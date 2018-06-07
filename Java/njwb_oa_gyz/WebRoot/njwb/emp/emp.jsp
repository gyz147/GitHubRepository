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
    
    <title>员工管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/reset.css">
    <link rel="stylesheet" type="text/css" href="css/main.css">
	<script type="text/javascript" src="<%=basePath%>js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript">
		$(function(){
			$("#add").click(function(){
				location.href="njwb/emp/empAdd.jsp";
			});
			
			$("#queryName").click(function(){
				location.href="queryEmps.do?empName="+$("#name").val()+"&deptNo="+$("#deptNo").val();
			});
			
			$("#name").keyup(function(){
				var name = $.trim($("#name").val());
				if("" != name){
  				$.ajax({
  					type:"GET",
  					url:"queryEmpsByName.do?name=" + name,
  					dataType:"json",
  					success:function(names){
  					    var htmlStr = "";
  						for(var i = 0; i < names.length; i++){
  							htmlStr += " <div onmouseover='setBgColor(this)' onmouseout='resetBgColor(this)' onclick='selectName(this)'>"
  							             + names[i]
  							             + "</div>"
  						}
  						if(names.length != 0){
  							$("#nameContainer").html(htmlStr);
  							$("#nameContainer").css("display","block");
  						}
  					}
  				});
  			  }else{
  			    $("#nameContainer").html("");
  			    $("#nameContainer").css("display","none");
  			  }
			});
		});

		 function setBgColor(obj){
		    $(obj).removeClass("resetColor");
		  	$(obj).addClass("selectedColor");	
		  }
		  
		  function resetBgColor(obj){
		    $(obj).removeClass("selectedColor");
		    $(obj).addClass("resetColor");	
		  }
		  
		  function selectName(obj){
		    $("#name").val($.trim($(obj).text()));
		    $("#nameContainer").css("display","none");
		  }
		  
		function del(empNo){
			if(confirm("确定删除吗?")){
				location.href="empDel.do?empNo="+empNo;
			}
		}
		
		function edit(empNo){
			location.href="queryEmpForUpdate.do?empNo=" + empNo;
		}
	    
	    function showDetail(empNo){
	    	location.href="queryEmp.do?empNo=" + empNo;
	    }
	</script>
	<style type="text/css">
	   *{
	   	 	margin: 0px;
	   	 	padding: 0px;
	    }
	
	   #nameContainer{
	   	  width: 67px;
	   	  border: 1px solid #9FBAD6;
	      position: absolute;
	      left:47px;
	      display: none;
	      background-color: white;
	   }
	   
	   .selectedColor{
	   	  background-color: #DBEAF9;
	   }
	   .resetColor{
	   	  background-color: white;
	   }
	 </style>
  </head>
  
  <body>
			<h1 class="title">首页  &gt;&gt;员工管理 </h1>
         	
         	<div class="add">
         		<img alt="" src="img/add.png" width="18px" height="18px" id="add">添加员工
         	</div>
         	
         	<div id="query" class="query">
         	姓名：<div id="nameContainer"></div>
         	<input type="text" style="width:100px" id="name" value="${empName}">&nbsp;&nbsp;&nbsp;&nbsp; 
         	部门：<select name="deptNo" id="deptNo">
         			<option value="">不限</option>
	         		<c:forEach items="${deptList}" var="dept" >
	         			<c:choose>
	         				<c:when test="${dept.deptNo==deptNo}">
	         					<option value="${dept.deptNo}" selected="selected">${dept.deptName}</option>
	         				</c:when>
	         				<c:otherwise>
	         					<option value="${dept.deptNo}">${dept.deptName}</option>
	         				</c:otherwise>
	         			</c:choose>
	         		</c:forEach>
         		 </select>&nbsp;&nbsp;&nbsp;&nbsp;
         		<input type="button" value="查询" id="queryName">
         	</div>
         	<table class="deptInfo">
         		<tr class="titleRow">
         			<td>员工编号</td>
         			<td>员工名称</td>
         			<td>性别</td>
         			<td>所属部门</td>
         			<td>部门名称</td>
         			<td>入职时间</td>
         			<td>操作列表</td>
         		</tr>
         		
         		
         		 <c:forEach items="${pageModel.dataList}" var="emp">
         		 	     <tr>
         						<td>${emp.empNo}</td>
         						<td>${emp.empName}</td>
         						<td>${emp.empSex}</td>
         						<td>${emp.deptNo}</td>
         						<td>${emp.deptName}</td>
         						<td>${emp.entryTime}</td>
         						<td>
         							<img alt="" src="img/delete.png" class="operateImg" onclick="del('${emp.empNo}')">
         							<img alt="" src="img/edit.png" class="operateImg" onclick="edit('${emp.empNo}')">
         							<img alt="" src="img/detail.png" class="operateImg" onclick="showDetail('${emp.empNo}')">
         						</td>
         				  </tr>
         		 
         		 </c:forEach>
         	     <tr>
         	         <td colspan="7">
         	         	<a href="queryEmps.do?pageNo=${pageModel.firstPage}&empName=${empName}&deptNo=${deptNo}">首页</a>&nbsp;&nbsp;
         	         	<a href="queryEmps.do?pageNo=${pageModel.prePage}&empName=${empName}&deptNo=${deptNo}">上一页</a>&nbsp;&nbsp;
         	         	<a href="queryEmps.do?pageNo=${pageModel.nextPage}&empName=${empName}&deptNo=${deptNo}">下一页</a>&nbsp;&nbsp;
         	         	<a href="queryEmps.do?pageNo=${pageModel.lastPage}&empName=${empName}&deptNo=${deptNo}">尾页</a>
         	         	&nbsp;&nbsp;&nbsp;<span>第${pageModel.pageNo}/${pageModel.totalPage}页</span>
       	           </td>
         	     </tr>               
         	</table>    

  </body>
</html>
