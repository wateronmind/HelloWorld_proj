package kr.spring.member.service;

import java.util.List;
import java.util.Map;

import kr.spring.member.domain.MemberCommand;

public interface MemberService {
	//ȸ�� ����
	public void insert(MemberCommand member);
	//ȸ�� ��
	public MemberCommand selectMember(String user_id);
	//ȸ�� ���� ����
	public void update(MemberCommand member);
	//��й�ȣ ���� 
	public void updatePassword(MemberCommand member);
	//Ż��
	public void delete(String user_id);
	//���̵� ��û
	public void applyGuide(String user_id);
	//���̵� ���
	public void cancelGuide(String user_id);
	
	//���̵� ��û ȸ�����
	public List<MemberCommand> selectList(Map<String, Object> map);
	public int selectRowCount(Map<String, Object> map);
}
