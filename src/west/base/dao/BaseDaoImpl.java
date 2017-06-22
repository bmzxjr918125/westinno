package west.base.dao;

import java.lang.reflect.ParameterizedType;
import java.util.Collections;
import java.util.List;
import javax.annotation.Resource;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateTemplate;

import west.base.action.datatables.DataTables;
import west.base.action.datatables.Order;



@SuppressWarnings("unchecked")
public class BaseDaoImpl<T> implements BaseDao<T> {

	private HibernateTemplate hibernateTemplate = null;
	private Class<T> classzz;

	private void initClasszz() {
		this.classzz = (Class<T>) ((ParameterizedType) this.getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public void save(T t) {
		this.getHibernateTemplate().save(t);
	}

	public void delete(T t) {
		this.getHibernateTemplate().delete(t);
	}

	public void update(T t) {
		this.getHibernateTemplate().update(t);
	}
	
	public void merge(T t) {
		this.getHibernateTemplate().merge(t);
	}

	public List<T> getByIdList(List<Integer> idList) {
		this.initClasszz();
		if (idList == null || idList.size() <= 0) {
			return Collections.EMPTY_LIST;
		}
		return this
				.getHibernateTemplate()
				.getSessionFactory()
				.getCurrentSession()
				.createQuery(
						"from " + classzz.getName() + " where id in(:idList)")
				.setParameterList("idList", idList).list();
	}

	public T load(int id) {
		this.initClasszz();
		return (T) this.getHibernateTemplate().load(this.classzz, id);
	}

	public List<T> findAll() {
		this.initClasszz();
		return this.getHibernateTemplate().find(
				"from " + this.classzz.getName());
	}


	public int count() {
		this.initClasszz();
		return ((Long) this.getHibernateTemplate().getSessionFactory()
				.getCurrentSession()
				.createQuery("select count(*) from " + this.classzz.getName())
				.uniqueResult()).intValue();
	}

	public void saveOrUpdate(T t) {
		//添加事务后清楚session后部分更新不执行
		/*this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.clear();*/

		this.getHibernateTemplate().saveOrUpdate(t);
	}

	public void delete(List<Integer> ids) {
		this.getHibernateTemplate().deleteAll(this.getByIdList(ids));
	}

	public T get(int id) {
		this.initClasszz();
		return (T) this.getHibernateTemplate().get(this.classzz, id);
	}

	public Session getCurrentSession() {
		return this.getHibernateTemplate().getSessionFactory()
				.getCurrentSession();
	}

	

	public List<T> getListByNameAndId(String str, int i) {
		this.initClasszz();

		return (List<T>) this
				.getHibernateTemplate()
				.getSessionFactory()
				.getCurrentSession()
				.createQuery(
						" from " + this.classzz.getName() + " where " + str
								+ " = " + i).list();
	}

	public List<T> findByName(String name, String str) {
		this.initClasszz();
		 Query query=this.getHibernateTemplate()
				.getSessionFactory()
				.getCurrentSession()
				.createQuery(
						" from " + this.classzz.getName() + " where " + name
								+ " = ?");
		// this.getHibernateTemplate().getSessionFactory().getCurrentSession().clear();
		 query.setString(0,str);
		 List<T> list = (List<T>)query.list();
		 return list;
	}

	public void deleteById(int id) {
		this.initClasszz();

		Session session = getHibernateTemplate().getSessionFactory()
				.getCurrentSession();
		String hql = " delete " + this.classzz.getName() + " where id =:id";
		// Transaction transaction=session.getTransaction();
		// transaction.begin();
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		query.executeUpdate();
		// session.createQuery(" delete "+this.classzz.getName()+" where id = "+id);
		// transaction.commit();

		// session.close();
		/*
		 * .getCurrentSession().createQuery( " delete from "+
		 * this.classzz.getName() +" where id = " + id);
		 */
	}

	public List<T> findByInt(String name, int i) {
		this.initClasszz();
		return (List<T>) this
				.getHibernateTemplate()
				.getSessionFactory()
				.getCurrentSession()
				.createQuery(
						" from " + this.classzz.getName() + " where " + name
								+ " = " + i).list();
	}

	public List<T> getPage(int displayStart, int displayLength, String hql) {
		this.initClasszz();
		return this.getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createQuery(
						"from " + this.classzz.getName()+hql).setFirstResult(displayStart)
				.setMaxResults(displayLength).list();
	}

	public int getPageCount(String hql) {
		this.initClasszz();
		return ((Long) this.getHibernateTemplate().getSessionFactory()
				.getCurrentSession()
				.createQuery("select count(*) from " + this.classzz.getName()+hql)
				.uniqueResult()).intValue();
	}

	public List<T> findByIntAndStr(String name1, int i, String name2,
			String value) {
		this.initClasszz();
		return (List<T>) this
				.getHibernateTemplate()
				.getSessionFactory()
				.getCurrentSession()
				.createQuery(
						" from " + this.classzz.getName() + " where "+name1+"= ? and "+name2+" = ?")
						.setInteger(0,i)
						.setString(1,value)
						.list();
	}

	public List<T> findByIntAndInt(String name1, int i, String name2, int j) {
		this.initClasszz();
		return (List<T>) this
				.getHibernateTemplate()
				.getSessionFactory()
				.getCurrentSession()
				.createQuery(
						" from " + this.classzz.getName() + " where "+name1+" = "+i+" and "+name2+" = "+j)
						.list();
	}

	/**
	 * <p>Methods : findByPage</P>
	 * <p>Description : 通用HQL分页查询返回DataTables对象</p>
	 * @Date : 2015年9月10日 下午1:55:18
	 * @param hql HQL语句
	 * @param dt DataTables对象
	 * @param params HQL语句参数集
	 * @return
	 */
	public void findByPage(String hql, DataTables dt,Object... params) {
		//this.getHibernateTemplate().setCacheQueries(true);
		//排序
		StringBuffer sbOrder = new StringBuffer();
		for(Order order : dt.getOrder()){
			String fields = dt.getColumns().get(order.getColumn()).getData();
			String direction = order.getDir();
			sbOrder.append(fields + " " + direction+",");
		}
		String orderStr = sbOrder.length() > 0 ? " order by " + sbOrder.substring(0, sbOrder.length()-1) : "";

		//查询
		Query query = this.getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(hql+orderStr);
		Query queryCount = this.getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery("select count(*) " + hql);
		if(params != null && params.length>0){
			for(int i=0;i<params.length;i++){
				query.setString(i, params[i].toString());
				queryCount.setString(i, params[i].toString());
			}
		}
		
		//总条数
		int count = ((Long)(queryCount.uniqueResult())).intValue();
		
		@SuppressWarnings("rawtypes")
		List list = query.setFirstResult(dt.getStart()).setMaxResults(dt.getLength()).setCacheable(true).list();
		
		dt.setRecordsTotal(count);
		dt.setRecordsFiltered(count);
		
		dt.setData(list);
		
	}
	
	/**
	 * <p>Methods : queryByAll</P>
	 * <p>Description : 根据HQL语句查询数据</p>
	 * @Date : 2015年9月10日 下午2:07:27
	 * @param hql HQL语句
	 * @param params HQL语句参数集
	 * @return
	 */
	public List<T> findByHql(String hql, Object...params){
		//this.getHibernateTemplate().setCacheQueries(true);
		Query query = this.getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(hql);
		if(params != null && params.length>0){
			for(int i=0;i<params.length;i++){
				query.setString(i, params[i].toString());
			}
		}
		return  query.list();
	}
	
	/**
	 * <p>Methods : runByHql</P>
	 * <p>Description : 通用执行HQL语句</p>
	 * @Date : 2015年9月12日 上午10:46:54
	 * @param hql
	 * @return
	 */
	public boolean runByHql(String hql, Object...params) {
		try {
			Query query = this.getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(hql);
			if(params != null && params.length>0){
				for(int i=0;i<params.length;i++){
					query.setString(i, params[i].toString());
				}
			}
			query.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
