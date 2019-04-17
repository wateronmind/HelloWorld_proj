package kr.spring.order.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.cart.domain.ItemCartCommand;
import kr.spring.order.dao.ItemOrderMapper;
import kr.spring.order.domain.ItemOrderCommand;
import kr.spring.order.domain.ItemOrderDetailCommand;

@Service("itemOrderService")
public class ItemOrderServiceImpl implements ItemOrderService {

	@Resource
	private ItemOrderMapper itemOrderMapper;
	
	@Override
	public int getOrderNum() {
		// TODO Auto-generated method stub
		return itemOrderMapper.getOrderNum();
	}

	@Override
	public List<ItemOrderCommand> getListOrder(Integer ibh_idx) {
		// TODO Auto-generated method stub
		return itemOrderMapper.getListOrder(ibh_idx);
	}

	@Override
	public List<ItemOrderCommand> getListOrderById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemOrderCommand getOrderDetail(int ibh_idx, String user_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertOrder(ItemOrderCommand itemOrderCommand,List<ItemCartCommand> itemOrderlist) {
		itemOrderMapper.insertOrder(itemOrderCommand);
		
		for(ItemCartCommand item : itemOrderlist) {
			item.setIbh_idx(itemOrderCommand.getIbh_idx());
			System.out.println("~~~~~~~~~~~~~~~~"+item);
			itemOrderMapper.insertDetailOrder(item);
		}
		
	}

	@Override
	public void updateOrder(ItemOrderCommand ItemOrder) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteOrder(Integer num) {
		// TODO Auto-generated method stub
		
	}



}
