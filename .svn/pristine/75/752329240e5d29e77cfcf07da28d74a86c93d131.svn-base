package west.dao.impl;


import java.util.List;

import org.springframework.stereotype.Repository;

import west.base.action.datatables.DataTables;
import west.base.dao.BaseDaoImpl;
import west.dao.We_AdminDao;
import west.entity.We_Admin;



@Repository("we_AdminDao")
public class We_AdminDaoImpl extends BaseDaoImpl<We_Admin> implements We_AdminDao{

	public We_Admin getAdminByName(String param,String value){
		String hql = "from We_Admin where "+param+"='"+value+"'";
		return (We_Admin) this.getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(hql).uniqueResult();
	}
	
	/**
	 * <p>Methods : getByNameAndPwd</P>
	 * <p>Description : 根据用户名和密码查询用户</p>
	 * @Date : 2015年9月10日 下午2:39:58
	 * @param admin
	 */
	public We_Admin getByNameAndPwd(We_Admin admin) {
		
		String hql = "from We_Admin where username = ? and password = ?";
		
		List<We_Admin> list = super.findByHql(hql, admin.getUsername(),admin.getPassword());
		
		return list != null && list.size() > 0 ? list.get(0) : null; 
	}
	
	/**
	 * <p>Methods : getByPage</P>
	 * <p>Description : 分页查询管理员数据</p>
	 * @Date : 2015年9月10日 下午5:46:12
	 * @param dt
	 */
	public void getByPage(DataTables dt){
		StringBuffer hql = new StringBuffer();
		
		hql.append("from We_Admin ");
		
		//筛选条件
		hql.append("where username like '%"+dt.getSearch().getValue()+"%' ");
		
		//排序
		//hql.append("order by "+dt.getColumns().get(dt.getOrder().get(0).getColumn()).getData()+" "+dt.getOrder().get(0).getDir());
		
		super.findByPage(hql.toString(), dt);
	}

}
