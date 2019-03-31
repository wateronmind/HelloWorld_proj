package kr.spring.flight.service;

import java.util.List;
import java.util.Map;

import kr.spring.flight.domain.FlightCommand;

public interface FlightService {
	// Ç×°ø±Ç
	public List<FlightCommand> selectFlightList(Map<String, Object> map);
	public int selectFlightCount(Map<String, Object> map);
}
