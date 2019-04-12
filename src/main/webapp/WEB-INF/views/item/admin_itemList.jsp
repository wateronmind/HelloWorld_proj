<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<br>
</div>
<div class="container table-list">
	<div class="row"><br><br>
		<h2 class="text-center">
			<i class="fas fa-suitcase-rolling"></i>&nbsp;여행물품 목록
		</h2>
		
		<div class="table-responsive">
		<div class="btn-submit pull-right">  
		<button type="button" value="물품등록" class="btn btn-ok" 
				onclick="location.href='itemWrite.do'">카테고리 등록</button>
		</div>
			<table class="table table-striped">
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