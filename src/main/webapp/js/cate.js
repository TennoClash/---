$(function() {

$("#catename").blur(
		function() {
			$("#catename_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#catename").after("<span id='catename_msg' style='color: red'>项目名称不能为空</span>");
			}
	});







$('#sub').click(function(){
var catename = $("#catename").val();
$("#catename_msg").empty();
if (catename == "" || catename == null) {
	$("#catename").after("<span id='catename_msg' style='color: red'>项目名称不能为空</span>");
	return false;
}
});
$('#res').click(function() {
$("#catename_msg").empty();
});


});
