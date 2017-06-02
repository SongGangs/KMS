<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>Kindergarten Manage System</title>

<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="icon" href="favicon.ico" />
<!--登陆注册通用的基本样式-->
<link href="/KMS/CSS/account/account.css" rel="stylesheet" type="text/css" />
</head>

<body>
<%@ include file="../template/headerWithoutLeft.jsp"%>
<div class="container-fluid all">
		<div class="maincontent row form-horizontal">
			<!--我是主要内容 start-->
			<ul class="breadcrumb">
				<li>登陆</li>
			</ul>
			<div class="col-sm-12 col-md-10">
	<!--登陆界面-->
	<div id="login" >
		<div class="well">
			<form id="login-from" method="POST" class="form-horizontal"
				action='/KMS/j_spring_security_check'>
				<div class="input-group ">
					<span class="input-group-addon"><i
						class="glyphicon glyphicon-user"></i></span> <input id="login_username"
						type="text" name="j_username" class="form-control "
						placeholder="请输入用户名" />
				</div>
				<div class="input-group " style="margin-top:10px;">
					<span class="input-group-addon"><i
						class="glyphicon glyphicon-lock"></i></span> <input id="login_password"
						type="password" name="j_password" class="form-control "
						placeholder="请输入密码" />
				</div>
				<div class="checkbox  mycheckbox">
					<label><input id="login_rememberme" type="checkbox">记住密码</label>
				</div>
				<div class="text-right">
					<input type="button" id="loginBtn" class="btn btn-primary"
						value="登录"> <input type="button" class="btn btn-danger"
						onclick=" layer.closeAll('page'); " value="取消">
				</div>
				<a class="a_register" href="/KMS/Account/Register">还没有账号？点我注册</a>
			</form>
		</div>
	</div>
	</div>
			<!--我是主要内容 end-->
		</div>
	</div>
	<%@ include file="../template/footer_tool.jsp"%>
	<%@ include file="../template/footer.jsp"%>
	
<!--基于jQuery的cookie插件-->
<script src="/KMS/JS/jquery.cookie.js" type="text/javascript"></script>
<!--基于jQuery的表单验证-->
<script src="/KMS/JS/jquery.validate.min.js" type="text/javascript"></script>
<!--登陆的js代码-->
<script src="/KMS/JS/account/login.js" type="text/javascript"></script>
</body>
</html>
