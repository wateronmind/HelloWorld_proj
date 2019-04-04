package kr.spring.flight.domain;

import java.io.IOException;
import java.sql.Date;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

public class FlightCommand {
	
	private int fi_id;
	@NotEmpty
	private String fi_nm;
	private MultipartFile upload_fi_logo; // 항공사 로고
	private byte[] fi_logo; // DB에 저장된 로고
	
	private int fsi_idx; // 항공권 idx
	@NotEmpty
	private String fsi_start_place;  // 출발지
	@NotEmpty
	private String fsi_arrive_place;  // 도착지
	private String fsi_pass1_place;  // 경유지1
	private String fsi_pass2_place;  // 경유지2
	@NotEmpty
	private String fsi_start_dt;     // 출발 시간
	@NotEmpty
	private String fsi_arrive_dt;    // 도착 시간
	private String fsi_pass1_dt;     // 경유지1 시간 
	private String fsi_pass2_dt;    // 경유지2 시간 
	private Date fsi_reg_dt;  // 항공권 등록 시간
	private String fsi_state;  // 구매 가능 상태

	private int fsi_fir_seat;  // FisrtClass 좌석 수
	private int fsi_bus_seat;  // Business 좌석 수
	private int fsi_eco_seat;  // Economy 좌석 수
	private int fsi_fir_pc;  // FisrtClass 가격
	private int fsi_bus_pc;  // Business 가격
	private int fsi_eco_pc;  // Economy 가격
	private int fsi_fir_mil;  // FisrtClass 마일리지
	private int fsi_bus_mil;  // Business 마일리지
	private int fsi_eco_mil;  // Economy 마일리지	
	
	public int getFi_id() {
		return fi_id;
	}
	public void setFi_id(int fi_id) {
		this.fi_id = fi_id;
	}
	public String getFi_nm() {
		return fi_nm;
	}
	public void setFi_nm(String fi_nm) {
		this.fi_nm = fi_nm;
	}
	public MultipartFile getUpload_fi_logo() {
		return upload_fi_logo;
	}
	public void setUpload_fi_logo(MultipartFile upload_fi_logo) throws IOException {
		this.upload_fi_logo = upload_fi_logo;
					// byte[] 데이터 저장
		setFi_logo(upload_fi_logo.getBytes());
	}
	public byte[] getFi_logo() {
		return fi_logo;
	}
	public void setFi_logo(byte[] fi_logo) {
		this.fi_logo = fi_logo;
	}
	public int getFsi_idx() {
		return fsi_idx;
	}
	public void setFsi_idx(int fsi_idx) {
		this.fsi_idx = fsi_idx;
	}
	public String getFsi_start_place() {
		return fsi_start_place;
	}
	public void setFsi_start_place(String fsi_start_place) {
		this.fsi_start_place = fsi_start_place;
	}
	public String getFsi_arrive_place() {
		return fsi_arrive_place;
	}
	public void setFsi_arrive_place(String fsi_arrive_place) {
		this.fsi_arrive_place = fsi_arrive_place;
	}
	public String getFsi_pass1_place() {
		return fsi_pass1_place;
	}
	public void setFsi_pass1_place(String fsi_pass1_place) {
		this.fsi_pass1_place = fsi_pass1_place;
	}
	public String getFsi_pass2_place() {
		return fsi_pass2_place;
	}
	public void setFsi_pass2_place(String fsi_pass2_place) {
		this.fsi_pass2_place = fsi_pass2_place;
	}
	public String getFsi_start_dt() {
		return fsi_start_dt;
	}
	public void setFsi_start_dt(String fsi_start_dt) {
		this.fsi_start_dt = fsi_start_dt;
	}
	public String getFsi_arrive_dt() {
		return fsi_arrive_dt;
	}
	public void setFsi_arrive_dt(String fsi_arrive_dt) {
		this.fsi_arrive_dt = fsi_arrive_dt;
	}
	public String getFsi_pass1_dt() {
		return fsi_pass1_dt;
	}
	public void setFsi_pass1_dt(String fsi_pass1_dt) {
		this.fsi_pass1_dt = fsi_pass1_dt;
	}
	public String getFsi_pass2_dt() {
		return fsi_pass2_dt;
	}
	public void setFsi_pass2_dt(String fsi_pass2_dt) {
		this.fsi_pass2_dt = fsi_pass2_dt;
	}
	public Date getFsi_reg_dt() {
		return fsi_reg_dt;
	}
	public void setFsi_reg_dt(Date fsi_reg_dt) {
		this.fsi_reg_dt = fsi_reg_dt;
	}
	public String getFsi_state() {
		return fsi_state;
	}
	public void setFsi_state(String fsi_state) {
		this.fsi_state = fsi_state;
	}
	public int getFsi_fir_seat() {
		return fsi_fir_seat;
	}
	public void setFsi_fir_seat(int fsi_fir_seat) {
		this.fsi_fir_seat = fsi_fir_seat;
	}
	public int getFsi_bus_seat() {
		return fsi_bus_seat;
	}
	public void setFsi_bus_seat(int fsi_bus_seat) {
		this.fsi_bus_seat = fsi_bus_seat;
	}
	public int getFsi_eco_seat() {
		return fsi_eco_seat;
	}
	public void setFsi_eco_seat(int fsi_eco_seat) {
		this.fsi_eco_seat = fsi_eco_seat;
	}
	public int getFsi_fir_pc() {
		return fsi_fir_pc;
	}
	public void setFsi_fir_pc(int fsi_fir_pc) {
		this.fsi_fir_pc = fsi_fir_pc;
	}
	public int getFsi_bus_pc() {
		return fsi_bus_pc;
	}
	public void setFsi_bus_pc(int fsi_bus_pc) {
		this.fsi_bus_pc = fsi_bus_pc;
	}
	public int getFsi_eco_pc() {
		return fsi_eco_pc;
	}
	public void setFsi_eco_pc(int fsi_eco_pc) {
		this.fsi_eco_pc = fsi_eco_pc;
	}
	public int getFsi_fir_mil() {
		return fsi_fir_mil;
	}
	public void setFsi_fir_mil(int fsi_fir_mil) {
		this.fsi_fir_mil = fsi_fir_mil;
	}
	public int getFsi_bus_mil() {
		return fsi_bus_mil;
	}
	public void setFsi_bus_mil(int fsi_bus_mil) {
		this.fsi_bus_mil = fsi_bus_mil;
	}
	public int getFsi_eco_mil() {
		return fsi_eco_mil;
	}
	public void setFsi_eco_mil(int fsi_eco_mil) {
		this.fsi_eco_mil = fsi_eco_mil;
	}
	
	@Override
	public String toString() {
		return "FlightCommand [fi_id=" + fi_id + ", fi_nm=" + fi_nm + ", upload_fi_logo=" + upload_fi_logo
				+ ", fsi_idx=" + fsi_idx + ", fsi_start_place="
				+ fsi_start_place + ", fsi_arrive_place=" + fsi_arrive_place + ", fsi_pass1_place=" + fsi_pass1_place
				+ ", fsi_pass2_place=" + fsi_pass2_place + ", fsi_start_dt=" + fsi_start_dt + ", fsi_arrive_dt="
				+ fsi_arrive_dt + ", fsi_pass1_dt=" + fsi_pass1_dt + ", fsi_pass2_dt=" + fsi_pass2_dt + ", fsi_reg_dt="
				+ fsi_reg_dt + ", fsi_state=" + fsi_state + ", fsi_fir_seat=" + fsi_fir_seat + ", fsi_bus_seat="
				+ fsi_bus_seat + ", fsi_eco_seat=" + fsi_eco_seat + ", fsi_fir_pc=" + fsi_fir_pc + ", fsi_bus_pc="
				+ fsi_bus_pc + ", fsi_eco_pc=" + fsi_eco_pc + ", fsi_fir_mil=" + fsi_fir_mil + ", fsi_bus_mil="
				+ fsi_bus_mil + ", fsi_eco_mil=" + fsi_eco_mil + "]";
	}
	
	
}
