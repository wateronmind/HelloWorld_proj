package kr.spring.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.spring.member.domain.MemberCommand;
import kr.spring.member.service.MemberService;

public class LoginCheckInterceptor extends HandlerInterceptorAdapter {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private MemberService memberService;
	
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
		}else {
			//로그인 상태
			MemberCommand member = memberService.selectMember((String)session.getAttribute("user_id"));
			if (log.isDebugEnabled()) {
				log.debug("<<session user_auth>> : "+ (Integer)session.getAttribute("user_auth"));
				log.debug("<<user_auth>> : "+ member.getUser_auth());
			}
			int user_auth=(Integer)session.getAttribute("user_auth");
			
			if(user_auth!=member.getUser_auth()) {
				session.setAttribute("user_auth", member.getUser_auth());
			}
		}
		
		
		return true; // <-- 클라이언트가 요청한 URL 호출
	}
	
}
