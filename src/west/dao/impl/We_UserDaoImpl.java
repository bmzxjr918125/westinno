package west.dao.impl;



import org.springframework.stereotype.Repository;

import west.base.action.datatables.DataTables;
import west.base.dao.BaseDaoImpl;
import west.dao.We_UserDao;
import west.entity.We_User;



@Repository("we_UserDao")
public class We_UserDaoImpl extends BaseDaoImpl<We_User> implements We_UserDao{

	/**
	 * <p>Method Name : getByPage</p>
	 * <p>Method Desc : 用户分页、筛选、排序</p>
	 * <p>Date : 2016-3-31 下午3:04:23</p>
	 * <p>Author : XQL</p>
	 * @param dtJson
	 */
	public void getByPage(DataTables dtJson) {
		StringBuilder hql = new StringBuilder();

		hql.append("from We_User where ");
		
		//筛选条件
		hql.append(" phonenum like ? or ");
		hql.append(" nickname like ? or ");
		hql.append(" e_mail like ? or ");
		hql.append(" qq like ?");
		super.findByPage(hql.toString(), dtJson,
				"%"+dtJson.getSearch().getValue()+"%",
				"%"+dtJson.getSearch().getValue()+"%",
				"%"+dtJson.getSearch().getValue()+"%",
				"%"+dtJson.getSearch().getValue()+"%");
	}
}
