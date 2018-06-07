<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>乐豆后台管理中心</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/pintuer.css">
	<link rel="stylesheet" type="text/css" href="css/admin.css">
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript">
		$(function() {
			$(".leftnav h2").click(function() {
				$(this).next("ul").slideToggle(200);
				$(this).toggleClass("on");
			})
			$(".leftnav ul li a").click(function() {
				$("#a_leader_txt").text($(this).text());
				$(".leftnav ul li a").removeClass("on");
				$(this).addClass("on");
			})
			function current(){
				var d=new Date();
				var str="";
				str += d.getFullYear()+"年";
				str += d.getMonth()+1+"月";
				str += d.getDate()+"日,";
				var weekday=new Array(7);
				weekday[0]="星期一";
				weekday[1]="星期二";
				weekday[2]="星期三";
				weekday[3]="星期四";
				weekday[4]="星期五";
				weekday[5]="星期六";
				weekday[6]="星期日";
				str += weekday[d.getDay()-1];
				return str;
			}
			$("#date").text(current());
		});
	</script>
  </head>
  <body>
    <div class="header bg-main">
		<div class="logo margin-big-left fadein-top">
					<h1>
										<img src="images/y.jpg" class="radius-circle rotate-hover" height="50" alt="" />
										<span>${sysUser.userName}</span>
										欢迎使用乐豆后台管理系统
								</h1>
						</div>
						<div class="head-2">
								<h1 id="date">
										2016年10月22日，星期五
								</h1>
						</div>
						<div class="head-l">
								<a href="beans/joyBeansUser/homePage.jsp" class="button button-little bg-green" target="_blank"><span class="icon-home"></span> 前台首页</a> &nbsp;&nbsp;
								<a href="beans/prompt/configQuit.jsp" class="button button-little bg-red"><span class="icon-power-off"></span> 退出登录</a>
						</div>
				</div>
				<div class="leftnav">
						<div class="leftnav-title">
								<strong><span class="icon-list"></span>菜单列表</strong>
						</div>
						<h2>
								<a href="joyBeans/queryAll.action" target="right"><span class="icon-caret-right"></span>用户管理</a>
						</h2>
						<h2>
								<span class="icon-caret-right"></span>游戏管理
						</h2>
						<ul>
								<li>
										<a href="gameType/queryAll.action" target="right"><span class="icon-pencil-square-o"></span>游戏类型</a>
								</li>
								<li>
										<a href="game/queryAll.action" target="right"><span class="icon-pencil-square-o"></span>游戏列表</a>
								</li>
						</ul>
						<h2>
								<a href="beanExchange/queryAll.action" target="right"><span class="icon-caret-right"></span>乐豆换算比例</a>
						</h2>
						<h2>
								<a href="secretCard/queryAll.action" target="right"><span class="icon-caret-right"></span>定向密报管理</a>
						</h2>
				</div>
				<ul class="bread">
					<li>
						操作中心
					</li>
				</ul>
				<div class="admin">
						<iframe name="right" width="100%" height="99%"></iframe>
				</div>
  </body>
</html>
