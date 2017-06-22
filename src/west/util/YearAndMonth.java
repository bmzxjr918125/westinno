package west.util;

/**
 * @Description:获取当前的年月
 */
 
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
 

public class YearAndMonth
{
    /**
     * @Description : 获取年月
     * @return
     */
    public static Date findYearMonth() throws Exception
    {
        /**
         * 声明一个int变量year
         */
        int year;
        /**
         * 声明一个int变量month
         */
        int month;
        /**
         * 声明一个字符串变量date
         */
        String date;
        /**
         * 实例化一个对象calendar
         */
        Calendar calendar = Calendar.getInstance();
        /**
         * 获取年份
         */
        year = calendar.get(Calendar.YEAR);
        /**
         * 获取月份
         */
        month = calendar.get(Calendar.MONTH) + 1;
        /**
         * 拼接年份和月份
         */
        date = year + "-" + ( month<10 ? "0" + month : month)+"-"+"01";
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
       
        /**
         * 返回当前年月
         */
        return  sdf.parse(date);
    }
}