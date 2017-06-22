package west.service.impl;



import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Service;

import west.base.action.datatables.DataTables;
import west.dao.We_MessageDao;
import west.dao.We_OrderDao;
import west.dao.We_Order_ItemDao;
import west.dao.We_Order_TeamDao;
import west.dao.We_ProductDao;
import west.dao.We_TeamDao;
import west.entity.We_Message;
import west.entity.We_Order;
import west.entity.We_Order_Item;
import west.entity.We_Order_Team;
import west.entity.We_Product;
import west.entity.We_Team;
import west.entity.We_User;
import west.service.We_OrderService;
import west.util.OrderUtil;



@Service("we_OrderService")
public class We_OrderServiceImpl implements We_OrderService{
	private We_OrderDao we_OrderDao;
	private We_ProductDao we_ProductDao;
	private We_Order_ItemDao we_Order_ItemDao;

	
	public We_OrderDao getWe_OrderDao() {
		return we_OrderDao;
	}
    @Resource(name="we_OrderDao")
	public void setWe_OrderDao(We_OrderDao we_OrderDao) {
		this.we_OrderDao = we_OrderDao;
	}
    
    /**
     * <p>Method Name : getByPage</p>
     * <p>Method Desc : 订单分页、筛选、排序</p>
     * <p>Date : 2016-3-31 下午3:05:32</p>
     * <p>Author : XQL</p>
     * @param dtJson
     */
	public void getByPage(DataTables dtJson) {
    	we_OrderDao.getByPage(dtJson);
	}
	
	/**
	 * <p>Method Name : check</p>
	 * <p>Method Desc : 审核订单</p>
	 * <p>Date : 2016-3-31 下午4:21:57</p>
	 * <p>Author : XQL</p>
	 * @param order_id
	 * @param status 1审核通过 2审核不通过
	 * @return
	 */
	public int check(int order_id,int status,int team_id){
		We_Order order = we_OrderDao.get(order_id);
		if(order != null){
			if(order.getStatus() == 2){
				order.setUpdatetime(new Date());
				order.setStatus(status == 1 ? 3 : 4);
				we_OrderDao.update(order);
				
				///关联客服人员
				if(status == 1 && team_id != 0){
					We_Team team = we_TeamDao.get(team_id);
					We_Order_Team order_Team = new We_Order_Team();
					order_Team.setOrder_id(order);
					order_Team.setTeam_id(team);
					we_Order_TeamDao.save(order_Team);
				}
				
				//发送消息
				We_Message msg = new We_Message();
				msg.setCreattime(new Date());
				msg.setF_id(order_id);
				msg.setIs_read((byte)0);
				msg.setMessage(order.getName()+"["+order.getOrdernum()+"]审核"+ (status == 1 ? "通过" : "不通过"));
				msg.setName(order.getName()+"["+order.getOrdernum()+"]审核"+ (status == 1 ? "通过" : "不通过"));
				msg.setType(1);
				msg.setUser_id(order.getUser_id());
				
				we_MessageDao.save(msg);
				
				return 1;
			}else{
				return 2;
			}	
		}else{
			return 3;
		}
		
	}
	
	/**
	 * <p>Method Name : getOrder</p>
	 * <p>Method Desc : 根据ID获取订单信息</p>
	 * <p>Date : 2016-3-31 下午4:33:25</p>
	 * <p>Author : XQL</p>
	 * @param order_id
	 * @return
	 */
	public We_Order getOrder(int order_id){
		return we_OrderDao.get(order_id);
	}
	
	/**
	 * <p>Method Name : update</p>
	 * <p>Method Desc : 修改订单信息</p>
	 * <p>Date : 2016-3-31 下午4:35:43</p>
	 * <p>Author : XQL</p>
	 * @param order
	 */
	public void update(We_Order order){
		we_OrderDao.update(order);
	}
	
	/**
	 *  新建订单
	 */
	public We_Order saveNew(String productJson, We_User user) {
		JSONObject json=JSONObject.fromObject(productJson);
		Date nowDate=new Date();
		JSONArray ja=json.getJSONArray("productList");
		double totalPrice=0.0;
		We_Order order=new We_Order();
		for(int i=0;i<ja.size();i++){
			int id=ja.getJSONObject(i).getInt("id");
			int number=ja.getJSONObject(i).getInt("number");
			We_Product product=we_ProductDao.get(id);
			if(i==0){
 	    		order.setName(product.getName());	
 	    	}
			totalPrice=totalPrice+product.getPrice()*number;
		}
		
		
 	    order.setCreattime(new Date());
 	    order.setOrdernum(OrderUtil.createOrderNumber(user.getPhonenum(),Calendar.getInstance().getTimeInMillis()));
 	    order.setPrice(totalPrice);
 	    if(user.getIs_complete()==1){
 	    	order.setStatus((byte)2);
 	    }else{
 	    	order.setStatus((byte)1);
 	    }
 	    order.setUpdatetime(new Date());
 	    order.setUser_id(user);
 	    we_OrderDao.save(order);
		
		for(int i=0;i<ja.size();i++){
			int id=ja.getJSONObject(i).getInt("id");
			int number=ja.getJSONObject(i).getInt("number");
			We_Product product=we_ProductDao.get(id);
			We_Order_Item item=new We_Order_Item();
			item.setCreattime(nowDate);
			item.setName(product.getName());
			item.setNumber(number);
			item.setOrder_id(order);
			item.setPrice(product.getPrice());
			item.setProduct_id(product);
			we_Order_ItemDao.save(item);
		}
		
		return order;
	}
	
	/**
	 * <p>Method Name : getByUser</p>
	 * <p>Method Desc : 获取用户的订单</p>
	 * <p>Date : 2016-4-13 下午3:21:43</p>
	 * <p>Author : XQL</p>
	 * @param user_id
	 * @return
	 */
	public List<We_Order> getByUser(int user_id,String name,int status,String start,String end){
		return we_OrderDao.findByUser(user_id,name ,status,start, end);
	}
	
	public We_ProductDao getWe_ProductDao() {
		return we_ProductDao;
	}
	@Resource(name="we_ProductDao")
	public void setWe_ProductDao(We_ProductDao we_ProductDao) {
		this.we_ProductDao = we_ProductDao;
	}
	public We_Order_ItemDao getWe_Order_ItemDao() {
		return we_Order_ItemDao;
	}
	@Resource(name="we_Order_ItemDao")
	public void setWe_Order_ItemDao(We_Order_ItemDao we_Order_ItemDao) {
		this.we_Order_ItemDao = we_Order_ItemDao;
	}
	
	private We_TeamDao we_TeamDao;
	public We_TeamDao getWe_TeamDao() {
		return we_TeamDao;
	}
	@Resource(name="we_TeamDao")
	public void setWe_TeamDao(We_TeamDao we_TeamDao) {
		this.we_TeamDao = we_TeamDao;
	}
	
	private We_Order_TeamDao we_Order_TeamDao;
	public We_Order_TeamDao getWe_Order_TeamDao() {
		return we_Order_TeamDao;
	}
	@Resource(name="we_Order_TeamDao")
	public void setWe_Order_TeamDao(We_Order_TeamDao we_Order_TeamDao) {
		this.we_Order_TeamDao = we_Order_TeamDao;
	}
	
	private We_MessageDao we_MessageDao;
	public We_MessageDao getWe_MessageDao() {
		return we_MessageDao;
	}
	@Resource(name="we_MessageDao")
	public void setWe_MessageDao(We_MessageDao we_MessageDao) {
		this.we_MessageDao = we_MessageDao;
	}
	
}
