<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
table { background:white,border-collapse: collapse; width: 100%; height: 300px;}
th {background: #2c623b; text-color:white; text-align: center; height: 40px; border-bottom: 1px solid white; font-size: 13pt; color: white;}
td { text-align: center; text-color:white; border-bottom: 1px solid white; font-size: 10pt; color: white;}

td > a{
	color:white;
	font-weight: bold;
}

ul.search{
	width:500px;
	list-style:none;
	padding:0;
	margin:10px auto;
}
ul.search li{
	display:inline;
}
ul.search li input[type="text"]{
	width:200px;
}
</style>
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
					<select name="keyfield" style="width:100px;">
						<option value="tr_title">제목</option>
						<option value="user_id">ID</option>
						<option value="tr_content">내용</option>
						<option value="all">전체</option>
					</select>
				</li>
				<li>
					<input type="text" name="keyword" id="keyword">
				</li>
				<li>
					<input type="submit" value="찾기" style="width:100px;border-radius:20%;background-color:#FFF;">
				</li>
			</ul>
		</form>
		<div align="right">
			<%-- <c:if test="${!empty user_id}"> --%>
				<a class="button border_radius little button-black mb-20" href="write.do"><span>글쓰기</span></a>
			<%-- </c:if> --%>
			<a class="button border_radius little button-black mb-20" href="list.do"><span>목록</span></a>
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
				<c:forEach var="review" items="${list}">
				<tr>
					<td>${review.tr_idx}</td>
					<td><a href="detail.do?tr_idx=${review.tr_idx}">${review.tr_title}</a></td>
					<td>${review.user_id}</td>
					<td>${review.tr_reg_date}</td>
					<td>${review.tr_hit}</td>
				</tr>
				</c:forEach>
			</table>
		</div>
		<div class="align-center">${pagingHtml}</div>
		</c:if>
	</div>
</div>
<!-- 중앙 컨텐츠 끝 -->