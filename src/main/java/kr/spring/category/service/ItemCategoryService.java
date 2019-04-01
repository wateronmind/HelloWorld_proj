package kr.spring.category.service;

import java.util.List;
import java.util.Map;

import kr.spring.category.domain.ItemCategoryCommand;



public interface ItemCategoryService {
	public List<ItemCategoryCommand> selectList(Map<String, Object> map);
	public int selectRowCount(Map<String, Object> map);
	public void insert(ItemCategoryCommand ItemCategory);
	public void update(ItemCategoryCommand ItemCategory);
	public void delete(Integer num);
}
