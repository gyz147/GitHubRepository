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
    
    <title>报销信息修改</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript">
		$(function(){
			$("#notToDo").click(function(){
				$("#status").val("0");
			});
			$("#ToDo").click(function(){
				$("#status").val("1");
			});
		});	
	</script>
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
     <form action=expendEdit.do method="post">
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
	   				<input type="text" name="expendName" value="${expend.expendName}"/>
	   			</td>
	   		</tr>        
	   		<tr>
	   			<td>
	   			报销类型:
	   			</td>
	   			<td>
	   				<select name="expendType">
	   					<option value="">未知</option>
	         			<c:forEach items="${expendTypeList}" var="Type" >
	         				<c:choose>
	         					<c:when test="${Type.id==expend.expendTypeId}">
	         						<option value="${Type.id}" selected="selected">${Type.value}</option>
	         					</c:when>
	         					<c:otherwise>
	         						<option value="${Type.id}">${Type.value}</option>
	         					</c:otherwise>
	         				</c:choose>
	         			</c:forEach>
         			</select>
	   			</td>
	   		</tr>
	   		<tr>
	   			<td>
	   			摘要:
	   			</td>
	   			<td>
	   				<textarea rows="5" cols="30" name="expendBz">${expend.expendBz}</textarea>
	   			</td>
	   		</tr>
	   		<tr>
	   			<td>
	   			金额:
	   			</td>
	   			<td>
	   				<input type="text" name="expendCount" value="${expend.expendCount}"/>
	   				<input type="hidden" name="status" id="status"/>
	   				<input type="hidden" id="userID" name="useID" value="${user.ID}">
	   			</td>
	   		</tr>    
	   		<tr>
	   			<td colspan="2">
	   				<input type = "submit" value="草稿" id="notToDo"/>&nbsp;&nbsp;&nbsp;
	   				<input type = "submit" value="提交" id="ToDo"/>&nbsp;&nbsp;&nbsp;
	   				<input type = "reset" value="重置"/>
	   			</td>
	   		</tr>  	
	   	</table>
   	</form>
  </body>
</html>
