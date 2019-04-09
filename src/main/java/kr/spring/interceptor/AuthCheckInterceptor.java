package kr.spring.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.spring.member.service.MemberService;

public class AuthCheckInterceptor extends HandlerInterceptorAdapter {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private MemberService memberService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response,
			Object handler) throws Exception {
		
		if (log.isDebugEnabled()) {
			log.debug("<<AuthCheckInterceptor����>>");
		}
		
		// ���� �˻�
		HttpSession session = request.getSession();
		
		if ((Integer)session.getAttribute("user_auth") !=2) {
			//���̵尡 �ƴ� ���
			response.sendRedirect(request.getContextPath()+"/member/login.do");
			return false; // <-- Ŭ���̾�Ʈ�� ��û�� URL ��ȣ��
		}
		
		
		return true; // <-- Ŭ���̾�Ʈ�� ��û�� URL ȣ��
	}
	
}
