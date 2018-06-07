<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
     <title>部门编辑</title>
	
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
    
	<style type="text/css">
		body,div,table,tr,td{
			margin: 0px;
			padding: 0px;
		}
	
		#deptAddTable{
			font-size: 15px;
			border-collapse: collapse;
			width: 350px;
			margin: 20px auto;
			
			
		}
		
		#deptAddTable td{
			height: 40px;
		}
	
	</style>
	
	<script type="text/javascript">
		$(function(){
			$(":submit").click(function(){
				//基础数据校验
				var deptNo = $.trim($("#deptNo").val());
				if(deptNo == ""){
					alert("部门编号不能为空");
					return false;
				}else if(deptNo.length != 5){
				    alert("部门编号长度必须为5位");
				    return false;
				
				}else{
					return true;
				
				}
			
			});
		
		});
	
	</script>
  </head>
  
  <body>
   	<form action=deptAdd.do method="post">
	   	<table id = "deptAddTable">
	   		<tr>
	   			<td>
	   			部门编号:
	   			</td>
	   			<td>
	   				<input type = "text" name="deptNo" id="deptNo"/>
	   			</td>
	   		</tr>
	   		<tr>
	   			<td>
	   			部门名称:
	   			</td>
	   			<td>
	   				<input type = "text" name="deptName" id="deptName"/>
	   			</td>
	   		</tr>  
	
	   		<tr>
	   			<td>
	   			部门位置:
	   			</td>
	   			<td>
	   				<input type = "text" name="deptLoc" id="deptLoc"/>
	   			</td>
	   		</tr>  
	
	   		<tr>
	   			<td>
	   			部门负责人:
	   			</td>
	   			<td>
	   				<input type = "text" name="deptManager" id="deptManager"/>
	   			</td>
	   		</tr>  
	   		
	   		<tr>
	   			<td colspan="2">
	   				<input type = "submit" value="添加"/>
	   				<input type = "reset" value="重置"/>
	   			</td>
	   		</tr>  	
	   	</table>
   	</form>
  </body>
</html>
