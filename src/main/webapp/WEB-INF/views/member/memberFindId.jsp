<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/findId.js"></script>
<!-- 중앙 컨텐츠 시작 -->
<div class="container write-form w_800">
	<div class="row">
		<section><br><br><br></section>
		<h3 class="col-xs-12 text-center">가입했던 이메일로 아이디를 찾을 수 있습니다</h3>
		<section><br><br><br><br><br><br><br></section>
		<form id="findIdForm">
			<div class="row">
			<form:errors element="div" cssClass="error-color" />
			<ul class="col-xs-6 col-xs-offset-3 flightForm">
				<li>
					<label for="user_email">이메일</label>
					<input type="email" name="user_email" id="user_email" placeholder="이메일을 입력하세요"/>
					<form:errors path="user_email" cssClass="error-color" />
					<span id="check_email"></span>
				</li>
				<li class="text-center" id="output"></li>
			</ul>
			</div>
			<div class="btn-submit">
				<input class="btn btn-ok" type="submit" value="확인">
				<input type="button" value="로그인" class="btn btn-default" 
				onclick="location.href='${pageContext.request.contextPath}/member/login.do'">
			</div>
		</form>
		<section><br><br><br></section>
	</div>
</div>
<!-- 중앙 컨텐츠 끝 -->
