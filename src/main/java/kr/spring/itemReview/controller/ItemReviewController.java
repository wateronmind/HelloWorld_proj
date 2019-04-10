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

	// �ڹٺ�(Ŀ�ǵ� ��ü) �ʱ�ȭ
	@ModelAttribute("IRcommand")
	public ItemReviewCommand initCommand() {
		return new ItemReviewCommand();
	}
            
	// ��� ��
	@RequestMapping(value="/item/reviewWrite.do", method=RequestMethod.GET)
	public String form(HttpSession session, Model model) {
		String id = (String)session.getAttribute("user_id");

		ItemReviewCommand ircommand = new ItemReviewCommand();
		
		model.addAttribute("ircommand", ircommand);

		return "reviewWrite";
	}

	// ���۵� ������ ó��
	@RequestMapping(value="/item/reviewWrite.do", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,String> submit(@ModelAttribute("IRcommand")
	@Valid ItemReviewCommand itemReviewCommand,
	BindingResult result,
	HttpSession session) {
		if (log.isDebugEnabled()) {
			log.debug("<<itemReviewCommand>> : " + itemReviewCommand);
		}

		// �۾���
		itemReviewService.insertReview(itemReviewCommand);

		Map<String,String> map = new HashMap<String,String>();
		map.put("result", "success");

		return map;
	}
	//��� ���
		@RequestMapping("/item/listReply.do")
		@ResponseBody
		public Map<String,Object> getList(@RequestParam(value="pageNum",defaultValue="1") int currentPage,
				                          @RequestParam("ir_num") int ir_num){
			
			if(log.isDebugEnabled()) {
				log.debug("<<currentPage>> : " + currentPage);
				log.debug("<<ir_num>> : " + ir_num);
			}
			
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("ir_num", ir_num);
			
			//�� ���� ����
			int count = itemReviewService.selectRowCountReview(map);
			
			PagingUtil page = new PagingUtil(currentPage, count, rowCount, pageCount,null);
			
			map.put("start", page.getStartCount());
			map.put("end", page.getEndCount());
			
			List<BoardReplyCommand> list = null;
			/*if(count > 0) {
				list = boardService.selectListReply(map);
			}else {
				list = Collections.emptyList();
			}*/
			
			Map<String, Object> mapJson = new HashMap<String, Object>();
			mapJson.put("count", count);
			mapJson.put("rowCount", rowCount);
			mapJson.put("list", list);
			
			/*return mapJson;*/
			return null;
		}

}
