package kr.spring.cart.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.cart.dao.ItemCartMapper;
import kr.spring.cart.domain.ItemCartCommand;


@Service("itemCartService")
public class ItemCartServiceImpl implements ItemCartService{

	@Resource
	private ItemCartMapper itemCartMapper;
	
	//장바구니목록
	@Override
	public List<ItemCartCommand> selectCartList(String user_id) {
		// TODO Auto-generated method stub
		return itemCartMapper.selectCartList(user_id);
	}

	
	/*@Override
	public int selectRowCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return 0;
	}*/

	//장바구니추가
	@Override
	public void insertCart(ItemCartCommand cart) {
		itemCartMapper.insertCart(cart);
		
	}

	//장바구니 금액합계
	@Override
	public int getTotalById(String user_id) {
		// TODO Auto-generated method stub
		return itemCartMapper.getTotalById(user_id);
	}

	//장바구니 상품 확인
	@Override
	public int selectCartDetail(int i_num,String user_id) {
		// TODO Auto-generated method stub
		return itemCartMapper.selectCartDetail(i_num,user_id);
	}

	//장바구니 상품수량변경
	@Override
	public void updateCart(ItemCartCommand cart) {
		itemCartMapper.updateCart(cart);
		
	}

	@Override
	public void deleteCart(Integer ic_num) {
		// TODO Auto-generated method stub
		itemCartMapper.deleteCart(ic_num);
	}


	

}
