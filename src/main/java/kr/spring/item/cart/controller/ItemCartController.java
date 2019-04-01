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
	
	/*// ================ 게시판 글 등록 ================ //
		// 등록 폼
		@RequestMapping(value="/item/itemWrite.do", method=RequestMethod.GET)
		public String form(@ModelAttribute("ICommand") @Valid ItemCommand itemCommand, 
				BindingResult result) {
			return "itemWrite";
		}

		// 전송된 데이터 처리
		@RequestMapping(value="/item/itemWrite.do", method=RequestMethod.POST)
			public String submit(@ModelAttribute("Icommand")
								@Valid ItemCommand itemCommand, 
								BindingResult result) {
				if (log.isDebugEnabled()) {
					log.debug("<<itemCommand>> : " + itemCommand);
				}

				// 유효성 체크
				if (result.hasErrors()) {
					return "itemWrite";
				}

				// 글쓰기
				itemService.insert(itemCommand);

				// RedirectAttributes 객체는 리다이렉트 시점에 한 번만 사용되는
				// 데이터를 전송.
				// 브라우저에 데이터를 전송하지만 URI상에는 보이지 않는 숨겨진 데이터의
				// 형태로 전달

				return "redirect:/item/list.do";
			}*/
		
	
	
	
	
		//======장바구니 글 목록=======//
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
				
				//총 글의 갯수 또는 검색된 글의 갯수
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
			//========게시판 글 상세=========//
			@RequestMapping("/itemcart/cartDetail.do")
			public ModelAndView process(
					               @RequestParam("num") int num) {
				
				if(log.isDebugEnabled()) {
					log.debug("<<num>> : " + num);
				}
				
				//해당 글의 조회수 증가
				//boardService.updateHit(num);
				
				ItemCartCommand list = itemCartService.selectCartList(num);
						              //view name    속성명  속성값
				return new ModelAndView("itemCartView","list",list);
			}

}
