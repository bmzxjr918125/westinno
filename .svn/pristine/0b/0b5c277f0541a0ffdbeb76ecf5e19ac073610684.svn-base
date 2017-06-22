package west.util;

import java.util.Calendar;

public class UUID {
    public static String createUUID(int len) {  
        
        String uuid = java.util.UUID.randomUUID().toString()  
                .replaceAll("-", "");  
        return uuid.substring(0, len);  
    }  
    
    @SuppressWarnings("unused")
	public static void main(String arg[]){
    	Calendar cc=Calendar.getInstance();
    	System.out.println(createUUID(30));
    }
}
