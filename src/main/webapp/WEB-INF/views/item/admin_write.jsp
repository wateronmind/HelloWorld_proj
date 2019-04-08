<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link
	href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.9/summernote.css"
	rel="stylesheet">
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.9/summernote.js"></script>
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$('#i_content')
								.summernote(
										{
											height : 200,
											fontNames : [ '맑은 고딕', 'Arial',
													'Arial Black',
													'Comic Sans Ms',
													'Courier New' ],
											focus : true,
											callbacks : {
												//이벤트처리
												onImageUpload : function(files,
														editor, welEditable) {
													for (var i = files.length - 1; i >= 0; i--) {
														sendFile(files[i], this);
													}
												}
											}
										});
						function sendFile(file, el) {
							var form_data = new FormData();
							form_data.append('file', file);
							$.ajax({
								data : form_data,
								type : 'post',
								url : './imageUploader.do',
								cache : false,
								contentType : false,//이미지업로드할때는 지정해줘야함
								enctype : 'multipart/form-data',//이미지업로드할때는 지정해줘야함
								processData : false,//이미지업로드할때는 지정해줘야함
								success : function(img_name) {
									$(el).summernote('editor.insertImage',
											img_name);
								}
							});
						}
					});
</script>
<style>
</style>
<!-- 중앙 컨텐츠 시작 -->
<br>
<div class="container write-form w_600">
	<div class="row">
		<h2 class="col-xs-12">
			<i class="fas fa-suitcase-rolling"></i>&nbsp;여행물품 등록
		</h2>
		<!-- form 시작 -->
		<form:form commandName="ICommand" 
				id="itemForm" 
				action="itemWrite.do" 
				enctype="multipart/form-data">
			<div class="row">
				<ul class="col-xs-12">
					
				<li>
						<div>
							<label for="upload">이미지 선택(상품 이미지)</label>
							<input type="file" id="upload" name="upload">
							<%-- form:input path="upload_fi_logo" type="file" />
							<form:errors element="div" path="upload_fi_logo" cssClass="error-color" /> --%>
						</div>
						<div class="thumb-box">
							<img alt src="" class="thumb-img">
						</div>
					</li>
					<li>
						<label for="i_nm">상품명</label>
						<form:input path="i_nm" placeholder="상품명을 입력 하세요" />
						<form:errors path="i_nm" cssClass="error-color" />
					</li>
					<li>
						<label for="i_pc">상품가격</label>
						<form:input path="i_pc" placeholder="상품가격을 입력해 주세요" />
						<form:errors path="i_pc" cssClass="error-color" />
					</li>
					<li>
						<label for="i_dispc">할인가격</label>
						<form:input path="i_dispc" placeholder="할인가격을 입력해 주세요(할인없을시 0입력)" />
						<form:errors path="i_dispc" cssClass="error-color" />
					</li>
					<li>
						<label for="i_quan">상품수량</label>
						<form:input path="i_quan" placeholder="상품수량을 입력해 주세요" />
						<form:errors path="i_quan" cssClass="error-color" />
					</li>
					<li>
						<label for="i_state">상품상태</label>
						<input
						type="radio" style="font-size: 17px; width: 23px; height: 23px"
						name="i_state" id="i_state" value="0"><label for="i_state">품절</label>
						&nbsp;&nbsp;&nbsp;&nbsp; <input type="radio"
						style="font-size: 17px; width: 23px; height: 23px" name="i_state"
						id="i_state" value="1" checked="checked"><label
						for="i_state">판매중</label>
					</li>
					<li>
					<label for="ict_num">카테고리 선택</label> 
					<select name="ict_num" id="ict_num">
						<c:forEach var="list" items="${list}">
						<option value="${list.ict_num}">${list.ict_nm}</option>
						</c:forEach>
					</select>
					</li>
					
					<li>
					<label for="i_content">상품설명</label> <textarea rows="6"
							cols="100" id="i_content" name="i_content" required="required"
							placeholder="상세설명을 입력해주세요"></textarea></li>
					<!-- submit -->
					<div class="btn-submit col-xs-12">
						<input type="button" value="뒤로" class="btn btn-default"> 
						<input type="submit" value="전송" class="btn btn-ok">
					</div>
					<!-- submit -->
				</ul>
			</div>
		</form:form>
	</div>
</div>
<!-- 중앙 컨텐츠 끝 -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/ajax/item/itemWrite.js"></script>