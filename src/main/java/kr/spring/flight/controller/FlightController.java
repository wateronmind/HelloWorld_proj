package kr.spring.flight.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.spring.flight.domain.FlightCommand;
import kr.spring.flight.domain.FlightSpotCommand;
import kr.spring.flight.service.FlightService;
import kr.spring.util.PagingUtil;

@Controller
public class FlightController {
	private Logger log = Logger.getLogger(this.getClass());
	private int rowCount = 10;
	private int pageCount = 10;
	
	@Resource
	private FlightService flightService;
	
	// �ڹ� �� �ʱ�ȭ
	@ModelAttribute("fCommand")
	public FlightCommand initCommand() {
		return new FlightCommand();
	}
	
	
	// =============== �װ��� ��� =============== // 
	@RequestMapping(value="/admin/flightWrite.do", method=RequestMethod.GET)
	public String flightForm(HttpSession session) {
		
		return "flightWrite";
	}
	
	@RequestMapping(value="/admin/flightWrite.do", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, String>  insertFlight(@ModelAttribute("fCommand")
							   @Valid FlightCommand flightCommand,
							   BindingResult result,
							   HttpSession session) {
		
		if (log.isDebugEnabled()) {
			log.debug("<<flightCommand>> : " + flightCommand);
		}
		Map<String, String> map = new HashMap<String, String>();
		
		// ��ȿ�� üũ
		if (result.hasErrors()) {
			map.put("result", "error");
			return map;
		}
		
		String user_id = (String)session.getAttribute("user_id");
		
		/*if (user_id == null) {
			// �α��� �ȵ�
			map.put("result", "logout");
		} else {
		}	*/	

		// �װ��� ���
		flightService.insertFlight(flightCommand);
		map.put("result", "success");
		return map;
	}
	
	// �װ��� �˻�
//	@RequestMapping(value="/admin/searchCompany.do", method=RequestMethod.POST)
//	@ResponseBody
//	public Map<Stirng, String> searchCompany(@ModelAttribute("command") 
//								@Valid FlightCommand flightCommand, 
//								)	{
//  }
	
	
	
	// =============== �װ��� ��ȸ =============== //
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
		
		// ��ϵ� �װ��� ����
		int flightCount = flightService.selectFlightCount(map);
		
		if (log.isDebugEnabled()) {
			log.debug("<<flightCount>> : " + flightCount);
		}
		
		PagingUtil page =
				new PagingUtil(null, keyword, 
						currentPage, flightCount, 
						rowCount, pageCount, "list.do");
		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());
		
		List<FlightSpotCommand> flightList = null;
		
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
