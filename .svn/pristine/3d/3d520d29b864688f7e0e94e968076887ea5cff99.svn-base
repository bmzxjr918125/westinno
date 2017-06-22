package west.dao;


import java.util.List;

import west.base.action.datatables.DataTables;
import west.base.dao.BaseDao;
import west.entity.We_Order;

public interface We_OrderDao extends BaseDao<We_Order>{

	/**
	 * <p>Method Name : getByPage</p>
	 * <p>Method Desc : 订单分页、筛选、排序</p>
	 * <p>Date : 2016-3-31 下午3:04:23</p>
	 * <p>Author : XQL</p>
	 * @param dtJson
	 */
	public abstract void getByPage(DataTables dtJson);

	/**
	 * <p>Method Name : findByUser</p>
	 * <p>Method Desc : 获取用户的订单</p>
	 * <p>Date : 2016-4-13 下午3:20:05</p>
	 * <p>Author : XQL</p>
	 * @param user_id
	 * @return
	 */
	public abstract List<We_Order> findByUser(int user_id,String name ,int status,String start,String end);
	
}
