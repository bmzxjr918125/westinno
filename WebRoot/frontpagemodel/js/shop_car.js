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

$(".delete_btn").on("click",function(){
    $(this).parents(".shop_list").remove();
    var shop_listLength = $(".shop_list").length;
    if(shop_listLength <= 0){
        $(".shop_content").css({
            display: "none"
        });
    }
});
//去结账
$(".accounts_btn").on("click",function(){
    $(".gap").css({
        display: "block"
    });
    $(".register_soon_main").css({
     display: "block"
    });
});
//快速注册
$(".cancel_pic").on("click",function(){
    $(".gap").css({
        display: "none"
    });
    $(".register_soon_main").css({
        display: "none"
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