package kr.spring.item.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.item.dao.ItemMapper;
import kr.spring.item.domain.ItemCommand;

@Service("itemService")
public class ItemServiceImpl implements ItemService{
	
	@Resource
	private ItemMapper itemMapper;
	
	
	@Override
	public void insert(ItemCommand Item) {
		itemMapper.insert(Item);
		
	}

	@Override
	public void update(ItemCommand Item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer num) {
		// TODO Auto-generated method stub
		
	}

	

	@Override
	public List<ItemCommand> selectList(Map<String, Object> map) {

		return itemMapper.selectList(map);
	}

	@Override
	public int selectRowCount(Map<String, Object> map) {
		return itemMapper.selectRowCount(map);
	}

	

	@Override
	public ItemCommand selectItem(Integer num) {
		// TODO Auto-generated method stub
		return itemMapper.selectItem(num);
	}

	

}
