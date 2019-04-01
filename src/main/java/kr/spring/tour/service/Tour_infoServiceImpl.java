package kr.spring.tour.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.tour_info.dao.Tour_infoMapper;
import kr.spring.tour_info.domain.Tour_infoCommand;

@Service("tour_infoService")
public class Tour_infoServiceImpl implements Tour_infoService{
	
	@Resource
	private Tour_infoMapper tour_infoMapper;
	
	@Override
	public void insert(Tour_infoCommand tour_info) {
		tour_infoMapper.insert(tour_info);
		
	}

	@Override
	public List<Tour_infoCommand> selectList(Map<String, Object> map) {
		return tour_infoMapper.selectList(map);
	}

	@Override
	public int selectRowCount(Map<String, Object> map) {
		return tour_infoMapper.selectRowCount(map);
	}

}
