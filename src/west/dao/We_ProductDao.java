package west.dao;


import west.base.action.datatables.DataTables;
import west.base.dao.BaseDao;
import west.entity.We_Product;

public interface We_ProductDao extends BaseDao<We_Product>{

	void getByPage(DataTables dtJson);

	We_Product getByType(int type_one, int type_two1, int type_two2,
			int type_two3);
	
}
