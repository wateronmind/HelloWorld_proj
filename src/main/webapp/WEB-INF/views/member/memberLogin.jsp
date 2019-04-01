<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- 중앙 컨텐츠 시작 -->
<div class="container write-form w_800">
	<div class="row">
		<h3 class="col-xs-12 text-center">당신을 기다리고 있는 세상에게 외쳐보세요</h3>
		<h1 class="col-xs-12 text-success text-center">"Hello World"</h1>
		<br><br>
		<form:form commandName="command" action="login.do" id="login_form">
			<form:errors element="div" cssClass="error-color" />
			<div class="col-xs-6 col-xs-offset-3 flightForm">
				<div class="">
					
					<div class="">
						<label for="id">아이디</label>
					</div>
					<div class="">
						<form:input path="user_id" cssClass="form-control" />
						<span id="check_id"></span>
						<form:errors path="user_id" cssClass="error-color" />
					</div>
					
				</div>
				<div class="">
					<div class="">
						<label for="user_pw">비밀번호</label>
					</div>
					<div class="">
						<form:password path="user_pw" cssClass="form-control" />
						<span id="check_pw"></span>
						<form:errors path="user_pw" cssClass="error-color" />
					</div>
				</div>
			<br>
				<div class="btn-submit">
					<input class="btn btn-ok" type="submit" value="로그인">
					<a href="${pageContext.request.contextPath}/member/write.do"
					class="btn btn-default">회원가입</a>
				</div>
			</div>
		<div class="col-xs-12 text-center">
		<a>아이디</a> / <a>비밀번호</a> 가 기억나지 않나요?
		</div>
		<br><br><br>
		</form:form>
		<br><br><br>
	</div>
</div>
<!-- 중앙 컨텐츠 끝 -->
