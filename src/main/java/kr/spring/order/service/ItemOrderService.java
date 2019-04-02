package kr.spring.order.service;

import java.util.List;

import kr.spring.order.domain.ItemOrderCommand;

public interface ItemOrderService {
	public int getOrderNum();					//�ֹ���ȣ
	public List<ItemOrderCommand> getListOrder();		//�ֹ���ü���
	//public int getOrderCount();						//�ֹ���ü����
	//public int getOrderCountById();					//ID�� �ֹ���ü����
	public List<ItemOrderCommand> getListOrderById(); 	//ID�� �ֹ���ü���
	//public List<ItemOrderDetailCommand> getListOrderDetail(int order_num);	//�ֹ���ȣ�� �ֹ���
	public ItemOrderCommand getOrderDetail(int ibh_rent_num,String user_id);	//ID,�ֹ���ȣ�� �ֹ���
	
	public void insertOrder(ItemOrderCommand itemOrderCommand, List<ItemOrderCommand> itemOrder);	//�ֹ����
	public void updateOrder(ItemOrderCommand itemOrderCommand);	
	public void deleteOrder(Integer num);

}
