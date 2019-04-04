package kr.spring.flight.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.flight.dao.FlightMapper;
import kr.spring.flight.domain.FlightCommand;

@Service("flightService")
public class FlightServiceImpl implements FlightService {
	
	@Resource
	private FlightMapper flightMapper;

	@Override
	public List<FlightCommand> selectFlightList(Map<String, Object> map) {
		// return flightMapper.selectFlightList(map);
		return null;
	}
	
	@Override
	public int selectFlightCount(Map<String, Object> map) {
		return flightMapper.selectFlightCount(map);
	}

	@Override
	public void insertFlight(FlightCommand flight) {
		System.out.println("~~~~~~~~~~~~~~~~");
		flightMapper.insertFlight(flight);	
	}
	
}
