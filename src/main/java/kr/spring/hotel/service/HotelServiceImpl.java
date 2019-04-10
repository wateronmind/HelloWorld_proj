package kr.spring.hotel.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.hotel.dao.HotelMapper;
import kr.spring.hotel.domain.CvntlInfoCommand;
import kr.spring.hotel.domain.HotelCommand;
import kr.spring.hotel.domain.HotelRoomCommand;

@Service("hotelService")
public class HotelServiceImpl implements HotelService {
	
	// 숙박
	@Resource
	private HotelMapper hotelMapper;
 
	@Override
	public List<HotelCommand> selectHotelList() {
		return hotelMapper.selectHotelList();
	}

	@Override
	public int selectHotelListRow() {
		return hotelMapper.selectHotelListRow();
	}

	@Override
	public HotelCommand getHotelInfo(int st_id) {
		return hotelMapper.getHotelInfo(st_id);
	}

	// 방
	@Override
	public List<HotelRoomCommand> selectRoomList(int st_id) {
		return hotelMapper.selectRoomList(st_id);
	}

	@Override
	public int selectRoomListRow(int st_id) {
		return hotelMapper.selectRoomListRow(st_id);
	}

	@Override
	public HotelRoomCommand getRoomInfo(int sr_id) {
		return hotelMapper.getRoomInfo(sr_id);
	}

	// 편의시설
	@Override
	public List<CvntlInfoCommand> selectCvntlList(List<String> list) {
		return hotelMapper.selectCvntlList(list);
	}
}
