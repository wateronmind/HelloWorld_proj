package kr.spring.hotel.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import kr.spring.hotel.domain.CvntlInfoCommand;
import kr.spring.hotel.domain.HotelCommand;
import kr.spring.hotel.domain.HotelRoomCommand;

public interface HotelMapper {
 
	// 숙박
	public List<HotelCommand> selectHotelList();
	public int selectHotelListRow();
	@Select("SELECT * FROM STAYING_INFO WHERE ST_ID = #{st_id}")
	public HotelCommand getHotelInfo(int st_id);
	
	// 방
	public List<HotelRoomCommand> selectRoomList(int st_id);
	public int selectRoomListRow(int st_id);
	@Select("SELECT * FROM STAYING_ROOM WHERE SR_ID = #{sr_id}")
	public HotelRoomCommand getRoomInfo(int sr_id);
	
	// 편의시설
	public List<CvntlInfoCommand> selectCvntlList(List<String> list);
}
