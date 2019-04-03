package kr.spring.hotel.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import kr.spring.hotel.domain.CvntlInfoCommand;
import kr.spring.hotel.domain.HotelCommand;

public interface HotelMapper {

	// 숙박
	public List<HotelCommand> selectHotelList();
	public int selectHotelListRow();
	
	// 방
	
	
	// 편의시설
	@Select("SELECT * FROM CVNTL_INFO ORDER BY CVNTL_ID")
	public List<CvntlInfoCommand> selectCvntlList();
}
