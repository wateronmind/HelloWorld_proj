<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>     
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<style>
.dtab{
	margin:0 auto;
}
.tablemain{
	margin:0 auto;
}
.dd{
	text-align:left;
}
span#item_total_txt{
	color:#000;
	font-weight:bold;
}
</style>
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

		<table class="tablemain">
		<tr>
			<td>
				<%-- <c:forEach var="item" items="${item}"> --%>
				<img src="imageView.do?i_num=${item.i_num}" width="400px">
			</td>
			<td>
			<table>
			<form:form commandName="Command" action="${pageContext.request.contextPath}/itemcart/cartInsert.do" id="cartInsert">
					<input type="hidden" name="item_price" value="${item.i_pc}" id="item_price">
					<tr>
					<td class="dd"><h6>&nbsp;&nbsp;카메라</h6></td>
					</tr>
					<tr>
					<td class="dd"><h3>
						<b>&nbsp;&nbsp;${item.i_nm}</b>
					</h3></td>
					</tr>
					<tr>
					<td class="dd" style="text-align:left;"><h4>&nbsp;&nbsp;대여료 : <fmt:formatNumber value="${item.i_pc}"/> 원</h4></td>
					</tr>
					<tr>
					<td class="dd"><h6>
						<font color="blue">&nbsp;&nbsp;※ 기본 1일 대여료입니다.</font>
					</h6></td>
					</tr>
					<tr>
					<td>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class="date-picker" type="text" value="대여일자" name="i_rent_day" style="width:150px;"> <i class="mdi mdi-calendar-text"></i>
					<input class="date-picker" type="text" value="반납일자" name="i_return_day" style="width:150px;"> <i class="mdi mdi-calendar-text"></i>
					</td>
					</tr>
					<br>
					<tr>
					<td>
					<h6>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;픽업공항&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;/&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;반납공항 선택</h6>
					<select style="width:150px;">
					<option>인천공항</option>
					<option>김포공항</option>
					<option>김포공항</option>
					<option>김포공항</option>
					<option>김포공항</option>
					</select>
					<select style="width:150px;">
					<option>인천공항</option>
					<option>김포공항</option>
					<option>김포공항</option>
					<option>김포공항</option>
					<option>김포공항</option>
					</select>
					</td>
					</tr>
					<br>
					<br>
					<tr>
					<td class="dd" style="text-align:left;">
					<h6>&nbsp;&nbsp;구매수량<br>&nbsp;&nbsp;<input type="number" name="order_quantity" min="1" max="99999" autocomplete="off" id="order_quantity" class="quantity-width" style="width:150px;">
					</h6>
					</td>
					</tr>
					<br>	
					<tr>
					<td>
					&nbsp;&nbsp;<span id="item_total_txt">총주문금액 : 0원</span><br>
					</td>
					</tr>
					<tr>
					<td>
				<div class="news-action">
					<div class="read-more">
						&nbsp;&nbsp;<input type="submit" value="장바구니 담기" class="btn btn-success">
					</div>
				</div>
				</td>
				</tr>
				<%-- </c:forEach> --%>
			
			</form:form>
			</table>
			</td>
			</tr>
			</table>
		</div>
	</div>
	
	<div class="dtab">
	<ul class="nav nav-tabs col-xs-12">
		<li class="active" style="width:600px;"><a href="#tab1" data-toggle="tab">상세보기</a></li>
		<li style="width:600px;"><a href="#tab2" data-toggle="tab">이용후기</a></li>
	</ul></div><br>
	<div class="tab-content">
		<div class="tab-pane active" id="tab1">
			<p>
				<img alt=""
					src="https://dbbi7jasykh4f.cloudfront.net/media/products/content_tap/2017/04/11/52_284.jpg"
					style="height: 2214px; width: 700px">
			</p>
		</div>
		<div class="tab-pane" id="tab2">
			<div style="text-align: center; margin-top: 20px">
				<span style="color: gray">※ 오쉐어를 이용한 고객님들께서 직접 작성하신 후기입니다.</span>
			</div>

			<div class="review-container">등록된 후기가 없습니다.</div>
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


<<<<<<< HEAD

			<%-- <div class="col-md-5 col-sm-3 col-xs-2">
=======
		
			<div class="col-md-5 col-sm-3 col-xs-2">
>>>>>>> 2dd81ceefd3de2374cac48e6e5d58432fa0479b6
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


			<input type="hidden" name="user_id" value="${user_id}">
			
			
				<table width="800px">
					<tr>
						<td rowspan="4"><img src="/5dmark3.jpg" width="400px" /></td>
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
				<div class="btn-submit col-sm-3">
					<input type="submit" value="장바구니담기">
					<input type="button" value="주문하기" onclick="location.href='orderForm.do'" class="btn btn-ok">
				</div>

		</div>
	</div>
</div>
<div class="section-title mb-80" style="text-align: center;">
	<span style="text-align: center">〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓</span>

	<p style="text-align: center">**해당 상품은 하자가 있는 상품입니다.**</p>

</div>


 --%>


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