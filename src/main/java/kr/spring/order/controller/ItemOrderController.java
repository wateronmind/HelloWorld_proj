package kr.spring.order.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.cart.domain.ItemCartCommand;
import kr.spring.cart.service.ItemCartService;
import kr.spring.item.domain.ItemCommand;
import kr.spring.item.service.ItemService;
import kr.spring.order.domain.ItemOrderCommand;
import kr.spring.order.domain.ItemOrderDetailCommand;
import kr.spring.order.service.ItemOrderService;

@Controller
public class ItemOrderController {
	private Logger log = Logger.getLogger(this.getClass()); 

	@Resource
	private ItemOrderService itemOrderService;
	@Resource
	private ItemCartService itemCartService;
	@Resource
	private ItemService itemService;

	// 자바빈(커맨드 객체) 초기화
	@ModelAttribute("command")
	public ItemOrderCommand initCommand() {
		return new ItemOrderCommand();
	}



	//이미지 출력
	@RequestMapping("/itemcart/imageView.do")
	public ModelAndView viewImage(@RequestParam("i_num") int i_num) {

		ItemCommand itemCommand = itemService.selectItem(i_num);

		if(log.isDebugEnabled()) {
			log.debug("itemCommand:"+itemCommand);
		}

		ModelAndView mav = new ModelAndView();
		mav.setViewName("imageView");
		mav.addObject("imageFile", itemCommand.getI_img());
		mav.addObject("filename", "image.jpg");

		return mav;
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
	public String submit(@ModelAttribute("command") @Valid ItemOrderCommand itemOrderCommand,
	BindingResult result,HttpSession session) {

		
		// 유효성 체크
		/*if (result.hasErrors()) {
			return "orderForm";
		}*/

		//주문번호 생성
		int order_num = itemOrderService.getOrderNum();
		itemOrderCommand.setIbh_idx(order_num);

		if (log.isDebugEnabled()) {
			log.debug("<<itemOrderCommand>> : " + itemOrderCommand);
		}
		
		String user_id = (String)session.getAttribute("user_id");
		//상세정보 처리를 위해서 장바구니 테이블에 저장된 정보 호출
		List<ItemCartCommand> itemOrderlist = itemCartService.selectCartList(user_id);
		
		// 글쓰기
		itemOrderService.insertOrder(itemOrderCommand,itemOrderlist);

		// RedirectAttributes 객체는 리다이렉트 시점에 한 번만 사용되는
		// 데이터를 전송.
		// 브라우저에 데이터를 전송하지만 URI상에는 보이지 않는 숨겨진 데이터의
		// 형태로 전달
		

		return "redirect:/itemcart/orderCheck.do";
	}



	// ================ 주문확인 ================ //
	@RequestMapping("/itemcart/orderCheck.do")
	public String process(HttpSession session,Model model, 
			@Valid ItemOrderCommand itemOrderCommand) {
		String user_id=(String)session.getAttribute("user_id");


		itemOrderService.getOrderDetail(itemOrderCommand.getIbh_idx(),user_id);

		if (log.isDebugEnabled()) {
			log.debug("<<itemOrderCommand>> : "+itemOrderCommand);
		}

		//뽑아낸 데이터는 모델에 넣어준다. 뷰에서 자바빈에 접근해서 사용 할 수 있도록.
		model.addAttribute("itemOrderCommand",itemOrderCommand);

		return "orderCheck";
	}


	/*	@RequestMapping("/itemcart/orderCheck.do")
	public ModelAndView orderCheck(@RequestParam("ibh_idx") int ibh_idx,
	HttpSession session, ModelAndView mav) {

		List<ItemOrderCommand> list = itemOrderService.getListOrder(ibh_idx);

		//return new ModelAndView("orderCheck","list",list);

	}*/
}
