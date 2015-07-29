
	$(function(){
		$(".markMap").click(function(){
			var d=dialog({
		    	id:"baiduMap",
		        title:"",
		        backdropBackground:"#ccc",
		        zIndex:1000,
		        url:"map.html",
		        width:"800px",
		        height:"600px"
		     });
		    d.__lock();
			d.show();
		  $("body").on("click",".cancelBtn",function(){d.close();});
		  $("body").on("click",".querenBtn",function(){
			  
			  d.close();
			  
		});
       });
		
		
		
		
	});