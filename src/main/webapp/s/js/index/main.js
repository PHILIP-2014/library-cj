$(function() {
	$(".ce > li > a").click(function() {
		$(this).addClass("xz").parents().siblings().find("a").removeClass("xz");
		$(this).parents().siblings().find(".er").hide(300);
		$(this).siblings(".er").toggle(300);
		var _url = $(this).attr("_url");
		$("#ifm").attr('src', _url)
		ifmW($(this))
		$('.firsttop .span3').remove()
		$('.firsttop .span2').html($(this).text())
		
	})

	$(".er > li > a").click(function() {
		$(this).addClass("sen_x").parents().siblings().find("a").removeClass("sen_x");
		console.log($(this).attr("_url"))
		var _url = $(this).attr("_url");
		$("#ifm").attr('src', _url)
		ifmW($(this))
		$('.firsttop .span3').remove()
		$('<span class="span1 span3">'+$(this).parents('ul').siblings('a').text()+'&nbsp;&nbsp;>&nbsp;&nbsp;</span>').insertBefore($('.firsttop .span2'))
		$('.firsttop .span2').html($(this).text())
	})
	function ifmW(_this){
		if (_this.attr('falg')=="true") {
			$("#ifm").width('1482')
		}else{
			$("#ifm").width('100%')
		}

	}
	// function setwidth() {
	// 	if (document.body.clientWidth <= 1480) {
	// 		$('body,html').width(1480)
	// 	} else {
	// 		$('body,html').width("100%")
	// 	}
	// }
	// setwidth();
	// $(window).resize(function() {

	// 	setwidth();
	// })
})