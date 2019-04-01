package kr.spring.package_info.domain;

import java.sql.Date;

public class Package_infoCommand {
	private int pi_id;//패키지 ID
	private String pi_nm;//패키지명
	private String pi_img;//패키지 이미지
	private String pi_copy_content;//패키지 카피글
	private int nc_cd;//도시코드
    private Date pi_start_day;//패키지 시작일
    private Date pi_end_day;//패키지 종료일
    private int pi_min_pp;//패키지 최소 인원
    private int pi_max_pp;//패키지 최대 인원
    private int pi_start_flight_rsrv_id;//패키지 출발 항공권
    private int pi_end_flight_rsrv_id;//패키지 도착 항공권
    private int pi_staying_rsrv_id;//패키지 숙박
    private int pi_time_diff;//현지시차
    private String pi_currency;//화폐
    private String pi_visa;//비자
    private String pi_volt;//전압
    private String pi_lang;//현지 언어
    private String pi_content;//상세내용
    private int pi_pc;//패키지 인당 가격
    private int pi_state;//패키지 상태
	public int getPi_id() {
		return pi_id;
	}
	public void setPi_id(int pi_id) {
		this.pi_id = pi_id;
	}
	public String getPi_nm() {
		return pi_nm;
	}
	public void setPi_nm(String pi_nm) {
		this.pi_nm = pi_nm;
	}
	public String getPi_img() {
		return pi_img;
	}
	public void setPi_img(String pi_img) {
		this.pi_img = pi_img;
	}
	public String getPi_copy_content() {
		return pi_copy_content;
	}
	public void setPi_copy_content(String pi_copy_content) {
		this.pi_copy_content = pi_copy_content;
	}
	public int getNc_cd() {
		return nc_cd;
	}
	public void setNc_cd(int nc_cd) {
		this.nc_cd = nc_cd;
	}
	public Date getPi_start_day() {
		return pi_start_day;
	}
	public void setPi_start_day(Date pi_start_day) {
		this.pi_start_day = pi_start_day;
	}
	public Date getPi_end_day() {
		return pi_end_day;
	}
	public void setPi_end_day(Date pi_end_day) {
		this.pi_end_day = pi_end_day;
	}
	public int getPi_min_pp() {
		return pi_min_pp;
	}
	public void setPi_min_pp(int pi_min_pp) {
		this.pi_min_pp = pi_min_pp;
	}
	public int getPi_max_pp() {
		return pi_max_pp;
	}
	public void setPi_max_pp(int pi_max_pp) {
		this.pi_max_pp = pi_max_pp;
	}
	public int getPi_start_flight_rsrv_id() {
		return pi_start_flight_rsrv_id;
	}
	public void setPi_start_flight_rsrv_id(int pi_start_flight_rsrv_id) {
		this.pi_start_flight_rsrv_id = pi_start_flight_rsrv_id;
	}
	public int getPi_end_flight_rsrv_id() {
		return pi_end_flight_rsrv_id;
	}
	public void setPi_end_flight_rsrv_id(int pi_end_flight_rsrv_id) {
		this.pi_end_flight_rsrv_id = pi_end_flight_rsrv_id;
	}
	public int getPi_staying_rsrv_id() {
		return pi_staying_rsrv_id;
	}
	public void setPi_staying_rsrv_id(int pi_staying_rsrv_id) {
		this.pi_staying_rsrv_id = pi_staying_rsrv_id;
	}
	public int getPi_time_diff() {
		return pi_time_diff;
	}
	public void setPi_time_diff(int pi_time_diff) {
		this.pi_time_diff = pi_time_diff;
	}
	public String getPi_currency() {
		return pi_currency;
	}
	public void setPi_currency(String pi_currency) {
		this.pi_currency = pi_currency;
	}
	public String getPi_visa() {
		return pi_visa;
	}
	public void setPi_visa(String pi_visa) {
		this.pi_visa = pi_visa;
	}
	public String getPi_volt() {
		return pi_volt;
	}
	public void setPi_volt(String pi_volt) {
		this.pi_volt = pi_volt;
	}
	public String getPi_lang() {
		return pi_lang;
	}
	public void setPi_lang(String pi_lang) {
		this.pi_lang = pi_lang;
	}
	public String getPi_content() {
		return pi_content;
	}
	public void setPi_content(String pi_content) {
		this.pi_content = pi_content;
	}
	public int getPi_pc() {
		return pi_pc;
	}
	public void setPi_pc(int pi_pc) {
		this.pi_pc = pi_pc;
	}
	public int getPi_state() {
		return pi_state;
	}
	public void setPi_state(int pi_state) {
		this.pi_state = pi_state;
	}
	@Override
	public String toString() {
		return "PackCommand [pi_id=" + pi_id + ", pi_nm=" + pi_nm + ", pi_img=" + pi_img + ", pi_copy_content="
				+ pi_copy_content + ", nc_cd=" + nc_cd + ", pi_start_day=" + pi_start_day + ", pi_end_day=" + pi_end_day
				+ ", pi_min_pp=" + pi_min_pp + ", pi_max_pp=" + pi_max_pp + ", pi_start_flight_rsrv_id="
				+ pi_start_flight_rsrv_id + ", pi_end_flight_rsrv_id=" + pi_end_flight_rsrv_id + ", pi_staying_rsrv_id="
				+ pi_staying_rsrv_id + ", pi_time_diff=" + pi_time_diff + ", pi_currency=" + pi_currency + ", pi_visa="
				+ pi_visa + ", pi_volt=" + pi_volt + ", pi_lang=" + pi_lang + ", pi_content=" + pi_content + ", pi_pc="
				+ pi_pc + ", pi_state=" + pi_state + "]";
	}
    
    

}
