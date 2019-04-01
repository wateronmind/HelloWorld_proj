<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 중앙 컨텐츠 시작 -->
<br>
<div class="container write-form w_600">
	<div class="row">
		<h2 class="col-xs-12">여행물품 등록</h2>
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
						id="upload"></li>
					<li><label for="i_nm">상품명</label> <input type="text" id="i_nm"
						required="required" placeholder="상품명을 입력 하세요"></li>
					<li><label for="i_pc">상품가격</label> <input type="number"
						id="i_pc" required="required" placeholder="상품가격을 입력해 주세요">
					</li>
					<li><label for="i_dispc">할인가격</label> <input type="number"
						id="i_dispc" required="required" placeholder="할인가격을 입력해 주세요">
					</li>
					<li><label for="i_quan">상품수량</label> <input type="number"
						id="i_quan" required="required" placeholder="상품수량을 입력해 주세요">
					</li>
					<li><label for="i_state">상품상태</label> <input type="radio"
						name="i_state" id="i_state" value="0">품절 <input
						type="radio" name="i_state" id="i_state" value="1"
						checked="checked">판매중</li>

					<li><label for="ict_num">카테고리 선택</label> 
					<select>
					<optgroup label="카테고리선택">
							<option value="${ict_num==2}">카메라</option>
<option value="${ict_num==4}">등산용품</option>
<option value="${ict_num==6}">물놀이용품</option>
<option value="${ict_num==8}">휴대폰용품</option>
<option value="${ict_num==10}">놀거리</option>
<option value="${ict_num==12}">기타</option>
					</optgroup>		
					</select></li>
					<input type="hidden" id="i_rent_day" name="i_rent_day" />
					<input type="hidden" id="i_return_day" name="i_return_day" />
					<li><label for="i_content">상품설명</label> <textarea rows="6"
							cols="100" id="i_content" required="required" placeholder="상세설명을 입력해주세요"></textarea></li>
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