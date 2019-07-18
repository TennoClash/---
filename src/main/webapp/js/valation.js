$(function() {
	$("#username").blur(function() {
		var username = $("#username").val();
		if (username == "") {
			$("#usernamerror").html("请输入用户名");
		} else {
			$("#usernamerror").html("");
		}
	});
});
$(function() {
	$("#password").blur(function() {
		var password = $("#password").val();
		if (password == "") {
			$("#passworderror").html("请输入密码");
		} else {
			$("#passworderror").html("");
		}
	});
});
$(function() {
	$("#repassword").blur(function() {
		var repassword = $("#repassword").val();
		var password = $("#password").val();
		if (repassword == "") {
			$("#repassworderror").html("请输入校验密码");
		} else if (repassword != password) {
			$("#repassworderror").html("密码校验失败");
		} else {
			$("#repassworderror").html("");
		}
	});
});
$(function() {
	$("#realname").blur(function() {
		var realname = $("#realname").val();
		if (realname == "") {
			$("#realnamerror").html("请输入姓名");
		} else {
			$("#realnamerror").html("");
		}
	});
});
$(function() {
	$("#birthday").change(function() {
		var birthday = $("#birthday").val();
		$("#birthdayerror").html("请选择出生日期");
	});
});
$(function() {
	$("#contact").blur(function() {
		var contact = $("#contact").val();
		var myreg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
		if (!myreg.test(contact)) {
			$("#contacterror").html("请输入11位手机号码！");
		}
	});
});
$(function() {
	$("#address").blur(function() {
		var address = $("#address").val();
		if (address == "") {
			$("#addresserror").html("请输入联系地址");
		} else {
			$("#addresserror").html("");
		}
	});
});
$(function() {
	$("#idcard").blur(function() {
		var idcard = $("#idcard").val();
		if (idcard == "") {
			$("#idcarderror").html("请输入身份证");
		} else {
			$("#idcarderror").html("");
		}
	});
});
$(function() {
	$("#email").blur(function() {
		var email = $("#email").val();
		var myreg = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
		if (!myreg.test(email)) {
			$("#emailerror").html("请输入正确的邮箱格式！");
		}
	});
});

$(function() {
	$("#btn").click(function() {
		var username = $("#username").val();
		var password = $("#password").val();
		var repassword = $("#repassword").val();
		var realname = $("#realname").val();
		var birthday = $("#birthday").val();
		var contact = $("#contact").val();
		var email = $("#email").val();
		var address = $("#address").val();
		var idcard = $("#idcard").val();
		var image = $("#image").val();
		var flag = false;
		if (username == "") {
			$("#usernamerror").html("请输入用户名");
			flag = false;
		} else {
			$("#usernamerror").html("");
			flag = true;
		}
		if (password == "") {
			$("#passworderror").html("请输入密码");
			flag = false;
		} else {
			$("#passworderror").html("");
			flag = true;
		}
		if (repassword == "") {
			$("#repassworderror").html("请输入校验密码");
			flag = false;
		} else if (repassword != password) {
			$("#repassworderror").html("密码校验失败");
			flag = false;
		} else {
			$("#repassworderror").html("");
			flag = true;
		}
		if (realname == "") {
			$("#realnamerror").html("请输入姓名");
			flag = false;
		} else {
			$("#realnamerror").html("");
			flag = true;
		}
		if (birthday == "") {
			$("#birthdayerror").html("请选择出生日期");
			flag = false;
		} else {
			$("#birthdayerror").html("");
			flag = true;
		}
		if (contact == "") {
			$("#contacterror").html("请输入联系电话");
			flag = false;
		} else {
			$("#contacterror").html("");
			flag = true;
		}
		var myreg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
		if (!myreg.test(contact)) {
			$("#contacterror").html("请输入11位手机号码！");
			flag = false;
		}
		if (address == "") {
			$("#addresserror").html("请输入联系地址");
			flag = false;
		} else {
			$("#addresserror").html("");
			flag = true;
		}
		if (email == "") {
			$("#emailerror").html("请输入电子邮件");
			flag = false;
		} else {
			$("#emailerror").html("");
			flag = true;
		}
		var xmyreg = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
		if (!xmyreg.test(email)) {
			$("#emailerror").html("请输入正确的邮箱格式！");
			flag = false;
		}
		if (idcard == "") {
			$("#idcarderror").html("请输入身份证");
			flag = false;
		} else {
			$("#idcarderror").html("");
			flag = true;
		}
		if (image == "") {
			$("#imageerror").html("请选择头像");
			flag = false;
		} else {
			$("#imageerror").html("");
			flag = true;
		}
		if (flag) {
			$("#myform").submit()
		}else{
			$("#usernameerror").html("XXXX");
		}
	});
});
