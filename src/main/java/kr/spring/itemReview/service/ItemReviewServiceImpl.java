package kr.spring.itemReview.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.itemReview.dao.ItemReviewMapper;
import kr.spring.itemReview.domain.ItemReviewCommand;

@Service("itemReviewService")
public class ItemReviewServiceImpl implements ItemReviewService{
	
	@Resource
	private ItemReviewMapper itemReviewMapper;
	
	@Override
	public List<ItemReviewCommand> selectListReview(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int selectRowCountReview(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void insertReview(ItemReviewCommand Item) {
		itemReviewMapper.insertReview(Item);
		
	}

	@Override
	public void deleteReview(Integer ir_num) {
		// TODO Auto-generated method stub
		
	}

	

}
