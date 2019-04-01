package kr.spring.item.cart.service;

import java.util.List;
import java.util.Map;

import kr.spring.item.cart.domain.ItemCartCommand;

public class ItemCartServiceImpl implements ItemCartService{

	@Override
	public List<ItemCartCommand> selectCartList(String user_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int selectRowCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void insertCart(ItemCartCommand cart) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getTotalById(String user_id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ItemCartCommand selectCartDetail(ItemCartCommand cart) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateCart(ItemCartCommand cart) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCart(Integer ic_num) {
		// TODO Auto-generated method stub
		
	}

}
