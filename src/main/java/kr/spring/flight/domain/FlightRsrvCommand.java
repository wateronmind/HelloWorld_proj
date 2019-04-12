package kr.spring.flight.domain;

public class FlightRsrvCommand {
	private int fr_id; //항공권 예약 ID
	private int fsi_idx; //항공권 IDX
	private String user_id; //회원 ID
	private String fr_rsrv_seat_type; //예약좌석 등급
	private int fr_adult_pp; //16이상 성인 인원
	private int fr_kid_pp; // 만 15세 이하
	private int ph_idx; //결제 내역 idx
	private String fr_nm; //예약자명	
	private String fr_email; //예약자 이메일
	private String fr_phone; //예약자 연락처
	private String fr_passport; //예약자 여권번호
	private int fr_age; //10대 단위
	private String fr_fnm; //예약자 성
	
	public int getFr_id() {
		return fr_id;
	}
	public void setFr_id(int fr_id) {
		this.fr_id = fr_id;
	}
	public int getFsi_idx() {
		return fsi_idx;
	}
	public void setFsi_idx(int fsi_idx) {
		this.fsi_idx = fsi_idx;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getFr_rsrv_seat_type() {
		return fr_rsrv_seat_type;
	}
	public void setFr_rsrv_seat_type(String fr_rsrv_seat_type) {
		this.fr_rsrv_seat_type = fr_rsrv_seat_type;
	}
	public int getFr_adult_pp() {
		return fr_adult_pp;
	}
	public void setFr_adult_pp(int fr_adult_pp) {
		this.fr_adult_pp = fr_adult_pp;
	}
	public int getFr_kid_pp() {
		return fr_kid_pp;
	}
	public void setFr_kid_pp(int fr_kid_pp) {
		this.fr_kid_pp = fr_kid_pp;
	}
	public int getPh_idx() {
		return ph_idx;
	}
	public void setPh_idx(int ph_idx) {
		this.ph_idx = ph_idx;
	}
	public String getFr_nm() {
		return fr_nm;
	}
	public void setFr_nm(String fr_nm) {
		this.fr_nm = fr_nm;
	}
	public String getFr_email() {
		return fr_email;
	}
	public void setFr_email(String fr_email) {
		this.fr_email = fr_email;
	}
	public String getFr_phone() {
		return fr_phone;
	}
	public void setFr_phone(String fr_phone) {
		this.fr_phone = fr_phone;
	}
	public String getFr_passport() {
		return fr_passport;
	}
	public void setFr_passport(String fr_passport) {
		this.fr_passport = fr_passport;
	}
	public int getFr_age() {
		return fr_age;
	}
	public void setFr_age(int fr_age) {
		this.fr_age = fr_age;
	}
	public String getFr_fnm() {
		return fr_fnm;
	}
	public void setFr_fnm(String fr_fnm) {
		this.fr_fnm = fr_fnm;
	}
	@Override
	public String toString() {
		return "FlightRsrvCommand [fr_id=" + fr_id + ", fsi_idx=" + fsi_idx + ", user_id=" + user_id
				+ ", fr_rsrv_seat_type=" + fr_rsrv_seat_type + ", fr_adult_pp=" + fr_adult_pp + ", fr_kid_pp="
				+ fr_kid_pp + ", ph_idx=" + ph_idx + ", fr_nm=" + fr_nm + ", fr_email=" + fr_email + ", fr_phone="
				+ fr_phone + ", fr_passport=" + fr_passport + ", fr_age=" + fr_age + ", fr_fnm=" + fr_fnm + "]";
	}
	
}
