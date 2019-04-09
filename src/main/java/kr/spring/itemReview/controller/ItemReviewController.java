package kr.spring.itemReview.controller;

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
import org.springframework.web.bind.annotation.ResponseBody;

import kr.spring.item.domain.ItemCommand;
import kr.spring.item.service.ItemService;
import kr.spring.itemReview.domain.ItemReviewCommand;
import kr.spring.itemReview.service.ItemReviewService;
    
@Controller
public class ItemReviewController {
	private Logger log = Logger.getLogger(this.getClass());
	private int rowCount = 10;
	private int pageCount = 10;

	@Resource
	private ItemReviewService itemReviewService;
	
	@Resource
	private ItemService itemService;

	// 자바빈(커맨드 객체) 초기화
	@ModelAttribute("IRcommand")
	public ItemReviewCommand initCommand() {
		return new ItemReviewCommand();
	}
            
	// 등록 폼
	@RequestMapping(value="/item/reviewWrite.do", method=RequestMethod.GET)
	public String form(HttpSession session, Model model) {
		String id = (String)session.getAttribute("user_id");

		ItemReviewCommand ircommand = new ItemReviewCommand();
		
		model.addAttribute("ircommand", ircommand);

		return "reviewWrite";
	}

	// 전송된 데이터 처리
	@RequestMapping(value="/item/reviewWrite.do", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,String> submit(@ModelAttribute("IRcommand")
	@Valid ItemReviewCommand itemReviewCommand,
	BindingResult result,
	HttpSession session) {
		if (log.isDebugEnabled()) {
			log.debug("<<itemReviewCommand>> : " + itemReviewCommand);
		}

		// 글쓰기
		itemReviewService.insertReview(itemReviewCommand);

		Map<String,String> map = new HashMap<String,String>();
		map.put("result", "success");

		return map;
	}


}
