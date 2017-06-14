/// <reference path="jquery-1.10.2.min.js" />
/// <reference path="CommonJS.js" />


//全局变量
var commentFlag = {
	"level" : "me",
	"here" : "main",
	"name_you" : "who",
	"dynamicid" : 0,
	"publishCommentId" : 0
};
function isEmpty(a) {
	if (typeof (a) == "undefined" || a == "") {
		return true;
	}
	return false
}
//根据传进来的 在那个here下面评论 和 level是自己新的评论还是回复别人的
function changeCommentFlag(e, b, c) {
	commentFlag.here = e;
	commentFlag.level = b;
	commentFlag.name_you = c;
}

///由于blur()优先级大于click()  导致click()事件无法发生 所以给Blur设置延时发生
$(function() {

	//toastr信息展示
	function showToastr(str) {
		toastr.options = {
			"progressBar" : true
		}
		toastr.info(str);
	}

	//当文档加载完毕时立即获取当前用户信息
	var me_userName = ""; //本人作者的名字
	var me_imgSrc = ""; //本人作者的图片
	function queryUserInfoAjax() {
		me_userName = $("#me_username").text();
		if (isEmpty(me_userName))
			return;
		$.post("/KMS/API/Account/QueryImgSrcByName", {
			userName : me_userName
		}, function(data) {
			if (data.msg == "success") {
				me_imgSrc = data.imgSrc;
			} else {
				alert(data.msg);
			}
		});
	}
	queryUserInfoAjax();

	$("#top-txt textarea").on("focus", function() {
		$(this).parent().css("background-color", "#FFFFCC");
		$(this).parent().next().slideDown(50);
	});
	$("#top-txt textarea").on("blur", function() {
		var e = $(this);
		setTimeout(function() {
			e.parent().removeAttr("style");
			e.parent().next().slideUp(50);
		}, 100);
	});
	//相机这里暂时不加事件
	$("#center-top-camera").mouseover(function() {});
	//用事件委托代替直接绑定
	//这样避免动态添加的HTML 标签无事件效果
	//也就是用$(document).on('click', '.xxx', function(){})替换$('.xxx').click()

	//鼠标滑到评论信息上时显示评论图标
	$(document).on('mouseover', '.center-item-commentitem-main-userinfo-detail', function() {
		$(this).find(".center-item-commentitem-comment").children().show();
	});
	//鼠标滑过评论信息上时显示评论图标
	$(document).on('mouseleave', '.center-item-commentitem-main-userinfo-detail', function() {
		$(this).find(".center-item-commentitem-comment").children().hide();
	});
	//评论信息上的评论图标的点击事件
	$(document).on('click', '.center-item-commentitem-comment,.center-item-ico-comment a', function() {
		//因为是绑定了两个按钮 所以要判断是哪个按钮 来获取文本框 并让其获取焦点
		if ($(this).attr("class") == "center-item-commentitem-comment") { //评论中的
			var who = $(this).parent().siblings(".center-item-commentitem-main-userinfo-detail-message").children().first().text();
			commentFlag.publishCommentId = $(this).data("id");
			if ($(this).parent().parent().parent().attr("class") == "center-item-commentitem-nomain") {
				changeCommentFlag($(this).parent().parent().parent().parent(), "you", who);
			} else if ($(this).parent().parent().parent().attr("class") == "center-item-commentitem-main") {
				changeCommentFlag($(this).parent().parent().parent().parent(), "you", who);
			}
			$(this).parent().parent().parent().parent().parent().siblings(".center-item-txt").children().focus();
		} else {
			//最初的
			var who = $(this).parent().parent().parent().siblings(".center-item-userinfo").children(".center-item-userinfo-detail").children(".center-item-userinfo-name").text();
			//如果直接对动态评论  就不需要对方的userid
			$(this).parent().parent().parent().siblings(".center-item-txt").children().focus();
		}

	});
	//动态列表的评论文本框获取焦点事件
	$(document).on('focus', '.center-item-txt textarea', function() {
		$(this).parent().css("height", "40px");
		$(this).parent().css("background-color", "#FFFFCC");
		$(this).css("background-color", "#FFFFFF");
		$(this).parent().next().slideDown(100);
	//$(this).parent().next().show();
	});
	//动态列表的评论文本框失去焦点事件
	$(document).on('blur', '.center-item-txt textarea', function() {
		var e = $(this);
		setTimeout(function() {
			e.parent().removeAttr("style");
			e.removeAttr("style");
			e.parent().next().slideUp(100);
		}, 100);
	});
	//动态列表的评论按钮的点击事件
	$(document).on('click', '.center-item .center-item-btn a', function() {
		if (isEmpty(me_userName)) {
			showToastr("请先登录！");
			return;
		}

		var txt = $.trim($(this).parent().siblings(".center-item-txt").children().val());
		var _imgsrc = me_imgSrc;
		var _username_me = me_userName; //我的名字 
		var _username_you = commentFlag.name_you; //对方的用户名
		commentFlag.dynamicid = $(this).data("dynamicid");
		var _dynamicID = commentFlag.dynamicid;
		var _publishCommentid = commentFlag.publishCommentId;

		var item; //最后加载评论的位置区域
		if (txt != "") {
			if (commentFlag.level == "me") {
				var htmls = "<div class='center-item-commentitem'><div class='center-item-commentitem-main'>" +
					"<div class='center-item-commentitem-main-userinfo-img'><img src='{imgsrc}'/></div>" +
					"<div class='center-item-commentitem-main-userinfo-detail'><div class='center-item-commentitem-main-userinfo-detail-message'>" +
					"<span class='center-item-commentitem-main-userinfo-detail-message-name center-item-commentitem-main-userinfo-messsage-me'>{name_me}</span>" +
					"<span>：</span>{message}</div><p class='center-item-commentitem-main-userinfo-detail-time'><span>{time}</span>" +
					"<a class='center-item-commentitem-comment' data-id='" + _publishCommentid + "'><img src='/KMS/resources/comment.png' /></a></p></div></div></div>";
				var result = htmls.format({
					imgsrc : _imgsrc,
					name_me : _username_me,
					message : txt,
					time : new Date().Format("yyyy-MM-dd hh:mm:ss")
				});
				item = $(this).parent().siblings(".center-item-commentlist:last");
			//commentFlag.here.append(result);
			} else if (commentFlag.level == "you") {
				var htmls = "<div class='center-item-commentitem-nomain'>" +
					"<div class='center-item-commentitem-main-userinfo-img'><img src='{imgsrc}'/>" +
					"</div><div class='center-item-commentitem-main-userinfo-detail'>" +
					"<div class='center-item-commentitem-main-userinfo-detail-message'>" +
					"<span class='center-item-commentitem-main-userinfo-detail-message-name center-item-commentitem-main-userinfo-messsage-me'>{name_me}</span>" +
					"对<span class='center-item-commentitem-main-userinfo-detail-message-name center-item-commentitem-main-userinfo-messsage-you'>{name_you}</span>" +
					"<span>说：</span>{message}</div><p class='center-item-commentitem-main-userinfo-detail-time'>" +
					"<span>{time}</span><a class='center-item-commentitem-comment' data-id='" + _publishCommentid + "'>" +
					"<img src='/KMS/resources/comment.png' /></a></p></div></div>";
				var result = htmls.format({
					imgsrc : _imgsrc,
					name_me : _username_me,
					name_you : _username_you,
					message : txt,
					time : new Date().Format("yyyy-MM-dd hh:mm:ss")
				});
				item = commentFlag.here;
			}
			$(this).parent().siblings(".center-item-txt").children().val("");
			//用Ajax向后台发送请求
			$.post("/KMS/API/Dynamic/AddComment", {
				username_me : _username_me,
				username_you : _username_you,
				message : txt,
				dynamicID : _dynamicID,
				publishCommentID : _publishCommentid
			}, function(data) {
				if (data.msg == "success") {
					item.append(result); //当加入数据库成功时 再将动态展示
				} else {
					alert(data.msg);
				}
			});
		}
		commentFlag.level = "me";
	});
	//点赞
	$(document).on('click', '.center-item-ico-like a', function() {
		var prenum = $(this).parent().parent().siblings(".center-item-ico-likenum").children("span").text();
		prenum++;
		$(this).parent().parent().siblings(".center-item-ico-likenum").children("span").text(prenum);
	});
	//发表动态的发表按钮的点击事件
	$("#top .center-item-btn a").click(function() {
		if (isEmpty(me_userName)) {
			showToastr("请先登录！");
			return;
		}
		var txt = $.trim($(this).parent().siblings("#top-txt").children("textarea").val());
		var _imgsrc = me_imgSrc;
		var _username = me_userName;
		if (txt != "") {
			var item = $(this).parent().parent().siblings("#center").children(".center-itemlist");
			var htmls = " <div class='center-item'> <div class='center-item-userinfo'><div class='center-item-userinfo-img'>" +
				"<img src='{imgsrc}'/></div>" +
				"<div class='center-item-userinfo-detail'><p class='center-item-userinfo-name'>{name}</p>" +
				"<p class='center-item-userinfo-time'>{date}</p>" +
				"</div></div><div class='center-item-description'>{message}</div>" +
				"<div class='center-item-ico'><div class='center-item-ico-likenum'>已被点赞<span>{nums}</span>次</div>" +
				"<ul><li class='center-item-ico-comment'><a href='javascript:;'><img src='/KMS/resources/comment.png'/></a></li>" +
				"<li class='center-item-ico-like'><a href='javascript:;'><img src='/KMS/resources/like.png'/></a></li></ul></div><hr/>" +
				"<div class='center-item-commentlist'></div><div class='center-item-txt'><textarea placeholder='评论'></textarea>" +
				"</div><div class='center-item-btn'><a href='javascript:;' data-dynamicid='{dynamicid}'>评论</a></div></div><div class='center-stop'></div>";

			$(this).parent().siblings("#top-txt").children().val("");

			//用Ajax向后台发送请求
			$.post("/KMS/API/Dynamic/AddDynamic", {
				username : _username,
				message : txt
			}, function(data) {
				if (data.msg == "success") {
					var result = htmls.format({
						imgsrc : _imgsrc,
						name : _username,
						date : new Date().Format("yyyy-MM-dd hh:mm:ss"),
						message : txt,
						nums : 5,
						dynamicid : data.dynamicid
					});
					item.append(result); //当加入数据库成功时 再将动态展示
				} else {
					alert(data.msg);
				}
			});
		}
	});

});


/*
 $(".center-item-txt textarea").on("focus", function () {
        $(this).parent().css("height", "40px");
        $(this).parent().css("background-color", "#FFFFCC");
        $(this).parent().next().slideDown(100);
    });
    $(".center-item-txt textarea").on("blur", function() {
        var e = $(this);
        setTimeout(function() {
            e.parent().removeAttr("style");
            e.parent().next().slideUp(100);
        }, 100);
    });
     $(".center-item .center-item-btn a").click(function () {
        var txt = $(this).parent().siblings(".center-item-txt").children().val();
        if (txt != "") {
            if (commentFlag.level == "me") {
                var htmls = "<div class='center-item-commentitem'><div class='center-item-commentitem-main'><div class='center-item-commentitem-main-userinfo-img'><img src='{imgsrc}'/></div><div class='center-item-commentitem-main-userinfo-detail'><div class='center-item-commentitem-main-userinfo-detail-message'><span class='center-item-commentitem-main-userinfo-detail-message-name center-item-commentitem-main-userinfo-messsage-me'>{name_me}</span><span>：</span>{message}</div><p class='center-item-commentitem-main-userinfo-detail-time'><span>{time}</span><a class='center-item-commentitem-comment'><img src='Images/comment.png' /></a></p></div></div></div>";
                var result = htmls.format({ imgsrc: 'Images/user.jpg', name_me : '我是测试机3号', message: txt, time: new Date().Format("yyyy-MM-dd hh:mm:ss") });
                $(this).parent().siblings(".center-item-commentlist").append(result);
                //commentFlag.here.append(result);
            } else if (commentFlag.level == "you") {
                var htmls = "<div class='center-item-commentitem-nomain'><div class='center-item-commentitem-main-userinfo-img'><img src='{imgsrc}'/></div><div class='center-item-commentitem-main-userinfo-detail'><div class='center-item-commentitem-main-userinfo-detail-message'><span class='center-item-commentitem-main-userinfo-detail-message-name center-item-commentitem-main-userinfo-messsage-me'>{name_me}</span>对<span class='center-item-commentitem-main-userinfo-detail-message-name center-item-commentitem-main-userinfo-messsage-you'>{name_you}</span><span>说：</span>{message}</div><p class='center-item-commentitem-main-userinfo-detail-time'><span>{time}</span><a class='center-item-commentitem-comment'><img src='Images/comment.png' /></a></p></div></div>";
                var result = htmls.format({ imgsrc: 'Images/user.jpg', name_me: '我是测试机3号', name_you:commentFlag.name_you,message: txt, time: new Date().Format("yyyy-MM-dd hh:mm:ss") });
                commentFlag.here.append(result);
            }
            $(this).parent().siblings(".center-item-txt").children().val("");
        }
        commentFlag.level = "me";
    });
    $(".center-item-commentitem-main-userinfo-detail").mouseover(function () {
        $(this).find(".center-item-commentitem-comment").children().show();
    });
    $(".center-item-commentitem-main-userinfo-detail").mouseleave(function () {
        $(this).find(".center-item-commentitem-comment").children().hide();
    });
     $(".center-item-commentitem-comment ").click(function() {
        var who = $(this).parent().siblings(".center-item-commentitem-main-userinfo-detail-message").find(".center-item-commentitem-main-userinfo-detail-message-name").text();
        $(this).parent().parent().parent().parent().parent().siblings(".center-item-txt").children().val("对" + who + "说：");
    });
    */