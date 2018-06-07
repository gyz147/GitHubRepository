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
    
    <title>审批历史记录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/reset.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>css/main.css">
	<style type="text/css">
		.deptInfo{
		width: 788px;
		margin: 36px auto;
		border-collapse: collapse;
		}
	</style>
  </head>
  
  <body>
	<h1 class="title">历史审批记录 </h1>
      <table class="deptInfo">
         <tr class="titleRow">
			<td>提交编号</td>
       		<td>流程名称</td>
         	<td>节点状态</td>
         	<td>打开时间</td>
         	<td>结束时间</td>
         	<td>待处理人</td>
         	<td>已处理人</td>
         	<td>处理意见</td>  
        </tr>
       <c:forEach items="${historyList}" var="history">
         <tr>
         	<td>${history.tableID}</td>
         	<td>${history.nodeName}</td>
         	<td>${history.statusName}</td>
         	<td>${history.openTime}</td>
         	<td>${history.closeTime}</td>
         	<td>${history.waitingUsersName}</td>
         	<td>${history.dealUserName}</td>
         	<td>${history.dealAdvices}</td>
         </tr>
        </c:forEach>
      </table>
  </body>
</html>
