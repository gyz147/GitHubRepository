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
    
    <title>请假信息编辑</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="js/laydate/laydate.js"></script>
	<script type="text/javascript">
			var start={
				elem:'#startTime',
				format:'YYYY/MM/DD hh:mm:ss',
				min:laydate.now(),
				max:'2099-06-16 23:59:59',
				istime:true,
				istoday:false,
				choose:function(datas){
					end.min=datas;
					end.start=datas;
				}
			};
			var end={
				elem:'#endTime',
				format:'YYYY/MM/DD hh:mm:ss',
				min:laydate.now(),
				max:'2099-06-16 23:59:59',
				istime:true,
				istoday:false,
				choose:function(datas){
					start.max=datas;
				}
			};
		$(function(){
			 $("#realStartTime").css("display","none");
			 $("#startTime").val($("#realStartTime").html());
			  $("#realEndTime").css("display","none");
			 $("#endTime").val($("#realEndTime").html());
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
     <form action="holidayEdit.do" method="post">
	   	<table id = "holidayEditTable">
	   		<tr>
	   			<td>
	   			请假编号:
	   			</td>
	   			<td>
	   				<input type = "text" name="holidayNo" id="holidayNo" value="${holiday.holidayNo}" readonly="readonly"/>
	   			</td>
	   		</tr>
	   		<tr>
	   			<td>
	   			申请人:
	   			</td>
	   			<td>
	   				<input type = "text" name="holidayName" id="holidayName" value="${holiday.holidayName}"/>
	   			</td>
	   		</tr>
	   		<tr>
	   			<td>
	   			请假类型:
	   			</td>
	   			<td>
	   				<select name="holidayType" id="holidayType">
         			<option value="">未知</option>
	         		<c:forEach items="${holidayTypeList}" var="Type" >
	         			<c:choose>
	         				<c:when test="${Type.id==holiday.holidayTypeId}">
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
	   			请假事由:
	   			</td>
	   			<td>
	   				<textarea rows="5" cols="30" name="holidayBz">${holiday.holidayBz}</textarea>
	   			</td>
	   		</tr>  
	   		<tr>
	   			<td>
	   			开始时间:
	   			</td>
	   			<td>
	   				<span id="realStartTime"><fmt:formatDate value="${holiday.startTime}" pattern="yyyy-MM-dd HH:mm:ss"/></span>
	   				<input type = "text" name="startTime" id="startTime" class="laydate-icon" onclick="laydate(start)"/>
	   				<input type="hidden" id="userID" name="useID" value="${user.ID}">
	   			</td>
	   		</tr>
	   		<tr>
	   			<td>
	   			结束时间:
	   			</td>
	   			<td>
	   				<span id="realEndTime"><fmt:formatDate value="${holiday.endTime}" pattern="yyyy-MM-dd HH:mm:ss"/></span>
	   				<input type = "text" name="endTime" id="endTime" class="laydate-icon" onclick="laydate(end)"/>
	   				<input type="hidden" name="status" id="status"/>
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
