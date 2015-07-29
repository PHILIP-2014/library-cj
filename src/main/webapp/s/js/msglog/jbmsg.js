 $(function() {
   function setwidth() {
     if (document.body.clientWidth <= 1480) {
       $('body,html').width(1480)
     } else {
       $('body,html').width("100%")
     }
   }
   setwidth();
   $(window).resize(function() {

     setwidth();
   })

   // 搜索  下啦

   $('.tableContent .search span .aricon').click(function() {
     $(this).siblings('ul').show();
   })
   $('.tableContent .search span ul li').click(function() {
     $(this).parent('ul').hide();
     $('.tableContent .search span var').eq(0).html($(this).html())
   })



   // 排序
   $('.tableContent table .arrow').click(function() {
     if ($(this).hasClass("arrowup")) {
       $(this).removeClass('arrowup').addClass("arrowdown")
     } else if ($(this).hasClass("arrowdown")) {
       $(this).removeClass('arrowdown').removeClass("arrowup")
     } else {
       $(this).addClass("arrowup")
     }
   })

   // 禁止
   // 
   // 
   var obj;
   $('td .op3').click(function() {
     obj = $(this);
     $("#dialog").dialog("open");
     $('select').selectOrDie();
   }) 
   $('.chatlog').click(function() {
     $("#chatlog").dialog("open");
   })
   $("#dialog").dialog({
     autoOpen: false,
     padding: 0,
     width: 500,
     height: 350,
     modal: true
   });
  $("#chatlog").dialog({
     autoOpen: false,
     padding: 0,
     width: 540,
     modal: true
   });
  $("#dialog1").dialog({
     autoOpen: false,
     padding: 0,
     width: 540,
     height:200,
     modal: true
   });
  $('.btmbar .del').click(function() {
     $("#dialog1").dialog('open');
   })
   $(".dialog .del").click(function() {
     $("#dialog").dialog('close');
     $("#dialog1").dialog('close');
   })
   $(".chatlogpop .titleV .close").click(function() {
     $("#chatlog").dialog('close');
   })
   $(".dialog .ok").click(function() {
      $("#dialog").dialog('close');
      $("#dialog1").dialog('close');
      obj.html('已处理').removeClass('op3')
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

 });