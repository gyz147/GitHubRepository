<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录乐豆游戏系统</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/style.css" />
	<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
	<script src="js/common.js"></script>
	<!--背景图片自动更换-->
	<script src="js/supersized.3.2.7.min.js"></script>
	<script src="js/supersized-init.js"></script>
	<!--表单验证-->
	<script src="js/jquery.validate.min.js"></script>
	<script type="text/javascript">
		var code=null;
		$(function(){
			$("#sendCode").click(function(){
				var userAccount=$.trim($("#userAccount").val());
				if(""!=userAccount){
					$.ajax({
						type:"GET",
						url:"joyBeans/getCode.action?userAccount="+userAccount,
						dataType:"json",
						success:function(messages){
							var phone=null;
							phone=messages[0];
							code=messages[1];						
							if(null!=phone){
								$("#message").html(phone+"的验证码是："+code);
								$("#message").css("color","white");
								$("#message").css("display","block");
								getCode(60);
							}else{
								$("#message").html("账号不存在！");
								$("#message").css("color","red");
								$("#message").css("display","block");
							}
						}
					});
				}
			});
			
			$(":submit").click(function(){
				if(code !=$("#code").val()){
					alert("验证码有误！");
					return false;
				}
			});
		});
		function getCode(s) {
			$("#sendCode").attr("disabled","disabled");
			$("#sendCode").css("background-color", "#E1E2E3");
			$("#sendCode").css("color", "black");
			$("#sendCode").text(s + "秒");
			if (s <= 0) {
				code=null;
				$("#sendCode").removeAttr("disabled");
				$("#sendCode").css("background-color", "#5CA6D5");
				$("#sendCode").css("color", "white");
				$("#sendCode").text("重新发送");
			} else {
				setTimeout("getCode(" + (s - 1) + ")", 1000);
			}
		}
	</script>
  </head>
  
  <body>
	<div class="login-container">
		<h1>登录乐豆游戏系统</h1>
		<div class="connect">
			<p id="message"></p>
		</div>
		<form action="joyBeans/login.action" method="post" id="loginForm">
			<div>
				<input type="text" name="userAccount" placeholder="用户名" id="userAccount"/>
			</div>
			<div>
				<input type="password" name="userPwd" placeholder="密码" />
			</div>
			<div>
				<input id="code" type="text" name="code" class="code" placeholder="验证码" style="width: 150px;float: left;margin-left: 19px;"/>
				<span><button type="button" style="width: 100px;" id="sendCode">发送验证码</button></span>
			</div>
			<button id="submit" type="submit">登 陆</button>
		</form>
		<a href="beans/joyBeansUser/register.jsp">
			<button type="button" class="register-tis">还有没有账号？</button>
		</a>
	</div>
  </body>
</html>
