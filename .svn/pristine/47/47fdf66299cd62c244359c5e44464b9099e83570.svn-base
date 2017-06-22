package west.util;



import org.apache.struts2.ServletActionContext;

public class RequestUtils {
	public static String getStrParamter(String name){
		String str =ServletActionContext.getRequest().getParameter(name);
		if (str != null) {
			str = str.trim();
		}
		return str;
	}

	public static int getIntParamter(String name) {
		// TODO Auto-generated method stub
		String str = ServletActionContext.getRequest().getParameter(name);
		if (str == null || str.trim().equals("")) {
			return 0;
		}
		return Integer.parseInt(str);
	}

	public static boolean getBooleanParamter(String name) {
		String str = ServletActionContext.getRequest().getParameter(name);
		if ("true".equals(str) || "1".equals(str) || "on".equals(str)) {
			return true;
		}
		return false;
	}

	public static float getFloatParamter(String name) {
		String str = ServletActionContext.getRequest().getParameter(name);
		if (str == null || str.trim().equals("")) {
			return 0;
		}

		return Float.parseFloat(str);
	}
	public static double getDoubleParamter(String name) {
		String str = ServletActionContext.getRequest().getParameter(name);
		if (str == null || str.trim().equals("")) {
			return 0;
		}
		
		return Double.parseDouble(str);
	}

}
