<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<style>
.ir_star{
  background: url('http://miuu227.godohosting.com/images/icon/ico_review.png') no-repeat right 0;
  background-size: auto 100%;
  width: 30px;
  height: 30px;
  display: inline-block;
  text-indent: -9999px;
  cursor: pointer;
}
.ir_star.on{background-position:0 0;}
</style>
<div class="container write-form w_600">
<div class="row">
<h2 class="col-xs-12">
			<i class="fas fa-suitcase-rolling"></i>&nbsp;여행물품 후기 작성
		</h2>
<form:form commandName="IRcommand" 
				id="itemReviewForm" 
				action="reviewWrite.do">
				<input type="hidden" name="user_id" value="${user_id}">
				<input type="hidden" name="i_num" value="${item.i_num}">
<br><br>
<div class="col-md-6">
<div class="starRev">
  <span class="ir_star on" value="1">별1</span>
  <span class="ir_star" value="2">별2</span>
  <span class="ir_star" value="3">별3</span>
  <span class="ir_star" value="4">별4</span>
  <span class="ir_star" value="5">별5</span>
</div>
</div>
<br><br>
<div class="col-xs-12"><br>
<form:textarea path="ir_content" rows="2" cols="150"/>
</div>
<div class="btn-submit col-xs-12">
<button type="submit" class="btn btn-ok">후기 등록</button>
</div>
</form:form>
</div>
</div>
<script type="text/javascript">
$('.starRev span').click(function(){
	  $(this).parent().children('span').removeClass('on');
	  $(this).addClass('on').prevAll('span').addClass('on');
	  return false;
	});
</script>