<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/confirmId.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/confirmEmail.js"></script>
<!-- 중앙 컨텐츠 시작 -->
<div class="container write-form w_800 ">
	<div class="row">
		<h1 class="col-xs-12 text-center margin-top"><span class="text-green">Hello World</span> 와 함께 여행을 떠나 보세요</h1>
		<section><br><br><br></section>
			<form:form commandName="command" action="write.do" id="register_form">
			<div class="row">
				<form:errors element="div" cssClass="error-color" />
				<ul class="col-xs-6 col-xs-offset-3 flightForm">
					<li>
						<label for="user_id">아이디</label>
						<form:input path="user_id"/>
						<span id="message_id"></span>
						<input type="button" id="confirmId" value="ID중복체크" class="btn btn-confirm">
						<form:errors path="user_id" cssClass="error-color" />
					</li>
					<li>
						<label for="user_nm">이름</label>
						<form:input path="user_nm"/>
						<form:errors path="user_nm" cssClass="error-color" />
					</li>
					<li>
						<label for="user_pw">비밀번호</label>
						<form:password path="user_pw" placeholder="4자 이상 입력하세요"/>
						<form:errors path="user_pw" cssClass="error-color" />
					</li>
					<li>
						<label for="user_phone">전화번호</label>
						<form:input path="user_phone"/>
						<form:errors path="user_phone" cssClass="error-color" />
					</li>
					<li>
						<label for="user_email">이메일</label>
						<form:input path="user_email"/>
						<span id="message_email"></span>
						<input type="button" id="confirmEmail" value="Email 중복체크" class="btn btn-confirm">
						<form:errors path="user_email" cssClass="error-color" />
					</li>
				</ul>
				</div>
				<div class="btn-submit col-xs-12 margin-bottom">
					<input type="submit" value="전송" class="btn btn-ok">
					<input type="button" value="홈으로" class="btn btn-default" 
						onclick="location.href='${pageContext.request.contextPath}/main/main.do'">
				</div>
		</form:form>
	</div>
</div>
<!-- 중앙 컨텐츠 끝 -->