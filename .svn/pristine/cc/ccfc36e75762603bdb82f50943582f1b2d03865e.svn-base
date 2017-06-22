package west.admin.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import west.base.action.BaseAction;
import west.entity.We_Admin;
import west.entity.We_AdminMenu;
import west.service.We_AdminMenuService;
import west.service.We_AdminService;
import west.util.Notify;



/**
 * 后台管理员action
 * @ClassName: AdminAction
 * @Description: TODO
 * @author BianMingZhou
 * @date 2015-10-21 上午11:19:39
 */
@Controller("adminAction")
@Scope("prototype")
public class AdminAction extends BaseAction {
	
	private static final long serialVersionUID = -7602700865904167060L;

	private We_Admin admin = new We_Admin();

	private String echoPwd;//重复密码
	
	private String oldPwd;//旧密码
	
	@Resource(name="we_AdminService")
	private We_AdminService we_AdminService;
	private We_AdminMenuService we_AdminMenuService;
	public We_AdminMenu menu;
	/**
	 * <p>Methods : login</P>
	 * <p>Description : 后台用户登录页面入口</p>
	 * @Date : 2015年9月10日 下午1:05:38
	 * @return
	 */
	public String login(){
		return LOGIN;
	}
	
	/**
	 * <p>Methods : Loginin</P>
	 * <p>Description : 后台用户登陆验证</p>
	 * @Date : 2015年9月10日 下午1:17:59
	 * @return
	 */
	public String loginin(){

		admin = we_AdminService.checkLogin(admin);
		
		if(admin != null){//查找到用户即登录成功
		
			//将后台用户信息存入session中
			super.request.getSession().setAttribute("ADMIN", admin);
			
			admin.setLastlogintime(admin.getThislogintime());
			admin.setThislogintime(new Date());
			
			//更新用户相关信息
			we_AdminService.updateByState(admin);
			
			//处理响应消息
			super.setNotify(new Notify(1, "登录成功！"));
			super.request.getSession().setAttribute("notify", super.getNotify());
			
			return SUCCESS;
		}else{//未查找到用户即登录失败
			super.setNotify(new Notify(2,"您输入用户名或密码错误，请重新登录！"));
			super.request.getSession().setAttribute("notify", super.getNotify());
			return LOGIN;
		}
	}
	/**
	 * 主页显示
	 * @return
	 */
	public String MenuShow(){
		
		We_Admin  admin=(We_Admin) request.getSession().getAttribute("ADMIN");
		
		if(admin != null){
			menu = we_AdminMenuService.getTree(admin.getRole_type());	
		}else{
			//暂时未做登录是使用
			menu = we_AdminMenuService.getTree(0);
			//menu=(Lc_AdminMenu) menu.getChildrens();
		}
		
		super.request.getSession().setAttribute("menu", menu);
		
		return "MenuShow";
	}
	/**
	 * <p>Methods : Show</P>
	 * <p>Description : 跳转到Admin列表页面</p>
	 * @Date : 2015年9月10日 下午5:29:24
	 * @return
	 */
	public String Show(){
		return "show";
	}
	
	/**
	 * <p>Methods : ajaxShow</P>
	 * <p>Description : 分页条件查询管理员数据</p>
	 * @Date : 2015年9月10日 下午5:48:22
	 * @return
	 */
	public String AjaxShow(){
		we_AdminService.getByPage(super.getDtJson());
		return "ajaxShow";
	}
	
	/**
	 * <p>Methods : Add</P>
	 * <p>Description : 跳转到新增管理员页面</p>
	 * @Date : 2015年9月11日 下午2:12:58
	 * @return
	 */
	public String Add(){
		return "add";
	}
	
	/**
	 * <p>Methods : CheckUnique</P>
	 * <p>Description : 校验用户名是否重复</p>
	 * @Date : 2015年9月11日 下午3:09:47
	 * 返回true/false
	 */
	public void CheckUnique(){
		
		this.setAdmin(we_AdminService.getOnlyByUsername(admin));;
		
		PrintWriter out;
		try {
			out = super.response.getWriter();
			out.write(admin != null ? "false" : "true");
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * <p>Methods : AddSave</P>
	 * <p>Description : 新增管理员用户</p>
	 * @Date : 2015年9月11日 下午3:55:32
	 * @return
	 */
	public String AddSave(){
		//保存成功
		if(we_AdminService.addSave(admin,echoPwd)){
			//处理响应消息
			super.setNotify(new Notify(1,"新增管理员用户成功！"));
			super.request.getSession().setAttribute("notify", super.getNotify());
			
			return "addSave";
		}else{
			super.setNotify(new Notify(2,"新增管理员用户失败，请重新操作！"));
			return "add";
		}
	}
	
	/**
	 * <p>Methods : Logout</P>
	 * <p>Description : 退出登录</p>
	 * @Date : 2015年9月11日 下午4:52:21
	 * @return
	 */
	public String Logout(){
		super.request.getSession().removeAttribute("ADMIN");
		return LOGIN;
	}
	
	/**
	 * <p>Methods : UpdatePassword</P>
	 * <p>Description : 根据ID查询用户信息，跳转到修改密码页面</p>
	 * @Date : 2015年9月11日 下午5:03:42
	 * @return
	 */
	public String UpdatePassword(){
		this.setAdmin(we_AdminService.getOnlyById(admin.getId()));
		return "updatePassword";
	}
	
	/**
	 * <p>Methods : UpdatePasswordSave</P>
	 * <p>Description : 修改管理员帐户密码</p>
	 * @Date : 2015年9月11日 下午5:52:01
	 * @return
	 */
	public String UpdatePasswordSave(){
		int sign = we_AdminService.updatePasswordSave(admin.getId(), oldPwd, admin.getPassword(), echoPwd);
		switch(sign){
			case 0:
				super.setNotify(new Notify(1,"修改密码成功！"));
				super.request.getSession().setAttribute("notify", super.getNotify());
				return "success";
			case 1:
				super.setNotify(new Notify(2,"修改密码失败，旧密码或新密码或重复密码不能为空！"));
				return "updatePassword";
			case 2:
				super.setNotify(new Notify(2,"修改密码失败，旧密码输入错误！"));
				return "updatePassword";
			case 3:
				super.setNotify(new Notify(2,"修改密码失败，没有查找到该账户！"));
				return "updatePassword";
			case 4:
				super.setNotify(new Notify(2,"修改密码失败，新密码和重复密码不相同！"));
				return "updatePassword";
			default:
				super.setNotify(new Notify(2,"修改密码失败，请重新操作！"));
				return "updatePassword";
		}
	}
	
	/**
	 * <p>Methods : UpdatePower</P>
	 * <p>Description : 跳转到设置管理员权限页面</p>
	 * @Date : 2015年9月12日 上午9:27:34
	 * @return
	 */
	public String UpdatePower(){
		this.setAdmin(we_AdminService.getOnlyById(admin.getId()));
		return "updatePower";
	}
	
	/**
	 * <p>Methods : UpdatePowerSave</P>
	 * <p>Description : 保存已设置管理员的权限</p>
	 * @Date : 2015年9月12日 上午9:41:19
	 * @return
	 */
	public String UpdatePowerSave(){
		boolean flag = we_AdminService.updatePowerSave(admin);
		if(flag){
			super.setNotify(new Notify(1,"设置权限成功！"));
			super.request.getSession().setAttribute("notify", super.getNotify());
			return "updatePowerSave";
		}else{
			super.setNotify(new Notify(2,"设置权限失败，请重新操作！"));
			return "updatePower";
		}
		
	}
	
	/**
	 * <p>Methods : DeleteByBatch</P>
	 * <p>Description : 批量删除管理员帐户</p>
	 * @Date : 2015年9月12日 上午11:48:07
	 * @return
	 */
	public String DeleteByBatch(){
		
		boolean flag = we_AdminService.deleteByBatch(super.getIds());
		if(flag){
			super.setNotify(new Notify(1,"批量删除管理员成功！"));
		}else{
			super.setNotify(new Notify(2,"批量删除管理员失败，请重新操作！"));
		}
		return "deleteByBatch";
	}
	
	/**
	 * 清除notify的session
	 */
	public void ClearNotify(){
		Notify notify= (Notify) request.getSession().getAttribute("notify");
		if(notify!=null){
			request.getSession().removeAttribute("notify");
		}
	}
	
	public We_AdminMenuService getLc_AdminMenuService() {
		return we_AdminMenuService;
	}
	@Resource(name="we_AdminMenuService")
	public void setLc_AdminMenuService(We_AdminMenuService we_AdminMenuService) {
		this.we_AdminMenuService = we_AdminMenuService;
	}
	public We_AdminMenu getMenu() {
		return menu;
	}
	public void setMenu(We_AdminMenu menu) {
		this.menu = menu;
	}
	
	public String getEchoPwd() {
		return echoPwd;
	}

	public void setEchoPwd(String echoPwd) {
		this.echoPwd = echoPwd;
	}

	public String getOldPwd() {
		return oldPwd;
	}

	public void setOldPwd(String oldPwd) {
		this.oldPwd = oldPwd;
	}

	public We_Admin getAdmin() {
		return admin;
	}

	public void setAdmin(We_Admin admin) {
		this.admin = admin;
	}
	
	public We_AdminService getLc_AdminService() {
		return we_AdminService;
	}

	public void setLc_AdminService(We_AdminService we_AdminService) {
		this.we_AdminService = we_AdminService;
	}
	
}
