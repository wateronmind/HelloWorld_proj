package kr.spring.travelreview.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.board.dao.BoardMapper;
import kr.spring.board.domain.BoardCommand;
import kr.spring.board.domain.BoardReplyCommand;
import kr.spring.travelreview.dao.TravelReviewMapper;
import kr.spring.travelreview.domain.TravelReviewCommand;

@Service("travelViewService")
public class TravelReviewServiceImpl implements TravelReviewService {
	
	@Resource
	private TravelReviewMapper travelReviewMapper;

	@Override
	public List<TravelReviewCommand> selectList(Map<String, Object> map) {
		return travelReviewMapper.selectList(map);
	}

	@Override
	public int selectRowCount(Map<String, Object> map) {
		return travelReviewMapper.selectRowCount(map);
	}

	@Override
	public void insert(TravelReviewCommand review) {
		travelReviewMapper.insert(review);
	}

	@Override
	public TravelReviewCommand selectBoard(Integer review) {
		return travelReviewMapper.selectBoard(review);
	}

	@Override
	public void updateHit(Integer review) {
		travelReviewMapper.updateHit(review);
		
	}

	@Override
	public void update(TravelReviewCommand review) {
		travelReviewMapper.update(review);
		
	}

	@Override
	public void delete(Integer review) {
		travelReviewMapper.delete(review);
	}
}
