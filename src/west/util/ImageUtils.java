package west.util;

import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletRequest;


import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

public class ImageUtils{
	public static final String basePath = System.getProperty("catalina.home") + "/webapps/";

	
	//临时图片存放地址，用于及时浏览以及保存信息是转存 
	public static final String uploadTempPath = System.getProperty("catalina.home") + "/webapps/westTempImages";
	public static final String saveTempPath = "westTempImages/";
	//新闻缩略图片
	public static final String uploadNewsPath = System.getProperty("catalina.home") + "/webapps/westNewsImages";
	public static final String saveNewsPath = "westNewsImages/";
	//新闻缩略图片
	public static final String uploadTeamPath = System.getProperty("catalina.home") + "/webapps/westTeamImages";
	public static final String saveTeamPath = "westTeamImages/";
	//商品缩略图片
	public static final String uploadProductPath = System.getProperty("catalina.home") + "/webapps/westProductImages";
	public static final String saveProductPath = "westProductImages/";

	
	
	
	//备份SQL文件存放文件夹
	public static final String uploadDataPath = System.getProperty("catalina.home") + "/webapps/westData";
	

	
	public static boolean isVisibleImage(String filename){
		return filename.endsWith(".jpg") || filename.endsWith(".png") || filename.endsWith(".jpeg"); 
	}
	
	public static String createUploadFileName(String fileName){
		return UUID.randomUUID().toString() + fileName;
	}
	
	private static String ip=null;


	public static String createImageURL(String fileName){
		ServletRequest request = ServletActionContext.getRequest();
		File file = new File(fileName);
		
		try {
			String str[]=InetAddress.getLocalHost().toString().split("/");
			
		     ip=str[1];
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		//获得ip或localhost
		//return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/stygImages/" + file.getName();
		//替换为ip存储
		return request.getScheme() + "://" + ip + ":" + request.getServerPort() + "/llcrmImages/" + file.getName();
	}
	
	protected static final Logger log = Logger.getLogger(ImageUtils.class); 
	/**
	 * 删除服务器上的图片
	 * param filePath
	 */
	public static void delImage(String filePath){
		
		log.info("=====>删除图片："+filePath+"<========");
		
		File f = new File(filePath);
        f.delete();	
	}
    /**
     * 创建临时图片存放名称 以时间戳命名
     * @param ext
     * @return
     */
	public static String createTempFileName(String ext) {
		
		Date nowDate=new Date();
		return nowDate.getTime()+ ext;
	}
	
	
}
