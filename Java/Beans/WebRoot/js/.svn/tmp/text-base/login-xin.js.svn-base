var code; //在全局 定义验证码      
var i;
var timeset;

function createCode() {
	code = "";
	var codeLength = 4;//验证码的长度      
	var checkCode = document.getElementById("checkCode");
	checkCode.value = "";
	var selectChar = new Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D',
			'E', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z');

	for ( var i = 0; i < codeLength; i++) {
		var charIndex = Math.floor(Math.random() * 60);
		code += selectChar[charIndex];
	}
	if (code.length != codeLength) {
		createCode();
	}
	checkCode.value = code;
}

function validate() {

	$("#m-tip").html("");
	$("#c-tip").html("");
	$("#p-tip").html("");

	var mobile = $("#account").val();
	var password = $("#pwd").val();
	var checkCode = $("#checkCode").val();

	if (mobile == "" || mobile == null || mobile == "请输入您的登录帐号") {
		//	$('#mobile-tip').append("<span class='formtips onError' style='color:red'>请输入商户号或注册邮箱</span>");
		$("#m-tip").html("请输入您的登录帐号");
		return false;
	}

	if (inputCode.length <= 0) {
		//alert("请输入验证码！");      
		$("#c-tip").html("请输入验证码！");
		return false;
	} 

	if (password == "" || password == null) {
		//alert("输入正确，输入的验证码为："+inputCode);
		$("#p-tip").html("请输入密码！");

		return false;
	}

	return true;
}

function timeandcode() {
	var str = document.getElementById("codeButton");
	i = i + 1;
	var seconds = 60 - i;
	var str1 = seconds + "秒";
	str.value = str1;

	if (str1 == "0秒") {
		str.value = "发送验证码";
		clearInterval(timeset);
		//$("#checkCode").removeClass("codeval");
		$("#checkCode").val("");
		$("#codeButton").removeAttr("disabled");
		$.ajax({
				type:"POST",
				url:"joyBeanUser/sessionInvalidate.action",
				data:new Date,
				dataType:"text",
				success:function(result){
					if("success" == result){
						$("#checkCode").val("验证码已过期，请重新发送");
					}
				}
			});
	}
}

function code() {
	//alert("111");
	var chars = [ '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' ];
	var codenum = "";
	for ( var j = 0; j < 4; j++) {
		var num = Math.floor(Math.random() * 10);
		codenum += chars[num];
	}
	return codenum;
}

function isEmpty(str) {
	if ("" == $.trim(str) || null == str) {
		return true;
	} else {
		return false;
	}
}