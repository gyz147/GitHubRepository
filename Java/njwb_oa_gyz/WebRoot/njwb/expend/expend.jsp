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
    
    <title>报销管理</title>
    
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
				location.href="njwb/expend/expendAdd.jsp";
			});
			
			$("#approve").click(function(){
				location.href="auditBefor.do?workID=2&waitingUserID="+$("#userID").val();
			});
			
			$("#queryExpend").click(function(){
				location.href="queryExpends.do?name="+$("#name").val()+"&expendType="+$("#expendType").val()+"&status="+$("#status").val();
			});
			
			$("#name").keyup(function(){
				var name = $.trim($("#name").val());
				if("" != name){
  				$.ajax({
  					type:"GET",
  					url:"queryExpendsByName.do?name=" + name,
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
		
			function del(expendNo,expendStatus){
				if(expendStatus=="已提交"){
					alert("已提交的请假信息不允许删除");
				}else{
					if(confirm("确定删除吗?")){
						location.href="expendDel.do?expendNo="+expendNo;
					}
				}
			}
			
			function edit(expendNo,expendStatus){
				if(expendStatus=="已提交"){
					alert("已提交的请假信息不允许修改");
				}else{
					location.href="queryExpendForUpdate.do?expendNo="+expendNo;
				}
			}
		    
		    function showDetail(expendNo,expendStatus){
				location.href="queryExpend.do?expendNo="+expendNo;
		    }
		    
		    function process(expendNo,expendStatus){
		    	if(expendStatus=="已提交"){
					location.href="queryHistoryAudit.do?workID=2&tableID="+expendNo;
				}else{
					alert("未提交报销条没有审批进度信息！");
				}
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
				<h1 class="title">
						首页 &gt;&gt;报销管理
				</h1>
				<div class="add">
						<img alt="" src="img/add.png" width="18px" height="18px" id="add">添加报销&nbsp;&nbsp;&nbsp;&nbsp;
						<img alt="" src="img/audit.png" width="18px" height="18px" id="approve">审批报销条
						<input type="hidden" id="userID" value="${user.ID}">
				</div>
				<div id="query" class="query">
						申请人:<div id="nameContainer"></div>
						<input type="text" style="width: 100px" id="name" value="${name}">
						&nbsp;&nbsp;&nbsp;&nbsp;报销类型：
						<select name="expendType" id="expendType">
							<option value="">不限</option>
							<c:forEach items="${expendTypeList}" var="Type" >
	         					<c:choose>
			         				<c:when test="${Type.id==expendType}">
			         					<option value="${Type.id}" selected="selected">${Type.value}</option>
			         				</c:when>
			         				<c:otherwise>
			         					<option value="${Type.id}">${Type.value}</option>
			         				</c:otherwise>
			         			</c:choose>
		         			</c:forEach>
						</select>
						&nbsp;&nbsp;&nbsp;&nbsp; 申请状态：
						<select name="status" id="status">
								<option value="">不限</option>
								<c:choose>
									<c:when test="${status=='1'}">
										<option value="0">草稿</option>
										<option value="1" selected="selected">已提交	</option>
									</c:when>
									<c:when test="${status=='0'}">
										<option value="0" selected="selected">草稿</option>
										<option value="1">已提交	</option>
									</c:when>
									<c:otherwise>
										<option value="0">草稿</option>
										<option value="1">已提交	</option>
									</c:otherwise>
								</c:choose>
						</select>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="button" value="查询" id="queryExpend">
				</div>
				<table class="expendInfo">
						<tr class="titleRow">
								<td class="tr1">
										报销编号
								</td>
								<td>
										申请人
								</td>
								<td>
										报销类型
								</td>
								<td>
										金额
								</td>
								<td>
										申请时间
								</td>
								<td>
										申请状态
								</td>
								<td>
										操作列表
								</td>
						</tr>
						<c:forEach items="${pageModel.dataList}" var="expend">
								<tr>
									<td>${expend.expendNo}</td>
	         						<td>${expend.expendName}</td>
	         						<td>${expend.expendTypeValue}</td>
	         						<td>${expend.expendCount}</td>
	         						<td>${expend.createTime}</td>
	         						<td>${expend.expendStatus}</td>
									<td>
										<img alt="" src="img/delete.png" class="operateImg" onclick="del('${expend.expendNo}','${expend.expendStatus}')">
										<img alt="" src="img/edit.png" class="operateImg" onclick="edit('${expend.expendNo}','${expend.expendStatus}')">
										<img alt="" src="img/detail.png" class="operateImg" onclick="showDetail('${expend.expendNo}','${expend.expendStatus}')">
										<img alt="" src="img/process.png" class="operateImg" onclick="process('${expend.expendNo}','${expend.expendStatus}')">
									</td>
								</tr>
						</c:forEach>
						<tr>
								<td colspan="7">
										<a href="queryExpends.do?pageNo=${pageModel.firstPage}&name=${name}&expendType=${expendType}&status=${status}">首页</a>&nbsp;&nbsp;
										<a href="queryExpends.do?pageNo=${pageModel.prePage}&name=${name}&expendType=${expendType}&status=${status}">上一页</a>&nbsp;&nbsp;
										<a href="queryExpends.do?pageNo=${pageModel.nextPage}&name=${name}&expendType=${expendType}&status=${status}">下一页</a>&nbsp;&nbsp;
										<a href="queryExpends.do?pageNo=${pageModel.lastPage}&name=${name}&expendType=${expendType}&status=${status}">尾页</a> &nbsp;&nbsp;&nbsp;
										<span>第${pageModel.pageNo}/${pageModel.totalPage}页</span>
								</td>
						</tr>
				</table>
		</body>
</html>
