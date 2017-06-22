package west.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import west.dao.We_Product_Type_TwoDao;
import west.entity.We_Product_Type_Two;
import west.service.We_Product_Type_TwoService;



@Service("we_Product_Type_TwoService")
public class We_Product_Type_TwoServiceImpl implements We_Product_Type_TwoService{
    private We_Product_Type_TwoDao we_Product_Type_TwoDao;
	public We_Product_Type_Two getById(int product_typetwo) {
		
		return we_Product_Type_TwoDao.get(product_typetwo);
	}
	public We_Product_Type_TwoDao getWe_Product_Type_TwoDao() {
		return we_Product_Type_TwoDao;
	}
	@Resource(name="we_Product_Type_TwoDao")
	public void setWe_Product_Type_TwoDao(
			We_Product_Type_TwoDao we_Product_Type_TwoDao) {
		this.we_Product_Type_TwoDao = we_Product_Type_TwoDao;
	}
	public List<We_Product_Type_Two> getByName(String name, int value) {
		return we_Product_Type_TwoDao.findByInt(name,value);
	}
	

}
