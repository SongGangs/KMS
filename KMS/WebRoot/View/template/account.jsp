<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>Kindergarten Manage System</title>

<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<style>
.displayDiv {
	display: none;
}
</style>
</head>

<body>
	<!-- 	登录界面 -->
	<div id="login" class="displayDiv">
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
	<!--注册界面-->
	<div id="register" class="displayDiv">
		<div class="well " ng-app="registerApp" ng-controller="registerCtrl">
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
						class="glyphicon glyphicon-lock"></i></span> <input class="form-control"
						id="register_password" name="password" type="password"
						placeholder="必须包含6-16位字母或数字">
				</div>
				<div class="form-group input-group">

					<span class="input-group-addon"><i
						class="glyphicon glyphicon-ok"></i></span> <input class="form-control"
						id="register_confirm_password" name="confirm_password"
						type="password" placeholder="再次输入密码验证">
				</div>
				<div class="form-group input-group">

					<span class="input-group-addon"><i
						class="glyphicon glyphicon-phone"></i></span> <input class="form-control"
						id="register_phone" name="phone" type="text"
						placeholder="请输入11位手机号码">
				</div>
				<div class="form-group input-group">

					<span class="input-group-addon"><i
						class="glyphicon glyphicon-envelope"></i></span> <input
						class=" form-control " id="register_identifyCode"
						name="identifyCode" type="text" placeholder="请输入验证码"> <input
						type="button" id="querySecurityCodeBtn" class="btn" value=" 获取验证码" />
				</div>

				<div class="form-group input-group">
					<span class="input-group-addon"><i
						class="glyphicon glyphicon-th-list"></i></span> <select
						class="selectpicker show-tick form-control" data-style="btn-info"
						ng-model='UCselected'
						ng-options='x.UserCatalogName for x in usercatalog'>
					</select> <span id='UserCatalogselected' ng-bind='UCselected.UserCatalogID'
						style='display: none'></span>
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
		<script>
			var app = angular.module('registerApp', []);
			app.controller('registerCtrl', function($scope, $http) {
				$http({
					method : 'GET',
					url : 'http://123.206.187.120/SG/KMS/queryUserCatalog.php'
				}).then(function successCallback(response) {
					$scope.usercatalog = response.data.usercatalog;
				}, function errorCallback(response) {
					$scope.usercatalog = '';
				});
			});
			angular.bootstrap($('#well'), [ 'registerApp' ]);
		</script>
	</div>

</body>
</html>
