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
    
    <title>用户管理</title>
    
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
     <form action=userEdit.do method="post">
	   	<table id = "userAddTable">
	   		<tr>
	   			<td>
	   			账号:
	   			</td>
	   			<td>
	   				<input type = "text" name="userName" id="userName" value="${user.userName}" readonly="readonly"/>
	   			</td>
	   		</tr>
	   		<tr>
	   			<td>
	   			员工编号:
	   			</td>
	   			<td>
	   				<input type = "text" name="empNo" id="empNo" value="${user.empNo}"/>
	   			</td>
	   		</tr>
	   		<tr>
	   			<td>
	   			员工姓名:
	   			</td>
	   			<td>
	   				<input type = "text" name="empName" id="empName" value="${user.empName}"/>
	   			</td>
	   		</tr>
	   		<tr>
	   			<td>
	   			状态:
	   			</td>
	   			<td>
	   				<select name="status">
						<c:choose>
							<c:when test="${user.userStatus=='1'}">
							<option value="1" selected="selected">正常</option>
								<option value="0">注销</option>
							</c:when>
							<c:when test="${user.userStatus=='0'}">
								<option value="0" selected="selected">注销</option>
								<option value="1">正常</option>
							</c:when>
							<c:otherwise>
								<option value="1">正常</option>
								<option value="0">注销</option>
							</c:otherwise>
						</c:choose>
         			</select>
	   			</td>
	   		</tr>  
	   		<tr>
	   			<td>
	   			角色:
	   			</td>
	   			<td>
	   				<select name="roleID" id="roleID">
			        	<c:forEach items="${roleList}" var="role" >
			         		<c:choose>
			         			<c:when test="${role.roleID==user.roleID}">
			         				<option value="${role.roleID}" selected="selected">${role.roleName}</option>
			         			</c:when>
			         			<c:otherwise>
			         				<option value="${role.roleID}">${role.roleName}</option>
			         			</c:otherwise>
			         		</c:choose>
			         	</c:forEach>
	   				</select>
	   			</td>
	   		</tr>
	   		<tr>
	   			<td colspan="2">
	   				<input type = "submit" value="保存"/>&nbsp;&nbsp;&nbsp;
	   				<input type = "reset" value="重置"/>&nbsp;&nbsp;&nbsp;
	   				<input type = "button" value="返回" onclick="javascript:history.go(-1);"/>
	   			</td>
	   		</tr>  	
	   	</table>
   	</form>
  </body>
</html>
