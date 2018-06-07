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
    
    <title>员工编辑</title>
    
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
    <form action="empEdit.do" method="post">
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
	   				<input type = "text" name="empName" id="empName" value="${emp.empName}"/>
	   			</td>
	   		</tr>
	   		<tr>
	   			<td>
	   			所属部门:
	   			</td>
	   			<td>
	   				<select name="empDept" id="empDept">
         			<option value="">未知</option>
	         		<c:forEach items="${deptList}" var="dept" >
	         			<c:choose>
	         				<c:when test="${dept.deptNo==emp.deptNo}">
	         					<option value="${dept.deptNo}" selected="selected">${dept.deptName}</option>
	         				</c:when>
	         				<c:otherwise>
	         					<option value="${dept.deptNo}">${dept.deptName}</option>
	         				</c:otherwise>
	         			</c:choose>
	         		</c:forEach>
         		 </select>
	   			</td>
	   		</tr>    
	   		<tr>
	   			<td>
	   			性别:
	   			</td>
	   			<td>
	   				<select name="empSex" >
						<c:if test="${emp.empSex=='女'}">
							<option value="1">男</option>
	         				<option value="0" selected="selected">女</option>
						</c:if>
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
	   				<input type = "text" name="education" id="education" value="${emp.empEducation}"/>
	   			</td>
	   		</tr>
	   		<tr>
	   			<td>
	   			电子邮箱:
	   			</td>
	   			<td>
	   				<input type = "text" name="email" id="email" value="${emp.empEmail}"/>
	   			</td>
	   		</tr>
	   		<tr>
	   			<td>
	   			电话:
	   			</td>
	   			<td>
	   				<input type = "text" name="phone" id="phone" value="${emp.empPhone}"/>
	   			</td>
	   		</tr>
	   		<tr>
	   			<td>
	   			入职时间:
	   			</td>
	   			<td>
	   				<input type = "text" name="entryTime" id="entryTime" onclick="laydate()" value="${emp.entryTime}"/>
	   			</td>
	   		</tr>   
	   		<tr>
	   			<td colspan="2">
	   				<input type = "submit" value="修改"/>&nbsp;&nbsp;&nbsp;
	   				<input type = "reset" value="重置"/>&nbsp;&nbsp;&nbsp;
	   				<input type = "button" value="返回" onclick="javascript:history.go(-1);"/>
	   			</td>
	   		</tr>  	
	   	</table>
   	</form>
  </body>
</html>
