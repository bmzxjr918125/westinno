package west.util;

/**
 * 常用参数配置
 * 
 * @author BianMingZhou
 * 
 */
public interface Config {

	// 在windows上使用"\\"，在linux上使用"/"
	// public static final String DIR_LOC = "\\";

	public static final String DIR_LOC = "/";

	/**
	 * 图片上传大小 10MB
	 */
	public static final int IMAGE_SIZE = 10485760;
	/**
	 * 图片上传大小 2MB
	 */
	public static final int IMAGE_SIZE_2 = 2097152;
	/**
	 * 图片保存大小限制 100kb
	 */
	public static final int JPG_IMAGE_SIZE = 102400;

	/**
	 * HTml 中信息列表显示条数
	 */
	public static final int HTML_SHOWNUMBER = 10;

	/**
	 * client 中信息列表显示条数
	 */
	public static final int CLIENT_SHOWNUMBER = 10;

	public static final int TIMER_NUM = 15;// 以天为单位

	public static final String TIMER_ALERT = "系统定时删除";// 删除理由
	
	/**
	 * Ping++ 平台提供的key
	 */
	public static final String API_KEY = "sk_live_K4eX5SbHGSu1zzHmD8rjfnjH";
	//public static final String API_KEY = "sk_test_0KOWH0vHm5a1S0O8W1S0GezD";
	
	/**
	 * 获取移动端支付所需的charge对象所需的凭证
	 */
	public static final String APP_ID = "app_qbz1i1ifjjz1KyrT";
	
	/**
	 * 付款成功跳转url
	 */
	public static final String chargeUrl = "http://www.westinno.com/";

	/**
	 * 支付回调key （westinnopaypushactionkey）双md5加密
	 *
	 */
	public static final String charge_key = "B68BCAEB55ACE33F38D45D65C064447C";

}
