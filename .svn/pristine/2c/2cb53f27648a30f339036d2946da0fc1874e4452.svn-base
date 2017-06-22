package west.service.impl;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;


import org.springframework.stereotype.Service;

import west.dao.We_AdminMenuDao;
import west.entity.We_AdminMenu;
import west.service.We_AdminMenuService;




@Service("we_AdminMenuService")
public class We_AdminMenuServiceImpl implements We_AdminMenuService {
    
	private We_AdminMenuDao we_AdminMenuDao;
         
	
	
	
	
	

	public List<We_AdminMenu> findAllMenu() {
		
		return we_AdminMenuDao.findAll();
	}
	/**
	 * 管理员获取tree
	 * @return
	 */
	public We_AdminMenu getTree(int i) {
		// TODO Auto-generated method stub
		List<We_AdminMenu> list=we_AdminMenuDao.findByInt("role_type", i);
		
		List<We_AdminMenu> rootlist=makeTree(list);
		
		return rootlist.get(0);
	}
	
	
	
	private List<We_AdminMenu> makeTree(List<We_AdminMenu> list){
		
		List<We_AdminMenu> parent = new ArrayList<We_AdminMenu>();
		
		//parentId ==null
		
		for(We_AdminMenu e: list){
			
			if(e.getParent()==null){
				parent.add(e);
				e.setChildrens(new ArrayList<We_AdminMenu>(0));
			}
		}
		//
		list.removeAll(parent);
		makeChildren(parent,list);
		return parent;
		
	}
	
	private void makeChildren(List<We_AdminMenu> parent, List<We_AdminMenu> list) {
		 if(list.isEmpty()){
			 return;
		 }
		 List<We_AdminMenu>  temp = new ArrayList<We_AdminMenu>(0);
		 for(We_AdminMenu s1:parent){
			 
			 for(We_AdminMenu s2:list){
				 
				 if(s1.getId().equals(s2.getParent().getId())){
					 s1.getChildrens().add(s2);
					 temp.add(s2);
				 }
			 }
		 }
		 list.removeAll(temp);
		 makeChildren(temp,list) ;
		
	}
		public We_AdminMenu getById(int parseInt) {
		
			return we_AdminMenuDao.get(parseInt);
		}
		public We_AdminMenuDao getDe_AdminMenuDao() {
			return we_AdminMenuDao;
		}
		@Resource(name="we_AdminMenuDao")
		public void setDe_AdminMenuDao(We_AdminMenuDao we_AdminMenuDao) {
			this.we_AdminMenuDao = we_AdminMenuDao;
		}
		

	
}
