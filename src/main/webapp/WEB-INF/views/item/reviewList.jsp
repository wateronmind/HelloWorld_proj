<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="container write-form w_600">
	<div class="row">
		<h2 class="col-xs-12">
			<i class="fas fa-suitcase-rolling"></i>&nbsp;여행물품 후기 목록
		</h2>
		
		<div>
			<table>
				<thead>
					<tr>
						<th>리뷰 번호</th>
						<th>내용</th>
						<th>ID</th>
						<th>별점</th>
					</tr>
				</thead>
				<c:forEach var="list" items="${list}">
					<tr>
						<td>${list.ir_num}</td>
						<td>${list.ir_content}</td>
						<td>${list.user_id}</td>
						<td>${list.ir_star}</td>
						<td>
						<button type="button" class="btn btn-danger" onclick="location.href='itemDelete.do?i_num=${list.i_num}'">삭제</button>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		
		
		
	</div>
</div>		