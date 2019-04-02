<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<br>
<style>
table {
	width: 700px;
	height: 250px;
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
			<i class="far fa-folder"></i>&nbsp;여행물품 목록
		</h2>

		<a href="itemWrite.do"
			class="button border_radius little button-black mb-20"><span>등록
		</span></a>

		<div class="col-xs-12">
			<table class="bluetop">
				<thead>
					<tr>
						<th scope="cols">번호</th>
						<th scope="cols">상품명</th>
						<th scope="cols">상품가격</th>
						<th scope="cols">할인가격</th>
						<th scope="cols">재고</th>
						<th scope="cols">카테고리</th>
						<th scope="cols">상태</th>
					</tr>
				</thead>
				<c:forEach var="item" items="${list}">
					<tr>
						<td class="even">${item.i_num}</td>
						<td class="even">${item.i_nm}</td>
						<td class="even">${item.i_pc}</td>
						<td class="even">${item.i_dispc}</td>
						<td class="even">${item.i_quan}</td>
						<td class="even">${item.ict_num}</td>
						<td class="even">${item.i_state}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</div>