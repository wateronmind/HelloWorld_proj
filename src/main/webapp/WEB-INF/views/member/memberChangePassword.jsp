<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/member.js"></script>
<!-- 중앙 컨텐츠 시작 -->
<div class="container write-form w_600 ">
	<div class="row">
		<h2 class="text-center margin-top-50 margin-bottom-50">비밀번호 변경</h2>
		<form:form commandName="command" action="changePassword.do" id="change_form">
			<form:hidden path="user_id"/>
			<form:errors element="div" cssClass="error-color" />
			<ul class="col-xs-6 col-xs-offset-3 flightForm">
				<li>
					<label for="old_pw">현재 비밀번호</label>
					<form:password path="old_pw"/>
					<form:errors path="old_pw" cssClass="error-color" />
				</li>
				<li>
					<label for="user_pw">변경할 비밀번호</label>
					<form:password path="user_pw" id="user_pw"/>
					<span id="message_id_2" class="error-color"></span>
				</li>
				<li>
					<label for="confirm_pw">변경할 비밀번호 확인</label>
					<input type="password" name="confirm_pw" id="confirm_pw" />
					<span id="message_id" class="error-color"></span>
				</li>
			</ul>
			<div class="btn-submit col-xs-12 margin-bottom margin-top-50">
				<input class="btn btn-ok" type="submit" value="전송">
				<input type="button" value="홈으로" class="btn btn-default" 
				onclick="location.href='${pageContext.request.contextPath}/main/main.do'">
			</div>
		</form:form>
	</div>
</div>
<!-- 중앙 컨텐츠 끝 -->