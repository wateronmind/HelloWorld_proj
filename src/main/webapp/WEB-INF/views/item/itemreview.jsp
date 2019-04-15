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
<h2 class="col-xs-12"><br><br>
			<i class="fas fa-suitcase-rolling"></i>&nbsp;여행물품 후기 작성
		</h2><br><br>
<form:form commandName="ircommand" 
				id="itemReviewForm" 
				action="itemreview.do">
				<input type="hidden" name="user_id" value="${user_id}">
				<input type="hidden" name="i_num" value="${param.i_num}"/>
				<input type="hidden" name="ir_star" id="ir_star" value="1"/>
<br><br>
<div class="col-md-6">
<div class="starRev">
  <span class="ir_star on" data-value="1">별1</span>
  <span class="ir_star" data-value="2">별2</span>
  <span class="ir_star" data-value="3">별3</span>
  <span class="ir_star" data-value="4">별4</span>
  <span class="ir_star" data-value="5">별5</span>
</div>
</div>
<br><br>
<div class="col-xs-12"><br>
<textarea name="ir_content" id="ir_content" style="width:600px; resize:none;" placeholder="물품대여 후기를 50자 이내로 적어주세요">
</textarea>
<br>
<span style="color:#aaa;" id="counter">(0 / 최대 50자)</span>
</div>
<div class="btn-submit col-xs-12">
<button type="submit" class="btn btn-ok" style="width: 150px;">후기 등록</button>
</div>
</form:form>
</div>
</div>
<script type="text/javascript">
$('.starRev span').click(function(){
	  $(this).parent().children('span').removeClass('on');
	  $(this).addClass('on').prevAll('span').addClass('on');
	  $('#ir_star').val($(this).attr('data-value'));
	  return false;
	});
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/ajax/item/item.review.js"></script>