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
    
    <title>角色管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/reset.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
	<script type="text/javascript" src="<%=basePath%>js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript">
		$(function(){
			$("#add").click(function(){
				location.href="njwb/role/roleAdd.jsp";
			});
		});
		function del(roleID){
			if(confirm("确定删除吗？")){
				location.href="roleDel.do?roleID="+roleID;
			}
		}
			
		function edit(roleID){
			location.href="queryRoleForUpdate.do?roleID="+roleID;
		}
	</script>
  </head>
  
  <body>
  	<h1 class="title">
		首页 &gt;&gt;角色管理
	</h1>
	<div class="add">
		<img alt="" src="img/add.png" width="18px" height="18px" id="add">
		添加角色
	</div>
	<table class="roleInfo">
		<tr class="titleRow">
			<td>
				角色ID
			</td>
			<td>
				角色名称
			</td>
			<td>
				操作列表
			</td>
		</tr>
		<c:forEach items="${roleList}" var="role">
		<tr>
	        <td>${role.roleID}</td>
	        <td>${role.roleName}</td>
			<td>
				<img alt="" src="img/delete.png" class="operateImg" onclick="del('${role.roleID}')">
				<img alt="" src="img/edit.png" class="operateImg" onclick="edit('${role.roleID}')">
			</td>
		</tr>
		</c:forEach>
	</table>
  </body>
</html>
