<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<base href="<%=basePath%>">
	<title>请假管理</title>
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
				location.href="njwb/holiday/holidayAdd.jsp";
			});
			
			$("#approve").click(function(){
				location.href="auditBefor.do?workID=1&waitingUserID="+$("#userID").val();
			});
			
			$("#queryHoliday").click(function(){
				location.href="queryHolidays.do?name="+$("#name").val()+"&holidayType="+$("#holidayType").val()+"&status="+$("#status").val();
			});
			
			$("#name").keyup(function(){
				var name = $.trim($("#name").val());
				if("" != name){
  				$.ajax({
  					type:"GET",
  					url:"queryHolidaysByName.do?name=" + name,
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
		    //$.trim($(obj).text());
		    $("#name").val($.trim($(obj).text()));
		    //让nameContainer隐藏
		    $("#nameContainer").css("display","none");
		  }
		
		function del(holidayNo,holidayStatus){
			if(holidayStatus!="草稿"){
				alert("已提交的请假信息不允许删除");
			}else{
				if(confirm("确定删除吗?")){
					location.href="holidayDel.do?holidayNo="+holidayNo;
				}
			}
		}
			
		function edit(holidayNo,holidayStatus){
			if(holidayStatus!="草稿"){
				alert("已提交的请假信息不允许修改");
			}else{
				location.href="queryHolidayForUpdate.do?holidayNo=" + holidayNo;
			}
		}
		    
		function showDetail(holidayNo,holidayStatus){
			location.href="queryHoliday.do?holidayNo=" + holidayNo;
		}
		
		function process(holidayNo,holidayStatus){
			if(holidayStatus=="草稿"){
				alert("未提交假条没有审批进度信息！");
			}else{
				location.href="queryHistoryAudit.do?workID=1&tableID="+holidayNo;
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
	      left:61px;
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
					首页 &gt;&gt;请假管理
			</h1>
			<div class="add">
				<img alt="" src="img/add.png" width="18px" height="18px" id="add">添加请假&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="hidden" id="userID" value="${user.ID}">
				<img alt="" src="img/audit.png" width="18px" height="18px" id="approve">审批请假条
			</div>
			<div id="query" class="query">
					申请人：<div id="nameContainer"></div>
					<input type="text" style="width: 100px" id="name" value="${name}">
					&nbsp;&nbsp;&nbsp;&nbsp; 请假类型：
					<select name="holidayType" id="holidayType">
						<option value="">不限</option>
						<c:forEach items="${holidayTypeList}" var="Type" >
	        				<c:choose>
		         				<c:when test="${Type.id==holidayType}">
		         					<option value="${Type.id}" selected="selected">${Type.value}</option>
		         				</c:when>
		         				<c:otherwise>
		         					<option value="${Type.id}">${Type.value}</option>
		         				</c:otherwise>
			        		</c:choose>
		       			</c:forEach>
					</select>
					&nbsp;&nbsp;&nbsp;&nbsp; 请假状态：
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
					<input type="button" value="查询" id="queryHoliday">
			</div>
			<table class="holidayInfo">
					<tr class="titleRow">
							<td class="tr1">
									请假编号
							</td>
							<td>
									申请人
							</td>
							<td>
									请假类型
							</td>
							<td class="tr2">
									开始时间
							</td>
							<td class="tr2">
									结束时间
							</td>
							<td>
									申请状态
							</td>
							<td>
									提交时间
							</td>
							<td>
									操作列表
							</td>
					</tr>
					<c:forEach items="${pageModel.dataList}" var="holiday">
							<tr>
								<td>${holiday.holidayNo}</td>
         						<td>${holiday.holidayName}</td>
	         					<td>${holiday.holidayTypeValue}</td>
	         					<td><fmt:formatDate value="${holiday.startTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
	         					<td><fmt:formatDate value="${holiday.endTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
	         					<td>${holiday.holidayStatus}</td>
        						<td><fmt:formatDate value="${holiday.createTime}" pattern="yyyy-MM-dd"/></td>
								<td>
									<img alt="" src="img/delete.png" class="operateImg" onclick="del('${holiday.holidayNo}','${holiday.holidayStatus}')">
									<img alt="" src="img/edit.png" class="operateImg" onclick="edit('${holiday.holidayNo}','${holiday.holidayStatus}')">
									<img alt="" src="img/detail.png" class="operateImg" onclick="showDetail('${holiday.holidayNo}','${holiday.holidayStatus}')">
									<img alt="" src="img/process.png" class="operateImg" onclick="process('${holiday.holidayNo}','${holiday.holidayStatus}')">
								</td>
							</tr>
					</c:forEach>
					<tr>
							<td colspan="8">
									<a href="queryHolidays.do?pageNo=${pageModel.firstPage}&name=${name}&holidayType=${holidayType}&status=${status}">首页</a>&nbsp;&nbsp;
									<a href="queryHolidays.do?pageNo=${pageModel.prePage}&name=${name}&holidayType=${holidayType}&status=${status}">上一页</a>&nbsp;&nbsp;
									<a href="queryHolidays.do?pageNo=${pageModel.nextPage}&name=${name}&holidayType=${holidayType}&status=${status}">下一页</a>&nbsp;&nbsp;
									<a href="queryHolidays.do?pageNo=${pageModel.lastPage}&name=${name}&holidayType=${holidayType}&status=${status}">尾页</a> &nbsp;&nbsp;&nbsp;
									<span>第${pageModel.pageNo}/${pageModel.totalPage}页</span>
							</td>
					</tr>
			</table>
	</body>
</html>
