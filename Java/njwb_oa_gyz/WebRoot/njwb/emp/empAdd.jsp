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
    
    <title>My JSP 'empAdd.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="js/laydate/laydate.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		body,div,table,tr,td{
			margin: 0px;
			padding: 0px;
		}
	
		#empAddTable{
			font-size: 15px;
			border-collapse: collapse;
			width: 350px;
			margin: 20px auto;
			
			
		}
		
		#empAddTable td{
			height: 40px;
		}
	
	</style>
  </head>
  <body>
       <form action=empAdd.do method="post">
	   	<table id = "empAddTable">
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
	   			员工名称:
	   			</td>
	   			<td>
	   				<input type = "text" name="empName" id="empName"/>
	   			</td>
	   		</tr>  
			<tr>
	   			<td>
	   			所属部门:
	   			</td>
	   			<td>
	   				<select name="empDept">
	         			<c:forEach items="${deptList}" var="dept" >
	         				<option value="${dept.deptNo}">${dept.deptName}</option>
	         			</c:forEach>
         			</select>
	   			</td>
	   		</tr>  
	   		<tr>
	   			<td>
	   			性别:
	   			</td>
	   			<td>
	   				<select name="sex">
	         			<option value="1">男</option>
	         			<option value="0">女</option>
         			</select>
	   			</td>
	   		</tr>  
	   		<tr>
	   			<td>
	   			学历:
	   			</td>
	   			<td>
	   				<input type = "text" name="education" id="education"/>
	   			</td>
	   		</tr>
	   		<tr>
	   			<td>
	   			电子邮箱:
	   			</td>
	   			<td>
	   				<input type = "text" name="email" id="email"/>
	   			</td>
	   		</tr>
	   		<tr>
	   			<td>
	   			电话:
	   			</td>
	   			<td>
	   				<input type = "text" name="phone" id="phone"/>
	   			</td>
	   		</tr>
	   		<tr>
	   			<td>
	   			入职时间:
	   			</td>
	   			<td>
	   				<input type = "text" name="entryTime" id="entryTime" class="laydate-icon" onclick="laydate()"/>
	   			</td>
	   		</tr>        
	   		<tr>
	   			<td colspan="2">
	   				<input type = "submit" value="添加"/>
	   				<input type = "reset" value="重置"/>
	   			</td>
	   		</tr>  	
	   	</table>
   	</form>
  </body>
</html>
