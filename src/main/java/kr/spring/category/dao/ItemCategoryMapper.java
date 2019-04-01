package kr.spring.category.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;

import kr.spring.category.domain.ItemCategoryCommand;


public interface ItemCategoryMapper {
	public List<ItemCategoryCommand> selectList(Map<String, Object> map);
	public int selectRowCount(Map<String, Object> map);
	@Insert("INSERT INTO item_category (ict_num,ict_nm,ict_state) VALUES (item_category_seq.nextval, #{ict_nm}, #{ict_state})")
	public void insert(ItemCategoryCommand ItemCategory);
	public void update(ItemCategoryCommand ItemCategory);
	public void delete(Integer num);
}
