<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'holidayAdd.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="<%=basePath%>js/jquery-1.8.3.min.js"></script>
	<style type="text/css">
		body,div,table,tr,td{
			margin: 0px;
			padding: 0px;
		}
	
		#holidayAddTable{
			font-size: 15px;
			border-collapse: collapse;
			width: 350px;
			margin: 20px auto;
			margin-top: 100px;			
		}
		
		#holidayAddTable td{
			height: 40px;
		}
		
		#startTime,#endTime{
			width: 200px;
		}
		.title {
			font-size: 18px;
			color: #1A3347;
			background-color: #95BFE0;
			font-weight: normal;
			font-size: 14px;
			line-height: 30px;
			height: 30px;
		}
	</style>
	
  <script type="text/javascript">
	 function formSubmit(type)
  	 {
  		var workID=$("#workID").val();
  		var tableID=$("#tableID").val();
  		var dealAdvices=$("#dealAdvices").val();
  		location.href = "audit.do?dealType="+type+"&workID="+workID+"&dealAdvices="+dealAdvices+"&tableID="+tableID;
  	}
  </script>
  
  </head>
  
  <body>
  <h1 class="title">审批</h1>
     <form action=holidayAdd.do method="post">
	   	<table id = "holidayAddTable">
	   		<tr>
	   			<td>
	   			审批编号:
	   			</td>
	   			<td>
	   				<input id="tableID" type="text" readonly="readonly" value="${WorkNodeActionPojo.tableID}">
	   				<input id="workID" type="hidden" readonly="readonly" value="${workID}">
	   			</td>
	   		</tr>
	   		<tr>
	   			<td>
	   			审批流程:
	   			</td>
	   			<td>
	   				<input type="text" readonly="readonly" value="${WorkNodeActionPojo.nodeName}">
	   			</td>
	   		</tr>
	   		<tr>
	   			<td>
	   			审批意见:
	   			</td>
	   			<td>
	   				<textarea id="dealAdvices" rows="5" cols="30" name="holidayBz" style="resize:none;"></textarea>
	   			</td>
	   		</tr>  
	   		<tr>
	   			<td colspan="2">
	   				<input type = "button" value="通过" id="ToDo" onclick="formSubmit('pass')"/>&nbsp;&nbsp;&nbsp;
	   				<input type = "button" value="拒绝" id="notToDo" onclick="formSubmit('refuse')"/>&nbsp;&nbsp;&nbsp;
	   				<input type = "reset" value="重置"/>
	   			</td>
	   		</tr>  	
	   	</table>
   	</form>
  </body>
</html>
