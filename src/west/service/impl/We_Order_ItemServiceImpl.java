package west.service.impl;




import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import west.base.action.datatables.DataTables;
import west.dao.We_Order_ItemDao;
import west.entity.We_Order_Item;
import west.service.We_Order_ItemService;



@Service("we_Order_ItemService")
public class We_Order_ItemServiceImpl implements We_Order_ItemService{
   	private We_Order_ItemDao we_Order_ItemDao;
	public We_Order_ItemDao getWe_Order_ItemDao() {
		return we_Order_ItemDao;
	}
	@Resource(name="we_Order_ItemDao")
	public void setWe_Order_ItemDao(We_Order_ItemDao we_Order_ItemDao) {
		this.we_Order_ItemDao = we_Order_ItemDao;
	}

	/**
	 * <p>Method Name : getByPage</p>
	 * <p>Method Desc : 订单详情分页、筛选、排序</p>
	 * <p>Date : 2016-3-31 下午3:44:22</p>
	 * <p>Author : XQL</p>
	 * @param dtJson
	 * @param order_id
	 */
	public void getByPage(DataTables dtJson,int order_id) {
		we_Order_ItemDao.getByPage(dtJson,order_id);
	}
	
}
