package kr.spring.hotel.service;

import java.util.List;
import java.util.Map;

import kr.spring.hotel.domain.CvntlInfoCommand;
import kr.spring.hotel.domain.HotelCommand;
import kr.spring.hotel.domain.HotelVwCommand;

public interface HotelService {

	// 숙박
	public List<HotelCommand> selectHotelList();
	public int selectHotelListRow();
	public HotelCommand getHotelInfo(int st_id);
	 
	// 방
	public List<HotelVwCommand> selectRoomList(int st_id);
	public int selectRoomListRow(int st_id);
	public HotelVwCommand getRoomInfo(int sr_id);
	public void HotelRsrv(Map<String,Object> map);
	
	// 편의시설
	public List<CvntlInfoCommand> selectCvntlList(List<String> list);
}
