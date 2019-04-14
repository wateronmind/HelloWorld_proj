package kr.spring.hotel.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.hotel.domain.HotelCommand;
import kr.spring.hotel.domain.HotelRoomCommand;
import kr.spring.hotel.domain.HotelRsrvCommand;
import kr.spring.hotel.service.HotelService;

@Controller
public class HotelController {
 
	private Logger log = Logger.getLogger(this.getClass());

	@Resource
	private HotelService hotelService;

	@RequestMapping("/hotel/hotelList.do")
	public ModelAndView hotelList() {

		if(log.isDebugEnabled()) log.debug("<<hotel list>>");
		
		int cnt = hotelService.selectHotelListRow();
		
		List<HotelCommand> hotelList = null;
		if (cnt > 0) {
			hotelList = hotelService.selectHotelList();
		}
		
		for(HotelCommand hotel : hotelList) {
			hotel.setSt_cvntl_list(hotelService.selectCvntlList(hotel.getSt_cvntl_id()));
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("hotelList");
		mav.addObject("cnt", cnt);
		mav.addObject("hotelList", hotelList);

		return mav;
	}

	@RequestMapping("/hotel/roomList.do")
	public ModelAndView roomList(@RequestParam("id") int id) {

		if(log.isDebugEnabled()) log.debug("<<hotel room detail id>> : " + id);
		
		int cnt = hotelService.selectHotelListRow();
		
		List<HotelRoomCommand> roomList = null;
		if (cnt > 0) {
			roomList = hotelService.selectRoomList(id);
		}
		
		HotelCommand hotel = hotelService.getHotelInfo(id);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("roomList");
		mav.addObject("cnt", cnt);
		mav.addObject("hotel", hotel);
		mav.addObject("roomList", roomList);

		return mav;
	}

	@RequestMapping("/hotel/roomDetail.do")
	public ModelAndView roomDetail(@RequestParam("id") int id) {

		if(log.isDebugEnabled()) log.debug("<<hotel room detail id>> : " + id);
		
		HotelRoomCommand room = hotelService.getRoomInfo(id);
		HotelCommand hotel = hotelService.getHotelInfo(room.getSt_id());
		hotel.setSt_cvntl_list(hotelService.selectCvntlList(hotel.getSt_cvntl_id()));
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("roomDetail");
		mav.addObject("hotel", hotel);
		mav.addObject("room", room);

		return mav;
	}

	@RequestMapping("/hotel/hotelRsrv.do")
	public ModelAndView hotelRsrv(@ModelAttribute("command") @Valid HotelRsrvCommand hotelRsrvCommand, HttpSession session) {

		hotelRsrvCommand.setUser_id((String)session.getAttribute("user_id"));
		
		if(log.isDebugEnabled()) {
			log.debug("<<hotelRsrvCommand>> : " + hotelRsrvCommand);
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("hotelRsrv");
		mav.addObject("hotelRsrvCommand", hotelRsrvCommand);

		return mav;
	}
}
