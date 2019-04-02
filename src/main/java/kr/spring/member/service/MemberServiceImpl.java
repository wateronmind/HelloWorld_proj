package kr.spring.member.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.member.dao.MemberMapper;
import kr.spring.member.domain.MemberCommand;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
	
	@Resource
	private MemberMapper memberMapper;

	@Override
	public void insert(MemberCommand member) {
		memberMapper.insert(member);
		memberMapper.insertDetail(member);
	}

	@Override
	public MemberCommand selectMember(String user_id) {
		return memberMapper.selectMember(user_id);
	}

	@Override
	public void update(MemberCommand member) {
		memberMapper.update(member);		
	}

	@Override
	public void updatePassword(MemberCommand member) {
		memberMapper.updatePassword(member);
		
	}

	@Override
	public void delete(String user_id) {
		memberMapper.delete(user_id);
		memberMapper.deleteDetail(user_id);
	}

	@Override
	public List<MemberCommand> selectList(Map<String, Object> map) {
		return memberMapper.selectList(map);
	}

	@Override
	public int selectRowCount(Map<String, Object> map) {
		return memberMapper.selectRowCount(map);
	}

	@Override
	public void applyGuide(String user_id) {
		memberMapper.applyGuide(user_id);
		memberMapper.applyGuideInfo(user_id);
	}

	@Override
	public void cancelGuide(String user_id) {
		memberMapper.cancelGuide(user_id);
		memberMapper.cancelGuideInfo(user_id);
	}

	
}
