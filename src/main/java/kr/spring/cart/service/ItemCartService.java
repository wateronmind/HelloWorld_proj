package kr.spring.item.cart.service;

import java.util.List;
import java.util.Map;


import kr.spring.item.cart.domain.ItemCartCommand;

public interface ItemCartService {
	public List<ItemCartCommand> selectCartList(String user_id);
	public int selectRowCount(Map<String,Object> map);
	public void insertCart(ItemCartCommand cart);
	public int getTotalById(String user_id);
	public ItemCartCommand selectCartDetail(ItemCartCommand cart);
	public void updateCart(ItemCartCommand cart);
	//public void updateCartByItem_num(ItemCartCommand cart);
	public void deleteCart(Integer ic_num);
}
