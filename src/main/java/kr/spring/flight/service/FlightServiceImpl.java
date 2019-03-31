package kr.spring.flight.service;

import java.util.List;
import java.util.Map;

import kr.spring.flight.dao.FlightMapper;
import kr.spring.flight.domain.FlightCommand;

public class FlightServiceImpl implements FlightService {
	
	private FlightMapper flightMapper;

	@Override
	public List<FlightCommand> selectFlightList(Map<String, Object> map) {
		return flightMapper.selectFlightList(map);
	}
	
	@Override
	public int selectFlightCount(Map<String, Object> map) {
		return flightMapper.selectFlightCount(map);
	}

	
}
