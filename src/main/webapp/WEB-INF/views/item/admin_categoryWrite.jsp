<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<style>

</style>
<!-- 중앙 컨텐츠 시작 -->
<br>
<div class="container">
	<div class="row">
		<div class="section-title mb-80" style="text-align:center; background-color:white;">
		<h2><span class="tt">여행물품 카테고리 등록</span></h2>
		</div>
		<div class="col-md-offset-2 col-md-8">
			<form:form commandName="ICCommand" action="categoryWrite.do" id="register_form">
				<form:errors element="div" cssClass="form-horizontal error-color" />
				<form:hidden path="ict_num" />
				
				<div class="form-group">
					<label for="ict_nm" class="col-md-4 control-label">카테고리명</label>
					<div class="col-md-8">
					<form:input path="ict_nm" cssClass="form-control" />
					<form:errors path="ict_nm" cssClass="error-color" />
					</div>
				</div>
				
				<div class="form-group">
					<label for="ict_state" class="col-md-4 control-label">카테고리상태</label>
					<div class="col-md-8">
						<input type="radio" name="ict_state" id="ict_state" value="0">안보여짐
						<input type="radio" name="ict_state" id="ict_state" value="1" checked="checked">보여짐
						<form:errors path="ict_state" cssClass="error-color" />
					</div>
				</div>
				
				<div class="form-group">
					<div class="col-md-offset-4 col-md-8">
						<input type="submit" value="등록" class="btn btn-default">
						<input type="button" value="홈으로" class="btn btn-default" 
							onclick="location.href='${pageContext.request.contextPath}/main/main.do'">
					</div>
				</div>
			</form:form>
		</div>
	</div>
</div>
<!-- 중앙 컨텐츠 끝 -->