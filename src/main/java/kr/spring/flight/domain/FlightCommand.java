package kr.spring.flight.domain;

public class FlightCommand {
	
	private int fi_id;
	private String fi_nm;
	private String fi_logo;
	
	public int getFi_id() {
		return fi_id;
	}
	public void setFi_id(int fi_id) {
		this.fi_id = fi_id;
	}
	public String getFi_nm() {
		return fi_nm;
	}
	public void setFi_nm(String fi_nm) {
		this.fi_nm = fi_nm;
	}
	public String getFi_logo() {
		return fi_logo;
	}
	public void setFi_logo(String fi_logo) {
		this.fi_logo = fi_logo;
	}
	
		@Override
	public String toString() {
		return "FlightCommand [fi_id=" + fi_id + ", fi_nm=" + fi_nm + ", fi_logo=" + fi_logo + "]";
	}
	
}
