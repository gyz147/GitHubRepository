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
    
    <title>权限管理</title>
    
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
	
		#permissionAddTable{
			font-size: 15px;
			border-collapse: collapse;
			width: 350px;
			margin: 20px auto;
			margin-top: 100px;			
		}
		
		#permissionAddTable td{
			height: 40px;
		}
		
	</style>

  </head>
  
  <body>
    <form action=permissionEdit.do method="post">
	   	<table id = "permissionAddTable">
	   		<tr>
	   			<td>
	   			角色:${permission.roleID}
	   			</td>
	   			<td>
	        		<c:forEach items="${roleList}" var="role" >
	        			<c:if test="${role.roleID==permission.roleID}">
	        				<input type="text" value="${role.roleName}" readonly="readonly"/>
	        			</c:if>
	        		</c:forEach>
	   			</td>
	   		</tr>
	   		<tr>
	   			<td>
	   			菜单:
	   			</td>
	   			<td>
	   				<select name="menuID" id="menuID">
         				<option value="">请选择</option>
	        				<c:forEach items="${menuList}" var="menu" >
	         					<c:choose>
	         						<c:when test="${menu.menuID==permission.menuID}">
	         							<option value="${menu.menuID}" selected="selected">${menu.menuName}</option>
	         						</c:when>
	         						<c:otherwise>
	         							<option value="${menu.menuID}">${menu.menuName}</option>
	         						</c:otherwise>
	         					</c:choose>
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
	   	<input type="hidden" name="id" value="${permission.id}"/>
   	</form>
  </body>
</html>
