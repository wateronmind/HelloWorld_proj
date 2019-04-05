package kr.spring.tour_info.controller;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.spring.tour.service.Tour_infoService;
import kr.spring.tour_info.domain.Tour_infoCommand;
import kr.spring.util.PagingUtil;

@Controller
public class Tour_infoController {
	private Logger log = Logger.getLogger(this.getClass());
	private int rowCount = 10;
	private int pageCount = 10;
	
	@Resource
	private Tour_infoService tour_infoService;

	//================���� �Խ��� �� ��� ==================//
	@ModelAttribute("command")
	public Tour_infoCommand initCommand() {
		return new Tour_infoCommand();
	}
	
	@RequestMapping(value="/tour_info/write.do",method=RequestMethod.GET)
	public String form(HttpSession session, Model model) {
		String user_id = (String)session.getAttribute("user_id");
		
		Tour_infoCommand command = new Tour_infoCommand();
		
		command.setUser_id(user_id);
		
		model.addAttribute("command", command);
		
		return "tour_infoWrite";
	}
    // ��� ������ ����
	@RequestMapping(value="/tour_info/write.do",method=RequestMethod.POST)
	public String submit(@ModelAttribute("command")@Valid Tour_infoCommand tour_infoCommand, BindingResult result,
			                                           HttpServletRequest request,
			                                            RedirectAttributes redirect) {
		//�α� ó��
		if(log.isDebugEnabled()) {
			log.debug("<<memberCommand>>: " + tour_infoCommand);
		}
		
		/*//������ ��ȿ�� üũ
		if(result.hasErrors()) {//���� �߻��� ������
			return "tour_infoWrite";
		}*/
		//����ϱ�
		tour_infoService.insert(tour_infoCommand);
		
		redirect.addFlashAttribute("result","success");
		
		return "redirect:/main/main.do";
	}
	
	//======================���� �� ���========================//
	@RequestMapping("/tour_info/list.do")
	public ModelAndView process(
			            @RequestParam(value="pageNum", defaultValue="1")
		                int currentPage,
		                @RequestParam(value="keyfield", defaultValue="")
			            String keyfield,
			            @RequestParam(value="keyword", defaultValue="")
			            String keyword
			            ) {
		           Map<String,Object> map = new HashMap<String,Object>();
		           
		           map.put("keyfield", keyfield);
		           map.put("keyword", keyword);
		           
		           //���� ���� �Ǵ� �˻��� ���� ����
		           int count = tour_infoService.selectRowCount(map);
		           if(log.isDebugEnabled()) {
		   			log.debug("<<count>> : " + count);
		   		}
		           //����¡ ó��
		           PagingUtil page =
		   				new PagingUtil(keyfield, keyword, 
		   						currentPage, count, 
		   						rowCount, pageCount, "list.do");
		   		map.put("start", page.getStartCount());
		   		map.put("end", page.getEndCount());
		   		
		   		List<Tour_infoCommand> list = null;
		   		if (count > 0) {
		   			list = tour_infoService.selectList(map);
		   		} 
	          ModelAndView mav = new ModelAndView();
	          mav.setViewName("tour_infoList");
	          mav.addObject("count",count);
	          mav.addObject("list", list);
	  	    	mav.addObject("pagingHtml", page.getPagingHtml());
	  		
	  		return mav; 
	}	
}
