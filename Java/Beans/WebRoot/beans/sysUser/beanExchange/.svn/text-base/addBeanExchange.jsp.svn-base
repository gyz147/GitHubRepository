<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加乐豆换算比例</title>
    
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
			$(":submit").click(function(){
				var provCode=$("#provCode").val();
				var price=$("#price").val();
				if(""==provCode || $("#provName").val()!=$("#provNameBack").val()){
					alert("请输入正确的省份");
					return false;
				}else if(!(!isNaN(parseFloat(price)) && price == (parseFloat(price)) && price != 0)){
					alert("请输入正确的金额度");
					return false;
				}else{
					return true;
				}
			});
			$("#provName").keyup(function(){
				var provName=$("#provName").val();
				if(""!=provName){
					$.ajax({
						type:"GET",
						url:"beanExchange/queryForAdd.action?provName="+provName,
						dataType:"json",
						success:function(provs){
							var htmlStr = "";
  							for(var i = 0; i < provs.length; i++){
  								var arr=provs[i].split(",");
  								var provCode=arr[0];
  								var provName=arr[1];
  								htmlStr += " <div id='"+provCode+"' onmouseover='setBgColor(this)' onmouseout='resetBgColor(this)' onclick='selectName(this)'>"
  							             + provName
  							             + "</div>";
  							}
  							if(provs.length != 0){
  								$("#provContainer").html(htmlStr);
  								$("#provContainer").css("display","block");
  							}
						}
					});
				}
				else{
					$("#provContainer").html("");
  			    	$("#provContainer").css("display","none");
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
		  $("#provName").val($.trim($(obj).text()));
		  $("#provNameBack").val($.trim($(obj).text()));
		  $("#provCode").val($.trim($(obj).attr("id")))
		  $("#provContainer").css("display","none");
		}
	</script>
	<style type="text/css">
	   *{
	   	 	margin: 0px;
	   	 	padding: 0px;
	    }
	   #provContainer{
	   	  width: 90px;
	   	  border: 1px solid #9FBAD6;
	      position: absolute;
	      left:16px;
	      display: none;
	      background-color: white;
	      text-align: center;
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
  <form action="beanExchange/addBeanExchange.action" method="get">
    <div class="panel-body" style="text-align: center;">
    	<div class="form-group" style="text-align: left;">
    		<strong>省份：</strong>
    		<input id="provName" type="text" placeholder="请输入省份" autocomplete="off" name="provName" class="input" style="width:250px; line-height:17px;display:inline-block;margin-top:5px;" /><br/>
    		<input id="provNameBack" type="hidden">
    		<input id="provCode" name="provCode" type="hidden" >
    		<div id="provContainer"></div>
    	</div>
    	<br/>
    	<div class="form-group" style="text-align: left;">
    		<strong>赠送1个乐豆所需的消费金额：</strong>
    		<input id="price" type="text" placeholder="请输入金额" name="price" class="input" style="width:250px; line-height:17px;display:inline-block;margin-top:5px;" />
    	</div>
    	<br/>
    	<div class="form-group" style="text-align: center;">
    		<button type="submit" class="button border-green"> 添加</button> &nbsp;&nbsp;
			<span><input type="reset" class="button border-red" value="重置" style="width:60px;"></span>
    	</div>
    </div>
   </form>
  </body>
</html>
