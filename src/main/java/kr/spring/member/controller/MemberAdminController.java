package kr.spring.member.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.board.domain.BoardCommand;
import kr.spring.member.domain.MemberCommand;
import kr.spring.member.service.MemberService;
import kr.spring.util.PagingUtil;

@Controller
public class MemberAdminController {
	private Logger log = Logger.getLogger(this.getClass());
	private int rowCount = 10;
	private int pageCount = 10;
	
	@Resource
	private MemberService memberService;
	
	// 자바빈(커맨드 객체) 초기화
	@ModelAttribute("command")
	public MemberCommand initCommand() {
		return new MemberCommand();
	}
	
	// =============== 회원목록 관리 ===============//
	@RequestMapping("/member/admin_list.do")
	public ModelAndView process(
			@RequestParam(value="pageNum", defaultValue="1")int currentPage,
			@RequestParam(value="keyfield", defaultValue="")String keyfield, 
			@RequestParam(value="keyword", defaultValue="")String keyword) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("keyfield", keyfield);
		map.put("keyword", keyword);
		
		// 총 글의 갯수 또는 검색된 글의 갯수
		int count = memberService.selectRowCount(map);
		
		if (log.isDebugEnabled()) {
			log.debug("<<count>> : " + count);
		}
		
		PagingUtil page = new PagingUtil(keyfield, keyword, 
				currentPage, count, rowCount, pageCount, "admin_list.do");
		
		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());
		
		List<MemberCommand> list = null;
		if(count > 0) {
			list = memberService.selectList(map);
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin_memberList");
		mav.addObject("count", count);
		mav.addObject("list", list);
		mav.addObject("pagingHtml", page.getPagingHtml());
		
		return mav;
	}
	
	//============회원 목록===========/
	@RequestMapping("/member/memberList.do")
	public ModelAndView processMember(
			@RequestParam(value="pageNum", defaultValue="1")int currentPage,
			@RequestParam(value="keyfield", defaultValue="")String keyfield,
			@RequestParam(value="keyword", defaultValue="")String keyword
			) {
		Map<String,Object> map = new HashMap<String, Object>();
		
		map.put("keyfield", keyfield);
		map.put("keyword", keyword);
		
		// 총 회원수 또는 검색된 회원의 갯수
		int count = memberService.selectRowCount(map);
		
		if(log.isDebugEnabled()) {
			log.debug("<<count>> : " + count);
		}
		
		PagingUtil page = new PagingUtil(keyfield, keyword,currentPage, count,rowCount, pageCount, "memberList.do");
		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());
		
		List<MemberCommand> list = null;
		if (count > 0) {
			list = memberService.selectList(map);
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("memberList");
		mav.addObject("count", count);
		mav.addObject("memberList", list);
		mav.addObject("pagingHtml", page.getPagingHtml());
		
		return mav;
	}
	//================회원 상세 보기============//
	@RequestMapping("/member/adminMemberDetail.do")
	public ModelAndView process(@RequestParam("user_id") String user_id) {
		if (log.isDebugEnabled()) {
			log.debug("<<user_id>> : " + user_id);
		}
		MemberCommand member = memberService.selectMember(user_id);
							    // view name   속성명     속성값
		return new ModelAndView("memberView", "member", member);
	}
	
	//================가이드 목록================//
	@RequestMapping("/member/guideList.do")
	public ModelAndView processGuide(
			@RequestParam(value="pageNum", defaultValue="1")int currentPage,
			@RequestParam(value="keyfield", defaultValue="")String keyfield,
			@RequestParam(value="keyword", defaultValue="")String keyword) {
		Map<String,Object> map = new HashMap<String, Object>();
		
		map.put("keyfield", keyfield);
		map.put("keyword", keyword);
		
		// 회원수 혹은 검색된 회원 수
		int count = memberService.selectGuideRowCount(map);
		
		if(log.isDebugEnabled()) {
			log.debug("<<count>> : " + count);
		}
		
		PagingUtil page = new PagingUtil(keyfield, keyword,currentPage, count,rowCount, pageCount, "guideList.do");
		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());
		
		List<MemberCommand> list = null;
		if (count > 0) {
			list = memberService.selectGuideList(map);
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("guideList");
		mav.addObject("count", count);
		mav.addObject("guideList", list);
		mav.addObject("pagingHtml", page.getPagingHtml());
		
		return mav;
	}
	
	//=========가이드 수락========//
	@RequestMapping("/member/confirmGuide.do")
	public String confirmGuide(@RequestParam("user_id") String user_id) {
		if (log.isDebugEnabled()) {
			log.debug("<<user_id>> : " + user_id);
		}
		memberService.confirmGuide(user_id);
		
		
		//DB의 auth 를 수정한 경우
		//해당 아이디로 로그인한 계정의 세션에서 auth값이 변경된다면 auth를 체크해서 session에 다시 값을 넣어 줘야 한다.
		
		//DB의 값을 변경하고 session을 다시 셋팅하게 한다.
		
		
		return "redirect:/member/guideList.do";
	}
	//=========가이드 거부========//
	@RequestMapping("/member/refuseGuide.do")
	public String revokeGuide(@RequestParam("user_id") String user_id,
							HttpSession session) {
		if (log.isDebugEnabled()) {
			log.debug("<<user_id>> : " + user_id);
		}
		memberService.refuseGuide(user_id);
		
		return "redirect:/member/guideList.do";
	}
	
	
}
