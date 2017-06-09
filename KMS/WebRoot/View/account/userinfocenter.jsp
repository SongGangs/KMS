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
<!--jQuery下拉列表插件bootstrap-select基本样式-->
<link href="/KMS/CSS/bootstrap-select.min.css" rel="stylesheet"
	type="text/css" />
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
				<div id="main">
					<dl>
						<dt>下面是个人信息展示</dt>
						<dd>
							如需修改点击<strong><a id="editlink" style="cursor: pointer;">这里</a></strong>
						</dd>
					</dl>

					<fieldset>
						<legend>User Information Center</legend>
						<div class="text-center">
							<img class="img-circle" style="width: 120px;height: 120px;"
								src="${viewmodel.getUserinfo().getImage()}" alt="用户头像"> <br>
							<button class="btn" id="changeHeadImg">选择头像</button>
							<!-- 给这个input 设置样式隐藏，切忌不可用display控制隐藏,可能不能跨浏览器 -->
							<input type="file" id="file"
								accept="image/png,image/jpg,image/jpeg,image/gif,image/bmp"
								style="filter:alpha(opacity=0);opacity:0;width: 0;height: 0;"
								data-rootPath="${viewmodel.getRootPath()}" />
						</div>
						<!--图片预览区 -->
						<div id="image_thumb" style="display: none">
							<div class="text-center">
								<img id="image_thumb_img" class="img-circle"
									style="width: 150px;height: 150px;" alt="用户头像">
							</div>
						</div>


						<br>
						<div class="form-group">
							<label class="col-sm-2 control-label">用户昵称</label>
							<div class="col-sm-10">
								<input class="form-control " type="text" id="username"
									name="username"
									value="${viewmodel.getUserinfo().getUserName()}" disabled>
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-2 control-label">注册时间</label>
							<div class="col-sm-10">
								<input class="form-control" type="text" id="registerTime"
									name="registerTime"
									value="${viewmodel.getUserinfo().getRegisterTime()}" disabled>
							</div>
						</div>
						<div class="form-group">
							<label for="usercatalogname" class="col-sm-2 control-label">用户身份</label>
							<div class="col-sm-10">
								<input class="form-control" type="text" id="usercatalogname"
									name="usercatalogname"
									value="${viewmodel.getUserinfo().getUsercatalog().getUserCatalogName()}"
									disabled>
							</div>
						</div>
						<div class="form-group">
							<label for="gender" class="col-sm-2 control-label">用户性别</label>
							<div class="col-sm-10">
								<select class="selectpicker show-tick form-control" id="gender"
									data-style="btn-info">
									<option value="-1">请选择</option>
									<option value="0"
										<c:if test="${viewmodel.getUserinfo().getGender()=='0'}">selected = "selected"</c:if>>男</option>
									<option value="1"
										<c:if test="${viewmodel.getUserinfo().getGender()=='1'}">selected = "selected"</c:if>>女</option>
								</select>
								<!-- <input class="form-control" type="text" id="gender"
									name="gender" 
									value="<c:if test="${viewmodel.getUserinfo().getGender()=='1'}">女</c:if><c:if test="${viewmodel.getUserinfo().getGender()=='0'}">男</c:if>">  -->
							</div>
						</div>
						<c:if test="${viewmodel.getUserinfolist().size()==0}">
							<div class="form-group ">
								<label for="family" class="col-sm-2 control-label">选择家庭</label>
								<div class="col-sm-10">
									<div class="input-group">
										<input class="form-control" id="family" name="family"
											type="text" placeholder="请输入你孩子的姓名">
										<div class="input-group-btn">
											<button type="button" class="btn btn-default dropdown-toggle"
												data-toggle="dropdown">
												<span class="caret"></span>
											</button>
											<ul class="dropdown-menu dropdown-menu-right" role="menu">
											</ul>
										</div>
									</div>
								</div>
							</div>

						</c:if>
						<div class="form-group ">
							<label for="phoneNumber" class="col-sm-2 control-label">联系方式</label>
							<div class="col-sm-10">
								<input class="form-control" type="text" id="phoneNumber"
									name="phoneNumber"
									value="${viewmodel.getUserinfo().getPhoneNumber()}">
							</div>
						</div>
						<div class="form-group form-inline">
							<label for="phoneNumber" class="col-sm-2 control-label">短信验证码</label>
							<div class="col-sm-10">
								<input class="form-control" type="text" id="identifyCode"
									name="identifyCode" placeholder="请输入验证码" disabled> <input
									type="button" id="querySecurityCodeBtn" class="btn"
									value=" 获取验证码" />
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-2 control-label">用户地址</label>
							<div class="col-sm-10">
								<c:forEach items="${viewmodel.getAddressinfos()}" var="item">
									<div class="form-inline">
										<input type="text" class="form-control" name="useraddress"
											value="${item.getAddressName()}" disabled /> <a href="#"
											data-id="${item.getAddressRecId()}" class="delectaddress">删除</a>
									</div>
								</c:forEach>
								<div class="form-inline">
									<input type="text" class="form-control" name="useraddress"
										value="${item.getAddressName()}" /> <a href="#"
										id="addaddress"
										data-id="${viewmodel.getUserinfo().getUserRecId()}"
										class="addaddress">添加</a>
								</div>
							</div>
						</div>
						<div class="text-center">
							<input type="button" id="saveBtn" class="btn btn-primary"
								value="保存修改"> <input type="button"
								class="btn  btn-danger" onclick="  " value="重置">
						</div>
						<c:if test="${viewmodel.getUserinfolist().size()>0}">
							<fieldset>
								<legend>家庭介绍</legend>



								<table class="table">
									<thead>
										<tr>
											<th>家庭识别码</th>
											<th>家庭名称</th>
											<th>家庭身份</th>
											<th>姓名</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${viewmodel.getUserinfolist()}" var="item">
											<tr style="{{$even?'background-color: #f1f1f1':''}}">
												<td>${item.getFamily().getFamilyId()}</td>
												<td>${item.getFamily().getFamilyName()}</td>
												<td>${item.getIdentity()}</td>
												<td>${item.getUserName()}</td>
											</tr>
										</c:forEach>
										<c:forEach items="${viewmodel.getChildinfolist()}"
											var="childitem">
											<tr style="{{$even?'background-color: #f1f1f1':''}}">
												<td>${childitem.getFamily().getFamilyId()}</td>
												<td>${childitem.getFamily().getFamilyName()}</td>
												<td>孩子</td>
												<td>${childitem.getChildName()}</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>

							</fieldset>
						</c:if>

					</fieldset>
				</div>

				<%@ include file="../template/footer.jsp"%>
			</div>
			<!--我是主要内容 end-->
		</div>
	</div>
	<%@ include file="../template/footer_tool.jsp"%>

	<!--jQuery下拉列表插件bootstrap-select-->
	<script src="/KMS/JS/bootstrap-select/bootstrap-select.js"
		type="text/javascript"></script>
	<!--bootstrap combox 搜索建议插件-->
	<script src="/KMS/JS/bootstrap-suggest.min.js" type="text/javascript"></script>
	<!--主要写的js代码关于Ajax的-->
	<script src="/KMS/JS/account/userinfocenter.js" type="text/javascript"></script>
</body>
</html>
