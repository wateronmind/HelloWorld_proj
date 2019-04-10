package kr.spring.hotel.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import kr.spring.hotel.domain.CvntlInfoCommand;
import kr.spring.hotel.domain.HotelCommand;
import kr.spring.hotel.domain.HotelRoomCommand;

public interface HotelMapper {
 
	// ����
	public List<HotelCommand> selectHotelList();
	public int selectHotelListRow();
	@Select("SELECT * FROM STAYING_INFO WHERE ST_ID = #{st_id}")
	public HotelCommand getHotelInfo(int st_id);
	
	// ��
	public List<HotelRoomCommand> selectRoomList(int st_id);
	public int selectRoomListRow(int st_id);
	
	// ���ǽü�
	@Select("SELECT * FROM CVNTL_INFO ORDER BY CVNTL_ID")
	public List<CvntlInfoCommand> selectCvntlList();
}
