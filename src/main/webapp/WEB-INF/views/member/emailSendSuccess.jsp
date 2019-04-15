<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 중앙 컨텐츠 시작 -->
<div class="container write-form w_800">
	<div class="row">
		<h3 class="col-xs-12 text-center">이메일로 임시 비밀번호가 발송되었습니다.</h3>
		<br><br><br>
		<div class="btn-submit">
			<input type="button" class="btn btn-ok text-center" value="로그인"
			onclick="location.href='${pageContext.request.contextPath}/member/login.do'">
		</div>
	</div>	
</div>	