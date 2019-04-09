<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- 중앙 컨텐츠 시작 -->
<div class="container write-form w_800">
	<div class="row">
		<h3 class="col-xs-12 text-center">당신을 기다리고 있는 세상에게 외쳐보세요</h3>
		<h1 class="col-xs-12 text-green text-center">"Hello World"</h1>
		<section class="text-center"><br><br></section>
		<br><br>
		<form:form commandName="command" action="login.do" id="flightForm">
			<div class="row">
			<form:errors element="div" cssClass="error-color" />
			<ul class="col-xs-6 col-xs-offset-3 flightForm">
				<li>
					<label for="user_id">아이디</label>
					<form:input path="user_id" placeholder="아이디를 입력하세요"/>
					<form:errors path="user_id" cssClass="error-color" />
					<span id="check_id"></span>
				</li>
				<li>
					<label for="user_pw">비밀번호</label>
					<span id="check_pw"></span>
					<form:password path="user_pw" placeholder="비밀번호를 입력하세요" />
					<form:errors path="user_pw" cssClass="error-color" />
				</li>
			</ul>
			</div>
			<div class="btn-submit">
				<input class="btn btn-ok" type="submit" value="로그인">
				<a href="${pageContext.request.contextPath}/member/write.do"
				class="btn btn-default">회원가입</a>
			</div>
			<section class=" text-center">
				<h3><a href="${pageContext.request.contextPath}/member/findIdForm.do">아이디</a> / <a href="${pageContext.request.contextPath}/member/findPassword.do">비밀번호</a> 가 기억나지 않나요?</h3>
			</section>
		</form:form>
	</div>
</div>
<!-- 중앙 컨텐츠 끝 -->
