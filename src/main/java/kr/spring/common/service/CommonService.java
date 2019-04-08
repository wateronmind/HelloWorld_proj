package kr.spring.common.service;

import java.util.List;

import kr.spring.common.domain.NationCityCommand;

public interface CommonService {

	public List<NationCityCommand> selectNCList();
}
