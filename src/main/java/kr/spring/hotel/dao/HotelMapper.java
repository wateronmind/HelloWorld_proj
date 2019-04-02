package kr.spring.hotel.dao;

import java.util.List;

import kr.spring.hotel.domain.HotelCommand;

public interface HotelMapper {

	public List<HotelCommand> selectList();
	public int selectListRow();
}
