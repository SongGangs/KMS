/**
 * 宋刚  2017/06/01
 * 用户个人中心的js文件
 */

$(function() {
	var code = 0;//短信验证码
	var status=false;//是否已发送
	var familyName="";//家庭名字
	$(document).on('click', '.delectaddress', function() {
		var _this = $(this);
		var _Addressid = $(this).data("id");
		if (typeof (_Addressid) != "undefined") {
			$.post("/KMS/API/Address/RemoveAddress",
				{
					id : _Addressid
				}, function(data) {
					if (data.msg == "success") {
						_this.prev().remove();
						_this.remove();
					} else if (data.msg == "error") {
						alert("error");
					}
				});
		}
	});
	$("#addaddress").click(function() {
		var txt = $(this).prev().val();
		var userid = $(this).data("id");
		var _this = $(this);
		if (txt != "") {
			$.post("/KMS/API/Address/AddAddress",
				{
					addressTxt : txt,
					userid : userid
				}, function(data) {
					if (data.msg == "success") {
						var id = data.id;
						var address = data.name;
						var html = "<input type='text' class='useraddress' name='useraddress' value='{address}' />" +
							"<a href='#' data-id='{id}' class='delectaddress'>删除</a>"
						var result = html.format({
							address : address,
							id : id
						});

						_this.prev().val("");
						_this.prev().before(result);
					} else if (data.msg == "error") {
						alert("error");
					}

				});
		}
	});

	$("#saveBtn").click(function() {
		if ((status == true && code == $("#identifyCode").val()) || (status == false)) {
			$.post("/KMS/API/Account/UpdateUserInfo", {
				userName:$("username").val(),
				phoneNumber : $("#phoneNumber").val(),
				gender : $("#gender").val(),
				family : familyName,
				childName:$("family").val()
			}, function(data) {
				if (data.msg == "success") {
					code = data.code;
					toastr.options = {
						"progressBar" : true
					}
					toastr.info('信息修改成功');
					settime($("#querySecurityCodeBtn"));
				} else {
					toastr.options = {
						"progressBar" : true
					}
					toastr.info('信息修改失败');
				}
			});
		} else {
			layer.msg('你输入的验证码不正确', {
				icon : 5,
				time : 1000
			});
		}
	});
	
	
	$("#family").onblur(function() {
		$.get("/KMS/API/ChildInfo/HasFamily", {
			childinfoID : $(this).val()
		}, function(data) {
			if (data.msg == "success") {
				familyName=data.familyName;
			} else {
				//默认prompt
				layer.prompt(function(val, index) {
					$.get("/KMS/API/Family/IsExist", {
						familyName : val
					}, function(data) {
						if (data.msg == "success") {
							familyName = val;
							toastr.options = {
								"progressBar" : true
							}
							toastr.info('恭喜你，' + val + ' 这个名字可以使用！');
							layer.close(index);
						} else {
							toastr.options = {
								"progressBar" : true
							}
							toastr.info('这个Family名字已经存在！');
						}
					});
				});
			}
		});
	});
	var countdown = 60;
	//60秒到计时
	function settime(obj) {
		if (countdown == 0) {
			obj.attr("disabled", false);
			obj.val("获取验证码");
			countdown = 60;
			return;
		} else {
			obj.attr("disabled", true);
			obj.val("重新发送(" + countdown + ")");
			countdown--;
		}
		setTimeout(function() {
			settime(obj)
		}, 1000)
	}
	$("#querySecurityCodeBtn").click(function() {
		$.post("/KMS/API/Message/SendSecurityCode", {
			phoneNumber : $("#phoneNumber").val()
		}, function(data) {
			if (data.msg == "success") {
				code = data.code;
				layer.msg('短信验证码已发送', {
					icon : 1,
					time : 1000
				});
				settime($("#querySecurityCodeBtn"));
			} else {
				layer.msg('短信验证码发送失败，请检查手机号是否更改', {
					icon : 5,
					time : 1000
				});
			}
		});
		$(this).prev().removeAttr("disabled");
	});
	/**
     * 测试(首次从 URL 获取数据，显示 header，不显示按钮，忽略大小写，可清除)
     */
	$("#family").bsSuggest({
		url : "http://123.206.187.120/SG/queryChildInfoByName.php?name=" + $.trim($(this).val()),
		/*effectiveFields: ["userName", "shortAccount"],
		searchFields: [ "shortAccount"],*/
		effectiveFieldsAlias : {
			ChildInfoID : "编号",
			ChildName : "姓名",
			Birthday : "生日",
			FamilyName : "家庭名"
		}, //showHeader 时，header 别名
		//ignorecase: true,//忽略大小写 
		showHeader : true,
		allowNoKeyword : false, //无输入时不执行过滤请求
		showBtn : false, //不显示下拉按钮
		delayUntilKeyup : true, //获取数据的方式为 firstByUrl 时，延迟到有输入/获取到焦点时才请求数据
		idField : "ChildInfoID",
		keyField : "ChildName",
		clearable : true
	}).on('onDataRequestSuccess', function(e, result) {
		console.log('onDataRequestSuccess: ', result);
	}).on('onSetSelectValue', function(e, keyword, data) {
		console.log('onSetSelectValue: ', keyword, data);
	}).on('onUnsetSelectValue', function() {
		console.log("onUnsetSelectValue");
	});


});