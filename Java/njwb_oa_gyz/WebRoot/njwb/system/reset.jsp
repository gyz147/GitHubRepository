<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.njwb.oa.entity.User"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>密码重置</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="<%=basePath%>js/jquery-1.8.3.min.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		body,div,table,tr,td{
			margin: 0px;
			padding: 0px;
		}
	
		#pwdResetTable{
			font-size: 15px;
			border-collapse: collapse;
			width: 450px;
			margin: 20px auto;
			
			
		}
		
		#pwdResetTable td{
			height: 40px;
		}
		
		span{
			font-size: 15px;
			color: red;
		}
	
	</style>
  </head>
  
  <body>
	  <%
	  	User user = (User)session.getAttribute("user");
	 %>
    <form action="njwb/system/doReset.jsp" method="post">
  	<table id = "pwdResetTable">
  		<tr>
  			<td>旧密码</td>
  			<td><input type = "text" name="oldPwd" id="oldPwd"/><span id="span1"></span></td>
  		</tr>
  		<tr>
  			<td>新密码</td>
  			<td><input type = "text" name="newPwd" id="newPwd"/><span id="span2"></span></td>
  		</tr>
  		<tr>
  			<td>确认密码</td>
  			<td><input type = "text" name="confirmPwd" id="confirmPwd"/><span id="span3"></span></td>
  		</tr>
  		<script type="text/javascript">
		$(function(){
			var result1=false;
			var result2=false;
			var result3=false;
			$("#oldPwd").blur(function(){
				if(""!=$(this).val() && $(this).val()!="<%=user.getPwd()%>"){
					$("#span1").html("密码输入错误");
					result1=false;
				}else{
					$("#span1").html("");
					result1=true;
				}
			});
			$("#newPwd").blur(function(){
				if($(this).val() == $("#oldPwd").val()){
					$("#span2").html("请输入新密码");
				}else if($(this).val()!=$("#confirmPwd").val() && ""!=$("#confirmPwd").val()){
					$("#span3").html("两次密码输入不一致");
					result2=false;
				}else{
					$("#span2").html("");
					$("#span3").html("");
					result2=true;
				}
			});
			$("#confirmPwd").blur(function(){
				if(""!=$(this).val() && $(this).val()!=$("#newPwd").val()){
					$("#span3").html("两次密码输入不一致");
					result3=false;
				}else{
					$("#span3").html("");
					result3=true;
				}
			});
			$(":submit").click(function(){
				if(result1==true && result2==true && result3==true){
				return true;
			}else{
				return false;
			}
			});
		});
	</script>
  		<tr>
  			<td colspan="2"><input type = "submit" name="modify" id="modify" value="提交"/></td>
  		</tr>
  	</table>
  	</form>
  </body>
</html>
