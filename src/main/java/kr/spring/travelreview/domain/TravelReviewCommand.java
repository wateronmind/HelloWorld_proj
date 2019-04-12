package kr.spring.travelreview.domain;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class TravelReviewCommand {
	private int tr_idx;//리뷰 번호
	private String tr_title;//제목
	private String tr_content;//내용
	private int tr_hit;//조회수
	private String tr_reg_date;//작성일
	private MultipartFile tr_upload;
	private byte[] tr_img;//이미지업로드
	private String user_id;//사용자아이디
	private int pi_id;//패키지 아이디
	private int ti_id;//투어 아이디
	
	public void setTr_upload(MultipartFile tr_upload) throws IOException {
		this.tr_upload = tr_upload;
		setTr_img(tr_upload.getBytes());
	}
	
	public int getTr_idx() {
		return tr_idx;
	}
	public void setTr_idx(int tr_idx) {
		this.tr_idx = tr_idx;
	}
	public String getTr_title() {
		return tr_title;
	}
	public void setTr_title(String tr_title) {
		this.tr_title = tr_title;
	}
	
	public String getTr_content() {
		return tr_content;
	}
	public void setTr_content(String tr_content) {
		this.tr_content = tr_content;
	}
	public int getTr_hit() {
		return tr_hit;
	}
	public void setTr_hit(int tr_hit) {
		this.tr_hit = tr_hit;
	}
	public String getTr_reg_date() {
		return tr_reg_date;
	}
	public void setTr_reg_date(String tr_reg_date) {
		this.tr_reg_date = tr_reg_date;
	}
	
	public MultipartFile getTr_upload() {
		return tr_upload;
	}
	
	public byte[] getTr_img() {
		return tr_img;
	}
	public void setTr_img(byte[] tr_img) {
		this.tr_img = tr_img;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getPi_id() {
		return pi_id;
	}
	public void setPi_id(int pi_id) {
		this.pi_id = pi_id;
	}
	public int getTi_id() {
		return ti_id;
	}
	public void setTi_id(int ti_id) {
		this.ti_id = ti_id;
	}
	@Override
	public String toString() {
		return "TravelReviewCommand [tr_idx=" + tr_idx + ", tr_title=" + tr_title + ", tr_content=" + tr_content
				+ ", tr_hit=" + tr_hit + ", tr_reg_date=" + tr_reg_date + ", tr_upload=" + tr_upload + ", user_id="
				+ user_id + ", pi_id=" + pi_id + ", ti_id=" + ti_id + "]";
	}
}
