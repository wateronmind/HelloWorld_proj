package kr.spring.member.controller;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.spring.member.domain.MemberCommand;
import kr.spring.member.email.Email;
import kr.spring.member.email.EmailSender;
import kr.spring.member.service.MemberService;

@Controller
public class FindPasswordAjaxController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private EmailSender emailSender;
	@Autowired
	private Email email;
	
	//자바빈 초기화
	@ModelAttribute("command")
	public MemberCommand initCommand() {
		return new MemberCommand();
	}
	
	@Resource
	private MemberService memberService;
	
	//============아이디/email로 비밀번호 찾기 =============//
	//폼 호출
	@RequestMapping(value="/member/findPasswordForm.do")
	public String formFindPassword() {
		return "memberFindPassword";
	}
	//아이디와 이메일이 DB와 일치하면 메일 발송
	
	//데이터 처리
	@RequestMapping("/member/findPassword.do")
	public String process(@ModelAttribute("command") 
						@Valid MemberCommand memberCommand, 
						BindingResult result) throws Exception{
		if (log.isDebugEnabled()) {
			log.debug("<<user_email>> : " + memberCommand.getUser_email());
			log.debug("<<user_id>> : " + memberCommand.getUser_id());
		}
		//유효성 체크
		if(result.hasFieldErrors("user_id") || result.hasFieldErrors("user_email")){
			return formFindPassword();
		}
		MemberCommand member = memberService.selectMember(memberCommand.getUser_id());
		
		//입력한 아이디로 가져올 때 null이 아니고 이메일과 입력한 이메일이 같을 때 
		if (member!=null && member.getUser_email().equals(memberCommand.getUser_email())) {
			//이메일 보냈다는 알림창 띄우기
			if (log.isDebugEnabled()) {
				log.debug("<<----mailing 진입----->>");
				
			}
			
			//기본비밀번호를 임시비밀번호로 변경
			String passwd = randomPassword(10);
			//member.setPasswd(cipherAES.encrypt(passwd));
			member.setUser_pw(passwd);
			
			//변경된 임시비밀번호를 DB에 저장
			memberService.updateRandomPassword(member);

			email.setContent("임시 비밀번호는 " + passwd +" 입니다.");
			email.setReceiver(member.getUser_email());
			email.setSubject(member.getUser_id()+" 님 비밀번호 찾기 메일입니다.");
			System.out.println(passwd + member.getUser_email() + member.getUser_id());
			emailSender.sendEmail(email);

			return "emailSendSuccess";
			
		} else {
			result.reject("invalidIdOrEmail");
			return formFindPassword();
		}
		
	}
	
	//비밀번호 보안을 위한 난수 발생 메소드
	public String randomPassword(int length){
		int index = 0;
		char[] charSet = new char[]{
				'0','1','2','3','4','5','6','7','8','9'
				,'A','B','C','D','E','F','G','H','I','J','K','L','M'
				,'N','O','P','Q','R','S','T','U','V','W','X','Y','Z'
				,'a','b','c','d','e','f','g','h','i','h','k','l','m'
				,'n','o','p','q','r','s','t','u','v','w','x','y','z'
		};

		StringBuffer sb = new StringBuffer();

		for(int i=0;i<length;i++){
			index = (int)(charSet.length * Math.random());
			sb.append(charSet[index]);
		}

		return sb.toString();
	}
	
}
