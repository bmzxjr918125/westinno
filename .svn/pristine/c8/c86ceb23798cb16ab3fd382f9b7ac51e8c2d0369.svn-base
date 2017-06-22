package west.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import west.dao.We_Product_CollectDao;
import west.entity.We_Product_Collect;
import west.service.We_Product_CollectService;

@Service("we_Product_CollectService")
public class We_Product_CollectServiceImpl implements We_Product_CollectService {
	private We_Product_CollectDao we_Product_CollectDao;

	public boolean getIsCollect(Integer product_id, Integer user_id) {
		List<We_Product_Collect> collectList = we_Product_CollectDao
				.findByIntAndInt("product_id.id", product_id, "user_id.id",
						user_id);
		if (collectList != null && collectList.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * <p>Method Name : getByUser</p>
	 * <p>Method Desc : 查询用户的收藏的产品</p>
	 * <p>Date : 2016-4-13 上午10:16:03</p>
	 * <p>Author : XQL</p>
	 * @param user_id
	 * @return
	 */
	public List<We_Product_Collect> getByUser(int user_id){
		return we_Product_CollectDao.findByUser(user_id);
	}
     public void delateByInt(int product_id, Integer user_id) {
    	 we_Product_CollectDao.delateByInt(product_id,user_id);
 	}
     public void save(We_Product_Collect collect) {
    	 we_Product_CollectDao.save(collect);
 	}
	
	public We_Product_CollectDao getWe_Product_CollectDao() {
		return we_Product_CollectDao;
	}

	@Resource(name = "we_Product_CollectDao")
	public void setWe_Product_CollectDao(
			We_Product_CollectDao we_Product_CollectDao) {
		this.we_Product_CollectDao = we_Product_CollectDao;
	}
}
