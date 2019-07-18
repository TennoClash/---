<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<header class="header">
	<nav class="navbar navbar-expand-lg ">
		<div class="search-box">
			<button class="dismiss">
				<i class="icon-close"></i>
			</button>
		</div>
		<div class="container-fluid ">
			<div class="navbar-holder d-flex align-items-center justify-content-between">
				<div class="navbar-header">
					<a href="admin/main.jsp" class="navbar-brand">
						<div class="brand-text brand-big hidden-lg-down">建材租赁财务管理系统</div>
					</a> <a id="toggle-btn" class="menu-btn active"> <span></span> <span></span> <span></span>
					</a>
				</div>
			</div>
			<ul class="nav-menu list-unstyled d-flex flex-md-row align-items-md-center">
				<li class="nav-item d-flex align-items-center"><a id="menu-toggle-right" class="nav-link">${sessionScope.adminname }</a></li>
				<li class="nav-item d-flex align-items-center"><a id="menu-toggle-right" class="nav-link"
					href="<%=basePath%>admin/prePwd.action">修改密码</a></li>
				<li class="nav-item d-flex align-items-center"><a id="menu-toggle-right" class="nav-link"
					href="<%=basePath%>admin/exit.action">退出系统</a></li>
			</ul>
		</div>
	</nav>
</header>