<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'success.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <%--
                提示操作成功
    
     --%>
     <%
     	String operator = (String)request.getAttribute("operator");
     %>
     
      <input type="hidden" value="<%=operator %>" id="operator"/>
     
     <script type="text/javascript">
        var operator = document.getElementById("operator").value;
        switch(operator){
        	case "001":
        	           alert("部门添加成功");
        	           location.href = "queryDepts.do";
        	           break;
        	case "002":
        	           alert("部门删除成功");
        	           location.href = "queryDepts.do";
        	           break;
        	case "003":
        	           alert("部门修改成功");
        	           location.href = "queryDepts.do";
        	           break;
        	case "101":
        	           alert("员工添加成功");
        	           location.href = "queryEmps.do";
        	           break;
        	case "102":
        	           alert("员工删除成功");
        	           location.href = "queryEmps.do";
        	           break;
        	case "103":
        	           alert("员工修改成功");
        	           location.href = "queryEmps.do";
        	           break;
        	case "201":
        	           alert("请假信息添加成功");
        	           location.href = "queryHolidays.do";
        	           break;
        	case "202":
        	           alert("请假信息删除成功");
        	           location.href = "queryHolidays.do";
        	           break;
        	case "203":
        	           alert("请假信息修改成功");
        	           location.href = "queryHolidays.do";
        	           break;
        	case "302": 
        	           alert("密码修改成功");
        	           window.parent.location.href = "njwb/system/quit.jsp";
        	           break;
        	case "401":
        	           alert("报销信息添加成功");
        	           location.href = "queryExpends.do";
        	           break;
        	case "402":
        	           alert("报销信息删除成功");
        	           location.href = "queryExpends.do";
        	           break;
        	case "403":
        	           alert("报销信息修改成功");
        	           location.href = "queryExpends.do";
        	           break;
        	case "501":
        	           alert("角色信息添加成功");
        	           location.href = "queryRoles.do";
        	           break;
        	case "502":
        	           alert("角色信息删除成功");
        	           location.href = "queryRoles.do";
        	           break;
        	case "503":
        	           alert("角色信息修改成功");
        	           location.href = "queryRoles.do";
        	           break;
        	case "601":
        	           alert("用户信息添加成功");
        	           location.href = "queryUsers.do";
        	           break;
        	case "602":
        	           alert("用户信息删除成功");
        	           location.href = "queryUsers.do";
        	           break;
        	case "603":
        	           alert("用户信息修改成功");
        	           location.href = "queryUsers.do";
        	           break;
        	case "701":
        	           alert("权限信息添加成功");
        	           location.href = "queryPermissions.do";
        	           break;
        	case "702":
        	           alert("权限信息删除成功");
        	           location.href = "queryPermissions.do";
        	           break;
        	case "703":
        	           alert("权限信息修改成功");
        	           location.href = "queryPermissions.do";
        	           break;
        }
     
     </script>
  </body>
</html>
