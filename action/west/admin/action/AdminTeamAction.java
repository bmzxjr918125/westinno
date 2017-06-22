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
import west.entity.We_Order_Team;
import west.service.We_Order_TeamService;
import west.entity.We_Team;
import west.service.We_TeamService;
import west.util.Config;
import west.util.ImageUtils;
import west.util.Notify;
import west.util.RequestUtils;
/**
 * 客服管理
 * @ClassName: AdminTeamAction
 * @Description: TODO
 * @author BianMingZhou
 * @date 2016-4-13 下午8:15:03
 */
@Controller("adminTeamAction")
@Scope("prototype")
public class AdminTeamAction extends BaseAction {
	private static final long serialVersionUID = 180050394627599726L;
	private Notify notify=new Notify();
	private We_TeamService we_TeamService;
	private We_Order_TeamService we_Order_TeamService;
	private int flag=1;
	private File file1;
	private String file1ContentType;
	private String file1FileName;
	private We_Team we_Team;
	private JSONObject jsonData;
	
	public JSONObject getJsonData() {
		return jsonData;
	}
	public void setJsonData(JSONObject jsonData) {
		this.jsonData = jsonData;
	}
	/**
	 * 客服列表显示
	 * @Title: Show
	 * @Description: TODO
	 * @author BianMingZhou
	 * @date 2016-4-13 下午8:17:00
	 * @param @return 
	 * @return String 
	 * @throws
	 */
	public String Show(){
		return "Show";
	}
	public String GetData(){
		we_TeamService.getByPage(super.getDtJson());
		return "ajaxShow";
	}
	
	public String Add(){
		flag=RequestUtils.getIntParamter("flag");
		if(flag==2){
			int id=RequestUtils.getIntParamter("team_id");
			we_Team=we_TeamService.getById(id);
		}
		
		return "Add";
	  }
	public String  AddSava(){
		int flag=RequestUtils.getIntParamter("flag");
		
		if(flag==1){//添加
			if (file1==null) {
				//操作消息提示
				notify.setCode(2);
				notify.setMsg("请选择头像");
				//操作提示放入session
				request.getSession().setAttribute("notify", notify);
				return "AddSaveError";
			}
			we_Team.setCreattime(new Date());
		}
		
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
				FileUtils.copyFile(file1, new File(ImageUtils.uploadTeamPath
						+ Config.DIR_LOC + imageName1));
				imagePath1 = ImageUtils.saveTeamPath + imageName1;
			} catch (Exception e) {
			}
		    imagepath = imagePath1;
		    we_Team.setLogo(imagepath);
		}
		//操作消息提示
		notify.setCode(1);
		notify.setMsg("操作成功！");
		//操作提示放入session
		request.getSession().setAttribute("notify", notify);
        we_TeamService.saveOrUpdate(we_Team);		
	     return "AddSave";
	}
	
	public void Delete() throws Exception{
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");// 解决中文乱码问题
		PrintWriter out = response.getWriter();
		JSONObject json = new JSONObject();
		try{
			
			int id = RequestUtils.getIntParamter("team_id");
			List<We_Order_Team> orderTeamList=we_Order_TeamService.getByInt("team_id.id",id);
			if(orderTeamList!=null&&orderTeamList.size()>0){
				json.put("msg","当前数据不能删除，该客服存在对应服务订单信息");
				json.put("response","error");
			}else{
				if (id != 0) {
					we_TeamService.deleteById(id);
				}
				json.put("msg","删除成功");
				json.put("response","success");
			}
			
		}catch (Exception e) {
			json.put("msg", e.getMessage());
			json.put("result", "error");
		}
		out.write(json.toString());
		out.flush();
		out.close();
	}
	public void GetTeam() throws Exception{
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");// 解决中文乱码问题
		PrintWriter out = response.getWriter();
		jsonData = new JSONObject();
		List<We_Team> list = we_TeamService.getAll();
		jsonData.put("teamList", list);
		out.write(jsonData.toString());
		out.flush();
		out.close();
	}
	public Notify getNotify() {
		return notify;
	}
	public void setNotify(Notify notify) {
		this.notify = notify;
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
	public We_TeamService getWe_TeamService() {
		return we_TeamService;
	}
	@Resource(name="we_TeamService")
	public void setWe_TeamService(We_TeamService we_TeamService) {
		this.we_TeamService = we_TeamService;
	}
	public We_Team getWe_Team() {
		return we_Team;
	}
	public void setWe_Team(We_Team we_Team) {
		this.we_Team = we_Team;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public We_Order_TeamService getWe_Order_TeamService() {
		return we_Order_TeamService;
	}
	@Resource(name="we_Order_TeamService")
	public void setWe_Order_TeamService(We_Order_TeamService we_Order_TeamService) {
		this.we_Order_TeamService = we_Order_TeamService;
	}
}
