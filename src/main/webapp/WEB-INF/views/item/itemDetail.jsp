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
					<input type="hidden" name="i_pc" value="${item.i_pc}" id="i_pc">
					<input type="hidden" name="user_id" value="${user_id}">
					<input type="hidden" name="i_num" value="${item.i_num}">
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
					<%-- <tr><td class="dd"><h6>&nbsp;&nbsp;현재 재고수량 : ${item.i_quan}</h6></td></tr> --%>
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
					<select name="i_rent_nc" style="width:150px;">
					<option>인천공항</option>
					<option>김포공항</option>
					<option>김포공항</option>
					<option>김포공항</option>
					<option>김포공항</option>
					</select>
					<select name="i_return_nc" style="width:150px;">
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
					<h6>&nbsp;&nbsp;구매수량<br>&nbsp;&nbsp;<input type="number" name="i_quan" min="1" max="99999" autocomplete="off" id="i_quan" class="quantity-width" style="width:150px;">
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
				${item.i_content}
			</p>
		</div>
		<div class="tab-pane" id="tab2">
			<div style="text-align: center; margin-top: 20px;">
				<span style="color: white;">※Hello World를 이용한 고객님들께서 직접 작성하신 후기입니다.</span>
			</div>
			
		<a href="reviewWrite.do"><button class="btn btn-success">후기등록</button></a>
		
			
		</div>
	</div>



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