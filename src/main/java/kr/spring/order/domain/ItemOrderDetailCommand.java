package kr.spring.order.domain;

public class ItemOrderDetailCommand {
	int detail_num;
	int i_num;
	String item_nm;
	int item_pc;
	int item_total;
	int order_quan;
	int ibh_idx;
	int i_rent_day;
	int i_return_day;
	int i_rent_nc;
	int i_return_nc;
	
	public int getI_rent_day() {
		return i_rent_day;
	}
	public void setI_rent_day(int i_rent_day) {
		this.i_rent_day = i_rent_day;
	}
	public int getI_return_day() {
		return i_return_day;
	}
	public void setI_return_day(int i_return_day) {
		this.i_return_day = i_return_day;
	}
	public int getI_rent_nc() {
		return i_rent_nc;
	}
	public void setI_rent_nc(int i_rent_nc) {
		this.i_rent_nc = i_rent_nc;
	}
	public int getI_return_nc() {
		return i_return_nc;
	}
	public void setI_return_nc(int i_return_nc) {
		this.i_return_nc = i_return_nc;
	}
	public int getDetail_num() {
		return detail_num;
	}
	public void setDetail_num(int detail_num) {
		this.detail_num = detail_num;
	}
	public int getI_num() {
		return i_num;
	}
	public void setI_num(int item_num) {
		this.i_num = item_num;
	}
	public String getItem_nm() {
		return item_nm;
	}
	public void setItem_nm(String item_nm) {
		this.item_nm = item_nm;
	}
	public int getItem_pc() {
		return item_pc;
	}
	public void setItem_pc(int item_pc) {
		this.item_pc = item_pc;
	}
	public int getItem_total() {
		return item_total;
	}
	public void setItem_total(int item_total) {
		this.item_total = item_total;
	}
	public int getOrder_quan() {
		return order_quan;
	}
	public void setOrder_quan(int order_quan) {
		this.order_quan = order_quan;
	}
	public int getIbh_idx() {
		return ibh_idx;
	}
	public void setIbh_idx(int ibh_idx) {
		this.ibh_idx = ibh_idx;
	}
	@Override
	public String toString() {
		return "ItemOrderDetailCommand [detail_num=" + detail_num + ", i_num=" + i_num + ", item_nm=" + item_nm
				+ ", item_pc=" + item_pc + ", item_total=" + item_total + ", order_quan=" + order_quan + ", ibh_idx="
				+ ibh_idx + ", i_rent_day=" + i_rent_day + ", i_return_day=" + i_return_day + ", i_rent_nc=" + i_rent_nc
				+ ", i_return_nc=" + i_return_nc + "]";
	}
	

	
}
