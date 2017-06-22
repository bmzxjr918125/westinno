/**
 * Created by Administrator on 2015/5/4.
 */
$(".agency_type ul li").on("click",function(){
    var agencyIndex = $(this).index();
    $(".move_line").stop().animate({
        left: 107*agencyIndex+"px"
    },200);
    $(".agency_dic_list").eq(agencyIndex).addClass("dic_current").siblings().removeClass("dic_current");
});

$(".agency_type ul li").on("click",function(){
	$(".agency_type ul li").removeClass("active");
	$(this).addClass("active");
});
$(".company_type_list").on("click",function(){
	$(".company_type_list input").removeClass("choice_yes");
	$(this).find("input").addClass("choice_yes");
});

function submitApply(){
	var agent = 0;
	var com_type = 0;
	var agent_type = $(".active span").text();
	if (agent_type=="渠道代理") {
		agent = 1;
	}else if (agent_type=="高级代理") {
		agent = 2;
	}else if (agent_type=="区县代理") {
		agent = 3;
	}else if (agent_type=="行业代理") {
		agent = 4;
	}
	var company_type = $(".choice_yes").next().text();
	if (company_type == "个人") {
		com_type = 1;
	}else if (company_type == "公司") {
		com_type = 2;
	}
	var name = $("#apply_name").val();
	var tel = $("#apply_tel").val();
	var apply_excuse = $("#apply_excuse").val();
	if (name=='' || tel=='' || apply_excuse=='') {
		alert("请填写完整信息");
		return false;
	}
	var param = agent+","+com_type+","+name+","+tel+","+apply_excuse;
	var url="http://192.168.2.110:8080/llms/tmg/applysave?param="+param;
	$.ajax({
        type: 'GET', 
        contentType: 'application/json', 
        url: url, 
        data: '',   
        dataType: 'json', 
        success: function(json) {
        	if (json.result == true) {
				alert("申请成功");
				$("#apply_name").val("");
				$("#apply_tel").val("");
				$("#apply_excuse").val("");
			}
        }
	});
}

