package kr.spring.cart.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.cart.domain.ItemCartCommand;
import kr.spring.cart.service.ItemCartService;

@Controller
@RequestMapping("/itemcart/*")
public class ItemCartController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private ItemCartService itemCartService;
	
	
	
	// ================ 장바구니 추가 ================ //
		// 등록 폼
		@RequestMapping("/itemcart/cartInsert.do")
		public String insert(@ModelAttribute ItemCartCommand itemCartCommand, HttpSession session) {
			String user_id = (String)session.getAttribute("user_id");
			itemCartCommand.setUser_id(user_id);
			//장바구니에 기존 상품이 있는지 검사
			int count = itemCartService.selectCartDetail(itemCartCommand.getI_num(),user_id);
			//count == 0 ? itemCartService.updateCart(itemCartCommand) : itemCartService.insertCart(itemCartCommand);
			
			if(count==0) {
				//없으면 insert
				itemCartService.insertCart(itemCartCommand);
			}else {
				//있으면 update
				itemCartService.updateCart(itemCartCommand);
			}

				return "redirect:/itemcart/cartList.do";
			}
		
	
	
	
	
		//======장바구니 글 목록=======//
			@RequestMapping("/itemcart/cartList.do")
			public ModelAndView list(HttpSession session, ModelAndView mav) {
				//String user_id = (String)session.getAttribute("user_id"); //session에 저장된 user_id
				String user_id = "dragon";
				Map<String,Object> map = 
						new HashMap<String, Object>();
				
				List<ItemCartCommand> list = itemCartService.selectCartList(user_id); //장바구니 정보
				int getTotalById = itemCartService.getTotalById(user_id);//장바구니 전체금액 호출
				
				
				map.put("list", list); //장바구니 정보를 map에 저장
				map.put("count", list.size()); //장바구니 상품 유무
				map.put("getTotalById", getTotalById); //장바구니 전체금액
				map.put("allTotal",getTotalById);	//주문상품 전체금액
				mav.setViewName("cartList");	//view(jsp)의 이름 저장
				mav.addObject("map",map);	//map 변수 저장
				
				return mav;
			}
			
			//=======장바구니 삭제========//
			@RequestMapping("/itemcart/cartDelete.do")
			public String delete(@RequestParam int ic_num) {
				itemCartService.deleteCart(ic_num);
				return "redirect:/itemcart/cartList.do";
			}
			
			//=======장바구니 수정========//
			@RequestMapping("/itemcart/cartUpdate.do")
			public String update(@RequestParam int[] ic_quan, @RequestParam int[] i_num, HttpSession session) {
				//session의 id
				String user_id = (String)session.getAttribute("user_id");
				//레코드의 갯수 만큼 반복문 실행
				for(int i=0; i<i_num.length;i++) {
					ItemCartCommand itemCartCommand = new ItemCartCommand();
					itemCartCommand.setUser_id(user_id);
					itemCartCommand.setIc_quan(ic_quan[i]);
					itemCartCommand.setI_num(i_num[i]);
					itemCartService.updateCart(itemCartCommand);
				}
				return "redirect:/itemcart/cartList.do";
			}
			
			
			
			/*//========장바구니 글 상세=========//
			@RequestMapping("cartDetail.do")
			public ModelAndView process(
					               @RequestParam ("num") int num) {
				
				if(log.isDebugEnabled()) {
					log.debug("<<num>> : " + num);
				}
				
				
				
				//ItemCartCommand list = itemCartService.selectCartList(num);
				ItemCartCommand list = null;
						              //view name    속성명  속성값
				return new ModelAndView("itemCartView","list",list);
			}*/

}
