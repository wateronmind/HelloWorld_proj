package kr.spring.hotel.service;

import java.util.List;

import kr.spring.hotel.domain.CvntlInfoCommand;
import kr.spring.hotel.domain.HotelCommand;

public interface HotelService {

	// 숙박
	public List<HotelCommand> selectHotelList();
	public int selectHotelListRow();
	
	// 방
	
	
	// 편의시설
	public List<CvntlInfoCommand> selectCvntlList();
}
