<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<form action="itemWrite.do" id="register_form"
			enctype="multipart/form-data">
			<div class="row">
				<ul class="col-xs-12">
					<input type="hidden" id="i_num" name="i_num" />
					<!-- 
				<div class="form-group">
					<label for="i_img" class="col-md-4 control-label">상품사진</label>
					<div class="col-md-8">
						<input type="file" name="i_img" id="i_img" />
					</div>
				</div> -->
					<li><label for="upload">이미지 선택</label> <input type="file"
						id="upload" name="upload"></li>
					<li><label for="i_nm">상품명</label> <input type="text" id="i_nm"
						name="i_nm" required="required" placeholder="상품명을 입력 하세요"></li>
					<li><label for="i_pc">상품가격</label> <input type="number"
						id="i_pc" name="i_pc" required="required"
						placeholder="상품가격을 입력해 주세요"></li>
					<li><label for="i_dispc">할인가격</label> <input type="number"
						id="i_dispc" name="i_dispc" required="required"
						placeholder="할인가격을 입력해 주세요"></li>
					<li><label for="i_quan">상품수량</label> <input type="number"
						id="i_quan" name="i_quan" required="required"
						placeholder="상품수량을 입력해 주세요"></li>

					<li><label for="i_state">상품상태</label> <br> <input
						type="radio" style="font-size: 17px; width: 23px; height: 23px"
						name="i_state" id="i_state" value="0"><label for="i_state">품절</label>
						&nbsp;&nbsp;&nbsp;&nbsp; <input type="radio"
						style="font-size: 17px; width: 23px; height: 23px" name="i_state"
						id="i_state" value="1" checked="checked"><label
						for="i_state">판매중</label></li>

					<li><label for="ict_num">카테고리 선택</label> <select>
							
								<option value="2" name="ict_num" id="ict_num">카메라</option>
								<option value="4" name="ict_num" id="ict_num">등산용품</option>
								<option value="6" name="ict_num" id="ict_num">물놀이용품</option>
								<option value="8" name="ict_num" id="ict_num">휴대폰용품</option>
								<option value="10" name="ict_num" id="ict_num">놀거리</option>
								<option value="12" name="ict_num" id="ict_num">기타</option>
							
					</select></li>
					<input type="hidden" id="i_rent_day" name="i_rent_day" />
					<input type="hidden" id="i_return_day" name="i_return_day" />
					<li><label for="i_content">상품설명</label> <textarea rows="6"
							cols="100" id="i_content" name="i_content" required="required"
							placeholder="상세설명을 입력해주세요"></textarea></li>
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