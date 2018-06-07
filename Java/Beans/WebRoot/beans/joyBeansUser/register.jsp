<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户注册</title>
    
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
	var accountConfig=false;
	var phoneConfig=false;
	$(function(){
		$("#userAccount").keyup(function(){
			var userAccount=$.trim($("#userAccount").val());
			if(""!=userAccount){
				$.ajax({
					type:"GET",
					url:"joyBeans/accountIsExist.action?userAccount="+userAccount,
					dataType:"text",
					success:function(message){
						if("exist"==message){
							alert("用户名已存在");
							accountConfig=false;
						}else{
							accountConfig=true;
						}
					}
				});
			}
		});
		$("#userPhone").keyup(function(){
			var userPhone=$.trim($("#userPhone").val());
			if(userPhone.length==11 && ""!=userPhone){
				$.ajax({
					type:"GET",
					url:"joyBeans/phoneIsExist.action?userPhone="+userPhone,
					dataType:"text",
					success:function(message){
						if("exist"==message){
							alert("手机号已注册");
							phoneConfig=false;
						}else if("notUse"==message){
							alert("手机号不存在");
							phoneConfig=false;
						}else{
							phoneConfig=true;
						}
					}
				});
			}
		});
		$(":submit").click(function(){
			if(accountConfig && phoneConfig){
				return true;
			}else{
				return false;
				continue;
			}
		});
	});
	</script>
  </head>
  
  <body>
	<div class="register-container">
		<h1>乐豆游戏用户注册</h1>
		<div class="connect">
			<p>欢迎您成为乐豆游戏系统的一员</p>
		</div>
		<form action="joyBeans/register.action" method="post" id="registerForm">
			<div>
				<input type="text" name="userAccount" id="userAccount" placeholder="您的用户名" autocomplete="off"/>
			</div>
			<div>
				<input type="password" name="userPwd" class="userPwd" placeholder="输入密码" oncontextmenu="return false" onpaste="return false" />
			</div>
			<div>
				<input type="password" name="confirm_userPwd" placeholder="再次输入密码" oncontextmenu="return false" onpaste="return false" />
			</div>
			<div>
				<input type="text" name="userName" placeholder="输入用户姓名" autocomplete="off"/>
			</div>
			<div>
				<input type="text" name="userPhone" placeholder="输入手机号码" autocomplete="off" id="userPhone"/>
			</div>
			<button id="submit" type="submit">注 册</button>
		</form>
		<a href="beans/joyBeansUser/login.jsp">
			<button type="button" class="register-tis">已经有账号？</button>
		</a>
	</div>
  </body>
</html>
