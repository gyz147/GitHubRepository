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
    
    <title>游戏类型管理</title>
    
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
					title:'新增游戏类型',
					shadeClose:true,
					shade:0.2,
					move:false,
					offset:['10%','40%'],
					area:['250px','280px'],
					content:'beans/sysUser/gameType/addGameType.jsp'
				});
			});
			$("#edit").click(function(){
				var id=$("input[name='gameTypeId']:checked").val();
				if(id==null){
					alert("未选中！");
				}else{
						layer.open({
						type:2,
						title:'修改游戏类型',
						shadeClose:true,
						shade:0.2,
						move:false,
						offset:['10%','40%'],
						area:['250px','295px'],
						content:'gameType/queryForUpdate.action?id='+id
					});
				}
			});
			$("#select").click(function(){
				location.href="gameType/queryAll.action?typeName="+$("#typeName").val()+"&typeStatus="+$("#typeStatus").val();
			});
		});
	</script>
  </head>
  
  <body>
    <form method="post" action="">
	  <div class="panel admin-panel">
	    <div class="panel-head">
	    	<strong>游戏类型</strong>
	    </div>
	    <div class="padding border-bottom">
	      <ul class="search">
	        <li>
	          <button type="button"  class="button border-blue icon-plus-square-o" id="add"> 新增</button>&nbsp;&nbsp;
	          <button type="button" class="button border-green icon-pencil" id="edit"> 修改</button>
	        </li>
	        <li style="margin-left: 688px;">
	       	 	类型名称：<input id="typeName" type="text" placeholder="请输入类型名称" name="typeName" value="${typeName}" class="input" style="width:120px; line-height:17px;display:inline-block" />&nbsp;&nbsp;
	          	状态：
	          	<select id="typeStatus" style="width: 80px;font-size: 14px;padding: 10px;border: solid 1px #ddd;line-height: 20px;border-radius: 3px;">
	          		<c:choose>
	          			<c:when test="${typeStatus=='1'}">
	          				<option value="1" selected="selected">商用</option>
	          				<option value="2">下线</option>
	          			</c:when>
	          			<c:when test="${typeStatus=='2'}">
	          				<option value="1">商用</option>
	          				<option value="2" selected="selected">下线</option>
	          			</c:when>
	          			<c:otherwise>
	          				<option value="1">商用</option>
	          				<option value="2">下线</option>
	          			</c:otherwise>
	          		</c:choose>
	          	</select>
	          	&nbsp;&nbsp;&nbsp;&nbsp;
	          	<button type="button" id="select" class="button border-main icon-search"> 查询</button>
	        </li>
	      </ul>
	    </div>
    <table class="table table-hover text-center" id="userTable">
      <tr>
        <th width="120"></th>
        <th>ID</th>
        <th>类型名称</th>
        <th>状态</th>
        <th width="25%">创建时间</th>
        <th width="25%">更新时间</th>
      </tr>
      <c:forEach items="${pageModel.dataList}" var="gameType">
      <tr>
        <td><input type="radio" name="gameTypeId" value="${gameType.id}" /></td>
         <td>${gameType.id}</td>
        <td>${gameType.typeName}</td>
        <td>${gameType.typeStatus=="1"?"商用":"下线"}</td>         
        <td>${gameType.createTime}</td>
        <td>${gameType.modifyTime}</td>
      </tr>
      </c:forEach>
      <tr>
       	<td colspan="6">
       	 <div class="pagelist"> 
       	 	<a href="gameType/queryAll.action?pageNo=${pageModel.firstPage}&typeName=${typeName}&typeStatus=${typeStatus}">首页</a> 
       	  	<a href="gameType/queryAll.action?pageNo=${pageModel.prePage}&typeName=${typeName}&typeStatus=${typeStatus}">上一页</a> 
       	  	<a href="gameType/queryAll.action?pageNo=${pageModel.nextPage}&typeName=${typeName}&typeStatus=${typeStatus}">下一页</a>
       	  	<a href="gameType/queryAll.action?pageNo=${pageModel.lastPage}&typeName=${typeName}&typeStatus=${typeStatus}">尾页</a>
       	  	<span style="border: white;">第${pageModel.pageNo}/${pageModel.totalPage}页</span>
       	 </div>
       </td>
      </tr>
     </table>
    </div>
   </form>
  </body>
</html>
