<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<c:if test="${sessionScope.role eq '管理员' }">
	<nav class="side-navbar">
		<ul class="list-unstyled">
			<li><a href="#1" aria-expanded="false" data-toggle="collapse"> <i class="icon-interface-windows"></i>用户管理
			</a> 
				<ul id="1" class="collapse list-unstyled">
					<li><a href="admin/createAdmin.action">添加管理人员</a></li>
					<li><a href="admin/getAllAdmin.action">用户查询</a></li> 
				</ul></li>

			<li><a href="#2" aria-expanded="false" data-toggle="collapse"> <i class="icon-interface-windows"></i>租赁用户信息管理
			</a>
				<ul id="2" class="collapse list-unstyled">
					<li><a href="users/queryUsersByCond.action">租赁用户查询</a></li>
				</ul></li>

			<li><a href="#3" aria-expanded="false" data-toggle="collapse"> <i class="icon-interface-windows"></i>网站板块管理
			</a>
				<ul id="3" class="collapse list-unstyled">
					<li><a href="banner/createBanner.action">新增内容主题信息</a></li>
					<li><a href="banner/getAllBanner.action">网站板块修改</a></li>
				</ul></li>

			<li><a href="#4" aria-expanded="false" data-toggle="collapse"> <i class="icon-interface-windows"></i>网站内容管理
			</a>
				<ul id="4" class="collapse list-unstyled">
					<li><a href="article/createArticle.action">新增网站内容</a></li>
					<li><a href="article/getAllArticle.action">网站内容修改</a></li>
				</ul></li>

			<li><a href="#5" aria-expanded="false" data-toggle="collapse"> <i class="icon-interface-windows"></i>建材类型管理
			</a>
				<ul id="5" class="collapse list-unstyled">
					<li><a href="kind/createKind.action">新增建材类型</a></li>
					<li><a href="kind/getAllKind.action">建材类型修改</a></li>
					<li><a href="kind/queryKindByCond.action">建材类型查询</a></li>
				</ul></li>

			<li><a href="#6" aria-expanded="false" data-toggle="collapse"> <i class="icon-interface-windows"></i>建材信息管理
			</a>
				<ul id="6" class="collapse list-unstyled">
					<li><a href="goods/createGoods.action">新增建材信息</a></li>
					<li><a href="goods/getAllGoods.action">建材信息编辑</a></li>
					<li><a href="goods/queryGoodsByCond.action">建材信息查询</a></li>
				</ul></li>

			<li><a href="#7" aria-expanded="false" data-toggle="collapse"> <i class="icon-interface-windows"></i>租赁订单管理
			</a>
				<ul id="7" class="collapse list-unstyled">
					<li><a href="orders/queryOrdersByCond.action">订单查询</a></li>
				</ul></li>


			<li><a href="#9" aria-expanded="false" data-toggle="collapse"> <i class="icon-interface-windows"></i>收支项目管理
			</a>
				<ul id="9" class="collapse list-unstyled">
					<li><a href="cate/createCate.action">新增收支项目</a></li>
					<li><a href="cate/queryCateByCond.action">收支项目查询</a></li>
				</ul></li>

			<li><a href="#10" aria-expanded="false" data-toggle="collapse"> <i class="icon-interface-windows"></i>财务收支信息管理
			</a>
				<ul id="10" class="collapse list-unstyled">
					<li><a href="book/getAllBook.action">财务收支信息查询</a></li>
					<li><a href="book/queryBookByCond.action">财务收支信息详细查询</a></li>
				</ul></li>

		</ul>
	</nav>
</c:if>
<c:if test="${sessionScope.role eq '财务人员' }">
	<nav class="side-navbar">
		<ul class="list-unstyled">

			<li><a href="#1" aria-expanded="false" data-toggle="collapse"> <i class="icon-interface-windows"></i>网站用户管理
			</a>
				<ul id="1" class="collapse list-unstyled">
					<li><a href="users/queryUsersByCond.action">网站用户查询</a></li>
				</ul></li>

			<li><a href="#2" aria-expanded="false" data-toggle="collapse"> <i class="icon-interface-windows"></i>建材信息管理
			</a>
				<ul id="2" class="collapse list-unstyled">
					<li><a href="goods/queryGoodsByCond.action">建材信息查询</a></li>
				</ul></li>

			<li><a href="#3" aria-expanded="false" data-toggle="collapse"> <i class="icon-interface-windows"></i>租赁订单管理
			</a>
				<ul id="3" class="collapse list-unstyled">
					<li><a href="orders/getAllOrders.action">订单状态管理</a></li>
				</ul></li>

			<li><a href="#4" aria-expanded="false" data-toggle="collapse"> <i class="icon-interface-windows"></i>收支项目管理
			</a>
				<ul id="4" class="collapse list-unstyled">
					<li><a href="cate/queryCateByCond.action">收支项目查询</a></li>
				</ul></li>

			<li><a href="#5" aria-expanded="false" data-toggle="collapse"> <i class="icon-interface-windows"></i>财务收支管理
			</a>
				<ul id="5" class="collapse list-unstyled">
					<li><a href="book/createBook.action">新增财务收支信息</a></li>
					<li><a href="book/getAllBook.action">财务收支管理</a></li>
					<li><a href="book/queryBookByCond.action">财务收支查询</a></li>
				</ul></li>

		</ul>
	</nav>
</c:if>
<c:if test="${sessionScope.role eq '财务主管' }">
	<nav class="side-navbar">
		<ul class="list-unstyled">

			<li><a href="#1" aria-expanded="false" data-toggle="collapse"> <i class="icon-interface-windows"></i>网站用户信息管理
			</a>
				<ul id="1" class="collapse list-unstyled">
					<li><a href="users/queryUsersByCond.action">网站用户信息查询</a></li>
				</ul></li>

			<li><a href="#2" aria-expanded="false" data-toggle="collapse"> <i class="icon-interface-windows"></i>建材信息管理
			</a>
				<ul id="2" class="collapse list-unstyled">
					<li><a href="goods/queryGoodsByCond.action">建材信息查询</a></li>
				</ul></li>

			<li><a href="#3" aria-expanded="false" data-toggle="collapse"> <i class="icon-interface-windows"></i>租赁订单管理
			</a>
				<ul id="3" class="collapse list-unstyled">
					<li><a href="orders/queryOrdersByCond.action">订单查询</a></li>
					<li><a href="admin/orders">订单报表</a></li>
				</ul></li>


			<li><a href="#4" aria-expanded="false" data-toggle="collapse"> <i class="icon-interface-windows"></i>收支项目信息管理
			</a>
				<ul id="4" class="collapse list-unstyled">
					<li><a href="cate/queryCateByCond.action">收支项目信息查询</a></li>
				</ul></li>

			<li><a href="#5" aria-expanded="false" data-toggle="collapse"> <i class="icon-interface-windows"></i>财务收支管理
			</a>
				<ul id="5" class="collapse list-unstyled">
					<li><a href="book/queryBookByCond.action">收支信息查询</a></li>
					<li><a href="admin/book">财务收支报表</a></li>
				</ul></li>

		</ul>
	</nav>
</c:if>