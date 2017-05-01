/// <reference path="jquery-1.10.2.min.js" />
$(function () {
    var  i = 0;
    $(".pro-btn").click(function() {
        var _top = $(this).siblings().find("img").offset().top;
        var _left = $(this).siblings().find("img").offset().left;
        var _width = $(this).siblings().find("img").width();
        var _height = $(this).siblings().find("img").height();

        var cart_top = $("#cart").offset().top;
        var cart_left = $("#cart").offset().left;
        var cart_width = $("#cart").width();
        var cart_height = $("#cart").height();
        $(this).siblings().find("img").clone().appendTo("body").addClass("body-img").
            css({
                "top": _top,
                "left": _left,
                "width": _width,
                "height": _height
            }).animate({
                "top": cart_top,
                "left": cart_left,
                "width": cart_width,
                "height": cart_height
            }, 1000, function() {
                $(this).remove();
                i++;
                $("#cart-num").html(i);
            });
    });
})