<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<script type="text/javascript">
	function selok() {
		opener.document.getElementById("image").value = myform.p.value;
		window.close();
	}
</script>
</head>
<body>
	<div class="page-content d-flex align-items-stretch">
		<div class="content-inner form-cont">
			<div class="row">
				<div class="col-md-12">
					<div class="card-header">
						<h3>上传图片</h3>
					</div>
					<form action="upload/image.action" autocomplete="off" name="myform" method="post" enctype="multipart/form-data">
						<div class="row">
							<div class="col-md-12">
								<div class="form-group row">
									<div class="col-9">
										<input type="file" name="image" class="form-control" id="image" />
									</div>
								</div>
							</div>
						</div>
						<c:if test="${imageFileName ne null }">
						${imageFileName } <input type="hidden" name="p" value="upfiles/${imageFileName }" id="p">
							<input type="button" class="btn btn-general btn-white" value="确定 " onclick="selok();" />
						</c:if>
						<c:if test="${imageFileName eq null }">
							<button type="submit" id="sub" class="btn btn-general btn-blue mr-2">上传图片</button>
						</c:if>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>

