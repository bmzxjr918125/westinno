var xmlHttpRequest = null;
 //判断是否IE
if(window.ActiveXObject){
//如果是IE
xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
} else if(window.XMLHttpRequest){
//非IE
xmlHttpRequest = new XMLHttpRequest();
}
   /**
    * AJAX清除notify的session
    */
   function clearNotify(){//
	  if(null!= xmlHttpRequest){		
			xmlHttpRequest.open("GET", "manage/adminClearNotify.action", true);
			xmlHttpRequest.onreadystatechange =  function (){
				if(xmlHttpRequest.readyState == 4){
					if(xmlHttpRequest.status == 200){
					//alert("session清除成功！");
						// alert(12312);
						var state=xmlHttpRequest.responseText;
						//alert(state);
						
					}
				}
			};
			xmlHttpRequest.send(null);	
			}}

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
    * AJAX删除药品图片
    * @param obj 
    * @param imagePath 图片路径
    * @param medicineId 药品Id
    */
    	function deleteMedicineImage(obj,imagePath,medicineId){
    		var imageSize=jQuery("#currentImagesize").val();
    		if(imageSize==1){
    			Ajalert("当前为最后一张图片不能删除，可以先进行添加再删除该图！","提示");
    			return false;
    		}
    		jConfirm("删除图片将不可逆，确定删除？","系统提示",function(result){
    			if(!result){
    				return false;
    			}else{
    	    		 if(null!= xmlHttpRequest){		
    	    				xmlHttpRequest.open("GET", "tmg/medicineDeleteImage?id="+medicineId+"&imagePath="+imagePath, true);
    	    				xmlHttpRequest.onreadystatechange =  function (){
    	    					if(xmlHttpRequest.readyState == 4){
    	    						if(xmlHttpRequest.status == 200){
    	    							var state=xmlHttpRequest.responseText;
    	    							if(state==0){
    	    								obj.parentNode.parentNode.removeChild(obj.parentNode);
    	    							
    	    									document.getElementById("currentImagesize").value=imageSize-1;
    	    								
    	    							}else{
    	    							  jAlert("删除异常，请刷新重试！","提示");	
    	    							}
    	    						}
    	    					}
    	    				};
    	    				xmlHttpRequest.send(null);	
    	    				}
    			}
    		});
    	
    	
    		
    		
    	}
    	
    	/**
    	 * AJAX删除药品信息
    	 * ch:table中所有的复选框
    	 */
    	function deleteMedicine(ids){
    		  var result=false;
           jConfirm("确定删除这些药品信息，删除将不可逆！","系统提示",function(r){
        	   if(!r){
        		   return false;
        	   }else{
           		if(null!= xmlHttpRequest){		
           			xmlHttpRequest.open("GET", "tmg/medicineDelete?ids="+ids,false);//false表示同步
           			xmlHttpRequest.onreadystatechange =  function (){
           				if(xmlHttpRequest.readyState == 4){
           					if(xmlHttpRequest.status == 200){
           						var state1=xmlHttpRequest.responseText;
           						 var state = eval("(" + state1 + ")");
           						if(state.isSuccess==0){
           							result=true;

        							var ch = jQuery('#medicinetable').find('tbody input[type=checkbox]');	
        							
        							ch.each(function(){
           								if(jQuery(this).is(':checked')) {
           									jQuery(this).parents('tr').fadeOut(function(){
           										jQuery(this).remove();								//remove row when animation is finished
           									});
           								}
           							});
           							
           						}else{
           							jAlert("删除异常，->"+state.name+"<-该药品正在被部分商家使用，不能删除！","提示");	
           							result=false;
           						}
           					}
           				}
           			};
           			
           			xmlHttpRequest.send(null);	
           		} 
           		return result;
        	   }
           });
    	}
    
    
    
    	/**
    	 * AJAX删除保健品图片
    	 * @param obj 
    	 * @param imagePath 图片路径
    	 * @param medicineId 药品Id
    	 */
    	function deleteHealthcareImage(obj,imagePath,healthcareId){
    		var imageSize=jQuery("#currentImagesize").val();
    		if(imageSize==1){
    			jAlert("当前为最后一张图片不能删除，可以先进行添加再删除该图！","提示");
    			return false;
    		}
    	jConfirm("删除图片将不可逆，确定删除？","系统提示",function(result){
    		if(!result){
    			return false;
    		}else{
    			if(null!= xmlHttpRequest){		
        			xmlHttpRequest.open("GET", "tmg/healthcareDeleteImage?id="+healthcareId+"&imagePath="+imagePath, true);
        			xmlHttpRequest.onreadystatechange =  function (){
        				if(xmlHttpRequest.readyState == 4){
        					if(xmlHttpRequest.status == 200){
        						var state=xmlHttpRequest.responseText;
        						if(state==0){
        							obj.parentNode.parentNode.removeChild(obj.parentNode);
        							
        							document.getElementById("currentImagesize").value=imageSize-1;
        							
        						}else{
        							alert("删除异常，请刷新重试！");	
        						}
        					}
        				}
        			};
        			xmlHttpRequest.send(null);	
        		}
    		}
    	});
    	}
     
    	/**
    	 * AJAX删除保健品信息
    	 */
    	function deleteHealthcare(ids){
    		  var result=false;
            jConfirm("确定删除这些保健品信息，删除将不可逆！","系统提示",function(r){
            	if(!r){
            		
            	}else{
            		if(null!= xmlHttpRequest){		
            			xmlHttpRequest.open("GET", "tmg/healthcareDelete?ids="+ids,false);//false表示同步
            			xmlHttpRequest.onreadystatechange =  function (){
            				if(xmlHttpRequest.readyState == 4){
            					if(xmlHttpRequest.status == 200){
            						
            						var state1=xmlHttpRequest.responseText;
            						 var state = eval("(" + state1 + ")");
            						if(state.isSuccess==0){
            							result=true;
            						
            							var ch = jQuery('#healthcaretable').find('tbody input[type=checkbox]');	
            							
            							ch.each(function(){
               								if(jQuery(this).is(':checked')) {
               									jQuery(this).parents('tr').fadeOut(function(){
               										jQuery(this).remove();								//remove row when animation is finished
               									});
               								}
               							});
            						
            						}else{
            							
            							jAlert("删除异常，->"+state.name+"<-该保健品正在被部分商家使用，不能删除！","提示");	
            							result=false;
            						}
            					}
            				}
            			};
            			
            			xmlHttpRequest.send(null);	
            		}
            		return result;
            	}
            });
    	}
    	
    	
    
    	/**
    	 * AJAX导出系统数据库数据
    	 */
    	function databankDaochu(){
    		
    		jConfirm('导出数据需花费一点点时间，请耐心等待！', '系统提示',function(result){
    			if(!result){
    				return false;
    			}else{
    				if(null!= xmlHttpRequest){	
    	    			
    	    			xmlHttpRequest.open("GET", "tmg/sysInfodaochu",true);//false表示同步
    	    			xmlHttpRequest.onreadystatechange =  function (){
    	    				if(xmlHttpRequest.readyState == 4){
    	    					if(xmlHttpRequest.status == 200){
    	    						var state=xmlHttpRequest.responseText;
    	    						if(state==0){
    	    							window.location.href="tmg/sysInfoxiazai.action";
    	    						}else{
    	    							jAlert("导出异常，请联系管理员！","提示");	
    	    						}
    	    					}
    	    				}
    	    			};
    	    			
    	    			xmlHttpRequest.send(null);	
    	    		}
    			}
    		});
    		
    		
    	}
    	
    	/**
    	 * 删除启动图片
    	 */
    function 	clientSplashDelete(id){
    	 jConfirm("确定删除，删除将不可逆！","系统提示",function(r){
         	if(!r){
         		
         	}else{
         		if(null!= xmlHttpRequest){		
         			xmlHttpRequest.open("GET", "tmg/clientSplashDelete?id="+id,true);//false表示同步
         			xmlHttpRequest.onreadystatechange =  function (){
         				if(xmlHttpRequest.readyState == 4){
         					if(xmlHttpRequest.status == 200){
         						
         						var state1=xmlHttpRequest.responseText;
         						 var state = eval("(" + state1 + ")");
         						if(state.isSuccess==0){
         							location.href="tmg/clientSplashShow";
         						}else{
         							jAlert("删除异常！","提示");	
         						}
         					}
         				}
         			};
         			
         			xmlHttpRequest.send(null);	
         		}
         	}
         });
    	
    	
    }
    	