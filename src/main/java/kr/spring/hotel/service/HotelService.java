package kr.spring.hotel.service;

import java.util.List;

import kr.spring.hotel.domain.HotelCommand;

public interface HotelService {

	public List<HotelCommand> selectList();
	public int selectListRow();
}
