﻿/*******
made by songgang
2017.06.01
*******/

$.tools = (function () {
    /*
    * getQueryString
    */
    var getQueryString = function (name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
        var r = window.location.search.substr(1).match(reg);
        if (r != null) return unescape(r[2]); return null;
    };
    /*
    * validateInt
    */
    var validateInt = function (value) {
        var reg = /^\d+$/;
        if (value.constructor === String) {
            var re = value.match(reg);
            if (re != null) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    };
    /*
    * validateFloat
    */
    var validateFloat = function (value) {
        var reg = /^[0-9]+([.]{1}[0-9]{1,2})?$/;
        if (value.constructor === String) {
            var re = value.match(reg);
            if (re != null) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    };


    return {
        getQueryString: getQueryString
    , validateInt: validateInt
    , validateFloat: validateFloat
    };

})();

//源于C#的string.format()
String.prototype.format = function (args) {
  var result = this;
  if (arguments.length > 0) {
      if (arguments.length == 1 && typeof (args) == "object") {
          for (var key in args) {
              if (args[key] != undefined) {
                  var reg = new RegExp("({" + key + "})", "g");
                  result = result.replace(reg, args[key]);
              }
          }
      }
      else {
          for (var i = 0; i < arguments.length; i++) {
              if (arguments[i] != undefined) {
                  //var reg = new RegExp("({[" + i + "]})", "g");//这个在索引大于9时会有问题，谢谢何以笙箫的指出

                  var reg = new RegExp("({)" + i + "(})", "g");
                  result = result.replace(reg, arguments[i]);
              }
          }
      }
  }
  return result;
}
//日期的格式化
Date.prototype.Format = function (fmt) { //author: meizz 
  var o = {
      "M+": this.getMonth() + 1, //月份 
      "d+": this.getDate(), //日 
      "h+": this.getHours(), //小时 
      "m+": this.getMinutes(), //分 
      "s+": this.getSeconds(), //秒 
      "q+": Math.floor((this.getMonth() + 3) / 3), //季度 
      "S": this.getMilliseconds() //毫秒 
  };
  if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
  for (var k in o)
      if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
  return fmt;
}
