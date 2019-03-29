package kr.spring.hotel.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.hotel.dao.HotelMapper;

@Service("hotelService")
public class HotelServiceImpl implements HotelService {
	
	@Resource
	private HotelMapper hotelMapper;
}
