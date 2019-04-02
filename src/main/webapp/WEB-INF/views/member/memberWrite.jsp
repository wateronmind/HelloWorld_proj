<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/confirmId.js"></script>
<!-- 중앙 컨텐츠 시작 -->
<div class="container">
	<div class="row">
		<h1 class="text-center">회원가입</h1>
		<div class="col-md-offset-2 col-md-6">
			<form:form commandName="command" action="write.do" id="register_form">
				<form:errors element="div" cssClass="form-horizontal error-color" />
				<div class="form-group">
					<label for="user_id" class="col-md-4 control-label">아이디</label>
					<div class="col-md-8">
						<form:input path="user_id" cssClass="form-control" />
						<span id="message_id"></span>
						<input type="button" id="confirmId" value="ID중복체크" class="btn btn-primary">
						<form:errors path="user_id" cssClass="form-horizontal error-color" />
						
					</div>
				</div>
				
				<div class="form-group">
					<label for="user_nm" class="col-md-4 control-label">이름</label>
					<div class="col-md-8">
						<form:input path="user_nm" cssClass="form-control" />
						<form:errors path="user_nm" cssClass="error-color" />
					</div>
				</div>
				
				<div class="form-group">
					<label for="user_pw" class="col-md-4 control-label">비밀번호</label>
					<div class="col-md-8">
						<form:password path="user_pw" cssClass="form-control" />
						<form:errors path="user_pw" cssClass="error-color" />
					</div>
				</div>
				
				<div class="form-group">
					<label for="user_phone" class="col-md-4 control-label">전화번호</label>
					<div class="col-md-8">
						<form:input path="user_phone" cssClass="form-control" />
						<form:errors path="user_phone" cssClass="error-color" />
					</div>
				</div>
				
				<div class="form-group">
					<label for="user_email" class="col-md-4 control-label">이메일</label>
					<div class="col-md-8">
						<form:input path="user_email" cssClass="form-control" />
						<form:errors path="user_email" cssClass="error-color" />
					</div>
				</div>
				
				<div class="form-group">
					<div class="col-md-offset-5 col-md-7">
						<input type="submit" value="전송" class="btn btn-default">
						<input type="button" value="홈으로" class="btn btn-default" 
							onclick="location.href='${pageContext.request.contextPath}/main/main.do'">
					</div>
				</div>
			</form:form>
		</div>
	</div>
</div>
<!-- 중앙 컨텐츠 끝 -->