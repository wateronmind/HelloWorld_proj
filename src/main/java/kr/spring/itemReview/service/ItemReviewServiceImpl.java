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
	public List<ItemReviewCommand> selectListReview() {
		
		return itemReviewMapper.selectListReview();
	}

	@Override
	public int selectRowCountReview(Map<String, Object> map) {
		
		return itemReviewMapper.selectRowCountReview(map);
	}

	@Override
	public void insertReview(ItemReviewCommand Item) {
		itemReviewMapper.insertReview(Item);
		
	}

	@Override
	public void deleteReview(Integer ir_num) {
		itemReviewMapper.deleteReview(ir_num);
		
	}


}
