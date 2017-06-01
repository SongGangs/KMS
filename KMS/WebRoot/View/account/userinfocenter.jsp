<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<!--主要写的js代码关于Ajax的-->
<script src="/KMS/JS/account/userinfocenter.js" type="text/javascript"></script>
<!-- <link rel="stylesheet" type="text/css" href="/KMS/CSS/account/userinfocenter.css"> -->

</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle show pull-left"
				data-target="sidebar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span><span class="icon-bar"></span><span
					class="icon-bar"></span>
			</button>
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span><span class="icon-bar"></span><span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="index.html">Bootstrap</a>
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
		<div class="sidebar">
			<ul class="nav">
				<li><a href="#">主页面</a></li>
				<li><a href="#">Form库</a></li>
				<li><a href="#">Message库</a></li>
				<li><a href="#">UI库</a></li>
				<li><a href="#">Animate库</a></li>
				<li><a href="#">Carousel库</a></li>
				<li><a href="#">Chart库</a></li>
				<li class="has-sub"><a href="javascript:void(0);"><span>导航选中演示</span><i
						class="fa fa-caret-right fa-fw pull-right"></i></a>
					<ul class="sub-menu">
						<li><a href="#"><i class="fa fa-circle-o fa-fw"></i>&nbsp;left1</a></li>
						<li><a href="#"><i class="fa fa-circle-o fa-fw"></i>&nbsp;left2</a></li>
						<li><a href="#"><i class="fa fa-circle-o fa-fw"></i>&nbsp;left3</a></li>
					</ul></li>
			</ul>
		</div>
		<div class="maincontent row">
			<!--我是主要内容 start-->
			<ul class="breadcrumb">
				<li class="active">首页</li>
			</ul>
			<div class="col-sm-12">
				<div id="main">
					<dl>
						<dt>下面是个人信息展示</dt>
						<dd>
							如需修改点击<strong><a>这里</a></strong>
						</dd>
					</dl>

					<fieldset>
						<legend>User Information Center</legend>

						<div id="imgcontain">
							<div class="imageDisplay">
								<img alt="用户头像" src="${viewmodel.getUserinfo().getImage()}" />
							</div>
							<div class="imageChange">
								<input type="button" value="更换" />
							</div>
						</div>
						<div class="contain">
							<div class="filed">
								<label for="username">用户名称：</label>
							</div>
							<div class="txt">
								<input type="text" id="username" name="username"
									value="${viewmodel.getUserinfo().getUserName()}" />
							</div>
						</div>
						<div class="contain">
							<div class="filed">
								<label for="gender">用户性别：</label>
							</div>
							<div class="txt">
								<input type="text" id="gender" name="gender"
									value="<c:if test="${viewmodel.getUserinfo().getGender()=='1'}">女</c:if><c:if test="${viewmodel.getUserinfo().getGender()=='0'}">男</c:if>" />
							</div>
						</div>

						<div class="contain">
							<div class="filed">
								<label for="registerTime">注册时间：</label>
							</div>
							<div class="txt">
								<input type="text" id="registerTime" name="registerTime"
									value="${viewmodel.getUserinfo().getRegisterTime()}" />
							</div>
						</div>
						<div class="contain">
							<div class="filed">
								<label for="phoneNumber">联系方式：</label>
							</div>
							<div class="txt">
								<input type="text" id="phoneNumber" name="phoneNumber"
									value="${viewmodel.getUserinfo().getPhoneNumber()}" />
							</div>
						</div>
						<div class="contain">
							<div class="filed">
								<label for="usercatalogname">用户种类：</label>
							</div>
							<div class="txt">
								<input type="text" id="usercatalogname" name="usercatalogname"
									value="${viewmodel.getUserinfo().getUsercatalog().getUserCatalogName()}" />
							</div>
						</div>
						<div class="filed">
							<label for="useraddress">用户地址：</label>
						</div>
						<div class="useraddresstxt">
							<c:forEach items="${viewmodel.getAddressinfos()}" var="item">
								<input type="text" class="useraddress" name="useraddress"
									value="${item.getAddressName()}" />
								<a href="#" data-id="${item.getAddressRecId()}"
									class="delectaddress">删除</a>
							</c:forEach>
							<input type="text" class="useraddress" name="useraddress"
								value="${item.getAddressName()}" /> <a href="#" id="addaddress"
								data-id="${viewmodel.getUserinfo().getUserRecId()}"
								class="addaddress">添加</a>
						</div>
						<div id="familymembers">
							<fieldset>
								<legend>家庭成员</legend>
								<table>
									<tr>
										<th>家庭识别码</th>
										<th>家庭名称</th>
										<th>家庭身份</th>
										<th>姓名</th>
										<th></th>
										<th></th>
									</tr>
									<c:forEach items="${viewmodel.getUserinfolist()}" var="item">
										<tr>
											<td>${viewmodel.getUserinfo().getFamily().getFamilyId()}</td>
											<td>${viewmodel.getUserinfo().getFamily().getFamilyName()}</td>
											<td>${item.getIdentity()}</td>
											<td>${item.getUserName()}</td>
										</tr>
									</c:forEach>
								</table>
							</fieldset>
						</div>
					</fieldset>
				</div>
			</div>
			<!--我是主要内容 end-->
		</div>
	</div>
	<a href="#top" id="goTop"><i class="fa fa-angle-up fa-3x"></i></a>
	<a href="#"> <img class="forkme"
		src="/KMS/resources/forkme.png" alt="Fork me on GitHub">
	</a>
	<%@ include file="../footer.jsp"%>
</body>
</html>
