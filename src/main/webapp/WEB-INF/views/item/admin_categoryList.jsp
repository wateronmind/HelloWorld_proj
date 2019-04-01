<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<br>
<style>
.bluetop th {
  color:white;
  background:black;
  font-size:15pt;
}
.bluetop th, .bluetop td {
  padding: 10px;
  border: 1px solid #ddd;
  font-size:15pt;
}
.bluetop th:first-child, .bluetop td:first-child {
  border-left: 0;
}
.bluetop th:last-child, .bluetop td:last-child {
  border-right: 0;
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
<div class="col-md-offset-2 col-md-8">
		<table class="bluetop">
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
					<td><button onclick="location.href='categoryUpdate.do'"
							value="수정"></button>
						<button onclick="location.href='categoryDelete.do'" value="삭제"></button></td>
				</tr>
			</c:forEach>
		</table>
		</div>
	</div>
</div>