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
	<link rel="stylesheet" type="text/css" href="css/reset.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
	<script type="text/javascript" src="<%=basePath%>js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript">
		$(function(){
			$("#add").click(function(){
				location.href="njwb/permission/permissionAdd.jsp";
			});
			$("#queryPermission").click(function(){
				location.href="queryPermissions.do?roleID="+$("#roleID").val()+"&menuID="+$("#menuID").val();
			});
		});
		function del(id){
			if(confirm("确定删除吗？")){
				location.href="permissionDel.do?id="+id;
			}
		}
			
		function edit(id){
			location.href="queryPermissionForUpdate.do?id="+id;
		}
	</script>
  </head>
  
  <body>
  	<h1 class="title">
		首页 &gt;&gt;权限管理
	</h1>
	<div class="add">
		<img alt="" src="img/add.png" width="18px" height="18px" id="add">
		添加权限
	</div>
	<div id="query" class="query">
         角色：<select name="roleID" id="roleID">
					<option value="">请选择</option>
					<c:forEach items="${roleList}" var="role" >
	         		<c:choose>
	         			<c:when test="${role.roleID==roleID}">
	         				<option value="${role.roleID}" selected="selected">${role.roleName}</option>
	         			</c:when>
	         			<c:otherwise>
	         				<option value="${role.roleID}">${role.roleName}</option>
	         			</c:otherwise>
	         		</c:choose>
	         	</c:forEach>
				 </select>&nbsp;&nbsp;&nbsp;
         菜单：<select name="menuID" id="menuID">
         		<option value="">请选择</option>
	        	<c:forEach items="${menuList}" var="menu" >
	         		<c:choose>
	         			<c:when test="${menu.menuID==menuID}">
	         				<option value="${menu.menuID}" selected="selected">${menu.menuName}</option>
	         			</c:when>
	         			<c:otherwise>
	         				<option value="${menu.menuID}">${menu.menuName}</option>
	         			</c:otherwise>
	         		</c:choose>
	         	</c:forEach>
         	</select>&nbsp;&nbsp;&nbsp;
         <input type="button" value="查询" id="queryPermission">
    </div>
	<table class="permissionInfo">
		<tr class="titleRow">
			<td>
				角色ID
			</td>
			<td>
				角色姓名
			</td>
			<td>
				菜单ID
			</td>
			<td>
				菜单名称
			</td>
			<td>
				操作列表
			</td>
		</tr>
	<c:forEach items="${pageModel.dataList}" var="permission">
		<tr>
	        <td>${permission.roleID}</td>
	        <td>${permission.roleName}</td>
	        <td>${permission.menuID}</td>
	        <td>${permission.menuName}</td>
			<td>
				<img alt="" src="img/delete.png" class="operateImg" onclick="del('${permission.id}')">
				<img alt="" src="img/edit.png" class="operateImg" onclick="edit('${permission.id}')">
			</td>
		</tr>
	</c:forEach>
		<tr>
			<td colspan="5">
				<a href="queryPermissions.do?pageNo=${pageModel.firstPage}&roleID=${roleID}&menuID=${menuID}">首页</a>&nbsp;&nbsp;
				<a href="queryPermissions.do?pageNo=${pageModel.prePage}&roleID=${roleID}&menuID=${menuID}">上一页</a>&nbsp;&nbsp;
				<a href="queryPermissions.do?pageNo=${pageModel.nextPage}&roleID=${roleID}&menuID=${menuID}">下一页</a>&nbsp;&nbsp;
				<a href="queryPermissions.do?pageNo=${pageModel.lastPage}&roleID=${roleID}&menuID=${menuID}">尾页</a> &nbsp;&nbsp;&nbsp;
				<span>第${pageModel.pageNo}/${pageModel.totalPage}页</span>
			</td>
		</tr>
	</table>
  </body>
</html>
