package kr.spring.package_info.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;

import kr.spring.package_info.domain.Package_infoCommand;

public interface Package_infoMapper {
	
	public List<Package_infoCommand> selectList(Map<String,Object> map);
	public int selectRowCount(Map<String,Object> map);
	@Insert("INSERT INTO Package_infoCommand (pi_id,pi_nm,")
	public void insert(Package_infoCommand Package_info);
	

}
