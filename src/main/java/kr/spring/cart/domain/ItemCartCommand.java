package kr.spring.cart.domain;

import org.hibernate.validator.constraints.NotEmpty;

public class ItemCartCommand {
	@NotEmpty
	private int ic_num;
	private int i_num;
	private int ic_quan;
	private String user_id;
	public int getIc_num() {
		return ic_num;
	}
	public void setIc_num(int ic_num) {
		this.ic_num = ic_num;
	}
	public int getI_num() {
		return i_num;
	}
	public void setI_num(int i_num) {
		this.i_num = i_num;
	}
	public int getIc_quan() {
		return ic_quan;
	}
	public void setIc_quan(int ic_quan) {
		this.ic_quan = ic_quan;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	@Override
	public String toString() {
		return "ItemCartCommand [ic_num=" + ic_num + ", i_num=" + i_num + ", ic_quan=" + ic_quan + ", user_id="
				+ user_id + "]";
	}
	
	
	
}
