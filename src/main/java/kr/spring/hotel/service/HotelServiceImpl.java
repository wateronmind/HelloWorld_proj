package kr.spring.hotel.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.hotel.dao.HotelMapper;
import kr.spring.hotel.domain.CvntlInfoCommand;
import kr.spring.hotel.domain.HotelCommand;

@Service("hotelService")
public class HotelServiceImpl implements HotelService {
	
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
	public List<CvntlInfoCommand> selectCvntlList() {
		return hotelMapper.selectCvntlList();
	}
}
