/**
 * 宋刚  2017/06/01
 * 用户个人中心的js文件
 */

$(function() {
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
	})

});