<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/ajax/item/star.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/ajax/item/jquery-1.11.3.min.js"></script>
<style>
.ir_star>.input,
.ir_star>.input>label:hover,
.ir_star>.input>input:focus+label,
.ir_star>.input>input:checked+label{display: inline-block;vertical-align:middle;background:url('images/item/grade_img.png')no-repeat;}
.ir_star{display:inline-block; white-space:nowrap;width:225px;height:40px;padding:25px;line-height:30px;}
.ir_star>.input{display:inline-block;width:150px;background-size:150px;height:28px;white-space:nowrap;overflow:hidden;position: relative;}
.ir_star>.input>input{position:absolute;width:1px;height:1px;opacity:0;}
.ir_star>.input.focus{outline:1px dotted #ddd;}
.ir_star>.input>label{width:30px;height:0;padding:28px 0 0 0;overflow: hidden;float:left;cursor: pointer;position: absolute;top: 0;left: 0;}
.ir_star>.input>label:hover,
.ir_star>.input>input:focus+label,
.ir_star>.input>input:checked+label{background-size: 150px;background-position: 0 bottom;}
.ir_star>.input>label:hover~label{background-image: none;}
.ir_star>.input>label[for="p1"]{width:30px;z-index:5;}
.ir_star>.input>label[for="p2"]{width:60px;z-index:4;}
.ir_star>.input>label[for="p3"]{width:90px;z-index:3;}
.ir_star>.input>label[for="p4"]{width:120px;z-index:2;}
.ir_star>.input>label[for="p5"]{width:150px;z-index:1;}
.ir_star>output{display:inline-block;width:60px; font-size:18px;text-align:right; vertical-align:middle;}
</style> --%>
<form:form commandName="IRcommand" 
				id="itemReviewForm" 
				action="reviewWrite.do">
				<input type="hidden" name="user_id" value="${user_id}">
				<input type="hidden" name="i_num" value="${item.i_num}">
<div class="col-md-6">
<span class="ir_star">
	<span class="input">
    	<input type="radio" name="ir_star" value="1" id="p1">
    	<label for="p1">1</label>
    	<input type="radio" name="ir_star" value="2" id="p2">
    	<label for="p2">2</label>
    	<input type="radio" name="ir_star" value="3" id="p3">
    	<label for="p3">3</label>
    	<input type="radio" name="ir_star" value="4" id="p4">
    	<label for="p4">4</label>
    	<input type="radio" name="ir_star" value="5" id="p5">
    	<label for="p5">5</label>
  	</span>
  	<output for="star-input"><b>0</b>점</output>						
</span>

<form:textarea path="ir_content"/>
</div>
<input type="submit" value="등록">
</form:form>
