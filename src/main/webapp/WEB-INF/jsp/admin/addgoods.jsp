<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><jsp:include page="check_logstate.jsp"></jsp:include>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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
<script type="text/javascript" src="js/goods.js" charset="utf-8"></script>
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
							<h3>新增建材信息</h3>
						</div>
						<br>
						<form action="goods/addGoods.action" autocomplete="off" name="myform" method="post" onsubmit="return check()">
							<div class="row">
								<div class="col-md-12">
									<div class="form-group row">
										<label style="width: 85px;" class=" col-form-label">建材名称</label>
										<div class="col-9">
											<input type="text" name="goodsname" class="form-control" id="goodsname" placeholder="请输入建材名称" />
										</div>
									</div>
									<div class="form-group row">
										<label style="width: 85px;" class=" col-form-label">建材类似</label>
										<div class="col-9">
											<select name="kindid" class="form-control" id="kindid"><c:forEach items="${kindList}" var="kind">
													<option value="${kind.kindid}">${kind.kindname }</option>
												</c:forEach></select>
										</div>
									</div>
									<div class="form-group row">
										<label style="width: 85px;" class=" col-form-label">图片</label>
										<div class="col-9">
											<script type="text/javascript" src="js/selimage.js"></script>
											<input class="form-control" type="text" name="goods.image" id="image" onclick="selimage();"
												placeholder="请选择图片" readonly="readonly" />
										</div>
									</div>
									<div class="form-group row">
										<label style="width: 85px;" class=" col-form-label">出租价格</label>
										<div class="col-9">
											<input type="text" name="price" class="form-control" id="price" placeholder="请输入出租价格" />
										</div>
									</div>
									<div class="form-group row">
										<label style="width: 85px;" class=" col-form-label">建材介绍</label>
										<div class="col-9">
											<script type="text/javascript" src="ckeditor/ckeditor.js"></script>
											<textarea cols="80" name="contents" id="contents" rows="10" placeholder="请输入建材介绍"> </textarea>
											<script type="text/javascript">
												CKEDITOR.replace('contents', {
													language : 'zh-cn'
												});
											</script>
										</div>
									</div>

								</div>
							</div>
							<button type="submit" id="sub" class="btn btn-general btn-blue mr-2">提交保存</button>
							<button type="reset" class="btn btn-general btn-white">取消重置</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>

