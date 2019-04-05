package kr.spring.tour_info.domain;

import java.io.IOException;
import java.sql.Date;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

public class Tour_infoCommand {
	private int ti_id;//투어 ID 1
	@NotEmpty
	private String ti_nm;//투여명 2
	/*@NotEmpty*/
	private String ti_img;//투어이미지 (파일 이름) 3 
	
	private MultipartFile upload;//업로드 파일 
	private byte[] uploadfile;//DB에 저장된 파일 4
	/*private String nc_cd;//도시 코드 5
*/	@NotEmpty
	private String ti_start_day;//투어 시작일 6
	@NotEmpty
	private String ti_end_day;//투어 종료일 7
	
	private int ti_min_pp;//투어 최소 인원 8
	
	private int ti_max_pp;//투어 최대 인원 9
	@NotEmpty
	private String ti_pickup_place;//픽업 장소 10
	@NotEmpty
	private String ti_pickup_time;//픽업 시간 11
	private String ti_content;//상세 내용 12
	/*@NotEmpty*/
	private int ti_pc;//투어 인당 가격 13
	private int ti_state;//투어 상태 14
	private String user_id;//가이드 ID 15
	
	private int re_cnt;//댓글 수 16
	
	//MultipartFile -> byte[] 변환
	//파일명 구하기
	public void setUpload(MultipartFile upload) throws IOException {
		this.upload = upload;
		              //byte[] 데이터 저장
		setUploadfile(upload.getBytes());
		                 //파일명
		setTi_img(upload.getOriginalFilename());
	}

	public int getTi_id() {
		return ti_id;
	}

	public void setTi_id(int ti_id) {
		this.ti_id = ti_id;
	}

	public String getTi_nm() {
		return ti_nm;
	}

	public void setTi_nm(String ti_nm) {
		this.ti_nm = ti_nm;
	}

	public String getTi_img() {
		return ti_img;
	}

	public void setTi_img(String ti_img) {
		this.ti_img = ti_img;
	}

	public byte[] getUploadfile() {
		return uploadfile;
	}

	public void setUploadfile(byte[] uploadfile) {
		this.uploadfile = uploadfile;
	}

	public String getTi_start_day() {
		return ti_start_day;
	}

	public void setTi_start_day(String ti_start_day) {
		this.ti_start_day = ti_start_day;
	}

	public String getTi_end_day() {
		return ti_end_day;
	}

	public void setTi_end_day(String ti_end_day) {
		this.ti_end_day = ti_end_day;
	}

	public int getTi_min_pp() {
		return ti_min_pp;
	}

	public void setTi_min_pp(int ti_min_pp) {
		this.ti_min_pp = ti_min_pp;
	}

	public int getTi_max_pp() {
		return ti_max_pp;
	}

	public void setTi_max_pp(int ti_max_pp) {
		this.ti_max_pp = ti_max_pp;
	}

	public String getTi_pickup_place() {
		return ti_pickup_place;
	}

	public void setTi_pickup_place(String ti_pickup_place) {
		this.ti_pickup_place = ti_pickup_place;
	}

	public String getTi_pickup_time() {
		return ti_pickup_time;
	}

	public void setTi_pickup_time(String ti_pickup_time) {
		this.ti_pickup_time = ti_pickup_time;
	}

	public String getTi_content() {
		return ti_content;
	}

	public void setTi_content(String ti_content) {
		this.ti_content = ti_content;
	}

	public int getTi_pc() {
		return ti_pc;
	}

	public void setTi_pc(int ti_pc) {
		this.ti_pc = ti_pc;
	}

	public int getTi_state() {
		return ti_state;
	}

	public void setTi_state(int ti_state) {
		this.ti_state = ti_state;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public int getRe_cnt() {
		return re_cnt;
	}

	public void setRe_cnt(int re_cnt) {
		this.re_cnt = re_cnt;
	}

	public MultipartFile getUpload() {
		return upload;
	}

	//(주의) byte[] uploadfile은 제외!!!

	@Override
	public String toString() {
		return "Tour_infoCommand [ti_id=" + ti_id + ", ti_nm=" + ti_nm + ", ti_img=" + ti_img + ", upload=" + upload
				+ ", ti_start_day=" + ti_start_day + ", ti_end_day=" + ti_end_day + ", ti_min_pp=" + ti_min_pp
				+ ", ti_max_pp=" + ti_max_pp + ", ti_pickup_place=" + ti_pickup_place + ", ti_pickup_time="
				+ ti_pickup_time + ", ti_content=" + ti_content + ", ti_pc=" + ti_pc + ", ti_state=" + ti_state
				+ ", user_id=" + user_id + ", re_cnt=" + re_cnt + "]";
	}
}


