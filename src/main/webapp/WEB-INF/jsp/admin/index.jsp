<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<link href="https://fonts.googleapis.com/css?family=Roboto+Condensed" rel="stylesheet">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="font-awesome-4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/font-icon-style.css">
<link rel="stylesheet" href="css/style.default.css" id="theme-stylesheet">
<link rel="stylesheet" href="css/pages/login.css">
<script src="js/jquery.min.js"></script>
<script src="js/jsencrypt.min.js"></script>
<script type="text/javascript"> 
$(document).ready(
		function() {
			var url = "/fms/admin/getkey.action";
			var Modulus;
			$.post(url, function(data) {
				Modulus = data;
			});

			$("#button1").on("click",function() {
						var username = $("#username").val();
						var password = $("#password").val();
						var encrypt = new JSEncrypt();
						encrypt.setPublicKey(Modulus);
						var password = encrypt.encrypt(password);
						if (password != null && username != ""&& password != null && username != "") {
						 	var url = "/fms/admin/login.action";
							var param = {
									username : username,
									password : password
							};
							$.post(url, param, function(data) {
								
								if (data == "1") {
									location.href = "/fms/admin/main"
								}else{
									alert(data);
								}
							});
						}
					})
		})
	function checkLogin() {
		var username = document.myform.username.value;
		var password = document.myform.password.value;
		if (username == '') {
			alert('请输入用户名');
			document.myform.username.focus();
			return false;
		}
		if (password == '') {
			alert('请输入密码');
			document.myform.password.focus();
			return false;
		}
	}
</script>
<%
	String message = (String) request.getAttribute("message");
	if (message == null) {
		message = "";
	}
	if (!message.trim().equals("")) {
		out.println("<script language='javascript'>");
		out.println("alert('" + message + "');");
		out.println("</script>");
	}
	request.removeAttribute("message");
%>
</head>
<body>
	<section class="hero-area">
		<div class="overlay"></div>
		<div class="container">
			<div class="row">
				<div class="col-md-12 ">
					<div class="contact-h-cont">
						<h3 class="text-center">欢迎使用财务管理系统</h3>
						<br>
						<form action="/ssm/admin/login.action" autocomplete="off" name="myform" method="post"
							onSubmit="return checkLogin()" id="myform">
							<div class="form-group">
								<label for="username">用户名</label> <input type="text" name="username" class="form-control" id="username"
									placeholder="请输入用户名">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">密码</label> <input class="form-control" name="password" type="password"
									placeholder="请输入密码" id="password">
							</div>
							<button class="btn btn-general btn-blue" id="button1" role="button" type="button">&nbsp;登&nbsp;录&nbsp;</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!--Global Javascript -->
	
	<script src="js/tether.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>