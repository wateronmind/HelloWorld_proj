<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- 중앙 컨텐츠 시작 -->
<div class="container write-form w_600">
	<div class="row">
		<h2 class="text-center"><span class="text-green">Hello World</span>는 
		<span class="text-green">${user_id}</span> 님과 <br>
		다시 여행할 날을 기다리겠습니다. </h2>
		<h3></h3>
		<section class="text-center"><br><br><br><br></section>
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
				<div class="btn-submit">
					<input type="submit" class="btn btn-ok" value="탈퇴">
					<input type="button" class="btn btn-default" value="홈으로"
					onclick="location.href='${pageContext.request.contextPath}/main/main.do'" >
				</div>
			</form:form>
			<section><br><br><br><br><br><br><br></section>
		</div>
	</div>
</div>
<!-- 중앙 컨텐츠 끝 -->