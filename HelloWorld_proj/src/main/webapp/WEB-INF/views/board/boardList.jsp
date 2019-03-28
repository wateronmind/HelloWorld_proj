<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/board.js"></script>
<script type="text/javascript">
	var result = '${result}';
	if (result == 'success') {
		alert('처리가 완료 되었습니다.');
	}
</script>
<!-- 중앙 컨텐츠 시작 -->
<div class="container">
	<div class="row">
		<h1>게시판 목록</h1>

		<form action="list.do" id="search_form" method="get">
			<ul class="search">
				<li>
					<select name="keyfield">
						<option value="title">제목</option>
						<option value="id">ID</option>
						<option value="content">내용</option>
						<option value="all">전체</option>
					</select>
				</li>
				<li>
					<input type="text" name="keyword" id="keyword">
				</li>
				<li>
					<input type="submit" value="찾기">
					<input type="button" value="목록" onclick="location.href='list.do'">
				</li>
			</ul>
		</form>
		<div class="align-right">
			<c:if test="${!empty user_id}">
				<input type="button" value="글쓰기" onclick="location.href='write.do'">
			</c:if>
		</div>
		<c:if test="${count == 0}">
		<div class="align-center">등록된 게시물이 없습니다.</div>
		</c:if>
		<c:if test="${count > 0}">
		<div class="table-responsive">
			<table class="table table-striped">
				<tr>
					<th>번호</th>
					<th width="400">제목</th>
					<th>ID</th>
					<th>등록날짜</th>
					<th>조회수</th>
				</tr>
				<c:forEach var="board" items="${list}">
				<tr>
					<td>${board.num}</td>
					<td><a href="detail.do?num=${board.num}">${board.title}(${board.re_cnt})</a></td>
					<td>${board.id}</td>
					<td>${board.reg_date}</td>
					<td>${board.hit}</td>
				</tr>
				</c:forEach>
			</table>
		</div>
		<div class="align-center">${pagingHtml}</div>
		</c:if>
	</div>
</div>
<!-- 중앙 컨텐츠 끝 -->