package kr.spring.order.domain;

import java.sql.Date;

public class ItemOrderCommand {
	private int ibh_idx;
	private int i_num;
	private int ibh_total;
	private int ph_idx;
	private String user_id;
	private String ibh_rent_num;
	private String ibh_phone;
	private String ibh_nm;

	
	private String ibh_email;
	private String ibh_pay;
	private String ibh_request;
	
	private Date reg_date;
	
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	public String getIbh_email() {
		return ibh_email;
	}
	public void setIbh_email(String ibh_email) {
		this.ibh_email = ibh_email;
	}
	public String getIbh_pay() {
		return ibh_pay;
	}
	public void setIbh_pay(String ibh_pay) {
		this.ibh_pay = ibh_pay;
	}
	public String getIbh_request() {
		return ibh_request;
	}
	public void setIbh_request(String ibh_request) {
		this.ibh_request = ibh_request;
	}
	public int getIbh_idx() {
		return ibh_idx;
	}
	public void setIbh_idx(int ibh_idx) {
		this.ibh_idx = ibh_idx;
	}
	public int getI_num() {
		return i_num;
	}
	public void setI_num(int i_num) {
		this.i_num = i_num;
	}
	public int getIbh_total() {
		return ibh_total;
	}
	public void setIbh_total(int ibh_total) {
		this.ibh_total = ibh_total;
	}
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
	public String getIbh_rent_num() {
		return ibh_rent_num;
	}
	public void setIbh_rent_num(String ibh_rent_num) {
		this.ibh_rent_num = ibh_rent_num;
	}
	public String getIbh_phone() {
		return ibh_phone;
	}
	public void setIbh_phone(String ibh_phone) {
		this.ibh_phone = ibh_phone;
	}
	public String getIbh_nm() {
		return ibh_nm;
	}
	public void setIbh_nm(String ibh_nm) {
		this.ibh_nm = ibh_nm;
	}
	@Override
	public String toString() {
		return "ItemOrderCommand [ibh_idx=" + ibh_idx + ", i_num=" + i_num + ", ibh_total=" + ibh_total + ", ph_idx="
				+ ph_idx + ", user_id=" + user_id + ", ibh_rent_num=" + ibh_rent_num + ", ibh_phone=" + ibh_phone
				+ ", ibh_nm=" + ibh_nm + ", ibh_email=" + ibh_email + ", ibh_pay=" + ibh_pay + ", ibh_request="
				+ ibh_request + ", reg_date=" + reg_date + "]";
	}
	
	
	
	
	
}
