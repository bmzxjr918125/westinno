package west.util;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * 时间计算的相关方法
 * @author  BianMingZhou
 *
 */
public class DateUtils {
	/**
	 * 获取时间差
	 * 
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public static String getTimeDifference(Date startTime, Date endTime)
			throws Exception {

		Date begin = startTime;
		Date end = endTime;
		long between = (end.getTime() - begin.getTime()) / 1000;// 除以1000是为了转换成秒

		long day = between / (24 * 3600);
		long hour = between % (24 * 3600) / 3600;
		long minute = between % 3600 / 60;
		long second = between % 60 % 60;
		String result = "" + day + "天" + hour + "小时" + minute + "分" + second
				+ "秒";

		return result;
	}
	
	/**
	 * 获取时间差
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public static String getTimePoor(Date startTime,Date endTime){
		Calendar calendar1 = Calendar.getInstance();
		calendar1.setTime(startTime);
		long estimatetime = calendar1.getTimeInMillis();
		Calendar calendar2 = Calendar.getInstance();
		calendar2.setTime(endTime);
		long nowtime = calendar2.getTimeInMillis();
		long time = estimatetime - nowtime;
		long days = time / (1000 * 60 * 60 * 24);
		long hours = (time - days * (1000 * 60 * 60 * 24))/(1000 * 60 * 60);
		long minutes = (time - days * (1000 * 60 * 60 * 24) - hours*(1000 * 60 * 60))/(1000 * 60);
		String result = Math.abs(days) + "天" + Math.abs(hours) + "小时" + Math.abs(minutes) + "分钟";
		return result;
	}
	

	/**
	 * 获取时间差 集合
	 * 
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public static Map<String, String> getTimeDifferenceList(Date startTime,
			Date endTime) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
      if(startTime==null||endTime==null){
    	  map.put("day","0");
    	  map.put("hour","0");
    	  map.put("minute","1");
      }else{
    	  Date begin = startTime;
  		Date end = endTime;
  		long between = (end.getTime() - begin.getTime()) / 1000;// 除以1000是为了转换成秒

  		long day = between / (24 * 3600);
  		long hour = between % (24 * 3600) / 3600;
  		long minute = between % 3600 / 60;
  		// long second=between%60/60;
  		
  		map.put("day", day + "");
  		map.put("hour", hour + "");
  		map.put("minute", minute + "");
      }

		return map;
	}

	/**
	 * 获取时间差 秒数
	 * 
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public static long getTimeDiffSeconds(Date startTime, Date endTime)
			throws Exception {

		Date begin = startTime;
		Date end = endTime;
		long between = (end.getTime() - begin.getTime()) / 1000;// 除以1000是为了转换成秒
		return between;
	}

	/**
	 * 时间格式化
	 * 
	 * @param time
	 *            需格式的时间 秒数 （秒）
	 * @return
	 */
	public static String formatMS(long time) throws Exception {

		long day = time / (24 * 3600);
		long hour = time % (24 * 3600) / 3600;
		long minute = time % 3600 / 60;
		long second = time % 60 / 60;
		String result = "";
		if (day == 0) {
			if (hour == 0) {
				if (minute == 0) {
					result = "" + second + "秒";
				} else {
					result = "" + minute + "分" + second + "秒";
				}
			} else {
				result = "" + hour + "小时" + minute + "分" + second + "秒";
			}
		} else {
			result = "" + day + "天" + hour + "小时" + minute + "分" + second + "秒";
		}

		return result;
	}
	
	
	
	/**
	 * 时间格式化
	 * 
	 * @param time
	 *            需格式的时间 秒数 （秒）
	 * @return
	 */
	public static String formatMSEn(long time) throws Exception {

		long day = time / (24 * 3600);
		long hour = time % (24 * 3600) / 3600;
		long minute = time % 3600 / 60;
		String result = "";
		if (day < 0) {
			if (hour <0) {
				if (minute < 0) {
					result = "0h 0m";
				} else {
					result = "0h" + minute + "m";
				}
			} else {
				result = "" + hour + "h" + minute + "m";
			}
		} else {
			result = "" + day + "d" + hour + "h" + minute + "m" ;
		}

		return result;
	}
	

	/**
	 * 获取对应星期
	 * 
	 * @param year
	 * @param month
	 * @param day
	 * @return
	 */
	public static String getWeek(Date date) {
		String[] weekDays = DateFormatSymbols.getInstance(Locale.CHINA)
				.getWeekdays();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int week = cal.get(Calendar.DAY_OF_WEEK);
		return weekDays[week];

	}

	/** 计算年龄 */
	public static String getAge(Date birthDay) throws Exception {
		Calendar cal = Calendar.getInstance();

		if (cal.before(birthDay)) {
			throw new IllegalArgumentException("日期错误!");
		}

		int yearNow = cal.get(Calendar.YEAR);
		int monthNow = cal.get(Calendar.MONTH) + 1;
		int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);

		cal.setTime(birthDay);
		int yearBirth = cal.get(Calendar.YEAR);
		int monthBirth = cal.get(Calendar.MONTH);
		int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);

		int age = yearNow - yearBirth;

		if (monthNow <= monthBirth) {
			if (monthNow == monthBirth) {
				// monthNow==monthBirth
				if (dayOfMonthNow < dayOfMonthBirth) {
					age--;
				}
			} else {
				// monthNow>monthBirth
				age--;
			}
		}

		return age + "";
	}
   
	/**
	 * 毫秒时间转换为xx分钟前的格式
	 * 
	 * @param text
	 * @return
	 */
	public static String timeToStr(Long date) throws Exception {
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
     * 得到指定时间月第一天的日期 
     * @Methods Name getFirstDayOfMonth 
     * @return Date 
     */  
    public static Date getFirstDayOfMonth(Date date)  throws ParseException {     
        Calendar cDay = Calendar.getInstance();  
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
      String str=  sdf.format(date)+" 00:00:00";
      sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			cDay.setTime( sdf.parse(str));
        cDay.set(Calendar.DAY_OF_MONTH, 1);  
        return cDay.getTime();     
    }     
   
    /**  
     * @param date1 需要比较的时间 不能为空(null),需要正确的日期格式  
     * @param date2 被比较的时间  为空(null)则为当前时间  
     * @param stype 返回值类型   0为多少天，1为多少个月，2为多少年  
     * @return  
     */  
    public static int compareDate(String date1,String date2,int stype){  
        int n = 0;  
          
       // String[] u = {"天","月","年"};  
        String formatStyle = stype==1?"yyyy-MM":"yyyy-MM-dd";  
          
        date2 = date2==null?getCurrentDate():date2;  
          
        DateFormat df = new SimpleDateFormat(formatStyle);  
        Calendar c1 = Calendar.getInstance();  
        Calendar c2 = Calendar.getInstance();  
        try {  
            c1.setTime(df.parse(date1));  
            c2.setTime(df.parse(date2));  
        } catch (Exception e3) {  
            System.out.println("wrong occured");  
        }  
        //List list = new ArrayList();  
        while (!c1.after(c2)) {                     // 循环对比，直到相等，n 就是所要的结果  
            //list.add(df.format(c1.getTime()));    // 这里可以把间隔的日期存到数组中 打印出来  
            n++;  
            if(stype==1){  
                c1.add(Calendar.MONTH, 1);          // 比较月份，月份+1  
            }  
            else{  
                c1.add(Calendar.DATE, 1);           // 比较天数，日期+1  
            }  
        }  
          
        n = n-1;  
          
        if(stype==2){  
            n = (int)n/365;  
        }     
          
       // System.out.println(date1+" -- "+date2+" 相差多少"+u[stype]+":"+n);        
        return n;  
    }   
 
    
    /**  
     * 得到当前日期  
     * @return  
     */ 
    public static String getCurrentDate() {  
        Calendar c = Calendar.getInstance();  
        Date date = c.getTime();  
        SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");  
        return simple.format(date);  
    }   
    
    public static void main(String[] args) {
    	System.out.println(compareDate("2015-08-09", "2015-12-09", 1));
	}
	/*Calendar calendar = new GregorianCalendar();  
    // 1. 当前登陆日期的周一至周五的日期 比如 现在是2012-06-11 周一是2012-06-11 周五就是 2012-06-15。  
        calendar.set(Calendar.DAY_OF_WEEK, 2);  
        System.out.println("登录日期的周一：" + print(calendar.getTime()));  
        // 2.星期五，第六天s  
        calendar.set(Calendar.DAY_OF_WEEK, 6);  
        System.out.println("登录日期的周五：" + print(calendar.getTime()));  
        // 3.当前月的第一天  
        calendar.set(Calendar.DAY_OF_MONTH, 1);  
        System.out.println("当前月的第一天：" + print(calendar.getTime()));  
        // 4.当前月的最后一天  
        calendar.add(Calendar.MONTH, 1);  
        calendar.set(Calendar.DAY_OF_MONTH, 0);  
        System.out.println("当前月的最后一天：" + print(calendar.getTime()));  
  
        // 季度初  
        calendar.setTime(new Date());  
        int month = getQuarterInMonth(calendar.get(Calendar.MONTH), true);  
        calendar.set(Calendar.MONTH, month);  
        calendar.set(Calendar.DAY_OF_MONTH, 1);  
        System.out.println("当季度的第一天：" + print(calendar.getTime()));  
        // 季度末  
        calendar.setTime(new Date());  
        month = getQuarterInMonth(calendar.get(Calendar.MONTH), false);  
        calendar.set(Calendar.MONTH, month + 1);  
        calendar.set(Calendar.DAY_OF_MONTH, 0);  
        System.out.println("当前时间的季度末：" + print(calendar.getTime()));  
    }  */
  
  
     
	
}
