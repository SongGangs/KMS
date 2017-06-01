<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>Kindergarten Manage System</title>

<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="icon" href="favicon.ico" />
<!--jquery库-->
<script src="/KMS/JS/jquery.min.js"></script>
<!--bootstrap库-->
<link href="/KMS/CSS/bootstrap.min.css" rel="stylesheet" />
<script src="/KMS/JS/bootstrap/bootstrap.min.js"></script>
<!--[if lt IE 9]>
      <script src="js/bootstrap/html5shiv.min.js"></script>
      <script src="js/bootstrap/respond.min.js"></script>
    <![endif]-->
<!--font-awesome字体库-->
<link href="/KMS/CSS/font-awesome.min.css" rel="stylesheet" />
<!--页面加载进度条-->
<link href="/KMS/CSS/pace/dataurl.css" rel="stylesheet" />
<script src="/KMS/JS/pace/pace.min.js"></script>
<!--jquery.hammer手势插件-->
<script src="/KMS/JS/jquery.hammer/hammer.min.js"></script>
<script src="/KMS/JS/jquery.hammer/jquery.hammer.js"></script>
<!--平滑滚动到顶部库-->
<script src="/KMS/JS/jquery.scrolltopcontrol/scrolltopcontrol.js"
	type="text/javascript"></script>
<!--主要写的jquery拓展方法-->
<script src="/KMS/JS/jquery.extend.js" type="text/javascript"></script>
<!--主要写的css代码-->
<link href="/KMS/CSS/default.css" rel="stylesheet" type="text/css" />
<!--主要写的js代码-->
<script src="/KMS/JS/default.js" type="text/javascript"></script>
<!--基于bootstrap的表单验证插件-->
<script src="/KMS/JS/bootstrapValidator.min.js" type="text/javascript"></script>
<!--登陆注册通用的基本样式-->
<link href="/KMS/CSS/account/account.css" rel="stylesheet"
	type="text/css" />
<!--登陆的js代码-->
<script src="/KMS/JS/account/register.js" type="text/javascript"></script>

</head>

<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
		
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span><span class="icon-bar"></span><span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="javascript:;"></a>
			<a class="navbar-brand" href="javascript:;"></a>
			<a class="navbar-brand" href="#">Bootstrap</a>
		</div>
		<div id="navbar" class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li><a href="/KMS/Dynamic/Index">动态</a></li>
				<li><a href="/KMS/View/home/index.html">商城</a></li>
				<li><a href="/KMS/Home/Index">首页</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-expanded="false"><i
						class="fa fa-user fa-fw"></i>&nbsp;小王&nbsp;<span class="caret"></span></a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="#">top-right1.html</a></li>
						<li class="divider"></li>
						<li><a href="#">top-right2.html</a></li>
						<li class="divider"></li>
						<li><a href="#"><i class="fa fa-sign-out fa-fw"></i>&nbsp;退出</a></li>
					</ul></li>
			</ul>
		</div>
	</div>
	</nav>
	<div class="container-fluid all">
		<div class="maincontent row">
			<!--我是主要内容 start-->
			<ul class="breadcrumb">
				<li>注册</li>
			</ul>
			<div class="col-sm-12 col-md-10">
				<!--注册界面-->
				<div id="register" class="row">
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
									style="width: 190px" name="identifyCode" type="text"
									placeholder="请输入验证码"> <input type="button"
									id="querySecurityCodeBtn" class="btn" style="margin-left: 10px"
									value=" 获取验证码" />
							</div>

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
	<a href="#top" id="goTop"><i class="fa fa-angle-up fa-3x"></i></a>
	<a href="#"> <img class="forkme" src="/KMS/resources/forkme.png"
		alt="Fork me on GitHub">
	</a>
<%-- 	<%@ include file="../footer.jsp"%> --%>
</body>
</html>
