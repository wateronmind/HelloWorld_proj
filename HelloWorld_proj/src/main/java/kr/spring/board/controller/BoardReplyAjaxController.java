package kr.spring.board.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.spring.board.domain.BoardReplyCommand;
import kr.spring.board.service.BoardService;

@Controller
public class BoardReplyAjaxController {
	private Logger log = Logger.getLogger(this.getClass());
	private int rowCount = 10;
	private int pageCount = 10;
	
	@Resource
	private BoardService boardService;
	
	// ´ñ±Û µî·Ï
	@RequestMapping("/board/writeReply.do")
	@ResponseBody
	public Map<String, String> writeReply(
				BoardReplyCommand boardReplyCommand, 
				HttpSession session, 
				HttpServletRequest request){
		
		if (log.isDebugEnabled()) {
			log.debug("<<boardReplyCommand>> : " + boardReplyCommand);
		}
		
		Map<String, String> map = new HashMap<String, String>();
		
		String user_id = (String)session.getAttribute("user_id");
		if (user_id == null) {
			// ·Î±×ÀÎ ¾È µÊ
			map.put("result", "logout");
		} else {
			// ipµî·Ï
			boardReplyCommand.setRe_ip(request.getRemoteAddr());
			// ´ñ±Û µî·Ï
			boardService.insertReply(boardReplyCommand);
			map.put("result", "success");
		}
		
		return map;
	}
	
}
