 $(function() {
   // function setwidth(){
   //   if (document.body.clientWidth<=1480) {
   //         $('body,html').width(1480)
   //       }else{
   //         $('body,html').width("100%")
   //       }
   // }
   // setwidth();
   // $(window).resize(function(){

   //     setwidth();
   // })
   // 上传
   $('select').selectOrDie();

   // $('#formBox').hradio();
   $('#file_upload').uploadify({
     'swf': '../../lib/upload/uploadify.swf',
     // 'uploader': '../../lib/upload/uploadify.php',
     'buttonText': '浏览',
     "width": "50"
   });
   $('#file_upload2').uploadify({
     'swf': '../../lib/upload/uploadify.swf',
     // 'uploader': '../../lib/upload/uploadify.php',
     'buttonText': '上传',
     "width": "90"
   });
   $('#addimg').uploadify({
     'swf': '../../lib/upload/uploadify.swf',
     // 'uploader': '../../lib/upload/uploadify.php',
     'buttonText': '浏览',
     "width": "100",
     "height": '60',
     'onSelect': function(e, queueId, fileObj) {
       alert("添加图片功能需要后天配合 用success回调就可")

     }
   });
   $('#addimg object').css("left", 0)
   $('#addimg').css("right", 0)
   $('#addimg').parent().css({
     "position": "relative",
     "height": 60,
     "paddingRight": 120
   })
   $('.imgbox .close').live('click', function(e) {
       e.preventDefault();
       $(this).parent().remove();
     })
     // 搜索  下啦

   $('.tableContent .search span .aricon').click(function() {
     $(this).siblings('ul').show();
   })
   $('.tableContent .search span ul li').click(function() {
     $(this).parent('ul').hide();
     $('.tableContent .search span var').eq(0).html($(this).html())
   })


   // 权重点击
   $('.weightp').click(function() {
     $(this).hide().siblings('.weight').show().val($(this).text());
   })
   $('body,html').click(function(e) {
       if ($(e.target).attr('class') == 'weightp') return false;
       $('.weightp').show().siblings('.weight').hide();
     })
     // 图片划过
   $('.imgbox').mouseover(function() {
     $(this).find('.close').show();
   })
   $('.imgbox').mouseout(function() {
     $(this).find('.close').hide();
   })

   // 排序
   $('.tableContent table .arrow').click(function() {
     $(this).toggleClass('arrowdown')
   })

   // 禁止
   // 
   // 
   var obj;
   $('td .op2').click(function() {
     obj = $(this);
     $("#dialog").dialog("open");
   })
    $('td .plbtn').click(function() {
     obj = $(this);
     $("#dialog3").dialog("open");
   })
    $('td .havePl').live('click',function() {
     obj = $(this);
     $("#dialog4").dialog("open");
   })
   $('td .op3').click(function() {
     obj = $(this);
     if ($(this).hasClass('down')) {
       $("#dialog2").dialog("open");
       return false

     };
     $("#dialog1").dialog("open");
   })
   var diabox = $("#dialog").dialog({
     autoOpen: false,
     padding: 0,
     width: 470,
     height: 280,
     modal: true
   });
   var diabox1 = $("#dialog1").dialog({
     autoOpen: false,
     padding: 0,
     width: 470,
     height: 280,
     modal: true
   });
   var diabox2 = $("#dialog2").dialog({
     autoOpen: false,
     padding: 0,
     width: 470,
     height: 280,
     modal: true
   });
   var diabox3= $("#dialog3").dialog({
     autoOpen: false,
     padding: 0,
     width: 470,
     height: 280,
     modal: true
   });
   var diabox4 = $("#dialog4").dialog({
     autoOpen: false,
     padding: 0,
     width: 470,
     height: 280,
     modal: true
   });
   $(".dialog .del").click(function() {
     $("#dialog").dialog('close');
     $("#dialog1").dialog('close');
     $("#dialog2").dialog('close');
     $("#dialog3").dialog('close');
     $("#dialog4").dialog('close');
   })
   $(".dialog .ok").click(function() {
       $("#dialog1").dialog('close');
       $("#dialog2").dialog('close');
       $("#dialog3").dialog('close');
       $("#dialog4").dialog('close');
       if ($(this).parents('.dialog').attr('id') == "dialog1") {
         obj.html("下架")
         obj.addClass("down")
       } else if ($(this).parents('.dialog').attr('id') == "dialog2") {
         obj.html("发布")
         obj.removeClass("down")
       }else if($(this).parents('.dialog').attr('id') == "dialog3"){
          obj.html("已评论")
          obj.removeClass("plbtn")
          obj.addClass("havePl")
       }
     })
     // 筛选
     // 
     // 
     // 表格划过
   $("tr").mouseover(function() {
     $(this).addClass('current').siblings().removeClass('current')
   })
   $(".screening dd a").click(function() {
       $(this).addClass('active').parent().siblings().find('a').removeClass('active');
     })
     // / 全选

   $('#all').click(function() {
     var checked = $(this).attr('checked');
     console.log(checked)
     if (checked) {
       $(":checkbox").attr("checked", 'checked'); //取消全选
     } else {

       $(":checkbox").attr("checked", false);
     }
   })

   $('.addbtn2').live('click',function(){
    
   })

 });