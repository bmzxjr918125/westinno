package west.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import west.base.action.datatables.DataTables;
import west.dao.We_AdminDao;
import west.entity.We_Admin;
import west.service.We_AdminService;
import west.util.Md5Utils;



@Service("we_AdminService")
public class We_AdminServiceImpl implements We_AdminService{
	
	private We_AdminDao we_AdminDao;

	public We_Admin getAdminByName(String param,String value){
		
		return we_AdminDao.getAdminByName(param, value);
	}
	
	public void updateOrSave(We_Admin admin){
		
		we_AdminDao.update(admin);
	}
	
	
	public We_AdminDao getlc_AdminDao() {
		return we_AdminDao;
	}

	@Resource(name="we_AdminDao")
	public void setlc_AdminDao(We_AdminDao de_AdminDao) {
		this.we_AdminDao = de_AdminDao;
	}

	public We_Admin getById(int id) {
		return we_AdminDao.get(id);
	}

	public void saveOrUpdate(We_Admin l_Admin) {
		we_AdminDao.saveOrUpdate(l_Admin);
	}
	
	/**
	 * <p>Methods : checkLogin</P>
	 * <p>Description : 验证用户登录是否成功</p>
	 * @Date : 2015年9月10日 下午2:40:35
	 * @param admin
	 */
	public We_Admin checkLogin(We_Admin admin){
		
		//验证用户名和密码是否为空
		if(admin == null || 
		   admin.getUsername() == null ||
		   admin.getPassword() == null ||
		   "".equals(admin.getUsername().trim()) || 
		   "".equals(admin.getPassword().trim())) return null;
		
		admin.setPassword(Md5Utils.md5(Md5Utils.md5(admin.getPassword())));//对密码进行加密
		
		return we_AdminDao.getByNameAndPwd(admin);
	}
	
	/**
	 * <p>Methods : updateBystate</P>
	 * <p>Description : 更新登录后的相关信息</p>
	 * @Date : 2015年9月10日 下午5:16:11
	 * @param admin
	 */
	public void updateByState(We_Admin admin){
		we_AdminDao.update(admin);
	}
	
	/**
	 * <p>Methods : getByPage</P>
	 * <p>Description : 分页、条件、排序查询管理员信息</p>
	 * @Date : 2015年9月10日 下午5:48:07
	 * @param dt
	 */
	public void getByPage(DataTables dt) {
		we_AdminDao.getByPage(dt);
	}
	
	/**
	 * <p>Methods : getByUsername</P>
	 * <p>Description : 根据用户名查询单个用户信息</p>
	 * @Date : 2015年9月11日 下午2:57:59
	 * @param admin
	 * @return
	 */
	public We_Admin getOnlyByUsername(We_Admin admin){
		//验证用户名是否有效
		if(admin != null && admin.getUsername() != null && !"".equals(admin.getUsername())){
			List<We_Admin> list = we_AdminDao.findByName("username", "'"+admin.getUsername()+"'");
			return list != null && list.size() > 0 ? list.get(0) : null;
		}else{
			return null;
		}
	}
	
	/**
	 * <p>Methods : addSave</P>
	 * <p>Description : 新增用户</p>
	 * @Date : 2015年9月11日 下午3:51:25
	 * @param admin
	 * @return
	 */
	public boolean addSave(We_Admin admin,String echoPwd){
		
		//验证两次密码是否相同
		if(!"".equals(echoPwd) && echoPwd.equals(admin.getPassword())){
			//加密
			admin.setPassword(Md5Utils.md5(Md5Utils.md5(admin.getPassword())));
			//初始值
			admin.setCreattime(new Date());
			
			we_AdminDao.save(admin);
			
			return true;
		}else return false;
	}
	
	/**
	 * <p>Methods : getOnlyById</P>
	 * <p>Description : 根据用户ID查询用户信息</p>
	 * @Date : 2015年9月11日 下午5:02:33
	 * @param id
	 * @return 
	 */
	public We_Admin getOnlyById(int id){
		return we_AdminDao.get(id);
	}
	
	/**
	 * <p>Methods : updatePasswordSave</P>
	 * <p>Description : 修改用户密码</p>
	 * @Date : 2015年9月11日 下午5:40:16
	 * @param id 账户ID
	 * @param oldPwd 旧密码
	 * @param newPwd 新密码
	 * @param echoPwd 重复密码
	 * @return 0修改成功 1旧密码或新密码或重复密码错误 2旧密码输入错误 3没有查找到该账户 4新密码和重复密码不相同
	 */
	public int updatePasswordSave(int id,String oldPwd,String newPwd,String echoPwd){
		//验证值是否为空
		if("".equals(oldPwd+"") || "".equals(newPwd+"") || "".equals(echoPwd+"")) return 1;
		
		//新密码和重复密码不相同
		if((newPwd).equals(echoPwd)){
			We_Admin admin = we_AdminDao.get(id);
			
			//没有查找该账户
			if(admin != null){
				//验证输入的旧密码是否相同
				if(admin.getPassword().equals(Md5Utils.md5(Md5Utils.md5(oldPwd)))){
					
					admin.setPassword(Md5Utils.md5(Md5Utils.md5(newPwd)));
					
					we_AdminDao.update(admin);
					
					return 0;
					
				}else return 2;
			} return 3;
			
		}else return 4;
	}
	
	/**
	 * <p>Methods : updatePowerSave</P>
	 * <p>Description : 保存已设置权限的用户信息</p>
	 * @Date : 2015年9月12日 上午9:48:09
	 * @param admin
	 * @return
	 */
	public boolean updatePowerSave(We_Admin admin){
		We_Admin lc_Admin = we_AdminDao.get(admin.getId());
		
		//验证是否已存在该用户
		if(lc_Admin != null){
			lc_Admin.setRole_type(admin.getRole_type());
			
			we_AdminDao.update(lc_Admin);
			
			return true;
		}
		
		return false;
	}
	
	/**
	 * <p>Methods : deleteByBatch</P>
	 * <p>Description : 批量删除管理员帐户</p>
	 * @Date : 2015年9月12日 上午10:53:19
	 * @param ids
	 * @return
	 */
	public boolean deleteByBatch(String ids){
		//验证ids不能为空
		if(!"".equals(ids+"")){
			List<Integer> idsList = new ArrayList<Integer>();
			for(String id : ids.split(",")){
				idsList.add(Integer.parseInt(id));
			}
			we_AdminDao.delete(idsList);
			return true;
		}
		return false;
	}

}
