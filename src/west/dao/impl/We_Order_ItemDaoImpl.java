package west.dao.impl;



import org.springframework.stereotype.Repository;

import west.base.action.datatables.DataTables;
import west.base.dao.BaseDaoImpl;
import west.dao.We_Order_ItemDao;
import west.entity.We_Order_Item;
import west.entity.We_Order_Team;



@Repository("we_Order_ItemDao")
public class We_Order_ItemDaoImpl extends BaseDaoImpl<We_Order_Item> implements We_Order_ItemDao{

	/**
	 * <p>Method Name : getByPage</p>
	 * <p>Method Desc : 查询订单详情 分页、筛选、排序</p>
	 * <p>Date : 2016-3-31 下午3:39:32</p>
	 * <p>Author : XQL</p>
	 * @param dtJson
	 * @param order_id 订单ID
	 */
	public void getByPage(DataTables dtJson,int order_id) {
		StringBuilder hql = new StringBuilder();

		hql.append("from We_Order_Item where order_id.id = ? and ( ");
		
		//筛选条件
		hql.append(" order_id.ordernum like ? or ");
		hql.append(" order_id.name like ? or ");
		hql.append(" product_id.name like ? or ");
		hql.append(" product_id.price like ?)");
		super.findByPage(hql.toString(), dtJson,order_id,
				"%"+dtJson.getSearch().getValue()+"%",
				"%"+dtJson.getSearch().getValue()+"%",
				"%"+dtJson.getSearch().getValue()+"%",
				"%"+dtJson.getSearch().getValue()+"%");
	}
}
