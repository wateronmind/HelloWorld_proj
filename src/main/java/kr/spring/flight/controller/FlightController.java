package kr.spring.flight.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.spring.flight.service.FlightService;

@Controller
public class FlightController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private FlightService flightService;
	
	// =============== 항공권 등록 =============== // 
	@RequestMapping(value="/admin/flightWrite.do", method=RequestMethod.GET)
	public String flightForm(HttpSession session, Model model) {

		return "flightWrite";
	}
}
