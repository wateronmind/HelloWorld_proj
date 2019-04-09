<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- 중앙 컨텐츠 시작 -->
<div class="container write-form w_600">
	<div class="row">
		<h2 class="text-center">회원 탈퇴</h2>
		<div class="col-md-offset-2 col-md-8">
			<form:form commandName="command" action="delete.do" id="delete_form">
				<form:hidden path="user_id"/>
				<form:errors element="div" cssClass="error-color" />
				<ul>
					<li>
						<label for="user_pw">비밀번호</label>
						<form:password path="user_pw"/>
						<form:errors path="user_pw" cssClass="error-color" />
					</li>
				</ul>
			</form:form>
			<div class="col-md-offset-3 col-md-7">
				<button type="submit" class="btn btn-ok">탈퇴</button>
				<button type="button" class="btn btn-default"
				onclick="location.href='${pageContext.request.contextPath}/main/main.do'">홈으로</button>
			</div>
		</div>
	</div>
</div>
<!-- 중앙 컨텐츠 끝 -->