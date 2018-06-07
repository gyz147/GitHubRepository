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
     <%
     	String operator = (String)request.getAttribute("operator");
     	String workID = (String)request.getAttribute("workID");
      %>
     
      <input type="hidden" value="<%=operator %>" id="operator"/>
     <input type="hidden" value="<%=workID %>" id="workID"/>
     <script type="text/javascript">
        var operator = document.getElementById("operator").value;
        var workID = document.getElementById("workID").value;
        switch(operator){
        	case "1000":
        	           alert("审批成功！");
        	           break;
        	case "9999":
        	           alert("审批失败");
        	           break;
        	
        	           
        }
        
        switch(workID){
        	case "1":
        	           location.href = "queryHolidays.do";
        	           break;
        	case "2":
        	           location.href = "queryExpends.do";
        	           break;
        	
        	           
        }
     </script>
  </body>
</html>
