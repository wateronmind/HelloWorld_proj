<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- 중앙 컨텐츠 시작 -->
<div class="container write-form w_800">
	<div class="row">
		<h3 class="col-xs-12 text-center">가입했던 아이디와 이메일로 비밀번호를 찾을 수 있습니다</h3>
		<h3 class="col-xs-12 text-success text-center"></h3>
		<br><br>
		<form:form commandName="command" action="findPassword.do" id="flightForm">
			<div class="row">
			<form:errors element="div" cssClass="error-color" />
			<ul class="col-xs-6 col-xs-offset-3 flightForm">
				<li>
					<label for="user_id">아이디</label>
					<form:input path="user_email" placeholder="이메일을 입력하세요"/>
					<form:errors path="user_email" cssClass="error-color" />
				</li>
				<li>
					<label for="user_email">이메일</label>
					<form:input path="user_email" placeholder="이메일을 입력하세요"/>
					<form:errors path="user_email" cssClass="error-color" />
				</li>
			</ul>
			</div>
			<div class="btn-submit">
				<input class="btn btn-ok" type="submit" value="확인">
				<a href="${pageContext.request.contextPath}/member/findId.do" class="btn btn-default">아이디 찾기</a>
			</div>
		</form:form>
	</div>
</div>
<!-- 중앙 컨텐츠 끝 -->
