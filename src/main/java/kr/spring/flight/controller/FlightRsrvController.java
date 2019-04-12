package kr.spring.flight.controller;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.spring.board.domain.BoardCommand;
import kr.spring.flight.domain.FlightCommand;
import kr.spring.flight.domain.FlightPayCommand;
import kr.spring.flight.domain.FlightRsrvCommand;
import kr.spring.flight.service.FlightService;

@Controller
public class FlightRsrvController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private FlightService flightService;
	
	//======게시판 글 등록=======//
	//등록 폼
	@RequestMapping(value="/flight/rsrvWrite.do",
	        			method=RequestMethod.GET)
	public String form(@RequestParam("fsi_idx") int fsi_idx, HttpSession session, Model model) {
		
		FlightCommand flightCommand = flightService.selectFlight(fsi_idx);
		
		String user_id = (String)session.getAttribute("user_id");
		
		FlightRsrvCommand command = new FlightRsrvCommand();
		command.setUser_id(user_id);
		
		model.addAttribute("command", command);
		model.addAttribute("flightCommand", flightCommand);
		
		return "flightRsrv";
	}
	//전송된 데이터 처리
	@RequestMapping(value="/flight/rsrvWrite.do",
					method=RequestMethod.POST)
	public String submit(@ModelAttribute("command")
						 FlightRsrvCommand flightRsrvCommand,
						 BindingResult result,
						 HttpServletRequest request,
						 RedirectAttributes redirect) {

		if(log.isDebugEnabled()) {
			log.debug("<<FlightRsrvCommand>> : " + flightRsrvCommand);
		}

		//데이터 유효성 체크
		/*if(result.hasErrors()) {
			return "flightRsrv";
		}*/

		int fr_id = flightService.getFr_id();
		if(log.isDebugEnabled()) {
			log.debug("<<fr_id>> : " + fr_id);
		}
		
		flightRsrvCommand.setFr_id(fr_id);
		
		//글쓰기
		flightService.insertFlightRsrv(flightRsrvCommand);

		//RedirectAttributes 객체는 리다이렉트 시점에 한 번만
		//사용되는 데이터를 전송.
		//브라우저에 데이터를 전송하지만 URI상에는 보이지 않는 
		//숨겨진 데이터의 형태로 전달
		redirect.addFlashAttribute("fr_id", fr_id);
		
		return "redirect:/flight/flightPay.do";
	}
	
	//=====결제 하기=====//
	//등록 폼
	@RequestMapping(value="/flight/flightPay.do",
						method=RequestMethod.GET)
	public String form(HttpSession session, Model model) {

		String user_id = (String)session.getAttribute("user_id");

		FlightPayCommand command = new FlightPayCommand();
		command.setUser_id(user_id);

		model.addAttribute("command", command);
		
		return "flightPay";
	}
	//전송된 데이터 처리
	@RequestMapping(value="/flight/flightPay.do",
			method=RequestMethod.POST)
	public String submit(@ModelAttribute("command")
						 FlightPayCommand flightPayCommand,
						 BindingResult result,
						 HttpServletRequest request,
						 RedirectAttributes redirect) {

		if(log.isDebugEnabled()) {
			log.debug("<<FlightPayCommand>> : " + flightPayCommand);
		}

		//데이터 유효성 체크
		/*if(result.hasErrors()) {
				return "flightRsrv";
			}*/

		//글쓰기
		flightService.insertFlightPay(flightPayCommand);

		//RedirectAttributes 객체는 리다이렉트 시점에 한 번만
		//사용되는 데이터를 전송.
		//브라우저에 데이터를 전송하지만 URI상에는 보이지 않는 
		//숨겨진 데이터의 형태로 전달
		redirect.addFlashAttribute("result", "success");

		return "redirect:/main/main.do";
	}
}
