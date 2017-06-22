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
 * 订单子项表
 * @ClassName: We_Order_Item
 * @Description: TODO
 * @author BianMingZhou
 * @date 2016-3-31 上午10:54:53
 */
@Entity
@Table(name="we_order_item")
public class We_Order_Item implements Serializable {
	private static final long serialVersionUID = 8877634518374197920L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	/**
	 * 商品名称
	 */
	@Column(length=100)
	private String name;
	/**
	 * 商品单价
	 */
	private double price;
	/**
	 * 商品数量
	 */
	private int number;
	/**
	 * 加入时间
	 */
	private Date creattime;
	/**
	 * 对应订单id
	 */
	@ManyToOne
	@JoinColumn(name="order_id")
	private We_Order order_id;
	/**
	 * 对应商品id
	 */
	@ManyToOne
	@JoinColumn(name="product_id")
	private We_Product product_id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public Date getCreattime() {
		return creattime;
	}
	public void setCreattime(Date creattime) {
		this.creattime = creattime;
	}
	public We_Order getOrder_id() {
		return order_id;
	}
	public void setOrder_id(We_Order order_id) {
		this.order_id = order_id;
	}
	public We_Product getProduct_id() {
		return product_id;
	}
	public void setProduct_id(We_Product product_id) {
		this.product_id = product_id;
	}
}
