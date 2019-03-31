package kr.spring.flight.dao;

import java.util.List;
import java.util.Map;

import kr.spring.flight.domain.FlightCommand;

public interface FlightMapper {
	// Ç×°ø±Ç
	public List<FlightCommand> selectFlightList(Map<String, Object> map);
	public int selectFlightCount(Map<String, Object> map);
}
