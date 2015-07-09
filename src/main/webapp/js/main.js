
var STATIC_UPLOAD="http://upload.example.com";
var STATIC="";

/**
 * Init system
 * */
(function(jQuery, bootstrap, i18n){
	debugger;
	$(document).ajaxError(function(event, request, settings) {
		if(request.status == 500){
			var errorCode = request.getResponseHeader("WN_ERROR");
			noty({
				type:"error",
				text: i18n.get(errorCode),
				timeout:2500
			});
		}else if(request.status > 500){
			noty({
				type:"error",
				text: request.statusText,
				timeout:2500
			});
		}else if(request.status!=200){
			noty({
				type:"error",
				text: "Server Error["+request.status+"]:"+request.statusText,
				timeout:2500
			});
		}
	});
})();	

/**
 * Date time format extend
 * */
Date.prototype.format = function(format){

    var o = { 
    "M+" : this.getMonth()+1, //month 
    "d+" : this.getDate(), //day 
    "h+" : this.getHours(), //hour 
    "m+" : this.getMinutes(), //minute 
    "s+" : this.getSeconds(), //second 
    "q+" : Math.floor((this.getMonth()+3)/3), //quarter 
    "S" : this.getMilliseconds() //millisecond 
    }

    if(/(y+)/.test(format)) { 
        format = format.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length)); 
    } 

    for(var k in o) { 
        if(new RegExp("("+ k +")").test(format)) { 
            format = format.replace(RegExp.$1, RegExp.$1.length==1 ? o[k] : ("00"+ o[k]).substr((""+ o[k]).length));
        } 
    }

    return format; 
}
