package west.dao.impl;



import org.springframework.stereotype.Repository;

import west.base.action.datatables.DataTables;
import west.base.dao.BaseDaoImpl;
import west.dao.We_ProductDao;
import west.entity.We_Product;



@Repository("we_ProductDao")
public class We_ProductDaoImpl extends BaseDaoImpl<We_Product> implements We_ProductDao{

	public void getByPage(DataTables dtJson) {
		StringBuilder hql = new StringBuilder();

		hql.append("from We_Product where ");
		//筛选条件
		hql.append(" name like ? "); 

		super.findByPage(hql.toString(), dtJson,
				"%" + dtJson.getSearch().getValue() + "%");

	}

	public We_Product getByType(int type_one, int type_two1, int type_two2,
			int type_two3) {
		String hql=" from We_Product where id!=0 ";
		
		if(type_one==0){
			hql=hql+" and type_one_id is null ";
		}else{
			hql=hql+" and type_one_id.id="+type_one;
		}
		
		if(type_two1==0){
			hql=hql+" and type_two_1 is null ";
		}else{
			hql=hql+" and type_two_1.id="+type_two1;
		}
		if(type_two2==0){
			hql=hql+" and type_two_2 is null ";
		}else{
			hql=hql+" and type_two_2.id="+type_two2;
		}
		if(type_two3==0){
			hql=hql+" and type_two_3 is null ";
		}else{
			hql=hql+" and type_two_3.id="+type_two3;
		}
		return (We_Product) this.getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(hql).uniqueResult();
	}

}
