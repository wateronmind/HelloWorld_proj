package kr.spring.flight.service;

import java.util.List;
import java.util.Map;

import kr.spring.flight.domain.FlightCommand;
import kr.spring.flight.domain.FlightSpotCommand;

public interface FlightService {
	// �װ���
	public List<FlightSpotCommand> selectFlightList(Map<String, Object> map);
	public int selectFlightCount(Map<String, Object> map);
	public void insertFlight(FlightCommand flight);
}
