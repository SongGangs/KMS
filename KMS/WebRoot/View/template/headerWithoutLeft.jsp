<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="icon" href="favicon.ico" />
<!--jquery库-->
<script src="/KMS/JS/jquery.min.js"></script>
<!--bootstrap库-->
<link href="/KMS/CSS/bootstrap.min.css" rel="stylesheet" />
<script src="/KMS/JS/bootstrap/bootstrap.min.js"></script>
<!--layer库-->
<link href="/KMS/CSS/layer/skin/default/layer.css" rel="stylesheet" />
<script src="/KMS/CSS/layer/layer.js"></script>
<!--angularJS库-->
<script src="/KMS/JS/angular.min.js"></script>
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
			<!--                 隔位符 -->
			<a class="navbar-brand" href="javascript:;"></a>
			 <a class="navbar-brand" href="javascript:;"></a>
			<a class="navbar-brand" href="/KMS">KMS</a>
		</div>
		<div id="navbar" class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li><a href="JavaScript:;">top1.html</a></li>
				<li><a href="JavaScript:;">top2.html</a></li>
				<li><a href="JavaScript:;">top3.html</a></li>
				<li><a href="https://github.com/shihao316558512/bootstrap"
					target="_blank"><i class="fa fa-download fa-fw"></i>&nbsp;原码下载</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<!-- 不具有 Admin,User的权限则显示登录链接-->
				<security:authorize ifNotGranted="ROLE_USER,ROLE_ADMIN">
					<li><a href="/KMS/Account/Login"><i
							class="fa fa-user fa-fw"></i>&nbsp;Log In</a></li>
				</security:authorize>
				<!-- 如果已经授权则显示退出链接 -->
				<security:authorize access="isAuthenticated()">
					<li ng-app="myApp" ng-controller="userCtrl" class="dropdown"><a
						href="#" class="dropdown-toggle" data-toggle="dropdown"
						role="button" aria-expanded="false"><i
							class="fa fa-user fa-fw"></i>&nbsp;<span id='username'><security:authentication
									property="principal.username"></security:authentication></span>&nbsp;<span
							class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href='{{href}}'>个人中心</a></li>
							<li class="divider"></li>
							<li><a href="/KMS/Account/LogOut"><i
									class="fa fa-sign-out fa-fw"></i>&nbsp;Log Out</a></li>
						</ul></li>
					<script>
						var app = angular.module('myApp', []);
						app.controller('userCtrl', function($scope, $http) {
							$http({
								method : 'GET',
								url : 'http://123.206.187.120/SG/queryIdFormName.php?name=' + $('#username').text()
							}).then(function successCallback(response) {
								$scope.href = '/KMS/Account/UserInfoCenter?UserRecID=' + response.data.userinfo[0].UserRecID;
							}, function errorCallback(response) {
								$scope.href = 'JavaScript:;';
							});
						});
					</script>
				</security:authorize>
			</ul>
		</div>
	</div>
	</nav>

</body>
</html>

