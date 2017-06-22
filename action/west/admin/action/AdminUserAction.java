package west.admin.action;


import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import west.base.action.BaseAction;
import west.service.We_UserService;
/**
 * 用户管理
 * @ClassName: adminUserAction
 * @Description: TODO
 * @author BianMingZhou
 * @date 2016-3-2 下午5:28:52
 */
@Controller("adminUserAction")
@Scope("prototype")
public class AdminUserAction extends BaseAction {
	private static final long serialVersionUID = 2953332355435570556L;
	private We_UserService we_UserService;
	public We_UserService getWe_UserService() {
		return we_UserService;
	}
	@Resource(name="we_UserService")
	public void setWe_UserService(We_UserService we_UserService) {
		this.we_UserService = we_UserService;
	}
	
	public String Show(){
		return "Show";
	}
	
	/**
	 * <p>Method Name : AjaxShow</p>
	 * <p>Method Desc : Ajax获取用户数据，分页排序筛选</p>
	 * <p>Date : 2016-3-31 下午3:07:53</p>
	 * <p>Author : XQL</p>
	 * @return
	 */
	public String AjaxShow(){
		we_UserService.getByPage(super.getDtJson());
		return "ajaxShow";
	}
	
	
}
