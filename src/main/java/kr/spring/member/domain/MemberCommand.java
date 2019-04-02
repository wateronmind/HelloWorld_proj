package kr.spring.member.domain;

import java.sql.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

public class MemberCommand {
	@NotEmpty
	private String user_id;
	private int user_auth;
	@NotEmpty
	private String user_nm;
	@Size(min=4,max=20)
	private String user_pw;
	@NotEmpty
	private String user_phone;
	@Email
	@NotEmpty
	private String user_email;
	
	private Date user_apply_dt;
	private String user_guide_apply;
	private int user_mil;
	private byte[] user_profile; // DB에 저장된 파일
	private String user_filename; // 파일명
	
	@Size(min=4,max=20)
	private String old_pw;
	
	// 비밀번호 일치 여부 체크
	public boolean isCheckedPasswd(String user_pw) {
		if (user_auth > 0 && user_pw.equals(user_pw)) {
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "MemberCommand [user_id=" + user_id + ", user_auth=" + user_auth + ", user_nm=" + user_nm + ", user_pw="
				+ user_pw + ", user_phone=" + user_phone + ", user_email=" + user_email + ", user_apply_dt="
				+ user_apply_dt + ", user_guide_apply=" + user_guide_apply + ", user_mil=" + user_mil
				+ ", user_filename=" + user_filename + ", old_pw=" + old_pw + "]";
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public int getUser_auth() {
		return user_auth;
	}

	public void setUser_auth(int user_auth) {
		this.user_auth = user_auth;
	}

	public String getUser_nm() {
		return user_nm;
	}

	public void setUser_nm(String user_nm) {
		this.user_nm = user_nm;
	}

	public String getUser_pw() {
		return user_pw;
	}

	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}

	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public Date getUser_apply_dt() {
		return user_apply_dt;
	}

	public void setUser_apply_dt(Date user_apply_dt) {
		this.user_apply_dt = user_apply_dt;
	}

	public String getUser_guide_apply() {
		return user_guide_apply;
	}

	public void setUser_guide_apply(String user_guide_apply) {
		this.user_guide_apply = user_guide_apply;
	}

	public int getUser_mil() {
		return user_mil;
	}

	public void setUser_mil(int user_mil) {
		this.user_mil = user_mil;
	}

	public byte[] getUser_profile() {
		return user_profile;
	}

	public void setUser_profile(byte[] user_profile) {
		this.user_profile = user_profile;
	}

	public String getUser_filename() {
		return user_filename;
	}

	public void setUser_filename(String user_filename) {
		this.user_filename = user_filename;
	}

	public String getOld_pw() {
		return old_pw;
	}

	public void setOld_pw(String old_pw) {
		this.old_pw = old_pw;
	}
	
	
	
}
