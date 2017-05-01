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
		<h2>Create a New Account</h2>
		<p>Use the form below to create a new account. </p>
			<form name='longin_f' action='/KMS/Account/Register'  method='POST'>
			 <div>
		       <fieldset>
					<legend>Account Information</legend>
					<div class="label">UserName:</div>
					<div class="txt">
						<input type='text' name='username' value='' />
					</div>

					<div class="label">Password:</div>
					<div class="txt">
						<input type='password' name='password' />
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
