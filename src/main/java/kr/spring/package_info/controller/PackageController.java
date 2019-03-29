package kr.spring.package_info.controller;

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

import kr.spring.board.domain.BoardCommand;
import kr.spring.package_info.domain.PackageCommand;
import kr.spring.util.PagingUtil;

@Controller
public class PackageController {
	private Logger log = Logger.getLogger(this.getClass());
	private int rowCount = 10;
	private int pageCount = 10;
	
	/*@Resource
	private PackService packsService;*/
	
	//===============��Ű�� ��� (�ӽ÷� �̰��� �۾�)===========//
	//��� ��
	@RequestMapping(value="/package/write.do",method=RequestMethod.GET)
	public String form(HttpSession session, Model model) {
		String id = (String)session.getAttribute("user_id");
		
		PackageCommand command = new PackageCommand();
		command.setPi_id(pi_id);
		
		model.addAttribute("command",command);
		return "packageWrite";
		
	}
    //���۵� ������ ó��
	@RequestMapping(value="/package/write.do", method=RequestMethod.POST)
    public String submit(@ModelAttribute("command")
                          @Valid PackageCommand packageCommand, BindingResult result,
                          HttpServletRequest request,
                          RedirectAttributes redirect){
		if(log.isDebugEnabled()) {
			log.debug("<<packageCommand>> : " + packageCommand);
		}
	
	//������ ��ȿ�� üũ
		if(result.hasErrors()) {
			return "packageWrite";
		}
	
		
		
	
	//=====================��Ű�� �� ���===================//
	@RequestMapping("/package/list.do")
	public ModelAndView process(
			@RequestParam(value="pageNum",defaultValue="1")
			int currentPage,
			@RequestParam(value="keyfield",defaultValue="")
			String keyfield,
			@RequestParam(value="keyword",defaultValue="")
			String keyword) {
			
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("keyfield", keyfield);
			map.put("keyword", keyword);
			
			//�� ���� ���� �Ǵ� �˻��� ���� ����
			int count = packageService.selectRowCount(map);
			
			if(log.isDebugEnabled()) {
				log.debug("<<count>> : " + count);
						
			}
			PagingUtil page = new PagingUtil(keyfield,keyword,currentPage,count,rowCount,pageCount,"list.do");
			
			map.put("start", page.getStartCount());
			map.put("end", page.getEndCount());
			
			List<BoardCommand> list = null;
			if(count > 0 ) {
				 list = packageService.selectList(map);
			}
			
			ModelAndView mav = new ModelAndView();
			mav.setViewName("boardList");
			mav.addObject("count",count);
			mav.addObject("list",list);
			mav.addObject("pagingHtml",page.getPagingHtml());
			return mav;
   }
}