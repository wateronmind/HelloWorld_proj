package kr.spring.common.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import kr.spring.common.domain.NationCityCommand;

public interface CommonMapper {
 
	@Select("SELECT * FROM NATION_CITY ORDER BY NC_NATION, NC_CITY")
	public List<NationCityCommand> selectNCList();
}
