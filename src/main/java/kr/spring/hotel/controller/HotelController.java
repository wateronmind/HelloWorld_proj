package kr.spring.hotel.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import kr.spring.hotel.domain.HotelRsrvCommand;
import kr.spring.hotel.domain.HotelVwCommand;
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
		
		List<HotelVwCommand> roomList = null;
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
		
		HotelVwCommand room = hotelService.getRoomInfo(id);
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
		HotelVwCommand hotelVwCommand = hotelService.getRoomInfo(hotelRsrvCommand.getSr_id());
		hotelVwCommand.setSt_cvntl_list(hotelService.selectCvntlList(hotelVwCommand.getSt_cvntl_id()));
		
		if(log.isDebugEnabled()) {
			log.debug("<<hotelRsrvCommand>> : " + hotelRsrvCommand);
			log.debug("<<hotelVwCommand>> : " + hotelVwCommand);
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("hotelRsrv");
		mav.addObject("rsrv", hotelRsrvCommand);
		mav.addObject("hotel", hotelVwCommand);

		return mav;
	}

	@RequestMapping("/hotel/hotelResult.do")
	public ModelAndView hotelResult(@ModelAttribute("command") @Valid HotelRsrvCommand hotelRsrvCommand,
			@RequestParam("cp_num") int cp_num, @RequestParam("cp_pin_num") int cp_pin_num,
			@RequestParam("cp_year_month") String cp_year_month) {

		HotelVwCommand hotelVwCommand = hotelService.getRoomInfo(hotelRsrvCommand.getSr_id());
		hotelVwCommand.setSt_cvntl_list(hotelService.selectCvntlList(hotelVwCommand.getSt_cvntl_id()));
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("p_sr_id", hotelVwCommand.getSr_id());
		map.put("p_user_id", hotelRsrvCommand.getUser_id());
		map.put("p_total_pc", hotelRsrvCommand.getSrl_total_pc());
		map.put("p_check_in_dt", hotelVwCommand.getSt_check_in());
		map.put("p_check_out_dt", hotelVwCommand.getSt_check_out());
		map.put("p_srl_nm", hotelRsrvCommand.getSrl_nm());
		map.put("p_srl_email", hotelRsrvCommand.getSrl_email());
		map.put("p_srl_phone", hotelRsrvCommand.getSrl_phone());
		map.put("p_srl_adult_pp", hotelRsrvCommand.getSrl_adult_pp());
		map.put("p_srl_kid_pp", hotelRsrvCommand.getSrl_kid_pp());
		map.put("p_num", cp_num);
		map.put("p_pin_num", cp_pin_num);
		
		String cp_ym[] = cp_year_month.split("/");
		
		map.put("p_year", Integer.parseInt(cp_ym[1]));
		map.put("p_month", Integer.parseInt(cp_ym[0]));
		
		if(log.isDebugEnabled()) {
			log.debug("<<hotelRsrvCommand>> : " + hotelRsrvCommand);
			log.debug("<<hotelVwCommand>> : " + hotelVwCommand);
			log.debug("<<map>> : " + map );
		}
		
		hotelService.hotelRsrv(map);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("hotelResult");
		mav.addObject("rsrv", hotelRsrvCommand);
		mav.addObject("hotel", hotelVwCommand);

		return mav;
	}
}
