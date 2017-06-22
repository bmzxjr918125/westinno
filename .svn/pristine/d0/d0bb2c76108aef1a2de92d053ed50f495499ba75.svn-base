/**
 * Created by Administrator on 2016/3/21.
 */

//数量加减
$(".add_pic").on("click",function(){
    var numVal = Number($(this).parent().find("input").val());
    numVal = numVal+1;
    $(this).parent().find("input").val(numVal);
});
$(".reduce_pic").on("click",function(){
    var numVal = Number($(this).parent().find("input").val());
    if( numVal > 0 ){
        numVal = numVal-1;
        $(this).parent().find("input").val(numVal);
    }else{

    }
});

//类型选择
$(".choice_list").on("click",function(){
    $(this).addClass("active").siblings().removeClass("active");
});

//商品详情、常见问题
$(".goods_info_head_content button").on("click",function(){
    var btnIndex = $(this).index();
    $(".move_line").animate({
        left: 61+222*btnIndex+"px"
    });
    $(".goods_info_show").eq(btnIndex).css({
        display: "block"
    }).siblings().css({
        display: "none"
    });
});