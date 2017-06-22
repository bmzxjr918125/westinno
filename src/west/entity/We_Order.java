package west.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 订单信息表
 * @ClassName: We_Order
 * @Description: TODO
 * @author BianMingZhou
 * @date 2016-3-31 上午10:37:40
 */
@Entity
@Table(name="we_order")
public class We_Order implements Serializable {
	private static final long serialVersionUID = 659333140212438710L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	/**
	 * 订单编号
	 */
	@Column(unique=true,length=50)
	private String ordernum;
	 /**
     * 订单状态 1待完善个人资料（用户可取消 后台可关闭） 2已提交待审核（用户可取消 后台可关闭） 
     *        3审核通过待付款（用户可取消 后台可关闭）4审核未通过（用户可取消 后台可关闭）
     *        5已付款（进行中） 6已完成（后台操作标记完成）7已取消（用户取消）8已关闭（后台关闭）
     */
	private int status;
	/**
	 * 订单名称 第一个商品名称
	 */
	@Column(length=100)
	private String name;
	/**
	 * 订单总价格
	 */
	private double price;
	/**
	 * 创建时间
	 */
	private Date creattime;
	/**
	 * 订单信息更新时间
	 */
	private Date updatetime;
	/**
	 * 对应用户
	 */
	@ManyToOne
	@JoinColumn(name="use_id")
	private We_User user_id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrdernum() {
		return ordernum;
	}

	public void setOrdernum(String ordernum) {
		this.ordernum = ordernum;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getCreattime() {
		return creattime;
	}

	public void setCreattime(Date creattime) {
		this.creattime = creattime;
	}

	public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	public We_User getUser_id() {
		return user_id;
	}

	public void setUser_id(We_User user_id) {
		this.user_id = user_id;
	}
}
