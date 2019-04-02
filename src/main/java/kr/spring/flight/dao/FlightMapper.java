package kr.spring.flight.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;

import kr.spring.flight.domain.FlightCommand;
import kr.spring.flight.domain.FlightSpotCommand;

public interface FlightMapper {
	// Ç×°ø±Ç
	public List<FlightSpotCommand> selectFlightList(Map<String, Object> map);
	public int selectFlightCount(Map<String, Object> map);
	
	@Insert("INSERT INTO flight_info (fi_id, fi_nm, fi_logo) VALUES "
			+ "( (SELECT NVL(MAX(fi_id), 0) + 1 from flight_info ), #{fi_nm}, #{fi_logo}) ")
	public void insertFlight(FlightCommand flight);
	
	@Insert("INSERT INTO flight_spot_info ( (SELECT NVL(MAX(fsi_idx), 0) + 1 FROM flight_spot_info), "
			+ "(SELECT NVL(MAX(fi_id), 0) FROM flight_info), "
			+ "fsi_start_place, fsi_arrive_place, fsi_pass1_place, "
			+ "fsi_pass2_place, fsi_start_dt, fsi_arrive_dt, fsi_pass1_dt, "
			+ "fsi_pass2_dt, sysdate, 0, "
			+ "fsi_fir_seat, fsi_bus_seat, fsi_eco_seat, "
			+ "fsi_fir_pc, fsi_bus_pc, fsi_eco_pc, "
			+ "fsi_fir_mil, fsi_bus_mil, fsi_eco_mil) "
			+ "VALUES ( (SELECT NVL(MAX(fsi_idx), 0) + 1 FROM flight_spot_info), "
			+ "(SELECT NVL(MAX(fi_id), 0) FROM flight_info), "
			+ "#{fsi_start_place}, #{fsi_arrive_place}, #{fsi_pass1_place}, #{fsi_pass2_place}, "
			+ "#{fsi_start_dt}, #{fsi_arrive_dt}, #{fsi_pass1_dt}, #{fsi_pass2_dt}, "
			+ "sysdate, 0, "
			+ "#{fsi_fir_seat}, #{fsi_bus_seat}, #{fsi_eco_seat}, "
			+ "#{fsi_fir_pc}, #{fsi_bus_pc}, #{fsi_eco_pc}, "
			+ "#{fsi_fir_mil}, #{fsi_bus_mil}, #{fsi_eco_mil} )")
	public void insertFlightSpot(FlightCommand flight);
}
