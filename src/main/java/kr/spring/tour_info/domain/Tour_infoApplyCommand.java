package kr.spring.tour_info.domain;

public class Tour_infoApplyCommand {
	private int ta_idx; //신청 내역 IDX
	private String user_id;// 회원 ID
	private int ti_id;//투어 ID 
	private int ti_state;// 신청 상태 (0:신청,1:승인,2:거부)
	private String ti_reg_date;//신청일자
	public int getTa_idx() {
		return ta_idx;
	}
	public void setTa_idx(int ta_idx) {
		this.ta_idx = ta_idx;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getTi_id() {
		return ti_id;
	}
	public void setTi_id(int ti_id) {
		this.ti_id = ti_id;
	}
	public int getTi_state() {
		return ti_state;
	}
	public void setTi_state(int ti_state) {
		this.ti_state = ti_state;
	}
	public String getTi_reg_date() {
		return ti_reg_date;
	}
	public void setTi_reg_date(String ti_reg_date) {
		this.ti_reg_date = ti_reg_date;
	}
	@Override
	public String toString() {
		return "Tour_infoApplyCommand [ta_idx=" + ta_idx + ", user_id=" + user_id + ", ti_id=" + ti_id + ", ti_state="
				+ ti_state + ", ti_reg_date=" + ti_reg_date + "]";
	}

}
