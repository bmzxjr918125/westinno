package west.base.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;

import west.base.action.datatables.DataTables;
import west.util.Notify;

import com.opensymphony.xwork2.ActionSupport;




public class BaseAction extends ActionSupport  implements ServletRequestAware,ServletResponseAware, ServletContextAware{
	private static final long serialVersionUID = -7588102526595752037L;

	public  HttpServletRequest request;
	
	public HttpServletResponse response;
	
	public ServletContext  context;
	
	private DataTables dtJson;
	
	private Notify notify;
	
	private String ids;//批量操作ids
	
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	public Notify getNotify() {
		return notify;
	}
	public void setNotify(Notify notify) {
		this.notify = notify;
	}
	public DataTables getDtJson() {
		return dtJson;
	}
	public void setDtJson(DataTables dtJson) {
		this.dtJson = dtJson;
	}
	
	public void setServletRequest(HttpServletRequest request) {
		 this.request = request;
	}
	public void setServletResponse(HttpServletResponse response) {
		  this.response = response;
	}
	public void setServletContext(ServletContext context) {
	   this.context = context;
	}
}
