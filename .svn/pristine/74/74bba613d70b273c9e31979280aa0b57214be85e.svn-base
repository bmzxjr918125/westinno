package west.util;

import java.io.UnsupportedEncodingException;

import west.exception.WestException;



/**
 * 编码转换
 * @author  BianMingZhou
 *
 */
public class CharacterEncoding {
      public static String Iso8859ToUtf8(String str){
    	 try {
    		 if(str!=null){
    			 str=new String(str.getBytes("iso-8859-1"),"utf-8");
    		 }else{
    			 str="";
    		 }
			
		} catch (UnsupportedEncodingException e) {
			throw new WestException(e.getMessage());
		}
    	 return str;
      }
}
