package west.service;

import java.util.List;

import west.entity.We_Product_Car;
import west.entity.We_User;


public interface We_Product_CarService {

	int countByUserId(int user_id);
   /**
    *  加入购物车
    * @Title: saveNew
    * @Description: TODO
    * @author BianMingZhou
    * @date 2016-4-1 下午5:18:14
    * @param @param productJson
    * @param @param user 
    * @return void 
    * @throws
    */
	void saveNew(String productJson, We_User user);
	/**
	 * 获取购物车列表
	 * @Title: getByUserId
	 * @Description: TODO
	 * @author BianMingZhou
	 * @date 2016-4-13 下午5:20:13
	 * @param @param id
	 * @param @return 
	 * @return List<We_Product_Car> 
	 * @throws
	 */
    List<We_Product_Car> getByUserId(Integer id);
	void deleteById(int id);
	We_Product_Car getById(int car_id);
	void saveOrUpdate(We_Product_Car car);

}
