<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>乐豆游戏大厅</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
	<script src="js/jquery.min.js"></script>
	<link href="css/style2.css" rel="stylesheet" type="text/css" media="all" />	
	<link rel="stylesheet" type="text/css" href="css/pintuer.css">
	<script type="text/javascript" src="js/move-top.js"></script>
	<script type="text/javascript" src="js/easing.js"></script>
	<script type="text/javascript">
		jQuery(document).ready(function($) {
			$(".scroll").click(function(event){		
				event.preventDefault();
				$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
			});
			$("#userCenter").click(function(){
				var userId=$("#joyBeansUser").val();
				if(""==userId){
					location.href="beans/prompt/joyBeansUserControl.jsp";
				}else{
					location.href="joyBeans/queryUserCenter.action";
				}
			});
			$("#quit").click(function(){
				var userId=$("#joyBeansUser").val();
				if(""==userId){
					location.href="beans/prompt/joyBeansUserControl.jsp";
				}else{
					location.href="beans/prompt/configQuit.jsp";
				}
			});
		});
	</script>
  </head>
  
  <body>
 <!--header-->
 	<input id="joyBeansUser" type="hidden" value="${joyBeansUser.id}">
	<div class="header" id="home">
		<div class="container">	
			<div class="logo">
				<h1><a><img src="images/logo.png" alt=""></a></h1>
			</div>
			<div class="header-bottom">
				<div class="top-nav">
					<ul>
						<li style="margin-left: 40px;"></li>
						<li><a href="#home" class="scroll">首页</a></li>
						<li><a href="#portfolio" class="scroll">游戏展示</a></li>
						<li><a id="userCenter">${joyBeansUser.userName==null?"个人中心":joyBeansUser.userName}</a></li>
						<li><a id="quit">退出</a></li>
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
		<div class="clearfix"> </div>
		</div>
	</div>
	<!---->
	
	<div class="container">		
		<div class="banner">
			<div class="banner-matter">
				<h2>欢迎进入乐豆游戏大厅</h2>
				<p>在这里你能感受到不一样的欢乐</p>		
			 </div>
			<div class="tv">
				<img class="img-responsive" src="images/tv.png" alt="">
			</div>
				 <div class="clearfix"> </div>
		</div>
	</div>
	<!---->
	<div class="container">	
	<div class="works" id="portfolio">
			<div class=" port-top">									
				<h3 class="port">游戏中心</h3>
					<ul id="filters">
						<li class="active"><a href="main/homePage.action"><span class="filter " data-filter="app card icon set sit web">All</span></a></li>
						<c:forEach items="${gameTypeList}" var="gameType">
							<c:if test="${gameType.typeStatus=='1'}">
								<li><a href="main/homePage.action?gameType=${gameType.id}"><span class="filter" data-filter="app">${gameType.typeName}</span></a></li>
							</c:if>
						</c:forEach>
					</ul>
					<div class="clearfix"> </div>
				</div>
				<div id="portfoliolist">
					<c:forEach items="${pageModel.dataList}" var="game">
						<c:if test="${game.gameStatus=='1'}">
						<div class="portfolio icon mix_all" data-cat="icon" style="display: inline-block; opacity: 1;">
						<div class="portfolio-wrapper">		
							<a href="main/gameCenter.action?id=${game.id}" class="b-link-stripe b-animate-go">
						    <img class="img-responsive" src="resource/${game.gamePicture}"/>
						   	<div class="b-wrapper" class="b-link-stripe b-animate-go">
									<h2 class="b-animate b-from-left ">	
										<span>${game.gameName}</span>									
										<button>查看</button>
									</h2>
								</div>
							</a>	
		               	 </div>
						</div>
						</c:if>	
					</c:forEach>		
				</div>
				<div style="margin-left:450px;margin-top: 600px;font-size: 20px;">
	        	 	<a href="main/homePage.action?pageNo=${pageModel.firstPage}&gameName=${gameName}&gameType=${gameType}">首页</a> 
		       	  	<a href="main/homePage.action?pageNo=${pageModel.prePage}&gameName=${gameName}&gameType=${gameType}">上一页</a> 
		       	  	<a href="main/homePage.action?pageNo=${pageModel.nextPage}&gameName=${gameName}&gameType=${gameType}">下一页</a>
		       	  	<a href="main/homePage.action?pageNo=${pageModel.lastPage}&gameName=${gameName}&gameType=${gameType}">尾页</a>
		       	  	<span style="border: white;">第${pageModel.pageNo}/${pageModel.totalPage}页</span>
        		</div>	
			<!-- Script for gallery Here -->
				<script type="text/javascript" src="js/jquery.mixitup.min.js"></script>
					<script type="text/javascript">
					$(function () {
						
						var filterList = {
						
							init: function () {
							
								// MixItUp plugin
								// http://mixitup.io
								$('#portfoliolist').mixitup({
									targetSelector: '.portfolio',
									filterSelector: '.filter',
									effects: ['fade'],
									easing: 'snap',
									// call the hover effect
									onMixEnd: filterList.hoverEffect()
								});				
							
							},
							
							hoverEffect: function () {
							
								// Simple parallax effect
								$('#portfoliolist .portfolio').hover(
									function () {
										$(this).find('.label').stop().animate({bottom: 0}, 200, 'easeOutQuad');
										$(this).find('img').stop().animate({top: -30}, 500, 'easeOutQuad');				
									},
									function () {
										$(this).find('.label').stop().animate({bottom: -40}, 200, 'easeInQuad');
										$(this).find('img').stop().animate({top: 0}, 300, 'easeOutQuad');								
									}		
								);				
							
							}
				
						};
						
						// Run the show!
						filterList.init();
					});	
					</script>
			<!-- Gallery Script Ends -->
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
	 <a href="#home" class="scroll" id="toTop" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>
	</div>
  </body>
</html>
