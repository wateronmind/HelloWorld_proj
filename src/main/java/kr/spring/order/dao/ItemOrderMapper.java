package kr.spring.order.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import kr.spring.order.domain.ItemOrderCommand;

public interface ItemOrderMapper {
	@Select("SELECT item_buy_hist_seq.nextval FROM dual")
	public int getOrderNum();					//주문번호
	
	public List<ItemOrderCommand> getListOrder(Integer ibh_idx);		//주문전체목록
	
	@Select("SELECT COUNT (*) FROM item_buy_hist")
	public int getOrderCount();						//주문전체개수
	//public int getOrderCountById();					//ID별 주문전체개수
	public List<ItemOrderCommand> getListOrderById(); 	//ID별 주문전체목록
	//public List<ItemOrderDetailCommand> getListOrderDetail(int order_num);	//주문번호별 주문상세
	public ItemOrderCommand getOrderDetail(int ibh_rent_num,String user_id);	//ID,주문번호별 주문상세
	
	@Insert("INSERT INTO item_buy_hist(ibh_idx,i_num,ibh_quan,ph_idx,user_id,ibh_rent_num,ibh_phone,ibh_nm,ibh_email,ibh_pay,ibh_request,reg_date) VALUES (item_buy_hist_seq.NEXTVAL,#{i_num},#{ibh_quan},#{ph_idx},#{user_id},#{ibh_rent_num},#{ibh_phone},#{ibh_nm},#{ibh_email},#{ibh_pay},#{ibh_request},SYSDATE)")
	public void insertOrder(ItemOrderCommand itemOrderCommand, List<ItemOrderCommand> itemOrder);	//주문등록
	public void updateOrder(ItemOrderCommand itemOrderCommand);	
	public void deleteOrder(Integer num);
}
