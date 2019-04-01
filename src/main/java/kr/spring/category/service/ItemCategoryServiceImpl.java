package kr.spring.category.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.category.dao.ItemCategoryMapper;
import kr.spring.category.domain.ItemCategoryCommand;


@Service("itemCategoryService")
public class ItemCategoryServiceImpl implements ItemCategoryService{
	
	@Resource
	private ItemCategoryMapper itemCategoryMapper;
	
	@Override
	public List<ItemCategoryCommand> selectList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int selectRowCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void insert(ItemCategoryCommand ItemCategory) {
		itemCategoryMapper.insert(ItemCategory);
		
	}

	@Override
	public void update(ItemCategoryCommand ItemCategory) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer num) {
		// TODO Auto-generated method stub
		
	}
	
	
}
