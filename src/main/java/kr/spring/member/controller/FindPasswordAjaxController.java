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
	
	//============���̵�/email�� ��й�ȣ ã�� =============//
	//�� ȣ��
	@RequestMapping(value="/member/findPasswordForm.do",method=RequestMethod.GET)
	public String formFindPassword() {
		return "memberFindPassword";
	}
	//���̵�� �̸����� DB�� ��ġ�ϸ� ���� �߼�
	
	//������ ó��
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
		
		//�Է��� ���̵�� ������ �� null�� �ƴϰ� �̸��ϰ� �Է��� �̸����� ���� �� 
		if (member!=null && user_email.equals(member.getUser_email())) {
			//�̸��� ���´ٴ� �˸�â ����
			if (log.isDebugEnabled()) {
				log.debug("<<----mailing ����----->>");
			}
			map.put("result", "success");
			
			//������ �̸��Ϸ� ������
			MemberMailController mailController=new MemberMailController();
			mailController.mailSender(user_id,user_email);
			
			map.put("user_id", member.getUser_id());
			map.put("user_email",member.getUser_email());
			
		} else {
			if (log.isDebugEnabled()) {
				log.debug("<<----wrong ID/Email ����----->>");
			}
			map.put("result", "wrong");
		}
		return map;
	}
	
}
