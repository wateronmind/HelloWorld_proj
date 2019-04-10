package kr.spring.order.controller;


import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.cart.domain.ItemCartCommand;
import kr.spring.cart.service.ItemCartService;
import kr.spring.order.domain.ItemOrderCommand;
import kr.spring.order.service.ItemOrderService;

@Controller
public class ItemOrderController {
	private Logger log = Logger.getLogger(this.getClass()); 

	@Resource
	private ItemOrderService itemOrderService;
	@Resource
	private ItemCartService itemCartService;

	// 자바빈(커맨드 객체) 초기화
		@ModelAttribute("command")
		public ItemOrderCommand initCommand() {
			return new ItemOrderCommand();
		}

	
			
	// ================ 게시판 글 등록 ================ //
	@RequestMapping(value="/itemcart/orderForm.do", method=RequestMethod.GET)
	public ModelAndView insertOrder(HttpSession session) {
		String user_id = (String)session.getAttribute("user_id");
		
		int getTotalById = itemCartService.getTotalById(user_id);//장바구니 전체금액 호출
		
		List<ItemCartCommand> list = itemCartService.selectCartList(user_id);
		
		if (log.isDebugEnabled()) {
			log.debug("<<list>> : " + list);
		}
		
		//Model이 들어간 이름은 리퀘스트에 담겨있고 el이 가져다씀
		ModelAndView mav = new ModelAndView();
		mav.setViewName("orderForm");
		mav.addObject("list",list);
		//mav에 담은걸 el이 뽑아서 사용한다 view에서

	
		mav.addObject("getTotalById",getTotalById);	//주문상품 전체금액

		return mav;
		
	}

	// 전송된 데이터 처리
	@RequestMapping(value="/itemcart/orderForm.do", method=RequestMethod.POST)
	public String submit(@ModelAttribute("command")
	@Valid ItemOrderCommand itemOrderCommand,
	BindingResult result) {
		
		if (log.isDebugEnabled()) {
			log.debug("<<itemOrderCommand>> : " + itemOrderCommand);
		}

		// 유효성 체크
		if (result.hasErrors()) {
			return "orderForm";
		}

		//주문번호 생성
		int order_num = itemOrderService.getOrderNum();
		
		itemOrderCommand.setIbh_idx(order_num);
		
		// 글쓰기
		itemOrderService.insertOrder(itemOrderCommand,itemOrder);

		// RedirectAttributes 객체는 리다이렉트 시점에 한 번만 사용되는
		// 데이터를 전송.
		// 브라우저에 데이터를 전송하지만 URI상에는 보이지 않는 숨겨진 데이터의
		// 형태로 전달

		return "redirect:/itemcart/orderCheck.do";
	}
	
	

	// ================ 주문확인 ================ //
	@RequestMapping("/itemcart/orderCheck.do")
	public ModelAndView orderCheck(@RequestParam("ibh_idx") int ibh_idx,
	HttpSession session, ModelAndView mav) {

		List<ItemOrderCommand> list = itemOrderService.getListOrder(ibh_idx);
		
		return new ModelAndView("orderCheck","list",list);

	}
}
