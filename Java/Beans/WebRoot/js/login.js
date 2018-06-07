$(function() {
	$("#sendCode").click(function(){
		code(60);
	});
});
function code(s) {
	$("#sendCode").unbind("click");
	$("#sendCode").css("background-color", "#E1E2E3");
	$("#sendCode").css("color", "black");
	$("#sendCode").val(s + "秒");
	if (s <= 0) {
		$("#sendCode").bind("click", function(){code(60);});
		$("#sendCode").css("background-color", "#00AAEE");
		$("#sendCode").css("color", "white");
		$("#sendCode").val("重新发送");
	} else {
		setTimeout("code(" + (s - 1) + ")", 1000);
	}
}