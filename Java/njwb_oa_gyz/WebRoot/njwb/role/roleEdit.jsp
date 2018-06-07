<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'roleEdit.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">
		body,div,table,tr,td{
			margin: 0px;
			padding: 0px;
		}
	
		#roleAddTable{
			font-size: 15px;
			border-collapse: collapse;
			width: 350px;
			margin: 20px auto;
			
			
		}
		
		#roleAddTable td{
			height: 40px;
		}
	
	</style>

  </head>
  
  <body>
   <form action=roleEdit.do method="post">
   	<table id = "roleAddTable">
   			<tr>
	   			<td>
	   			角色ID:
	   			</td>
	   			<td>
	   				<input type = "text" name="roleID" id="roleID" readonly="readonly" value="${role.roleID}"/>
	   			</td>
	   		</tr>
	   		<tr>
	   			<td>
	   			角色名称:
	   			</td>
	   			<td>
	   				<input type = "text" name="roleName" id="roleName" value="${role.roleName}"/>
	   			</td>
	   		</tr>
	   		<tr>
	   			<td colspan="2">
	   				<input type = "submit" value="修改"/>
	   				<input type = "reset" value="重置"/>
	   				<input type = "button" value="返回" onclick="javascript:history.go(-1);"/>
	   			</td>
	   		</tr>  	
	   	</table>
	 </form>  	
  </body>
</html>
