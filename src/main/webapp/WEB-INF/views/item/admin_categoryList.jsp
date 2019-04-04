<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<br>
<style>

table { border-collapse: collapse; width: 100%; height: 300px;}
th {background: #2c623b; text-align: center; height: 40px; border-bottom: 1px solid white; font-size: 13pt; color: white;}
td { text-align: center; border-bottom: 1px solid white; font-size: 10pt; color: white;}


</style>
<div class="container write-form w_600">
	<div class="row">
		<h2 class="col-xs-12">
			<i class="far fa-folder"></i>&nbsp;여행물품 카테고리 목록
		</h2>

		<a href="categoryWrite.do"
			class="button border_radius little button-black mb-20"><span>등록
		</span></a>

		<div>
			<table>
				<thead>
					<tr>
						<!-- <th scope="cols">카테고리번호</th> -->
						<th>카테고리번호</th>
						<th>카테고리명</th>
						<th>상태</th>
						<th>비고</th>
					</tr>
				</thead>
				<c:forEach var="itemCategory" items="${list}">
					<tr>
						<%-- <td class="even">${itemCategory.ict_num}</td> --%>
						<td>${itemCategory.ict_num}</td>
						<td>${itemCategory.ict_nm}</td>
						<td>${itemCategory.ict_state}</td>
						<td>
							<!-- Button trigger modal -->
							<button type="button" class="btn btn-success" data-toggle="modal"
								data-target="#exampleModal">수정</button> <!-- Modal -->
							<div class="modal fade" id="exampleModal" tabindex="-1"
								role="dialog" aria-labelledby="exampleModalLabel"
								aria-hidden="true">
								<div class="modal-dialog" role="document">
									<div class="modal-content">
										<div class="modal-header">
											<ul class="col-xs-12">
												<li><label for="ict_nm">카테고리명</label> <input
													type="text" id="ict_nm" required="required"
													value="${itemCategory.ict_nm}"></li>

												<li><label for="ict_state">카테고리상태</label><br> <input
													type="radio" name="ict_state" id="ict_state"
													style="font-size: 17px; width: 23px; height: 23px"
													value="0"><label for="i_state">안보여짐</label>
													&nbsp;&nbsp;&nbsp;&nbsp; <input type="radio"
													name="ict_state" id="ict_state" value="1" checked="checked"
													style="font-size: 17px; width: 23px; height: 23px"><label
													for="i_state">보여짐</label></li>
												<div class="modal-footer">
													<button type="button" class="btn btn-secondary"
														data-dismiss="modal">Close</button>
													<button type="button" class="btn btn-primary"
														onclick="location.href='categoryUpdate.do'">수정</button>
												</div>
										</div>
									</div>
								</div>
								</div>
								<!-- Button trigger modal -->
							<button type="button" class="btn btn-danger" data-toggle="modal"
								data-target="#exampleModal2">삭제</button> <!-- Modal -->
							<div class="modal fade" id="exampleModal2" tabindex="-1"
								role="dialog" aria-labelledby="exampleModalLabel"
								aria-hidden="true">
								<div class="modal-dialog" role="document">
									<div class="modal-content">
										<div class="modal-header">
											정말 삭제하시겠습니까?
												<div class="modal-footer">
													<button type="button" class="btn btn-secondary"
														data-dismiss="modal">Close</button>
													<button type="button" class="btn btn-primary"
														onclick="location.href='categoryDelete.do?ict_num=${itemCategory.ict_num}'">삭제</button>
												</div>
										</div>
									</div>
								</div>
								</div>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</div>
<br><br>
<script>
$('#myModal').on('shown.bs.modal', function () {
	  $('#myInput').trigger('focus')
	})
</script>