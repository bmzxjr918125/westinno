package west.html.action;


import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;



import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import west.base.action.BaseAction;
import west.entity.We_News;
import west.entity.We_News_Type;
import west.service.We_NewsService;
import west.service.We_News_TypeService;
import west.util.Config;
import west.util.RequestUtils;

@Controller("htmlNewsAction")
@Scope("prototype")
public class HtmlNewslAction extends BaseAction{
	private static final long serialVersionUID = -8149172477741803862L;
	private JSONObject jsonData;
    private We_NewsService we_NewsService;
    private We_News_TypeService we_News_TypeService;
    private static Logger logger = Logger.getLogger(HtmlNewslAction.class);
   private We_News we_News;
    
    public String Show(){
    	jsonData=new JSONObject();
    	//获取最多9条推荐资讯
    	List<We_News> recommendList=we_NewsService.getRecommend();
    	List<We_News> imageList=new ArrayList<We_News>();
    	if(recommendList!=null){
    		//获取最多四张图片
    		for(We_News news:recommendList){
    			if(imageList.size()<4){
    				imageList.add(news);
    			}else{
    				break;
    			}
    		}
    	}
    	//获取类型列表
    	List<We_News_Type> newsTypeList=we_News_TypeService.getAll();
    	
    	jsonData.put("newsTypeList", newsTypeList);
    	jsonData.put("recommendList", recommendList);
    	jsonData.put("imageList", imageList);
    	return "Show";
    }
    /**
     * 分页获取资讯列表  分页 按类型获取
     * @Title: GetList
     * @Description: TODO
     * @author BianMingZhou
     * @date 2016-3-24 下午2:24:04
     * @param  pageNumber
     * @param  currentPage
     * @param  type
     * @return void 
     * @throws
     */
    public void GetList() throws Exception{
    	response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");// 解决中文乱码问题
		PrintWriter out = response.getWriter();
    	try{
    		jsonData = new JSONObject();
    		
    		int pageNumber = Config.HTML_SHOWNUMBER;
    		int currentPage = RequestUtils.getIntParamter("currentPage");
    		int type = RequestUtils.getIntParamter("type");
    		if (currentPage == 0||currentPage < 0) {
    			currentPage = 1;
    		}
    		jsonData.put("pageNumber", pageNumber);
    		int totalCount=we_NewsService.countAllByType(type);
    		int totalPage=countPage(totalCount);
    		jsonData.put("totalPage",totalPage);
    		if(currentPage>totalPage){
    			jsonData.put("currentPage", totalPage);
    		}else{
    			jsonData.put("currentPage", currentPage);
    		}
    		
    		jsonData.put("type",type);
    		
    		List<We_News> newsList=we_NewsService.getHtmlPage(jsonData);
    		
    		
    		
    		jsonData.put("list", newsList);
    		jsonData.put("response","success");
    	}catch (Exception e) {
    		jsonData.put("response","error");
    		jsonData.put("msg","请求异常");
    		logger.error("htmlNewsShow异常："+e.getMessage());
    		e.printStackTrace();
		}
		out.write(jsonData.toString());
		out.flush();
		out.close();
    }
    
    
    public String Look(){
        int id=RequestUtils.getIntParamter("news_id");  
        jsonData=new JSONObject();
        we_News=we_NewsService.getById(id);
      //获取最多9条推荐资讯
      List<We_News> recommendList=we_NewsService.getRecommend();
      jsonData.put("recommendList", recommendList);
    	return "Look";
    }
    
    
    public int countPage(int totalCount){
    	int countPage= (int)(totalCount % Config.HTML_SHOWNUMBER == 0 ? totalCount
    				/ Config.HTML_SHOWNUMBER : (totalCount / Config.HTML_SHOWNUMBER) + 1);
    	return countPage;
    }
    
    
	public JSONObject getJsonData() {
		return jsonData;
	}
	public void setJsonData(JSONObject jsonData) {
		this.jsonData = jsonData;
	}
	public We_NewsService getWe_NewsService() {
		return we_NewsService;
	}
    @Resource(name="we_NewsService")
	public void setWe_NewsService(We_NewsService we_NewsService) {
		this.we_NewsService = we_NewsService;
	}
	public We_News_TypeService getWe_News_TypeService() {
		return we_News_TypeService;
	}
	@Resource(name="we_News_TypeService")
	public void setWe_News_TypeService(We_News_TypeService we_News_TypeService) {
		this.we_News_TypeService = we_News_TypeService;
	}
	public We_News getWe_News() {
		return we_News;
	}
	public void setWe_News(We_News we_News) {
		this.we_News = we_News;
	}

}
