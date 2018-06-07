<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>员工明细</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		body,div,table,tr,td{
			margin: 0px;
			padding: 0px;
		}
	
		#empEditTable{
			font-size: 15px;
			border-collapse: collapse;
			width: 350px;
			margin: 20px auto;
			
			
		}
		
		#empEditTable td{
			height: 40px;
		}
	
	</style>
  </head>
  
  <body>
    	<table id = "empEditTable">
	   		<tr>
	   			<td>
	   			员工编号:
	   			</td>
	   			<td>
	   				<input type = "text" name="empNo" id="empNo" value="${emp.empNo}" readonly="readonly"/>
	   			</td>
	   		</tr>
	   		<tr>
	   			<td>
	   			员工姓名:
	   			</td>
	   			<td>
	   				<input type = "text" name="empName" id="empName" value="${emp.empName}" readonly="readonly"/>
	   			</td>
	   		</tr>
	   		<tr>
	   			<td>
	   			所属部门:
	   			</td>
	   			<td>
	         		<c:forEach items="${deptList}" var="dept" >
	         			<c:if test="${dept.deptNo==emp.deptNo}">
	         				<input type = "text" name="empDept" id="empDept" value="${dept.deptName}" readonly="readonly"/>
	         			</c:if>
	         		</c:forEach>
	   			</td>
	   		</tr>    
	   		<tr>
	   			<td>
	   			性别:
	   			</td>
	   			<td>
	   				<input type = "text" name="empSex" id="empSex" value="${emp.empSex}" readonly="readonly"/>
	   			</td>
	   		</tr>  
	   		<tr>
	   			<td>
	   			学历:
	   			</td>
	   			<td>
	   				<input type = "text" name="education" id="education" value="${emp.empEducation}" readonly="readonly"/>
	   			</td>
	   		</tr>
	   		<tr>
	   			<td>
	   			电子邮箱:
	   			</td>
	   			<td>
	   				<input type = "text" name="email" id="email" value="${emp.empEmail}" readonly="readonly"/>
	   			</td>
	   		</tr>
	   		<tr>
	   			<td>
	   			电话:
	   			</td>
	   			<td>
	   				<input type = "text" name="phone" id="phone" value="${emp.empPhone}" readonly="readonly"/>
	   			</td>
	   		</tr>
	   		<tr>
	   			<td>
	   			入职时间:
	   			</td>
	   			<td>
	   				<input type = "text" name="entryTime" id="entryTime" value="${emp.entryTime}" readonly="readonly"/>
	   			</td>
	   		</tr> 
	   		<tr>
	   			<td colspan="2">
	   				<input type = "button" value="返回" onclick="javascript:history.go(-1);"/>
	   			</td>
	   		</tr>  	
	   	</table>
  </body>
</html>
