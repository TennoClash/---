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
				<h3>网站用户信息列表</h3>
			</div>
			<br>


			<div class="row">
				<table class="table table-hover">
					<thead>
						<tr class="bg-info text-white">
							<th class="center">用户名</th>
							<th class="center">姓名</th>
							<th class="center">联系方式</th>
							<th class="center">联系电话</th>
							<th class="center">联系地址</th>
							<th class="center">注册日期</th>
						</tr>
					</thead>
					<c:forEach items="${usersList}" var="users">
						<tr align="center">
							<td class="center">${users.username}</td>
							<td class="center">${users.realname}</td>
							<td class="center">${users.contact}</td>
							<td class="center">${users.phone}</td>
							<td class="center">${users.address}</td>
							<td class="center">${users.regdate}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div style="float: right;">
				<form action="users/queryUsersByCond.action" name="myform" method="post">
					<label>查询条件: <select name="cond" style="width: 100px">
							<option value="username">按用户名查询</option>
							<option value="password">按密码查询</option>
							<option value="realname">按姓名查询</option>
							<option value="contact">按联系方式查询</option>
							<option value="phone">按联系电话查询</option>
							<option value="address">按联系地址查询</option>
							<option value="regdate">按注册日期查询</option>
					</select>
					</label>&nbsp;&nbsp;&nbsp; <label>关键字: <input type="text" name="name" required style="width: 100px" /></label>&nbsp;&nbsp;&nbsp;
					<label><input type="submit" value="查询" class="mws-button green" /> </label>${html }
				</form>
			</div>
		</div>
	</div>
</body>
</html>
