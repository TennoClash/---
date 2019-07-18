<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><jsp:include page="check_logstate.jsp"></jsp:include>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!doctype html>
<html lang="zh_CN">
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>建材租赁财务管理系统</title>
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
<script type="text/javascript" src="js/book.js" charset="utf-8"></script>
<script type="text/javascript" src="js/selimage.js" charset="utf-8"></script>
<script type="text/javascript" src="<%=basePath%>My97DatePicker/WdatePicker.js" charset="utf-8"></script>
</head>
<body>
	<jsp:include page="top.jsp"></jsp:include>
	<div class="page-content d-flex align-items-stretch">
		<jsp:include page="menu.jsp"></jsp:include>
		<div class="content-inner form-cont">
			<div class="row">
				<div class="col-md-12">
					<div class="card form" id="form2">
						<div class="card-header">
							<h3>编辑财务收支信息</h3>
						</div>
						<br>
						<form action="book/updateBook.action" autocomplete="off" name="myform" method="post" onsubmit="return check()">
							<div class="row">
								<div class="col-md-12">
									<div class="form-group row">
										<label style="width: 85px;" class=" col-form-label">收支单号</label>
										<div class="col-9">
											<input type="text" name="bookno" class="form-control" id="bookno" readonly="readonly" value="${book.bookno}" />
										</div>
									</div>
									<div class="form-group row">
										<label style="width: 85px;" class=" col-form-label">收支项目</label>
										<div class="col-9">
											<select name="cateid" class="form-control" id="cateid"><c:forEach items="${cateList}" var="cate">
													<option value="${cate.cateid}">${cate.catename }</option>
												</c:forEach></select>
										</div>
									</div>
									<div class="form-group row">
										<label style="width: 85px;" class=" col-form-label">金额</label>
										<div class="col-9">
											<input type="text" name="money" class="form-control" id="money" value="${book.money}" />
										</div>
									</div>
									<div class="form-group row">
										<label style="width: 85px;" class=" col-form-label">经手人</label>
										<div class="col-9">
											<select name="adminid" class="form-control" id="adminid"><c:forEach items="${adminList}" var="admin">
													<option value="${admin.adminid}">${admin.realname }</option>
												</c:forEach></select>
										</div>
									</div>
									<div class="form-group row">
										<label style="width: 85px;" class=" col-form-label">备注</label>
										<div class="col-9">
											<input type="text" name="memo" class="form-control" id="memo" value="${book.memo}" />
										</div>
									</div>
								</div>
							</div>
							<input type="hidden" name="bookid" id="bookid" value="${book.bookid}" /><input type="hidden" name="addtime"
								id="addtime" value="${book.addtime}" /><input type="hidden" name="adminid"
								id="addtime" value="${book.adminid}" />

							<button type="submit" class="btn btn-general btn-blue mr-2">提交保存</button>
							<button type="reset" class="btn btn-general btn-white">取消重置</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>

