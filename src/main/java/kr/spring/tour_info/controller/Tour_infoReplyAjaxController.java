package kr.spring.tour_info.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.spring.tour.service.Tour_infoService;
import kr.spring.tour_info.domain.Tour_infoReplyCommand;

@Controller
public class Tour_infoReplyAjaxController {
	private Logger log = Logger.getLogger(this.getClass());
	private int rowCount = 10;
	private int pageCount = 10;
	
	@Resource
	private Tour_infoService tour_infoService;
	
	//��� ���
	@RequestMapping("/tour_info/writeReply.do")
	@ResponseBody
	public Map<String, String> writeReply(Tour_infoReplyCommand tour_infoReplyCommand,HttpSession session,HttpServletRequest request){
		if(log.isDebugEnabled()) {
			log.debug("<<tour_infoReplyCommand>> : " + tour_infoReplyCommand);
		}
		Map<String,String> map = new HashMap<String, String>();
		
		//�α��� ���� üũ 
		String user_id = (String)session.getAttribute("user_id");
		if(user_id==null) {
			//�α��� �ȵ�
			map.put("result", "logout");
		}else {
			//��� ���
			tour_infoService.insertReply(tour_infoReplyCommand);
			map.put("result", "success");
		}
		return map;
	}
			
	

}
