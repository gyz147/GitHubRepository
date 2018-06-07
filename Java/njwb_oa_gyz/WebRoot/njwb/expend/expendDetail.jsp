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
    
    <title>报销详情</title>
    
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
	
		#expendEditTable{
			font-size: 15px;
			border-collapse: collapse;
			width: 350px;
			margin: 20px auto;
			margin-top: 100px;			
		}
		
		#expendEditTable td{
			height: 40px;
		}
	</style>
  </head>
  
  <body>
    <table id = "expendEditTable">
	   		<tr>
	   			<td>
	   			报销编号:
	   			</td>
	   			<td>
	   				<input type="text" name="expendNo" readonly="readonly" value="${expend.expendNo}"/>
	   			</td>
	   		</tr>
	   		<tr>
	   			<td>
	   			申请人:
	   			</td>
	   			<td>
	   				<input type="text" name="expendName" value="${expend.expendName}" readonly="readonly"/>
	   			</td>
	   		</tr>        
	   		<tr>
	   			<td>
	   			报销类型:
	   			</td>
	   			<td>
	   				<c:forEach items="${expendTypeList}" var="Type" >
	         			<c:if test="${Type.id==expend.expendTypeId}">
	         				<input type = "text" name="expendType" id="expendType" value="${Type.value}" readonly="readonly"/>
	         			</c:if>
	         		</c:forEach>
	   			</td>
	   		</tr>
	   		<tr>
	   			<td>
	   			摘要:
	   			</td>
	   			<td>
	   				<textarea rows="5" cols="30" name="expendBz" readonly="readonly">${expend.expendBz}</textarea>
	   			</td>
	   		</tr>
	   		<tr>
	   			<td>
	   			金额:
	   			</td>
	   			<td>
	   				<input type="text" name="expendCount" value="${expend.expendCount}" readonly="readonly"/>
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
