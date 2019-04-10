package kr.spring.itemReview.domain;

public class ItemReviewCommand {
	private int ir_num;
	private String ir_content;
	private String ir_reg_date;
	private int ir_star;
	private String user_id;
	private int i_num;
	
	public int getIr_num() {
		return ir_num;
	}
	public void setIr_num(int ir_num) {
		this.ir_num = ir_num;
	}
	public String getIr_content() {
		return ir_content;
	}
	public void setIr_content(String ir_content) {
		this.ir_content = ir_content;
	}
	public String getIr_reg_date() {
		return ir_reg_date;
	}
	public void setIr_reg_date(String ir_reg_date) {
		this.ir_reg_date = ir_reg_date;
	}
	public int getIr_star() {
		return ir_star;
	}
	public void setIr_star(int ir_star) {
		this.ir_star = ir_star;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getI_num() {
		return i_num;
	}
	public void setI_num(int i_num) {
		this.i_num = i_num;
	}
	@Override
	public String toString() {
		return "ItemReviewCommand [ir_num=" + ir_num + ", ir_content=" + ir_content + ", ir_reg_date=" + ir_reg_date
				+ ", ir_star=" + ir_star + ", user_id=" + user_id + ", i_num=" + i_num + "]";
	}
	
	

}
