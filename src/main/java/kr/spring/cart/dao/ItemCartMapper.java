package kr.spring.cart.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.spring.cart.domain.ItemCartCommand;

public interface ItemCartMapper {
	public List<ItemCartCommand> selectCartList(String user_id);
	public int selectRowCount(Map<String,Object> map);
	@Insert("INSERT INTO item_cart(ic_num,i_num,ic_quan,user_id) VALUES (cart_seq.nextval,?,?,?)")
	public void insertCart(ItemCartCommand cart);
	public int getTotalById(String user_id);
	@Select("SELECT * FROM item_cart c JOIN item_info i ON c.i_num = i.i_num WHERE c.user_id = ? ORDER BY i.i_num ASC")
	public ItemCartCommand selectCartDetail(ItemCartCommand cart);
	@Update("")
	public void updateCart(ItemCartCommand cart);
	//public void updateCartByItem_num(ItemCartCommand cart);
	@Delete("")
	public void deleteCart(Integer ic_num);
	
}
