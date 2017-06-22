package west.dao.impl;



import org.springframework.stereotype.Repository;

import west.base.action.datatables.DataTables;
import west.base.dao.BaseDaoImpl;
import west.dao.We_TeamDao;
import west.entity.We_Team;



@Repository("we_TeamDao")
public class We_TeamDaoImpl extends BaseDaoImpl<We_Team> implements We_TeamDao{

	public void getByPage(DataTables dtJson) {
		StringBuffer hql = new StringBuffer();

		hql.append("from We_Team where id!=0 ");
		//筛选条件
		if (dtJson.getSearch().getValue()!=null&&!dtJson.getSearch().getValue().equals("")) {
			hql.append(" and ( name like '%"+dtJson.getSearch().getValue()+"%' or qq like '%"+dtJson.getSearch().getValue()+"%' or phonenum like '%"+dtJson.getSearch().getValue()+"%' or e_mail like '%"+dtJson.getSearch().getValue()+"%' )" );
		}
		super.findByPage(hql.toString(), dtJson);
	}


}
