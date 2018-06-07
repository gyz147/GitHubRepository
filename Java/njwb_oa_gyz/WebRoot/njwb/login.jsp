<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
  <title>用户登录</title>
	
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>css/reset.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>css/login.css">
    <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>

   <style type="text/css">
   body{
   	 background-color: #0070A2;
   }
   </style>
   
   <script type="text/javascript">
   		$(function(){
   			$("#codeImg").click(function(){
  	       		var date  = new Date();//时间戳
  	       		$(this).attr("src","getCertPic.do?date=" + date);
  	  		});
   			$("#loginBtn").click(function(){
   				 var param = "userName=" + $("#userName").val() + "&password=" + $("#password").val() + "&code=" + $("#code").val();
   				 $.ajax({
   					 type:"POST",
   					 url:"login.do",
   					 data:param,
   					 dataType:"text",
   					 success:function(result){
   						if(result=="0"){
   							location.href = "njwb/main.jsp";
   						}else{
	   						if(result=="1"){
	   							$("#errorMsg").html("用户名不能为空");
	   						}else if(result=="2"){
								$("#errorMsg").html("密码不能为空");   							
	   						}else if(result=="3"){
								$("#errorMsg").html("验证码不正确");   							
	   						}else if(result=="4"){
								$("#errorMsg").html("用户名或密码不正确");   							
	   						}
	   						$("#errorMsg").css("color","red");
		  	  	   			$("#codeImg").attr("src","getCertPic.do?date=" + new Date);
		  	  	   			$("#code").val("");
   						} 
   					 }
   				 });
   			});
   		});
   </script>
  </head>
  
  <body>
     <div id = "login">
	     <div id = "title">
     	  		NJWB管理系统
     	  </div>
     	  <table id="loginTable">
     	  		<tr>
     	  			<td>用户名:&nbsp;</td>
     	  			<td>
     	  				<input type= "text" name = "userName" id = "userName"/>
     	  			</td>
     	  		</tr>
     	  		<tr>
     	  			<td>密&nbsp;&nbsp;&nbsp;码:&nbsp;</td>
     	  			<td>
     	  				<input type= "password" name = "password" id = "password"/>
     	  			</td>
     	  		</tr>
      	  		<tr>
     	  			<td>验证码:&nbsp;</td>
     	  			<td>
     	  				<input type= "text" name = "code" id = "code"/><img alt="" src="getCertPic.do" id="codeImg">
     	  			</td>
     	  		</tr>
     	  		
     	  		<tr>
     	  			<td colspan="2">
     	  				<input type= "button" value="登&nbsp;录" class="btn" id="loginBtn"/><span id="errorMsg"></span>
     	  			</td>
     	  		</tr>
     	  		    	  		     	  
     	  </table>     
     </div>
  </body>
</html>
