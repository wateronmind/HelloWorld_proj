package kr.spring.travelreview.controller;

import java.util.Collections;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.spring.board.domain.BoardCommand;
import kr.spring.board.domain.BoardReplyCommand;
import kr.spring.board.service.BoardService;
import kr.spring.travelreview.domain.TravelReviewCommand;
import kr.spring.travelreview.service.TravelReviewService;
import kr.spring.util.PagingUtil;

@Controller
public class TravelReviewController {
	private Logger log = Logger.getLogger(this.getClass());
	private int rowCount = 10;
	private int pageCount = 10;
	
	@Resource
	private TravelReviewService travelReviewService;

	// ================ 게시판 글 등록 ================ //
	// 등록 폼
	@RequestMapping(value="/review/write.do", method=RequestMethod.GET)
	public String form(HttpSession session, Model model) {

		String user_id = (String)session.getAttribute("user_id");

		TravelReviewCommand command = new TravelReviewCommand();
		command.setUser_id(user_id);

		model.addAttribute("command", command);

		return "reviewWrite";
	}

	// 전송된 데이터 처리
	@RequestMapping(value="/review/write.do", method=RequestMethod.POST)
	public String submit(@ModelAttribute("command")
	@Valid TravelReviewCommand travelReviewCommand, 
	BindingResult result, 
	HttpServletRequest request,
	RedirectAttributes redirect) {
		if (log.isDebugEnabled()) {
			log.debug("<<travelReviewCommand>> : " + travelReviewCommand);
		}

		// 유효성 체크
		if (result.hasErrors()) {
			return "reviewWrite";
		}

		// 글쓰기
		travelReviewService.insert(travelReviewCommand);

		// RedirectAttributes 객체는 리다이렉트 시점에 한 번만 사용되는
		// 데이터를 전송.
		// 브라우저에 데이터를 전송하지만 URI상에는 보이지 않는 숨겨진 데이터의
		// 형태로 전달
		redirect.addFlashAttribute("result", "success");

		return "redirect:/review/list.do";
	}
	// ================ 게시판 글 목록 ================ //
	@RequestMapping("/review/list.do")
	public ModelAndView process(
			@RequestParam(value="pageNum", defaultValue="1")
			int currentPage,
			@RequestParam(value="keyfield", defaultValue="")
			String keyfield,
			@RequestParam(value="keyword", defaultValue="")
			String keyword
			) {
		Map<String,Object> map = 
				new HashMap<String, Object>();

		map.put("keyfield", keyfield);
		map.put("keyword", keyword);

		// 총 글의 갯수 또는 검색된 글의 갯수
		int count = travelReviewService.selectRowCount(map);

		if(log.isDebugEnabled()) {
			log.debug("<<count>> : " + count);
		}

		PagingUtil page =
				new PagingUtil(keyfield, keyword, 
						currentPage, count, 
						rowCount, pageCount, "list.do");
		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());

		List<TravelReviewCommand> list = null;
		if (count > 0) {
			list = travelReviewService.selectList(map);
		}

		ModelAndView mav = new ModelAndView();
		mav.setViewName("reviewList");
		mav.addObject("count", count);
		mav.addObject("list", list);
		mav.addObject("pagingHtml", page.getPagingHtml());

		return mav;
	}
	// ================ 게시판 글 상세 ================ //
	@RequestMapping("/review/detail.do")
	public ModelAndView process(@RequestParam("tr_idx") int tr_idx) {

		if (log.isDebugEnabled()) {
			log.debug("<<tr_idx>> : " + tr_idx);
		}

		// 해당 글의 조회수 증가
		travelReviewService.updateHit(tr_idx);

		TravelReviewCommand review = travelReviewService.selectBoard(tr_idx);
		// view name   속성명     속성값
		return new ModelAndView("reviewView", "review", review);
	}
	//이미지 출력
	@RequestMapping("/review/imageView.do")
	public ModelAndView viewImage(@RequestParam("tr_idx") int tr_idx) {

		TravelReviewCommand review = 
				travelReviewService.selectBoard(tr_idx);

		ModelAndView mav = new ModelAndView();
		mav.setViewName("imageView");
		mav.addObject("imageFile", review.getTr_img());
		mav.addObject("filename", "image.jpg");

		return mav;
	}
	// ================ 게시판 글 삭제 ================ //
	@RequestMapping("/review/delete.do")
	public String submit(@RequestParam("tr_idx") int tr_idx) {

		if (log.isDebugEnabled()) {
			log.debug("<<tr_idx>> : " + tr_idx);
		}

		// 글 삭제
		travelReviewService.delete(tr_idx);

		return "redirect:/review/list.do";
	}
	// ================ 게시판 글 수정 ================ //
	// 수정 폼
	@RequestMapping(value="/review/update.do", 
			method=RequestMethod.GET)
	public String form(@RequestParam("tr_idx") int tr_idx, 
			Model model) {

		TravelReviewCommand travelReviewCommand =	travelReviewService.selectBoard(tr_idx);

		model.addAttribute("command", travelReviewCommand);

		return "reviewModify";
	}
	// 수정 폼에서 전송된 데이터 처리
	@RequestMapping(value="/review/update.do", method=RequestMethod.POST)
	public String submit(@ModelAttribute("command") 
	@Valid TravelReviewCommand reviewCommand,
	BindingResult result,
	HttpServletRequest request) {

		if (log.isDebugEnabled()) {
			log.debug("<<reviewCommand>> : " + reviewCommand);
		}

		// 데이터 유효성 체크
		if(result.hasErrors()) {
			return "reviewModify";
		}


		// 글 수정
		travelReviewService.update(reviewCommand);

		return "redirect:/review/list.do";
	}
}
