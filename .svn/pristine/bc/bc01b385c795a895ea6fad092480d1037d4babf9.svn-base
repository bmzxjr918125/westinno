/**
 * Created by Administrator on 2016/3/18.
 */
$(".two_dimension").hover(
    function(){
        $(".two_dimension_gap").css({
            display: "block"
        });
    },function(){
        $(".two_dimension_gap").css({
            display: "none"
        });
    }
);

/**              
 * 时间戳转换日期              
 * @param <int> unixTime    待时间戳(秒)              
 * @param <bool> isFull    返回完整时间(Y-m-d 或者 Y-m-d H:i:s)              
 * @param <int>  timeZone   时区              
 */
 function UnixToDate(unixTime, isFull, timeZone) {
 	if(unixTime==null){
 		return "";
 	}else{
 	
   // if (typeof (timeZone) == 'number')
   // {
        unixTime = parseInt(unixTime) + 28800000;//东8区时间偏移量为28800000毫秒
   // }
    var time = new Date(unixTime);
    var ymdhis = "";
    ymdhis += time.getUTCFullYear() + "-";
    ymdhis += (time.getUTCMonth()+1) + "-";
    ymdhis += time.getUTCDate();
    if (isFull == true)
    {
        ymdhis += " " + time.getUTCHours() + ":";
        ymdhis += time.getUTCMinutes() + ":";
        ymdhis += time.getUTCSeconds();
    }
    return ymdhis;
	
 	}
}
 
 /**
  * 新闻详细查看跳转
  * @param news_id
  */
 function showNewsInfo(news_id){
     
     location.href="newsLook-"+news_id+".html";
  
  }
 /**
  * head菜单选中状态
  */
 function choiceTop(tag){
	 $(".bar_bank a").removeClass("active");
	 $("#tag_"+tag).addClass("active");
	 
 }
 /**
  *  提交订单商品参数
  * @param id
  * @param number
  * @returns {Product}
  */
 function Product(id,number){
		this.id=id;
		this.number=number;
		return this;
	}
 
 