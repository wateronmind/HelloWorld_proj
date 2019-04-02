package kr.spring.member.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.spring.member.domain.MemberCommand;

public interface MemberMapper {
	@Insert("INSERT INTO user_auth (user_id) VALUES (#{user_id})")
	public void insert(MemberCommand member);
	@Insert("INSERT INTO user_info (user_id,user_nm,user_pw,user_email,user_phone) "
			+ " VALUES (#{user_id}, #{user_nm}, #{user_pw},#{user_email},#{user_phone})")
	public void insertDetail(MemberCommand member);
	
	@Select("SELECT * FROM user_auth m LEFT OUTER JOIN user_info d ON m.user_id = d.user_id WHERE m.user_id=#{user_id}")
	public MemberCommand selectMember(String user_id);
	
	@Update("UPDATE user_info SET user_nm=#{user_nm}, user_phone=#{user_phone}, user_email=#{user_email} WHERE user_id=#{user_id}")
	public void update(MemberCommand member);
	
	@Update("UPDATE user_info SET user_pw=#{user_pw} WHERE user_id=#{user_id}")
	public void updatePassword(MemberCommand member);
	
	@Update("UPDATE user_auth SET user_auth=0 WHERE user_id=#{user_id}")
	public void delete(String user_id);
	
	@Delete("DELETE FROM user_info WHERE user_id=#{user_id}")
	public void deleteDetail(String user_id);
	
	@Update("UPDATE user_auth SET user_auth=2 WHERE user_id=#{user_id}")
	public void applyGuide(String user_id);
	@Update("UPDATE user_info SET user_apply_dt=sysdate,user_guide_apply='Y' WHERE user_id=#{user_id}")
	public void applyGuideInfo(String user_id);
	
	@Update("UPDATE user_auth SET user_auth=1 WHERE user_id=#{user_id}")
	public void cancelGuide(String user_id);
	@Update("UPDATE user_info SET user_guide_apply='N' WHERE user_id=#{user_id}")
	public void cancelGuideInfo(String user_id);
	
	
	// 관리자 회원목록
	public List<MemberCommand> selectList(Map<String, Object> map);
	public int selectRowCount(Map<String, Object> map);
}
