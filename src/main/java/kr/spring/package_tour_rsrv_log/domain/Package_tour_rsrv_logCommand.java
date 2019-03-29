package kr.spring.package_tour_rsrv_log.domain;

public class Package_tour_rsrv_logCommand {
	private int ptr_id;//패키지/투어 예약 ID
	private String uesr_id;//회원 ID
	private int pi_id;//패키지 ID
	private int ti_id;//투어 ID
	private int ph_idx;//결제 내역 IDX
	private int ptr_pp;//예약 인원
	private int pte_state;//예약 상태
	public int getPtr_id() {
		return ptr_id;
	}
	public void setPtr_id(int ptr_id) {
		this.ptr_id = ptr_id;
	}
	public String getUesr_id() {
		return uesr_id;
	}
	public void setUesr_id(String uesr_id) {
		this.uesr_id = uesr_id;
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
	public int getPh_idx() {
		return ph_idx;
	}
	public void setPh_idx(int ph_idx) {
		this.ph_idx = ph_idx;
	}
	public int getPtr_pp() {
		return ptr_pp;
	}
	public void setPtr_pp(int ptr_pp) {
		this.ptr_pp = ptr_pp;
	}
	public int getPte_state() {
		return pte_state;
	}
	public void setPte_state(int pte_state) {
		this.pte_state = pte_state;
	}
	@Override
	public String toString() {
		return "Package_tour_rsrv_logCommand [ptr_id=" + ptr_id + ", uesr_id=" + uesr_id + ", pi_id=" + pi_id
				+ ", ti_id=" + ti_id + ", ph_idx=" + ph_idx + ", ptr_pp=" + ptr_pp + ", pte_state=" + pte_state + "]";
	}
	
	

}
