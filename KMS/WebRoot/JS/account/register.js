/**
 * 宋刚 2017/06/01
 * register验证及js事件
 */
$(function() {
	/**
	      * 下面是进行插件初始化
	      * 你只需传入相应的键值对
	      * 
	      */

	var code=0;
	$("#showRegisterLayerBtn").on("click", function() {
		showRegisterLayer();
	});
	
	//这里使用bootstrapValidator
	var validator_register = $("#register-from").bootstrapValidator({
		message : 'This value is not valid',
		feedbackIcons : { /*输入框不同状态，显示图片的样式*/
			valid : 'glyphicon glyphicon-ok',
			invalid : 'glyphicon glyphicon-remove',
			validating : 'glyphicon glyphicon-refresh'
		},
		fields : { /*验证*/
			username : { /*键名username和input name值对应*/
				validators : {
					notEmpty : { /*非空提示*/
						message : '用户名不能为空'
					},
					//						stringLength : {
					//							min : 4,
					//							max : 30,
					//							message : '用户名长度必须在4到30之间'
					//						},
					threshold : 4, //有4字符以上才发送ajax请求，（input中输入一个字符，插件会向服务器发送一次，设置限制，4字符以上才开始）
					remote : { //ajax验证。server result:{"valid",true or false} 向服务发送当前input name值，获得一个json数据。例表示正确：{"valid",true}  
						url : '/KMS/API/Account/CheckuNickNameIsExist', //验证地址
						message : '用户已存在', //提示消息
						delay : 2000, //每输入一个字符，就发ajax请求，服务器压力还是太大，设置2秒发送一次ajax（默认输入一个字符，提交一次，服务器压力太大）
						type : 'POST', //请求方式
						/**自定义提交数据，默认值提交当前input value*/
						data : {
							uNickName : function() {
								return $.trim($("#register_username").val());
							}
						}
					}
				}
			},
			password : {
				validators : {
					notEmpty : {
						message : '密码不能为空'
					},
					stringLength : { /*长度提示*/
						min : 6,
						max : 16,
						message : '请输入长度为6-16个字符'
					},
					regexp : {
						regexp : /[A-Za-z].*[0-9]|[0-9].*[A-Za-z]/, //必须包含字母和数字的正则表达式
						message : '必须包含字母和数字 '
					}
				}
			},
			confirm_password : {
				validators : {
					notEmpty : {
						message : '请再次输入密码'
					},
					identical : {
						field : "password",
						message : "两次密码必须一致"
					}
				}
			},
			phone : {
				validators : {
					notEmpty : {
						message : '手机号不能为空'
					},
					regexp : {
						regexp : /^1[3458]\d{9}$/,
						message : '手机号码不正确 '
					}
				}
			},
			identifyCode : {
				validators : {
					notEmpty : {
						message : '短信验证码不能为空'
					},
					stringLength : {
						min : 6,
						max : 6,
						message : '请输入正确长度的短信验证码'
					},
					numeric : {
						message : '短信验证码只能为数字'
					},
					threshold : 5,
					remote : {
						url : '/KMS/API/Message/CheckSecurityCode', //验证地址
						message : '短信验证码不正确', //提示消息
						delay : 2000, //每输入一个字符，就发ajax请求，服务器压力还是太大，设置2秒发送一次ajax（默认输入一个字符，提交一次，服务器压力太大）
						type : 'POST', //请求方式
						data : {
							securityCode : function() {
								return $.trim($("#register_identifyCode").val());
							}
						}
					}
				}
			}
		}
	});
	function showRegisterLayer() {
		layer.closeAll('page');
		layer.open({
			type : 1, //Page层类型
			// area: ['500px', '405px'],
			title : '注册',
			shade : 0.6, //遮罩透明度
			anim : 1, //0-6的动画形式，-1不开启
			content : $("#register"),

			end : function() { //重置validate的验证提示
				$("#register_username").val("");
				$("#register_password").val("");
				$("#register_confirm_password").val("");
				$("#register_phone").val("");
				$("#register_identifyCode").val("");
				$("#register-from").data('bootstrapValidator').resetForm(true); //重置表单
			}
		});
	}
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

	$("#querySecurityCodeBtn").on("click", function() {
		$.post("/KMS/API/Message/SendSecurityCode", {
			phoneNumber : $("#register_phone").val()
		}, function(data) {
			if (data.msg == "success") {
				code=data.code;
				layer.msg('短信验证码已发送', {
					icon : 1,
					time : 1000
				});
				settime($("#querySecurityCodeBtn"));
			//$("#querySecurityCodeBtn").attr("disabled", true);
			} else {
				layer.msg('短信验证码发送失败', {
					icon : 5,
					time : 1000
				});
			}
		});
	});

	//输入孩子姓名时 异步请求数据库返回孩子信息
	/*$("#register_family").bind("input propertychange", function() {
		if($.trim($(this).val())!=""){
		$.get("http://123.206.187.120/SG/queryChildInfoByName.php?name=" + $.trim($(this).val()),
			function(data) {
				alert(data.childinfo[0].ChildName);
			});
		}
	});*/



	//点击注册按钮
	$("#registerBtn").on("click", function() {
		var familyID = $("#Familyselected").text();
		var usercatalogID = $("#UserCatalogselected").text();
	/*
	if ($("#register-from").valid()) {
		//如果验证成功
		$.post("/KMS/API/Account/AddUser",
			{
			userName : $.trim($("#register_username").val()),
			password : $("#register_password").val(),
			phoneNumber : $("#register_phone").val(),
			usercatalogID : 1,
			familyID : 1
			},
			function(data) {
				if (data.msg == "success") {
					layer.msg('用户注册成功', {
						icon : 1,
						time : 1000
					});
					layer.closeAll('page');
				} else {
					layer.msg('用户注册失败', {
						icon : 5,
						time : 1000
					});
				}
			});
	}*/
	});

});