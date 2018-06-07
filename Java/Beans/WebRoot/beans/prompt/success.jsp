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
        	    alert("用户状态修改成功");
        	    location.href = "joyBeans/queryAll.action";
        	    break;
        	case "002":
        	    alert("用户名或密码错误！");
        	    history.go(-1);
        	    break;
        	case "003":
        	    alert("登录成功！");
        	    location.href = "beans/joyBeansUser/homePage.jsp";
        	    break;
        	case "004":
        	    alert("注册成功！");
        	    location.href = "beans/joyBeansUser/login.jsp";
        	    break;
        	case "005":
        	    alert("当前用户已暂停使用！");
        	    history.go(-1);
        	    break;
        	case "101":
        	    alert("游戏类型添加成功");
        	    window.parent.location.href = "gameType/queryAll.action";
        	    break;
        	case "102":
        	    alert("游戏类型修改成功");
        	    window.parent.location.href = "gameType/queryAll.action";
        	    break;
        	case "201":
        	    alert("密保卡批量生成成功！");
        	     window.parent.location.href = "secretCard/queryAll.action";
        	    break;
        	case "301":
        	    alert("游戏添加成功！");
        	    window.parent.location.href = "game/queryAll.action";
        	    break;
        	case "302":
        	    alert("游戏修改成功！");
        	    window.parent.location.href = "game/queryAll.action";
        	    break;
        	case "401":
        	    alert("乐豆换算比例添加成功！");
        	    window.parent.location.href = "beanExchange/queryAll.action";
        	    break;
        	case "402":
        	    alert("乐豆换算比例修改成功！");
        	    window.parent.location.href = "beanExchange/queryAll.action";
        	    break;
        	case "403":
        	    alert("乐豆换算比例删除成功！");
        	    location.href = "beanExchange/queryAll.action";
        	    break;
        	case "501":
        	    alert("用户名或密码错误！");
        	    history.go(-1);
        	    break;
        	case "502":
        	    alert("登录成功！");
        	    location.href = "beans/sysUser/main.jsp";
        	    break;
        	case "601":
        	    alert("卡号或密码错误！");
        	    history.go(-1);
        	    break;
        	case "602":
        	    alert("不可充值其它省份的卡！");
        	    history.go(-1);
        	    break;
        	case "603":
        	    alert("当前密保卡不可用！");
        	    history.go(-1);
        	    break;
        	case "604":
        	    alert("密保余额未用完不可充值！");
        	    history.go(-1);
        	    break;
        	case "605":
        	    alert("密保卡充值成功！");
        	    location.href="main/homePage.action";
        	    break;
        	case "701":
        	    alert("购买成功！");
        	    location.href="main/homePage.action";
        	    break;
        	case "702":
        	    alert("下载成功！");
        	    location.href="joyBeans/queryUserCenter.action";
        	    break;
        }
     
     </script>
  </body>
</html>
