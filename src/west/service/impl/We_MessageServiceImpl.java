package west.service.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import west.dao.We_MessageDao;
import west.entity.We_Message;
import west.service.We_MessageService;



@Service("we_MessageService")
public class We_MessageServiceImpl implements We_MessageService{
	private We_MessageDao we_MessageDao;

	
	
	
	public We_MessageDao getWe_MessageDao() {
		return we_MessageDao;
	}
    @Resource(name="we_MessageDao")
	public void setWe_MessageDao(We_MessageDao we_MessageDao) {
		this.we_MessageDao = we_MessageDao;
	}
    
	public void save(We_Message msg){
    	we_MessageDao.save(msg);
    }

}
