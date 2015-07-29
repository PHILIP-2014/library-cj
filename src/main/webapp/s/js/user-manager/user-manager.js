$(function(){
    $("#user_sort_btn").click(function(){
        var $i=$(this).next();
        if($i.hasClass("sort-asc")){
            $i.removeClass().addClass("sort-desc");
        }else{
            $i.removeClass().addClass("sort-asc");
        }
    })
    $("#remove_select_user_dialog").on("show.bs.modal",function(){
        $("#delete_select_user_btn").click(function(){
            $("#user_table tbody").find("tr").find("td:first").find(".checkbox-checked").parent().parent().parent().parent().remove();
            $("#remove_select_user_dialog").modal("hide");
        })
    })
    $("#search_selector_item li").click(function(){
        var itemName=$(this).children().html();
        $("#search_selector").empty().html(itemName);
    })

    $("#user_select_all").click(function(){
        var me=$(this);
        if(me.hasClass("checkbox-default")){
            me.addClass("checkbox-checked").removeClass("checkbox-default");
            $("#user_table tbody i[name='checkbox']").addClass("checkbox-checked").removeClass("checkbox-default");
        }else{
            me.addClass("checkbox-default").removeClass("checkbox-checked");
            $("#user_table tbody i[name='checkbox']").addClass("checkbox-default").removeClass("checkbox-checked");
        }
    })
    $("#user_table tbody i[name='checkbox']").click(function(){
        var me=$(this);
        if(me.hasClass("checkbox-default")){
            me.addClass("checkbox-checked").removeClass("checkbox-default");
        }else{
            me.addClass("checkbox-default").removeClass("checkbox-checked");
        }
    })

})