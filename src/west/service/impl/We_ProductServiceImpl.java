package west.service.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import west.base.action.datatables.DataTables;
import west.dao.We_ProductDao;
import west.entity.We_Product;
import west.service.We_ProductService;



@Service("we_ProductService")
public class We_ProductServiceImpl implements We_ProductService{
	 private We_ProductDao we_ProductDao;

	  public void getByPage(DataTables dtJson) {
		  try {
			  we_ProductDao.getByPage(dtJson);	
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
	  }
	 
	  public We_Product getById(int id) {
			return we_ProductDao.get(id);
		}
	  public void saveOrUpdate(We_Product product) {
		  we_ProductDao.saveOrUpdate(product);
		}
	  
	  public We_Product getByType(int type_one, int type_two1, int type_two2,
				int type_two3) {
			
			return we_ProductDao.getByType(type_one,type_two1,type_two2, type_two3);
		}
	  
	  
	public We_ProductDao getWe_ProductDao() {
		return we_ProductDao;
	}
     @Resource(name="we_ProductDao")
	public void setWe_ProductDao(We_ProductDao we_ProductDao) {
		this.we_ProductDao = we_ProductDao;
	}

	
}
