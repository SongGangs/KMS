<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>Kindergarten Manage System</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css" href="/KMS/CSS/account.css">

</head>

<body>
	<%@ include file="../header.jsp"%>

	<div id="main">
		<h2>登陆</h2>
		<p>
			Please enter your user name and password. <a
				href="/KMS/Account/Register">Register</a> if you don't have an
			account.
		</p>
		<form name='longin_f' action='/OurMarkets/j_spring_security_check' method='POST'>
			<div>
				<fieldset>
					<legend>Account Information</legend>
					<div class="label">UserName:</div>
					<div class="txt">
						<input type='text' name="j_username" value='' />
					</div>

					<div class="label">Password:</div>
					<div class="txt">
						<input type='password' name='j_password' />
					</div>
					<p>
						<input name="submit" type="submit" value="Login" />
					</p>
				</fieldset>
			</div>
		</form>
	</div>
	<%@ include file="../footer.jsp"%>
</body>
</html>
