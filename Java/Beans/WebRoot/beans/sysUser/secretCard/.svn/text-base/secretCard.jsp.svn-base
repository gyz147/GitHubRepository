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
    
    <title>定向密报卡管理</title>
    
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
	<script type="text/javascript" src="js/laydate/laydate.js"></script>
	<script type="text/javascript">
		$(function(){
			$("#add").click(function(){
				layer.open({
					type:2,
					title:'批量生成密报卡',
					shadeClose:true,
					shade:0.2,
					move:false,
					offset:['10%','28%'],
					area:['580px','450px'],
					content:'secretCard/queryForAdd.action'
				});
			});
			$("#select").click(function(){
				location.href="secretCard/queryAll.action?cardNo="+$("#cardNo").val()+"&provName="+$("#provName").val()+"&endTime="+$("#endTime").val();
			});
		});
	
	</script>
  </head>
  
  <body>
    <form method="post" action="">
	  <div class="panel admin-panel">
	    <div class="panel-head">
	    	<strong>定向密报卡管理</strong>
	    </div>
	    <div class="padding border-bottom">
	      <ul class="search">
	        <li>
	          <button type="button"  class="button border-green icon-check" id="checkall"> 全选</button>&nbsp;&nbsp;
	          <button type="button"  class="button border-blue icon-pencil-square-o" id=""> 导出</button>&nbsp;&nbsp;
	          <button type="button" class="button border-yellow icon-plus-square-o" id="add"> 批量生成密报卡</button>
	        </li>
	        <li style="margin-left: 211px;">
		        卡号：<input id="cardNo" value="${cardNo}" type="text" placeholder="请输入卡号" name="keywords" class="input" style="width:150px; line-height:17px;display:inline-block" />&nbsp;&nbsp;
		        省份：<input id="provName" value="${provName}" type="text" placeholder="请输入省份" name="keywords" class="input" style="width:150px; line-height:17px;display:inline-block" />&nbsp;&nbsp;
	       	 	密报卡到期时间：<input id="endTime"  value="${endTime}" type="text" placeholder="请选择"  class="laydate-icon" style="width:180px; line-height:17px;display:inline-block" onclick="laydate()"/>&nbsp;&nbsp;
	          	<button type="button" id="select" class="button border-main icon-search"> 查询</button>
	        </li>
	      </ul>
	    </div>
    <table class="table table-hover text-center" id="userTable">
      <tr>
        <th width="100px"></th>
        <th width="150px">卡号</th>
        <th>密码</th>
        <th>金额</th>
        <th width="180px">省份</th>
        <th>有效开始时间</th>
        <th>有效结束时间</th>
        <th width="100px">状态</th>
        <th>创建时间</th>
      </tr>     
      <c:forEach items="${pageModel.dataList}" var="secretCard"> 
      <tr>
       <td><input type="checkbox" name="id[]" value="1"/></td>
        <td>${secretCard.cardNo}</td>
        <td>${secretCard.cardPwd}</td>  
        <td>${secretCard.beansNumbers}</td>         
        <td>${secretCard.provName}</td>
        <td>${secretCard.startTime}</td>
        <td>${secretCard.endTime}</td>
        <td>${secretCard.cardStatus}</td>
        <td>${secretCard.createTime}</td>
      </tr>
      </c:forEach>
      <tr>
       	<td colspan="9">
       	 <div class="pagelist"> 
       	 	<a href="secretCard/queryAll.action?pageNo=${pageModel.firstPage}&cardNo=${cardNo}&provName=${provName}&endTime=${endTime}">首页</a> 
       	  	<a href="secretCard/queryAll.action?pageNo=${pageModel.prePage}&cardNo=${cardNo}&provName=${provName}&endTime=${endTime}">上一页</a> 
       	  	<a href="secretCard/queryAll.action?pageNo=${pageModel.nextPage}&cardNo=${cardNo}&provName=${provName}&endTime=${endTime}">下一页</a>
       	  	<a href="secretCard/queryAll.action?pageNo=${pageModel.lastPage}&cardNo=${cardNo}&provName=${provName}&endTime=${endTime}">尾页</a>
       	  	<span style="border: white;">第${pageModel.pageNo}/${pageModel.totalPage}页</span>
       	 </div>
       	</td>
      </tr>
     </table>
    </div>
   </form>
  </body>
</html>
