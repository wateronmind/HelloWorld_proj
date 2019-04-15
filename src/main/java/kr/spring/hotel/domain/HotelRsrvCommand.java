package kr.spring.hotel.domain;

public class HotelRsrvCommand {

	private int srl_id;
	private int sr_id;
	private String user_id;
	private int srl_total_pc;
	private String srl_check_in_dt;
	private String srl_check_out_dt;
	private String srl_nm;
	private String srl_email;
	private String srl_phone;
	private int srl_age;
	private int ph_idx;
	private int srl_adult_pp;
	private int srl_kid_pp;

	public int getSrl_id() {
		return srl_id;
	}
	public void setSrl_id(int srl_id) {
		this.srl_id = srl_id;
	}
	public int getSr_id() {
		return sr_id;
	}
	public void setSr_id(int sr_id) {
		this.sr_id = sr_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getSrl_total_pc() {
		return srl_total_pc;
	}
	public void setSrl_total_pc(int srl_total_pc) {
		this.srl_total_pc = srl_total_pc;
	}
	public String getSrl_check_in_dt() {
		return srl_check_in_dt;
	}
	public void setSrl_check_in_dt(String srl_check_in_dt) {
		this.srl_check_in_dt = srl_check_in_dt;
	}
	public String getSrl_check_out_dt() {
		return srl_check_out_dt;
	}
	public void setSrl_check_out_dt(String srl_check_out_dt) {
		this.srl_check_out_dt = srl_check_out_dt;
	}
	public String getSrl_nm() {
		return srl_nm;
	}
	public void setSrl_nm(String srl_nm) {
		this.srl_nm = srl_nm;
	}
	public String getSrl_email() {
		return srl_email;
	}
	public void setSrl_email(String srl_email) {
		this.srl_email = srl_email;
	}
	public String getSrl_phone() {
		return srl_phone;
	}
	public void setSrl_phone(String srl_phone) {
		this.srl_phone = srl_phone;
	}
	public int getSrl_age() {
		return srl_age;
	}
	public void setSrl_age(int srl_age) {
		this.srl_age = srl_age;
	}
	public int getPh_idx() {
		return ph_idx;
	}
	public void setPh_idx(int ph_idx) {
		this.ph_idx = ph_idx;
	}
	public int getSrl_adult_pp() {
		return srl_adult_pp;
	}
	public void setSrl_adult_pp(int srl_adult_pp) {
		this.srl_adult_pp = srl_adult_pp;
	}
	public int getSrl_kid_pp() {
		return srl_kid_pp;
	}
	public void setSrl_kid_pp(int srl_kid_pp) {
		this.srl_kid_pp = srl_kid_pp;
	}

	@Override
	public String toString() {
		return "HotelRsrvCommand [srl_id=" + srl_id + ", sr_id=" + sr_id + ", user_id=" + user_id + ", srl_total_pc="
				+ srl_total_pc + ", srl_check_in_dt=" + srl_check_in_dt + ", srl_check_out_dt=" + srl_check_out_dt
				+ ", srl_nm=" + srl_nm + ", srl_email=" + srl_email + ", srl_phone=" + srl_phone + ", srl_age="
				+ srl_age + ", ph_idx=" + ph_idx + ", srl_adult_pp=" + srl_adult_pp + ", srl_kid_pp=" + srl_kid_pp
				+ "]";
	}
}
