package west.service.impl;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import west.base.action.datatables.DataTables;
import west.dao.We_UserDao;
import west.entity.We_User;
import west.service.We_UserService;
import west.util.Md5Utils;



@Service("we_UserService")
public class We_UserServiceImpl implements We_UserService{
	private We_UserDao we_UserDao;
    
	
	public We_User getByPhoneNum(String phonenum) {
		List<We_User> userList=new ArrayList<We_User>();
		userList=we_UserDao.findByName("phonenum",phonenum);
		if(userList!=null&&userList.size()>0){
			return userList.get(0);
		}else{
			return null;
		}
	}
	
	public We_User getByEmail(String email){
		List<We_User> list = we_UserDao.findByName("e_mail", email);
		return list != null && list.size() > 0 ? list.get(0) : null;
	}
	
	public We_UserDao getWe_UserDao() {
		return we_UserDao;
	}
    @Resource(name="we_UserDao")
	public void setWe_UserDao(We_UserDao we_UserDao) {
		this.we_UserDao = we_UserDao;
	}

	public int register(String phoneNum, String password, int type) {
		We_User we_User=null;
		if(type==1){
			we_User=getByPhoneNum(phoneNum);
			if(we_User!=null){
				return -1;
			}else{
				we_User=new We_User();
				we_User.setPhonenum(phoneNum);
				we_User.setNickname(phoneNum);
				we_User.setPassword(Md5Utils.md5(Md5Utils.md5(password)));
				we_User.setSex((byte)1);
				we_User.setCreattime(new Date());
				we_User.setUpdatetime(new Date());
				we_User.setIs_complete((byte)0);
				we_User.setIs_other((byte)0);
				we_UserDao.save(we_User);
				return we_User.getId();
			}
		}else{//第三方注册
			return -1;
		}
	}

	public We_User getById(int id) {
		
		return we_UserDao.get(id);
	}
    /**
     * 登录保存
     * 返回
     */
	public int loginSave(String phoneNum, String password) {
	    We_User	we_User = phoneNum.contains("@") ? getByEmail(phoneNum) : getByPhoneNum(phoneNum);
		if(we_User!=null){
			if(we_User.getPassword().equals(password)){
				we_User.setLastlogintime(we_User.getThislogintime());
				we_User.setThislogintime(new Date());
				we_UserDao.saveOrUpdate(we_User);
				return we_User.getId();
			}else{
				return -2;
			}
		}else{
			return -1;
		}
		
	}

	public void saveOrUpdate(We_User user) {
		we_UserDao.saveOrUpdate(user);
	}
	
	 /**
     * <p>Method Name : getByPage</p>
     * <p>Method Desc : 用户分页、筛选、排序</p>
     * <p>Date : 2016-3-31 下午3:05:32</p>
     * <p>Author : XQL</p>
     * @param dtJson
     */
	public void getByPage(DataTables dtJson) {
    	we_UserDao.getByPage(dtJson);
	}
	
}
