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
	
	//public int selectRowCount(Map<String,Object> map);
	
	@Insert("INSERT INTO item_cart(ic_num, user_id,i_num,ic_quan) VALUES(item_cart_seq.NEXTVAL, #{user_id},#{i_num},#{ic_quan})")
	public void insertCart(ItemCartCommand cart);
	
	public int getTotalById(String user_id);
	
	@Select("SELECT * FROM item_cart c JOIN item_info i ON c.i_num = i.i_num WHERE c.user_id = ? ORDER BY i.i_num ASC")
	public int selectCartDetail(int i_num,String user_id);
	
	@Update("UPDATE item_cart SET ic_quan=#{ic_quan} AND i_num=#{i_num}")
	public void updateCart(ItemCartCommand cart);
	
	//public void updateCartByItem_num(ItemCartCommand cart);
	
	@Delete("DELETE FROM item_cart WHERE ic_num=#{ic_num}")
	public void deleteCart(ItemCartCommand cart);
	
}
