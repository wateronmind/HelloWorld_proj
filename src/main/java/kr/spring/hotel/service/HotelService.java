package kr.spring.hotel.service;

import java.util.List;

import kr.spring.hotel.domain.CvntlInfoCommand;
import kr.spring.hotel.domain.HotelCommand;
import kr.spring.hotel.domain.HotelRoomCommand;

public interface HotelService {

	// ����
	public List<HotelCommand> selectHotelList();
	public int selectHotelListRow();
	public HotelCommand getHotelInfo(int st_id);
	 
	// ��
	public List<HotelRoomCommand> selectRoomList(int st_id);
	public int selectRoomListRow(int st_id);
	
	// ���ǽü�
	public List<CvntlInfoCommand> selectCvntlList();
}
