package kr.spring.member.service;

import java.util.List;
import java.util.Map;

import kr.spring.member.domain.MemberCommand;

public interface MemberService {
	//회원 가입
	public void insert(MemberCommand member);
	//회원 상세
	public MemberCommand selectMember(String user_id);
	//회원 정보 수정
	public void update(MemberCommand member);
	//비밀번호 수정 
	public void updatePassword(MemberCommand member);
	//탈퇴
	public void delete(String user_id);
	
	//가이드 신청 회원목록
	public List<MemberCommand> selectList(Map<String, Object> map);
	public int selectRowCount(Map<String, Object> map);
}
