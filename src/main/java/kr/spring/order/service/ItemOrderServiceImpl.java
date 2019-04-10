package kr.spring.order.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.order.dao.ItemOrderMapper;
import kr.spring.order.domain.ItemOrderCommand;

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
	public ItemOrderCommand getOrderDetail(int ibh_rent_num, String user_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertOrder(ItemOrderCommand ItemOrder, List<ItemOrderCommand> itemOrderCommand) {
		// TODO Auto-generated method stub
		itemOrderMapper.insertOrder(ItemOrder, itemOrderCommand);
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
