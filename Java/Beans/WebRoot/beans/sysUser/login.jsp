<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录乐豆后台管理系统</title>
    
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
	var code=null;
	$(function(){
		$("#sendCode").click(function(){
			var account=$.trim($("#account").val());
			if(""!=account){
				$.ajax({
					type:"GET",
					url:"sysUser/getCode.action?account="+account,
					dataType:"json",
					success:function(messages){
						var phone=null;
						phone=messages[0];
						code=messages[1];						
						if(null!=phone){
							$("#message").html(phone+"的验证码是："+code);
							$("#message").css("color","black");
							$("#message").css("display","block");
							getCode(60);
						}else{
							$("#message").html("账号不存在！");
							$("#message").css("color","red");
							$("#message").css("display","block");
						}
					}
				});
			}
		});
		
		$(":submit").click(function(){
			if(code !=$("#code").val()){
				alert("验证码有误！");
				return false;
			}
		});
	});
	function getCode(s) {
		$("#sendCode").attr("disabled","disabled");
		$("#sendCode").css("background-color", "#E1E2E3");
		$("#sendCode").css("color", "black");
		$("#sendCode").val(s + "秒");
		if (s <= 0) {
			code=null;
			$("#sendCode").removeAttr("disabled");
			$("#sendCode").css("background-color", "#00AAEE");
			$("#sendCode").css("color", "white");
			$("#sendCode").val("重新发送");
		} else {
			setTimeout("getCode(" + (s - 1) + ")", 1000);
		}
	}
	</script>
  </head>
  
  <body>
    <div class="bg"></div>
	<div class="container">
    <div class="line bouncein">
        <div class="xs6 xm4 xs3-move xm4-move">
            <div style="height:150px;"></div>
            <div class="media media-y margin-big-bottom">           
        </div>         
        <form action="sysUser/login.action" method="post">
            <div class="panel loginbox">
                <div class="text-center margin-big padding-big-top"><h1>乐豆后台管理中心</h1></div>
                <p id="message" style="text-align: center;display: none;"></p>
                <div class="panel-body" style="padding:30px; padding-bottom:10px; padding-top:10px;">
                    <div class="form-group">
                        <div class="field field-icon-right">
                            <input id="account" name="account" type="text" class="input input-big" placeholder="登录账号" data-validate="required:请填写账号" />
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="field field-icon-right">
                            <input name="password" type="password" class="input input-big" placeholder="登录密码" data-validate="required:请填写密码" />
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="field">
                            <input id="code" type="text" class="input input-big" name="code" placeholder="验证码" data-validate="required:请填写手机接受到的验证码" />
                            <input type="button" value="发送验证码" width="100" height="32" class="passcode" id="sendCode"/>
                        </div>
                    </div>
                </div>
                <div style="padding:30px;">
                	<input type="submit" class="button button-block bg-main text-big input-big" value="登录">
                </div>
            </div>
          </form>          
        </div>
    </div>
	</div>
  </body>
</html>
