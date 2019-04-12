package kr.spring.itemReview.controller;

import java.util.Collections;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.board.domain.BoardReplyCommand;
import kr.spring.item.domain.ItemCommand;
import kr.spring.item.service.ItemService;
import kr.spring.itemReview.domain.ItemReviewCommand;
import kr.spring.itemReview.service.ItemReviewService;
import kr.spring.util.PagingUtil;
    
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
		//String id = (String)session.getAttribute("user_id");
		ItemReviewCommand ircommand = new ItemReviewCommand();
		
		model.addAttribute("ircommand", ircommand);

		return "reviewWrite";
	}

	// 전송된 데이터 처리
	@RequestMapping(value="/item/reviewWrite.do", method=RequestMethod.POST)
	@ResponseBody
	public String submit(@ModelAttribute("IRcommand")
	@Valid ItemReviewCommand itemReviewCommand,
	BindingResult result,
	HttpSession session) {
		if (log.isDebugEnabled()) {
			log.debug("<<itemReviewCommand>> : " + itemReviewCommand);
		}

		// 글쓰기
		itemReviewService.insertReview(itemReviewCommand);
		
		return "redirect:/item/reviewList.do";
	}
	//댓글 목록
		@RequestMapping("/item/reviewList.do")
		@ResponseBody
		public ModelAndView getList(@RequestParam(value="pageNum",defaultValue="1") int currentPage){
			
			if(log.isDebugEnabled()) {
				log.debug("<<currentPage>> : " + currentPage);
			}
			
			Map<String,Object> map = new HashMap<String, Object>();
			
			//총 글의 갯수
			int count = itemReviewService.selectRowCountReview(map);
			
			PagingUtil page = new PagingUtil(currentPage, count, rowCount, pageCount,"reviewList.do");
			
			map.put("start", page.getStartCount());
			map.put("end", page.getEndCount());
			
			List<ItemReviewCommand> listr = null;
			if(count > 0) {
				listr = itemReviewService.selectListReview(map);
			}
			
			ModelAndView mav = new ModelAndView();
			mav.setViewName("reviewList");
			mav.addObject("count", count);
			mav.addObject("listr", listr);
			mav.addObject("pagingHtml", page.getPagingHtml());
			
			return mav;
		}

}
