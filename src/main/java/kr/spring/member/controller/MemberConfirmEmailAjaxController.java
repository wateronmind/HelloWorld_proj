package kr.spring.member.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.spring.member.domain.MemberCommand;
import kr.spring.member.service.MemberService;

@Controller
public class MemberConfirmEmailAjaxController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private MemberService memberService;
	
		
	@RequestMapping("/member/confirmEmail.do")
	@ResponseBody
	public Map<String, String> process(@RequestParam("user_email") String user_email) {
		
		if (log.isDebugEnabled()) {
			log.debug("<<user_email>> : " + user_email);
		}
		
		Map<String, String> map =
				new HashMap<String, String>();
		
		MemberCommand member = memberService.selectMemberByEmail(user_email);
		
		if (member != null) {
			// 아이디 중복
			map.put("result", "emailDuplicated");
		} else {
			// 아이디 미중복
			map.put("result", "emailNotFound");
		}
		
		return map;
	}
}
