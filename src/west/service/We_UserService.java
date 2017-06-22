package west.service;

import west.base.action.datatables.DataTables;
import west.entity.We_User;


public interface We_UserService {
    /**
     * 通过手机号获取用户信息
     * @Title: getByPhoneNum
     * @Description: TODO
     * @author BianMingZhou
     * @date 2016-3-25 下午2:08:59
     * @param @param phonenum
     * @param @return 
     * @return We_User 
     * @throws
     */
	We_User getByPhoneNum(String phonenum);
    /**
     * 用户注册
     * @Title: register
     * @Description: TODO
     * @author BianMingZhou
     * @date 2016-3-28 下午2:25:49
     * @param @param phoneNum
     * @param @param password 未加密密码
     * @param @param type  1正常注册  2第三方
     * @return int id注册成功 -1该手机号码已被注册
     * @throws
     */
	int register(String phoneNum, String password, int type);
	We_User getById(int id);
	/**
	 * 登录保存
	 * @Title: loginSave
	 * @Description: TODO
	 * @author BianMingZhou
	 * @date 2016-3-29 上午11:08:12
	 * @param @param phoneNum
	 * @param @param password
	 * @param @return 
	 * @return int >id0登录成功  -1未找到该用户 -2用户名密码不匹配  
	 * @throws
	 */
	int loginSave(String phoneNum, String password);
	
	void saveOrUpdate(We_User user);
	
	 /**
     * <p>Method Name : getByPage</p>
     * <p>Method Desc : 用户分页、筛选、排序</p>
     * <p>Date : 2016-3-31 下午3:05:32</p>
     * <p>Author : XQL</p>
     * @param dtJson
     */
	public abstract void getByPage(DataTables dtJson);
	public abstract We_User getByEmail(String email);
	
	
  
}
