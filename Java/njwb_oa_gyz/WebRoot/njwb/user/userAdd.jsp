<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>账户管理</title>
    
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
	
		#userAddTable{
			font-size: 15px;
			border-collapse: collapse;
			width: 350px;
			margin: 20px auto;
			margin-top: 100px;			
		}
		
		#userAddTable td{
			height: 40px;
		}
		
	</style>
  </head>
  
  <body>
     <form action=userAdd.do method="post">
	   	<table id = "userAddTable">
	   		<tr>
	   			<td>
	   			账号:
	   			</td>
	   			<td>
	   				<input type = "text" name="userName" id="userName"/>
	   			</td>
	   		</tr>
	   		<tr>
	   			<td>
	   			员工编号:
	   			</td>
	   			<td>
	   				<input type = "text" name="empNo" id="empNo"/>
	   			</td>
	   		</tr>
	   		<tr>
	   			<td>
	   			员工姓名:
	   			</td>
	   			<td>
	   				<input type = "text" name="empName" id="empName"/>
	   			</td>
	   		</tr>
	   		<tr>
	   			<td>
	   			状态:
	   			</td>
	   			<td>
	   				<select name="status">
	         			<option value="1">正常</option>
	         			<option value="0">注销</option>
         			</select>
	   			</td>
	   		</tr>  
	   		<tr>
	   			<td>
	   			角色:
	   			</td>
	   			<td>
	   				<select name="roleID" id="roleID">
	   					<option value="">请选择</option>
	        			<c:forEach items="${roleList}" var="role" >
	        				<option value="${role.roleID}">${role.roleName}</option>
	        			</c:forEach>
	   				</select>
	   			</td>
	   		</tr>
	   		<tr>
	   			<td colspan="2">
	   				<input type = "submit" value="保存"/>&nbsp;&nbsp;&nbsp;
	   				<input type = "reset" value="重置"/>
	   			</td>
	   		</tr>  	
	   	</table>
   	</form>
  </body>
</html>
