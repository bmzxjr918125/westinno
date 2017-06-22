package west.dao.impl;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import west.base.action.datatables.DataTables;
import west.base.dao.BaseDaoImpl;
import west.dao.We_OrderDao;
import west.entity.We_Order;



@Repository("we_OrderDao")
public class We_OrderDaoImpl extends BaseDaoImpl<We_Order> implements We_OrderDao{

	/**
	 * <p>Method Name : getByPage</p>
	 * <p>Method Desc : 订单分页、筛选、排序</p>
	 * <p>Date : 2016-3-31 下午3:04:23</p>
	 * <p>Author : XQL</p>
	 * @param dtJson
	 */
	public void getByPage(DataTables dtJson) {
		StringBuilder hql = new StringBuilder();

		hql.append("from We_Order where ");
		
		//筛选条件
		hql.append(" ordernum like ? or ");
		hql.append(" name like ? or ");
		hql.append(" user_id.nickname like ? or ");
		hql.append(" user_id.phonenum like ?");
		super.findByPage(hql.toString(), dtJson,
				"%"+dtJson.getSearch().getValue()+"%",
				"%"+dtJson.getSearch().getValue()+"%",
				"%"+dtJson.getSearch().getValue()+"%",
				"%"+dtJson.getSearch().getValue()+"%");
	}
	
	/**
	 * <p>Method Name : findByUser</p>
	 * <p>Method Desc : 获取用户的订单</p>
	 * <p>Date : 2016-4-13 下午3:20:05</p>
	 * <p>Author : XQL</p>
	 * @param user_id
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public List<We_Order> findByUser(int user_id,String name ,int status,String start,String end){
		StringBuilder hql = new StringBuilder();
		hql.append("from We_Order ");
		hql.append("where user_id.id = ? ");
		if(status != 0){
			hql.append("and status = " + status);
		}
		hql.append("and name like ? ");
		
		if(!StringUtils.isEmpty(start) && !StringUtils.isEmpty(end)){
			if(start.equals(end)){
				try {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					Date end_date = sdf.parse(end);
					end_date.setDate(end_date.getDate() + 1);
					hql.append("and creattime between '" + start + "' and '" + sdf.format(end_date) + "' ");
				} catch (ParseException e) {
					end = "";
				}
			}else{
				hql.append("and creattime between '" + start + "' and '" + end + "' ");
			}
		}
		if(!StringUtils.isEmpty(start) && StringUtils.isEmpty(end)){
			hql.append("and creattime >= '" + start + "' ");
		}
		if(StringUtils.isEmpty(start) && !StringUtils.isEmpty(end)){
			hql.append("and creattime <= '" + end + "' ");
		}
		
		hql.append(" order by creattime desc");
		return super.findByHql(hql.toString(), user_id,"%"+name+"%");
	}

}
