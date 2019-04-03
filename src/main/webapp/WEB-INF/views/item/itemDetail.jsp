<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<br>

<div class="container write-form w_600">
	<div class="row">
		<h2 class="col-xs-12">
			<i class="far fa-folder"></i>&nbsp;상품 상세보기
		</h2>


		<div class="col-xs-12">
			<table class="bluetop">
				<thead>
					<tr>
						<th scope="cols">상품명</th>
						<th scope="cols">가격</th>

					</tr>
				</thead>
				<c:forEach var="itemDetail" items="${list}">
					<tr>
						<td class="even">${itemDetail.i_nm}</td>
						<td class="even">${itemDetail.i_pc}</td>
						<td class="even"></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</div>
