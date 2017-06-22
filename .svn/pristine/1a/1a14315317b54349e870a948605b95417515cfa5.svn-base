package west.dao;


import west.base.action.datatables.DataTables;
import west.base.dao.BaseDao;
import west.entity.We_Admin;

public interface We_AdminDao extends BaseDao<We_Admin>{

	/**
	 * 根据指定字段以及字段的值获取Admin
	 * @param param
	 * @param value
	 * @return
	 */
	public We_Admin getAdminByName(String param,String value);

	public We_Admin getByNameAndPwd(We_Admin admin);
	
	public void getByPage(DataTables dt);
	
}
