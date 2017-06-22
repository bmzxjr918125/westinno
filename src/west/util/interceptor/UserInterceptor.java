package west.util.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/**
 * 用户登录拦截
 * @author  BianMingZhou
 *
 */
public class UserInterceptor extends MethodFilterInterceptor{
	private static final long serialVersionUID = 4040489084252615735L;

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		if (invocation.getInvocationContext().getSession().get("USER")!= null) {
			return invocation.invoke();
		}
		return "login";
	}

}
