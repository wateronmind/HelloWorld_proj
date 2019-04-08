package kr.spring.common.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.common.dao.CommonMapper;
import kr.spring.common.domain.NationCityCommand;

@Service("commonService")
public class CommonServiceImpl implements CommonService {
	
	@Resource
	private CommonMapper commonMapper;

	@Override
	public List<NationCityCommand> selectNCList() {
		return commonMapper.selectNCList();
	}
}
