package kr.spring.category.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.category.dao.ItemCategoryMapper;
import kr.spring.category.domain.ItemCategoryCommand;


@Service("itemCategoryService")
public class ItemCategoryServiceImpl implements ItemCategoryService{
	
	@Resource
	private ItemCategoryMapper itemCategoryMapper;
	
	

	@Override
	public void insert(ItemCategoryCommand ItemCategory) {
		itemCategoryMapper.insert(ItemCategory);
		
	}

	@Override
	public void update(ItemCategoryCommand ItemCategory) {
		itemCategoryMapper.update(ItemCategory);
		
	}

	@Override
	public void delete(Integer ict_num) {
		itemCategoryMapper.delete(ict_num);
		
	}


	@Override
	public int getCategoryCount() {
		return itemCategoryMapper.getCategoryCount();
	}

	@Override
	public List<ItemCategoryCommand> selectList() {
		return itemCategoryMapper.selectList();
	}

	@Override
	public ItemCategoryCommand selectCategory(Integer ict_num) {
		return itemCategoryMapper.selectCategory(ict_num);
	}
	
	
}
