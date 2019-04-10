package kr.spring.itemReview.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import kr.spring.itemReview.domain.ItemReviewCommand;


public interface ItemReviewMapper {
	
	public List<ItemReviewCommand> selectListReview(Map<String,Object> map);
	@Select("SELECT COUNT(*) FROM item_review WHERE ir_num=#{ir_num}")
	public int selectRowCountReview(Map<String,Object> map);
	@Insert("INSERT INTO item_review (ir_num,ir_content,ir_reg_date,ir_star,user_id,i_num) "
			+ " VALUES (item_review_seq.nextval, #{ir_content}, SYSDATE, #{ir_star}, #{user_id}, #{i_num})")
	public void insertReview(ItemReviewCommand Item);
	@Delete("DELETE FROM item_review WHERE ir_num=#{ir_num}")
	public void deleteReview(Integer ir_num);
}
