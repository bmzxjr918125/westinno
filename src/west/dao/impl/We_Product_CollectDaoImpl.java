package west.dao.impl;



import java.util.List;

import org.springframework.stereotype.Repository;

import west.base.dao.BaseDaoImpl;
import west.dao.We_Product_CollectDao;
import west.entity.We_Product_Collect;



@Repository("we_Product_CollectDao")
public class We_Product_CollectDaoImpl extends BaseDaoImpl<We_Product_Collect> implements We_Product_CollectDao{
	
	/**
	 * <p>Method Name : findByUser</p>
	 * <p>Method Desc : 查询用户的收藏产品</p>
	 * <p>Date : 2016-4-13 上午10:12:24</p>
	 * <p>Author : XQL</p>
	 * @param user_id
	 * @return
	 */
	public List<We_Product_Collect> findByUser(int user_id){
		String hql = "from We_Product_Collect where user_id.id = ? order by creattime desc";
		
		return super.findByHql(hql, user_id);
	}
	public void delateByInt(int product_id, Integer user_id) {
		String hql=" delete We_Product_Collect where product_id.id="+product_id+" and user_id.id="+user_id;
		this.getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(hql).executeUpdate();
	}

}
