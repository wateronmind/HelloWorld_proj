package kr.spring.order.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import kr.spring.order.domain.ItemOrderCommand;

public interface ItemOrderMapper {
	@Select("SELECT item_buy_hist_seq.nextval FROM dual")
	public int getOrderNum();					//�ֹ���ȣ
	public List<ItemOrderCommand> getListOrder(Integer ibh_idx);		//�ֹ���ü���
	//public int getOrderCount();						//�ֹ���ü����
	//public int getOrderCountById();					//ID�� �ֹ���ü����
	public List<ItemOrderCommand> getListOrderById(); 	//ID�� �ֹ���ü���
	//public List<ItemOrderDetailCommand> getListOrderDetail(int order_num);	//�ֹ���ȣ�� �ֹ���
	public ItemOrderCommand getOrderDetail(int ibh_rent_num,String user_id);	//ID,�ֹ���ȣ�� �ֹ���
	
	public void insertOrder(ItemOrderCommand itemOrderCommand, List<ItemOrderCommand> itemOrder);	//�ֹ����
	public void updateOrder(ItemOrderCommand itemOrderCommand);	
	public void deleteOrder(Integer num);
}
