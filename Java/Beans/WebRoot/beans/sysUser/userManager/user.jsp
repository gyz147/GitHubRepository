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
    
    <title>用户管理</title>
    
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
			$("#serch").click(function(){
				location.href="joyBeans/queryAll.action?userAccount="+$("#userAccount").val()+"&userName="+$("#userName").val()+"&userPhone="+$("#userPhone").val();
			});
			$("#star").click(function(){
				modifyStatus(1);
			});
			$("#stop").click(function(){
				modifyStatus(2);
			});
		});
		function modifyStatus(userStatus){
			var id=$("input:radio[name='select']:checked").val();
			location.href="joyBeans/modifyStatus.action?id="+id+"&userStatus="+userStatus;
		}
	</script>
  </head>
  
  <body>
    <form method="post" action="">
	  <div class="panel admin-panel">
	    <div class="panel-head"><strong> 用户管理</strong></div>
	    <div class="padding border-bottom">
	      <ul class="search">
	        <li>
	          <button type="button" class="button border-green icon-star" id="star"> 恢复使用</button>&nbsp;&nbsp;
	          <button type="button" class="button border-red icon-stop" id="stop"> 暂停使用</button>
	        </li>
	        <li style="margin-left: 100px;">
		        账号：<input value="${userAccount}" type="text" placeholder="请输入账号" id="userAccount" name="userAccount" class="input" style="width:250px; line-height:17px;display:inline-block" />&nbsp;&nbsp;
		        姓名：<input value="${userName}" type="text" placeholder="请输入姓名" id="userName" name="userName" class="input" style="width:250px; line-height:17px;display:inline-block" />&nbsp;&nbsp;
	       	 	手机号：<input value="${userPhone}" type="text" placeholder="请输入手机号" id="userPhone" name="userPhone" class="input" style="width:250px; line-height:17px;display:inline-block" />&nbsp;&nbsp;
	          	<font id="serch" class="button border-main icon-search" onclick="changesearch()" > 搜索</font>
	        </li>
	      </ul>
	    </div>
    <table class="table table-hover text-center" id="userTable">
      <tr>
        <th width="120">ID</th>
        <th>用户账号</th>
        <th>姓名</th>
        <th>手机号</th>
        <th width="20%">状态</th>
        <th width="15%">创建时间</th>
      </tr>      
     <c:forEach items="${pageModel.dataList}" var="joyBeansUser">
     <tr>
     	<td>
     		<input type="radio" name="select" value="${joyBeansUser.id}"/>
     		${joyBeansUser.id}
     	</td>
     	<td>${joyBeansUser.userAccount}</td>
     	<td>${joyBeansUser.userName}</td>
     	<td>${joyBeansUser.userPhone}</td>
     	<td>${joyBeansUser.userStatus}</td>
     	<td>${joyBeansUser.createTime}</td>
     </tr>
     </c:forEach>
      <tr>
        <td colspan="6">
          <div class="pagelist">
       	    <a href="joyBeans/queryAll.action?pageNo=${pageModel.firstPage}&userAccount=${userAccount}&userName=${userName}&userPhone=${userPhone}">首页</a> 
       	  	<a href="joyBeans/queryAll.action?pageNo=${pageModel.prePage}&userAccount=${userAccount}&userName=${userName}&userPhone=${userPhone}">上一页</a> 
       	  	<a href="joyBeans/queryAll.action?pageNo=${pageModel.nextPage}&userAccount=${userAccount}&userName=${userName}&userPhone=${userPhone}">下一页</a>
       	  	<a href="joyBeans/queryAll.action?pageNo=${pageModel.lastPage}&userAccount=${userAccount}&userName=${userName}&userPhone=${userPhone}">尾页</a>
       	  	<span style="border: white;">第${pageModel.pageNo}/${pageModel.totalPage}页</span>
       	  </div>
       	</td>
      </tr>
     </table>
    </div>
   </form>
  </body>
</html>
