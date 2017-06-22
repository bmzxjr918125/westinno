package west.service;

import java.util.List;

import west.base.action.datatables.DataTables;
import west.entity.We_Team;


public interface We_TeamService {
  
	void getByPage(DataTables dtJson);

	void saveOrUpdate(We_Team we_Team);
	public abstract List<We_Team> getAll();
	We_Team getById(int id);
   
	void deleteById(int id);

}
