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

import kr.spring.order.domain.ItemOrderCommand;
import kr.spring.order.service.ItemOrderService;

@Controller
public class ItemOrderController {
	private Logger log = Logger.getLogger(this.getClass()); 

	@Resource
	private ItemOrderService itemOrderService;
	

	// 자바빈(커맨드 객체) 초기화
		@ModelAttribute("command")
		public ItemOrderCommand initCommand() {
			return new ItemOrderCommand();
		}

	

			
			
	// ================ 게시판 글 등록 ================ //
	// 등록 폼
	@RequestMapping(value="/itemcart/insertOrder.do", method=RequestMethod.GET)
	public ModelAndView insertOrder(@ModelAttribute("command") @Valid ItemOrderCommand itemOrderCommand, 
			BindingResult result, ModelAndView mav, HttpSession session) {
		String user_id = (String)session.getAttribute("user_id");
		itemOrderCommand.setUser_id(user_id);
		
		int ibh_idx = itemOrderService.getOrderNum();
		
		List<ItemOrderCommand> list = itemOrderService.getListOrder(ibh_idx); //장바구니 정보
		//int getTotalById = itemCartService.getTotalById(user_id);//장바구니 전체금액 호출
		
		if (log.isDebugEnabled()) {
			log.debug("<<list>> : " + list);
		}
		
		//mav.addObject("getTotalById", getTotalById); //장바구니 전체금액
		//mav.addObject("allTotal",getTotalById);	//주문상품 전체금액
		mav.setViewName("orderForm");	//view(jsp)의 이름 저장
		
		return mav;
		
	}

	// 전송된 데이터 처리
	@RequestMapping(value="/itemcart/insertOrder.do", method=RequestMethod.POST)
	public String submit(@ModelAttribute("command")
	@Valid ItemOrderCommand itemOrderCommand, List<ItemOrderCommand> itemOrder,
	BindingResult result) {
		if (log.isDebugEnabled()) {
			log.debug("<<itemOrderCommand>> : " + itemOrderCommand);
		}

		// 유효성 체크
		if (result.hasErrors()) {
			return "orderForm";
		}

		// 글쓰기
		itemOrderService.insertOrder(itemOrderCommand,itemOrder);

		// RedirectAttributes 객체는 리다이렉트 시점에 한 번만 사용되는
		// 데이터를 전송.
		// 브라우저에 데이터를 전송하지만 URI상에는 보이지 않는 숨겨진 데이터의
		// 형태로 전달

		return "redirect:/itemcart/orderForm.do";
	}

	// ================ 주문확인 ================ //
	@RequestMapping("/itemcart/orderCheck.do")
	public ModelAndView process(@RequestParam("ibh_idx") int ibh_idx,
	HttpSession session, ModelAndView mav) {

		List<ItemOrderCommand> list = itemOrderService.getListOrder(ibh_idx);
		
		return new ModelAndView("orderCheck","list",list);

	}
}
