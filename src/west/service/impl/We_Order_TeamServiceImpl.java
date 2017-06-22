package west.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import west.dao.We_Order_TeamDao;
import west.entity.We_Order_Team;
import west.service.We_Order_TeamService;



@Service("we_Order_TeamService")
public class We_Order_TeamServiceImpl implements We_Order_TeamService{
	private We_Order_TeamDao we_Order_TeamDao;

	public We_Order_TeamDao getWe_Order_TeamDao() {
		return we_Order_TeamDao;
	}
    @Resource(name="we_Order_TeamDao")
	public void setWe_Order_TeamDao(We_Order_TeamDao we_Order_TeamDao) {
		this.we_Order_TeamDao = we_Order_TeamDao;
	}
	public List<We_Order_Team> getByInt(String name, int value) {
		
		return we_Order_TeamDao.findByInt(name, value);
	}
	
    
	public We_Order_Team getOnly(int order_id){
    	return we_Order_TeamDao.findOnly(order_id);
    }
}
