	var pageNum;
	var totalRecord; 
	var totalPageCount; 
	var firstPageNum; 
	var lastPageNum; 
	function page(pageNum,totalRecord){
	    totalPageCount = totalRecord % 4 == 0 ? parseInt(totalRecord/ 4) : parseInt(totalRecord / 4) + 1;
		pageNum=pageNum;
		totalRecord=totalRecord;
		if(totalPageCount<=5) {
			firstPageNum = 1;
			lastPageNum = totalPageCount;
		} else {
			firstPageNum = pageNum-parseInt(5/2);
			lastPageNum = parseInt(pageNum)+parseInt(5/2);
			if(firstPageNum<1) {
				firstPageNum = 1;
				lastPageNum = 5;
			}
			if(lastPageNum>totalPageCount) {
				lastPageNum = totalPageCount;
				firstPageNum = lastPageNum-5+1;
			}
		}
		var html = "";
		for(var i=firstPageNum;i<lastPageNum;i++){
			if(i==pageNum){
				html+=" <li class='page_num page_active'><a href='javascript:void(0);' onclick='find(this)'>"+i+"</a></li>";
			}else{
				html+=" <li class='page_num '><a href='javascript:void(0);' onclick='find(this)'>"+i+"</a></li>";
			}	
			
		}
		if(lastPageNum<totalPageCount-2){
			html+=" <li class='page_omit' style='border:none;'>...</li>";
		}
		if(lastPageNum<totalPageCount-1){
			html+="<li class='page_num '><a href='javascript:void(0);' onclick='find(this)'>"+(totalPageCount-2)+"</a></li> ";
		}
		if(lastPageNum<totalPageCount){
			html+="<li class='page_num '><a href='javascript:void(0);' onclick='find(this)'>"+(totalPageCount-1)+"</a></li> ";
		}
		if(lastPageNum<=totalPageCount){
			if(lastPageNum==pageNum){
				html+="<li class='page_num page_active'><a href='javascript:void(0);' onclick='find(this)'>"+totalPageCount+"</a></li> ";
			}else{
				html+="<li class='page_num '><a href='javascript:void(0);' onclick='find(this)'>"+totalPageCount+"</a></li> ";
			}
			
		}		
		$("#page1").html(html);
		$(".page1").html(pageNum);
		if($(".page1").text()==totalPageCount){
			$(".page_click").css("color","#d7d7d7");
		}else{
			$(".page_click").css("color","#38ad6a");
		}
		if($(".page1").text()==1){
			$(".page_noClick").css("color","#d7d7d7");
		}else{
			$(".page_noClick").css("color","#38ad6a");
		}
	}
	
	function find(obj){
		var a = $(obj).text();
		if("首页"==a){
			a=1;
		}
		if("尾页"==a){
			a=totalPageCount;
		}
		if("上一页"==a){
			var s =$(".page_active").find("a").text();
			s =s-1;
			if(s<1){
				s=1;
			}
			a=s;
		}
		if("下一页"==a){
			var s =$(".page_active").find("a").text();
			s =parseInt(s)+1;
			if(s>totalPageCount){
				s=totalPageCount;
			}
			a=s;	
		}

		$("tbody tr").hide();
		$("tbody tr:gt("+((a-1)*4)+")").show();
		$("tbody tr:gt("+((a-1)*4+4)+")").hide();
		page(a,$("tbody tr").length-1);
	}
	function page85(){
		var s =$(".page_active").find("a").text();
		s =parseInt(s)+1;
		if(s>totalPageCount){
			s=totalPageCount;
		}
		a=s;
		$("tbody tr").hide();
		$("tbody tr:gt("+((a-1)*4)+")").show();
		$("tbody tr:gt("+((a-1)*4+4)+")").hide();
		if($("#footer_page").find("li.page_active").find("a").text() == 85){
            return false;
        }
        $("#footer_page").find("li.page_active").next().addClass("page_active").siblings().removeClass("page_active");
        page(a,$("tbody tr").length-1);
	}
	function page1(){
		var s =$(".page_active").find("a").text();
		s =s-1;
		if(s<1){
			s=1;
		}
		a=s;
		$("tbody tr").hide();
		$("tbody tr:gt("+((a-1)*4)+")").show();
		$("tbody tr:gt("+((a-1)*4+4)+")").hide();
		  if($("#footer_page").find("li.page_active").find("a").text() == 1){
	            return false;
	        }
	        $("#footer_page").find("li.page_active").prev().addClass("page_active").siblings().removeClass("page_active");
	     page(a,$("tbody tr").length-1);
	}
	
	$(document).ready(function(){
		$("tbody tr:gt(4)").hide();
		var nums = $("tbody tr").length-1;
		var numc= nums % 4 == 0 ? parseInt(nums/ 4) : parseInt(nums / 4) + 1;
		$(".page85").text(numc);
		$(".page500").text(nums);
		page(1,$("tbody tr").length-1);
		
	})