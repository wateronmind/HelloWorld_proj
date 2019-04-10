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
import org.springframework.web.servlet.ModelAndView;

import kr.spring.cart.service.ItemCartService;
import kr.spring.order.domain.ItemOrderCommand;
import kr.spring.order.service.ItemOrderService;

@Controller
public class ItemOrderController {
	private Logger log = Logger.getLogger(this.getClass());

	@Resource
	private ItemOrderService itemOrderService;
	

	// �ڹٺ�(Ŀ�ǵ� ��ü) �ʱ�ȭ
	//	@ModelAttribute("command")
	//	public ItemCommand initCommand() {
	//		return new ItemCommand();
	//	}

	

			
			
	// ================ �Խ��� �� ��� ================ //
	// ��� ��
	@RequestMapping(value="/itemcart/insertOrder.do", method=RequestMethod.GET)
	public ModelAndView form(@ModelAttribute("command") @Valid ItemOrderCommand itemOrderCommand, 
			BindingResult result, ModelAndView mav, HttpSession session) {
		String user_id = (String)session.getAttribute("user_id");
		itemOrderCommand.setUser_id(user_id);
		
		int ibh_idx=itemOrderService.getOrderNum();
		
		List<ItemOrderCommand> list = itemOrderService.getListOrder(ibh_idx); //��ٱ��� ����
		//int getTotalById = itemCartService.getTotalById(user_id);//��ٱ��� ��ü�ݾ� ȣ��
		
		if (log.isDebugEnabled()) {
			log.debug("<<list>> : " + list);
		}
		
		//mav.addObject("getTotalById", getTotalById); //��ٱ��� ��ü�ݾ�
		//mav.addObject("allTotal",getTotalById);	//�ֹ���ǰ ��ü�ݾ�
		mav.setViewName("orderForm");	//view(jsp)�� �̸� ����
		
		return mav;
		
	}

	// ���۵� ������ ó��
	@RequestMapping(value="/itemcart/insertOrder.do", method=RequestMethod.POST)
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

		return "redirect:/itemcart/orderForm.do";
	}

	// ================ �Խ��� �� ��� ================ //
	@RequestMapping("/itemcart/orderForm.do")
	public ModelAndView process(HttpSession session, ModelAndView mav) {

		int ibh_idx=itemOrderService.getOrderNum();
		List<ItemOrderCommand> list = itemOrderService.getListOrder(ibh_idx);

		//Model�� �� �̸��� ������Ʈ�� ����ְ� el�� �����پ�
		
		mav.addObject("list", list); //��ٱ��� ������ map�� ����
		mav.setViewName("orderForm");
		mav.addObject("list",list);
		//mav�� ������ el�� �̾Ƽ� ����Ѵ� view����
		return mav;

	}
}
