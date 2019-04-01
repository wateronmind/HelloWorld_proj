<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- 중앙 컨텐츠 시작 -->
<div class="container">
	<div class="row">
		<h2 class="text-center text-white">당신을 기다리고 있는 세상에게 외쳐보세요</h2>
		<h1 class="text-center text-success">"Hello World"</h1>
		<form:form commandName="command" action="login.do" id="login_form">
			<form:errors element="div" cssClass="error-color" />
			<div class="col-sm-9 col-lg-9">
				<div class="form-group custom-input">
					<div class="col-sm-3 col-lg-3">
						<label for="id">아이디</label>
					</div>
					<div class="col-sm-3 col-lg-3">
						<form:input path="user_id" cssClass="form-control" />
						<span id="check_id"></span>
						<form:errors path="user_id" cssClass="error-color" />
					</div>
				</div>
				
				<div class="form-group custom-input">
					<div class="col-sm-3 col-lg-3">
						<label for="user_pw">비밀번호</label>
					</div>
					<div class="col-sm-3 col-lg-3">
						<form:password path="user_pw" cssClass="form-control" />
						<span id="check_pw"></span>
						<form:errors path="user_pw" cssClass="error-color" />
					</div>
				</div>
			</div>
			<br>
			<div class="col-sm-3 col-lg-3 custom-login-submit">
				<input class="btn btn-primary custom-submit" type="submit" value="로그인">
				<input class="btn btn-default" value="회원가입">
			</div>
		</form:form>
		<div class="text-center">
		<a>아이디</a> / <a>비밀번호</a> 가 기억나지 않나요?
		</div>
	</div>
</div>
<!-- 중앙 컨텐츠 끝 -->