<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>游戏详情</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
	<link href="css/style2.css" rel="stylesheet" type="text/css" media="all" />	
	<script src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/move-top.js"></script>
	<script type="text/javascript" src="js/easing.js"></script>
	<script type="text/javascript">
		jQuery(document).ready(function($) {
			$(".scroll").click(function(event){		
				event.preventDefault();
				$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
			});
			$("#downLoad").click(function(){
				var userId=$("#joyBeansUser").val();
				var gameId=$("#gameId").val();
				if(""==userId){
					location.href="beans/prompt/joyBeansUserControl.jsp";
				}else{
					$.ajax({
						type:"GET",
						url:"consumeRecord/queryConsumeRecord.action?userId="+userId+"&gameId="+gameId,
						dataType:"text",
						success:function(textStr){
							if("notConsumeRecord"==textStr){
								alert("请先购买");
							}else if("reBuy"==textStr){
								alert("下载次数用完，请重新购买！");
							}else if("overTime"==textStr){
								alert("购买超过一天，请重新购买！");
							}else{
								location.href="consumeRecord/updateDownCnt.action?id="+textStr;
							}
						}
					});
				}
			});
			$("#feeBuy").click(function(){
				var userAccount=$("#userAccount").val();
				var feeBalance=0;
				var beanBalance=0;
				var secretBalance=0;
				if(""==userAccount){
					location.href="beans/prompt/joyBeansUserControl.jsp";
				}else{
					$.ajax({
							type:"GET",
							url:"joyBeans/queryBalance.action?userAccount="+userAccount,
							dataType:"text",
							success:function(balance){
								var arr=balance.split(",");
								feeBalance=arr[0];
								beanBalance=arr[1];
								secretBalance=arr[2];
								if(confirm("当前话费余额:"+feeBalance+"。是否用话费购买?")){
									if(feeBalance<$("#gameFee").val()){
										alert("当前话费不足！")
									}else{
										location.href="consumeRecord/buyGame.action?userAccount="+$("#userAccount").val()+"&gameId="+$("#gameId").val()+"&buyType=1";
									}
								}
							}
					});
				}
			});
			$("#beansBuy").click(function(){
				var userAccount=$("#userAccount").val();
				var feeBalance=0;
				var beanBalance=0;
				var secretBalance=0;
				if(""==userAccount){
					location.href="beans/prompt/joyBeansUserControl.jsp";
				}else{
					$.ajax({
							type:"GET",
							url:"joyBeans/queryBalance.action?userAccount="+userAccount,
							dataType:"text",
							success:function(balance){
								var arr=balance.split(",");
								feeBalance=arr[0];
								beanBalance=arr[1];
								secretBalance=arr[2];
								if(confirm("乐豆余额度:"+beanBalance+"，密保余额:"+secretBalance+"。是否用乐豆购买?")){
									if(beanBalance+secretBalance<$("#gameBeans").val()){
										alert("当前乐豆余额不足！")
									}else{
										location.href="consumeRecord/buyGame.action?userAccount="+$("#userAccount").val()+"&gameId="+$("#gameId").val()+"&buyType=2";
									}
								}
							}
					});
				}
			});
		});
	</script>

  </head>
  
  <body>
<!--header-->
	<div class="header" id="home">
		<div class="container">	
			<div class="logo">
				<h1><a><img src="images/logo.png" alt=""></a></h1>
			</div>
			<div class="header-bottom">
				<div class="top-nav">
					<ul>
						<li style="margin-left: 200px;"></li>
						<li><a href="beans/joyBeansUser/homePage.jsp">游戏大厅</a></li>
						<li><a href="beans/prompt/configQuit.jsp">退出</a></li>
						<li><a href="#aboutUs" class="scroll">关于我们</a></li>
					</ul>
					<!--script-->
				<script>
					$("span.menu").click(function(){
						$(".top-nav ul").slideToggle(500, function(){
						});
					});
				</script>
			</div>
		</div>
	</div>
	<!---->
	<div class="container">
		<div class="single-page-artical">
			<div class="artical-content">
					<h3>${game.gameName}</h3>
					<img class="img-responsive" src="resource/${game.gamePicture}" title="banner1">
					<p>${game.gameDetail}</p>
					<p>话费价格:${game.gameFee}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;乐豆价格:${game.gameBeans}</p>
					<p>创建时间:${game.createTime}</p>
					<input id="gameId" type="hidden" value="${game.id}">
					<input id="gameFee" type="hidden" value="${game.gameFee}">
					<input id="gameBeans" type="hidden" value="${game.gameBeans}">
			</div>
			<div class="artical-links">
		  		<ul>
		  			<li><button id="feeBuy"><small class="admin"> </small><span>话费购买</span></button></li>
		  			<li>&nbsp;&nbsp;&nbsp;</li>
		  			<li><button id="beansBuy"><small class="no"> </small><span>乐豆购买</span></button></li>
		  			<li><button id="downLoad"><small class="posts"> </small><span>下载游戏</span></button></li>
		  		</ul>
		  		<input id="joyBeansUser" type="hidden" value="${joyBeansUser.id}">
		  		<input id="userAccount" type="hidden" value="${joyBeansUser.userAccount}">
		  		<input id="feeBalance" type="hidden">
		  		<input id="beanBalance" type="hidden">
		  		<input id="secretBalance" type="hidden">
		  	 </div>
		</div>
	</div>
		<!---->
	<div class="footer" style="height: 160px;" id="aboutUs">
	  <div class="container">
		<div class="footer-bottom">
				<ul class="social">
					<li><a><i> </i></a></li>						
					<li><a><i class="facebook"> </i></a></li>
					<li><a><i class="html"> </i></a></li>
					<li><a><i class="dot"> </i></a></li>
				</ul>
				<p class="footer-class">Copyright &copy; 2016.Company name All rights reserved.</p>
				<div class="clearfix"></div>
		</div>						
	 </div>
	 <a href="#home"  class="scroll" id="toTop" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>
	</div>
  </body>
</html>
