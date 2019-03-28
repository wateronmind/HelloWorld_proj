<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Hello World</title>
    <meta name="description" content="KH 파이널 프로젝트">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="${pageContext.request.contextPath}/resources/images/apple-touch-icon.png" type="images/x-icon" rel="shortcut icon">
    <!-- 로고 사용 폰트 -->
    <link href="https://fonts.googleapis.com/css?family=Anton" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/all.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/core.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/shortcode/shortcodes.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/responsive.css">
    <!-- customizer style css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/custom.css">
    <link href="${pageContext.request.contextPath}/resources/css/color/color-2.css" data-style="styles" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/resources/js/vendor/modernizr-2.8.3.min.js"></script>

    <script src="${pageContext.request.contextPath}/resources/js/vendor/jquery-1.12.0.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/waypoints.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/jquery.counterup.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/video-player.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/animated-headlines.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/parallax.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/textilate.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/lettering.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/isotope.pkgd.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/packery-mode.pkgd.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/owl.carousel.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/jquery.magnific-popup.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/plugins.js"></script>
</head>
<body>
	<tiles:insertAttribute name="header" />
	<tiles:insertAttribute name="body" />
	<tiles:insertAttribute name="footer" />
</body>
</html>