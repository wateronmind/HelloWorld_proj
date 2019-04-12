<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<br>
<script type="text/javascript">
$(document).ready(function(){
	$('.cate-btn').click(function(){
		$('#ict_num').val($(this).attr('data-num'));
		$('#ict_nm').val($(this).attr('data-nm'));
		if($(this).attr('data-state') == 0){
			$('#ict_state1').attr('checked',true);
		}else if($(this).attr('data-state') == 1){
			$('#ict_state2').attr('checked',true);
		}
	});
});
</script>
</div>
<div class="container table-list">
	<div class="row"><br><br>
		<h2 class="text-center">
			<i class="far fa-folder"></i>&nbsp;여행물품 카테고리 목록
		</h2>
		
		<div class="table-responsive">
		<div class="btn-submit pull-right">   
		<button type="button" value="물품등록" class="btn btn-ok" 
				onclick="location.href='categoryWrite.do'">물품등록</button>
		</div>
			<table class="table table-striped">
				
					<tr>
						<!-- <th scope="cols">카테고리번호</th> -->
						<th>카테고리번호</th>
						<th>카테고리명</th>
						<th>상태 (0:안보임, 1:보임)</th>
						<th>비고</th>
					</tr>
				
				<c:forEach var="itemCategory" items="${list}">
					<tr>
						<%-- <td class="even">${itemCategory.ict_num}</td> --%>
						<td>${itemCategory.ict_num}</td>
						<td>${itemCategory.ict_nm}</td>
						<td>${itemCategory.ict_state}</td>
						<td>
							<!-- Button trigger modal -->
							<button type="button" class="btn btn-success cate-btn" data-toggle="modal"
								data-target="#exampleModal" data-num="${itemCategory.ict_num}" data-nm="${itemCategory.ict_nm}" data-state="${itemCategory.ict_state}">수정</button> 
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</div>
<!-- 수정 Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1"
	role="dialog" aria-labelledby="exampleModalLabel"
	aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
			<form:form commandName="ICCommand"
                                      action="categoryUpdate.do">
				<form:hidden path="ict_num"/>
					<ul class="col-xs-12">
					
						<li>
<label for="ict_nm">카테고리명</label>
<form:input path="ict_nm"/>
</li>
	

							<li><label for="ict_state">카테고리상태</label><br> <input
								type="radio" name="ict_state" id="ict_state1"
								style="font-size: 17px; width: 23px; height: 23px"
						value="0"><label for="i_state">안보여짐</label>
						&nbsp;&nbsp;&nbsp;&nbsp; <input type="radio"
						name="ict_state" id="ict_state2" value="1" 
						style="font-size: 17px; width: 23px; height: 23px"><label
						for="i_state">보여짐</label></li>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Close</button>
						<button type="submit" class="btn btn-primary">수정</button>
					</div>
			</ul>
			</form:form>
			</div>
		</div>
	</div>
	</div>
<br><br>
<script>
$('#myModal').on('shown.bs.modal', function () {
	  $('#myInput').trigger('focus')
	})
</script>