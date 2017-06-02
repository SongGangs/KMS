<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>Kindergarten Manage System</title>

<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="icon" href="favicon.ico" />

<!-- 由于母版页中引入了那些JS及CSS文件 所以这里不需要再次引入
但是JS文件应该放在最下面 important -->
<!--登陆注册通用的基本样式-->
<link href="/KMS/CSS/account/account.css" rel="stylesheet" type="text/css" />
<!--注册的基本样式-->
<link href="/KMS/CSS/account/register.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<%@ include file="../template/headerWithoutLeft.jsp"%>
	<div class="container-fluid all">
		<div class="maincontent row form-horizontal">
			<!--我是主要内容 start-->
			<ul class="breadcrumb">
				<li>注册</li>
			</ul>
			<div class="col-sm-12 col-md-10">
				<!--注册界面-->
				<div id="register" >
					<div class="well ">
						<!-- class都是bootstrap定义好的样式，验证是根据input中的name值 -->
						<form id="register-from" method="post" class="form-horizontal"
							action="/KMS/Account/Register">
							<!-- 下面这个div必须要有，插件根据这个进行添加提示 -->
							<div class="form-group input-group">
								<span class="input-group-addon"><i
									class="glyphicon glyphicon-user" aria-hidden="true"></i></span> <input
									id="register_username" class="form-control" name="username"
									type="text" placeholder="由字母或数字或汉字组成">
							</div>
							<div class="form-group input-group">

								<span class="input-group-addon"><i
									class="glyphicon glyphicon-lock"></i></span> <input
									class="form-control" id="register_password" name="password"
									type="password" placeholder="必须包含6-16位字母或数字">
							</div>
							<div class="form-group input-group">

								<span class="input-group-addon"><i
									class="glyphicon glyphicon-ok"></i></span> <input class="form-control"
									id="register_confirm_password" name="confirm_password"
									type="password" placeholder="再次输入密码验证">
							</div>
							<div class="form-group input-group">

								<span class="input-group-addon"><i
									class="glyphicon glyphicon-phone"></i></span> <input
									class="form-control" id="register_phone" name="phone"
									type="text" placeholder="请输入11位手机号码">
							</div>
							<div class="form-group input-group">

								<span class="input-group-addon"><i
									class="glyphicon glyphicon-envelope"></i></span> <input
									class=" form-control " id="register_identifyCode"
									 name="identifyCode" type="text"
									placeholder="请输入验证码"> <input type="button"
									id="querySecurityCodeBtn" class="btn" 
									value=" 获取验证码" />
							</div>
					<!--	宽度变化
					<script type="text/javascript">
							var precent=($('#querySecurityCodeBtn').width()+$('#querySecurityCodeBtn').prev().prev().width())
							/$('#querySecurityCodeBtn').parent().width();
							$("#register_identifyCode").width((1-precent-0.02)*100+"%");
							</script>-->
							<div class="text-right">
								<input type="button" id="registerBtn" class="btn btn-primary"
									value="注册"> <input type="button"
									class="btn btn btn-danger" onclick=" layer.closeAll('page'); "
									value="取消">
							</div>

							<a class="a_login" href="/KMS/Account/Login">已有账号？点我登录</a>
						</form>
					</div>
				</div>
			</div>
			<!--我是主要内容 end-->
		</div>
	</div>
	<%@ include file="../template/footer_tool.jsp"%>
	<%@ include file="../template/footer.jsp"%>
	
<!--基于bootstrap的表单验证插件-->
<script src="/KMS/JS/bootstrapValidator.min.js" type="text/javascript"></script>

<!--注册的js代码-->
<script src="/KMS/JS/account/register.js" type="text/javascript"></script>
</body>
</html>
