$(document).ready(function(){
    $("#sotr_btn").click(function(){

        var me = $(this).next("span");

        if(me.hasClass("sort_up")){
            //降序方法
            me.removeClass("sort_up").addClass("sort_down");

        }else{
            //升序方法
            me.removeClass("sort_down").addClass("sort_up");

        }



    })

    $(".modal").find(".modal-body").find(".dropdown").find(".dropdown-menu").find("li").click(function(){
        var me = $(this);
        var content = me.find("a").text();
        me.parent().prev("button").find("span.select_content").text(content);
    });

    $(".search_area").find(".dropdown-menu").find("li").click(function(){
        var me = $(this);
        var content = me.find("a").text();
        me.parent().prev("a").find("span.search_condition").text(content);
    });

    $(".checkbox_select_all").click(function(){
        var me = this;
        var checkboxs =  $(".table_role_list").find(".admin_list").find("tbody").find("tr").find("td:first").find("input[type=checkbox]");
        if(me.checked == true){

            checkboxs.each(function(i){
                this.checked = true;
            });
        }else{
            checkboxs.each(function(i){
                this.checked = false;
            });
        }
    });

    $('#deleteAdmin').on('show.bs.modal', function (e) {
        var me = e.relatedTarget;
        $(".delete_finish").click(function(){
            $(me).parent().parent().remove();
            $('#deleteAdmin').modal('hide');

        });

    })
    $('#deleteRole').on('show.bs.modal', function (e) {
        var me = e.relatedTarget;
        $(".delete_finish").click(function(){
            $(me).parent().parent().remove();
            $('#deleteRole').modal('hide');

        });

    })
    $('#deleteAdminAll').on('show.bs.modal', function (e) {

        $(".delete_finish").click(function(){
            var checkboxs =  $(".table_role_list").find(".admin_list").find("tbody").find("tr").find("td:first").find("input[type=checkbox]");
            checkboxs.each(function(i){
                if(this.checked == true){
                    $(this).parent().parent().parent().parent().remove();
                }
            });
            $('#deleteAdminAll').modal('hide');
        });

    })




   /* $(".delete_checkbox_rele").click(function(){
        var checkboxs =  $(".table_role_list").find(".admin_list").find("tbody").find("tr").find("td:first").find("input[type=checkbox]");
        checkboxs.each(function(i){
            if(this.checked == true){
                $(this).parent().parent().parent().parent().remove();
            }
        });
    });*/
    /* 页码 */
    $("#footer_page").find("li.page_num").click(function(){
        var me = $(this);
        me.addClass("page_active").siblings().removeClass("page_active");
        $(".page_role").find(".page_now").text(me.find("a").text());
    });
    /*首页 */
    $("#footer_page").find("li.page_home").click(function(){

        $("#footer_page").find("li.page_num:first").addClass("page_active").siblings().removeClass("page_active");
        $(".page_role").find(".page_now").text( $("#footer_page").find("li.page_active").find('a').text());

    });
    /* 尾页*/
    $("#footer_page").find("li.page_trailer").click(function(){

        $("#footer_page").find("li.page_num:last").addClass("page_active").siblings().removeClass("page_active");
        $(".page_role").find(".page_now").text( $("#footer_page").find("li.page_active").find('a').text());

    });
    
//    /*上一页 */
//    $("#footer_page").find("li.page_previous").click(function(){
//        debugger;
//        if($("#footer_page").find("li.page_active").find("a").text() == 1){
//            return false;
//        }
//        $("#footer_page").find("li.page_active").prev().addClass("page_active").siblings().removeClass("page_active");
//
//
//    });
//    /*下一页 */
//    $("#footer_page").find("li.page_next").click(function(){
//        debugger;
//        if($("#footer_page").find("li.page_active").find("a").text() == 85){
//            return false;
//        }
//        $("#footer_page").find("li.page_active").next().addClass("page_active").siblings().removeClass("page_active");
//
//
//    });


    



});