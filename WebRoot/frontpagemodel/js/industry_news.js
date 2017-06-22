/**
 * Created by Administrator on 2016/3/21.
 */
//轮播
var i = 0;
var play_pic1Lengh = $(".left_pic .swiper-slide").length;
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
    play_move = setInterval(play1,2000);
    i = spanIndex;
});
var play_move = setInterval(play1,2000);