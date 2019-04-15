<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>     
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<style>
.dtab{
	margin:0 auto;
}
table{
	margin:0 auto;
}
span#item_total_txt{
	color:#000;
	font-weight:bold;
}
#align-right{
	text-align: right;
}
</style>
<div class="welcome-section text-center ptb-110">
	<!-- <div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="section-title mb-50">
					<h2>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>물품
							상세보기</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					</h2>
				</div>
			</div>
		</div>
	</div> -->
	<div class="col-xs-12">
		<h3 class="crowd_prod_title">
		  <font color="white" style="font-weight:bold;">${item.i_nm}</font>
		</h3>
		<hr width="800px">
		<table>
		<tr>
			<td style="width: 400px;">
				<img src="imageView.do?i_num=${item.i_num}" width="400">
			</td>
			<td>
			<table style="width: 400px;">
			<form:form commandName="Command" action="${pageContext.request.contextPath}/itemcart/cartInsert.do" id="cartInsert">
					<input type="hidden" name="i_pc" value="${item.i_pc}" id="i_pc">
					<input type="hidden" name="user_id" value="${user_id}">
					<input type="hidden" name="i_num" value="${item.i_num}">
					<tr>
					<td><h4 style="color: white;">&nbsp;&nbsp;대여료 : <i class="fas fa-won-sign"></i>&nbsp;<fmt:formatNumber value="${item.i_pc}"/> 원</h4>
					</td>
					</tr>
					<tr>
					<td>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class="date-picker" type="text" value="대여일자" name="i_rent_day" style="width:150px;"> <i class="mdi mdi-calendar-text"></i>
					<input class="date-picker" type="text" value="반납일자" name="i_return_day" style="width:150px;"> <i class="mdi mdi-calendar-text"></i>
					<br><br>
					<h6>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;픽업공항&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;/&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;반납공항 선택</h6>
					&nbsp;
					<select name="i_rent_nc" style="width:150px;">
					<option>인천공항</option>
					<option>김포공항</option>
					<option>김포공항</option>
					<option>김포공항</option>
					<option>김포공항</option>
					</select>&nbsp;&nbsp;&nbsp;&nbsp;
					<select name="i_return_nc" style="width:150px;">
					<option>인천공항</option>
					<option>김포공항</option>
					<option>김포공항</option>
					<option>김포공항</option>
					<option>김포공항</option>
					</select>
					<br><br>
					<h6>&nbsp;&nbsp;구매수량<br>&nbsp;&nbsp;<br>
					<input type="number" name="ic_quan" min="1" max="99999" autocomplete="off" id="ic_quan" class="quantity-width" style="width:300px;">
					</h6>
					</td>
					</tr>
					<br>	
					<tr>
					<td style="font-size:13pt;color:white;">총 주문 금액:<label>
					&nbsp;&nbsp;<!-- <span id="item_total_txt"><h4>총주문금액 : 0원</h4></span> --><br>
					</label>원</td>
					</tr>
					<tr>
					<td>
				<div class="btn-submit col-xs-12">
					<button type="submit" class="btn btn-ok" style="width:250px;">장바구니 담기</button>
				</div>
				</td>
				</tr>
			</form:form>
			</table>
			</td>
			</tr>
			</table>
		</div>
	</div>
	
	<div style="text-align:center;">
	<ul class="nav nav-tabs col-xs-12">
		<li class="active" style="width:600px;"><a href="#tab1" data-toggle="tab">상세보기</a></li>
		<li style="width:600px;"><a href="#tab2" data-toggle="tab">이용후기</a></li>
	</ul></div><br>
	<!-- 전체 탭 시작 -->
	<div class="tab-content">
		<!-- 탭1 상세보기 시작 -->
		<div class="tab-pane active" id="tab1">
			<p class="col-xs-12">
				${item.i_content}
			</p>
		</div>
		<!-- 탭1 상세보기 끝 -->
		
		<!-- 탭2 이용후기 시작 -->
		<div class="tab-pane" id="tab2"><br><br><br>
			<div style="text-align: center;">
				<span style="color: white; font-size:12pt;"><br><br>※Hello World를 이용한 고객님들께서 직접 작성하신 후기입니다.</span>
			</div>
			<br><br>
			<div class="col-xs-12">
				<div style="text-align:center;">
				<a href="itemreview.do?i_num=${item.i_num}"><button class="btn btn-ok" style="width:250px;">후기등록</button></a>
				</div>
			</div>
			<!-- 리뷰리스트 시작 -->
			<div class="row">
			<div class="col-xs-12"><br><br><br><br>
				<h4 style="color: white; text-align:center;">
					<i class="fas fa-suitcase-rolling"></i>&nbsp;여행물품 후기 목록
				</h4>
				<hr width="800px">
				<br><br>
				<div style="color:white; text-align:center;" class="col-xs-12">
					<c:forEach var="list" items="${list}">
					<input type="hidden" name="ir_num" value="${list.ir_num}">
					<input type="hidden" name="i_num" value="${list.i_num}"><tr style="color:white;">
						<c:if test="${list.i_num==item.i_num}">
							<p style="color:white;">
							<span style="font-size:13pt;">${list.ir_content}</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<span style="font-size:9pt;" class="align-right">${list.user_id}&nbsp;
							<%-- <span>${list.ir_star}</span> --%>
							${list.ir_reg_date}</span>
							<c:if test="${!empty user_id && user_auth==3}"><button type="button" class="btn btn-danger" onclick="location.href='reviewDelete.do?ir_num=${list.ir_num}&i_num=${list.i_num}'">삭제</button></c:if>
							</p>
							<span><hr width="600px" style="color:gray;"></span>
						</c:if>
					</c:forEach>
				</div>
			</div>
			</div>
			<!-- 리뷰리스트 끝 -->
		</div>
		<!-- 탭2 이용후기 끝 -->
		<br><br><br><br><br><br><br><br>
	</div>
	<!-- 전체 탭 끝 -->
<script type="text/javascript"
			src="//cdnjs.cloudflare.com/ajax/libs/jquery.lazy/1.7.5/jquery.lazy.min.js"></script>
<script type="text/javascript"
			src="//cdnjs.cloudflare.com/ajax/libs/jquery.lazy/1.7.5/jquery.lazy.plugins.min.js"></script>
<script>
    $('img.lazy').Lazy({
        effect: 'fadeIn',
        effectTime: 200
    })
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/ajax/item/detail.js"></script>
<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/ajax/item/review.js"></script> --%>