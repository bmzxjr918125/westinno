package west.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import west.dao.We_News_TypeDao;
import west.entity.We_News_Type;
import west.service.We_News_TypeService;



@Service("we_News_TypeService")
public class We_News_TypeServiceImpl implements We_News_TypeService{
	private We_News_TypeDao we_News_TypeDao;

	public List<We_News_Type> getAll() {
		
		return we_News_TypeDao.findAll();
	}
	public We_News_Type getById(int type) {
		return we_News_TypeDao.get(type);
	}
	public We_News_TypeDao getWe_News_TypeDao() {
		return we_News_TypeDao;
	}
    @Resource(name="we_News_TypeDao")
	public void setWe_News_TypeDao(We_News_TypeDao we_News_TypeDao) {
		this.we_News_TypeDao = we_News_TypeDao;
	}

	
}
