package kr.spring.item.cart.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.item.cart.domain.ItemCartCommand;
import kr.spring.item.cart.service.ItemCartService;
import kr.spring.item.domain.ItemCommand;
import kr.spring.util.PagingUtil;

@Controller
public class ItemCartController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private ItemCartService itemCartService;
	
	private int rowCount = 10;
	private int pageCount = 10;
	
	/*// ================ �Խ��� �� ��� ================ //
		// ��� ��
		@RequestMapping(value="/item/itemWrite.do", method=RequestMethod.GET)
		public String form(@ModelAttribute("ICommand") @Valid ItemCommand itemCommand, 
				BindingResult result) {
			return "itemWrite";
		}

		// ���۵� ������ ó��
		@RequestMapping(value="/item/itemWrite.do", method=RequestMethod.POST)
			public String submit(@ModelAttribute("Icommand")
								@Valid ItemCommand itemCommand, 
								BindingResult result) {
				if (log.isDebugEnabled()) {
					log.debug("<<itemCommand>> : " + itemCommand);
				}

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

				return "redirect:/item/list.do";
			}*/
		
	
	
	
	
		//======��ٱ��� �� ���=======//
			@RequestMapping("/itemcart/cartList.do")
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
				int count = itemCartService.selectRowCount(map);
				
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
					list = itemCartService.selectCartList(user_id);
				}
				
				ModelAndView mav = new ModelAndView();
				mav.setViewName("itemCartList");
				mav.addObject("count", count);
				mav.addObject("list", list);
				mav.addObject("pagingHtml", page.getPagingHtml());
				
				return mav;
			}
			//========�Խ��� �� ��=========//
			@RequestMapping("/itemcart/cartDetail.do")
			public ModelAndView process(
					               @RequestParam("num") int num) {
				
				if(log.isDebugEnabled()) {
					log.debug("<<num>> : " + num);
				}
				
				//�ش� ���� ��ȸ�� ����
				//boardService.updateHit(num);
				
				ItemCartCommand list = itemCartService.selectCartList(num);
						              //view name    �Ӽ���  �Ӽ���
				return new ModelAndView("itemCartView","list",list);
			}

}
