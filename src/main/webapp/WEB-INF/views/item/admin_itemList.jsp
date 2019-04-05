<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<br>
<style>
table { border-collapse: collapse; width: 800px; height: 300px;}
th {background: #2c623b; text-align: center; height: 40px; border-bottom: 1px solid white; font-size: 13pt; color: white;}
td { text-align: center; border-bottom: 1px solid white; font-size: 10pt; color: white;}

</style>
<div class="container write-form w_600">
	<div class="row">
		<h2 class="col-xs-12">
			<i class="fas fa-suitcase-rolling"></i>&nbsp;여행물품 목록
		</h2>

		<a href="itemWrite.do"
			class="button border_radius little button-black mb-20"><span>등록
		</span></a>

		<div>
			<table>
				<thead>
					<tr>
						<th>번호</th>
						<th>상품이미지</th>
						<th>상품명</th>
						<th>상품가격</th>
						<th>할인가격</th>
						<th>재고</th>
						<th>카테고리</th>
						<th>상태</th>
						<th>비고</th>
					</tr>
				</thead>
				<c:forEach var="list" items="${list}">
					<tr>
						<td>${list.i_num}</td>
						<td><img src="imageView.do?i_num=${list.i_num}" width="50"></td>
						<td>${list.i_nm}</td>
						<td>${list.i_pc}</td>
						<td>${list.i_dispc}</td>
						<td>${list.i_quan}</td>
						<td>${list.ict_num}</td>
						<td>${list.i_state}</td>
						<td>
						<button type="button" class="btn btn-success" onclick="location.href='itemModify.do?i_num=${list.i_num}'">수정</button>
						<button type="button" class="btn btn-danger" onclick="location.href='itemDelete.do?i_num=${list.i_num}'">삭제</button>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</div>
<br><br>