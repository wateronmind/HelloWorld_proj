package kr.spring.item.controller;

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

	// 자바빈(커맨드 객체) 초기화
	@ModelAttribute("ICommand")
	public ItemCommand initCommand() {
		return new ItemCommand();
	}

	
	//=======================관리자============================//
	// ================ (관리자)게시판 글 등록 ================ //
	// 등록 폼
	@RequestMapping(value="/item/itemWrite.do", method=RequestMethod.GET)
	public String form(HttpSession session, Model model) {
		String id = (String)session.getAttribute("user_id");
		
		ItemCommand icommand = new ItemCommand();
		
		List<ItemCategoryCommand> list = itemCategoryService.selectList();
		
		model.addAttribute("icommand", icommand);
		model.addAttribute("list", list);
		
		return "itemWrite";
	}

	// 전송된 데이터 처리
	@RequestMapping(value="/item/itemWrite.do", method=RequestMethod.POST)
		public String submit(@ModelAttribute("ICommand")
							@Valid ItemCommand itemCommand,
							BindingResult result,
							   HttpSession session) {
			if (log.isDebugEnabled()) {
				log.debug("<<itemCommand>> : " + itemCommand);
			}

			
			// 글쓰기
			itemService.insert(itemCommand);

			// RedirectAttributes 객체는 리다이렉트 시점에 한 번만 사용되는
			// 데이터를 전송.
			// 브라우저에 데이터를 전송하지만 URI상에는 보이지 않는 숨겨진 데이터의
			// 형태로 전달

			return "redirect:/item/admin_itemList.do";
		}
	
<<<<<<< HEAD
	//======게시판 글 목록(관리자)=======//
=======
	//======관리자 아이템 목록=======//
>>>>>>> d595646fbb6d79728a5686ce5fe99fc806d8d6fa
	@RequestMapping("/item/admin_itemList.do")
		public ModelAndView process(@RequestParam(value="pageNum",defaultValue="1")
		int currentPage,
		@RequestParam(value="keyword",defaultValue="")
		String keyword) {
	
	Map<String,Object> map = 
			new HashMap<String, Object>();
	map.put("keyword", keyword);
	
	//총 글의 갯수 또는 검색된 글의 갯수
	int count = itemService.selectRowCount(map);
	
	if(log.isDebugEnabled()) {
		log.debug("<<count>> : " + count);
	}
	
	PagingUtil page = 
			new PagingUtil(null,keyword,currentPage,
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
	
	//이미지 출력
		@RequestMapping("/item/imageView.do")
		public ModelAndView viewImage(@RequestParam("i_num") int num) {
			
			ItemCommand itemCommand = itemService.selectList(num);
			
			ModelAndView mav = new ModelAndView();
			mav.setViewName("imageView");
			mav.addObject("imageFile", itemCommand.getUpload());
			mav.addObject("filename", itemCommand.getFilename());
			
			return mav;
		}
<<<<<<< HEAD
	
	
	//카테고리 카메라
	@RequestMapping("/item/camera.do")
	public ModelAndView cameraProcess(
			@RequestParam(value="pageNum",defaultValue="1")
			int currentPage,
			@RequestParam(value="keyword",defaultValue="")
			String keyword) {
		
		Map<String,Object> map = 
				new HashMap<String, Object>();
		map.put("keyword", keyword);
		
		List<ItemCategoryCommand> list1 = itemCategoryService.selectList();
		
		//총 글의 갯수 또는 검색된 글의 갯수
		int count = itemService.selectRowCount(map);
		
		if(log.isDebugEnabled()) {
			log.debug("<<count>> : " + count);
		}
		
		PagingUtil page = 
				new PagingUtil(null,keyword,currentPage,
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
		mav.addObject("list1", list1);
		mav.addObject("pagingHtml", page.getPagingHtml());
		
		return mav;
	}
		/*//========게시판 글 상세=========//
=======
		
	//=======================관리자 끝============================//
	
	
	
	
	
	
	
	
	
	//========게시판 글 목록=========//
	
	
	
	//========게시판 글 상세=========//
>>>>>>> d595646fbb6d79728a5686ce5fe99fc806d8d6fa
		@RequestMapping("/item/itemDetail.do")
		public ModelAndView detail(
				               @RequestParam(value="i_num", defaultValue="1") int i_num) {
			
			if(log.isDebugEnabled()) {
				log.debug("<<i_num>> : " + i_num);
			}
			
			//해당 글의 조회수 증가
			//boardService.updateHit(num);
			
			ItemCommand item = itemService.selectItem(i_num);
					              //view name    속성명  속성값
			return new ModelAndView("itemDetail","item",item);
		}

}