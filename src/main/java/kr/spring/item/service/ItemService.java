package kr.spring.item.service;

import java.util.List;
import java.util.Map;

import kr.spring.item.domain.ItemCommand;

public interface ItemService {
	public List<ItemCommand> selectList(Map<String,Object> map);
	public ItemCommand selectItem(Integer i_num);
	public int selectRowCount(Map<String,Object> map);
	public void insert(ItemCommand Item);
	public void update(ItemCommand Item);
	public void delete(Integer i_num);
	
}
