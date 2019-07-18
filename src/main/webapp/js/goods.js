$(function() {

$("#goodsname").blur(
		function() {
			$("#goodsname_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#goodsname").after("<span id='goodsname_msg' style='color: red'>建材名称不能为空</span>");
			}
	});

$("#kindid").blur(
		function() {
			$("#kindid_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#kindid").after("<span id='kindid_msg' style='color: red'>建材类似不能为空</span>");
			}
	});

$("#image").blur(
		function() {
			$("#image_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#image").after("<span id='image_msg' style='color: red'>图片不能为空</span>");
			}
	});

$("#price").blur(
		function() {
			$("#price_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#price").after("<span id='price_msg' style='color: red'>出租价格不能为空</span>");
			}
	});

$("#contents").blur(
		function() {
			$("#contents_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#contents").after("<span id='contents_msg' style='color: red'>建材介绍不能为空</span>");
			}
	});







$('#sub').click(function(){
var goodsname = $("#goodsname").val();
var kindid = $("#kindid").val();
var image = $("#image").val();
var price = $("#price").val();
var contents = $("#contents").val();
$("#goodsname_msg").empty();
$("#kindid_msg").empty();
$("#image_msg").empty();
$("#price_msg").empty();
$("#contents_msg").empty();
if (goodsname == "" || goodsname == null) {
	$("#goodsname").after("<span id='goodsname_msg' style='color: red'>建材名称不能为空</span>");
	return false;
}
if (kindid == "" || kindid == null) {
	$("#kindid").after("<span id='kindid_msg' style='color: red'>建材类似不能为空</span>");
	return false;
}
if (image == "" || image == null) {
	$("#image").after("<span id='image_msg' style='color: red'>图片不能为空</span>");
	return false;
}
if (price == "" || price == null) {
	$("#price").after("<span id='price_msg' style='color: red'>出租价格不能为空</span>");
	return false;
}
if (contents == "" || contents == null) {
	$("#contents").after("<span id='contents_msg' style='color: red'>建材介绍不能为空</span>");
	return false;
}
});
$('#res').click(function() {
$("#goodsname_msg").empty();
$("#kindid_msg").empty();
$("#image_msg").empty();
$("#price_msg").empty();
$("#contents_msg").empty();
});


});
