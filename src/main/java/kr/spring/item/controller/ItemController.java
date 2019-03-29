package kr.spring.item.controller;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.spring.item.domain.ItemCommand;

@Controller
public class ItemController {
	private Logger log = Logger.getLogger(this.getClass());

//	@Resource
//	private ItemService itemService;

	// �ڹٺ�(Ŀ�ǵ� ��ü) �ʱ�ȭ
//	@ModelAttribute("command")
//	public ItemCommand initCommand() {
//		return new ItemCommand();
//	}

	// ================ �Խ��� �� ��� ================ //
	// ��� ��
	@RequestMapping(value="/item/itemWrite.do")
	public String form(@ModelAttribute("ICommand") @Valid ItemCommand itemCommand, 
			BindingResult result) {
		return "itemWrite";
	}

	// ���۵� ������ ó��
	/*@RequestMapping(value="/item/itemWrite.do", method=RequestMethod.POST)
		public String submit(@ModelAttribute("command")
							@Valid ItemCommand itemCommand, 
							BindingResult result) {
			if (log.isDebugEnabled()) {
				log.debug("<<itemCommand>> : " + itemCommand);
			}

			// ��ȿ�� üũ
			if (result.hasErrors()) {
				return form();
			}

			// �۾���
			itemService.insert(itemCommand);

			// RedirectAttributes ��ü�� �����̷�Ʈ ������ �� ���� ���Ǵ�
			// �����͸� ����.
			// �������� �����͸� ���������� URI�󿡴� ������ �ʴ� ������ ��������
			// ���·� ����

			return "redirect:/item/list.do";
		}*/

}