package west.dao;


import java.util.List;

import west.base.dao.BaseDao;
import west.entity.We_Product_Collect;

public interface We_Product_CollectDao extends BaseDao<We_Product_Collect>{

	/**
	 * <p>Method Name : findByUser</p>
	 * <p>Method Desc : 查询用户的收藏产品</p>
	 * <p>Date : 2016-4-13 上午10:12:24</p>
	 * <p>Author : XQL</p>
	 * @param user_id 
	 * @return
	 */
	public abstract List<We_Product_Collect> findByUser(int user_id);

	void delateByInt(int product_id, Integer user_id);
	
}
