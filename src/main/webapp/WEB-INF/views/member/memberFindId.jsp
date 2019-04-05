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
		<form:form commandName="command" action="findId.do" id="findIdForm">
			<div class="row">
			<form:errors element="div" cssClass="error-color" />
			<ul class="col-xs-6 col-xs-offset-3 flightForm">
				<li>
					<label for="user_email">이메일</label>
					<form:input path="user_email" placeholder="이메일을 입력하세요"/>
					<form:errors path="user_email" cssClass="error-color" />
					<span id="check_email"></span>
				</li>
				<li>아이디는 <div id="output"></div> 입니다</li>
			</ul>
			</div>
			<div class="btn-submit">
				<input class="btn btn-ok" type="submit" value="확인">
				<a href="${pageContext.request.contextPath}/main/main.do" class="btn btn-default">홈으로</a>
			</div>
		</form:form>
	</div>
</div>
<!-- 중앙 컨텐츠 끝 -->
