package kr.spring.cart.service;

import java.util.List;


import kr.spring.cart.domain.ItemCartCommand;


public interface ItemCartService {
	public List<ItemCartCommand> selectCartList(String user_id);
	//public int selectRowCount(Map<String,Object> map);
	public void insertCart(ItemCartCommand cart);
	public int getTotalById(String user_id);
	public int selectCartDetail(int i_num,String user_id);
	public void updateCart(ItemCartCommand cart);
	//public void updateCartByItem_num(ItemCartCommand cart);
	public void deleteCart(ItemCartCommand cart);
}
