package kr.spring.board.domain;

import java.io.IOException;
import java.sql.Date;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

public class BoardCommand {
	private int num; // 글번호
	@NotEmpty
	private String title; // 글제목
	@NotEmpty
	private String content; // 글내용
	private int hit; // 조회수
	private Date reg_date; // 등록날짜
	private MultipartFile upload; // 업로드 파일
	// toString으로 만들면 byte 타입의 데이터는 엄청 길기 때문에
	// 속도가 느려진다. toString 시 제외해 준다.
	private byte[] uploadfile; // DB에 저장된 파일
	private String filename; // 파일명
	private String ip; // ip주소
	@NotEmpty
	private String id; // 회원id
	
	private int re_cnt; // 댓글 수
	
	// MultipartFile -> byte[] 변환
	// 파일명 구하기
	public void setUpload(MultipartFile upload) throws IOException {
		this.upload = upload;
					 // byte[] 데이터 저장
		setUploadfile(upload.getBytes());
                     // 파일명
		setFilename(upload.getOriginalFilename());
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}

	public MultipartFile getUpload() {
		return upload;
	}

	public byte[] getUploadfile() {
		return uploadfile;
	}

	public void setUploadfile(byte[] uploadfile) {
		this.uploadfile = uploadfile;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getRe_cnt() {
		return re_cnt;
	}

	public void setRe_cnt(int re_cnt) {
		this.re_cnt = re_cnt;
	}

	// (주의) byte[]의 uploadfile은 제외!!!!
	@Override
	public String toString() {
		return "BoardCommand [num=" + num + ", title=" + title + ", content=" + content + ", hit=" + hit + ", reg_date="
				+ reg_date + ", upload=" + upload + ", filename=" + filename + ", ip=" + ip + ", id=" + id + ", re_cnt="
				+ re_cnt + "]";
	}
	
}
