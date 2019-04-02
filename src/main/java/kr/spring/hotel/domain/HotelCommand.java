package kr.spring.hotel.domain;

public class HotelCommand {
	private int st_id;
	private String st_nm;
	private String nc_cd;
	private String st_type;
	private String st_addr;
	private String st_cvntl;
	private String st_place_id;
	private int st_la;
	private int st_lo;
	private String st_img;
	
	public int getSt_id() {
		return st_id;
	}
	public void setSt_id(int st_id) {
		this.st_id = st_id;
	}
	public String getSt_nm() {
		return st_nm;
	}
	public void setSt_nm(String st_nm) {
		this.st_nm = st_nm;
	}
	public String getNc_cd() {
		return nc_cd;
	}
	public void setNc_cd(String nc_cd) {
		this.nc_cd = nc_cd;
	}
	public String getSt_type() {
		return st_type;
	}
	public void setSt_type(String st_type) {
		this.st_type = st_type;
	}
	public String getSt_addr() {
		return st_addr;
	}
	public void setSt_addr(String st_addr) {
		this.st_addr = st_addr;
	}
	public String getSt_cvntl() {
		return st_cvntl;
	}
	public void setSt_cvntl(String st_cvntl) {
		this.st_cvntl = st_cvntl;
	}
	public String getSt_place_id() {
		return st_place_id;
	}
	public void setSt_place_id(String st_place_id) {
		this.st_place_id = st_place_id;
	}
	public int getSt_la() {
		return st_la;
	}
	public void setSt_la(int st_la) {
		this.st_la = st_la;
	}
	public int getSt_lo() {
		return st_lo;
	}
	public void setSt_lo(int st_lo) {
		this.st_lo = st_lo;
	}
	public String getSt_img() {
		return st_img;
	}
	public void setSt_img(String st_img) {
		this.st_img = st_img;
	}
	@Override
	public String toString() {
		return "HotelCommand [st_id=" + st_id + ", st_nm=" + st_nm + ", nc_cd=" + nc_cd + ", st_type=" + st_type
				+ ", st_addr=" + st_addr + ", st_cvntl=" + st_cvntl + ", st_place_id=" + st_place_id + ", st_la="
				+ st_la + ", st_lo=" + st_lo + ", st_img=" + st_img + "]";
	}
}
