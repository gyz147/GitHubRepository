<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'holidayDetail.jsp' starting page</title>
    
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
	
		#holidayEditTable{
			font-size: 15px;
			border-collapse: collapse;
			width: 350px;
			margin: 20px auto;
		}
		
		#holidayEditTable td{
			height: 40px;
		}
	</style>

  </head>
  
  <body>
    	<table id = "holidayEditTable">
	   		<tr>
	   			<td>
	   			请假编号:
	   			</td>
	   			<td>
	   				${holiday.holidayNo}
	   			</td>
	   		</tr>
	   		<tr>
	   			<td>
	   			申请人:
	   			</td>
	   			<td>
	   				${holiday.holidayName}
	   			</td>
	   		</tr>
	   		<tr>
	   			<td>
	   			请假类型:
	   			</td>
	   			<td>
	         		<c:forEach items="${holidayTypeList}" var="Type" >
	         			<c:if test="${Type.id==holiday.holidayTypeId}">
	         				${Type.value}
	         			</c:if>
	         		</c:forEach>
	   			</td>
	   		</tr>    
	   		<tr>
	   			<td>
	   			请假事由:
	   			</td>
	   			<td>
	   				${holiday.holidayBz}
	   			</td>
	   		</tr>
	   		<tr>
	   			<td>
	   			申请状态:
	   			</td>
	   			<td>
	   				${holiday.holidayStatus}
	   			</td>
	   		</tr>  
	   		<tr>
	   			<td>
	   			开始时间:
	   			</td>
	   			<td>
	   				<fmt:formatDate value="${holiday.startTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
	   			</td>
	   		</tr>
	   		<tr>
	   			<td>
	   			结束时间:
	   			</td>
	   			<td>
	   				<fmt:formatDate value="${holiday.endTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
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
