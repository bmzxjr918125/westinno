package west.html.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.pingplusplus.Pingpp;
import com.pingplusplus.exception.PingppException;
import com.pingplusplus.model.Charge;

import west.base.action.BaseAction;
import west.entity.We_Order;
import west.entity.We_Order_Team;
import west.entity.We_Product;
import west.entity.We_Product_Car;
import west.entity.We_Product_Collect;
import west.entity.We_Product_Type_One;
import west.entity.We_Product_Type_Two;
import west.entity.We_User;
import west.service.We_OrderService;
import west.service.We_Order_TeamService;
import west.service.We_ProductService;
import west.service.We_Product_CarService;
import west.service.We_Product_CollectService;
import west.service.We_Product_Type_OneService;
import west.service.We_Product_Type_TwoService;
import west.service.We_UserService;
import west.util.Config;
import west.util.OrderUtil;
import west.util.RequestUtils;

/**
 * 商品页面action
 * @ClassName: HtmlProductAction
 * @Description: TODO
 * @author BianMingZhou
 * @date 2016-3-30 下午8:04:37
 */
@Controller("htmlProductAction")
@Scope("prototype")
public class HtmlProductAction extends BaseAction{
	private static final long serialVersionUID = 2860243697328647346L;
	private JSONObject jsonData;
    private static Logger logger = Logger.getLogger(HtmlProductAction.class);
    private We_ProductService we_ProductService;
    private We_Product_Type_OneService we_Product_Type_OneService;
    private We_Product_Type_TwoService we_Product_Type_TwoService;
    private We_Product_CollectService we_Product_CollectService;
    private We_OrderService we_OrderService;
    private We_Product_CarService we_Product_CarService;
    private We_UserService we_UserService;
    private int flag;
    private Charge charge;
    
    /**
     * 跳转商品显示页面
     * @Title: Show
     * @Description: TODO
     * @author BianMingZhou
     * @date 2016-3-31 下午2:59:46
     * @param @return 
     * @return String 
     * @throws
     */
    public String Show(){
    	flag=RequestUtils.getIntParamter("flag");
    	jsonData=new JSONObject();
    	List<We_Product_Type_One> oneList=we_Product_Type_OneService.getByName("flag",flag);
    	jsonData.put("oneList",oneList);
    	return "Show";
    }
    /**
     *  根据各种类型1获取其他类型
     * @Title: GetTypeOne
     * @Description: TODO
     * @author BianMingZhou
     * @date 2016-3-31 下午2:59:30
     * @param  
     * @return void 
     * @throws
     */
    public void GetByTypeOne() throws Exception{
    	response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");// 解决中文乱码问题
		PrintWriter out = response.getWriter();
    	try{
    		jsonData = new JSONObject();
    	    int type_one= RequestUtils.getIntParamter("type_one");
    	    //int flag= RequestUtils.getIntParamter("flag");
    	    List<We_Product_Type_Two> twoList=we_Product_Type_TwoService.getByName("type_one_id.id",type_one);
    	    jsonData.put("twoList", twoList);
    	    jsonData.put("response","success");
    		
    	}catch (Exception e) {
    		jsonData.put("response","error");
    		jsonData.put("msg","请求异常");
    		logger.error("根据类型获取商品数据异常："+e.getMessage());
    		e.printStackTrace();
		}
		out.write(jsonData.toString());
		out.flush();
		out.close();
    }
    /**
     *  根据各种类型获取商品数据
     * @Title: GetByType
     * @Description: TODO
     * @author BianMingZhou
     * @date 2016-3-31 下午2:59:30
     * @param  
     * @return void 
     * @throws
     */
    public void GetByType() throws Exception{
    	response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");// 解决中文乱码问题
		PrintWriter out = response.getWriter();
    	try{
    		jsonData = new JSONObject();
    	    int type_one= RequestUtils.getIntParamter("type_one");
    	    int type_two1= RequestUtils.getIntParamter("type_two1");
    	    int type_two2= RequestUtils.getIntParamter("type_two2");
    	    int type_two3= RequestUtils.getIntParamter("type_two3");
    	    //int flag= RequestUtils.getIntParamter("flag");
    	   We_Product product= we_ProductService.getByType(type_one,type_two1,type_two2,type_two3);
    		if(product!=null){
    			 jsonData.put("product",product);
    			 //获取收藏状态
    			 if(request.getSession().getAttribute("USER")!=null){
    				 boolean result= we_Product_CollectService.getIsCollect(product.getId(),((We_User)(request.getSession().getAttribute("USER"))).getId());
    				 jsonData.put("isCollect", result);
    				 jsonData.put("isLogin", true);
    			 }else{
    				 jsonData.put("isCollect", false);
    				 jsonData.put("isLogin", false);
    			 }
    			
    			 jsonData.put("response","success");
    		}else{
    			jsonData.put("response","error");
        		jsonData.put("msg","无该种组合，请重新选择组合");
    		}
    	}catch (Exception e) {
    		jsonData.put("response","error");
    		jsonData.put("msg","请求异常");
    		logger.error("根据类型获取商品数据异常："+e.getMessage());
    		e.printStackTrace();
		}
		out.write(jsonData.toString());
		out.flush();
		out.close();
    }
    /**
     * 商品收藏或取消
     * @Title: CollectSave
     * @Description: TODO
     * @author BianMingZhou
     * @date 2016-4-1 上午10:37:44
     * @param  collect_status 0 取消 1收藏 
     * @return void 
     * @throws
     */
    public void CollectSave() throws Exception{
    	response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");// 解决中文乱码问题
		PrintWriter out = response.getWriter();
    	try{
    		jsonData = new JSONObject();
    	    int product_id= RequestUtils.getIntParamter("product_id");
    	    int collect_status= RequestUtils.getIntParamter("collect_status");
    	   We_User user= (We_User) request.getSession().getAttribute("USER"); 
    	    if(collect_status==1){
    	    	 boolean result=we_Product_CollectService.getIsCollect(product_id, user.getId());
    	    	 if(result){
    	    			jsonData.put("response","error");
    	        		jsonData.put("msg","已收藏过该商品");
    	    		}else{
    	    			We_Product_Collect collect=new We_Product_Collect();
            			
            			collect.setCreattime(new Date());
            			collect.setProduct_id(we_ProductService.getById(product_id));
            			collect.setUser_id(user);
            			we_Product_CollectService.save(collect);
            			jsonData.put("response","success");
    	    		}
    	    }else{
    				we_Product_CollectService.delateByInt(product_id,user.getId());
    				jsonData.put("response","success");
    		}
    	}catch (Exception e) {
    		jsonData.put("response","error");
    		jsonData.put("msg","请求异常");
    		logger.error("根据类型获取商品数据异常："+e.getMessage());
    		e.printStackTrace();
		}
		out.write(jsonData.toString());
		out.flush();
		out.close();
    }
    
    /**
     * <p>Method Name : GetUserCollect</p>
     * <p>Method Desc : 获取用户收藏的数据</p>
     * <p>Date : 2016-4-13 上午10:22:02</p>
     * <p>Author : XQL</p>
     * @throws Exception
     */
    public void GetUserCollect() throws Exception{
    	response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");// 解决中文乱码问题
		PrintWriter out = response.getWriter();
		
		jsonData = new JSONObject();
	    int user_id = RequestUtils.getIntParamter("user_id");
    	List<We_Product_Collect> list = we_Product_CollectService.getByUser(user_id);
		jsonData.put("collectList", list);
			
		out.write(jsonData.toString());
		out.flush();
		out.close();
    }
    
    /**
     * 加入购物车
     * @Title: CarSave
     * @Description: TODO
     * @author BianMingZhou
     * @date 2016-4-1 下午4:37:01
     * @param @throws Exception 
     * post {"productList":[{"id":12,"number":1},{}]}
     * @return void 
     * @throws
     */
    public void CarSave() throws Exception{
    	response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");// 解决中文乱码问题
		PrintWriter out = response.getWriter();
    	try{
    		jsonData = new JSONObject();
    		//获取POST数据
    			BufferedReader br = new BufferedReader(new InputStreamReader(
    					request.getInputStream(), "UTF-8"));
    			String line = null;
    			StringBuilder sb = new StringBuilder();
    			while ((line = br.readLine()) != null) {
    				sb.append(line);
    			}
    			String productJson=  sb.toString();
    		
    	    We_User user= (We_User) request.getSession().getAttribute("USER"); 
    	    
    		we_Product_CarService.saveNew(productJson,user);
    		int car_num=we_Product_CarService.countByUserId(user.getId());
    		super.request.getSession().setAttribute("CAR_NUM", car_num);
    	     
    		jsonData.put("car_num",car_num);
    	    jsonData.put("response","success");
    	}catch (Exception e) {
    		jsonData.put("response","error");
    		jsonData.put("msg","请求异常");
    		logger.error("根据类型获取商品数据异常："+e.getMessage());
    		e.printStackTrace();
		}
		out.write(jsonData.toString());
		out.flush();
		out.close();
    }
    /**
     * 跳转订单提交页面
     * @Title: OrderAdd
     * @Description: TODO
     * @author BianMingZhou
     * @date 2016-4-13 下午2:41:54
     * @param @return 
     * @return String 
     * @throws
     */
    public String OrderAdd(){
    	int product_id=RequestUtils.getIntParamter("product_id");
    	int number=RequestUtils.getIntParamter("number");
    	jsonData=new JSONObject();
    	We_Product product=we_ProductService.getById(product_id);
    	/*if(product.getPrice()==0){
        	jsonData.put("totalprice","联系客户");
    	}else{
        	jsonData.put("totalprice",OrderUtil.showPrice(OrderUtil.mul(product.getPrice(), number),1));
    	}*/
  	      double totalprice=0.0;
  	      JSONArray ja=new JSONArray();
  		  JSONObject jo=new JSONObject();
  		  jo.put("name",product.getName());
  		  jo.put("unitprice",OrderUtil.showPrice(product.getPrice(),1));
  		  jo.put("numberprice",OrderUtil.showPrice(OrderUtil.mul(product.getPrice(), number),1));
  		  jo.put("number", number);
  		  jo.put("id", product.getId());
  		  totalprice=OrderUtil.add(totalprice, OrderUtil.mul(product.getPrice(), number));
  		  ja.add(jo);
  	  
  	      jsonData.put("productList", ja);
  	      jsonData.put("flag", 1);
  	      jsonData.put("product",product);
  	       jsonData.put("number", number);
    	
          jsonData.put("totalprice",OrderUtil.showPrice(totalprice,1));
	      return "OrderAdd";
    }
    
    /**
     * 加入订单
     * @Title: OrderSave
     * @Description: TODO
     * @author BianMingZhou
     * @date 2016-4-1 下午4:37:01
     * @param @throws Exception 
     * post {"productList":[{"id":12,"number":1},{}]}
     * @return void 
     * @throws
     */
    public void OrderSave() throws Exception{
    	response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");// 解决中文乱码问题
		PrintWriter out = response.getWriter();
    	try{
    		jsonData = new JSONObject();
    		//获取POST数据
			BufferedReader br = new BufferedReader(new InputStreamReader(
					request.getInputStream(), "UTF-8"));
			String line = null;
			StringBuilder sb = new StringBuilder();
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
			String productJson=  sb.toString();
    	    We_User user= (We_User) request.getSession().getAttribute("USER"); 
    	    
    		We_Order order=we_OrderService.saveNew(productJson,user);
    		if(user.getIs_complete()==0){//提示完善资料 跳转个人中心
    			jsonData.put("code",0);
    		}else{//弹框付款
    			jsonData.put("code",1);
    		}
    		
    		jsonData.put("order_id",order.getId());
    		jsonData.put("ordernum",order.getOrdernum());
    		
    		if(order.getPrice()==0){//联系客户 跳转个人中心
    			jsonData.put("code",2);
    		}
    		jsonData.put("totalprice",OrderUtil.showPrice(order.getPrice(),1));
    	    jsonData.put("response","success");
    	    
    	}catch (Exception e) {
    		jsonData.put("response","error");
    		jsonData.put("msg","请求异常");
    		logger.error("根据类型获取商品数据异常："+e.getMessage());
    		e.printStackTrace();
		}
		out.write(jsonData.toString());
		out.flush();
		out.close();
    }
    /**
     * 我的购物车显示
     * @Title: ShopCar
     * @Description: TODO
     * @author BianMingZhou
     * @date 2016-4-13 下午4:57:07
     * @param @return 
     * @return String 
     * @throws
     */
   public String ShopCar(){
	   We_User user= (We_User) request.getSession().getAttribute("USER");
	   
	  List<We_Product_Car> carList= we_Product_CarService.getByUserId(user.getId());
	   jsonData=new JSONObject();
	   jsonData.put("carList",carList);
	   double totalprice=0.0;
	   for(We_Product_Car car:carList){
		   totalprice=OrderUtil.add(totalprice, OrderUtil.mul(car.getProduct_id().getPrice(),car.getNumber()));
	   }
	   
	   jsonData.put("totalprice",totalprice);
	   return "ShopCar";
   }
    
   public String CarDelete(){
	   We_User user= (We_User) request.getSession().getAttribute("USER");
	  int id=  RequestUtils.getIntParamter("car_id");  
	  we_Product_CarService.deleteById(id);
	  int car_num=we_Product_CarService.countByUserId(user.getId());
      super.request.getSession().setAttribute("CAR_NUM", car_num);
	   return "CarDelete";
   }
   /**
    * 购物车数量改变
    * @Title: CarChangeNumber
    * @Description: TODO
    * @author BianMingZhou
    * @date 2016-4-14 下午3:48:02
    * @param @throws Exception 
    * @return void 
    * @throws
    */
   public void CarChangeNumber() throws Exception{
   	    response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");// 解决中文乱码问题
		PrintWriter out = response.getWriter();
   	try{
   		jsonData = new JSONObject();
   	    int car_id=RequestUtils.getIntParamter("car_id");
   	    int type=RequestUtils.getIntParamter("type");
   	    if(type==2){
   	    	type=-1;
   	    }
   	    We_Product_Car car=we_Product_CarService.getById(car_id);
   	    
   	    if((car.getNumber()+type)>0){
   	    	car.setNumber(car.getNumber()+type);
   	    	we_Product_CarService.saveOrUpdate(car);
   	    	
   	    	
   	    	jsonData.put("number",car.getNumber());
   	    	
   	     
   	   	    We_User user= (We_User) request.getSession().getAttribute("USER"); 
   	   	    
   	   	    List<We_Product_Car> carList= we_Product_CarService.getByUserId(user.getId());
   		  
   		    double totalprice=0.0;
   		    for(We_Product_Car car1:carList){
   			   totalprice=OrderUtil.add(totalprice, OrderUtil.mul(car1.getProduct_id().getPrice(),car1.getNumber()));
   		    }
   		    jsonData.put("numberprice",OrderUtil.showPrice(OrderUtil.mul(car.getProduct_id().getPrice(),car.getNumber()), 1));
   		    jsonData.put("totalprice",OrderUtil.showPrice(totalprice, 1));
   	    	jsonData.put("response","success");
   	    }else{
   	    	jsonData.put("response","error");
   	   		jsonData.put("msg","当前数量不正确");
   	    }
   	}catch (Exception e) {
   		jsonData.put("response","error");
   		jsonData.put("msg","请求异常");
   		logger.error("改变购物车数量数据异常："+e.getMessage());
   		e.printStackTrace();
		}
		out.write(jsonData.toString());
		out.flush();
		out.close();
   }
   /**
    * 购物车跳转订单提交页面
    * @Title: OrderAdd
    * @Description: TODO
    * @author BianMingZhou
    * @date 2016-4-13 下午2:41:54
    * @param @return 
    * @return String 
    * @throws
    */
   public String CarToOrderAdd(){
   	  jsonData=new JSONObject();
   	  We_User user= (We_User) request.getSession().getAttribute("USER"); 
  	  List<We_Product_Car> carList= we_Product_CarService.getByUserId(user.getId());
	  double totalprice=0.0;
	  JSONArray ja=new JSONArray();
	  for(We_Product_Car car:carList){
		  JSONObject jo=new JSONObject();
		  jo.put("name", car.getProduct_id().getName());
		  jo.put("unitprice",OrderUtil.showPrice(car.getProduct_id().getPrice(),1));
		  jo.put("numberprice",OrderUtil.showPrice(OrderUtil.mul(car.getProduct_id().getPrice(), car.getNumber()),1));
		  jo.put("number", car.getNumber());
		  jo.put("id", car.getId());
		  totalprice=OrderUtil.add(totalprice, OrderUtil.mul(car.getProduct_id().getPrice(), car.getNumber()));
		  ja.add(jo);
	  }
	  jsonData.put("productList", ja);
      jsonData.put("totalprice",OrderUtil.showPrice(totalprice,1));
      jsonData.put("flag",2);
	  return "OrderAdd";
   }
   
   public String CarOrderSure(){
	   We_User user= (We_User) request.getSession().getAttribute("USER"); 
	   List<We_Product_Car> carList= we_Product_CarService.getByUserId(user.getId());
	   JSONObject jo=new JSONObject();
	   JSONObject joo=new JSONObject();
	   
	   JSONArray ja=new JSONArray();
	   for(We_Product_Car car:carList){
			  jo=new JSONObject();
			  jo.put("number", car.getNumber());
			  jo.put("id", car.getProduct_id().getId());
			  ja.add(jo);
		  }
	   joo.put("productList", ja);
	   
	   we_OrderService.saveNew(joo.toString(),user);
	   
	   //删除购物车
	   
	   
	  return "CarOrderSure";
   }
    /**
     * <p>Method Name : GetUserOrder</p>
     * <p>Method Desc : 获取用户的订单信息</p>
     * <p>Date : 2016-4-13 下午3:23:22</p>
     * <p>Author : XQL</p>
     * @throws Exception
     */
    public void GetUserOrder() throws Exception{
    	response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");// 解决中文乱码问题
		PrintWriter out = response.getWriter();
		
		jsonData = new JSONObject();
	    int user_id = RequestUtils.getIntParamter("user_id");
	    String order_name = RequestUtils.getStrParamter("order_name");
	    int order_status = RequestUtils.getIntParamter("order_status");
	    String order_start = RequestUtils.getStrParamter("order_start");
	    String order_end = RequestUtils.getStrParamter("order_end");
	    
    	List<We_Order> list = we_OrderService.getByUser(user_id,order_name,order_status,order_start,order_end);
		jsonData.put("orderList", list);
			
		out.write(jsonData.toString());
		out.flush();
		out.close();
    }
    
    /**
     * 获取订单信息
     * @throws IOException
     */
    public void GetOrderInfo() throws IOException{
    	response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");// 解决中文乱码问题
		PrintWriter out = response.getWriter();
		jsonData = new JSONObject();
		int order_id = RequestUtils.getIntParamter("order_id");
		We_Order order = we_OrderService.getOrder(order_id);
		jsonData.put("order", order);
		out.write(jsonData.toString());
		out.flush();
		out.close();
    }
    
    /**
	 * 付款充值
	 */
	public String charge(){
		Pingpp.apiKey = Config.API_KEY;
    	charge = null;
    	String ip = OrderUtil.getIp(request);
    	int user_id = RequestUtils.getIntParamter("user_id");
    	int order_id = RequestUtils.getIntParamter("order_id");
    	We_User user = we_UserService.getById(user_id);
    	We_Order order = we_OrderService.getOrder(order_id);
    	if (user != null && order != null) {
    		 Map<String, Object> chargeMap = new HashMap<String, Object>();
	        //订单总金额, 单位为对应币种的最小货币单位，例如：人民币为分（如订单总金额为 1 元，此处请填 100）
	        chargeMap.put("amount",OrderUtil.mul(order.getPrice(), 100));
	        //三位 ISO 货币代码，目前仅支持人民币 cny
	        chargeMap.put("currency", "cny");
	        //元数据 用来判断支付类型 1.订单支付,2.钱包充值,3.保证金充值
	        Map<Object, Integer> metadata = new HashMap<Object, Integer>();
	        metadata.put("user_id", user.getId());
	        metadata.put("order_id", order.getId());
	        chargeMap.put("metadata", metadata);
	        //商品的标题，该参数最长为 32 个 Unicode 字符
	        chargeMap.put("subject", user.getNickname()+"支付订单"+order.getName());
	        //商品的描述信息，该参数最长为 128 个 Unicode 字符
	        chargeMap.put("body", user.getNickname()+"支付订单"+order.getName());
	        //发起支付请求终端的 IP 地址，格式为 IPV4，如: 127.0.0.1。
	        chargeMap.put("client_ip", ip);
	        //商户订单号，适配每个渠道对此参数的要求，必须在商户系统内唯一。
	        chargeMap.put("order_no", order.getOrdernum());
	        //支付使用的第三方支付渠道
	        //upacp:银联全渠道支付;upacp_wap:银联全渠道手机网页支付
	        chargeMap.put("channel", "alipay_pc_direct");
	        Map<String, String> app = new HashMap<String, String>();
	        app.put("id",Config.APP_ID);
	        chargeMap.put("app", app);
	        //特定渠道发起交易时需要的额外参数以及部分渠道支付成功返回的额外参数
	        Map<String, String> extra = new HashMap<String, String>();
	        extra.put("success_url", Config.chargeUrl+"memberCenter-2.html");
	        chargeMap.put("extra", extra);
	        try {
	            //发起交易请求
	            charge = Charge.create(chargeMap);
	            System.out.println(charge);
	        } catch (PingppException e) {
	            e.printStackTrace();
	        }
	        return "success";
		}else {
			return "error";
		}
	}
    
    /**
     * <p>Method Name : GetOrderTeam</p>
     * <p>Method Desc : 获取订单对应的客服</p>
     * <p>Date : 2016-4-13 下午3:23:22</p>
     * <p>Author : XQL</p>
     * @throws Exception
     */
    public void GetOrderTeam() throws Exception{
    	response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");// 解决中文乱码问题
		PrintWriter out = response.getWriter();
		
		jsonData = new JSONObject();
	    int order_id = RequestUtils.getIntParamter("order_id");
	    
	    We_Order_Team order_team = we_Order_TeamService.getOnly(order_id);
		jsonData.put("order_team", order_team);
			
		out.write(jsonData.toString());
		out.flush();
		out.close();
    }
    
	public We_ProductService getWe_ProductService() {
		return we_ProductService;
	}

	@Resource(name = "we_ProductService")
	public void setWe_ProductService(We_ProductService we_ProductService) {
		this.we_ProductService = we_ProductService;
	}

	public JSONObject getJsonData() {
		return jsonData;
	}

	public void setJsonData(JSONObject jsonData) {
		this.jsonData = jsonData;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public We_Product_Type_OneService getWe_Product_Type_OneService() {
		return we_Product_Type_OneService;
	}

	@Resource(name = "we_Product_Type_OneService")
	public void setWe_Product_Type_OneService(
			We_Product_Type_OneService we_Product_Type_OneService) {
		this.we_Product_Type_OneService = we_Product_Type_OneService;
	}

	public We_Product_Type_TwoService getWe_Product_Type_TwoService() {
		return we_Product_Type_TwoService;
	}

	@Resource(name = "we_Product_Type_TwoService")
	public void setWe_Product_Type_TwoService(
			We_Product_Type_TwoService we_Product_Type_TwoService) {
		this.we_Product_Type_TwoService = we_Product_Type_TwoService;
	}

	public We_Product_CollectService getWe_Product_CollectService() {
		return we_Product_CollectService;
	}

	@Resource(name = "we_Product_CollectService")
	public void setWe_Product_CollectService(
			We_Product_CollectService we_Product_CollectService) {
		this.we_Product_CollectService = we_Product_CollectService;
	}

	public We_OrderService getWe_OrderService() {
		return we_OrderService;
	}

	@Resource(name = "we_OrderService")
	public void setWe_OrderService(We_OrderService we_OrderService) {
		this.we_OrderService = we_OrderService;
	}

	public We_Product_CarService getWe_Product_CarService() {
		return we_Product_CarService;
	}

	@Resource(name = "we_Product_CarService")
	public void setWe_Product_CarService(
			We_Product_CarService we_Product_CarService) {
		this.we_Product_CarService = we_Product_CarService;
	}

	private We_Order_TeamService we_Order_TeamService;

	public We_Order_TeamService getWe_Order_TeamService() {
		return we_Order_TeamService;
	}

	@Resource(name = "we_Order_TeamService")
	public void setWe_Order_TeamService(
			We_Order_TeamService we_Order_TeamService) {
		this.we_Order_TeamService = we_Order_TeamService;
	}

	public We_UserService getWe_UserService() {
		return we_UserService;
	}

	@Resource(name = "we_UserService")
	public void setWe_UserService(We_UserService we_UserService) {
		this.we_UserService = we_UserService;
	}

	public Charge getCharge() {
		return charge;
	}

	public void setCharge(Charge charge) {
		this.charge = charge;
	}
	
}
