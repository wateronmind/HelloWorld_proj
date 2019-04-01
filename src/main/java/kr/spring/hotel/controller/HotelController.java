package kr.spring.hotel.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.hotel.domain.HotelCommand;
import kr.spring.hotel.domain.HotelRoomCommand;
import kr.spring.hotel.service.HotelService;

@Controller
public class HotelController {

	private Logger log = Logger.getLogger(this.getClass());
	private int rowCount = 10;
	private int pageCount = 10;

	@Resource
	private HotelService hotelService;

	@RequestMapping("/hotel/list.do")
	public ModelAndView hotelList() {

		if(log.isDebugEnabled()) {
			log.debug("<<hotel list test>>");
		}

		//HotelCommand hotel = hotelService.selectBoard(num);
		HotelCommand hotel = new HotelCommand();

		return new ModelAndView("hotelList","hotel",hotel);
	}

	@RequestMapping("/hotel/detail.do")
	public ModelAndView hotelDetail(@RequestParam("num") int num) {

		if(log.isDebugEnabled()) log.debug("<<hotel room detail num>> : " + num);

		//HotelCommand hotel = hotelService.selectBoard(num);
		HotelRoomCommand room = new HotelRoomCommand();

		return new ModelAndView("hotelDetail","room",room);
	}
}
