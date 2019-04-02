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

	// �ڹٺ�(Ŀ�ǵ� ��ü) �ʱ�ȭ
	//	@ModelAttribute("command")
	//	public ItemCommand initCommand() {
	//		return new ItemCommand();
	//	}

	// ================ �Խ��� �� ��� ================ //
	// ��� ��
	@RequestMapping(value="/itemcart/orderForm.do", method=RequestMethod.GET)
	public String form(@ModelAttribute("Command") @Valid ItemOrderCommand itemOrderCommand, 
			BindingResult result) {
		return "orderForm";
	}

	// ���۵� ������ ó��
	@RequestMapping(value="/itemcart/orderForm.do", method=RequestMethod.POST)
	public String submit(@ModelAttribute("Command")
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
	@RequestMapping("/itemcart/orderCheck.do")
	public ModelAndView process() {

		List<ItemOrderCommand> list = itemOrderService.getListOrder();

		//Model�� �� �̸��� ������Ʈ�� ����ְ� el�� �����پ�
		ModelAndView mav = new ModelAndView();
		mav.setViewName("orderCheck");
		mav.addObject("list",list);
		//mav�� ������ el�� �̾Ƽ� ����Ѵ� view����
		return mav;

	}
}
