package west.dao.impl;



import java.util.List;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Repository;

import west.base.action.datatables.DataTables;
import west.base.dao.BaseDaoImpl;
import west.dao.We_NewsDao;
import west.entity.We_News;



@Repository("we_NewsDao")
public class We_NewsDaoImpl extends BaseDaoImpl<We_News> implements We_NewsDao{

	public void getByPage(DataTables dtJson) {
		StringBuffer hql = new StringBuffer();

		hql.append("from We_News where id!=0 ");
		//筛选条件

		if (dtJson.getSearch().getValue()!=null&&!dtJson.getSearch().getValue().equals("")) {
			hql.append(" and ( title like '%"+dtJson.getSearch().getValue()+"%' or tag like '%"+dtJson.getSearch().getValue()+"%' or news_type_id.name like '%"+dtJson.getSearch().getValue()+"%' or source like '%"+dtJson.getSearch().getValue()+"%' )" );
		}
		super.findByPage(hql.toString(), dtJson);
	}

	@SuppressWarnings("unchecked")
	public List<We_News> getRecommend() {
		String hql=" from We_News where is_recommend=1 order by creattime desc ";
		return this.getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(hql).setFirstResult(0).setMaxResults(9).list();
	}

	public int countAllByType(int type) {
		String hql=" select count(id) from We_News ";
		if(type!=0){
			hql=hql+" where news_type_id.id= "+type;
		}
		return ((Long)this.getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(hql).uniqueResult()).intValue();
	}

	@SuppressWarnings("unchecked")
	public List<We_News> getHtmlPage(JSONObject jsonData) {
		int pageNumber=jsonData.getInt("pageNumber");
		int currentPage=jsonData.getInt("currentPage");
		int type=jsonData.getInt("type");
		
		String hql=" from We_News ";
		
		if(type!=0){
			hql=hql+" where news_type_id.id= "+type;
		}
		hql=hql+" order by creattime desc ";
		return this.getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(hql)
				.setFirstResult((currentPage-1)*pageNumber).setMaxResults(pageNumber).list();
	}

}
