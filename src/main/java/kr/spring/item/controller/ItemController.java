package kr.spring.item.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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

import kr.spring.board.domain.BoardCommand;
import kr.spring.category.domain.ItemCategoryCommand;
import kr.spring.category.service.ItemCategoryService;
import kr.spring.item.domain.ItemCommand;
import kr.spring.item.service.ItemService;
import kr.spring.util.PagingUtil;

@Controller
public class ItemController {
	private Logger log = Logger.getLogger(this.getClass());

	@Resource
	private ItemService itemService;

	@Resource
	private ItemCategoryService itemCategoryService;

	private int rowCount = 9;
	private int pageCount = 10;

	// �ڹٺ�(Ŀ�ǵ� ��ü) �ʱ�ȭ
	@ModelAttribute("ICommand")
	public ItemCommand initCommand() {
		return new ItemCommand();
	}
	//=======================������============================//
	// ================ (������)�Խ��� �� ��� ================ //
	// ��� ��
	@RequestMapping(value="/item/itemWrite.do", method=RequestMethod.GET)
	public String form(HttpSession session, Model model) {
		String id = (String)session.getAttribute("user_id");

		ItemCommand icommand = new ItemCommand();

		List<ItemCategoryCommand> list = itemCategoryService.selectList();

		model.addAttribute("icommand", icommand);
		model.addAttribute("list", list);

		return "itemWrite";
	}

	// ���۵� ������ ó��
	@RequestMapping(value="/item/itemWrite.do", method=RequestMethod.POST)
	public String submit(@ModelAttribute("ICommand")
	@Valid ItemCommand itemCommand,
	BindingResult result,
	HttpSession session) {
		if (log.isDebugEnabled()) {
			log.debug("<<itemCommand>> : " + itemCommand);
		}


		// �۾���
		itemService.insert(itemCommand);

		return "redirect:/item/admin_itemList.do";
	}
	//������ ��ǰ ���
	@RequestMapping("/item/admin_itemList.do")
	public ModelAndView process(@RequestParam(value="pageNum",defaultValue="1") int currentPage,
            @RequestParam(value="keyfield",defaultValue="") String keyfield,
            @RequestParam(value="keyword",defaultValue="") String keyword) {

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
						count,rowCount,pageCount,"admin_itemList.do");
		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());

		List<ItemCommand> list = null;
		if(count > 0) {
			list = itemService.selectList(map);
		}

		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin_itemList");
		mav.addObject("count", count);
		mav.addObject("list", list);
		mav.addObject("pagingHtml", page.getPagingHtml());

		return mav;
	}

	//�̹��� ���
	@RequestMapping("/item/imageView.do")
	public ModelAndView viewImage(@RequestParam("i_num") int i_num) {

		ItemCommand itemCommand = itemService.selectItem(i_num);

		ModelAndView mav = new ModelAndView();
		mav.setViewName("imageView");
		mav.addObject("imageFile", itemCommand.getI_img());
		mav.addObject("filename", itemCommand.getFilename());

		return mav;
	}
	//ī�װ� ī�޶�
	@RequestMapping("/item/camera.do")
	public ModelAndView cameraProcess(@RequestParam(value="pageNum",defaultValue="1") int currentPage,
    @RequestParam(value="keyfield",defaultValue="") String keyfield,
    @RequestParam(value="keyword",defaultValue="") String keyword) {

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
				new PagingUtil(keyfield, keyword,currentPage,
						count,rowCount,pageCount,"camera.do");
		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());

		List<ItemCommand> list = null;
		if(count > 0) {
			list = itemService.selectList(map);
		}

		ModelAndView mav = new ModelAndView();
		mav.setViewName("camera");
		mav.addObject("count", count);
		mav.addObject("list", list);
		mav.addObject("pagingHtml", page.getPagingHtml());

		return mav;
	}
	//���๰ǰ ����
	@RequestMapping(value="/item/itemModify.do",method=RequestMethod.GET)
	public String form(@RequestParam("i_num") int i_num, Model model) {
		
		ItemCommand itemCommand = itemService.selectItem(i_num);//�Ѱ��� �����͸� ����
		
		model.addAttribute("ICommand",itemCommand);
		
		
		return "itemModify";//���Ǵϼ� ����
	}
	//���� ������ ���۵� ������ ó��
	@RequestMapping(value="/item/itemModify.do",method=RequestMethod.POST)
	public String submit(@ModelAttribute("ICommand")@Valid ItemCommand itemCommand,
			              BindingResult result,HttpSession session, HttpServletRequest request) {
		
		if(log.isDebugEnabled()) {
			log.debug("<<itemCommand>> : " + itemCommand);
		}
		
		//�� ����
		itemService.update(itemCommand);
		//boardService.update(boardCommand);
		
		return "redirect:/item/admin_itemList.do";
	}
	//==========�Ի��� �� ��===============//
	@RequestMapping("/item/itemDetail.do")
	public ModelAndView process(@RequestParam("i_num") int i_num) {
			
			//�α� ���
			if(log.isDebugEnabled()) {
				log.debug("<<i_num>> : " + i_num);
			}
			
			//�Ѱ��� ���ڵ带 �о��
			ItemCommand item = itemService.selectItem(i_num);
			                       //view name   �Ӽ���       �Ӽ���
			return new ModelAndView("itemDetail","item",item);
		}
	

}