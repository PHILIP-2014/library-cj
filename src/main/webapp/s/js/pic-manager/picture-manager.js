$(function(){
    $("#picture_sort_btn").click(function(){
        var $i=$(this).next();
        if($i.hasClass("sort-asc")){
            $i.removeClass().addClass("sort-desc");
        }else{
            $i.removeClass().addClass("sort-asc");
        }
    })
    $("#edit_picture_dialog").on("show.bs.modal",function(){
        $("#edit_picture_div").show();
    })
    $("#remove_picture_dialog").on("show.bs.modal",function(event){
        var btn=$(event.relatedTarget);
        $("#delete_picture_btn").click(function(){
            btn.parent().parent().remove();
            $("#remove_picture_dialog").modal("hide");
        })
    })
    $("#publish_dialog").on("show.bs.modal",function(event){
        var btn=$(event.relatedTarget);
        $("#publish_btn").click(function(){
            btn.after("<a class='btn btn-default unpublish' role='button' data-toggle='modal' data-target='#unpublish_dialog'>下架</a>");
            btn.remove();
            $("#publish_dialog").modal("hide");
        })
    })
    $("#unpublish_dialog").on("show.bs.modal",function(event){
        var btn=$(event.relatedTarget);
        $("#unpublish_btn").click(function(){
            btn.after("<a class='btn btn-default publish' role='button' data-toggle='modal' data-target='#publish_dialog'>发布</a>");
            btn.remove();
            $("#unpublish_dialog").modal("hide");
        })
    })
    $("#remove_select_picture_dialog").on("show.bs.modal",function(){
        $("#delete_select_picture_btn").click(function(){
            $("#picture_table tbody ").find("tr").find("td:first").find(".checkbox-checked").parent().parent().parent().parent().remove();
            $("#remove_select_picture_dialog").modal("hide");
        })
    })
    $("#picture_table span[name='weight_span']").click(function(){
        var me=$(this);
        var temp=me.html();
        me.hide();
        var $input=$("<input class='edit-table-input'>").val(temp);
        me.after($input);
        $input.focus();
        $input.blur(function(){
            me.empty().html($(this).val());
            $(this).remove();
            me.show();
        })
    })
    $("#search_selector_item li").click(function(){
        var itemName=$(this).children().html();
        $("#search_selector").empty().html(itemName);
    })
    $("#place_selector_item_add_dialog li").click(function(){
        var itemName=$(this).children().html();
        $("#place_selector_add_dialog").empty().html(itemName);
    })
    $("#state_selector_item_add_dialog li").click(function(){
        var itemName=$(this).children().html();
        $("#state_selector_add_dialog").empty().html(itemName);
    })
    $("#place_selector_item_edit_dialog li").click(function(){
        var itemName=$(this).children().html();
        $("#place_selector_edit_dialog").empty().html(itemName);
    })
    $("#state_selector_item_edit_dialog li").click(function(){
        var itemName=$(this).children().html();
        $("#state_selector_edit_dialog").empty().html(itemName);
    })
    $("#picture_select_all").click(function(){
        var me=$(this);
        if(me.hasClass("checkbox-default")){
            me.addClass("checkbox-checked").removeClass("checkbox-default");
            $("#picture_table tbody i[name='checkbox']").addClass("checkbox-checked").removeClass("checkbox-default");
        }else{
            me.addClass("checkbox-default").removeClass("checkbox-checked");
            $("#picture_table tbody i[name='checkbox']").addClass("checkbox-default").removeClass("checkbox-checked");
        }
    })
    $("#picture_table tbody i[name='checkbox']").click(function(){
        var me=$(this);
        if(me.hasClass("checkbox-default")){
            me.addClass("checkbox-checked").removeClass("checkbox-default");
        }else{
            me.addClass("checkbox-default").removeClass("checkbox-checked");
        }
    })
    $("#remove_edit_picture").click(function(){
        $("#edit_picture_div").hide();
    })
})