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
public class FindIdAjaxController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private MemberService memberService;
	
	//===========이메일로 아이디 찾기 ============//
	//폼 호출
	@RequestMapping("/member/findIdForm.do")
	public String formFindId() {
		return "memberFindId";
	}
	
	@RequestMapping("/member/findId.do")
	@ResponseBody
	public Map<String, String> process(@RequestParam("user_email") String user_email) {
		if (log.isDebugEnabled()) {
			log.debug("<<user_email>> : " + user_email);
		}
		Map<String, String> map = new HashMap<String, String>();
		
		MemberCommand member = memberService.selectMemberByEmail(user_email);
		//이메일이 null이 아니면 해당 이메일로 회원 정보를 가져온다.
		if (member != null) {
			// 이메일 로 정보를 가져왔을 때.
			//map.put("result", "emailNotNull");
			map.put("user_id", member.getUser_id());
		} else {
			// 아이디 미중복
			map.put("result", "emailNull");
		}
		return map;
	}
	
	@RequestMapping("/member/foundId.do")
	@ResponseBody
	public Map<String, String> processed(@RequestParam("user_email") String user_email) {
		if (log.isDebugEnabled()) {
			log.debug("<<user_email>> : " + user_email);
		}
		Map<String, String> map = new HashMap<String, String>();
		
		MemberCommand member = memberService.selectMemberByEmail(user_email);
		//이메일이 null이 아니면 해당 이메일로 회원 정보를 가져온다.
		if (member != null) {
			// 아이디 중복
			map.put("user_id", member.getUser_id());
		} else {
			// 아이디 미중복
			map.put("result", "emailNull");
		}
		return map;
	}
}
