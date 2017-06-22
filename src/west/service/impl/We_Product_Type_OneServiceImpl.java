package west.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import west.dao.We_Product_Type_OneDao;
import west.entity.We_Product_Type_One;
import west.service.We_Product_Type_OneService;



@Service("we_Product_Type_OneService")
public class We_Product_Type_OneServiceImpl implements We_Product_Type_OneService{
	private We_Product_Type_OneDao we_Product_Type_OneDao;

	public We_Product_Type_OneDao getWe_Product_Type_OneDao() {
		return we_Product_Type_OneDao;
	}
    @Resource(name="we_Product_Type_OneDao")
	public void setWe_Product_Type_OneDao(
			We_Product_Type_OneDao we_Product_Type_OneDao) {
		this.we_Product_Type_OneDao = we_Product_Type_OneDao;
	}
	public We_Product_Type_One getById(int product_typeone) {
		
		return we_Product_Type_OneDao.get(product_typeone);
	}
	public List<We_Product_Type_One> getByName(String name, int value) {
		
		return we_Product_Type_OneDao.findByInt(name,value);
	}

}
