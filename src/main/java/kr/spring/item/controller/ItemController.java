package kr.spring.item.controller;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.spring.item.domain.ItemCommand;

@Controller
public class ItemController {
	private Logger log = Logger.getLogger(this.getClass());

//	@Resource
//	private ItemService itemService;

	// 자바빈(커맨드 객체) 초기화
//	@ModelAttribute("command")
//	public ItemCommand initCommand() {
//		return new ItemCommand();
//	}

	// ================ 게시판 글 등록 ================ //
	// 등록 폼
	@RequestMapping(value="/item/itemWrite.do")
	public String form(@ModelAttribute("ICommand") @Valid ItemCommand itemCommand, 
			BindingResult result) {
		return "itemWrite";
	}

	// 전송된 데이터 처리
	/*@RequestMapping(value="/item/itemWrite.do", method=RequestMethod.POST)
		public String submit(@ModelAttribute("command")
							@Valid ItemCommand itemCommand, 
							BindingResult result) {
			if (log.isDebugEnabled()) {
				log.debug("<<itemCommand>> : " + itemCommand);
			}

			// 유효성 체크
			if (result.hasErrors()) {
				return form();
			}

			// 글쓰기
			itemService.insert(itemCommand);

			// RedirectAttributes 객체는 리다이렉트 시점에 한 번만 사용되는
			// 데이터를 전송.
			// 브라우저에 데이터를 전송하지만 URI상에는 보이지 않는 숨겨진 데이터의
			// 형태로 전달

			return "redirect:/item/list.do";
		}*/

}