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
		<h2><span class="tt">여행물품 등록</span></h2>
		</div>
		<div class="col-md-offset-2 col-md-8">
			<form:form commandName="ICommand" action="itemWrite.do" id="register_form">
				<form:errors element="div" cssClass="form-horizontal error-color" />
				<form:hidden path="i_num" />
				
				<div class="form-group">
					<label for="i_img" class="col-md-4 control-label">상품사진</label>
					<div class="col-md-8">
						<input type="file" name="i_img" id="i_img" />
					</div>
				</div>
				
				<div class="form-group">
					<label for="i_nm" class="col-md-4 control-label">상품명</label>
					<div class="col-md-8">
					<form:input path="i_nm" cssClass="form-control" />
					<form:errors path="i_nm" cssClass="error-color" />
					</div>
				</div>
				
				<div class="form-group">
					<label for="i_pc" class="col-md-4 control-label">상품가격</label>
					<div class="col-md-8">
						<form:input path="i_pc" cssClass="form-control" />
						<form:errors path="i_pc" cssClass="error-color" />
					</div>
				</div>
				
				<div class="form-group">
					<label for="i_dispc" class="col-md-4 control-label">할인가격</label>
					<div class="col-md-8">
						<form:input path="i_dispc" cssClass="form-control" />
						<form:errors path="i_dispc" cssClass="error-color" />
					</div>
				</div>
				
				<div class="form-group">
					<label for="i_quan" class="col-md-4 control-label">상품수량</label>
					<div class="col-md-8">
						<form:input path="i_quan" cssClass="form-control" />
						<form:errors path="i_quan" cssClass="error-color" />
					</div>
				</div>
				
				
				<div class="form-group">
					<label for="i_content" class="col-md-4 control-label">상품설명</label>
					<div class="col-md-8">
						<form:textarea path="i_content" />
						<form:errors path="i_content" cssClass="error-color" />
					</div>
				</div>
				
				<div class="form-group">
					<label for="i_state" class="col-md-4 control-label">상품상태</label>
					<div class="col-md-8">
						<input type="radio" name="i_state" id="i_state" value="0">품절
						<input type="radio" name="i_state" id="i_state" value="1" checked="checked">판매중
						<form:errors path="i_state" cssClass="error-color" />
					</div>
				</div>
				<div class="form-group">
					<label for="ict_num" class="col-md-4 control-label">카테고리 선택</label>
					<div class="col-md-8">
						<form:select path="ict_num">
							<form:option value="1">카메라</form:option>
							<form:option value="2">등산용품</form:option>
							<form:option value="3">물놀이용품</form:option>
						</form:select>	
						<form:errors path="ict_num" cssClass="error-color" />
					</div>
				</div>
				
				<form:hidden path="i_rent_day" />
				<form:hidden path="i_return_day" />
				
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