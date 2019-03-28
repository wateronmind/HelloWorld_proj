<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/board.reply.js"></script>
<!-- 중앙 컨텐츠 시작 -->
<div class="container">
	<div class="row">
		<h1>${board.title}</h1>
		<ul>
			<li>번호 : ${board.num}</li>
			<li>작성자 : ${board.id}</li>
			<li>조회수 : ${board.hit}</li>
			<li>등록일 : ${board.reg_date}</li>
			<c:if test="${!empty board.filename}">
			<li>첨부파일 : <a href="file.do?num=${board.num}">${board.filename}</a></li>
			</c:if>
		</ul>
		<hr size="1" width="100%">
		<p>
			${board.content}
		</p>
		<hr size="1" width="100%">
		<div class="align-right">
			<c:if test="${!empty user_id && user_id == board.id}">
			<input type="button" value="수정" 
				onclick="location.href='update.do?num=${board.num}'">
			<input type="button" value="삭제" 
				onclick="location.href='delete.do?num=${board.num}'">
			</c:if>
			<input type="button" value="목록" 
				onclick="location.href='list.do'">
		</div>
		
		<div id="reply_div">
			<span class="reply-title">댓글 달기</span>
			<form id="re_form">
				<input type="hidden" name="num" value="${board.num}" 
						id="num">
				<input type="hidden" name="id" value="${user_id}" 
						id="user_id">
				<textarea rows="3" cols="50" name="re_content" id="re_content"
						class="rep-content"
						<c:if test="${empty user_id}">disabled="disabled"</c:if>
				><c:if test="${empty user_id}">로그인해야 작성할 수 있습니다.</c:if></textarea>
				<c:if test="${!empty user_id}">
				<div id="re_first">
					<span class="letter-count">300/300</span>
				</div>
				<div id="re_second" class="align-right">
					<input type="submit" value="전송">
				</div>
				</c:if>
			</form>
		</div>
		
		<!-- 댓글 목록 출력 -->
		<div id="output"></div>
		<div class="paging-button" style="display:none;">
			<input type="button" value="다음글 보기">
		</div>
		<div id="loading" style="display: none;">
			<img alt="로딩중" src="${pageContext.request.contextPath}/resources/images/ajax-loader.gif">
		</div>
		
	</div>
</div>
<!-- 중앙 컨텐츠 끝 -->