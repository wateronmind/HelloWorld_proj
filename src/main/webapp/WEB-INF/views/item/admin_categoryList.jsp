<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<br>
<style>
.clist {
	padding: 5px 0px 5px 5px;
	margin-bottom: 5px;
	border-bottom: 1px solid #efefef;
	font-size: 25px;
	color: white;
}
</style>
<div class="container">
	<div class="row">
		<div class="section-title mb-80"
			style="text-align: center; background-color: white;">
			<h2>
				<span class="tt">여행물품 카테고리 목록</span>
			</h2>
		</div>
		<div class="col-lg-3 col-md-3 mb-30">
			<a href="categoryWrite.do"
				class="button border_radius little button-black mb-20"><span>등록
			</span></a>
		</div>

		<table class="clist">
			<tr>
				<th>카테고리번호</th>
				<th>카테고리명</th>
				<th>상태</th>
				<th>비고</th>
			</tr>
			<c:forEach var="itemCategory" items="${list}">
				<tr>
					<td>${itemCategory.ict_num}</td>
					<td>${itemCategory.ict_nm}</td>
					<td>${itemCategory.ict_state}</td>
					<td><button onclick="location.href='categoryWrite.do'"
							value="수정"></button>
						<button onclick="location.href='categoryDelete.do'" value="삭제"></button></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>