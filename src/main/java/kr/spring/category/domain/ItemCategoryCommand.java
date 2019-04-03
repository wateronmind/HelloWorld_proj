package kr.spring.category.domain;

public class ItemCategoryCommand {
	private int ict_num;
	private String ict_nm;
	private int ict_state;
	//private int ict_cm;
	
	
	
	/*public int getIct_cm() {
		return ict_cm;
	}
	public void setIct_cm(int ict_cm) {
		this.ict_cm = ict_cm;
	}*/
	public int getIct_num() {
		return ict_num;
	}
	public void setIct_num(int ict_num) {
		this.ict_num = ict_num;
	}
	public String getIct_nm() {
		return ict_nm;
	}
	public void setIct_nm(String ict_nm) {
		this.ict_nm = ict_nm;
	}
	public int getIct_state() {
		return ict_state;
	}
	public void setIct_state(int ict_state) {
		this.ict_state = ict_state;
	}
	@Override
	public String toString() {
		return "ItemCategoryCommand [ict_num=" + ict_num + ", ict_nm=" + ict_nm + ", ict_state=" + ict_state + "]";
	}
	
}
