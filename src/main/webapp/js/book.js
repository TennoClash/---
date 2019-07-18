$(function() {

$("#bookno").blur(
		function() {
			$("#bookno_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#bookno").after("<span id='bookno_msg' style='color: red'>收支单号不能为空</span>");
			}
	});

$("#cateid").blur(
		function() {
			$("#cateid_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#cateid").after("<span id='cateid_msg' style='color: red'>收支项目不能为空</span>");
			}
	});

$("#money").blur(
		function() {
			$("#money_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#money").after("<span id='money_msg' style='color: red'>金额不能为空</span>");
			}
	});

$("#adminid").blur(
		function() {
			$("#adminid_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#adminid").after("<span id='adminid_msg' style='color: red'>经手人不能为空</span>");
			}
	});

$("#memo").blur(
		function() {
			$("#memo_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#memo").after("<span id='memo_msg' style='color: red'>备注不能为空</span>");
			}
	});







$('#sub').click(function(){
var bookno = $("#bookno").val();
var cateid = $("#cateid").val();
var money = $("#money").val();
var adminid = $("#adminid").val();
var memo = $("#memo").val();
$("#bookno_msg").empty();
$("#cateid_msg").empty();
$("#money_msg").empty();
$("#adminid_msg").empty();
$("#memo_msg").empty();
if (bookno == "" || bookno == null) {
	$("#bookno").after("<span id='bookno_msg' style='color: red'>收支单号不能为空</span>");
	return false;
}
if (cateid == "" || cateid == null) {
	$("#cateid").after("<span id='cateid_msg' style='color: red'>收支项目不能为空</span>");
	return false;
}
if (money == "" || money == null) {
	$("#money").after("<span id='money_msg' style='color: red'>金额不能为空</span>");
	return false;
}
if (adminid == "" || adminid == null) {
	$("#adminid").after("<span id='adminid_msg' style='color: red'>经手人不能为空</span>");
	return false;
}
if (memo == "" || memo == null) {
	$("#memo").after("<span id='memo_msg' style='color: red'>备注不能为空</span>");
	return false;
}
});
$('#res').click(function() {
$("#bookno_msg").empty();
$("#cateid_msg").empty();
$("#money_msg").empty();
$("#adminid_msg").empty();
$("#memo_msg").empty();
});


});
