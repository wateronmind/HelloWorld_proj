package kr.spring.order.controller;


import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.order.domain.ItemOrderCommand;
import kr.spring.order.service.ItemOrderService;

@Controller
public class ItemOrderController {
	private Logger log = Logger.getLogger(this.getClass());

	@Resource
	private ItemOrderService itemOrderService;

	// 자바빈(커맨드 객체) 초기화
	//	@ModelAttribute("command")
	//	public ItemCommand initCommand() {
	//		return new ItemCommand();
	//	}

	// ================ 게시판 글 등록 ================ //
	// 등록 폼
	@RequestMapping(value="/itemcart/orderForm.do", method=RequestMethod.GET)
	public String form(@ModelAttribute("Command") @Valid ItemOrderCommand itemOrderCommand, 
			BindingResult result) {
		return "orderForm";
	}

	// 전송된 데이터 처리
	@RequestMapping(value="/itemcart/orderForm.do", method=RequestMethod.POST)
	public String submit(@ModelAttribute("Command")
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

	// ================ 게시판 글 목록 ================ //
	@RequestMapping("/itemcart/orderCheck.do")
	public ModelAndView process() {

		List<ItemOrderCommand> list = itemOrderService.getListOrder();

		//Model이 들어간 이름은 리퀘스트에 담겨있고 el이 가져다씀
		ModelAndView mav = new ModelAndView();
		mav.setViewName("orderCheck");
		mav.addObject("list",list);
		//mav에 담은걸 el이 뽑아서 사용한다 view에서
		return mav;

	}
}
