package west.util;


import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.domain.BizResult;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;



public class SendMsg_webchinese {
	private static Logger logger = Logger.getLogger(SendMsg_webchinese.class);
		/**
		 * @Title: sendMsg
		 * @Description: 阿里大鱼短信发送
		 * @author BianMingZhou
		 * @date 2015-12-22 下午6:12:38
		 * @param @param content
		 * @param @param phoneNumber
		 * @param @param type 模版类型 1用户注册验证码SMS_7795680 
		 * @param @return
		 * @param @throws Exception 
		 * @return String -4号码不正确  >0发送短信数量 -1短信发送异常
		 * @throws
		 */
		public static String sendMsg(String content,String phoneNumber,int type)
				throws Exception {
		//	TaobaoClient client = new DefaultTaobaoClient("http://gw.api.taobao.com/router/rest","23287683","7484ad6f3a3698acb79ef12cdc093277");
			TaobaoClient client = new DefaultTaobaoClient("http://gw.api.taobao.com/router/rest","23346725","617a1d5568b3707eefac811c4821fb6a");
			AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
			//req.setExtend("");//公共回传参数，在“消息返回”中会透传回该参数；举例：用户可以传入自己下级的会员ID，在消息返回时，该会员ID会包含在内，用户可以根据该会员ID识别是哪位会员使用了你的应用 
			req.setSmsType("normal");
			req.setRecNum(phoneNumber);
			if(content!=null&&!"".equals(content.trim())){
				if(type==1){
					req.setSmsFreeSignName("注册验证");
					req.setSmsParamString("{\"code\":\""+content+"\",\"product\":\"westinno\"}");
					req.setSmsTemplateCode("SMS_7795680");
				}else if(type==2){
					
				}
				AlibabaAliqinFcSmsNumSendResponse rsp = client.execute(req);
		         		
				BizResult result=rsp.getResult();
				String bodystr=rsp.getBody();
				
				String responseStr=new String(bodystr.getBytes("gbk"));
				
				if(result!=null){
					if(result.getSuccess()){//成功
					   return "1";	
					}else{
						logger.error("短信发送失败"+responseStr);
						return "-1";
					}
				}else{
					//http://open.taobao.com/apitools/errorCodeSearch?spm=0.0.0.0.fNPfev   异常查询
					//短信发送异常
					JSONObject jo=JSONObject.fromObject(responseStr);
					JSONObject json=jo.getJSONObject("error_response");
					if(json.getInt("code")==15&&json.getString("sub_code").equalsIgnoreCase("isv.MOBILE_NUMBER_ILLEGAL")){
						
						return "-4";
					}
					logger.error("短信发送异常"+responseStr);
					
					return "-1";
				}
			}else{
				return "-1";
			}
		}
		public static void main(String[] args) {
			try {
				String str=SendMsg_webchinese.sendMsg("123456","15802861658",1);
				System.out.println(str);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

}

