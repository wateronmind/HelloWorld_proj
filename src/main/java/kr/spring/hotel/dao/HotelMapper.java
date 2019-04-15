package kr.spring.hotel.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import kr.spring.hotel.domain.CvntlInfoCommand;
import kr.spring.hotel.domain.HotelCommand;
import kr.spring.hotel.domain.HotelVwCommand;

public interface HotelMapper {
 
	// 숙박
	public List<HotelCommand> selectHotelList();
	public int selectHotelListRow();
	@Select("SELECT * FROM STAYING_INFO WHERE ST_ID = #{st_id}")
	public HotelCommand getHotelInfo(int st_id);
	
	// 방
	public List<HotelVwCommand> selectRoomList(int st_id);
	public int selectRoomListRow(int st_id);
	@Select("SELECT * FROM STAYING_VW WHERE SR_ID = #{sr_id}")
	public HotelVwCommand getRoomInfo(int sr_id);
	public void HotelRsrv(Map<String,Object> map);
	
	// 편의시설
	public List<CvntlInfoCommand> selectCvntlList(List<String> list);
}
