package kr.spring.tour_info.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.tour_info.dao.Tour_infoMapper;
import kr.spring.tour_info.domain.Tour_infoCommand;
import kr.spring.tour_info.domain.Tour_infoReplyCommand;

@Service("tour_infoService")
public class Tour_infoServiceImpl implements Tour_infoService{
	
	@Resource
	private Tour_infoMapper tour_infoMapper;

	@Override
	public List<Tour_infoCommand> selectList(Map<String, Object> map) {
		return tour_infoMapper.selectList(map);
	}

	@Override
	public int selectRowCount(Map<String, Object> map) {
		return tour_infoMapper.selectRowCount(map);
	}
	@Override
	public void insert(Tour_infoCommand tour_info) {
		tour_infoMapper.insert(tour_info);
		
	}

	@Override
	public Tour_infoCommand selectTour_info(Integer ti_id) {
		return tour_infoMapper.selectTour_info(ti_id);
	}

	@Override
	public void update(Tour_infoCommand tour_info) {
          tour_infoMapper.update(tour_info);
		
	}

	@Override
	public void delete(Integer ti_id) {
		//����� �����ϸ� �켱 ���� �׸��� �θ�� ����
		tour_infoMapper.deleteReplyByNum(ti_id);
		//�θ�� ����
		tour_infoMapper.delete(ti_id);
	}

	@Override
	public List<Tour_infoReplyCommand> selectListReply(Map<String, Object> map) {
		return tour_infoMapper.selectListReply(map);
	}

	@Override
	public int selectRowCountReply(Map<String, Object> map) {
		return tour_infoMapper.selectRowCountReply(map);
	}

	@Override
	public void insertReply(Tour_infoReplyCommand tour_infoReply) {
		tour_infoMapper.insertReply(tour_infoReply);
	}

	@Override
	public void updateReply(Tour_infoReplyCommand boardReply) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteReply(Integer tr_idx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteReplyByNum(Integer ti_id) {
		// TODO Auto-generated method stub
		
	}

}