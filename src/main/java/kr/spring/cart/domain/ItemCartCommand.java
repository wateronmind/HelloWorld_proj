package kr.spring.cart.domain;

public class ItemCartCommand {
	private int ic_num;
	private int i_num;
	private int ic_quan;
	private String user_id;
	private String i_rent_day;
	private String i_return_day;
	private String i_rent_nc;
	private String i_return_nc;
	private int sub_total;
	
	private String i_nm;
	private int i_pc;
	private int ibh_idx;
	
	public int getIbh_idx() {
		return ibh_idx;
	}
	public void setIbh_idx(int ibh_idx) {
		this.ibh_idx = ibh_idx;
	}
	public int getSub_total() {
		sub_total = ic_quan * i_pc;
		return sub_total;
	}
	public void setSub_total(int sub_total) {
		this.sub_total = sub_total;
	}
	public String getI_rent_nc() {
		return i_rent_nc;
	}
	public void setI_rent_nc(String i_rent_nc) {
		this.i_rent_nc = i_rent_nc;
	}
	public String getI_return_nc() {
		return i_return_nc;
	}
	public void setI_return_nc(String i_return_nc) {
		this.i_return_nc = i_return_nc;
	}
	public String getI_rent_day() {
		return i_rent_day;
	}
	public void setI_rent_day(String i_rent_day) {
		this.i_rent_day = i_rent_day;
	}
	public String getI_return_day() {
		return i_return_day;
	}
	public void setI_return_day(String i_return_day) {
		this.i_return_day = i_return_day;
	}

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
	
	public String getI_nm() {
		return i_nm;
	}
	public void setI_nm(String i_nm) {
		this.i_nm = i_nm;
	}
	
	public int getI_pc() {
		return i_pc;
	}
	public void setI_pc(int i_pc) {
		this.i_pc = i_pc;
	}
	@Override
	public String toString() {
		return "ItemCartCommand [ic_num=" + ic_num + ", i_num=" + i_num + ", ic_quan=" + ic_quan + ", user_id="
				+ user_id + ", i_rent_day=" + i_rent_day + ", i_return_day=" + i_return_day + ", i_rent_nc=" + i_rent_nc
				+ ", i_return_nc=" + i_return_nc + ", sub_total=" + sub_total + ", i_nm=" + i_nm + ", i_pc=" + i_pc
				+ ", ibh_idx=" + ibh_idx + "]";
	}
}
