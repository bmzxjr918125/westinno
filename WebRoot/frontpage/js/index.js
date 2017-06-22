/**
 * Created by Administrator on 2016/3/17.
 */
//轮播
var i = 0;
var play_pic1Lengh = $(".play_pic1 .swiper-slide").length;
for( var j = 0; j < play_pic1Lengh; j++){
    var spanHtml = "<span></span>";
    $(".swiper-pagination").append(spanHtml);
}
$(".swiper-slide").eq(0).css({
    display: "block"
});
$(".swiper-pagination span").eq(0).addClass("active");
function play1() {
    if (i < play_pic1Lengh - 1) {
        $(".swiper-slide").eq(i).fadeOut("normal").next().fadeIn();
        i++;
        $(".swiper-pagination span").eq(i).addClass("active").siblings().removeClass("active");
    } else {
        $(".swiper-slide").eq(i).fadeOut("normal");
        $(".swiper-slide").eq(0).fadeIn("normal");
        i = 0;
        $(".swiper-pagination span").eq(0).addClass("active").siblings().removeClass("active");
    }
}
$(".swiper-pagination span").live("click",function(){
    clearInterval(play_move);
    var spanIndex = $(this).index();
    $(".swiper-pagination span").eq(spanIndex).addClass("active").siblings().removeClass("active");
    $(".swiper-slide").eq(i).fadeOut("normal");
    $(".swiper-slide").eq(spanIndex).fadeIn("normal");
    play_move = setInterval(play1,5000);
    i = spanIndex;
});
var play_move = setInterval(play1,5000);

<!--听他们怎么说-->
var say_person_listLengh = $(".say_person_list").length;
var listWidth = $(".say_person").width();
$(".say_person_main").css({
    width: listWidth * say_person_listLengh+"px"
});
$(".say_person_list").css({
    width: 100/say_person_listLengh+"%"
});
$(".say_word_content span").eq(1).css({
    display: "block"
});
function leftMove(){
    $(".button_prev").attr("disabled","disabled");
    $(".say_person_list").eq(0).stop().animate({
        marginLeft: -listWidth+"px"
    },500,function(){
        var spanNode = $(".say_word_content span").eq(0).clone();
        var listNode = $(".say_person_list").eq(0).clone();
        $(".say_word_content span").eq(0).remove();
        $(".say_person_list").eq(0).remove();
        $(".say_word_content").append(spanNode);
        $(".say_person_main").append(listNode);
        $(".say_person_list").css({
            marginLeft: 0
        });
        $(".say_word_content span").eq(1).fadeIn("normal").siblings().css({
            display: "none"
        });
        $(".button_prev").removeAttr("disabled");
    });

}
function rightMove(){
    $(".button_next").attr("disabled","disabled");
    $(".say_person_list").eq(0).stop().animate({
        marginLeft: listWidth+"px"
    },500,function(){
        var spanNode = $(".say_word_content span").eq(say_person_listLengh-1).clone();
        var listNode = $(".say_person_list").eq(say_person_listLengh-1).clone();
        $(".say_word_content span").eq(say_person_listLengh-1).remove();
        $(".say_person_list").eq(say_person_listLengh-1).remove();
        $(".say_word_content").prepend(spanNode);
        $(".say_person_main").prepend(listNode);
        $(".say_person_list").css({
            marginLeft: 0
        });
        $(".say_word_content span").eq(1).fadeIn("normal").siblings().css({
           display: "none"
        });
        $(".button_next").removeAttr("disabled");
    });

}
$(".button_prev").on("click",leftMove);
$(".button_next").on("click",rightMove);


//侧栏导航悬停图片切换
$(".bar_content_list").on("mouseover",function(){
    $(this).find(".bar_icon_show img").eq(0).css({
        display: "none"
    });
});
$(".bar_content_list").on("mouseout",function(){
    $(this).find(".bar_icon_show img").eq(0).css({
        display: "block"
    });
});

//鼠标滚动
var lastVal=900;
$(function(){
    var currentVal = $(window).scrollTop();
    var moveVal = (currentVal-lastVal)/10;
    $(".listen_main").css({
        backgroundPosition: "0"+" "+moveVal+"px"
    });
});
$(window).scroll(function(){
    var currentVal = $(window).scrollTop();
    //console.log(currentVal);
    var moveVal = (currentVal-lastVal)/50;
    $(".listen_main").css({
        backgroundPosition: "0"+" "+moveVal+"px"
    });
});

//伙伴图片悬停图片切换
$(".brand_list").on("mouseover",function(){
    $(this).find(".brand_list_show img").eq(0).css({
        display: "none"
    });
});
$(".brand_list").on("mouseout",function(){
    $(this).find(".brand_list_show img").eq(0).css({
        display: "block"
    });
});

$.ready(function(){


});