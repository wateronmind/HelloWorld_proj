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
import kr.spring.item.domain.ItemCommand;
import kr.spring.util.PagingUtil;

@RequestMapping("/itemcart/*")
@Controller
public class ItemCartController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private ItemCartService itemCartService;
	
	private int rowCount = 10;
	private int pageCount = 10;
	
	// ================ 장바구니 추가 ================ //
		// 등록 폼
		@RequestMapping("cartInsert.do")
		public String form(@ModelAttribute ItemCartCommand itemCartCommand, HttpSession session) {
			String user_id = (String)session.getAttribute("user_id");
			itemCartCommand.setUser_id(user_id);
			//장바구니에 기존 상품이 있는지 검사
			//int count = itemCartService.selectRowCount(itemCartCommand.getI_num(), user_id);
			//count == 0 ? itemCartService.updateCart(itemCartCommand) : itemCartService.insertCart(itemCartCommand);
			

				return "redirect:/itemcart/cartList.do";
			}
		
	
	
	
	
		//======장바구니 글 목록=======//
			@RequestMapping("/itemcart/cartList.do")
			public ModelAndView process(
					@RequestParam(value="pageNum",defaultValue="1")
					int currentPage,
					@RequestParam(value="keyfield",defaultValue="")
					String keyfield,
					@RequestParam(value="keyword",defaultValue="")
					String keyword) {
				
				Map<String,Object> map = 
						new HashMap<String, Object>();
				map.put("keyfield", keyfield);
				map.put("keyword", keyword);
				
				//총 글의 갯수 또는 검색된 글의 갯수
				int count = itemCartService.selectRowCount(map);
				
				if(log.isDebugEnabled()) {
					log.debug("<<count>> : " + count);
				}
				
				PagingUtil page = 
						new PagingUtil(keyfield,keyword,currentPage,
								count,rowCount,pageCount,"itemList.do");
				map.put("start", page.getStartCount());
				map.put("end", page.getEndCount());
				
				List<ItemCommand> list = null;
				if(count > 0) {
					//list = itemCartService.selectCartList(user_id);
				}
				
				ModelAndView mav = new ModelAndView();
				mav.setViewName("itemCartList");
				mav.addObject("count", count);
				mav.addObject("list", list);
				mav.addObject("pagingHtml", page.getPagingHtml());
				
				return mav;
			}
			//========게시판 글 상세=========//
			@RequestMapping("/itemcart/cartDetail.do")
			public ModelAndView process(
					               @RequestParam("num") int num) {
				
				if(log.isDebugEnabled()) {
					log.debug("<<num>> : " + num);
				}
				
				//해당 글의 조회수 증가
				//boardService.updateHit(num);
				
				//ItemCartCommand list = itemCartService.selectCartList(num);
				ItemCartCommand list = null;
						              //view name    속성명  속성값
				return new ModelAndView("itemCartView","list",list);
			}

}
