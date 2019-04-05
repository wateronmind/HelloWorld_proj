package kr.spring.item.controller;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.board.domain.BoardCommand;
import kr.spring.category.domain.ItemCategoryCommand;
import kr.spring.category.service.ItemCategoryService;
import kr.spring.item.domain.ItemCommand;
import kr.spring.item.service.ItemService;
import kr.spring.util.PagingUtil;

@Controller
public class ItemController {
	private Logger log = Logger.getLogger(this.getClass());

	@Resource
	private ItemService itemService;

	@Resource
	private ItemCategoryService itemCategoryService;

	private int rowCount = 9;
	private int pageCount = 10;

	// 자바빈(커맨드 객체) 초기화
	@ModelAttribute("ICommand")
	public ItemCommand initCommand() {
		return new ItemCommand();
	}
	//=======================관리자============================//
	// ================ (관리자)게시판 글 등록 ================ //
	// 등록 폼
	@RequestMapping(value="/item/itemWrite.do", method=RequestMethod.GET)
	public String form(HttpSession session, Model model) {
		String id = (String)session.getAttribute("user_id");

		ItemCommand icommand = new ItemCommand();

		List<ItemCategoryCommand> list = itemCategoryService.selectList();

		model.addAttribute("icommand", icommand);
		model.addAttribute("list", list);

		return "itemWrite";
	}

	// 전송된 데이터 처리
	@RequestMapping(value="/item/itemWrite.do", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,String> submit(@ModelAttribute("ICommand")
	@Valid ItemCommand itemCommand,
	BindingResult result,
	HttpSession session) {
		if (log.isDebugEnabled()) {
			log.debug("<<itemCommand>> : " + itemCommand);
		}

		// 글쓰기
		itemService.insert(itemCommand);
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("result", "success");

		return map;
	}
	//관리자 물품 목록
	@RequestMapping("/item/admin_itemList.do")
	public ModelAndView process(@RequestParam(value="pageNum",defaultValue="1") int currentPage,
            @RequestParam(value="keyfield",defaultValue="") String keyfield,
            @RequestParam(value="keyword",defaultValue="") String keyword) {

		Map<String,Object> map = 
				new HashMap<String, Object>();
		map.put("keyfield", keyfield);
		map.put("keyword", keyword);

		//총 글의 갯수 또는 검색된 글의 갯수
		int count = itemService.selectRowCount(map);

		if(log.isDebugEnabled()) {
			log.debug("<<count>> : " + count);
		}

		PagingUtil page = 
				new PagingUtil(keyfield,keyword,currentPage,
						count,rowCount,pageCount,"admin_itemList.do");
		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());

		List<ItemCommand> list = null;
		if(count > 0) {
			list = itemService.selectList(map);
		}

		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin_itemList");
		mav.addObject("count", count);
		mav.addObject("list", list);
		mav.addObject("pagingHtml", page.getPagingHtml());

		return mav;
	}

	//이미지 출력
	@RequestMapping("/item/imageView.do")
	public ModelAndView viewImage(@RequestParam("i_num") int i_num) {

		ItemCommand itemCommand = itemService.selectItem(i_num);
		
		if(log.isDebugEnabled()) {
			log.debug("itemCommand:"+itemCommand);
		}

		ModelAndView mav = new ModelAndView();
		mav.setViewName("imageView");
		mav.addObject("imageFile", itemCommand.getI_img());
		mav.addObject("filename", "image.jpg");

		return mav;
	}
	//==========글쓰기 이미지 업로드===========//
		@RequestMapping("/item/imageUploader.do")
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
	
	//물품메인페이지
	@RequestMapping("/item/itemMain.do")
	public ModelAndView itemMainProcess(@RequestParam(value="pageNum",defaultValue="1") int currentPage,
    @RequestParam(value="keyfield",defaultValue="") String keyfield,
    @RequestParam(value="keyword",defaultValue="") String keyword) {

		Map<String,Object> map = 
				new HashMap<String, Object>();
		map.put("keyfield", keyfield);
		map.put("keyword", keyword);

		//총 글의 갯수 또는 검색된 글의 갯수
		int count = itemService.selectRowCount(map);

		if(log.isDebugEnabled()) {
			log.debug("<<count>> : " + count);
		}

		PagingUtil page = 
				new PagingUtil(keyfield, keyword,currentPage,
						count,rowCount,pageCount,"camera.do");
		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());

		List<ItemCommand> list = null;
		if(count > 0) {
			list = itemService.selectList(map);
		}

		ModelAndView mav = new ModelAndView();
		mav.setViewName("itemMain");
		mav.addObject("count", count);
		mav.addObject("list", list);
		mav.addObject("pagingHtml", page.getPagingHtml());

		return mav;
	}
	//카테고리별 페이지
		@RequestMapping("/item/camera.do")
		public ModelAndView cameraProcess(@RequestParam(value="pageNum",defaultValue="1") int currentPage,
	    @RequestParam(value="keyfield",defaultValue="") String keyfield,
	    @RequestParam(value="keyword",defaultValue="") String keyword) {

			Map<String,Object> map = 
					new HashMap<String, Object>();
			map.put("keyfield", keyfield);
			map.put("keyword", keyword);

			//총 글의 갯수 또는 검색된 글의 갯수
			int count = itemService.selectRowCount(map);

			if(log.isDebugEnabled()) {
				log.debug("<<count>> : " + count);
			}

			PagingUtil page = 
					new PagingUtil(keyfield, keyword,currentPage,
							count,rowCount,pageCount,"camera.do");
			map.put("start", page.getStartCount());
			map.put("end", page.getEndCount());

			List<ItemCommand> list = null;
			if(count > 0) {
				list = itemService.selectList(map);
			}

			ModelAndView mav = new ModelAndView();
			mav.setViewName("camera");
			mav.addObject("count", count);
			mav.addObject("list", list);
			mav.addObject("pagingHtml", page.getPagingHtml());

			return mav;
		}
	//여행물품 수정
	@RequestMapping(value="/item/itemModify.do",method=RequestMethod.GET)
	public String form(@RequestParam("i_num") int i_num, Model model) {
		
		ItemCommand itemCommand = itemService.selectItem(i_num);//한건의 데이터를 받음
		List<ItemCategoryCommand> list = itemCategoryService.selectList();
		
		model.addAttribute("ICommand",itemCommand);
		model.addAttribute("list",list);
		
		return "itemModify";//데피니션 설정
	}
	//수정 폼에서 전송된 데이터 처리
	@RequestMapping(value="/item/itemModify.do",method=RequestMethod.POST)
	public String submit(@ModelAttribute("ICommand")@Valid ItemCommand itemCommand,
			              BindingResult result,HttpSession session, HttpServletRequest request) {
		
		if(log.isDebugEnabled()) {
			log.debug("<<itemCommand>> : " + itemCommand);
		}
		
		//글 수정
		itemService.update(itemCommand);
		//boardService.update(boardCommand);
		
		return "redirect:/item/admin_itemList.do";
	}
	//==========여행물품 글 상세===============//
	@RequestMapping("/item/itemDetail.do")
	public ModelAndView process(@RequestParam("i_num") int i_num) {
			
			//로그 찍기
			if(log.isDebugEnabled()) {
				log.debug("<<i_num>> : " + i_num);
			}
			
			//한건의 레코드를 읽어옴
			ItemCommand item = itemService.selectItem(i_num);
			                       //view name   속성명       속성값
			return new ModelAndView("itemDetail","item",item);
		}
	

	//==========여행물품 삭제============//
	@RequestMapping("/item/itemDelete.do")
	public String submit(@RequestParam("i_num") int i_num) {
		
		if(log.isDebugEnabled()) {
			log.debug("<<i_num>> : " + i_num);
		}
		//글 삭제
		itemService.delete(i_num);
		
		return "redirect:/item/admin_itemList.do";
	}
}