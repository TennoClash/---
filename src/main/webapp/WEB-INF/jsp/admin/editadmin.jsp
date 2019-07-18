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
<script type="text/javascript" src="js/admin.js" charset="utf-8"></script>
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
							<h3>编辑系统用户·信息</h3>
						</div>
						<br>
						<form action="admin/updateAdmin.action" autocomplete="off" name="myform" method="post" onsubmit="return check()">
							<div class="row">
								<div class="col-md-12">
									<div class="form-group row">
										<label style="width: 85px;" class=" col-form-label">用户名</label>
										<div class="col-9">
											<input type="text" name="username" class="form-control" id="username" value="${admin.username}" />
										</div>
									</div>
									<div class="form-group row">
										<label style="width: 85px;" class=" col-form-label">姓名</label>
										<div class="col-9">
											<input type="text" name="realname" class="form-control" id="realname" value="${admin.realname}" />
										</div>
									</div>
									<div class="form-group row">
										<label style="width: 85px;" class=" col-form-label">性别</label>
										<div class="col-9">
											<select class="form-control" name="sex" id="sex"><option value="是">是</option>
												<option value="否">否</option></select>
										</div>
									</div>
									<div class="form-group row">
										<label style="width: 85px;" class=" col-form-label">出生日期</label>
										<div class="col-9">
											<input type="text" name="birthday" class="form-control" id="birthday" value="${admin.birthday}"
												onclick="WdatePicker()" readonly="readonly" />
										</div>
									</div>
									<div class="form-group row">
										<label style="width: 85px;" class=" col-form-label">联系方式</label>
										<div class="col-9">
											<input type="text" name="contact" class="form-control" id="contact" value="${admin.contact}" />
										</div>
									</div>
									<div class="form-group row">
										<label style="width: 85px;" class=" col-form-label">角色</label>
										<div class="col-9">
											<select class="form-control" name="role" id="role"><option value="是">是</option>
												<option value="否">否</option></select>
										</div>
									</div>
								</div>
							</div>
							<input type="hidden" name="adminid" id="adminid" value="${admin.adminid}" /><input type="hidden" name="password"
								id="password" value="${admin.password}" /> <input type="hidden" name="addtime" id="addtime"
								value="${admin.addtime}" />

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

