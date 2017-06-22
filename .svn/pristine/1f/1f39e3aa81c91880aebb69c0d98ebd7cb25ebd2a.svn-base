package west.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import west.base.action.datatables.DataTables;
import west.dao.We_TeamDao;
import west.entity.We_Team;
import west.service.We_TeamService;



@Service("we_TeamService")
public class We_TeamServiceImpl implements We_TeamService{
	  private We_TeamDao we_TeamDao;

	public We_TeamDao getWe_TeamDao() {
		return we_TeamDao;
	}
    @Resource(name="we_TeamDao")
	public void setWe_TeamDao(We_TeamDao we_TeamDao) {
		this.we_TeamDao = we_TeamDao;
	}
	public void getByPage(DataTables dtJson) {
		we_TeamDao.getByPage(dtJson);
	}
	public void saveOrUpdate(We_Team we_Team) {
		we_TeamDao.saveOrUpdate(we_Team);
	}
	public We_Team getById(int id) {
		
		return we_TeamDao.get(id);
	}
	public void deleteById(int id) {
		we_TeamDao.deleteById(id);
	}
	
	public List<We_Team> getAll(){
		return we_TeamDao.findAll();
	}
	
}
