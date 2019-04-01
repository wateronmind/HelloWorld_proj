package kr.spring.category.controller;

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

import kr.spring.category.domain.ItemCategoryCommand;
import kr.spring.category.service.ItemCategoryService;
import kr.spring.member.domain.MemberCommand;
import kr.spring.util.PagingUtil;

@Controller
public class ItemCategoryController {
	private Logger log = Logger.getLogger(this.getClass());

	@Resource
	private ItemCategoryService itemCategoryService;

	// 자바빈(커맨드 객체) 초기화
	//	@ModelAttribute("command")
	//	public ItemCommand initCommand() {
	//		return new ItemCommand();
	//	}

	// ================ 게시판 글 등록 ================ //
	// 등록 폼
	@RequestMapping(value="/item/categoryWrite.do", method=RequestMethod.GET)
	public String form(@ModelAttribute("ICCommand") @Valid ItemCategoryCommand itemCategoryCommand, 
			BindingResult result) {
		return "categoryWrite";
	}

	// 전송된 데이터 처리
	@RequestMapping(value="/item/categoryWrite.do", method=RequestMethod.POST)
	public String submit(@ModelAttribute("ICCommand")
	@Valid ItemCategoryCommand itemCategoryCommand, 
	BindingResult result) {
		if (log.isDebugEnabled()) {
			log.debug("<<itemCategoryCommand>> : " + itemCategoryCommand);
		}

		// 유효성 체크
		if (result.hasErrors()) {
			return "categoryWrite";
		}

		// 글쓰기
		itemCategoryService.insert(itemCategoryCommand);

		// RedirectAttributes 객체는 리다이렉트 시점에 한 번만 사용되는
		// 데이터를 전송.
		// 브라우저에 데이터를 전송하지만 URI상에는 보이지 않는 숨겨진 데이터의
		// 형태로 전달

		return "redirect:/item/categorylist.do";
	}

	// ================ 게시판 글 목록 ================ //
	@RequestMapping("/item/categorylist.do")
	public ModelAndView process() {
		
		List<ItemCategoryCommand> list = itemCategoryService.selectList();
		
		//Model이 들어간 이름은 리퀘스트에 담겨있고 el이 가져다씀
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin_categoryList");
		mav.addObject("list",list);
		//mav에 담은걸 el이 뽑아서 사용한다 view에서
		return mav;
	}
}