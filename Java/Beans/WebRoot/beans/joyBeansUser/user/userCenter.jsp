<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
    
    <title>个人主页</title>
    
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
	</div>
	<!---->
	<div class="container">
		<div class="contact-page">
		<div class=" map">
			<h5>个人主页</h5>
			</div>
			<div class="contact-non"  id="center">
					<div class="col-md-6 contact-inline" style="width: 12%;">
				     	<h5>个人信息</h5>
						姓名：<p>${joyBeansUser.userName}</p>
						账号：<p>${joyBeansUser.userAccount}</p>
						手机号：<p>${joyBeansUser.userPhone}</p>
				   		话费余额：<p>${joyBeansUser.feeBalance}元</p>
				   		乐豆余额：<p>${joyBeansUser.beansBalance}个</p>
				   		密保余额：<p>${joyBeansUser.secretBalance}个</p>
				 	 	创建时间：<p>${joyBeansUser.createTime}</p>
				    </div>
				    <div class="col-md-6 contact-inline" style="width: 73%;">
				     	<h5>购买记录</h5>
						 <table class="table table-hover text-center">
					      <tr>
					        <th width="35px" style="text-align: center;">ID</th>
					        <th width="130px" style="text-align: center;">游戏名称</th>
					        <th width="110px" style="text-align: center;">游戏图片</th>
					        <th width="110px" style="text-align: center;">购买方式</th>
					        <th width="110px" style="text-align: center;">消费金额</th>
					        <th width="110px" style="text-align: center;">赠送乐豆</th>
					        <th width="180px" style="text-align: center;">购买时间</th>
					        <th width="110px" style="text-align: center;">下载次数</th>
					      </tr>
					    <c:forEach items="${pageModel.dataList}" var="consumeRecordWrapper">
					      <tr>
					        <td>${consumeRecordWrapper.id}</td>
					        <td>${consumeRecordWrapper.gameName}</td>
					        <td width="10%"><img src="resource/${consumeRecordWrapper.picture}" width="70" height="50" /></td>
					        <td>${consumeRecordWrapper.buyType=="1"?"话费购买":"乐豆购买"}</td>         
					        <td>${consumeRecordWrapper.price}</td>
					        <td>${consumeRecordWrapper.sendBeans}</td>
					        <td><fmt:formatDate value="${consumeRecordWrapper.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
					        <td>${consumeRecordWrapper.downCount}</td>
					      </tr>
					    </c:forEach>
					      <tr> 
					        <td colspan="9">
					        	<div class="pagelist">
					        	 	<a href="joyBeans/queryUserCenter.action?pageNo=${pageModel.firstPage}">首页</a> 
						       	  	<a href="joyBeans/queryUserCenter.action?pageNo=${pageModel.prePage}">上一页</a> 
						       	  	<a href="joyBeans/queryUserCenter.action?pageNo=${pageModel.nextPage}">下一页</a>
						       	  	<a href="joyBeans/queryUserCenter.action?pageNo=${pageModel.lastPage}">尾页</a>
						       	  	<span style="border: white;">第${pageModel.pageNo}/${pageModel.totalPage}页</span>
					        	</div>
					        </td>
					      </tr>
					    </table>
				    </div>
					<div class="col-md-6 contact-grid" style="width: 15%">
					<h5>密保充值</h5>
					<form action="joyBeans/addSecretBalance.action" method="post">						
						<input id="cardNo" name="cardNo" type="text"  placeholder="卡号" style="width: 260px;">
						<input id="cardPwd" name="cardPwd" type="text" placeholder="密码" style="width: 260px;">					
						<input name="phone" type="hidden" value="${joyBeansUser.userPhone}">
						<input name="userAccount" type="hidden" value="${joyBeansUser.userAccount}">
						<input name="userId" type="hidden" value="${joyBeansUser.id}">
						<div class="send-in">
							<input id="submit" type="submit" value="充值"  style="width: 260px;"/>
						</div>
					</form>
				</div>
					<div class="clearfix"> </div>
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
	 <a href="#home" class="scroll" id="toTop" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>
	</div>
  </body>
</html>
