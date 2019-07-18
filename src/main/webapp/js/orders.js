$(function() {

$("#usersid").blur(
		function() {
			$("#usersid_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#usersid").after("<span id='usersid_msg' style='color: red'>用户不能为空</span>");
			}
	});

$("#ordercode").blur(
		function() {
			$("#ordercode_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#ordercode").after("<span id='ordercode_msg' style='color: red'>订单号不能为空</span>");
			}
	});

$("#addtime").blur(
		function() {
			$("#addtime_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#addtime").after("<span id='addtime_msg' style='color: red'>下单日期不能为空</span>");
			}
	});

$("#way").blur(
		function() {
			$("#way_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#way").after("<span id='way_msg' style='color: red'>结算方式不能为空</span>");
			}
	});

$("#status").blur(
		function() {
			$("#status_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#status").after("<span id='status_msg' style='color: red'>状态不能为空</span>");
			}
	});







$('#sub').click(function(){
var usersid = $("#usersid").val();
var ordercode = $("#ordercode").val();
var addtime = $("#addtime").val();
var way = $("#way").val();
var status = $("#status").val();
$("#usersid_msg").empty();
$("#ordercode_msg").empty();
$("#addtime_msg").empty();
$("#way_msg").empty();
$("#status_msg").empty();
if (usersid == "" || usersid == null) {
	$("#usersid").after("<span id='usersid_msg' style='color: red'>用户不能为空</span>");
	return false;
}
if (ordercode == "" || ordercode == null) {
	$("#ordercode").after("<span id='ordercode_msg' style='color: red'>订单号不能为空</span>");
	return false;
}
if (addtime == "" || addtime == null) {
	$("#addtime").after("<span id='addtime_msg' style='color: red'>下单日期不能为空</span>");
	return false;
}
if (way == "" || way == null) {
	$("#way").after("<span id='way_msg' style='color: red'>结算方式不能为空</span>");
	return false;
}
if (status == "" || status == null) {
	$("#status").after("<span id='status_msg' style='color: red'>状态不能为空</span>");
	return false;
}
});
$('#res').click(function() {
$("#usersid_msg").empty();
$("#ordercode_msg").empty();
$("#addtime_msg").empty();
$("#way_msg").empty();
$("#status_msg").empty();
});


});
