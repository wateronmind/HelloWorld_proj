package kr.spring.hotel.domain;

import java.util.ArrayList;
import java.util.List;

public class HotelVwCommand {

	private int st_id;
	private int sr_id;
	private int sr_room_cnt;
	private int sr_max_pp;
	private int sr_adult_pc;
	private int sr_kid_pc;
	private int sr_bed;
	private int sr_toilet;
	private String sr_context;
	private String sr_img1;
	private String sr_img2;
	private String sr_img3;
	private String sr_img4;
	private String sr_img5;
	private String sr_nm;
	private String st_nm;
	private String nc_cd;
	private String st_type;
	private String st_addr;
	private String st_cvntl;
	private String st_content;
	private String st_check_in;
	private String st_check_out;
	private List<String> st_cvntl_id;
	private List<CvntlInfoCommand> st_cvntl_list;
	
	public List<String> getSt_cvntl_id() {
		
		String[] cvntl_arr = st_cvntl.split(",");
		
		st_cvntl_id = new ArrayList<String>();
		
		for(String arr : cvntl_arr) {
			st_cvntl_id.add(arr);
		}
		
		return st_cvntl_id;
	}
	
	public int getSt_id() {
		return st_id;
	}
	public void setSt_id(int st_id) {
		this.st_id = st_id;
	}
	public int getSr_id() {
		return sr_id;
	}
	public void setSr_id(int sr_id) {
		this.sr_id = sr_id;
	}
	public int getSr_room_cnt() {
		return sr_room_cnt;
	}
	public void setSr_room_cnt(int sr_room_cnt) {
		this.sr_room_cnt = sr_room_cnt;
	}
	public int getSr_max_pp() {
		return sr_max_pp;
	}
	public void setSr_max_pp(int sr_max_pp) {
		this.sr_max_pp = sr_max_pp;
	}
	public int getSr_adult_pc() {
		return sr_adult_pc;
	}
	public void setSr_adult_pc(int sr_adult_pc) {
		this.sr_adult_pc = sr_adult_pc;
	}
	public int getSr_kid_pc() {
		return sr_kid_pc;
	}
	public void setSr_kid_pc(int sr_kid_pc) {
		this.sr_kid_pc = sr_kid_pc;
	}
	public int getSr_bed() {
		return sr_bed;
	}
	public void setSr_bed(int sr_bed) {
		this.sr_bed = sr_bed;
	}
	public int getSr_toilet() {
		return sr_toilet;
	}
	public void setSr_toilet(int sr_toilet) {
		this.sr_toilet = sr_toilet;
	}
	public String getSr_context() {
		return sr_context;
	}
	public void setSr_context(String sr_context) {
		this.sr_context = sr_context;
	}
	public String getSr_img1() {
		return sr_img1;
	}
	public void setSr_img1(String sr_img1) {
		this.sr_img1 = sr_img1;
	}
	public String getSr_img2() {
		return sr_img2;
	}
	public void setSr_img2(String sr_img2) {
		this.sr_img2 = sr_img2;
	}
	public String getSr_img3() {
		return sr_img3;
	}
	public void setSr_img3(String sr_img3) {
		this.sr_img3 = sr_img3;
	}
	public String getSr_img4() {
		return sr_img4;
	}
	public void setSr_img4(String sr_img4) {
		this.sr_img4 = sr_img4;
	}
	public String getSr_img5() {
		return sr_img5;
	}
	public void setSr_img5(String sr_img5) {
		this.sr_img5 = sr_img5;
	}
	public String getSr_nm() {
		return sr_nm;
	}
	public void setSr_nm(String sr_nm) {
		this.sr_nm = sr_nm;
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
	public String getSt_content() {
		return st_content;
	}
	public void setSt_content(String st_content) {
		this.st_content = st_content;
	}
	public String getSt_check_in() {
		return st_check_in;
	}
	public void setSt_check_in(String st_check_in) {
		this.st_check_in = st_check_in;
	}
	public String getSt_check_out() {
		return st_check_out;
	}
	public void setSt_check_out(String st_check_out) {
		this.st_check_out = st_check_out;
	}
	public void setSt_cvntl_id(List<String> st_cvntl_id) {
		this.st_cvntl_id = st_cvntl_id;
	}
	public List<CvntlInfoCommand> getSt_cvntl_list() {
		return st_cvntl_list;
	}
	public void setSt_cvntl_list(List<CvntlInfoCommand> st_cvntl_list) {
		this.st_cvntl_list = st_cvntl_list;
	}
	
	@Override
	public String toString() {
		return "HotelVwCommand [st_id=" + st_id + ", sr_id=" + sr_id + ", sr_room_cnt=" + sr_room_cnt + ", sr_max_pp="
				+ sr_max_pp + ", sr_adult_pc=" + sr_adult_pc + ", sr_kid_pc=" + sr_kid_pc + ", sr_bed=" + sr_bed
				+ ", sr_toilet=" + sr_toilet + ", sr_context=" + sr_context + ", sr_img1=" + sr_img1 + ", sr_img2="
				+ sr_img2 + ", sr_img3=" + sr_img3 + ", sr_img4=" + sr_img4 + ", sr_img5=" + sr_img5 + ", sr_nm="
				+ sr_nm + ", st_nm=" + st_nm + ", nc_cd=" + nc_cd + ", st_type=" + st_type + ", st_addr=" + st_addr
				+ ", st_cvntl=" + st_cvntl + ", st_content=" + st_content + ", st_check_in=" + st_check_in
				+ ", st_check_out=" + st_check_out + ", st_cvntl_id=" + st_cvntl_id + ", st_cvntl_list=" + st_cvntl_list
				+ "]";
	}
}
