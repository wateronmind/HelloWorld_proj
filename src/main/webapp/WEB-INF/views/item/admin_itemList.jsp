<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<br>
<style>
table {
	width: 800px;
	height: 200px;
	margin: 30px 10px 20px 50px;
}

table.bluetop {
	border-collapse: collapse;
	text-align: left;
	line-height: 1.5;
	border-top: 1px solid #ccc;
	border-bottom: 1px solid #ccc;
	margin: 20px 10px;
}

table.bluetop thead th {
	width: 300px;
	padding: 10px;
	font-weight: bold;
	vertical-align: top;
	color: #fff;
	background: #2c623b;
	margin: 20px 10px;
	text-align: center;
}

table.bluetop tbody th {
	width: 150px;
	padding: 10px;
}

table.bluetop td {
	width: 350px;
	padding: 10px;
	vertical-align: top;
	text-align: center;
}

table.bluetop .even {
	background: #fdf3f5;
}

table.bluttop .even-4 {
	width: 250px;
}

.button border_radius little button-black mb-20 {
	margin: 20px 10px;
}
</style>
<div class="container write-form w_600">
	<div class="row">
		<h2 class="col-xs-12">
			<i class="fas fa-suitcase-rolling"></i>&nbsp;여행물품 목록
		</h2>

		<a href="itemWrite.do"
			class="button border_radius little button-black mb-20"><span>등록
		</span></a>

		<div class="col-xs-12">
			<table class="bluetop">
				<thead>
					<tr>
						<th scope="cols">번호</th>
						<th scope="cols">상품이미지</th>
						<th scope="cols">상품명</th>
						<th scope="cols">상품가격</th>
						<th scope="cols">할인가격</th>
						<th scope="cols">재고</th>
						<th scope="cols">카테고리</th>
						<th scope="cols">상태</th>
						<th scope="cols">비고</th>
					</tr>
				</thead>
				<c:forEach var="list" items="${list}">
					<tr>
						<td class="even">${list.i_num}</td>
						<td><img src="imageView.do?i_num=${list.i_num}"></td>
						<td class="even">${list.i_nm}</td>
						<td class="even">${list.i_pc}</td>
						<td class="even">${list.i_dispc}</td>
						<td class="even">${list.i_quan}</td>
						<td class="even">${list.ict_num}</td>
						<td class="even">${list.i_state}</td>
						<td class="even">
						<button type="button" class="btn btn-success" onclick="itemUpdate.do">수정</button>
						<button type="button" class="btn btn-danger" onclick="itemDelete.do">삭제</button>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</div>