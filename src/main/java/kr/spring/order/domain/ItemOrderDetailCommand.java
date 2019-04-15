package kr.spring.order.domain;

public class ItemOrderDetailCommand {
	int detail_num;
	int item_num;
	String item_nm;
	int item_pc;
	int item_total;
	int order_quan;
	int ibh_idx;
	public int getDetail_num() {
		return detail_num;
	}
	public void setDetail_num(int detail_num) {
		this.detail_num = detail_num;
	}
	public int getItem_num() {
		return item_num;
	}
	public void setItem_num(int item_num) {
		this.item_num = item_num;
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
		return "ItemOrderDetailCommand [detail_num=" + detail_num + ", item_num=" + item_num + ", item_nm=" + item_nm
				+ ", item_pc=" + item_pc + ", item_total=" + item_total + ", order_quan=" + order_quan + ", ibh_idx="
				+ ibh_idx + "]";
	}

	
}
