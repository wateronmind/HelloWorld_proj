<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>카테고리목록</title>
</head>
<body>
<div class="container">
	<div class="row">
	<h2>카테고리 목록</h2>
	<div class="align-right">
		<input type="button" value="등록" onclick="location.href='categoryWrite.do'">
	</div>
	
		<table>
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
				<td><button onclick="location.href='categoryWrite.do'" value="수정"></button>
				<button onclick="location.href='categoryDelete.do'" value="삭제"></button></td>
			</tr>	
			</c:forEach>	
		</table>
</div>
</div>
</body>
</html>