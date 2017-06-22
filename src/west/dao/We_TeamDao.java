package west.dao;


import west.base.action.datatables.DataTables;
import west.base.dao.BaseDao;
import west.entity.We_Team;

public interface We_TeamDao extends BaseDao<We_Team>{

	void getByPage(DataTables dtJson);

	
}
