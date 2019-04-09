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

	// �ڹٺ�(Ŀ�ǵ� ��ü) �ʱ�ȭ
		@ModelAttribute("command")
		public ItemOrderCommand initCommand() {
			return new ItemOrderCommand();
		}

	
			
	// ================ �Խ��� �� ��� ================ //
	@RequestMapping(value="/itemcart/orderForm.do", method=RequestMethod.GET)
	public ModelAndView insertOrder(HttpSession session) {
		String user_id = (String)session.getAttribute("user_id");
		
		int getTotalById = itemCartService.getTotalById(user_id);//��ٱ��� ��ü�ݾ� ȣ��
		
		List<ItemCartCommand> list = itemCartService.selectCartList(user_id);
		
		if (log.isDebugEnabled()) {
			log.debug("<<list>> : " + list);
		}
		
		//Model�� �� �̸��� ������Ʈ�� ����ְ� el�� �����پ�
		ModelAndView mav = new ModelAndView();
		mav.setViewName("orderForm");
		mav.addObject("list",list);
		//mav�� ������ el�� �̾Ƽ� ����Ѵ� view����

	
		mav.addObject("getTotalById",getTotalById);	//�ֹ���ǰ ��ü�ݾ�

		return mav;
		
	}

	// ���۵� ������ ó��
	@RequestMapping(value="/itemcart/orderForm.do", method=RequestMethod.POST)
	public String submit(@ModelAttribute("command")
	@Valid ItemOrderCommand itemOrderCommand, List<ItemOrderCommand> itemOrder,
	BindingResult result) {
		if (log.isDebugEnabled()) {
			log.debug("<<itemOrderCommand>> : " + itemOrderCommand);
		}

		// ��ȿ�� üũ
		if (result.hasErrors()) {
			return "orderForm";
		}

		// �۾���
		itemOrderService.insertOrder(itemOrderCommand,itemOrder);

		// RedirectAttributes ��ü�� �����̷�Ʈ ������ �� ���� ���Ǵ�
		// �����͸� ����.
		// �������� �����͸� ���������� URI�󿡴� ������ �ʴ� ������ ��������
		// ���·� ����

		return "redirect:/itemcart/orderCheck.do";
	}
	
	

	// ================ �ֹ�Ȯ�� ================ //
	@RequestMapping("/itemcart/orderCheck.do")
	public ModelAndView orderCheck(@RequestParam("ibh_idx") int ibh_idx,
	HttpSession session, ModelAndView mav) {

		List<ItemOrderCommand> list = itemOrderService.getListOrder(ibh_idx);
		
		return new ModelAndView("orderCheck","list",list);

	}
}
