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
	
	@Update("UPDATE spmember_detail SET name=#{name}, phone=#{phone}, email=#{email}, zipcode=#{zipcode}, address1=#{address1}, address2=#{address2} WHERE id=#{id}")
	public void update(MemberCommand member);
	@Update("UPDATE spmember_detail SET passwd=#{passwd} WHERE id=#{id}")
	public void updatePassword(MemberCommand member);
	@Update("UPDATE spmember SET auth=0 WHERE id=#{id}")
	public void delete(String id);
	@Delete("DELETE FROM spmember_detail WHERE id=#{id}")
	public void deleteDetail(String id);
	
	// 관리자 회원목록
	public List<MemberCommand> selectList(Map<String, Object> map);
	public int selectRowCount(Map<String, Object> map);
}
