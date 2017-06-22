/**
 * Created by Administrator on 2015/5/3.
 */
$(function(){
	   $(".team_member_list").eq(0).css({
	       marginLeft: 0
	   });
	});
$(".nav_list ul li").on("click",function(){
    var navIndex = $(this).index();
    $(".move_piece").stop().animate({
        top: 70*navIndex+20+"px"
    },200);
    $(".content_list").eq(navIndex).addClass("show_current").siblings().removeClass("show_current");
});