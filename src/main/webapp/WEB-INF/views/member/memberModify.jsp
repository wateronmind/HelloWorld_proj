<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- 중앙 컨텐츠 시작 -->
<div class="container write-form w_600">
	<div class="row">
			<h2 class="text-center">회원정보 수정</h2>
			<div class="col-md-offset-2 col-md-8">
				<!-- commandName 에서 자동으로 자바빈 정보를 읽어오기 때문에 -->
				<form:form commandName="command" action="update.do" id="modify_form">
					<!-- 다음과 같이 명시해줘도 id를 가져올 수 있다. -->
					<form:hidden path="user_id" />
					<form:errors element="div" cssClass="form-horizontal error-color" />
					<ul>
						<li>
							<label for="user_nm" class="col-md-4 control-label">이름</label>
							<form:input path="user_nm" cssClass="form-control" />
							<form:errors path="user_nm" cssClass="error-color" />
						</li>
						<li>
							<label for="user_phone" class="col-md-4 control-label">전화번호</label>
							<form:input path="user_phone" cssClass="form-control" />
							<form:errors path="user_phone" cssClass="error-color" />
						</li>
						<li>
							<label for="user_email" class="col-md-4 control-label">이메일</label>
							<form:input path="user_email" cssClass="form-control" />
							<form:errors path="user_email" cssClass="error-color" />
						</li>
						<li><br></li>
						<li><a href="${pageContext.request.contextPath}/member/changePassword.do"><input type="button" value="비밀번호 변경"></a></li>
					</ul>
				</form:form>
					<div class="text-center">
						<button type="submit" class="btn btn-ok">수정</button>
						<button type="button" value="홈으로" class="btn btn-default" 
							onclick="location.href='${pageContext.request.contextPath}/member/detail.do'">취소</button>
					</div>
			</div>
	</div>
</div>
<!-- 중앙 컨텐츠 끝 -->