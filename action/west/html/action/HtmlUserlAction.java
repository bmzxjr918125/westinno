package west.html.action;





import java.io.PrintWriter;
import java.util.Date;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import west.base.action.BaseAction;
import west.entity.We_User;
import west.service.We_Product_CarService;
import west.service.We_UserService;
import west.util.Md5Utils;
import west.util.RequestUtils;
import west.util.SendMsg_webchinese;

@Controller("htmlUserAction")
@Scope("prototype")
public class HtmlUserlAction extends BaseAction{
	private static final long serialVersionUID = 4333225484822435247L;
	private JSONObject jsonData;
    private We_UserService we_UserService;
    private We_Product_CarService we_Product_CarService;
    private static Logger logger = Logger.getLogger(HtmlUserlAction.class);
	
    public String Register(){
    	
    	return "Register";
    }
    
    /**
     * 发送验证码
     * @Title: SendCode
     * @Description: TODO
     * @author BianMingZhou
     * @date 2016-3-25 下午2:04:16
     * @param  
     * @return void 
     * @throws
     */
    public void SendCode() throws Exception{
    	response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");// 解决中文乱码问题
		PrintWriter out = response.getWriter();
    	try{
    	String phoneNum= RequestUtils.getStrParamter("phoneNum");
    	jsonData=new JSONObject();
    	if(phoneNum!=null&&!"".equals(phoneNum.trim())){
              //检测手机号码唯一性   		
    		We_User we_User=we_UserService.getByPhoneNum(phoneNum);
    		if(we_User==null){
    			// 发送验证码
    			String code =((int)((Math.random() * (999999 - 100000) + 100000)))+"";
    			String smsResult = SendMsg_webchinese.sendMsg(code+"",phoneNum,1);
    			//String smsResult="1";
    			if (smsResult == "-4") {
    				jsonData.put("response", "error");
    				jsonData.put("msg", "手机号格式不正确");
    			} else if (Integer.parseInt(smsResult) > 0) {
    				if(request.getSession().getAttribute("phoneCode") != null) {
    					request.getSession().removeAttribute("phoneCode");
    				}
	    				//request.getSession().setMaxInactiveInterval(80);//80秒
	    				request.getSession().setAttribute("phoneCode", code);
	    				request.getSession().setAttribute("phoneNum", phoneNum);
	    				jsonData.put("response", "success");
    			} 
    		}else{
                jsonData.put("response","error");
                jsonData.put("msg","对不起该号码已被注册!");
    		}
    	}else{
    		jsonData.put("response","error");
    		jsonData.put("msg","请输入正确的手机号码");
    	}
    	}catch (Exception e) {
    		jsonData.put("response","error");
    		jsonData.put("msg","短信发送异常:"+e.getMessage());
    		logger.error("注册发送验证码短信发送异常:"+e.getMessage());
    		e.printStackTrace();
		}
    	out.write(jsonData.toString());
		out.flush();
		out.close();
    }
    
    public void RegisterSave() throws Exception{
    	response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");// 解决中文乱码问题
		PrintWriter out = response.getWriter();
    	try{
    		jsonData=new JSONObject();
    		String phoneNum=RequestUtils.getStrParamter("phoneNum");
    		String phoneCode=RequestUtils.getStrParamter("phoneCode");
    		String password=RequestUtils.getStrParamter("password");
    		if(phoneNum!=null&&!"".equals(phoneNum.trim())&&phoneCode!=null&&!"".equals(phoneCode.trim())&&password!=null&&!"".equals(password.trim())){
    			String sessionPhoneNum=(String) request.getSession().getAttribute("phoneNum");
    			String sessionPhoneCode=(String) request.getSession().getAttribute("phoneCode");
    			if(sessionPhoneNum!=null&&sessionPhoneNum.equals(phoneNum)){
    				  if(sessionPhoneCode!=null&&sessionPhoneCode.equals(phoneCode)){
    					int result=  we_UserService.register(phoneNum,password,1);
    					if(result>0){
    						//将用户信息存入session中
    						super.request.getSession().setAttribute("USER", we_UserService.getById(result));
    						jsonData.put("response","success");
    					}else{
    						if(result==-2){
    							jsonData.put("response","error");
          	    	            jsonData.put("msg","该手机号码已被注册");
    						}
    					}
    				  }else{
    					  jsonData.put("response","error");
    	    	          jsonData.put("msg","验证码错误");
    				  }
    			 }else{
    				 jsonData.put("response","error");
    	             jsonData.put("msg","请先进行手机号码验证码验证");
    			 }
    		}else{
    			jsonData.put("response","error");
        		jsonData.put("msg","请填写完整注册信息");
    		}
    	}catch (Exception e) {
    		jsonData.put("response","error");
    		jsonData.put("msg","注册保存异常:"+e.getMessage());
    		logger.error("注册保存时异常:"+e.getMessage());
    		e.printStackTrace();
		}
    	out.write(jsonData.toString());
		out.flush();
		out.close();
    }
    
    public String RegisterSuccess(){
    	//自动执行登录
    	
    	return "RegisterSuccess";
    }
    /**
     * 跳转登录页面
     * @Title: Login
     * @Description: TODO
     * @author BianMingZhou
     * @date 2016-3-29 上午10:48:09
     * @param @return 
     * @return String 
     * @throws
     */
    public String Login(){
    	
    	
    	return "Login";
    }
    public void LoginSave() throws Exception{

    	response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");// 解决中文乱码问题
		PrintWriter out = response.getWriter();
    	try{
    		jsonData=new JSONObject();
    		String phoneNum=RequestUtils.getStrParamter("phoneNum");
    		String password=RequestUtils.getStrParamter("password_m");
    		if(phoneNum!=null&&!"".equals(phoneNum.trim())&&password!=null&&!"".equals(password.trim())){
    			int user_id=we_UserService.loginSave(phoneNum,password);
    			if(user_id>0){
    				jsonData.put("response","success");
    				//购物车数量
    				int num=we_Product_CarService.countByUserId(user_id);
    				//将用户信息存入session中
					super.request.getSession().setAttribute("CAR_NUM", num);
    				
					super.request.getSession().setAttribute("USER", we_UserService.getById(user_id));
    			}else{
    				if(user_id==-1){
    					jsonData.put("response","error");
    	        		jsonData.put("msg","未找到该用户");
    				}else if(user_id==-2){
    					jsonData.put("response","error");
    	        		jsonData.put("msg","用户名密码不匹配");
    				}
    			}
    			
    		}else{
    			jsonData.put("response","error");
        		jsonData.put("msg","请填写完整登录信息");
    		}
    	}catch (Exception e) {
    		jsonData.put("response","error");
    		jsonData.put("msg","登录保存异常:"+e.getMessage());
    		logger.error("登录保存时异常:"+e.getMessage());
    		e.printStackTrace();
		}
    	out.write(jsonData.toString());
		out.flush();
		out.close();
    }
    /**
     * 已登录用户中心
     * @Title: MemberCenter
     * @Description: TODO
     * @author BianMingZhou
     * @date 2016-3-29 下午2:24:39
     * @param @return 
     * @return String 
     * @throws
     */
    public String MemberCenter(){
    	int flag=RequestUtils.getIntParamter("flag");
    	request.setAttribute("flag",flag);
    	return "MemberCenter";
    }
    
    
    /**
     * 用户退出登录
     * @Title: LoginOut
     * @Description: TODO
     * @author BianMingZhou
     * @date 2016-3-29 上午10:56:31
     * @param @return 
     * @return String 
     * @throws
     */
    public String LoginOut(){
    	super.request.getSession().removeAttribute("USER");
    	return "LoginOut";
    }
    
    
    /**
     *  修改用户信息，保存
     * @Title: UpdateSave
     * @Description: TODO
     * @author BianMingZhou
     * @date 2016-3-29 下午6:16:12
     * @param  
     * @return void 
     * @throws
     */
    public void UpdateSave() throws Exception{
    	response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");// 解决中文乱码问题
		PrintWriter out = response.getWriter();
    	try{
    		jsonData=new JSONObject();
    		String e_mail=RequestUtils.getStrParamter("e_mail");
    		int id=RequestUtils.getIntParamter("id");
    		String nickname=RequestUtils.getStrParamter("nickname");
    		String qq=RequestUtils.getStrParamter("qq");
    		int sex=RequestUtils.getIntParamter("sex");
    		if(sex==0){
    			sex=1;
    		}
    		if(e_mail!=null&&!"".equals(e_mail.trim())&&nickname!=null&&!"".equals(nickname.trim())){
    			We_User user=we_UserService.getById(id);
    			user.setUpdatetime(new Date());
    			user.setSex((byte)sex);
    			user.setNickname(nickname);
    			user.setQq(qq);
    			user.setE_mail(e_mail);
    			user.setIs_complete((byte)1);
    			we_UserService.saveOrUpdate(user);
    			//将用户信息存入session中
				super.request.getSession().setAttribute("USER",user);
				jsonData.put("response","success");
    		}else{
    			jsonData.put("response","error");
        		jsonData.put("msg","请填写完整个人必填信息");
    		}
    	}catch (Exception e) {
    		jsonData.put("response","error");
    		jsonData.put("msg","修改个人信息异常:"+e.getMessage());
    		logger.error("修改个人信息时异常:"+e.getMessage());
    		e.printStackTrace();
		}
    	out.write(jsonData.toString());
		out.flush();
		out.close();
    }
    
    /**
     * <p>Method Name : UpdatePhoneNum</p>
     * <p>Method Desc : 更新用户的手机号</p>
     * <p>Date : 2016-3-30 上午11:40:59</p>
     * <p>Author : XQL</p>
     */
    public void UpdatePhoneNum() throws Exception{
    	response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");// 解决中文乱码问题
		PrintWriter out = response.getWriter();
    	
    	String phoneNum= RequestUtils.getStrParamter("phoneNum");
    	String checkNum= RequestUtils.getStrParamter("checkNum");
    	jsonData=new JSONObject();
    	if(phoneNum != null && !"".equals(phoneNum.trim()) && checkNum != null && !"".equals(checkNum.trim())){
            //检测手机号码唯一性	
    		We_User we_User = we_UserService.getByPhoneNum(phoneNum);
    		if(we_User == null){
    			
    			String s_phoneCode = (String) request.getSession().getAttribute("phoneCode");
				String s_phoneNum = (String) request.getSession().getAttribute("phoneNum");
    			if(s_phoneCode.equals(checkNum) && s_phoneNum.equals(phoneNum)){
	    			We_User s_User = (We_User) request.getSession().getAttribute("USER");
	    			s_User.setPhonenum(phoneNum);
	    			s_User.setUpdatetime(new Date());
	    			we_UserService.saveOrUpdate(s_User);
	    			request.getSession().setAttribute("USER",s_User);
	    			jsonData.put("response","success");
    			}else{
    				 jsonData.put("response","error");
 	                jsonData.put("msg","请输入正确的手机号或验证码");
    			}
    		}else{
                jsonData.put("response","error");
                jsonData.put("msg","对不起该号码已被注册!");
    		}
    	}else{
    		jsonData.put("response","error");
    		jsonData.put("msg","手机号码或验证码不能为空");
    	}
    	
    	out.write(jsonData.toString());
		out.flush();
		out.close();
    }
    
    /**
     * <p>Method Name : SwitchPassword</p>
     * <p>Method Desc : 更换用户密码</p>
     * <p>Date : 2016-3-30 下午2:47:45</p>
     * <p>Author : XQL</p>
     * @throws Exception
     */
    public void SwitchPassword() throws Exception{
    	response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");// 解决中文乱码问题
		PrintWriter out = response.getWriter();
    	
    	String oldPass= RequestUtils.getStrParamter("oldPass");
    	String newPass= RequestUtils.getStrParamter("newPass");
    	String echoPass = RequestUtils.getStrParamter("echoPass");
    	
    	jsonData=new JSONObject();
    	if(!StringUtils.isEmpty(oldPass) && !StringUtils.isEmpty(newPass) && !StringUtils.isEmpty(echoPass)){
    		We_User s_User = (We_User) request.getSession().getAttribute("USER");
    		if(s_User != null){
    			if(s_User.getPassword().equals(Md5Utils.md5(oldPass.toUpperCase()))){
    				if(newPass.equals(echoPass)){
    					s_User.setPassword(Md5Utils.md5(newPass.toUpperCase()));
    					s_User.setUpdatetime(new Date());
    					we_UserService.saveOrUpdate(s_User);
    					request.getSession().setAttribute("USER",s_User);
    					jsonData.put("response","success");
    				}else{
    					jsonData.put("response","error");
                        jsonData.put("msg","两次密码不一样");
    				}
    			}else{
    				jsonData.put("response","error");
                    jsonData.put("msg","您之前的密码输入错误");
    			}
    		}else{
                jsonData.put("response","error");
                jsonData.put("msg","请重新登录");
    		}
    	}else{
    		jsonData.put("response","error");
    		jsonData.put("msg","请输入密码");
    	}
    	
    	out.write(jsonData.toString());
		out.flush();
		out.close();
    }

    
    
    public JSONObject getJsonData() {
		return jsonData;
	}
	public void setJsonData(JSONObject jsonData) {
		this.jsonData = jsonData;
	}
	public We_UserService getWe_UserService() {
		return we_UserService;
	}
	@Resource(name="we_UserService")
	public void setWe_UserService(We_UserService we_UserService) {
		this.we_UserService = we_UserService;
	}

	public We_Product_CarService getWe_Product_CarService() {
		return we_Product_CarService;
	}
    @Resource(name="we_Product_CarService")
	public void setWe_Product_CarService(We_Product_CarService we_Product_CarService) {
		this.we_Product_CarService = we_Product_CarService;
	}
  

}
