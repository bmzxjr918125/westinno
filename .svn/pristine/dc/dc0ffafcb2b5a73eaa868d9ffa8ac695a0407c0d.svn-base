package west.admin.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import west.base.action.BaseAction;
import west.util.ImageUtils;



/**
 * 系统基本信息
 * @ClassName: AdminSysInfoAction
 * @Description: TODO
 * @author BianMingZhou
 * @date 2015-10-21 上午11:20:20
 */
@Controller("adminSysInfoAction")
@Scope("prototype")
public class AdminSysInfoAction extends BaseAction {
	private static final long serialVersionUID = 4590256818048094005L;
   /**
    * 基本信息显示
    * @return
    */
	public String show(){
		
		return "show";
	}
	/**
	 * 系统数据备份
	 * @return
	 */
	/*public String DataBank(){
	   	String path=ImageUtils.basePath+"llms/llmsData.sql";
	   	Runtime javaRuntime = Runtime.getRuntime();
			try {
				Properties prop = new Properties();
				InputStream in = new FileInputStream(getClass().getResource("/").getPath()
						+ "databank.properties");
				prop.load(in);
				in.close();
				javaRuntime.exec(prop.getProperty("exec")+path);
			} catch (IOException e) {
				e.printStackTrace();
			}
		return "DataBank";
	}*/
	
	public String DataBank(){
	   	String path=ImageUtils.basePath+"debtms/debtmsData.sql";
	   	Runtime javaRuntime = Runtime.getRuntime();
			try {
				Properties prop = new Properties();
				InputStream in = new FileInputStream(getClass().getResource("/").getPath()
						+ "databank.properties");
				prop.load(in);
				in.close();
				javaRuntime.exec(prop.getProperty("bankFileExec")+path);
			} catch (IOException e) {
				e.printStackTrace();
			}
		return "DataBank";
	}
	
			private String filename;
			public void daochu(){
				 response.setContentType("text/xml;charset=utf-8"); 
				 response.setCharacterEncoding("UTF-8");  
				 response.setHeader("Cache-Control", "no-cache");   
				 PrintWriter out;
				 try {
					out = response.getWriter();
					out.print(0);
				} catch (IOException e) {
					e.printStackTrace();
				}
					
					
				
			}
			
			public void xiazai(){

				try{
					 String path=ImageUtils.basePath+"debtms/debtmsData.sql";
				filename="llms.sql";
			   File file=new File(path);
			    response.setContentType( "multipart/form-data"); 
				response.setCharacterEncoding("UTF-8");  
				response.addHeader( "Content-Disposition","attachment;filename="+filename); 
				java.io.OutputStream os = response.getOutputStream(); 
				java.io.FileInputStream fis = new java.io.FileInputStream(file); 

				byte[] b = new byte[1024]; 
				int i = 0; 
				
				while ( (i = fis.read(b)) > 0) { 
				os.write(b, 0, i); 
				} 
				fis.close();
				os.flush();
				os.close(); 
			 
				}catch (Exception e) {
					// TODO: handle exception
				}
				
			}
			public String getFilename() {
				return filename;
			}
			public void setFilename(String filename) {
				this.filename = filename;
			}
			
			
	
}
