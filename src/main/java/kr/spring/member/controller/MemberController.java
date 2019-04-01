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
	
	// �ڹٺ�(Ŀ�ǵ� ��ü) �ʱ�ȭ
	@ModelAttribute("command")
	public MemberCommand initCommand() {
		return new MemberCommand();
	}
	
	// =============== ȸ�� ���� ===============// 
	// ȸ����� �� ȣ��
	@RequestMapping(value="/member/write.do",method=RequestMethod.GET)
	public String form() {
		return "memberWrite";
	}
	
	// ȸ������ ������ ����
	@RequestMapping(value="/member/write.do",method=RequestMethod.POST)
	public String submit(@ModelAttribute("command") 
						@Valid MemberCommand memberCommand,
						BindingResult result) {
		if (log.isDebugEnabled()) {
			log.debug("<<memberCommand>> : "+memberCommand);
		}
		//������ ������ �ٽ� �� ȣ��
		if (result.hasErrors()) {
			return form();
		}
		
		//ȸ�� ����
							//�ڹٺ��� �ѱ��.
		memberService.insert(memberCommand);
		
		return "redirect:/main/main.do";
	}
	
	// =============== ȸ�� �α��� =============== //
	// �α��� ��
	@RequestMapping(value="/member/login.do", method=RequestMethod.GET)
	public String formLogin() {
		return "memberLogin";
	}
	
	// �α��� ���� ���۵� ������ ó��
	@RequestMapping(value="/member/login.do", method=RequestMethod.POST)
	public String submitLogin(@ModelAttribute("command") 
							  @Valid MemberCommand memberCommand, 
							  BindingResult result, 
							  HttpSession session) {
		if (log.isDebugEnabled()) {
			log.debug("<<memberCommand>> : " + memberCommand);
		}
		
		// ��ȿ�� üũ(id�� passwd �ʵ常 üũ)
		if (result.hasFieldErrors("user_id") || result.hasFieldErrors("user_pw")) {
			return formLogin();
		}
		
		// �α��� üũ(id, ��й�ȣ ��ġ ���� üũ)
		try {
			MemberCommand member = 
					memberService.selectMember(memberCommand.getUser_id());
			boolean check = false;
			
			if (member != null) {
				// ��й�ȣ ��ġ ���� üũ
				check = member.isCheckedPasswd(memberCommand.getUser_pw());
			}
			
			if (check) {
				// ���� ����, �α��� ó��
				session.setAttribute("user_id", member.getUser_id());
				session.setAttribute("user_auth", member.getUser_auth());
				
				if (log.isDebugEnabled()) {
					log.debug("<<���� ����>>");
					log.debug("<<user_id>> : " + member.getUser_id());
					log.debug("<<user_auth>> : " + member.getUser_auth());
				}
				
				return "redirect:/main/main.do";
				
			} else { 
				// ���� ����
				throw new LoginException();
			}
		} catch(LoginException e) {
			// ���� ���з� �α����� ȣ��
			result.reject("invalidIdOrPassword"); // �޽��� ó��
			
			if (log.isDebugEnabled()) {
				log.debug("<<���� ����>>");
			}
			
			return formLogin(); // �α����� ȣ��
		}
		
	}
	
	// =============== ȸ�� �α׾ƿ� =============== //
	@RequestMapping("/member/logout.do")
	public String processLogout(HttpSession session) {
		//�α׾ƿ�
		session.invalidate();
		
		return "redirect:/main/main.do";
	}
	
	// =============== ȸ�������� =============== //
	@RequestMapping("/member/detail.do")
	public String process(HttpSession session,Model model) {
		String user_id=(String)session.getAttribute("user_id");
		
		MemberCommand member = memberService.selectMember(user_id);
		
		if (log.isDebugEnabled()) {
			log.debug("<<memberCommand>> : "+member);
		}
		
		//�̾Ƴ� �����ʹ� �𵨿� �־��ش�. �信�� �ڹٺ� �����ؼ� ��� �� �� �ֵ���.
		model.addAttribute("member",member);
		
		return "memberView";
	}
	
	
	// =============== ȸ���������� =============== //
	// ������
	
	// ���������� ���۵� ������ ó��
	
	// ===============��й�ȣ ����=============== //
	
	// ��й�ȣ ���������� ���۵� ������ ó��
	
	// ============== ȸ������(ȸ��Ż��) ============== //
	// ȸ�� ���� ��
	
	// ȸ�� ���� ó��
	
}
