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
	<link rel="stylesheet" type="text/css" href="css/reset.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
	<script type="text/javascript" src="<%=basePath%>js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript">
		$(function(){
			$("#add").click(function(){
				location.href="njwb/user/userAdd.jsp";
			});
			$("#queryUser").click(function(){
				location.href="queryUsers.do?userName="+$("#userName").val()+"&roleID="+$("#roleID").val()+"&status="+$("#status").val();
			});
			$("#userName").keyup(function(){
				var name = $.trim($("#userName").val());
				if("" != name){
  				$.ajax({
  					type:"GET",
  					url:"queryUsersByName.do?name=" + name,
  					dataType:"json",
  					success:function(names){
  					    var htmlStr = "";
  						for(var i = 0; i < names.length; i++){
  							htmlStr += " <div onmouseover='setBgColor(this)' onmouseout='resetBgColor(this)' onclick='selectName(this)'>"
  							             + names[i]
  							             + "</div>"
  						}
  						if(names.length != 0){
  							$("#nameContainer").html(htmlStr);
  							$("#nameContainer").css("display","block");
  						}
  					}
  				});
  			  }else{
  			    $("#nameContainer").html("");
  			    $("#nameContainer").css("display","none");
  			  }
			});
		});
		
		function setBgColor(obj){
		    $(obj).removeClass("resetColor");
		  	$(obj).addClass("selectedColor");	
		  }
		  
		  function resetBgColor(obj){
		    $(obj).removeClass("selectedColor");
		    $(obj).addClass("resetColor");	
		  }
		  
		  function selectName(obj){
		    $("#userName").val($.trim($(obj).text()));
		    $("#nameContainer").css("display","none");
		  }
		
		function del(userName){
			if(confirm("确定删除吗？")){
				location.href="userDel.do?userName="+userName;
			}
		}
			
		function edit(userName){
			location.href="queryUserForUpdate.do?userName="+userName;
		}
	</script>
	<style type="text/css">
	   *{
	   	 	margin: 0px;
	   	 	padding: 0px;
	    }
	
	   #nameContainer{
	   	  width: 67px;
	   	  border: 1px solid #9FBAD6;
	      position: absolute;
	      left:47px;
	      display: none;
	      background-color: white;
	   }
	   
	   .selectedColor{
	   	  background-color: #DBEAF9;
	   }
	   .resetColor{
	   	  background-color: white;
	   }
	 </style>
  </head>
  
  <body>
  	<h1 class="title">
		首页 &gt;&gt;账户管理
	</h1>
	<div class="add">
		<img alt="" src="img/add.png" width="18px" height="18px" id="add">
		添加账户
	</div>
	<div id="query" class="query">
         账号：<div id="nameContainer"></div>
         <input type="text" style="width:100px" id="userName" value="${userName}" autocomplete="off">&nbsp;&nbsp;&nbsp;
         账号状态：<select name="status" id="status">
					<option value="">请选择</option>
					<c:choose>
						<c:when test="${status=='1'}">
							<option value="0">注销</option>
							<option value="1" selected="selected">正常</option>
						</c:when>
						<c:when test="${status=='0'}">
							<option value="0" selected="selected">注销</option>
							<option value="1">正常</option>
						</c:when>
						<c:otherwise>
							<option value="0">注销</option>
							<option value="1">正常</option>
						</c:otherwise>
					</c:choose>
				 </select>&nbsp;&nbsp;&nbsp;
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
         <input type="button" value="查询" id="queryUser">
    </div>
	<table class="roleInfo">
		<tr class="titleRow">
			<td>
				账号
			</td>
			<td>
				员工姓名
			</td>
			<td>
				状态
			</td>
			<td>
				角色
			</td>
			<td>
				操作列表
			</td>
		</tr>
	<c:forEach items="${pageModel.dataList}" var="user">
		<tr>
	        <td>${user.userName}</td>
	        <td>${user.empName}</td>
	        <td>${user.userStatus}</td>
	        <td>${user.roleName}</td>
			<td>
				<img alt="" src="img/delete.png" class="operateImg" onclick="del('${user.userName}')">
				<img alt="" src="img/edit.png" class="operateImg" onclick="edit('${user.userName}')">
			</td>
		</tr>
	</c:forEach>
		<tr>
			<td colspan="5">
				<a href="queryUsers.do?pageNo=${pageModel.firstPage}&userName=${userName}&roleID=${roleID}&status=${status}">首页</a>&nbsp;&nbsp;
				<a href="queryUsers.do?pageNo=${pageModel.prePage}&userName=${userName}&roleID=${roleID}&status=${status}">上一页</a>&nbsp;&nbsp;
				<a href="queryUsers.do?pageNo=${pageModel.nextPage}&userName=${userName}&roleID=${roleID}&status=${status}">下一页</a>&nbsp;&nbsp;
				<a href="queryUsers.do?pageNo=${pageModel.lastPage}&userName=${userName}&roleID=${roleID}&status=${status}">尾页</a> &nbsp;&nbsp;&nbsp;
				<span>第${pageModel.pageNo}/${pageModel.totalPage}页</span>
			</td>
		</tr>
	</table>
  </body>
</html>
