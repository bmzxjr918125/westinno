package west.service.impl;


import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Service;

import west.dao.We_ProductDao;
import west.dao.We_Product_CarDao;
import west.entity.We_Product;
import west.entity.We_Product_Car;
import west.entity.We_User;
import west.service.We_Product_CarService;



@Service("we_Product_CarService")
public class We_Product_CarServiceImpl implements We_Product_CarService{
	private We_Product_CarDao we_Product_CarDao;
	private We_ProductDao we_ProductDao;

	public int countByUserId(int user_id) {
		return we_Product_CarDao.countByUserId(user_id);
	}

	
	public We_Product_CarDao getWe_Product_CarDao() {
		return we_Product_CarDao;
	}
    @Resource(name="we_Product_CarDao")
	public void setWe_Product_CarDao(We_Product_CarDao we_Product_CarDao) {
		this.we_Product_CarDao = we_Product_CarDao;
	}

    /**
     * 加入购物车
     */
	public void saveNew(String productJson, We_User user) {
		JSONObject json=JSONObject.fromObject(productJson);
		Date nowDate=new Date();
		JSONArray ja=json.getJSONArray("productList");
		 We_Product_Car car=null;
		for(int i=0;i<ja.size();i++){
			car=new We_Product_Car();
			int id=ja.getJSONObject(i).getInt("id");
			int number=ja.getJSONObject(i).getInt("number");
			We_Product product=we_ProductDao.get(id);
			car.setCreattime(nowDate);
			car.setNumber(number);
			car.setProduct_id(product);
			car.setUser_id(user);
			we_Product_CarDao.save(car);
		}
	}
	public We_ProductDao getWe_ProductDao(){
		return we_ProductDao;
	}
    @Resource(name="we_ProductDao")
	public void setWe_ProductDao(We_ProductDao we_ProductDao) {
		this.we_ProductDao = we_ProductDao;
	}


	public List<We_Product_Car> getByUserId(Integer user_id) {
		
		return we_Product_CarDao.getByUserId(user_id);
	}


	public void deleteById(int id) {
		we_Product_CarDao.deleteById(id);
	}


	public We_Product_Car getById(int car_id) {
		return we_Product_CarDao.get(car_id);
	}


	public void saveOrUpdate(We_Product_Car car) {
		we_Product_CarDao.saveOrUpdate(car);
	}
}
