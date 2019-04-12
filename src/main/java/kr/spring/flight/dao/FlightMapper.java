package kr.spring.flight.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import kr.spring.flight.domain.FlightCommand;
import kr.spring.flight.domain.FlightPayCommand;
import kr.spring.flight.domain.FlightRsrvCommand;

public interface FlightMapper {
	// 항공권
	public List<FlightCommand> selectFlightList(Map<String, Object> map);
	public int selectFlightRowCount(Map<String, Object> map);
	//@Select("SELECT * FROM flight_spot_info WHERE fsi_idx=#{fsi_idx}")
	//public FlightCommand selectFlight(Integer fsi_idx);
	
	@Select("SELECT flight_rsrv_log_seq.nextval FROM dual")
	public int getFr_id();
	
	//항공권 예약
	@Insert("INSERT INTO flight_rsrv_log (fr_id,fsi_idx," 
			+ "user_id,fr_rsrv_seat_type,fr_adult_pp," 
			+ "fr_kid_pp,fr_nm,fr_email," 
			+ "fr_phone,fr_passport,fr_age,fr_fnm) VALUES ("
			+ "#{fr_id},#{fsi_idx},#{user_id},#{fr_rsrv_seat_type},"
			+ "#{fr_adult_pp},#{fr_kid_pp},"
			+ "#{fr_nm},#{fr_email},#{fr_phone},#{fr_passport},"
			+ "#{fr_age},#{fr_fnm})")
	public void insertFlightRsrv(FlightRsrvCommand flightRsrv);
	
	public FlightCommand selectFlight(Integer fsi_idx);
	
	//결제
	public void insertFlightPay(FlightPayCommand flightPay);
	
}
	
	
	
	
	
	
	/*@Insert("{call INSERT_FLIGHT(#{fi_nm}, #{upload_fi_logo}, #{fsi_start_place}, "
		+ "#{fsi_arrive_place}, #{fsi_pass1_place}, #{fsi_pass2_place}, "
		+ "#{fsi_start_dt}, #{fsi_arrive_dt}, #{fsi_pass1_dt}, #{fsi_pass2_dt}, "
		+ "#{fsi_fir_seat}, #{fsi_bus_seat}, #{fsi_eco_seat}, "
		+ "#{fsi_fir_pc}, #{fsi_bus_pc}, #{fsi_eco_pc}, "
		+ "#{fsi_fir_mil}, #{fsi_bus_mil}, #{fsi_eco_mil})}")
	public void insertFlight(FlightCommand flight);*/
	/*
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
	*/
