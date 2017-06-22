package west.service;

import java.util.List;

import west.entity.We_Product_Collect;

public interface We_Product_CollectService {
	/**
	 * 获取对应商品是否被收藏
	 * 
	 * @Title: getIsCollect
	 * @Description: TODO
	 * @author BianMingZhou
	 * @date 2016-3-31 下午6:49:31
	 * @param @param product_id
	 * @param @param user_id
	 * @param @return
	 * @return boolean
	 * @throws
	 */
	boolean getIsCollect(Integer product_id, Integer user_id);

	void delateByInt(int product_id, Integer user_id);

	/**
	 * <p>Method Name : getByUser</p>
	 * <p>Method Desc : 查询用户的收藏的产品</p>
	 * <p>Date : 2016-4-13 上午11:08:01</p>
	 * <p>Author : XQL</p>
	 * @param user_id
	 * @return
	 */
	public abstract List<We_Product_Collect> getByUser(int user_id);

	void save(We_Product_Collect collect);

}
