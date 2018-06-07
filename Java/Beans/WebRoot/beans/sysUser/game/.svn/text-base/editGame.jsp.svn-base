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
    
    <title>修改游戏</title>
    
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
			var gameUsable=true;
			var gameNameBack=$.trim($("#gameName").val());
			$("#gameName").keyup(function(){
				gameUsable=true;
				var gameName=$.trim($("#gameName").val());
				if(""!=gameName && gameName !=gameNameBack){
					$.ajax({
						type:"GET",
						url:"game/GameNameIsExist.action?gameName="+gameName,
						dataType:"text",
						success:function(textStr){
							$("#gameContainer").text(textStr);
							if(""!=textStr){
								gameUsable=false;
							}
						}
					});
				}
			});	
			$(":submit").click(function(){
				var gameName=$.trim($("#gameName").val());
				if(""==gameName || !gameUsable){
					alert("请检查游戏名是否输入正确");
					return false;
				}
				var gameStatus=$("#gameStatus").val();
				if(""==gameStatus){
					alert("请选择游戏状态");
					return false;
				}
				var gameType=$("#gameType").val();
				if(""==gameType){
					alert("请选择游戏类型");
					return false;
				}
				var gameDetail=$.trim($("#gameDetail").val());
				if(""==gameDetail){
					alert("请输入游戏详情");
					return false;
				}
				var gameFee=$.trim($("#gameFee").val());
				if(!(!isNaN(parseFloat(gameFee)) && gameFee == (parseFloat(gameFee)) && gameFee != 0)){
					alert("请输入正确话费价格");
					return false;
				}
				var gameBeans=$.trim($("#gameBeans").val());
				if(!(!isNaN(parseFloat(gameBeans)) && gameBeans == (parseFloat(gameBeans)) && gameBeans != 0)){
					alert("请输入正确乐豆价格");
					return false;
				}else{
					return true;
				}
			});
		});
	</script>
  </head>
  
  <body>
   <form action="game/editGame.action" method="post" enctype="multipart/form-data">
    <div class="panel-body" style="text-align: center;">
    	<div class="form-group" style="text-align: left;">
    		<strong>游戏名称：</strong>
    		<input type="hidden" name="id" value="${game.id}">
    		<input id="gameName" value="${game.gameName}" type="text" placeholder="请输入游戏名称" name="gameName" class="input" style="width:150px; line-height:17px;display:inline-block;margin-top:5px;" />
    		<span id="gameContainer" style="color: red;font-size: 12px;"></span><br/>
    	</div>
    	<div class="form-group" style="text-align: left;">
    		<strong>游戏状态：</strong>
    		<select id="gameStatus" style="width: 80px;font-size: 14px;padding: 10px;border: solid 1px #ddd;line-height: 20px;border-radius: 3px;" name="gameStatus">
    			<c:choose>
    				<c:when test="${game.gameStatus=='1'}">
    					<option value="1" selected="selected">商用</option>
    					<option value="2">下线</option>
    				</c:when>
    				<c:otherwise>
    					<option value="1">商用</option>
    					<option value="2" selected="selected">下线</option>
    				</c:otherwise>
    			</c:choose>
    		</select>
    		&nbsp;&nbsp;&nbsp;&nbsp;
    		<strong>游戏类别：</strong>
    			<select style="width: 80px;font-size: 14px;padding: 10px;border: solid 1px #ddd;line-height: 20px;border-radius: 3px;" id="gameType" name="gameType">
		       		<c:forEach items="${gameTypeList}" var="Type" >
		        		<c:choose>
			         		<c:when test="${Type.id==game.gameType}">
			         			<option value="${Type.id}" selected="selected">${Type.typeName}</option>
			         		</c:when>
			         		<c:otherwise>
			         			<option value="${Type.id}">${Type.typeName}</option>
			         		</c:otherwise>
				        </c:choose>
			        </c:forEach>
	       		</select><br/>
    	</div>
    	<div class="form-group" style="text-align: left;">
    		<strong>游戏详情：</strong>
    		<textarea id="gameDetail" placeholder="请输入游戏详情" name="gameDetail" class="input" style="width:280px; line-height:17px;display:inline-block;margin-top:5px;resize:none;" >
    		${game.gameDetail}
    		</textarea><br/>
    	</div>
    	<div class="form-group" style="text-align: left;">
    		<strong>游戏图片：</strong>
    		<input type="hidden" name="gamePicture" value="${game.gamePicture}">
    		<input type="file" name="file" id="file" class="input" style="width:200px; line-height:17px;display:inline-block;margin-top:5px;"/>&nbsp;&nbsp;
    	</div>
    	<div class="form-group" style="text-align: left;">
    		<strong>话费价格：</strong>
    		<input id="gameFee" value="${game.gameFee}" type="text" placeholder="请输入" name="gameFee" class="input" style="width:70px; line-height:17px;display:inline-block;margin-top:5px;" />
    		&nbsp;&nbsp;&nbsp;&nbsp;
    		<strong>乐豆价格：</strong>
    		<input id="gameBeans" value="${game.gameBeans}" type="text" placeholder="请输入" name="gameBeans" class="input" style="width:70px; line-height:17px;display:inline-block;margin-top:5px;" /><br/>
    	</div>
    	<div class="form-group" style="text-align: center;">
    		<button type="submit" class="button border-green"> 修改</button> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<span><input type="reset" class="button border-red" value="重置" style="width:60px;"></span>
    	</div>
    </div>
    </form>
  </body>
</html>
