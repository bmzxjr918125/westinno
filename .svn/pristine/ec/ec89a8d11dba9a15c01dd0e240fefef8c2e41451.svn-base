package west.admin.action;


import java.util.Date;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import west.base.action.BaseAction;
import west.entity.We_Message;
import west.entity.We_Order;
import west.service.We_MessageService;
import west.service.We_OrderService;
import west.service.We_Order_ItemService;
import west.util.Notify;
import west.util.RequestUtils;
/**
 * 订单管理
 * @ClassName: AdminOrderAction
 * @Description: TODO
 * @author BianMingZhou
 * @date 2016-3-22 下午5:28:52
 */
@Controller("adminOrderAction")
@Scope("prototype")
public class AdminOrderAction extends BaseAction {
	private static final long serialVersionUID = 5186953648488638851L;

	public String Show(){
		return "Show";
	}
	
	private We_OrderService we_OrderService;
	private We_Order_ItemService we_Order_ItemService;
	
	public We_OrderService getWe_OrderService() {
		return we_OrderService;
	}
	@Resource(name="we_OrderService")
	public void setWe_OrderService(We_OrderService we_OrderService) {
		this.we_OrderService = we_OrderService;
	}
	public We_Order_ItemService getWe_Order_ItemService() {
		return we_Order_ItemService;
	}
	@Resource(name="we_Order_ItemService")
	public void setWe_Order_ItemService(We_Order_ItemService we_Order_ItemService) {
		this.we_Order_ItemService = we_Order_ItemService;
	}
	private We_MessageService we_MessageService;
	
	public We_MessageService getWe_MessageService() {
		return we_MessageService;
	}
	@Resource(name="we_MessageService")
	public void setWe_MessageService(We_MessageService we_MessageService) {
		this.we_MessageService = we_MessageService;
	}
	/**
	 * <p>Method Name : AjaxShow</p>
	 * <p>Method Desc : Ajax获取订单数据，分页排序筛选</p>
	 * <p>Date : 2016-3-31 下午3:07:53</p>
	 * <p>Author : XQL</p>
	 * @return
	 */
	public String AjaxShow(){
		we_OrderService.getByPage(super.getDtJson());
		return "ajaxShow";
	}
	
	public String ItemShow(){
		int order_id = RequestUtils.getIntParamter("order_id");
		request.setAttribute("order_id", order_id);
		return "ItemShow";
	}
	
	/**
	 * <p>Method Name : ItemAjaxShow</p>
	 * <p>Method Desc : Ajax获取订单详细数据，分页排序筛选</p>
	 * <p>Date : 2016-3-31 下午3:07:53</p>
	 * <p>Author : XQL</p>
	 * @return
	 */
	public String ItemAjaxShow(){
		int order_id = RequestUtils.getIntParamter("order_id");
		
		we_Order_ItemService.getByPage(super.getDtJson(),order_id);
		return "ajaxShow";
	}
	
	/**
	 * <p>Method Name : Check</p>
	 * <p>Method Desc : 操作订单审核</p>
	 * <p>Date : 2016-3-31 下午4:24:59</p>
	 * <p>Author : XQL</p>
	 * @return
	 */
	public String Check(){
		int order_id = RequestUtils.getIntParamter("order_id");
		int status = RequestUtils.getIntParamter("status");
		int team_id = RequestUtils.getIntParamter("team_id");
		
		int flag = we_OrderService.check(order_id, status,team_id);
		if(flag == 1){
			super.setNotify(new Notify(1,"审核成功"));
		}else{
			super.setNotify(new Notify(2,"审核失败,请刷新再操作"));
		}
		
		return "notify";
	}
	
	/**
	 * <p>Method Name : Close</p>
	 * <p>Method Desc : 关闭订单操作</p>
	 * <p>Date : 2016-3-31 下午4:39:16</p>
	 * <p>Author : XQL</p>
	 * @return
	 */
	public String Close(){
		int order_id = RequestUtils.getIntParamter("order_id");
		
		We_Order order = we_OrderService.getOrder(order_id);
		
		if(order != null){
			if(order.getStatus() == 1 || order.getStatus() == 2 || order.getStatus() == 3 || order.getStatus() == 4){
				order.setStatus(8);
				order.setUpdatetime(new Date());
				we_OrderService.update(order);
				
				//发送消息
				We_Message msg = new We_Message();
				msg.setCreattime(new Date());
				msg.setF_id(order_id);
				msg.setIs_read((byte)0);
				msg.setMessage(order.getName()+"["+order.getOrdernum()+"]关闭成功");
				msg.setName(order.getName()+"["+order.getOrdernum()+"]关闭成功");
				msg.setType(1);
				msg.setUser_id(order.getUser_id());
				
				we_MessageService.save(msg);
				
				super.setNotify(new Notify(1,"关闭成功"));
			}else{
				super.setNotify(new Notify(2,"关闭失败，请刷新后再操作"));
			}
		}else{
			super.setNotify(new Notify(2,"关闭失败"));
		}
		return "notify";
	}
	
	/**
	 * <p>Method Name : Finish</p>
	 * <p>Method Desc : 完成订单操作</p>
	 * <p>Date : 2016-3-31 下午4:39:16</p>
	 * <p>Author : XQL</p>
	 * @return
	 */
	public String Finish(){
		int order_id = RequestUtils.getIntParamter("order_id");
		
		We_Order order = we_OrderService.getOrder(order_id);
		
		if(order != null){
			if(order.getStatus() == 5){
				order.setStatus(6);
				order.setUpdatetime(new Date());
				we_OrderService.update(order);
				
				//发送消息
				We_Message msg = new We_Message();
				msg.setCreattime(new Date());
				msg.setF_id(order_id);
				msg.setIs_read((byte)0);
				msg.setMessage(order.getName()+"["+order.getOrdernum()+"]已完成");
				msg.setName(order.getName()+"["+order.getOrdernum()+"]已完成");
				msg.setType(1);
				msg.setUser_id(order.getUser_id());
				
				we_MessageService.save(msg);
				
				super.setNotify(new Notify(1,"完成订单成功"));
			}else{
				super.setNotify(new Notify(2,"完成订单失败，请刷新后再操作"));
			}
		}else{
			super.setNotify(new Notify(2,"完成失败"));
		}
		return "notify";
	}
	
	/**
	 * <p>Method Name : EditPrice</p>
	 * <p>Method Desc : 修改订单价格</p>
	 * <p>Date : 2016-3-31 下午4:39:16</p>
	 * <p>Author : XQL</p>
	 * @return
	 */
	public String EditPrice(){
		int order_id = RequestUtils.getIntParamter("order_id");
		double price = RequestUtils.getDoubleParamter("price");
		
		We_Order order = we_OrderService.getOrder(order_id);
		
		if(order != null){
			if(order.getStatus() < 5){
				order.setPrice(price);
				order.setUpdatetime(new Date());
				we_OrderService.update(order);
				
				//发送消息
				We_Message msg = new We_Message();
				msg.setCreattime(new Date());
				msg.setF_id(order_id);
				msg.setIs_read((byte)0);
				msg.setMessage(order.getName()+"["+order.getOrdernum()+"]被修改了订单价格");
				msg.setName(order.getName()+"["+order.getOrdernum()+"]被修改了订单价格");
				msg.setType(1);
				msg.setUser_id(order.getUser_id());
				
				we_MessageService.save(msg);
				
				super.setNotify(new Notify(1,"修改价格成功"));
			}else{
				super.setNotify(new Notify(2,"修改价格失败，请刷新后再操作"));
			}
		}else{
			super.setNotify(new Notify(2,"未查询到该订单"));
		}
		return "notify";
	}

}
