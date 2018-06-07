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
    
    <title>游戏管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/pintuer.css">
	<link rel="stylesheet" type="text/css" href="css/admin.css">
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/pintuer.js"></script>
	<script type="text/javascript" src="js/layer/layer.js"></script>
	<script type="text/javascript">
		$(function(){
			$("#add").click(function(){
				layer.open({
					type:2,
					title:'新增游戏',
					shadeClose:true,
					shade:0.2,
					move:false,
					offset:['5%','35%'],
					area:['400px','500px'],
					content:'beans/sysUser/game/addGame.jsp'
				});
			});
			
			$("#edit").click(function(){
				var id=$("input[name='gameId']:checked").val();
				if(id==null){
					alert("未选中！");
				}else{
					layer.open({
					type:2,
					title:'修改游戏',
					shadeClose:true,
					shade:0.2,
					move:false,
					offset:['5%','35%'],
					area:['400px','500px'],
					content:'game/queryForUpdate.action?id='+id
				});
				}
			});
			
			$("#select").click(function(){
				location.href="game/queryAll.action?gameName="+$("#gameName").val()+"&gameType="+$("#gameType").val();	
			});
		});
	
	</script>
  </head>
  
  <body>
  <div class="panel admin-panel">
    <div class="panel-head">
    	<strong class="icon-reorder"> 游戏管理</strong> 
    </div>
    <div class="padding border-bottom">
      <ul class="search" style="padding-left:10px;">
        <li>
          <button type="button" id="add" class="button border-main icon-plus-square-o" > 新增游戏</button>&nbsp;&nbsp;
          <button type="button" id="edit" class="button border-red icon-pencil"> 修改游戏</button> 
        </li>
        <li style="margin-left: 500px;">
	     	游戏名称：<input id="gameName" type="text" placeholder="请输入游戏名称" name="gameName" value="${gameName}" class="input" style="width:250px; line-height:17px;display:inline-block" />&nbsp;&nbsp;&nbsp;&nbsp;
	       	游戏类别：
	       	<select style="width: 80px;font-size: 14px;padding: 10px;border: solid 1px #ddd;line-height: 20px;border-radius: 3px;" id="gameType">
	       		<c:forEach items="${gameTypeList}" var="Type" >
	        		<c:choose>
		         		<c:when test="${Type.id==gameType}">
		         			<option value="${Type.id}" selected="selected">${Type.typeName}</option>
		         		</c:when>
		         		<c:otherwise>
		         			<option value="${Type.id}">${Type.typeName}</option>
		         		</c:otherwise>
			        </c:choose>
		        </c:forEach>
	       	</select>&nbsp;&nbsp;&nbsp;&nbsp;
	       	<button id="select" class="button border-main icon-search"> 查询</button>
	    </li>
      </ul>
    </div>
    <table class="table table-hover text-center">
      <tr>
        <th width="100px">ID</th>
        <th width="200px">游戏名称</th>
        <th width="130px">游戏类别</th>
        <th>游戏图片</th>
        <th width="150px">状态</th>
        <th>乐豆价格</th>
        <th>话费价格</th>
        <th width="180px">创建时间</th>
        <th width="180px">更新时间</th>
      </tr>
      <c:forEach items="${pageModel.dataList}" var="game">
      <tr>
        <td><input type="radio" name="gameId" value="${game.id}" />${game.id}</td>
        <td>${game.gameName}</td>
        <td>${game.typeName}</td>
        <td width="10%"><img src="resource/${game.gamePicture}" width="70" height="50" /></td>
        <td>${game.gameStatus=="1"?"商用":"下线"}</td>         
        <td>${game.gameBeans}</td>
        <td>${game.gameFee}</td>
        <td>${game.createTime}</td>
        <td>${game.modifyTime}</td>
      </tr>
      </c:forEach>
      <tr>
        <td colspan="9">
        	<div class="pagelist">
        	 	<a href="game/queryAll.action?pageNo=${pageModel.firstPage}&gameName=${gameName}&gameType=${gameType}">首页</a> 
	       	  	<a href="game/queryAll.action?pageNo=${pageModel.prePage}&gameName=${gameName}&gameType=${gameType}">上一页</a> 
	       	  	<a href="game/queryAll.action?pageNo=${pageModel.nextPage}&gameName=${gameName}&gameType=${gameType}">下一页</a>
	       	  	<a href="game/queryAll.action?pageNo=${pageModel.lastPage}&gameName=${gameName}&gameType=${gameType}">尾页</a>
	       	  	<span style="border: white;">第${pageModel.pageNo}/${pageModel.totalPage}页</span>
        	</div>
        </td>
      </tr>
    </table>
  </div>
  </body>
</html>
