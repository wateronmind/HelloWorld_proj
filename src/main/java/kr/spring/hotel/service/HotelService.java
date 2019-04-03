package kr.spring.hotel.service;

import java.util.List;

import kr.spring.hotel.domain.CvntlInfoCommand;
import kr.spring.hotel.domain.HotelCommand;

public interface HotelService {

	// ����
	public List<HotelCommand> selectHotelList();
	public int selectHotelListRow();
	
	// ��
	
	
	// ���ǽü�
	public List<CvntlInfoCommand> selectCvntlList();
}
