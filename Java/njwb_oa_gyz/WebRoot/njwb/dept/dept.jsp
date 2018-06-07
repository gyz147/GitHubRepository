<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>部门管理</title>
	
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    
    <link rel="stylesheet" type="text/css" href="<%=basePath%>css/reset.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>css/main.css">
    <script type="text/javascript" src="<%=basePath%>js/jquery-1.8.3.min.js"></script>


	<style type="text/css">
	
	
	</style>
	
	<script type="text/javascript">
		$(function(){
			$("#add").click(function(){
			    //添加
				location.href="njwb/dept/deptAdd.jsp";
			});
		})

		function del(deptNo){
			if(confirm("确定删除吗?")){
				//删除
				location.href="deptDel.do?deptNo=" + deptNo;
			}
		}
		
		//obj 修改图片
		function edit(deptNo){
			location.href="queryDeptForUpdate.do?deptNo=" + deptNo;
		}
	    
	    //obj  明细图片
	    function showDetail(deptNo){
			location.href="queryDept.do?deptNo=" + deptNo;	    
	    }
	</script>
  </head>
  
  <body>
       <h1 class="title">首页  &gt;&gt;部门管理 </h1>
         	
       <div class="add">
        	<img alt="" src="<%=basePath%>img/add.png" width="18px" height="18px" id="add">添加部门
       </div>  	
         	
         	<table class="deptInfo">
         		<tr class="titleRow">
         			<td>部门编号</td>
         			<td>部门名称</td>
         			<td>部门位置</td>
         			<td>部门负责人</td>
         			<td>操作列表</td>
         		</tr>
			<c:forEach items="${pageModel.dataList}" var="dept">
         		<tr>
         			<td>${dept.deptNo}</td>
         			<td>${dept.deptName}</td>
         			<td>${dept.deptLoc}</td>
         			<td>${dept.deptManager}</td>			
         			<td>
         				<img alt="" src="img/delete.png" class="operateImg" onclick="del('${dept.deptNo}')">
         				<img alt="" src="img/edit.png" class="operateImg" onclick="edit('${dept.deptNo}')">
         				<img alt="" src="img/detail.png" class="operateImg" onclick="showDetail('${dept.deptNo}')">
         			</td>			
         		</tr> 	     
         	</c:forEach>         		 
         	     <tr>
         	         <td colspan="5">
         	         	<a href="queryDepts.do?pageNo=${pageModel.firstPage}">首页</a>&nbsp;&nbsp;
         	         	<a href="queryDepts.do?pageNo=${pageModel.prePage}">上一页</a>&nbsp;&nbsp;
         	         	<a href="queryDepts.do?pageNo=${pageModel.nextPage}">下一页</a>&nbsp;&nbsp;
         	         	<a href="queryDepts.do?pageNo=${pageModel.lastPage}">尾页</a>
         	         	&nbsp;&nbsp;&nbsp;<span>第${pageModel.pageNo}/${pageModel.totalPage}页</span>
       	           </td>
         	     </tr>         
         	</table>
  </body>
</html>
