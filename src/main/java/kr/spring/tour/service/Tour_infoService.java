package kr.spring.tour.service;

import java.util.List;
import java.util.Map;

import kr.spring.tour_info.domain.Tour_infoCommand;

public interface Tour_infoService {
	public List<Tour_infoCommand> selectList(Map<String,Object> map);
	public int selectRowCount(Map<String,Object> map);
	public void insert(Tour_infoCommand tour_info);

}
