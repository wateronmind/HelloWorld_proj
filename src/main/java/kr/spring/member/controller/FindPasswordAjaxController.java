package kr.spring.member.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.spring.member.domain.MemberCommand;
import kr.spring.member.service.MemberService;

@Controller
public class FindPasswordAjaxController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private MemberService memberService;
	
	//============아이디/email로 비밀번호 찾기 =============//
	//폼 호출
	@RequestMapping(value="/member/findPasswordForm.do",method=RequestMethod.GET)
	public String formFindPassword() {
		return "memberFindPassword";
	}
	//아이디와 이메일이 DB와 일치하면 메일 발송
	
	//데이터 처리
	@RequestMapping("/member/findPassword.do")
	@ResponseBody
	public Map<String, String> process(@RequestParam("user_email") String user_email,
										@RequestParam("user_id") String user_id) throws AddressException, MessagingException {
		if (log.isDebugEnabled()) {
			log.debug("<<user_email>> : " + user_email);
			log.debug("<<user_id>> : " + user_id);
		}
		Map<String, String> map = new HashMap<String, String>();
		
		MemberCommand member = memberService.selectMember(user_id);
		
		//입력한 아이디로 가져올 때 null이 아니고 이메일과 입력한 이메일이 같을 때 
		if (member!=null && user_email.equals(member.getUser_email())) {
			//이메일 보냈다는 알림창 띄우기
			if (log.isDebugEnabled()) {
				log.debug("<<----mailing 진입----->>");
			}
			map.put("result", "success");
			
			//가입한 이메일로 보내기
			MemberMailController mailController=new MemberMailController();
			mailController.mailSender(user_id,user_email);
			
			map.put("user_id", member.getUser_id());
			map.put("user_email",member.getUser_email());
			
		} else {
			if (log.isDebugEnabled()) {
				log.debug("<<----wrong ID/Email 진입----->>");
			}
			map.put("result", "wrong");
		}
		return map;
	}
	
}
