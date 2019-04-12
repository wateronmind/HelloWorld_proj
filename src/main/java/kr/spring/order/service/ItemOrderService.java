package kr.spring.order.service;

import java.util.List;

import kr.spring.cart.domain.ItemCartCommand;
import kr.spring.order.domain.ItemOrderCommand;
import kr.spring.order.domain.ItemOrderDetailCommand;

public interface ItemOrderService {
	public int getOrderNum();					//주문번호
	public List<ItemOrderCommand> getListOrder(Integer ibh_idx);		//주문전체목록
	//public int getOrderCount();						//주문전체개수
	//public int getOrderCountById();					//ID별 주문전체개수
	public List<ItemOrderCommand> getListOrderById(); 	//ID별 주문전체목록
	//public List<ItemOrderDetailCommand> getListOrderDetail(int order_num);	//주문번호별 주문상세
	public ItemOrderCommand getOrderDetail(int ibh_idx,String user_id);	//ID,주문번호별 주문상세
	
	public void insertOrder(ItemOrderCommand itemOrderCommand,List<ItemCartCommand> itemOrderlist);	//주문등록
	public void updateOrder(ItemOrderCommand itemOrderCommand);	
	public void deleteOrder(Integer num);

}
