package west.service;

import west.base.action.datatables.DataTables;
import west.entity.We_Product;


public interface We_ProductService {

	void getByPage(DataTables dtJson);

	We_Product getById(int id);

	void saveOrUpdate(We_Product product);

	We_Product getByType(int type_one, int type_two1, int type_two2,
			int type_two3);

}
