/**
 * 
 */

/// <reference path="jquery-1.10.2.min.js" />

$(function(){
	
	 var Ouli = $("#header-img-center ul li");
     var Ooli = $("#header-img-center ol li");
     var nIndex = 0;
     var timer = null;

     for (var i = 0; i < Ooli.length; i++) {
         Ooli[i].index = i;
         Ooli[i].onmouseover= function() {
             index = this.index;
             clearTimeout(timer);
             auto();
         }
         Ooli[i].onmouseout= function() {
             time();
         }

     }
     time();
     function time() {
         timer = setInterval(function() {
             nIndex++;
             nIndex %= 4;
             auto();
         }, 1000);
     }

     function auto() {
         for (var i = 0; i < Ooli.length; i++) {
             Ooli[i].style.background = '#ffffff';
             Ouli[i].style.display = 'none';
         }
         Ooli[nIndex].style.background = '#000';
         Ouli[nIndex].style.display = 'block';
     }
});