function generate(type) {
	    var n = noty({
	        text        : type,
	        type        : type,
	        dismissQueue: false,
	        layout      : 'top',
	        theme       : 'defaultTheme'
	    });
	    debugger;
	    console.log(type + ' - ' + n.options.id);
	    return n;
	}
	(function(){
		$("#loginBtn").on('click',function(){
			var name = $("#name").val();
			var password = $("#password").val();
			$.ajax({
			   type: "POST",
			   url: "/login",
			   data: {name:name,password:password},
			   success: function(data){
				   window.location.href="/main";
			   },
			   error: function(data){
				   var warning = generate('warning');
				   $.noty.setText(warning.options.id, '用户名和密码不匹配！');
				   setTimeout(function () {
			            $.noty.close(warning.options.id);
			        }, 2000);
			   },
			});
		});
	})();