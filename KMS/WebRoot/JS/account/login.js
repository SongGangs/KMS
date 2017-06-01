/**
 * 宋刚 2017/06/01
 * login验证及js事件
 */
$(function() {
	/**
	      * 下面是进行插件初始化
	      * 你只需传入相应的键值对
	      * 
	      */
	//登陆表单
	//让当前表单调用validate方法，实现表单验证功能
	//这里使用jQuery .validate
	var validator_login = $("#login-from").validate({
		onkeyup : null, //当丢失焦点时才触发验证请求
		rules : {
			//配置验证规则，key就是被验证的dom对象，value就是调用验证的方法(也是json格式)
			j_username : {
				required : true //必填。如果验证方法不需要参数，则配置为true
			},
			j_password : {
				required : true,
				rangelength : [ 6, 16 ]
			}
		},
		messages : {
			j_username : {
				required : "请输入用户名"
			},
			j_password : {
				required : "请输入密码",
				rangelength : $.validator.format("密码长度为{0}-{1}个字符")
			}
		}
	});
	$(".a_login").on("click", function() {
		layer.closeAll('page');
		layer.open({
			type : 1, //此处以iframe举例
			id : 'Layer_Login', //设定一个id，防止重复弹出
			//area: ['500px', '320px'],
			title : '登陆',
			shade : 0.6, //遮罩透明度
			anim : 1, //0-6的动画形式，-1不开启
			content : $("#login"),
			end : function() { //重置validate的验证提示
				$("#login_username").val("");
				$("#login_password").val("");
				validator_login.resetForm(); //重置表单
			}
		});
		AutoFillCookie(); //查看Cookie记录里面是否有保存信息 有就自动填充
	});
	$("#loginBtn").on("click", function() {
		$("#login-from").submit();
		/*if ($("#login-from").valid()) {
			//如果验证成功
			$.post("/KMS/API/Account/Login"
				, {
					uNickName : $.trim($("#login_username").val()),
					uPassword : $('#login_password').val()
				}
				, function(data) {
					if (data.msg == "success") {
						layer.msg('身份验证通过', {
							icon : 1,
							time : 1000
						});
						layer.closeAll('page');
						//如果记住账户密码被选中 就将登录信息存到Cookie中
						if ($("#login_rememberme").is(':checked')) {
							CookieUserInfo();
						}else{
							ClearCookie();
						}
						$("#login-from").submit();
					} else {
						layer.msg('身份验证失败', {
							icon : 5,
							time : 1000
						});
					}
				});
		}*/
	});

	//初始化页面时验证是否记住了密码 
	function AutoFillCookie() {
		//当用户名和密码都不为null 并且也不为undefined时进行调用
		if ($.cookie("username") != undefined && $.cookie("password") != undefined) {
			$("#login_username").val($.cookie("username"));
			$("#login_password").val($.cookie("password"));
			$("#login_rememberme").attr('checked', 'true');
		}
	}
	//Cookie用户登录信息
	function CookieUserInfo() {
		$.cookie("username", $.trim($("#login_username").val()), {
			expires : 7
		}); // 存储一个带7天期限的 cookie   
		$.cookie("password", $("#login_password").val(), {
			expires : 7
		}); // 存储一个带7天期限的 cookie   
	}
	//清楚用户信息
	function ClearCookie() {
		$.cookie('username', '', { expires: -1 });
		$.cookie('password', '', { expires: -1 });
	}

});