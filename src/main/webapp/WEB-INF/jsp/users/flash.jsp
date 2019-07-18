<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<link href="<%=basePath %>css/css.css" rel="stylesheet" type="text/css">
<link href="<%=basePath %>css/css_2.css" rel="stylesheet" type="text/css">
<script src="<%=basePath %>js/jquery-1.4a2.min.js" type="text/javascript"></script>
<script src="<%=basePath %>js/jquery.KinSlideshow-1.2.1.min.js" type="text/javascript"></script>
<script type="text/javascript">
	var moveStyle
	var rand = parseInt(Math.random() * 4)
	switch (3) {
	case 0:
		moveStyle = "left";
		break;
	case 1:
		moveStyle = "right";
		break;
	case 2:
		moveStyle = "down";
		break;
	case 3:
		moveStyle = "up";
		break;
	}
	$(function() {
		$("#KinSlideshow").KinSlideshow( {
			moveStyle : moveStyle
		});

	})
</script>


<div id="KinSlideshow" style="visibility: hidden;">
	<c:forEach items="${favList}" var="article">
		<a href="index/read.action?id=${article.articleid }"><img src="${article.image }"
				alt="${article.title }" width="355" height="235" /> </a>
	</c:forEach>
</div>