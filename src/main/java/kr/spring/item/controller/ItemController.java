package kr.spring.item.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.board.domain.BoardCommand;
import kr.spring.item.domain.ItemCommand;
import kr.spring.item.service.ItemService;
import kr.spring.util.PagingUtil;

@Controller
public class ItemController {
	private Logger log = Logger.getLogger(this.getClass());

	@Resource
	private ItemService itemService;
	
	private int rowCount = 10;
	private int pageCount = 10;

	// �ڹٺ�(Ŀ�ǵ� ��ü) �ʱ�ȭ
	/*@ModelAttribute("ICommand")
	public ItemCommand initCommand() {
		return new ItemCommand();
	}*/

	// ================ (������)�Խ��� �� ��� ================ //
	// ��� ��
	@RequestMapping(value="/item/itemWrite.do", method=RequestMethod.GET)
	public String form() {
		return "itemWrite";
	}

	// ���۵� ������ ó��
	@RequestMapping(value="/item/itemWrite.do", method=RequestMethod.POST)
		public String submit(@ModelAttribute("ICommand")
							@Valid ItemCommand itemCommand, 
							BindingResult result) {
			if (log.isDebugEnabled()) {
				log.debug("<<itemCommand>> : " + itemCommand);
			}

			System.out.println(itemCommand);
			
			// ��ȿ�� üũ
			if (result.hasErrors()) {
				return "itemWrite";
			}

			// �۾���
			itemService.insert(itemCommand);

			// RedirectAttributes ��ü�� �����̷�Ʈ ������ �� ���� ���Ǵ�
			// �����͸� ����.
			// �������� �����͸� ���������� URI�󿡴� ������ �ʴ� ������ ��������
			// ���·� ����

			return "redirect:/item/itemList.do";
		}
	
	/*//======�Խ��� �� ���=======//
		@RequestMapping("/item/itemList.do")
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
			
			//�� ���� ���� �Ǵ� �˻��� ���� ����
			int count = itemService.selectRowCount(map);
			
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
				list = itemService.selectList(map);
			}
			
			ModelAndView mav = new ModelAndView();
			mav.setViewName("itemList");
			mav.addObject("count", count);
			mav.addObject("list", list);
			mav.addObject("pagingHtml", page.getPagingHtml());
			
			return mav;
		}*/
		/*//========�Խ��� �� ��=========//
		@RequestMapping("/item/itemDetail.do")
		public ModelAndView process(
				               @RequestParam("num") int num) {
			
			if(log.isDebugEnabled()) {
				log.debug("<<num>> : " + num);
			}
			
			//�ش� ���� ��ȸ�� ����
			//boardService.updateHit(num);
			
			ItemCommand list = itemService.selectList(num);
					              //view name    �Ӽ���  �Ӽ���
			return new ModelAndView("itemView","list",list);
		}*/

}