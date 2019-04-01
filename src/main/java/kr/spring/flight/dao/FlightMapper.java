package kr.spring.flight.dao;

import java.util.List;
import java.util.Map;

import kr.spring.flight.domain.FlightCommand;
import kr.spring.flight.domain.FlightSpotCommand;

public interface FlightMapper {
	// Ç×°ø±Ç
	public List<FlightSpotCommand> selectFlightList(Map<String, Object> map);
	public int selectFlightCount(Map<String, Object> map);
	public void insertFlight(FlightCommand flight);
	public void insertFlightSpot(FlightSpotCommand flightSpot);
}
