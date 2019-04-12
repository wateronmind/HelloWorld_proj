<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!-- 중앙 컨텐츠 시작 -->
<div class="container">
	<div class="row">
		<h1>${review.tr_title}</h1>
		<ul>
			<li>번호 : ${review.tr_idx}</li>
			<li>작성자 : ${review.user_id}</li>
			<li>조회수 : ${review.tr_hit}</li>
			<li>등록일 : ${review.tr_reg_date}</li>
		</ul>
		<hr size="1" width="100%">
		<div class="align-center">
			<img src="imageView.do?tr_idx=${review.tr_idx}"
								  style="max-width:500px;">
		</div>			  
		<p>
			${review.tr_content}
		</p>
		<hr size="1" width="100%">
		<div class="align-right">
			<%-- <c:if test="${!empty user_id && user_id == review.tr_idx}"> --%>
			<input type="button" value="수정" 
				onclick="location.href='update.do?tr_idx=${review.tr_idx}'">
			<input type="button" value="삭제" 
				onclick="location.href='delete.do?tr_idx=${review.tr_idx}'">
			<%-- </c:if> --%>
			<input type="button" value="목록" 
				onclick="location.href='list.do'">
		</div>
	</div>
</div>
<!-- 중앙 컨텐츠 끝 -->