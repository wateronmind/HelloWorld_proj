package kr.spring.cart.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.cart.domain.ItemCartCommand;
import kr.spring.cart.service.ItemCartService;

@Controller
@RequestMapping("/itemcart/*")
public class ItemCartController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private ItemCartService itemCartService;
	
	
	
	// ================ ��ٱ��� �߰� ================ //
		// ��� ��
		@RequestMapping("/itemcart/cartInsert.do")
		public String insert(@ModelAttribute ItemCartCommand itemCartCommand, HttpSession session) {
			String user_id = (String)session.getAttribute("user_id");
			itemCartCommand.setUser_id(user_id);
			//��ٱ��Ͽ� ���� ��ǰ�� �ִ��� �˻�
			int count = itemCartService.selectCartDetail(itemCartCommand.getI_num(),user_id);
			//count == 0 ? itemCartService.updateCart(itemCartCommand) : itemCartService.insertCart(itemCartCommand);
			
			if(count==0) {
				//������ insert
				itemCartService.insertCart(itemCartCommand);
			}else {
				//������ update
				itemCartService.updateCart(itemCartCommand);
			}

				return "redirect:/itemcart/cartList.do";
			}
		
	
	
	
	
		//======��ٱ��� �� ���=======//
			@RequestMapping("/itemcart/cartList.do")
			public ModelAndView list(HttpSession session, ModelAndView mav) {
				//String user_id = (String)session.getAttribute("user_id"); //session�� ����� user_id
				String user_id = "dragon";
				Map<String,Object> map = 
						new HashMap<String, Object>();
				
				List<ItemCartCommand> list = itemCartService.selectCartList(user_id); //��ٱ��� ����
				int getTotalById = itemCartService.getTotalById(user_id);//��ٱ��� ��ü�ݾ� ȣ��
				
				
				map.put("list", list); //��ٱ��� ������ map�� ����
				map.put("count", list.size()); //��ٱ��� ��ǰ ����
				map.put("getTotalById", getTotalById); //��ٱ��� ��ü�ݾ�
				map.put("allTotal",getTotalById);	//�ֹ���ǰ ��ü�ݾ�
				mav.setViewName("cartList");	//view(jsp)�� �̸� ����
				mav.addObject("map",map);	//map ���� ����
				
				return mav;
			}
			
			//=======��ٱ��� ����========//
			@RequestMapping("/itemcart/cartDelete.do")
			public String delete(@RequestParam int ic_num) {
				itemCartService.deleteCart(ic_num);
				return "redirect:/itemcart/cartList.do";
			}
			
			//=======��ٱ��� ����========//
			@RequestMapping("/itemcart/cartUpdate.do")
			public String update(@RequestParam int[] ic_quan, @RequestParam int[] i_num, HttpSession session) {
				//session�� id
				String user_id = (String)session.getAttribute("user_id");
				//���ڵ��� ���� ��ŭ �ݺ��� ����
				for(int i=0; i<i_num.length;i++) {
					ItemCartCommand itemCartCommand = new ItemCartCommand();
					itemCartCommand.setUser_id(user_id);
					itemCartCommand.setIc_quan(ic_quan[i]);
					itemCartCommand.setI_num(i_num[i]);
					itemCartService.updateCart(itemCartCommand);
				}
				return "redirect:/itemcart/cartList.do";
			}
			
			
			
			/*//========��ٱ��� �� ��=========//
			@RequestMapping("cartDetail.do")
			public ModelAndView process(
					               @RequestParam ("num") int num) {
				
				if(log.isDebugEnabled()) {
					log.debug("<<num>> : " + num);
				}
				
				
				
				//ItemCartCommand list = itemCartService.selectCartList(num);
				ItemCartCommand list = null;
						              //view name    �Ӽ���  �Ӽ���
				return new ModelAndView("itemCartView","list",list);
			}*/

}
