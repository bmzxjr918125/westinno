/**
 * Created by Administrator on 2015/5/3.
 */



$(".hover_list").hover(function(){
    var infHeight = $(this).find(".doctor_inf").height();
    $(this).find("img").stop().animate({
        top: -30+"px"
    });
    $(this).find(".doctor_inf").stop().animate({
        top: 290-infHeight+"px"
    });
},function(){
    $(this).find(".doctor_inf").stop().animate({
        top: 290+"px"
    });
    $(this).find("img").stop().animate({
        top: 0
    });
});

function scrollShow(){
    var scrollTopValue = $(window).scrollTop();
    if( scrollTopValue >= 540 ){
        $(".two_dimension_code_frame").fadeIn();
    }else{
        $(".two_dimension_code_frame").fadeOut();
    }
}
scrollShow();
$(document).ready(function(){
    $(window).scroll(function(){
        scrollShow();
    });
});

$(".android_btn").on("click",function(){
    var download_way = $("#download_way").offset().top;
    $("html,body").animate({
        scrollTop: download_way
    }, 500);
});
$(".iPhone_btn").on("click",function(){
    var download_way = $("#download_way").offset().top;
    $("html,body").animate({
        scrollTop: download_way
    }, 500);
});

