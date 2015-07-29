var totalPage=8;
var beforePageNum=4;
var afterPageNum=3;
var ellipsis="...";
var currPage=1;
function getPaginationNumber(currentPage){
    var pageArr=[];
    if(totalPage<=beforePageNum+afterPageNum){
        for(var i=1;i<=totalPage;i++){
            pageArr.push(i);
        }
        return pageArr;
    }
    var flag=false;
    for(var i=1;i<=beforePageNum-1;i++){
        if(currentPage==i){
            flag=true;
            break;
        }
    }
    if(flag==true){
        for(var i=1;i<=beforePageNum;i++){
            pageArr.push(i);
        }
        pageArr.push(ellipsis);
        for(var j=totalPage-afterPageNum+1;j<=totalPage;j++){
            pageArr.push(j);
        }
        return pageArr;
    }
    for(var i=totalPage-afterPageNum+1;i<=totalPage;i++){
        if(currentPage==i){
            flag=true;
            break;
        }
    }
    if(flag==true){
        for(var i=totalPage-beforePageNum-afterPageNum+1;i<=totalPage;i++){
            pageArr.push(i);
        }
        return pageArr;
    }
    if(currentPage==totalPage-afterPageNum){
        for(var i=currentPage-3;i<=totalPage;i++){
            pageArr.push(i);
        }
        return pageArr;
    }
    for(var i=currentPage-2;i<=currentPage;i++){
        pageArr.push(i);
    }
    pageArr.push(currentPage+1)
    if((currentPage+1)!=(totalPage-afterPageNum)){
        pageArr.push(ellipsis);
    }
    for(var i=totalPage-afterPageNum+1;i<=totalPage;i++){
        pageArr.push(i);
    }
    return pageArr;

}
function drawPage(currentPage){
    if(currentPage<=1){
        currentPage=1;
        $("#prev_btn").addClass("disabled").removeClass("active");
    }else{
        $("#prev_btn").addClass("active").removeClass("disabled");
    }
    if(currentPage>=totalPage){
        currentPage=totalPage;
        $("#next_btn").addClass("disabled").removeClass("active");
    }else{
        $("#next_btn").addClass("active").removeClass("disabled");
    }
    $("#current_page_span").empty().html(currentPage);
    currPage=currentPage;
    var pageArr=getPaginationNumber(currentPage);
    var html="";
    var prev=currentPage<=1?1:currentPage-1;
    var next=currentPage>=totalPage?totalPage:currentPage+1;
    var htmlBefore="<li onclick='drawPage("+1+")'><a href='javascript:void(0);'>首页</a></li>"+
        "<li onclick='drawPage("+prev+")'><a href='javascript:void(0);'>上一页</a></li>";
    var htmlAfter="<li onclick='drawPage("+next+")'><a href='javascript:void(0);'>下一页</a></li>"+
        "<li onclick='drawPage("+totalPage+")'><a href='javascript:void(0);'>尾页</a></li>";
    for(var i= 0,len=pageArr.length;i<len;i++){
        var page=pageArr[i];
        if(page==ellipsis){
            html=html+"<li class='ellipsis'><a href='javascript:void(0);'>"+ellipsis+"</a></li>";
        }else if(currentPage==page){
            html=html+"<li class='page-active'><a href='javascript:void(0);'>"+page+"</a></li>";
        }else{
            html=html+"<li onclick='drawPage("+page+")'><a href='javascript:void(0);'>"+page+"</a></li>";
        }
    }
    $("#page_ul").empty().html(htmlBefore+html+htmlAfter);
}
function prev(){
    var page=currPage-1;
    drawPage(page);
}
function next(obj){
    var page=currPage+1;
    drawPage(page);
}
$(function(){
    drawPage(1);
    $("#total_count_span").html(totalPage);
})