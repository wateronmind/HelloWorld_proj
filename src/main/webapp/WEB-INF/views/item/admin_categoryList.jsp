<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<br>
<style>
table{
	width:700px;
	height:250px;
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
    text-align:center;
}
table.bluetop tbody th {
    width: 150px;
    padding: 10px;
}
table.bluetop td {
    width: 350px;
    padding: 10px;
    vertical-align: top;
    text-align:center;
}
table.bluetop .even {
    background: #fdf3f5;
}
table.bluttop .even-4{
	width:250px;
}
.button border_radius little button-black mb-20{
	margin: 20px 10px;
}
</style>
<div class="container write-form w_600">
	<div class="row">
		<h2 class="col-xs-12"><i class="far fa-folder"></i>&nbsp;여행물품 카테고리 목록</h2>
		
			<a href="categoryWrite.do"
				class="button border_radius little button-black mb-20"><span>등록
			</span></a>
		
<div class="col-xs-12">
		<table class="bluetop">
		<thead>
			<tr>
				<th scope="cols">카테고리번호</th>
				<th scope="cols">카테고리명</th>
				<th scope="cols">상태</th>
				<th scope="cols">비고</th>
			</tr>
			</thead>
			<c:forEach var="itemCategory" items="${list}">
				<tr>
					<td class="even">${itemCategory.ict_num}</td>
					<td class="even">${itemCategory.ict_nm}</td>
					<td class="even">${itemCategory.ict_state}</td>
					<td class="even">
					<input type="button" value="수정" onclick="location.href='categoryUpdate.do'" style="WIDTH: 60pt; HEIGHT: 30pt;">
					<input type="button" value="삭제" onclick="location.href='categoryDelete.do'" style="WIDTH: 60pt; HEIGHT: 30pt;"></td>
				</tr>
			</c:forEach>
		</table>
		</div>
	</div>
</div>