package kr.spring.board.domain;

import kr.spring.util.DurationFromNow;

public class BoardReplyCommand {
	private int re_num;
	private String re_content;
	private String re_date;
	private String re_ip;
	private int num;
	private String id;

	public int getRe_num() {
		return re_num;
	}
	public void setRe_num(int re_num) {
		this.re_num = re_num;
	}
	public String getRe_content() {
		return re_content;
	}
	public void setRe_content(String re_content) {
		this.re_content = re_content;
	}
	public String getRe_date() {
		return re_date;
	}
	public void setRe_date(String re_date) {
		this.re_date = DurationFromNow.getTimeDiffLabel(re_date);
	}
	public String getRe_ip() {
		return re_ip;
	}
	public void setRe_ip(String re_ip) {
		this.re_ip = re_ip;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "BoardReplyCommand [re_num=" + re_num + ", re_content=" + re_content + ", re_date=" + re_date
				+ ", re_ip=" + re_ip + ", num=" + num + ", id=" + id + "]";
	}
	
}
