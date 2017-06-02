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


</head>
<body>
		<%@ include file="../template/headerWithLeft.jsp"%>
	<div class="container-fluid all">
			<%@ include file="../template/left.jsp"%>
		<div class="maincontent row form-horizontal">
			<!--我是主要内容 start-->
			<ul class="breadcrumb">
				<li class="active">首页</li>
			</ul>
			<div class="col-sm-12">
				<div id="main" >
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
	<%@ include file="../template/footer_tool.jsp"%>
	<%@ include file="../template/footer.jsp"%>
	<!--主要写的js代码关于Ajax的-->
<script src="/KMS/JS/account/userinfocenter.js" type="text/javascript"></script>
</body>
</html>
