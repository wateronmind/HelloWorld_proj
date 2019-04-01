package kr.spring.tour_info.controller;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.spring.tour.service.Tour_infoService;
import kr.spring.tour_info.domain.Tour_infoCommand;

@Controller
public class Tour_infoController {
	private Logger log = Logger.getLogger(this.getClass());
	private int rowCount = 10;
	private int pageCount = 10;
	
	@Resource
	private Tour_infoService tour_infoService;

	//투어 게시판 글 등록 
	
	@RequestMapping(value="/tour_info/write.do",method=RequestMethod.GET)
	public String form() {
		return "tour_infoWrite";
	}
    // 등록 데이터 전송
	@RequestMapping(value="tour_info/write.do",method=RequestMethod.POST)
	public String submit(@ModelAttribute("command")@Valid Tour_infoCommand tour_infoCommand, BindingResult result,
			                                           HttpServletRequest request,
			                                            RedirectAttributes redirect) {
		//로그 처리
		if(log.isDebugEnabled()) {
			log.debug("<<memberCommand>>: " + tour_infoCommand);
		}
		
		//데이터 유효성 체크
		if(result.hasErrors()) {//에러 발생시 폼으로
			return form();
		}
		//등록하기
		tour_infoService.insert(tour_infoCommand);
		
		return "redirect:/tour_info/list.do";
	}
}
