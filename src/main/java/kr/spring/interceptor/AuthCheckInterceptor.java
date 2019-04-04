package kr.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthCheckInterceptor extends HandlerInterceptorAdapter {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response,
			Object handler) throws Exception {
		
		if (log.isDebugEnabled()) {
			log.debug("<<AuthCheckInterceptor진입>>");
		}
		
		// 권한 검사
		HttpSession session = request.getSession();
		
		if ((Integer)session.getAttribute("user_auth") !=2) {
			//가이드가 아닌 경우
			response.sendRedirect(request.getContextPath()+"/member/login.do");
			return false; // <-- 클라이언트가 요청한 URL 미호출
		}
		
		
		return true; // <-- 클라이언트가 요청한 URL 호출
	}
	
}
