package kr.spring.tour_info.domain;

import kr.spring.util.DurationFromNow;

public class Tour_infoReplyCommand {
	
	private int tr_idx;
	private String tr_content;
	private String tr_date;
	private int ti_id;
	private String user_id;
	private int ti_star;
	
	
	public int getTr_idx() {
		return tr_idx;
	}
	public void setTr_idx(int tr_idx) {
		this.tr_idx = tr_idx;
	}
	public String getTr_content() {
		return tr_content;
	}
	public void setTr_content(String tr_content) {
		this.tr_content = tr_content;
	}
	public String getTr_date(String tr_date) {
		return tr_date = DurationFromNow.getTimeDiffLabel(tr_date);
	}
	public void setTr_date(String tr_date) {
		this.tr_date = tr_date;
	}
	public int getTi_id() {
		return ti_id;
	}
	public void setTi_id(int ti_id) {
		this.ti_id = ti_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getTi_star() {
		return ti_star;
	}
	public void setTi_star(int ti_star) {
		this.ti_star = ti_star;
	}
	@Override
	public String toString() {
		return "Tour_infoReplyCommand [tr_idx=" + tr_idx + ", tr_content=" + tr_content + ", tr_date=" + tr_date
				+ ", ti_id=" + ti_id + ", user_id=" + user_id + ", ti_star=" + ti_star + "]";
	}
	
	
}
