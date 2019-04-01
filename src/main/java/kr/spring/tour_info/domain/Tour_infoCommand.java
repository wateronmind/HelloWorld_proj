package kr.spring.tour_info.domain;

import java.sql.Date;

import org.hibernate.validator.constraints.NotEmpty;

public class Tour_infoCommand {
	private int ti_id;//투어 ID
	@NotEmpty
	private String ti_nm;//투여명
	private String ti_img;//투어이미지
	@NotEmpty
	private int nc_cd;//도시 코드
	@NotEmpty
	private String ti_start_day;//투어 시작일
	@NotEmpty
	private String ti_end_day;//투어 종료일
	@NotEmpty
	private int ti_min_pp;//투어 최소 인원
	@NotEmpty
	private int ti_max_pp;//투어 최대 인원
	@NotEmpty
	private String ti_pickup_place;//픽업 장소
	@NotEmpty
	private int ti_pickup_time;//픽업 시간
	private String ti_content;//상세 내용
	@NotEmpty
	private int ti_pc;//투어 인당 가격
	private int ti_state;//투어 상태
	public int getTi_id() {
		return ti_id;
	}
	public void setTi_id(int ti_id) {
		this.ti_id = ti_id;
	}
	public String getTi_nm() {
		return ti_nm;
	}
	public void setTi_nm(String ti_nm) {
		this.ti_nm = ti_nm;
	}
	public String getTi_img() {
		return ti_img;
	}
	public void setTi_img(String ti_img) {
		this.ti_img = ti_img;
	}
	public int getNc_cd() {
		return nc_cd;
	}
	public void setNc_cd(int nc_cd) {
		this.nc_cd = nc_cd;
	}
	public String getTi_start_day() {
		return ti_start_day;
	}
	public void setTi_start_day(String ti_start_day) {
		this.ti_start_day = ti_start_day;
	}
	public String getTi_end_day() {
		return ti_end_day;
	}
	public void setTi_end_day(String ti_end_day) {
		this.ti_end_day = ti_end_day;
	}
	public int getTi_min_pp() {
		return ti_min_pp;
	}
	public void setTi_min_pp(int ti_min_pp) {
		this.ti_min_pp = ti_min_pp;
	}
	public int getTi_max_pp() {
		return ti_max_pp;
	}
	public void setTi_max_pp(int ti_max_pp) {
		this.ti_max_pp = ti_max_pp;
	}
	public String getTi_pickup_place() {
		return ti_pickup_place;
	}
	public void setTi_pickup_place(String ti_pickup_place) {
		this.ti_pickup_place = ti_pickup_place;
	}
	public int getTi_pickup_time() {
		return ti_pickup_time;
	}
	public void setTi_pickup_time(int ti_pickup_time) {
		this.ti_pickup_time = ti_pickup_time;
	}
	public String getTi_content() {
		return ti_content;
	}
	public void setTi_content(String ti_content) {
		this.ti_content = ti_content;
	}
	public int getTi_pc() {
		return ti_pc;
	}
	public void setTi_pc(int ti_pc) {
		this.ti_pc = ti_pc;
	}
	public int getTi_state() {
		return ti_state;
	}
	public void setTi_state(int ti_state) {
		this.ti_state = ti_state;
	}
	@Override
	public String toString() {
		return "TourCommand [ti_id=" + ti_id + ", ti_nm=" + ti_nm + ", ti_img=" + ti_img + ", nc_cd=" + nc_cd
				+ ", ti_start_day=" + ti_start_day + ", ti_end_day=" + ti_end_day + ", ti_min_pp=" + ti_min_pp
				+ ", ti_max_pp=" + ti_max_pp + ", ti_pickup_place=" + ti_pickup_place + ", ti_pickup_time="
				+ ti_pickup_time + ", ti_content=" + ti_content + ", ti_pc=" + ti_pc + ", ti_state=" + ti_state + "]";
	}
	
	

}
