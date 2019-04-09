<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/findId.js"></script>
<!-- 중앙 컨텐츠 시작 -->
<div class="container write-form w_800">
	<div class="row">
		<h3 class="col-xs-12 text-center">가입했던 이메일로 아이디를 찾을 수 있습니다</h3>
		<h3 class="col-xs-12 text-success text-center"></h3>
		<br><br>
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
				<li class="text-center"><label>아이디는 <span id="output"></span> 입니다</label></li>
			</ul>
			</div>
			<div class="btn-submit">
				<input class="btn btn-ok" type="submit" value="확인">
				<a href="${pageContext.request.contextPath}/member/findPassword.do" class="btn btn-default">비밀번호 찾기</a>
			</div>
		</form>
	</div>
</div>
<!-- 중앙 컨텐츠 끝 -->
