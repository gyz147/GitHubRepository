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
    
    <title>乐豆换算比例</title>
    
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
					title:'新增乐豆换算比例',
					shadeClose:true,
					shade:0.2,
					move:false,
					offset:['10%','40%'],
					area:['280px','330px'],
					content:'beans/sysUser/beanExchange/addBeanExchange.jsp'
				});
			});
			
			$("#delet").click(function(){
				var id=$("input[name='beanExchangeId']:checked").val();
				if(id==null){
					alert("未选中！");
				}else{
					if(confirm("确认删除？")){
						location.href="beanExchange/deleteBeanExchange.action?id="+id;
					}
				}
			});
			
			$("#edit").click(function(){
				var id=$("input[name='beanExchangeId']:checked").val();
				if(id==null){
					alert("未选中！");
				}else{
					layer.open({
						type:2,
						title:'修改乐豆换算比例',
						shadeClose:true,
						shade:0.2,
						move:false,
						offset:['10%','40%'],
						area:['280px','330px'],
						content:'beanExchange/queryForUpdate.action?id='+id
					});
				}
			});
			
			$("#select").click(function(){
				location.href="beanExchange/queryAll.action?provName="+$("#provName").val();
			});
		});
	
	</script>
  </head>
  
  <body>
    <form method="post" action="">
	  <div class="panel admin-panel">
	    <div class="panel-head">
	    	<strong>乐豆换算比例</strong>
	    	<span style="margin-left:50px;">默认配置：消费1元赠送1个乐豆</span>
	    </div>
	    <div class="padding border-bottom">
	      <ul class="search">
	        <li>
	          <button type="button"  class="button border-green icon-plus-square-o" id="add"> 新增</button>&nbsp;&nbsp;
	          <button type="button" class="button border-blue icon-pencil" id="edit"> 修改</button>&nbsp;&nbsp;
	          <button type="button" class="button border-red icon-trash-o" id="delet"> 删除</button>
	        </li>
	        <li style="margin-left: 666px;">
	       	 	省份：<input id="provName" type="text" placeholder="请输入省份" name="provName" value="${provName}" class="input" style="width:250px; line-height:17px;display:inline-block" />&nbsp;&nbsp;
	          	<button type="button" id="select" class="button border-main icon-search"> 查询</button>
	        </li>
	      </ul>
	    </div>
    <table class="table table-hover text-center" id="userTable">
      <tr>
        <th width="120"></th>
        <th>ID</th>
        <th>省份</th>
        <th>消费金额</th>
        <th width="25%">创建时间</th>
        <th width="25%">更新时间</th>
      </tr>
      <c:forEach items="${pageModel.dataList}" var="beanExchange">
      <tr>
        <td><input type="radio" name="beanExchangeId" value="${beanExchange.id}" /></td>
        <td>${beanExchange.id}</td>
        <td>${beanExchange.provName}</td>  
        <td>${beanExchange.price}</td>         
        <td>${beanExchange.createTime}</td>
        <td>${beanExchange.modifyTime}</td>
      </tr>
      </c:forEach>
      <tr>
       	<td colspan="6">
       	 <div class="pagelist"> 
       	 	<a href="beanExchange/queryAll.action?pageNo=${pageModel.firstPage}&provName=${provName}">首页</a> 
       	  	<a href="beanExchange/queryAll.action?pageNo=${pageModel.prePage}&provName=${provName}">上一页</a> 
       	  	<a href="beanExchange/queryAll.action?pageNo=${pageModel.nextPage}&provName=${provName}">下一页</a>
       	  	<a href="beanExchange/queryAll.action?pageNo=${pageModel.lastPage}&provName=${provName}">尾页</a>
       	  	<span style="border: white;">第${pageModel.pageNo}/${pageModel.totalPage}页</span>
       	 </div>
       </td>
      </tr>
     </table>
    </div>
   </form>
  </body>
</html>
