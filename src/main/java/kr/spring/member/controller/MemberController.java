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
	@RequestMapping(value="/member/write.do",method=RequestMethod.GET)
	public String form() {
		return "memberWrite";
	}
	
	// 회원가입 데이터 전송
	@RequestMapping(value="/member/write.do",method=RequestMethod.POST)
	public String submit(@ModelAttribute("command") 
						@Valid MemberCommand memberCommand,
						BindingResult result) {
		if (log.isDebugEnabled()) {
			log.debug("<<memberCommand>> : "+memberCommand);
		}
		//에러가 있으면 다시 폼 호출
		if (result.hasErrors()) {
			return form();
		}
		
		//회원 가입
							//자바빈을 넘긴다.
		memberService.insert(memberCommand);
		
		return "redirect:/main/main.do";
	}
	
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
		if (result.hasFieldErrors("user_id") || result.hasFieldErrors("user_pw")) {
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
	@RequestMapping("/member/logout.do")
	public String processLogout(HttpSession session) {
		//로그아웃
		session.invalidate();
		
		return "redirect:/main/main.do";
	}
	
	// =============== 회원상세정보 =============== //
	@RequestMapping("/member/detail.do")
	public String process(HttpSession session,Model model) {
		String user_id=(String)session.getAttribute("user_id");
		
		MemberCommand member = memberService.selectMember(user_id);
		
		if (log.isDebugEnabled()) {
			log.debug("<<memberCommand>> : "+member);
		}
		
		//뽑아낸 데이터는 모델에 넣어준다. 뷰에서 자바빈에 접근해서 사용 할 수 있도록.
		model.addAttribute("member",member);
		
		return "memberView";
	}
	//=========가이드 신청========//
	@RequestMapping("/member/applyGuide.do")
	public String submitGuide(HttpSession session) {
		String user_id=(String)session.getAttribute("user_id");
		memberService.applyGuide(user_id);
		
		return "redirect:/member/detail.do";
	}
	//=========가이드 취소========//
	@RequestMapping("/member/cancelGuide.do")
	public String revokeGuide(HttpSession session) {
		String user_id=(String)session.getAttribute("user_id");
		memberService.cancelGuide(user_id);
		
		return "redirect:/member/detail.do";
	}
	
	
	// =============== 회원정보수정 =============== //
	// 수정폼
	@RequestMapping(value="/member/update.do",method=RequestMethod.GET)
	public String formUpdate(HttpSession session,Model model) {
		String user_id=(String)session.getAttribute("user_id");
		
		MemberCommand member=memberService.selectMember(user_id);
		
		model.addAttribute("command",member);
		
		return "memberModify";
	}
	
	// 수정폼에서 전송된 데이터 처리
	@RequestMapping(value="/member/update.do",method=RequestMethod.POST)
	public String submitUpdate(@ModelAttribute("command") 
								@Valid MemberCommand memberCommand,
								BindingResult result) {
		if (log.isDebugEnabled()) {
			log.debug("<<memberCommand>> : "+memberCommand);
		}
		if (result.hasErrors()) {
			return "memberModify";
		}
		//회원정보 수정
		memberService.update(memberCommand);
		
		return "redirect:/member/detail.do";
	}
	
	// ===============비밀번호 수정=============== //
	//수정 폼
	@RequestMapping(value="/member/changePassword.do",method=RequestMethod.GET)
	public String formChangePassword(HttpSession session,Model model) {
		String id=(String)session.getAttribute("user_id");
		
		MemberCommand member=memberService.selectMember(id);
		
		model.addAttribute("command",member);
		
		return "memberChangePassword";
	}
	
	// 비밀번호 수정폼에서 전송된 데이터 처리
	@RequestMapping(value="/member/changePassword.do",method=RequestMethod.POST)
	public String submitChangePassword(@ModelAttribute("command")
										@Valid MemberCommand memberCommand,
										BindingResult result) {
		if (log.isDebugEnabled()) {
			log.debug("<<memberCommand>> : "+memberCommand);
		}
		if (result.hasFieldErrors("user_id")||
			result.hasFieldErrors("old_pw")||
			result.hasFieldErrors("user_pw")) {
			return "memberChangePassword";
		}
		//현재 비밀번호 (old_passwd) 일치 여부 체크
		MemberCommand member=memberService.selectMember(memberCommand.getUser_id());
		//사용자가 입력한 비밀번호와 DB의 비밀번호 일치 여부
		if (!member.getUser_pw().equals(memberCommand.getOld_passwd())) {
			result.rejectValue("old_pw", "invalidPassword");
			return "memberChangePassword";
		}
		//비밀번호 수정
		memberService.updatePassword(memberCommand);
		
		return "redirect:/member/detail.do";
	}
	
	
	// ============== 회원삭제(회원탈퇴) ============== //
	// 회원 삭제 폼
	@RequestMapping(value="/member/delete.do",method=RequestMethod.GET)
	public String formDelete(HttpSession session,Model model) {
		String user_id=(String)session.getAttribute("user_id");
		MemberCommand member=new MemberCommand();
		member.setUser_id(user_id);
		
		model.addAttribute("command",member);
		
		return "memberDelete";
	}
	// 회원 삭제 처리
	@RequestMapping(value="member/delete.do",method=RequestMethod.POST)
	public String submitDelete(@ModelAttribute("command")
								@Valid MemberCommand memberCommand,
								BindingResult result,
								HttpSession session) {
		
		if (log.isDebugEnabled()) {
			log.debug("<<memberCommand>> : "+memberCommand);
		}
		
		//id,passwd 필드의 에러 체크
		if (result.hasFieldErrors("user_id")||result.hasFieldErrors("user_pw")) {
			return "memberDelete";
		}
		
		//비밀번호 일치 여부 체크
		try {
			MemberCommand member=memberService.selectMember(memberCommand.getUser_id());
			boolean check=false;
			
			if (member!=null) {
				//비밀번호 일치여부 체크
				check=member.isCheckedPasswd(memberCommand.getUser_pw());
			}
			if (check) {
				//인증성공 정보 삭제
				memberService.delete(memberCommand.getUser_id());
				
				//로그 아웃
				session.invalidate();
				return "redirect:/main/main.do";
				
			}else {
				throw new LoginException();
			}
			
		} catch (LoginException e) {
			result.rejectValue("pw", "invalidPassword");
			//회원 탈퇴 폼 호출"
			return "memberDelete";
		}
	}
}
