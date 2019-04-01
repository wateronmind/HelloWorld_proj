package kr.spring.member.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.spring.member.domain.MemberCommand;
import kr.spring.member.service.MemberService;
import kr.spring.util.LoginException;

@Controller
public class MemberController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private MemberService memberService;
	
	// 자바빈(커맨드 객체) 초기화
	@ModelAttribute("command")
	public MemberCommand initCommand() {
		return new MemberCommand();
	}
	
	// =============== 회원 가입 ===============// 
	// 회원등록 폼 호출
	
	// 회원가입 데이터 전송

	// =============== 회원 로그인 =============== //
	// 로그인 폼
	@RequestMapping(value="/member/login.do", method=RequestMethod.GET)
	public String formLogin() {
		return "memberLogin";
	}
	
	// 로그인 폼에 전송된 데이터 처리
	@RequestMapping(value="/member/login.do", method=RequestMethod.POST)
	public String submitLogin(@ModelAttribute("command") 
							  @Valid MemberCommand memberCommand, 
							  BindingResult result, 
							  HttpSession session) {
		if (log.isDebugEnabled()) {
			log.debug("<<memberCommand>> : " + memberCommand);
		}
		
		// 유효성 체크(id와 passwd 필드만 체크)
		if (result.hasFieldErrors("id") || result.hasFieldErrors("passwd")) {
			return formLogin();
		}
		
		// 로그인 체크(id, 비밀번호 일치 여부 체크)
		try {
			MemberCommand member = 
					memberService.selectMember(memberCommand.getUser_id());
			boolean check = false;
			
			if (member != null) {
				// 비밀번호 일치 여부 체크
				check = member.isCheckedPasswd(memberCommand.getUser_pw());
			}
			
			if (check) {
				// 인증 성공, 로그인 처리
				session.setAttribute("user_id", member.getUser_id());
				session.setAttribute("user_auth", member.getUser_auth());
				
				if (log.isDebugEnabled()) {
					log.debug("<<인증 성공>>");
					log.debug("<<user_id>> : " + member.getUser_id());
					log.debug("<<user_auth>> : " + member.getUser_auth());
				}
				
				return "redirect:/main/main.do";
				
			} else { 
				// 인증 실패
				throw new LoginException();
			}
		} catch(LoginException e) {
			// 인증 실패로 로그인폼 호출
			result.reject("invalidIdOrPassword"); // 메시지 처리
			
			if (log.isDebugEnabled()) {
				log.debug("<<인증 실패>>");
			}
			
			return formLogin(); // 로그인폼 호출
		}
		
	}
	
	// =============== 회원 로그아웃 =============== //
	
	// =============== 회원상세정보 =============== //
	
	// =============== 회원정보수정 =============== //
	// 수정폼
	
	// 수정폼에서 전송된 데이터 처리
	
	// ===============비밀번호 수정=============== //
	
	// 비밀번호 수정폼에서 전송된 데이터 처리
	
	// ============== 회원삭제(회원탈퇴) ============== //
	// 회원 삭제 폼
	
	// 회원 삭제 처리
	
}
