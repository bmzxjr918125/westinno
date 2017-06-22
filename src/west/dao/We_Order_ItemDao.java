package west.dao;


import west.base.action.datatables.DataTables;
import west.base.dao.BaseDao;
import west.entity.We_Order_Item;

public interface We_Order_ItemDao extends BaseDao<We_Order_Item>{

	/**
	 * <p>Method Name : getByPage</p>
	 * <p>Method Desc : 查询订单详情 分页、筛选、排序</p>
	 * <p>Date : 2016-3-31 下午3:39:32</p>
	 * <p>Author : XQL</p>
	 * @param dtJson
	 * @param order_id 订单ID
	 */
	public abstract void getByPage(DataTables dtJson, int order_id);
	
}
