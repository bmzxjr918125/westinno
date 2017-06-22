package west.quarz;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

import west.util.ImageUtils;
import west.util.SqlDataUtils;


/**
 * mysql数据库备份 job
 * @author  BianMingZhou
 *
 */

public class DataTimer extends QuartzJobBean {

	@SuppressWarnings("unused")
	private static BeanFactory factory = new ClassPathXmlApplicationContext(
			"applicationContext.xml");
	//输出到lo4j中对应配置的路径
	private Logger logger = Logger.getLogger("dataTimer");

     /**
      * 判断文件夹是否存在
      */
	  static{
			File file=new File(ImageUtils.uploadDataPath+"debtmsData");
			if(!file.exists()&& !file .isDirectory()){
					file.mkdirs();
			}
		}
	  
	  
	@Override
	protected void executeInternal(JobExecutionContext arg0)
			throws JobExecutionException {
		Date date = new Date();
		SimpleDateFormat sdfDateFormat = new SimpleDateFormat(
				"yyyy-MM-dd");
		logger.info(sdfDateFormat.format(date) + "Excute->DataTimer<-！");
	     SqlDataUtils sdu=new SqlDataUtils();
	     sdu.backup();
		/*	String path=ImageUtils.uploadDataPath+"llmsData/"+name+".sql";
	   	Runtime javaRuntime = Runtime.getRuntime();
			try {
				Properties prop = new Properties();
				InputStream in = new FileInputStream(getClass().getResource("/")
						.getPath()
						+ "databank.properties");
				prop.load(in);
				in.close();
				
				javaRuntime.exec(prop.getProperty("exec")+path);
			} catch (IOException e) {
				e.printStackTrace();
			}*/
		logger.info("---End->DataTimer<-");

	}

}