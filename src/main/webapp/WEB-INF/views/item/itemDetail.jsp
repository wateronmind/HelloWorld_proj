<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- <style>
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


		
			<%-- <div class="col-md-5 col-sm-3 col-xs-2">
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
			</div> --%>

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


