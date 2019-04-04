package kr.spring.order.domain;

public class ItemOrderCommand {
	private int ibh_idx;
	private int i_num;
	private int ibh_quan;
	private int ph_idx;
	private String user_id;
	private String ibh_rent_num;
	private String ibh_phone;
	private String ibh_nm;
	private String ibh_rent_nc;
	private String ibh_return_nc;
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
	public int getIbh_quan() {
		return ibh_quan;
	}
	public void setIbh_quan(int ibh_quan) {
		this.ibh_quan = ibh_quan;
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
	public String getIbh_rent_nc() {
		return ibh_rent_nc;
	}
	public void setIbh_rent_nc(String ibh_rent_nc) {
		this.ibh_rent_nc = ibh_rent_nc;
	}
	public String getIbh_return_nc() {
		return ibh_return_nc;
	}
	public void setIbh_return_nc(String ibh_return_nc) {
		this.ibh_return_nc = ibh_return_nc;
	}
	@Override
	public String toString() {
		return "ItemOrderCommand [ibh_idx=" + ibh_idx + ", i_num=" + i_num + ", ibh_quan=" + ibh_quan + ", ph_idx="
				+ ph_idx + ", user_id=" + user_id + ", ibh_rent_num=" + ibh_rent_num + ", ibh_phone=" + ibh_phone
				+ ", ibh_nm=" + ibh_nm + ", ibh_rent_nc=" + ibh_rent_nc + ", ibh_return_nc=" + ibh_return_nc + "]";
	}
	
	
	
}
