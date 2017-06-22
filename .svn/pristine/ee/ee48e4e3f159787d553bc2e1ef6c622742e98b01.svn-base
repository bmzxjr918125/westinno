package west.dao.impl;



import java.util.List;

import org.springframework.stereotype.Repository;

import west.base.dao.BaseDaoImpl;
import west.dao.We_Product_CarDao;
import west.entity.We_Product_Car;



@Repository("we_Product_CarDao")
public class We_Product_CarDaoImpl extends BaseDaoImpl<We_Product_Car> implements We_Product_CarDao{

	public int countByUserId(int user_id) {
		String hql=" select count(id) from We_Product_Car where user_id.id="+user_id;
		return ((Long)this.getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(hql).uniqueResult()).intValue();
	}

	@SuppressWarnings("unchecked")
	public List<We_Product_Car> getByUserId(Integer user_id) {
		String hql=" from We_Product_Car where user_id.id="+user_id+" order by creattime desc ";
		return this.getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(hql).list();
	}

}
