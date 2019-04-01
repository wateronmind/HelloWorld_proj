package kr.spring.category.controller;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.spring.category.domain.ItemCategoryCommand;
import kr.spring.category.service.ItemCategoryService;
  
@Controller
public class ItemCategoryController {
	private Logger log = Logger.getLogger(this.getClass());

	@Resource
	private ItemCategoryService itemCategoryService;

	// �ڹٺ�(Ŀ�ǵ� ��ü) �ʱ�ȭ
//	@ModelAttribute("command")
//	public ItemCommand initCommand() {
//		return new ItemCommand();
//	}
   
	// ================ �Խ��� �� ��� ================ //
	// ��� ��
	@RequestMapping(value="/item/categoryWrite.do", method=RequestMethod.GET)
	public String form(@ModelAttribute("ICCommand") @Valid ItemCategoryCommand itemCategoryCommand, 
			BindingResult result) {
		return "categoryWrite";
	}
  
	// ���۵� ������ ó��
	@RequestMapping(value="/item/categoryWrite.do", method=RequestMethod.POST)
		public String submit(@ModelAttribute("ICCommand")
							@Valid ItemCategoryCommand itemCategoryCommand, 
							BindingResult result) {
			if (log.isDebugEnabled()) {
				log.debug("<<itemCategoryCommand>> : " + itemCategoryCommand);
			}

			// ��ȿ�� üũ
			if (result.hasErrors()) {
				return "categoryWrite";
			}

			// �۾���
			itemCategoryService.insert(itemCategoryCommand);

			// RedirectAttributes ��ü�� �����̷�Ʈ ������ �� ���� ���Ǵ�
			// �����͸� ����.
			// �������� �����͸� ���������� URI�󿡴� ������ �ʴ� ������ ��������
			// ���·� ����

			return "redirect:/item/Categorylist.do";
		}

}