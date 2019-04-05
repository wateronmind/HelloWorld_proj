<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/ajax/tour/tour_info.js"></script>
 <link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.9/summernote.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.9/summernote.js"></script> 

<div class="tour_infoWrite write-form w_600">
		<!-- 컨텐츠 시작 -->
		<div class="container">
			<div class="row">
<%-- 
<c:if test="${user_auth!=2}">
	<div><h1 style="color:white"> 해당 코너는 가이드 전용입니다.</h1></div>
</c:if> --%>
<c:if test="${!empty user_id && user_auth == 2}">
			<!-- ========================================================== -->
	
            <!-- ========================================================== -->
				<h2 class="col-xs-12">투어 등록</h2>
					<form:form commandName="command" action="write.do" enctype="multipart/form-data" id="register_form" cssClass="form-horizontal">
					  <form:hidden path="user_id" value="${user_id}"/>
					  <div class="col-xs-12">  
						<%-- <form:errors element="div" cssClass="error-color" /> --%>
						<div class="form-group">
						    <label for="ti_nm" class="col-md-2" id="ti_nm">투어명</label> 
						       <div class="col-lg-6">
						    		<form:input path="ti_nm" cssClass="form-control"/>
									<%-- <form:errors path="ti_nm" cssClass="error-color" /> --%>
							    </div>
						 </div>	
						 <div class="form-group">		
								<label for="ti_start_day" class="col-md-2">시작일자 </label> 
								<div class="col-lg-6">
						          <form:input path="ti_start_day" type="date" cssClass="form-control"/> 
						          <%--  <form:errors path="ti_start_day" cssClass="error-color" /> --%>
								</div>
			            </div>
			             <div class="form-group">		
								<label for="ti_end_day" class="col-md-2">종료일자 </label> 
								<div class="col-lg-6">
						          <form:input path="ti_end_day" type="date" cssClass="form-control"/> 
						       <%--     <form:errors path="ti_start_day" cssClass="error-color" /> --%>
								</div>
			            </div>	
			            <div class="form-group">		
								<label for="ti_min_pp" class="col-md-2">최소인원 </label> 
								<div class="col-lg-6">
						          <form:select path="ti_min_pp">
								<c:forEach var="i" begin="1" end="20">
									<option value="${i}">${i}명</option>
								</c:forEach>
							   </form:select> 
							<%-- <form:errors path="ti_min_pp" cssClass="error-color" /> --%>
				    	</div>
			            </div>
			            <div class="form-group">		
								<label for="ti_max_pp" class="col-md-2">최대인원 </label> 
								<div class="col-lg-6">
						          <form:select path="ti_max_pp">
								<c:forEach var="i" begin="1" end="20">
									<option value="${i}">${i}명</option>
								</c:forEach>
							   </form:select> 
						<%-- 	<form:errors path="ti_max_pp" cssClass="error-color" /> --%>
				    	</div>
			            </div>	
			            <div class="form-group">
			             <label for="ti_pickup_place" class="col-md-2">픽업장소</label> 
						     <div class="col-lg-6">
						    		<form:input path="ti_pickup_place" cssClass="form-control"/>
									<%-- <form:errors path="ti_pickup_place" cssClass="error-color" /> --%>
						     </div>
						 </div>
						 <div class="form-group">
			             <label for="ti_pickup_time" class="col-md-2">픽업시간</label> 
						     <div class="col-lg-6">
						    		<form:input path="ti_pickup_time" cssClass="form-control"/>
							<%-- 		<form:errors path="ti_pickup_place" cssClass="error-color" /> --%>
						     </div>
						 </div>
						 <div class="form-group">
			             <label for="ti_pc" class="col-md-2">가격</label> 
						     <div class="col-lg-6">
						    		<form:input path="ti_pc" cssClass="form-control"/>
									<%-- <form:errors path="ti_pc" cssClass="error-color" /> --%>
						     </div>
						 </div>
						 <div class="form-group">
			               <label for="upload" class="col-md-2">투어 사진</label> 
						      <div class="col-lg-6">
						    		<input type="file" id="upload" name="upload" class="form-control"/>
								<%-- 	<form:errors path="ti_img" cssClass="error-color" /> --%>
						      </div>
						 </div>
						   <div class="form-group">
						     <label for="ti_content"  class="col-md-2">상세 내용</label>
					               <form:textarea path="ti_content"/>
					              <%--  <form:errors path="ti_content" cssClass="error-color"/> --%>
					        </div>
						 <div class="form-group">
						     <div class="btn-submit col-xs-12">
							   <input type="button" value="뒤로" class="btn btn-default" onclick="${pageContext.request.contextPath}/main/main.do"> 
							   <input type="submit" value="전송" class="btn btn-ok" id="tour_register">
						     </div>
						</div>
				    </div>
				</form:form>
          </c:if>
      </div>
    </div>
</div>
<script type="text/javascript">
$('.price').mask('000,000,000,000,000', {reverse: true});
</script>