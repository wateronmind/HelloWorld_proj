package kr.spring.category.domain;

public class ItemCategoryCommand {
	private int ict_num;
	private String ict_name;
	private int ict_state;
	
	public int getIct_num() {
		return ict_num;
	}
	public void setIct_num(int ict_num) {
		this.ict_num = ict_num;
	}
	public String getIct_name() {
		return ict_name;
	}
	public void setIct_name(String ict_name) {
		this.ict_name = ict_name;
	}
	public int getIct_state() {
		return ict_state;
	}
	public void setIct_state(int ict_state) {
		this.ict_state = ict_state;
	}
	
	@Override
	public String toString() {
		return "ItemCategoryCommand [ict_num=" + ict_num + ", ict_name=" + ict_name + ", ict_state=" + ict_state + "]";
	}
	
	
}
