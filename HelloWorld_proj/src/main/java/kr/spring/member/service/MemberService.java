package kr.spring.member.service;

import java.util.List;
import java.util.Map;

import kr.spring.member.domain.MemberCommand;

public interface MemberService {
	public void insert(MemberCommand member);
	public MemberCommand selectMember(String id);
	public void update(MemberCommand member);
	public void updatePassword(MemberCommand member);
	public void delete(String id);
	
	// 관리자 회원목록
	public List<MemberCommand> selectList(Map<String, Object> map);
	public int selectRowCount(Map<String, Object> map);
}
