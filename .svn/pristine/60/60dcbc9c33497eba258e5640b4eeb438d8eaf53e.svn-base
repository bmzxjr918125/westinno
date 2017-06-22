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
    $(this).addClass("active").siblings().removeClass("active");
});

$(".type_bar_list").on("click",function(){
    $(".type_bar_list").find("span").removeClass("active");
    $(this).find("span").addClass("active");
});

//类型选择
$(".choice_list").on("click",function(){
    $(this).addClass("active").siblings().removeClass("active");
});

//收藏
$(".collect").live("click",function(){
    $(".collect").css({
        backgroundColor: "#f2f2f2"
    });
    $(".collect_pic img").attr("src","../images/y_star.png");
    $(".collect p").text("取消").css({
        color: "#cccccc"
    });
    $(this).addClass("collect_ed").removeClass("collect");
});
//取消收藏
$(".collect_ed").live("click",function(){
    $(".collect_ed").css({
        backgroundColor: "#ff9900"
    });
    $(".collect_pic img").attr("src","../images/w_star.png");
    $(".collect_ed p").text("收藏").css({
        color: "#ffffff"
    });
    $(this).addClass("collect").removeClass("collect_ed");
});

$(document).ready(function(){
    var doc=document,inputs=doc.getElementsByTagName('input'),supportPlaceholder='placeholder'in doc.createElement('input'),placeholder=function(input){var text=input.getAttribute('placeholder'),defaultValue=input.defaultValue;
        if(defaultValue==''){
            input.value=text}
        input.onfocus=function(){
            if(input.value===text){this.value=''}};
        input.onblur=function(){if(input.value===''){this.value=text}}};
    if(!supportPlaceholder){
        for(var i=0,len=inputs.length;i<len;i++){var input=inputs[i],text=input.getAttribute('placeholder');
            if(input.type==='text'&&text){placeholder(input)}}}});