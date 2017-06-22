/**
 * Created by Administrator on 2016/3/21.
 */
//消息中心
$(".member_list").on("click",function(){
    $(".member_list").removeClass("active");
    var indexVal = $(this).index();
    $(this).addClass("active");
    $(".member_show").eq(indexVal).css({
        display: "block"
    }).siblings().css({
        display: "none"
    });
    $(".news_show").eq(0).css({
        display: "block"
    }).siblings().css({
        display: "none"
    });
    $(".info_show").eq(0).css({
        display: "block"
    }).siblings().css({
        display: "none"
    });
    $(".user_show").eq(0).css({
        display: "block"
    }).siblings().css({
        display: "none"
    });
});
$(".news_type").on("click",function(){
    $(".news_type").find("span").removeClass("active");
    var indexVal = $(this).index();
    $(this).find("span").addClass("active");
    $(".news_show").eq(indexVal).css({
        display: "block"
    }).siblings().css({
        display: "none"
    });
});

//我的资料
$(".info_replay a").on("click",function(){
    $(".info_show").eq(0).css({
        display: "none"
    }).siblings().css({
        display: "block"
    });
    $(this).parent().css({
        display: "none"
    });
});
$(".my_info_btn").on("click",function(){
    $(".info_replay").css({
        display: "block"
    });
});

//取消
$(".replay_btn .cancel_btn").on("click",function(){
    $(this).parents(".info_show").css({
        display: "none"
    }).siblings().css({
        display: "block"
    });
    $(".info_replay").css({
        display: "block"
    });
});
//
$(".replay_btn .save_info").on("click",function(){
    var userName = $(".userName").val();
    var telNum = $(".telNum").val();
    var emailNum = $(".emailNum").val();
    var qqNum = $(".qqNum").val();
    $(this).parents(".info_show").css({
        display: "none"
    }).siblings().css({
        display: "block"
    });
    $(".info_replay").css({
        display: "block"
    });
});

//我的订单
//完善资料
$(".complete_info").on("click",function(){
    $(this).parents(".member_show").css({
        display: "none"
    });
    $(".my_info").parent().css({
        display: "block"
    });
    $(".info_show").eq(0).css({
        display: "none"
    });
    $(".info_show").eq(1).css({
        display: "block"
    });
    $(".member_list").removeClass("active");
    $(".member_list").eq(1).addClass("active");
});
//取消
$(".operate .cancel_btn").on("click",function(){
    $(".gap").css({
        display: "block"
    });
    $(".cancel_main").css({
     display: "block"
    });
});
//取消弹框——关闭
$(".order_cancel_head .cancel_btn").on("click",function(){
    $(".gap").css({
        display: "none"
    });
    $(".cancel_main").css({
        display: "none"
    });
    $(".pay_now").css({
        display: "none"
    });
});
//取消弹框——取消订单
$(".order_btn .cancel_order_btn").on("click",function(){
    $(".gap").css({
        display: "none"
    });
    $(".cancel_main").css({
        display: "none"
    });
});
//取消弹框——再想想
$(".order_btn .think_more_btn").on("click",function(){
    $(".gap").css({
        display: "none"
    });
    $(".cancel_main").css({
        display: "none"
    });
});
//取消弹框——原因选择
$(".reason_list img").on("click",function(){
    $(".reason_list img").attr("src","../images/choice1.png");
    $(this).attr("src","../images/choice2.png");
});
//立即付款
$(".pay_now_btn").on("click",function(){
    $(".gap").css({
        display: "block"
    });
    $(".pay_now").css({
        display: "block"
    });
});
//联系客服
$(".contact_service").on("click",function(){
    $(".gap").css({
        display: "block"
    });
    $(".service_gap").css({
        display: "block"
    });
});
//我的客服
$(".my_service").on("click",function(){
    $(".gap").css({
        display: "block"
    });
    $(".service_gap").css({
        display: "block"
    });
});
$(".cancel_btn_pic .cancel_btn").on("click",function(){
    $(".gap").css({
        display: "none"
    });
    $(".service_gap").css({
        display: "none"
    });
});

//账户管理
//更换手机
$(".replace_tel_btn").on("click",function(){
    $(".user_show").css({
        display: "none"
    });
    $(".replace_tel_main").css({
        display: "block"
    });
});
$(".tel_sure_btn").on("click",function(){
    $(".user_show").css({
        display: "none"
    });
    $(".user_info_main").css({
        display: "block"
    });
});
//修改密码
$(".replace_psd_btn").on("click",function(){
    $(".user_show").css({
        display: "none"
    });
    $(".replace_psd_main").css({
        display: "block"
    });
});
$(".psd_sure_btn").on("click",function(){
    $(".user_show").css({
        display: "none"
    });
    $(".user_info_main").css({
        display: "block"
    });
});
$(".replace_tel_pic .cancel_btn").on("click",function(){
    $(".user_show").css({
        display: "none"
    });
    $(".user_info_main").css({
        display: "block"
    });
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