package west.service;

import java.util.List;

import west.base.action.datatables.DataTables;
import west.entity.We_Order;
import west.entity.We_User;


public interface We_OrderService {

	 /**
     * <p>Method Name : getByPage</p>
     * <p>Method Desc : 订单分页、筛选、排序</p>
     * <p>Date : 2016-3-31 下午3:05:32</p>
     * <p>Author : XQL</p>
     * @param dtJson
     */
	public abstract void getByPage(DataTables dtJson);

	/**
	 * <p>Method Name : check</p>
	 * <p>Method Desc : 审核订单</p>
	 * <p>Date : 2016-3-31 下午4:21:57</p>
	 * <p>Author : XQL</p>
	 * @param order_id
	 * @param status 1审核通过 2审核不通过
	 * @return
	 */
	public abstract int check(int order_id, int status,int team_id);

	/**
	 * <p>Method Name : getOrder</p>
	 * <p>Method Desc : 根据ID获取订单信息</p>
	 * <p>Date : 2016-3-31 下午4:33:25</p>
	 * <p>Author : XQL</p>
	 * @param order_id
	 * @return
	 */
	public abstract We_Order getOrder(int order_id);

	public abstract void update(We_Order order);
    /**
     * @return 
     * 新建订单
     * @Title: saveNew
     * @Description: TODO
     * @author BianMingZhou
     * @date 2016-4-1 下午4:47:45
     * @param @param product
     * @param @param user
     * @param @param number 
     * @return void 
     * @throws
     */
	public  We_Order saveNew(String productJson, We_User user);

	/**
	 * <p>Method Name : getByUser</p>
	 * <p>Method Desc : 获取用户的订单</p>
	 * <p>Date : 2016-4-13 下午3:21:43</p>
	 * <p>Author : XQL</p>
	 * @param user_id
	 * @return
	 */
	public abstract List<We_Order> getByUser(int user_id,String name,int status,String start,String end);

}
