package kr.spring.item.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;

import kr.spring.item.domain.ItemCommand;

public interface ItemMapper {
	public List<ItemCommand> selectList(Map<String, Object> map);
	public int selectRowCount(Map<String, Object> map);
	@Insert("INSERT INTO item_info (i_num,i_nm,i_pc,i_dispc,i_quan,i_img,i_content,i_rent_day,i_return_day,i_state,ivt_num) VALUES (item_info_seq.nextval, #{i_nm}, #{i_pc}, #{i_dispc}, #{i_quan}, #{i_img}, #{i_content}, #{i_rent_day}, #{i_return_day}, #{i_state}, #{ict_num})")
	public void insert(ItemCommand Item);
	public void update(ItemCommand Item);
	public void delete(Integer num);
}