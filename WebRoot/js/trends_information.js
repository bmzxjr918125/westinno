/**
 * Created by Administrator on 2015/5/4.
 */
 $(function(){
    var screenHeight = $(window).height();
    $(".trends_content_show").css({
        minHeight: screenHeight-105-80-2+"px"
    });
});

 $(".trends_words_show_content p").css({
	fontFamily: "Verdana, Microsoft YaHei, Simsun"
 });

$(document).ready(function(){
urlinfo=window.location.href; //��ȡ��ǰҳ���url
len=urlinfo.length;//��ȡurl�ĳ���
offset=urlinfo.indexOf("?");//���ò����ַ�����ʼ��λ��
newsidinfo=urlinfo.substr(offset,len)//ȡ�������ַ��� ����������ơ�id=1���������ַ���
newsids=newsidinfo.split("=");//�Ի�õĲ����ַ������ա�=�����зָ�
newsid=newsids[1];//�õ�����ֵ
newsname=newsids[0];//�õ���������

if(newsname=='?pagenum'){
var id=newsid;
 ajaxGetDescData(id);
 
}

});








/**
 * ajax ���ظ��ඩ��
 */
function ajaxGetDescData(id){
	
	var url="http://www.ehuu.com/tmg/newsajaxGetDescData?id="+id;
	
	$.ajax({
        type: 'GET',   //��ʽ����
        contentType: 'application/json', 
        url: url, 
        data: '',  //������Ҫ���ݵĲ�������ʽΪ data: '{paraName:paraValue}',���潫�ῴ��       
        dataType: 'json',   //����Json����
        success: function(json) {
        	 
        	 var html="";
        	
        		 if(json.response=='success'){
        			 
        				
						 html=html+"<div class='trends_list'>"+
									"<div class='nav_left'>"+
										"<div class='move_piece'></div>"+
										"<span>"+json.createtime+"</span>"+
									"</div>"+
									"<div class='trends_list_content'>"+
										"<div class='trends_name'>"+json.title+"</div>"+
										"<div class='trends_date'>"+json.createtime+"</div>"+
										"<div class='trends_dic'>"+
										 "<div class='trends_words_show'>"+
											 "<div class='trends_words_show_content'>"+json.content+
											 "</div>"+
											 
											"</div>"+
										"</div>"+
								
										
									"</div>"+
								"</div>";
						 
        				 
        				 
						
					
        	        	 $('.trends_content_show').append(html);
						 $(".trends_words_show_content p").css({
							fontFamily: "Verdana, Microsoft YaHei, Simsun"
						 });
        		 }else{
        			 //��ȡ����ʧ��
        			 alert("��ȡ����ʧ��");
        			
        		 }
        	 }

	
    });
}