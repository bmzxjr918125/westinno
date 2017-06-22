package west.service;

import west.base.action.datatables.DataTables;


public interface We_Order_ItemService {

	public abstract void getByPage(DataTables dtJson, int order_id);

}
