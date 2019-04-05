<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="welcome-section text-center ptb-110">
	<div class="container">
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
	</div>
	<div class="col-md-12 pb-80">

		<div class="news-inner">

			<div class="news-img">
				<%-- <c:forEach var="item" items="${item}"> --%>
				<img src="imageView.do?i_num=${item.i_num}" alt="">

			</div>
			<div class="news-desc">
				<h3 class="news-title">
					<h6>등산용품</h6>
					<h3>
						<b>${item.i_nm}</b>
					</h3>
					<h3>대여료 : ${item.i_pc}</h3>
					<h5>
						<font color="blue">※ 기본 1일 대여료입니다.</font>
					</h5>
				</h3>
				<div class="news-action">
					<div class="read-more">
						<a href="${pageContext.request.contextPath}/itemcart/cartList.do">장바구니</a>&nbsp;<a href="#">구매하기</a>
					</div>

				</div>
				<%-- </c:forEach> --%>
			</div>
	
		</div>

	</div>
	<div class="booking_form_inner">
		<form action="#">
			<div class="single-form-part">
				<div class="date-to mb-20">
					<input class="date-picker" type="text" placeholder="대여일자"
						value="대여일자" width="80px;"> <i class="mdi mdi-calendar-text"></i>
				</div>

			</div>
			<div class="single-form-part">
				<div class="date-to mb-20">
					<input class="date-picker" type="text" placeholder="반납일자"
						value="반납일자"> <i class="mdi mdi-calendar-text"></i>
				</div>

			</div>

		</form>
	</div>
	<div>
	${item.i_content}
	</div>
</div>

<%-- <!-- <style>
#info td { background-color:#FFDDDD; padding:10px; border:1px solid #ACB4F2; }

</style> -->


<br>

<div class="container write-form w_600">
	<div class="section-title mb-80" style="text-align: center;">

		<h2>상품 상세보기</h2>
	</div>
</div>
</div>

<div class="our-services-list">
	<div class="container-fluid">
		<div class="row">


		
			<div class="col-md-5 col-sm-3 col-xs-2">
				<div class="single-services">
					<div class="services-img">
						<br> <img
							src="${pageContext.request.contextPath}/resources/images/services/services3.jpg"
							alt="">
						<div class="services-title">
							<h2>24/7 Reception</h2>
						</div>
						<div class="services-hover-desc">
							<div class="services-hover-inner">
								<div class="services-hover-table">
									<div class="services-hover-table-cell">
										<h2>24/7 Reception</h2>
										<p>There are many variations of passages Loem Ipsum
											available, but the majority have suffered alteration in some
											form, by injected humour.</p>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

				<table width="800px">
					<tr>
						<td rowspan="4"><img src="/5dmark3.jpg" width="400px"/></td>
						<td>category : ${item.ict_num}</td>
					</tr>
					<tr>
						<td>name : ${item.i_nm}</td>
					</tr>
					<tr>
						<td>price : ${item.i_pc}</td>
					</tr>
					<tr>
						<td>discount price : ${item.i_dispc}</td>
					</tr>
				</table>
						
		</div>
	</div>
	</div>
	<div class="section-title mb-80" style="text-align: center;">
			<span style="text-align:center">〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓</span>
			
			<p style="text-align:center">**해당 상품은 하자가 있는 상품입니다.**</p>
			
			</div>


 --%>