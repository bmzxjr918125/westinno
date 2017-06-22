package west.admin.action;


import java.io.File;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;


import net.sf.json.JSONObject;

import org.apache.commons.io.FileUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;



import west.base.action.BaseAction;
import west.entity.We_News;
import west.entity.We_News_Type;
import west.service.We_NewsService;
import west.service.We_News_TypeService;
import west.util.Config;
import west.util.ImageUtils;
import west.util.Notify;
import west.util.RequestUtils;
/**
 * 新闻管理
 * @ClassName: AdminNewsAction
 * @Description: TODO
 * @author BianMingZhou
 * @date 2016-3-22 下午5:28:52
 */
@Controller("adminNewsAction")
@Scope("prototype")
public class AdminNewsAction extends BaseAction {
	private static final long serialVersionUID = 2953492355435570556L;
    private Notify notify=new Notify();
	private We_NewsService we_NewsService;
	private We_News_TypeService we_News_TypeService;
	private List<We_News_Type> newsTypeList;
	private int flag=1;
	private We_News we_News;
	private File file1;
	private String file1ContentType;
	private String file1FileName;
	public String Show(){
		
		
		return "Show";
	}
	public String GetData(){
		we_NewsService.getByPage(super.getDtJson());
		return "ajaxShow";
	}
	
	public String Add(){
		flag=RequestUtils.getIntParamter("flag");
		if(flag==2){
			int id=RequestUtils.getIntParamter("news_id");
			we_News=we_NewsService.getById(id);
		}
		newsTypeList=we_News_TypeService.getAll();
		return "Add";
	}
	public String  AddSava(){
		int flag=RequestUtils.getIntParamter("flag");
		int type=RequestUtils.getIntParamter("we_News_type");
		
		if(flag==1){//添加
			if (file1==null) {
				//操作消息提示
				notify.setCode(2);
				notify.setMsg("请选择新闻缩略图");
				//操作提示放入session
				request.getSession().setAttribute("notify", notify);
				return "AddSaveError";
			}
			we_News.setCreattime(new Date());
		}
			
		We_News_Type newsType=we_News_TypeService.getById(type);
		we_News.setNews_type_id(newsType);
		
		
		String imagepath = "";
		String ext1 = "";
		if (file1!=null) {
			if (!ImageUtils.isVisibleImage(file1FileName)) {
				// json.put("msg","手持照图片格式有误。");
				return "AddSaveError";
			}
			String imagePath1 = "";
			ext1 = this.file1FileName.substring(
					this.file1FileName.lastIndexOf("."),
					this.file1FileName.length());
			try {
				String imageName1 = ImageUtils.createUploadFileName(ext1);
				FileUtils.copyFile(file1, new File(ImageUtils.uploadNewsPath
						+ Config.DIR_LOC + imageName1));
				imagePath1 = ImageUtils.saveNewsPath + imageName1;
			} catch (Exception e) {
			}
		    imagepath = imagePath1;
		    we_News.setImage(imagepath);
		}
		//操作消息提示
		notify.setCode(1);
		notify.setMsg("操作成功！");
		//操作提示放入session
		request.getSession().setAttribute("notify", notify);
        we_NewsService.saveOrUpdate(we_News);		
	     return "AddSave";
	}
	
	public void Delete() throws Exception{
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");// 解决中文乱码问题
		PrintWriter out = response.getWriter();
		JSONObject json = new JSONObject();
		try{
			
			int id = RequestUtils.getIntParamter("news_id");
			if (id != 0) {
				we_NewsService.deleteById(id);
			}
			json.put("msg","删除成功");
			json.put("response","success");
		}catch (Exception e) {
			json.put("msg", e.getMessage());
			json.put("result", "error");
		}
		out.write(json.toString());
		out.flush();
		out.close();
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
	
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public We_News getWe_News() {
		return we_News;
	}
	public void setWe_News(We_News we_News) {
		this.we_News = we_News;
	}
	public List<We_News_Type> getNewsTypeList() {
		return newsTypeList;
	}
	public void setNewsTypeList(List<We_News_Type> newsTypeList) {
		this.newsTypeList = newsTypeList;
	}
	public File getFile1() {
		return file1;
	}
	public void setFile1(File file1) {
		this.file1 = file1;
	}
	public String getFile1ContentType() {
		return file1ContentType;
	}
	public void setFile1ContentType(String file1ContentType) {
		this.file1ContentType = file1ContentType;
	}
	public String getFile1FileName() {
		return file1FileName;
	}
	public void setFile1FileName(String file1FileName) {
		this.file1FileName = file1FileName;
	}
	
}
