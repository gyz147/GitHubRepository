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
    
    <!--<link rel="stylesheet" type="text/css" href="./styles.css">-->
	<style type="text/css">
		body,div,table,tr,td{
			margin: 0px;
			padding: 0px;
		}
	
		#deptEditTable{
			font-size: 15px;
			border-collapse: collapse;
			width: 350px;
			margin: 20px auto;
			
			
		}
		
		#deptEditTable td{
			height: 40px;
		}
	
	</style>
  </head>
  <script type="text/javascript">
  		//一系列验证
  
  </script>
  <body>
     
   	<form action="deptEdit.do" method="post">
	   	<table id = "deptEditTable">
	   		<tr>
	   			<td>
	   			部门编号:
	   			</td>
	   			<td>
	   				<input type = "text" name="deptNo" id="deptNo" value="${dept.deptNo }" readonly="readonly"/>
	   			</td>
	   		</tr>
	   		<tr>
	   			<td>
	   			部门名称:
	   			</td>
	   			<td>
	   				<input type = "text" name="deptName" id="deptName" value="${dept.deptName }"/>
	   			</td>
	   		</tr>  
	   		<tr>
	   			<td>
	   			部门位置:
	   			</td>
	   			<td>
	   				<input type = "text" name="deptLoc" id="deptLoc" value="${dept.deptLoc}"/>
	   			</td>
	   		</tr>  
	   		<tr>
	   			<td>
	   			部门负责人:
	   			</td>
	   			<td>
	   				<input type = "text" name="deptManager" id="deptManager" value="${dept.deptManager }"/>
	   			</td>
	   		</tr>  
	   		<tr>
	   			<td colspan="2">
	   				<input type = "submit" value="修改"/>&nbsp;&nbsp;&nbsp;
	   				<input type = "reset" value="重置"/>&nbsp;&nbsp;&nbsp;
	   				<input type = "button" value="返回" onclick="javascript:history.go(-1);"/>
	   			</td>
	   		</tr>  	
	   	</table>
   	</form>
  </body>
</html>
