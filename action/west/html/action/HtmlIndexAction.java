package west.html.action;
import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import west.base.action.BaseAction;
import west.service.We_ProductService;
import west.util.RequestUtils;
/**
 * 首页action
 * @ClassName: HtmlIndexAction
 * @Description: TODO
 * @author BianMingZhou
 * @date 2016-3-30 下午8:04:04
 */
@Controller("htmlIndexAction")
@Scope("prototype")
public class HtmlIndexAction extends BaseAction{
	private static final long serialVersionUID = -44896043937437881L;
	private JSONObject jsonData;
    private static Logger logger = Logger.getLogger(HtmlIndexAction.class);
    private We_ProductService we_ProductService;
    
    public String Show(){
    	
    	
    	
    	return "Show";
    }
    
    
	public We_ProductService getWe_ProductService() {
		return we_ProductService;
	}
	@Resource(name="we_ProductService")
	public void setWe_ProductService(We_ProductService we_ProductService) {
		this.we_ProductService = we_ProductService;
	}
	public JSONObject getJsonData() {
		return jsonData;
	}
	public void setJsonData(JSONObject jsonData) {
		this.jsonData = jsonData;
	}
	
	public String Other(){
		int flag = RequestUtils.getIntParamter("flag");
		switch(flag){
			case 1://公司介绍
				return "page_1";
			case 2://联系我们
				return "page_2";
			case 3://加入我们
				return "page_3";
			case 4://项目申报
				return "page_4";
			case 5://知识产权
				return "page_5";
			case 6://创业服务
				return "page_6";
			case 7://常见问题
				return "page_7";
			case 8://自助服务
				return "page_8";
			case 9://其他页面
				return "page_9";
			case 10://
				return "page_10";
			case 11:
				return "page_11";
			case 12:
				return "page_12";
			case 13:
				return "page_13";
			case 14:
				return "page_14";
			case 15:
				return "page_15";
			default:
				return "Show";
		}
	}
}
