package kr.spring.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginCheckInterceptor extends HandlerInterceptorAdapter {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response,
			Object handler) throws Exception {
		
		if (log.isDebugEnabled()) {
			log.debug("<<LoginCheckInterceptor진입>>");
		}
		
		// 로그인 여부 검사
		HttpSession session = request.getSession();
		
		if (session.getAttribute("user_id") == null) {
			// 로그인이 되지 않은 경우
			response.sendRedirect(request.getContextPath()+"/member/login.do");
			return false; // <-- 클라이언트가 요청한 URL 미호출
		}
		
		if ((Integer)session.getAttribute("user_auth") != 2) {
			// 관리자 권한이 아닐 때
			RequestDispatcher dispatcher =
					request.getRequestDispatcher(
							"/WEB-INF/views/common/notice.jsp");
			dispatcher.forward(request, response);
			return false;
		}
		
		return true; // <-- 클라이언트가 요청한 URL 호출
	}
	
}
