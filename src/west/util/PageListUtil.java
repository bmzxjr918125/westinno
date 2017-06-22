package west.util;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 构造 dataTable 分页返回数据格式
 * @author  BianMingZhou
 *
 */
public class PageListUtil {
	@SuppressWarnings("unused")
	public static <T> String listForPage(List<T> list, int count,String aoData) {
		JSONArray jsonarray = JSONArray.fromObject(aoData);
		
        int iDisplayStart = 0; // 起始索引
        int iDisplayLength = 0; // 每页显示的行数
        String sEcho="";
        for (int i = 0; i < jsonarray.size(); i++) {
            JSONObject obj = (JSONObject) jsonarray.get(i);
            if (obj.get("name").equals("sEcho"))
                sEcho = obj.get("value").toString();
     
            if (obj.get("name").equals("iDisplayStart"))
                iDisplayStart = obj.getInt("value");
     
            if (obj.get("name").equals("iDisplayLength"))
                iDisplayLength = obj.getInt("value");
        }
     
        
         
        JSONObject getObj = new JSONObject();
        getObj.put("sEcho", sEcho);// 不知道这个值有什么用,有知道的请告知一下
        getObj.put("iTotalRecords",count);//实际的行数
        getObj.put("iTotalDisplayRecords",count);//显示的行数,这个要和上面写的一样
        //"creatTime":{"date":28,"day":6,"hours":0,"minutes":0,"month":1,"nanos":0,"seconds":0,"time":1425052800000,"timezoneOffset":-480,"year":115}
        JSONArray jsonArray1 = JSONArray.fromObject(list);
        getObj.put("aaData",jsonArray1);//要以JSON格式返回
		return getObj.toString();
	}
	
	
	
}
