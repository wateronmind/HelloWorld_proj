package kr.spring.tour_info.controller;

import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.spring.board.domain.BoardCommand;
import kr.spring.tour_info.domain.Tour_infoCommand;
import kr.spring.tour_info.service.Tour_infoService;
import kr.spring.util.PagingUtil;

@Controller
public class Tour_infoController {
	private Logger log = Logger.getLogger(this.getClass());
	private int rowCount = 10;
	private int pageCount = 10;
	
	@Resource
	private Tour_infoService tour_infoService;

	//================투어 게시판 글 등록 ==================//
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
    // 등록 데이터 전송
	@RequestMapping(value="/tour_info/write.do",method=RequestMethod.POST)
	public String submit(@ModelAttribute("command")@Valid Tour_infoCommand tour_infoCommand, BindingResult result,
			                                           HttpServletRequest request,
			                                            RedirectAttributes redirect) {
		//로그 처리
		if(log.isDebugEnabled()) {
			log.debug("<<memberCommand>>: " + tour_infoCommand);
		}
		
		/*//데이터 유효성 체크
		if(result.hasErrors()) {//에러 발생시 폼으로
			return "tour_infoWrite";
		}*/
		//등록하기
		tour_infoService.insert(tour_infoCommand);
		
		redirect.addFlashAttribute("result","success");
		
		return "redirect:/main/main.do";
	}
	
	//======================투어 글 목록========================//
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
		           
		           //글의 개수 또는 검색된 글의 개수
		           int count = tour_infoService.selectRowCount(map);
		           if(log.isDebugEnabled()) {
		   			log.debug("<<count>> : " + count);
		   		}
		           //페이징 처리
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
		   		
		   	 if(log.isDebugEnabled()) {
		   			log.debug("<<list>> : " + list);
		   		}
		   		
	          ModelAndView mav = new ModelAndView();
	          mav.setViewName("tour_infoList");
	          mav.addObject("count",count);
	          mav.addObject("list", list);
	  	    	mav.addObject("pagingHtml", page.getPagingHtml());
	  		
	  		return mav; 
	}
 	//==============게시판 글 상세==================//
	@RequestMapping("/tour_info/detail.do")
	public ModelAndView process(@RequestParam("ti_id") int ti_id) {
		//로그 
		if(log.isDebugEnabled()) {
			log.debug("<<ti_id>> : " + ti_id);
		}
	//한 건 읽기
	Tour_infoCommand tour_info = tour_infoService.selectTour_info(ti_id);
	                                    //뷰 네임        , 속성명    , 속성값
         	return new ModelAndView("tour_infoDetail","tour_info",tour_info);
}
	//이미지 출력
		@RequestMapping("/tour_info/imageView.do")
		public ModelAndView viewImage(@RequestParam("ti_id") int ti_id) {
			
			
			if(log.isDebugEnabled()) {
				log.debug("<<ti_id>> : " + ti_id);
			}
			
			Tour_infoCommand tour_info = tour_infoService.selectTour_info(ti_id);
			
			if(log.isDebugEnabled()) {
				log.debug("<<tour_info>> : " + tour_info);
			}
			
			ModelAndView mav = new ModelAndView();
			mav.setViewName("imageView");
			mav.addObject("imageFile", tour_info.getUploadfile());
			mav.addObject("filename", tour_info.getTi_img());
			
			return mav;
		}
	//==========글쓰기 이미지 업로드===========//
		@RequestMapping("/tour_info/imageUploader.do")
		public void uploadImage(MultipartFile file,HttpServletRequest request,
				                 HttpServletResponse response,HttpSession session)throws Exception{
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			
			//업로드할 폴더 경로
			String realFolder = session.getServletContext().getRealPath("/resources/image_upload");
			
			//업로드할 파일 이름
			String org_filename = file.getOriginalFilename();
			String str_filename = System.currentTimeMillis()+org_filename; //시간차에 따라 이름이 달라져서 겹치지않음
			
			if(log.isDebugEnabled()) {
				log.debug("<<원본 파일명>> : " + org_filename);
				log.debug("<<저장할 파일명>> : " + str_filename);
			}
			
			String filepath = realFolder + "\\" + str_filename;
			
			File f = new File(filepath);
			if(log.isDebugEnabled()) {
				log.debug("<<파일 경로>> : " + filepath);
			}
			
			//지정한 경로에 파일을 저장
			file.transferTo(f);
			
			out.println(request.getContextPath()+"/resources/image_upload/"+str_filename);
			out.close();
		}
		//==========================글 삭제=============================//
		@RequestMapping("/tour_info/delete.do")
		public String submit(@RequestParam("ti_id") int ti_id) {
			if(log.isDebugEnabled()) {
				log.debug("<<ti_id>>:"+ ti_id);
			}
			//글 삭제
			tour_infoService.delete(ti_id);
			
			return "redirect:/tour_info/list.do";
		}
		
		
		//=========================글 수정===========================//
	/*	@RequestMapping(value="/tour_info/update.do",method=RequestMethod.GET)
		public String form(@RequestParam("ti_id") int ti_id, Model model) {
			Tour_infoCommand tour_infoCommand = tour_infoService.selectTour_info(ti_id);
			model.addAttribute("command",tour_infoCommand);
			return "tour_infoModify";
		}
		//수정 폼 데이터 처리
		@RequestMapping(value="/tour_info/update.do", method=RequestMethod.POST)
		public String submit(@ModelAttribute("command")@Valid Tour_infoCommand tour_infoCommand,
							BindingResult result) {
			
			if (log.isDebugEnabled()) {
				log.debug("<<Tour_infoCommand>> : " + tour_infoCommand);
			}
		//데이터 유효성
			if(result.hasErrors()) {
				return "tour_infoModify";
			}
			
		//수정
			tour_infoService.update(tour_infoCommand);*/
   /*}*/
  
}