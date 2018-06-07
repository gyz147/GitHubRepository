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
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/reset.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>css/main.css">
	<script type="text/javascript" src="<%=basePath%>js/jquery-1.8.3.min.js"></script>
	<style type="text/css">
		.deptInfo{
		width: 788px;
		margin: 36px auto;
		border-collapse: collapse;
		}
	</style>
	<script type="text/javascript">
		function audit(workID,tableID){
			location.href="queryAudit.do?workID="+workID+"&tableID="+tableID;
		}
	
	</script>
  
  </head>
  
  <body>
	<h1 class="title">待审批信息 </h1>
	  <input type="hidden" value="${workID}" id="workID">
      <table class="deptInfo">
         <tr class="titleRow">
			<td>提交编号</td>
       		<td>审批流程</td>
         	<td>节点状态</td>
         	<td>审批开始时间</td>
         	<td>审批结束时间</td>
         	<td>待处理人</td>
         	<td>审批</td>  
        </tr>
       <c:forEach items="${WorkNodeActionPojoList}" var="WorkNodeActionPojo">
         <tr>
         	<td>${WorkNodeActionPojo.tableID}</td>
         	<td>${WorkNodeActionPojo.nodeName}</td>
         	<td>${WorkNodeActionPojo.statusName}</td>
         	<td>${WorkNodeActionPojo.openTime}</td>
         	<td>${WorkNodeActionPojo.closeTime}</td>
         	<td>${WorkNodeActionPojo.waitingUsersName}</td>
         	<td><img alt="" src="img/audit.png" class="operateImg" onclick="audit('${workID}','${WorkNodeActionPojo.tableID}')"></td>
         </tr>
        </c:forEach>
      </table>
  </body>
</html>
