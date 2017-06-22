package west.util;

import org.hibernate.dialect.MySQLDialect;
import org.hibernate.dialect.function.SQLFunctionTemplate;

/**
 * hql不支持utf-8的汉字按拼音排序，需要转换成gbk,这就要扩展数据库方言
 * @author  BianMingZhou
 * 同时修改数据库方言配置：
<property name="hibernateProperties">
<props>
<prop key="hibernate.dialect">
<!-- org.hibernate.dialect.MySQLDialect-->
com.jbms.util.MySQLLocalDialect
</prop>
<prop key="hibernate.show_sql">true</prop>
</props>
</property> 
 *
 */
public class MySQLLocalDialect extends MySQLDialect{

	public MySQLLocalDialect() {
		super();
		registerFunction("convert", new SQLFunctionTemplate(
				org.hibernate.Hibernate.STRING, "convert(?1 using ?2)"));
	}

}
