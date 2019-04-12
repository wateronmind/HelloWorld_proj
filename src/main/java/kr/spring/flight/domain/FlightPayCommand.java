package kr.spring.flight.domain;

import java.sql.Date;

public class FlightPayCommand {
	private int ph_idx; // 결제 내역 IDX	
	private String user_id; //회원 ID
	private String ph_pay_type; //0:현금/1:카드/2:계좌이체/3:환불
	private int ph_pay; //결제 금액
	private Date ph_reg_dt; //결제 일시
	
	public int getPh_idx() {
		return ph_idx;
	}
	public void setPh_idx(int ph_idx) {
		this.ph_idx = ph_idx;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getPh_pay_type() {
		return ph_pay_type;
	}
	public void setPh_pay_type(String ph_pay_type) {
		this.ph_pay_type = ph_pay_type;
	}
	public int getPh_pay() {
		return ph_pay;
	}
	public void setPh_pay(int ph_pay) {
		this.ph_pay = ph_pay;
	}
	public Date getPh_reg_dt() {
		return ph_reg_dt;
	}
	public void setPh_reg_dt(Date ph_reg_dt) {
		this.ph_reg_dt = ph_reg_dt;
	}
	
	@Override
	public String toString() {
		return "FlightPayCommand [ph_idx=" + ph_idx + ", user_id=" + user_id + ", ph_pay_type=" + ph_pay_type
				+ ", ph_pay=" + ph_pay + ", ph_reg_dt=" + ph_reg_dt + "]";
	}	
}
