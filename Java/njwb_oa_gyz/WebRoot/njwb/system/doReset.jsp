<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.njwb.oa.entity.User"%>
<%@page import="com.njwb.oa.service.UserService"%>
<%@page import="com.njwb.oa.exception.OAException"%>
<%@page import="com.njwb.oa.util.Constant"%>
<%@page import="com.njwb.oa.factory.ApplicationContext"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'doReset.jsp' starting page</title>
    
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
  		User user=(User)session.getAttribute("user");
  		String oldPwd=request.getParameter("oldPwd");
  		String newPwd=request.getParameter("newPwd"); 
  		UserService userService=(UserService)ApplicationContext.getBean("userService");
  		try{
  			userService.modify(user.getUserName(),newPwd);
  		}catch(OAException e){
  			request.setAttribute("errorMsg",e.getMessage());
            request.getRequestDispatcher("../prompt/error.jsp").forward(request,response);
  		}
  		request.setAttribute("operator",Constant.MODIFYPWD_SUCCESS);
        request.getRequestDispatcher("../prompt/success.jsp").forward(request,response);
  	%>
  	
  </body>
</html>
