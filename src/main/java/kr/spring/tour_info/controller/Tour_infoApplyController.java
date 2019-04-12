/*package kr.spring.tour_info.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.spring.tour_info.domain.Tour_infoApplyCommand;
import kr.spring.tour_info.service.Tour_infoService;
import kr.spring.util.PagingUtil;

@Controller
public class Tour_infoApplyController {
	private Logger log = Logger.getLogger(this.getClass());
	private int rowCount = 10;
	private int pageCount = 10;
	
	@Resource
	private Tour_infoService tour_infoService;
	//신청자 리스트 등록
	@RequestMapping(value="/tour_info/apply.do", method=RequestMethod.GET)
	public String form(HttpSession session, Model model) {
	  String id = (String)session.getAttribute("user_id");
	
	Tour_infoApplyCommand command = new Tour_infoApplyCommand();
	command.setUser_id(id);
	
	model.addAttribute("command",command);
	
	return "tour_infoApply";
	}
	//등록 데이터 전송
	@RequestMapping(value="/tour_info/apply.do",method=RequestMethod.POST)
	public String submit(@ModelAttribute("command")@Valid Tour_infoApplyCommand tour_infoApplyCommand, BindingResult result,
			                                           HttpServletRequest request,
			                                            RedirectAttributes redirect) {
		//로그 처리
		if(log.isDebugEnabled()) {
			log.debug("<<tour_infoApplyCommand>>: " + tour_infoApplyCommand);
		}
		//등록하기
		tour_infoService.insertApply(tour_infoApplyCommand);
		
		redirect.addFlashAttribute("result","success");
		
		return "redirect:/tour_info/list.do";
	}
	//신청자 목록 (가이드 내역에서 볼 수 있는 부분?)
	@RequestMapping("tour_info/applyList.do")
	public ModelAndView process(@RequestParam(value="pageNum",defaultValue="1") int currentPage,
			                    @RequestParam(value="keyfield",defaultValue="") String keyfield,
			                    @RequestParam(value="keyword",defaultValue="") String keyword) {
		Map<String,Object> map = new HashMap<String,Object>();//map 구조로 키필드와 키워드 넣어준다.
		
		//총 글의 개수 또는 검색된 글의 개수
		int count = tour_infoService.selectRowCount(map);
		
		if(log.isDebugEnabled()) {
			log.debug("<<count>> : " + count);
		}
		//페이징 처리 
		PagingUtil page = new PagingUtil(keyfield, keyword, currentPage, count, rowCount, pageCount, "list.do");
		List<Tour_infoApplyCommand> list = null;
		if(count > 0) {
			list = tour_infoService.selectList(map);
		}
		
		ModelAndView mav = new ModelAndView();//뷰처리
		mav.setViewName("boardList");//데피니션 설정 지정
		mav.addObject("count", count);
		mav.addObject("list", list);
		mav.addObject("pagingHtml", page.getPagingHtml());
		
		return mav;
	}
	
}
*/