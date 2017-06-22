package west.dao.impl;



import java.util.List;

import org.springframework.stereotype.Repository;

import west.base.dao.BaseDaoImpl;
import west.dao.We_Order_TeamDao;
import west.entity.We_Order_Team;



@Repository("we_Order_TeamDao")
public class We_Order_TeamDaoImpl extends BaseDaoImpl<We_Order_Team> implements We_Order_TeamDao{

	
	/**
	 * <p>Method Name : findOnly</p>
	 * <p>Method Desc : 根据订单ID查询对应客服</p>
	 * <p>Date : 2016-4-13 下午9:57:12</p>
	 * <p>Author : XQL</p>
	 * @param order_id
	 * @return
	 */
	public We_Order_Team findOnly(int order_id){
		String hql = "from We_Order_Team where order_id.id = ?";
		List<We_Order_Team> list = super.findByHql(hql, order_id);
		
		return list != null && list.size() > 0 ? list.get(0) : null;
	}
}
