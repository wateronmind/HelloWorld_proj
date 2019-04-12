package kr.spring.travel.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.flight.domain.FlightCommand;
import kr.spring.flight.service.FlightService;
import kr.spring.util.PagingUtil;

@Controller
public class TravelController {
	private Logger log = Logger.getLogger(this.getClass());
	private int rowCount = 10;
	private int pageCount = 10;
	
	@Resource
	private FlightService flightService;
	
	// =============== 항공권 등록 =============== // 
	@RequestMapping(value="/admin/flightWrite.do", method=RequestMethod.GET)
	public String flightForm(HttpSession session) {
		return "flightWrite";
	}
	
	// =============== 항공권 조회 =============== //
	@RequestMapping(value="/travel/list.do")
	public ModelAndView travelList(
			@RequestParam(value="pageNum", defaultValue="1")
			int currentPage,
			@RequestParam(value="keyword", defaultValue="")
			String keyword
			) {
		
		Map<String, Object> map =
				new HashMap<String, Object>();
		
		map.put("keyword", keyword);
		
		// 등록된 항공권 갯수
		int flightCount = flightService.selectFlightRowCount(map);
		
		if (log.isDebugEnabled()) {
			log.debug("<<flightCount>> : " + flightCount);
		}
		
		PagingUtil page =
				new PagingUtil(null, keyword, 
						currentPage, flightCount, 
						rowCount, pageCount, "list.do");
		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());
		
		List<FlightCommand> flightList = null;
		
		if (flightCount > 0) {
			flightList = flightService.selectFlightList(map);
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("flightList");
		mav.addObject("fCount", flightCount);
		mav.addObject("fList", flightList);
		mav.addObject("pagingHtml", page.getPagingHtml());
		
		return mav;
		
	}
}
