<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>

</style>
<!-- 중앙 컨텐츠 시작 -->
<div class="container write-form w_600">
	<div class="row">
		<h2 class="col-xs-12"><i class="far fa-folder"></i>&nbsp;여행물품 카테고리 등록</h2>
		<!-- form 시작 -->
		<form action="categoryWrite.do" id="register_form"
			enctype="multipart/form-data">
			<div class="row">
				<ul class="col-xs-12">
					<input type="hidden" id="ict_num" name="ict_num" />
					<li><label for="ict_nm">카테고리명</label> <input type="text" id="ict_nm"
						required="required" placeholder="카테고리명을 입력 하세요"></li>
		
				<li><label for="ict_state">카테고리상태</label><br> <input type="radio"
						name="ict_state" id="ict_state" style="font-size:17px; width:23px;height:23px" value="0"><label for="i_state">안보여짐</label> 
						&nbsp;&nbsp;&nbsp;&nbsp;
						<input
						type="radio" name="ict_state" id="ict_state" value="1"
						checked="checked" style="font-size:17px; width:23px;height:23px"><label for="i_state">보여짐</label></li>
				
				
				<div class="btn-submit col-xs-12">
						<input type="button" value="뒤로" class="btn btn-default"> <input
							type="submit" value="전송" class="btn btn-ok">
					</div>
					</ul>
					</div>
			</form>
		</div>
	</div>
<!-- 중앙 컨텐츠 끝 -->