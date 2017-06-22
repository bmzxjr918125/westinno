package west.util.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/**
 * 后台管理登录拦截
 * @author  BianMingZhou
 *
 */
public class AdminInterceptor extends MethodFilterInterceptor{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		if (invocation.getInvocationContext().getSession().get("ADMIN")!= null) {
			return invocation.invoke();
		}
		return "login";
	}

}
