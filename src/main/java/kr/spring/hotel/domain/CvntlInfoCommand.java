package kr.spring.hotel.domain;

public class CvntlInfoCommand {
 
	private int cvntl_id;
	private String cvntl_nm;
	private String cvntl_icon;
	
	public int getCvntl_id() {
		return cvntl_id;
	}
	public void setCvntl_id(int cvntl_id) {
		this.cvntl_id = cvntl_id;
	}
	public String getCvntl_nm() {
		return cvntl_nm;
	}
	public void setCvntl_nm(String cvntl_nm) {
		this.cvntl_nm = cvntl_nm;
	}
	public String getCvntl_icon() {
		return cvntl_icon;
	}
	public void setCvntl_icon(String cvntl_icon) {
		this.cvntl_icon = cvntl_icon;
	}

	@Override
	public String toString() {
		return "CvntlInfoCommand [cvntl_id=" + cvntl_id + ", cvntl_nm=" + cvntl_nm + ", cvntl_icon=" + cvntl_icon + "]";
	}
}
