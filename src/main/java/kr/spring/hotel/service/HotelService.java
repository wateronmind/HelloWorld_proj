package kr.spring.hotel.service;

import java.util.List;

import kr.spring.hotel.domain.CvntlInfoCommand;
import kr.spring.hotel.domain.HotelCommand;
import kr.spring.hotel.domain.HotelRoomCommand;

public interface HotelService {

	// 숙박
	public List<HotelCommand> selectHotelList();
	public int selectHotelListRow();
	public HotelCommand getHotelInfo(int st_id);
	 
	// 방
	public List<HotelRoomCommand> selectRoomList(int st_id);
	public int selectRoomListRow(int st_id);
	
	// 편의시설
	public List<CvntlInfoCommand> selectCvntlList();
}
