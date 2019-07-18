function selimage() {
	window
			.open(
					"saveimage",
					"",
					"toolbar=no,location=no,directories=no,status=no,menubar=no,resizable=yes,copyhistory=no,scrollbars=yes,width=400,height=240,top="
							+ (screen.availHeight - 240)
							/ 2
							+ ",left="
							+ (screen.availWidth - 400) / 2 + "");
}
function print(id) {
	window
			.open(
					"index/print.action?id=" + id,
					"",
					"toolbar=no,location=no,directories=no,status=no,menubar=no,resizable=yes,copyhistory=no,scrollbars=yes,width=800,height=480,top="
							+ (screen.availHeight - 240)
							/ 2
							+ ",left="
							+ (screen.availWidth - 400) / 2 + "");
}