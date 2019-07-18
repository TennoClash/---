$(function() {

$("#kindname").blur(
		function() {
			$("#kindname_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#kindname").after("<span id='kindname_msg' style='color: red'>类型名称不能为空</span>");
			}
	});







$('#sub').click(function(){
var kindname = $("#kindname").val();
$("#kindname_msg").empty();
if (kindname == "" || kindname == null) {
	$("#kindname").after("<span id='kindname_msg' style='color: red'>类型名称不能为空</span>");
	return false;
}
});
$('#res').click(function() {
$("#kindname_msg").empty();
});


});
