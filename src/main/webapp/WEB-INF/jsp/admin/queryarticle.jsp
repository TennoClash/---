<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%><%@ taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%><jsp:include page="check_logstate.jsp"></jsp:include>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%><!doctype html>
<html lang="zh_CN">
<head>
<base href="<%=basePath%>" />
<title>欢迎使用网站后台管理系统</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="font-awesome-4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/font-icon-style.css">
<link rel="stylesheet" href="css/style.default.css" id="theme-stylesheet">
<link rel="stylesheet" href="css/form.css">
<script src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/popper/popper.min.js"></script>
<script type="text/javascript" src="js/tether.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/jquery.cookie.js"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script type="text/javascript" src="js/chart.min.js"></script>
<script type="text/javascript" src="js/front.js"></script>
</head>
<body>
	<jsp:include page="top.jsp"></jsp:include>
	<div class="page-content d-flex align-items-stretch">
		<jsp:include page="menu.jsp"></jsp:include>
		<div class="content-inner chart-cont">
			<div class="card-header">
				<h3>网站内容信息列表</h3>
			</div>
			<br>


			<div class="row">
				<table class="table table-hover">
					<thead>
						<tr class="bg-info text-white">
							<th class="center">标题</th>
							<th class="center">内容主题</th>
							<th class="center">是否置顶</th>
							<th class="center">是否轮播</th>
							<th class="center">发布日期</th>
							<th class="center">点击数</th>
						</tr>
					</thead>
					<c:forEach items="${articleList}" var="article">
						<tr align="center">
							<td class="center">${article.title}</td>
							<td class="center">${article.bannername}</td>
							<td class="center">${article.istop}</td>
							<td class="center">${article.isflv}</td>
							<td class="center">${article.addtime}</td>
							<td class="center">${article.hits}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div style="float: right;">
				<form action="article/queryArticleByCond.action" name="myform" method="post">
					<label>查询条件: <select name="cond" style="width: 100px">
							<option value="title">按标题查询</option>
							<option value="bannerid">按内容主题查询</option>
							<option value="image">按图片查询</option>
							<option value="istop">按是否置顶查询</option>
							<option value="isflv">按是否轮播查询</option>
							<option value="contents">按内容查询</option>
							<option value="addtime">按发布日期查询</option>
							<option value="hits">按点击数查询</option>
					</select>
					</label>&nbsp;&nbsp;&nbsp; <label>关键字: <input type="text" name="name" required style="width: 100px" /></label>&nbsp;&nbsp;&nbsp;
					<label><input type="submit" value="查询" class="mws-button green" /> </label>${html }
				</form>
			</div>
		</div>
	</div>
</body>
</html>
