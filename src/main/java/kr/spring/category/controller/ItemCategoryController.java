package kr.spring.category.controller;

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
	@ModelAttribute("ICCommand")
	public ItemCategoryCommand initCommand() {
		return new ItemCategoryCommand();
	}

	// ================ 카테고리 등록 ================ //
	// 등록 폼
	@RequestMapping(value="/item/categoryWrite.do", method=RequestMethod.GET)
	public String form() {
		return "categoryWrite";
	}

	// 전송된 데이터 처리
	@RequestMapping(value="/item/categoryWrite.do", method=RequestMethod.POST)
	public String submit(@ModelAttribute("ICCommand")
	ItemCategoryCommand itemCategoryCommand) {
		if (log.isDebugEnabled()) {
			log.debug("<<itemCategoryCommand>> : " + itemCategoryCommand);
		}
		System.out.println(itemCategoryCommand);

		// 글쓰기
		itemCategoryService.insert(itemCategoryCommand);

		// RedirectAttributes 객체는 리다이렉트 시점에 한 번만 사용되는
		// 데이터를 전송.
		// 브라우저에 데이터를 전송하지만 URI상에는 보이지 않는 숨겨진 데이터의
		// 형태로 전달

		return "redirect:/item/categorylist.do";
	}

	// ================ 카테고리 목록 ================ //
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

	//카테고리 삭제//
	@RequestMapping("/item/categoryDelete.do")
	public String submit(@RequestParam("ict_num") int ict_num) {

		if(log.isDebugEnabled()) {
			log.debug("<<ict_num>> : " + ict_num);
		}
		//글 삭제
		itemCategoryService.delete(ict_num);

		return "redirect:/item/categorylist.do";
	}
	//카테고리 수정
	@RequestMapping(value="/item/categoryUpdate.do", method=RequestMethod.GET)
	public String updateForm(@RequestParam("ict_num") int ict_num, Model model) {
		
		ItemCategoryCommand itemCategory = itemCategoryService.selectCategory(ict_num);
		List<ItemCategoryCommand> list = itemCategoryService.selectList();
		
		model.addAttribute("ICCommand",itemCategory);
		model.addAttribute("list",list);
		
		return "categoryUpdate";
	}
	// 전송된 데이터 처리
		@RequestMapping(value="/item/categoryUpdate.do", method=RequestMethod.POST)
		public String updateSubmit(@ModelAttribute("ICCommand")
		@Valid ItemCategoryCommand itemCategory,
        BindingResult result,HttpSession session, HttpServletRequest request) {
			if (log.isDebugEnabled()) {
				log.debug("<<itemCategoryCommand>> : " + itemCategory);
			}

			// 수정
			itemCategoryService.update(itemCategory);

			// RedirectAttributes 객체는 리다이렉트 시점에 한 번만 사용되는
			// 데이터를 전송.
			// 브라우저에 데이터를 전송하지만 URI상에는 보이지 않는 숨겨진 데이터의
			// 형태로 전달

			return "redirect:/item/categorylist.do";
		}

}