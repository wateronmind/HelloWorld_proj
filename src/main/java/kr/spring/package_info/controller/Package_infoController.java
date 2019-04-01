/*package kr.spring.package_info.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.board.domain.BoardCommand;
import kr.spring.package_info.domain.Package_infoCommand;
import kr.spring.package_info.service.Package_infoService;
import kr.spring.util.PagingUtil;

@Controller
public class Package_infoController {
	private Logger log = Logger.getLogger(this.getClass());
	private int rowCount = 10;
	private int pageCount = 10;

	@Resource
	private Package_infoService package_infoService;

	//================게시판 글 등록=======================//
	//등록 폼
	@RequestMapping(value="/package/write.do",method=RequestMethod.GET)
	public String form(HttpSession session,Model model) {

		String id = (String)session.getAttribute("user_id");

		Package_infoCommand command = new Package_infoCommand();
		command.setId(id);

		model.addAttribute("command",command);
		return "boardWrite";
	}
	
	//==========게시판 글 목록===========//
		@RequestMapping("/board/list.do")
		public ModelAndView process(@RequestParam(value="pageNum",defaultValue="1") int currentPage,
				                   @RequestParam(value="keyfield",defaultValue="") String keyfield,
				                   @RequestParam(value="keyword",defaultValue="") String keyword) {
			
			Map<String,Object> map = new HashMap<String,Object>();//map구조로 키필드와 키워드를 넣어준다
			map.put("keyfield", keyfield);
			map.put("keyword", keyword);
			
			//총 글의 갯수 또는 검색된 글의 갯수
			int count = Package_infoService.selectRowCount(map);
			
			if(log.isDebugEnabled()) {
				log.debug("<<count>> : " + count);
			}
			
			//페이징 처리
			PagingUtil page = new PagingUtil(keyfield, keyword, currentPage, count, rowCount,pageCount,"list.do");
			map.put("start", page.getStartCount());
			map.put("end", page.getEndCount());
			
			List <Package_infoCommand> list = null;
			if(count > 0) {
				list = package_infoService.selectList(map);
			}
			
			ModelAndView mav = new ModelAndView();//뷰처리
			mav.setViewName("package_infoList");//데피니션 설정 지정
			mav.addObject("count", count);
			mav.addObject("list", list);
			mav.addObject("pagingHtml", page.getPagingHtml());
			
			return mav;
		}
	
}
*/