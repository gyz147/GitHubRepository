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
    
    <title>批量生成密报卡</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/pintuer.css">
	<link rel="stylesheet" type="text/css" href="css/admin.css">
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/laydate/laydate.js"></script>
	<script type="text/javascript">
		$(function(){
			$("input[name='provCode']").click(function(){
				check_box();
			});
			$(":submit").click(function(){
				var provStr=$("#provStr").val();
				if(provStr==null || provStr==""){
					alert("请选择省份");
					return false;
				}
				var cardNumbers=$("#cardNumbers").val();
				if(cardNumbers==null || cardNumbers==""){
					alert("请填写密保卡数量");
					return false;
				}
				var beansNumber=$("#beansNumber").val();
				if(beansNumber==null || beansNumber==""){
					alert("请填写密保卡金额");
					return false;
				}
				var startTime=$("#startTime").val();
				if(startTime==null || startTime==""){
					alert("请选择开始时间");
					return false;
				}
				var endTime=$("#startTime").val();
				if(endTime==null || endTime==""){
					alert("请选择结束时间");
					return false;
				}else{
					return true;					
				}
			});
		});
		function check_box(){
			var provStr="";
			$("input[name='provCode']:checked").each(function(){
				provStr+=$(this).val()+",";
			});
			provStr=provStr.substring(0,provStr.length-1);
			$("#provStr").val(provStr);
		}
		var start={
			elem:'#startTime',
			format:'YYYY-MM-DD',
			min:laydate.now(+7),
			max:'2099-06-16',
			festival:true,
			istoday:false,
			choose:function(datas){
				end.min=datas;
				end.start=datas;
			}
		};
		var end={
			elem:'#endTime',
			format:'YYYY-MM-DD',
			min:laydate.now(+7),
			max:'2099-06-16',
			festival:true,
			istoday:false,
			choose:function(datas){
				start.max=datas;
			}
		};
	</script>
  </head>
  
  <body>
  <form action="secretCard/addSecretCard.action" method="post">
    <div class="panel-body" style="text-align: center;">
    	<div class="form-group" style="text-align: left;">
    		<strong>请选择省份:</strong>
    		<input id="provStr" name="provStr" type="hidden"/>
    		<div style="width: 545px;">
    			<c:forEach items="${provinceList}" var="province" varStatus="i" begin="0">
    				<input name="provCode" type="checkbox" style="margin-left: 15px;margin-top: 5px;" value="${province.provCode}"/>${province.provName}
    				<c:if test="${(i.index+1)%5==0}">
    					<br/>
    				</c:if>
    			</c:forEach>
    		</div>
    	</div>
    	<div class="form-group" style="text-align: left;">
    		<strong>数量(张)：</strong>
    		<input id="cardNumbers" name="cardNumbers" type="text" placeholder="请输入数量" class="input" style="width:100px; line-height:17px;display:inline-block;margin-top:5px;" />
    		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    		<strong>金额(个)：</strong>
    		<input id="beansNumber" name="beansNumber" type="text" placeholder="请输入金额" class="input" style="width:100px; line-height:17px;display:inline-block;margin-top:5px;" />
    	</div>
    	<div class="form-group" style="text-align: left;">
    		<strong>有效开始时间：</strong>
    		<input type = "text" name="startTime" placeholder="请选择" id="startTime" class="laydate-icon" onclick="laydate(start)"/>
    		<br/><br/>
    		<strong>有效结束时间：</strong>
    		<input type = "text" name="endTime" placeholder="请选择" id="endTime" class="laydate-icon" onclick="laydate(end)"/>
    	</div>
    	<div class="form-group" style="text-align: center;">
    		<button type="submit" class="button border-green">提交</button> &nbsp;&nbsp;
			<span><input type="reset" class="button border-red" value="重置" style="width:60px;"></span>
    	</div>
    </div>
   </form>
  </body>
</html>
