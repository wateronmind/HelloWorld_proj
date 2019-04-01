<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>안내</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/layout.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
	<div class="row">
		<h2><a href="${pageContext.request.contextPath}/main/main.do">회원제 게시판</a></h2>
		<div class="result-display">
			<c:if test="${!empty accessMsg}">
				${accessMsg}
			</c:if>
			<c:if test="${empty accessMsg}">
				잘못된 접속입니다.
			</c:if>
			<c:if test="${!empty accessUrl}">
			<input type="button" value="이동"
			   onclick="location.href='${accessUrl}'">
			</c:if>
			<c:if test="${empty accessUrl}">
			<input type="button" value="이동"
			   onclick="location.href='${pageContext.request.contextPath}/main/main.do'">
			</c:if>
		</div>
	</div>
</div>
</body>
</html>









