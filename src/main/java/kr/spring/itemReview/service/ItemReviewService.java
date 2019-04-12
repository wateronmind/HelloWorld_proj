package kr.spring.itemReview.service;

import java.util.List;
import java.util.Map;

import kr.spring.itemReview.domain.ItemReviewCommand;

public interface ItemReviewService {
	public List<ItemReviewCommand> selectListReview(Map<String,Object> map);
	public int selectRowCountReview(Map<String,Object> map);
	public void insertReview(ItemReviewCommand Item);
	public void deleteReview(Integer ir_num);
   
}
