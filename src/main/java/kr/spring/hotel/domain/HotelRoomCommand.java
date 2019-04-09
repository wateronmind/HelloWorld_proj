package kr.spring.hotel.domain;

public class HotelRoomCommand {
 
	private int sr_id;
	private int st_id;
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
	
	public int getSr_id() {
		return sr_id;
	}
	public void setSr_id(int sr_id) {
		this.sr_id = sr_id;
	}
	public int getSt_id() {
		return st_id;
	}
	public void setSt_id(int st_id) {
		this.st_id = st_id;
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

	@Override
	public String toString() {
		return "HotelRoomCommand [sr_id=" + sr_id + ", st_id=" + st_id + ", sr_room_cnt=" + sr_room_cnt + ", sr_max_pp="
				+ sr_max_pp + ", sr_adult_pc=" + sr_adult_pc + ", sr_kid_pc=" + sr_kid_pc + ", sr_bed=" + sr_bed
				+ ", sr_toilet=" + sr_toilet + ", sr_context=" + sr_context + ", sr_img1=" + sr_img1 + ", sr_img2="
				+ sr_img2 + ", sr_img3=" + sr_img3 + ", sr_img4=" + sr_img4 + ", sr_img5=" + sr_img5 + ", sr_nm="
				+ sr_nm + "]";
	}
}
