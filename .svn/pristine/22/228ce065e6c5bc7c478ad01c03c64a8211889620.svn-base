package west.service;

import west.base.action.datatables.DataTables;
import west.entity.We_Admin;

public interface We_AdminService {

	/**
	 * 根据指定字段以及指定字段的值获取Admin
	 * @param param
	 * @param value
	 * @return
	 */
	public We_Admin getAdminByName(String param,String value);
	
	/**
	 * 修改Admin信息
	 * @param admin
	 */
	public void updateOrSave(We_Admin admin);

	public We_Admin getById(int id);

	public void saveOrUpdate(We_Admin l_Admin);
	
	public We_Admin checkLogin(We_Admin admin);
	
	public void updateByState(We_Admin admin);
	
	public void getByPage(DataTables dt);
	
	public We_Admin getOnlyByUsername(We_Admin admin);
	
	public boolean addSave(We_Admin admin,String echoPwd);
	
	public We_Admin getOnlyById(int id);
	
	public int updatePasswordSave(int id,String oldPwd,String newPwd,String echoPwd);
	
	public boolean updatePowerSave(We_Admin admin);
	
	public boolean deleteByBatch(String ids);
}
