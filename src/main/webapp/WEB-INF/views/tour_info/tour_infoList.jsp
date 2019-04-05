<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- <script type="text/javascript">
	var result = '${result}';
	if(result == 'success'){
		alert('처리가 완료되었습니다.');
	}
</script> -->
<!-- 목록 시작 -->
<div class="write-form w_600">
   <div class="container">
	<div class="row">
		<h2>투어 목록</h2>
		<form action="list.do" id="search_form" method="get">
			<div class="col-xs-4">
			<ul class="search-sth">
				<li>
					<select name="keyfield">
						<option value="ti_nm">투어명</option>
						<option value="ti_start_day">출발 일자</option>
						<option value="all">키워드</option><!-- 투어명하고 상세설명 두개를 포함해서? -->
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
			</div>
		</form>
		<%-- <div class="align-right">
			<c:if test="${!empty user_id}">
				<input type="button" value="글쓰기" onclick="location.href='write.do'">
			</c:if>
		</div> --%><!--  -->
		<c:if test="${count == 0}">
		<div class="align-center">등록된 투어 게시물이 없습니다.</div>
		</c:if>
		<c:if test="${count > 0}">
		<div class="table-responsive">
			<table class="table table-striped">
				<tr>
					<th>투어 ID</th>
					<th width="400">투어 명</th>
					<th>작성자</th>
					<th>시작 일자</th>
					<!-- <th>조회수</th> -->
				</tr>
				<c:forEach var="tour_info" items="${list}">
				<tr>
					<td>${tour_info.ti_id}</td>
					<td><a href="detail.do?num=${tour_info.ti_nm}">${tour_info.ti_nm} (${tour_info.re_cnt})</a></td>
					<td>${tour_info.user_id}</td>
					<td>${tour_info.ti_start_day}</td>
					<%-- <td>${tour_info.hit}</td> --%>
				</tr>
				</c:forEach>
			</table>
		</div>
		<div class="align-center">${pagingHtml}</div>		
		</c:if>
	</div>
  </div>
</div>
<!-- 중앙 컨텐츠 끝 -->