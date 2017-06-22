package west.el;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import west.util.DateUtils;



/**
 * 自定义EL函数
 * 
 * @author BianMingZhou
 * 
 */
public class Functions {
	/**
	 * json中的时间转换为xx分钟前的格式
	 * 
	 * @param text
	 * @return
	 */
	public static String timeEx(Long date) throws Exception {
		// return new StringBuffer( text ).reverse().toString();
		Map<String, String> timeMap = DateUtils.getTimeDifferenceList(new Date(
				date), new Date());
		String time = "";
		if (Integer.parseInt(timeMap.get("day")) > 0) {
			time = timeMap.get("day") + "天前";
		} else if (Integer.parseInt(timeMap.get("hour")) > 0) {
			time = timeMap.get("hour") + "小时前";
		} else if (Integer.parseInt(timeMap.get("minute")) > 0) {
			time = timeMap.get("minute") + "分钟前";
		} else {
			time = "1分钟前";
		}
		return time;
	}

	/**
	 * long型转为yyyy-MM-dd HH:mm
	 * 
	 * @param date
	 * @return
	 * @throws Exception
	 */
	public static String longEx(Long date) throws Exception {
		Date date_ = new Date(date);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		return sdf.format(date_);
	}

	/**
	 * json中的时间转换为“今天 10:00 昨天 01:00 或2015-11-03 12:45”的格式
	 * 
	 * @param text
	 * @return
	 */
	public static String dateEx(Long date) throws Exception {
		// return new StringBuffer( text ).reverse().toString();
		Date formatDate = new Date(date);

		Date nowDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String nowStr = sdf.format(nowDate);
		nowStr = nowStr + " 23:59";
		sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		nowDate = sdf.parse(nowStr);

		Date dBefore = new Date();
		Calendar calendar = Calendar.getInstance(); // 得到日历
		calendar.setTime(nowDate);// 把当前时间赋给日历
		calendar.add(Calendar.DAY_OF_MONTH, -1); // 设置为前一天
		dBefore = calendar.getTime(); // 得到前一天的时间

		Date dBefore2 = new Date();
		calendar.setTime(dBefore);// 把当前时间赋给日历
		calendar.add(Calendar.DAY_OF_MONTH, -1); // 设置为前一天
		dBefore2 = calendar.getTime(); // 得到前一天的时间

		if (formatDate.after(dBefore) && formatDate.before(nowDate)) {
			// 今天
			sdf = new SimpleDateFormat("HH:mm");
			return "今天 " + sdf.format(formatDate);
		} else if (formatDate.after(dBefore2) && formatDate.before(dBefore)) {
			// 昨天
			sdf = new SimpleDateFormat("HH:mm");
			return "昨天 " + sdf.format(formatDate);
		} else {
			// 显示时间
			return sdf.format(formatDate);
		}
	}

	/**
	 * 价格转换
	 * 
	 * @param price
	 * @return
	 */
	public static String getPrice(Double price) {
		DecimalFormat df = new DecimalFormat("######0.00");
		String price_str = df.format(price);
		return price_str;
	}
	
	/**
	 * 显示价格
	 * @param price
	 * @return
	 */
	public static String priceEx(Double price){
		NumberFormat currenct = NumberFormat.getCurrencyInstance();
		return currenct.format(price).substring(1);
	}

	/**
	 * 转为整形
	 * @param score
	 * @return
	 */
	public static Integer scoreEx(Double score){
		return score.intValue();
	}
	
	/**
	 * 取绝对值
	 * @param score
	 * @return
	 */
	public static Integer absEx(Integer value){
		return Math.abs(value);
	}
	
	
}
