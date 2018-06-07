<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改乐豆换算比例</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/pintuer.css">
	<link rel="stylesheet" type="text/css" href="css/admin.css">
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript">
		$(function(){
			$(":submit").click(function(){
				var price=$("#price").val();
				if(!(!isNaN(parseFloat(price)) && price == (parseFloat(price)) && price != 0)){
					alert("请输入正确的金额度");
					return false;
				}else{
					return true;
				}
			});
		});
	</script>
  </head>
  
  <body>
  <form action="beanExchange/editBeanExchange.action" method="post">
    <div class="panel-body" style="text-align: center;">
    	<div class="form-group" style="text-align: left;">
    		<strong>省份：</strong>
    		<input id="id" name="id" type="hidden" value="${beansExchange.id}">
    		<input id="provName" type="text" readonly="readonly" value="${beansExchange.provName}" name="provName" class="input" style="width:250px; line-height:17px;display:inline-block;margin-top:5px;" /><br/>
    		<input id="provCode" name="provCode" type="hidden" value="${beansExchange.provCode}">
    	</div>
    	<br/>
    	<div class="form-group" style="text-align: left;">
    		<strong>赠送1个乐豆所需的消费金额：</strong>
    		<input id="price" type="text" value="${beansExchange.price}" placeholder="请输入金额" name="price" class="input" style="width:250px; line-height:17px;display:inline-block;margin-top:5px;" />
    	</div>
    	<br/>
    	<div class="form-group" style="text-align: center;">
    		<button type="submit" class="button border-green"> 修改</button> &nbsp;&nbsp;
			<span><input type="reset" class="button border-red" value="重置" style="width:60px;"></span>
    	</div>
    </div>
   </form>
  </body>
</html>
