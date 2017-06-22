package west.service.impl;


import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Service;

import west.base.action.datatables.DataTables;
import west.dao.We_NewsDao;
import west.entity.We_News;
import west.service.We_NewsService;



@Service("we_NewsService")
public class We_NewsServiceImpl implements We_NewsService{
	private We_NewsDao we_NewsDao;
     
	
	public void getByPage(DataTables dtJson) {
		
		we_NewsDao.getByPage(dtJson);
	}
	public We_News getById(int id) {
		
		return we_NewsDao.get(id);
	}
	public void saveOrUpdate(We_News we_News) {
		we_NewsDao.saveOrUpdate(we_News);
	}
	public void deleteById(int id) {
		we_NewsDao.deleteById(id);
	}
	public List<We_News> getRecommend() {
		
		return we_NewsDao.getRecommend();
	}
	public int countAllByType(int type) {
		
		return we_NewsDao.countAllByType(type);
	}
	
	public List<We_News> getHtmlPage(JSONObject jsonData) {
		
		return we_NewsDao.getHtmlPage(jsonData);
	}
	
	
	
	
	
	
	public We_NewsDao getWe_NewsDao() {
		return we_NewsDao;
	}
    @Resource(name="we_NewsDao")
	public void setWe_NewsDao(We_NewsDao we_NewsDao) {
		this.we_NewsDao = we_NewsDao;
	}
	
}
