<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加游戏类型</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/pintuer.css">
	<link rel="stylesheet" type="text/css" href="css/admin.css">
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/pintuer.js"></script>
	<script type="text/javascript">
		$(function(){
			var gameTypeUsable=true;
			$("#typeName").keyup(function(){
				gameTypeUsable=true;
				var typeName=$.trim($("#typeName").val());
				if(""!=typeName){
					$.ajax({
						type:"GET",
						url:"gameType/gameTypeNameIsExist.action?typeName="+typeName,
						dataType:"text",
						success:function(textStr){
							$("#typeNameContainer").text(textStr);
							if(""!=textStr){
								gameTypeUsable=false;
							}
						}
					});
				}
			});
			$(":submit").click(function(){
				var typeName=$("#typeName").val();
				var typeStatus=$("input[name='typeStatus']:checked").val();
				if(""==typeName || !gameTypeUsable){
					alert("请检查类型名称是否输入正确");
					return false;
				}else if(""==typeStatus || null==typeStatus){
					alert("请选择状态");
					return false;
				}else{
					return true;
				}
			});
		});
	</script>
  </head>
  
  <body>
  <form action="gameType/addGameType.action" method="post">
    <div class="panel-body" style="text-align: center;">
    	<div class="form-group" style="text-align: left;">
    		<strong>类型名称：</strong>
    		<input id="typeName" type="text" placeholder="请输入" autocomplete="off" name="typeName" class="input" style="width:80px; line-height:17px;display:inline-block;margin-top:5px;" />
    		<span id="typeNameContainer" style="color: red;font: 12px;"></span><br/>
    	</div>
    	<br/>
    	<div class="form-group" style="text-align: left;">
    		<strong>状态：</strong>
    		<input type="radio" name="typeStatus" value="1">商用&nbsp;&nbsp;&nbsp;
    		<input type="radio" name="typeStatus" value="2">下线
    	</div>
    	<br/>
    	<div class="form-group" style="text-align: center;">
    		<button type="submit" class="button border-green"> 添加</button> &nbsp;&nbsp;
			<span><input type="reset" class="button border-red" value="重置" style="width:60px;"></span>
    	</div>
    </div>
   </form>
  </body>
</html>
