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
				<h3>财务收支信息列表</h3>
			</div>
			<br>


			<div class="row">
				<table class="table table-hover">
					<thead>
						<tr class="bg-info text-white">
							<th class="center">收支单号</th>
							<th class="center">收支项目</th>
							<th class="center">日期</th>
							<th class="center">金额</th>
							<th class="center">经手人</th>
							<th class="center">备注</th>
						</tr>
					</thead>
					<c:forEach items="${bookList}" var="book">
						<tr align="center">
							<td class="center">${book.bookno}</td>
							<td class="center">${book.catename}</td>
							<td class="center">${book.addtime}</td>
							<td class="center">${book.money}</td>
							<td class="center">${book.realname}</td>
							<td class="center">${book.memo}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div style="float: right;">
				<form action="book/queryBookByCond.action" name="myform" method="post">
					<label>查询条件: <select name="cond" style="width: 100px">
							<option value="bookno">按收支单号查询</option>
							<option value="cateid">按收支项目查询</option>
							<option value="addtime">按日期查询</option>
							<option value="money">按金额查询</option>
							<option value="adminid">按经手人查询</option>
							<option value="memo">按备注查询</option>
					</select>
					</label>&nbsp;&nbsp;&nbsp; <label>关键字: <input type="text" name="name" required style="width: 100px" /></label>&nbsp;&nbsp;&nbsp;
					<label><input type="submit" value="查询" class="mws-button green" /> </label>${html }
				</form>
			</div>
		</div>
	</div>
</body>
</html>
