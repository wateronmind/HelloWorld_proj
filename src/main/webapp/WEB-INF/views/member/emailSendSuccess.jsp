<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 중앙 컨텐츠 시작 -->
<div class="container write-form w_800">
	<div class="row">
		<div class="margin-top"><h3 class="col-xs-12 text-center">이메일로 임시 비밀번호가 발송되었습니다.</h3></div>
		<br><br><br>
		<div class="btn-submit margiin-bottom">
			<input type="button" class="btn btn-ok text-center margin-bottom" value="로그인"
			onclick="location.href='${pageContext.request.contextPath}/member/login.do'">
		</div>
	</div>	
</div>	