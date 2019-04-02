package kr.spring.item.service;

import java.util.List;
import java.util.Map;

import kr.spring.board.domain.BoardCommand;
import kr.spring.item.domain.ItemCommand;

public interface ItemService {
	public List<ItemCommand> selectList(Map<String,Object> map);
	public int selectRowCount(Map<String,Object> map);
	public void insert(ItemCommand Item);
	public ItemCommand selectList(Integer num);
	public void update(ItemCommand Item);
	public void delete(Integer num);
}
