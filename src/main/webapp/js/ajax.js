
$(function() {
	$("#btnAdd").click(
			function() {
				var num = $("#hidNum").val(); 
				num = parseInt(num);
				num++;
				$("#hidNum").val(num);
				$("#tRow0").clone(true).attr("id", "tRow" + num).appendTo(
						"#tblData");
				$("#tRow" + num + " td").each(
						function() {
							$(this).find("input[type='text']").val("");
							$(this).find("input[name='num0']").attr("id",
									"num" + num).attr("name", "num" + num);
						});
			});
});

$(function() {
	$("#btnSave").click(function() {
		var objT1 = $(this).closest("tr").find(".m1").val();// 明细单ID
		var objT2 = $(this).closest("tr").find(".m2").val();// 货物名称
		var objT3 = $(this).closest("tr").find(".m3").val();// 数量

		var loc = "";
		var str = "" + objT1 + "," + objT2 + "," + objT3;
			$.ajax({
				type : "POST",
				url : loc + "ajax/save.action?str=" + str,
				contentType : "application/json; charset=utf-8",
				dataType : "text",
				success : function(json) {
					var d = json;
					d = d.replace('"', '');
					d = d.replace('"', '');
					//objTx.val(d);
				},
				error : function() {
					alert("ajax请求发生错误3");
				}
			});
	});
});
