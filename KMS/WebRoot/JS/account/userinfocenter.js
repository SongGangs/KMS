/**
 * 宋刚  2017/06/01
 * 用户个人中心的js文件
 */

$(function() {
	//加载层-默认风格
	layer.load();
	//此处演示关闭
	setTimeout(function() {
		layer.closeAll('loading');
	}, 2000);
	code = 0; //短信验证码
	status = false; //是否已发送
	familyName = ""; //家庭名字
	childinfoID = 0;
	phoneNumber = $("#phoneNumber").val();
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
						showToastr('地址删除成功。');
					} else {
						showToastr('地址删除失败。');
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
						var html = "<div class='form-inline'><input type='text' class='form-control' " +
								"name='useraddress' value='{address}' disabled /> " +
								"<a href='#' data-id='{id}' class='delectaddress'>删除</a></div>"
						var result = html.format({
							address : address,
							id : id
						});

						_this.prev().val("");
						_this.prev().before(result);
						showToastr('地址添加成功。');
					} else  {
						showToastr('地址添加失败。');
					}

				});
		}
	});

	$("#saveBtn").click(function() {
		if ($("#gender").val() < 0) {
			showToastr('请选择性别');
			return;
		}
		if ((status == "true" && code == $("#identifyCode").val() && phoneNumber != $("#phoneNumber").val()) || (status == "false" && phoneNumber == $("#phoneNumber").val())) {
			$.post("/KMS/API/Account/UpdateUserInfo", {
				userName : $("#username").text(),
				phoneNumber : $("#phoneNumber").val(),
				gender : $("#gender").val(),
				familyName : familyName,
				childinfoID : childinfoID
			}, function(data) {
				if (data.msg == "success") {
					code = data.code;
					showToastr('信息修改成功');
					settime($("#querySecurityCodeBtn"));
				} else {
					showToastr('信息修改失败');
				}
			});
		} else {
			layer.msg('你输入的验证码不正确', {
				icon : 5,
				time : 1000
			});
		}
	});
	/*
	 $("#family").blur(function(){
		 $.post("/KMS/API/ChildInfo/HasFamily", {
				childinfoID : $(this).val()
			}, function(data) {
				if (data.msg == "success") {
					familyName=data.familyName;
				} else {
					//默认prompt
					layer.prompt(function(val, index) {
						$.post("/KMS/API/Family/IsExist", {
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
	 */
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
				status = "true";
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
		url : "http://123.206.187.120/SG/KMS/queryChildInfoByName.php?name=" + $.trim($(this).val()),
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
		childinfoID = data.ChildInfoID;
		if (data.FamilyName != null) {
			familyName = data.FamilyName;
		} else {
			//默认prompt
			layer.prompt(function(val, index) {
				$.post("/KMS/API/Family/IsExist", {
					familyName : val
				}, function(data) {
					if (data.msg == "success") {
						familyName = val;
						showToastr('恭喜你，' + val + ' 这个名字可以使用！');
						layer.close(index);
					} else {
						showToastr('这个Family名字已经存在！');
					}
				});
			});
		}
	}).on('onUnsetSelectValue', function() {
		console.log("onUnsetSelectValue");
	});


	$("#file").change(function() {
		var rootPath = $(this).attr("data-rootPath").replace(/\\/g, '\\\\');
		var filetype = [ 'jpg', 'jpeg', 'png', 'gif' ];
		if (this.files[0]) {
			fi = this.files[0]; //得到文件信息
			//图片不得超过2M
			if (fi.size > 2097152) {
				showToastr('图片不得超过2M');
				return;
			}
			//判断文件格式是否是图片 如果不是图片则返回false
			var fname = fi.name.split('.');
			if (filetype.indexOf(fname[1].toLowerCase()) == -1) {
				showToastr('文件格式不支持');
				return;
			}

			//实例化h5的fileReader
			var fr = new FileReader();
			fr.readAsDataURL(fi); //以base64编码格式读取图片文件
			fr.onload = function(frev) {
				pic = frev.target.result; //得到结果数据
				//开始上传之前，预览图片
				$('#image_thumb_img').attr('src', pic);
				showLayer(pic, fname, fi, rootPath);
			}
		}
	});

	//跟换头像
	$("#changeHeadImg").click(function() {
		//触发 文件选择的click事件  
		$("#file").trigger("click");
	});
	//使用ajax 利用post方式提交数据
	//这是java将js传来的base64编码格式读取图片文件 解码存储
	function uploadImg(pic, fname) {
		var userName = $("#username").text();
		$.post('/KMS/API/File/Upload',
			{
				message : pic,
				filename : userName,
				imgType : fname[1]
			},
			function(data) {
				if (data.msg == "success") {
					showToastr('上传成功');
					//把图中的头像也更改了
					$("#changeHeadImg").siblings("img").attr('src', pic);
					//更新到数据库
					ChangeHeaderImgSrc(userName,  fname[1]);
				} else {
					showToastr('上传失败');
				}
			});
	}
	/*
	//这是php将js传来的base64编码格式读取图片文件 解码存储
	function uploadImg(pic, fname, fi, rootPath) {
		var userName = $("#username").text();
		$.post('http://123.206.187.120/SG/KMS/uploadImg.php',
			{
				message : pic,
				filename : userName,
				filetype : fname[1],
				filesize : fi.size,
				rootPath : rootPath
			},
			function(data) {
				if (data.code == 1 || data.code == 2) {
					showToastr('上传失败');
				} else if (data.code == 0) {
					showToastr('上传成功');
					//把图中的头像也更改了
					$("#changeHeadImg").siblings("img").attr('src', pic);
					//更新到数据库
					ChangeHeaderImgSrc(userName,  fname[1]);
				}
			});
	}*/
	//更新到数据库
	function ChangeHeaderImgSrc(userName, imgType) {
		$.post('/KMS/API/Account/ChangeHeadImg',
			{
				userName : userName,
				imgType : imgType,
				
			},
			function(data) {
				if (data.msg == "success") {
					showToastr("头像修改成功");
				} else {
					showToastr("头像修改失败");
				}
			});
	}
	//toastr信息展示
	function showToastr(str) {
		toastr.options = {
			"progressBar" : true
		}
		toastr.info(str);
	}
	//展现layer
	function showLayer(pic, fname, fi, rootPath) {
		layer.closeAll('page');
		layer.open({
			type : 1, //Page层类型
			// area: ['500px', '405px'],
			//title : '头像预览',
			//shade : 0.6, //遮罩透明度
			anim : 1, //0-6的动画形式，-1不开启
			shade : false,
			title : false, //不显示标题
			btn : [ '立即上传', '残忍拒绝' ],
			offset : '100px',
			btnAlign : 'c',
			content : $("#image_thumb"),
			yes : function() {
				layer.closeAll('page');
				uploadImg(pic, fname, fi, rootPath);
			}
		});
	}
});