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
 *  商品购物车信息表
 * @ClassName: We_Product_Car
 * @Description: TODO
 * @author BianMingZhou
 * @date 2016-3-22 上午11:39:22
 */
@Entity
@Table(name="we_product_car")
public class We_Product_Car implements Serializable {
	private static final long serialVersionUID = 8581532782112476667L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	/**
	 * 创建时间
	 */
	@Column(nullable=false,columnDefinition="TIMESTAMP default CURRENT_TIMESTAMP")
	private Date creattime;
	/**
	 *  数量
	 */
	private int number;
	/**
	 * 对应商品
	 */
	@ManyToOne
	@JoinColumn(name="product_id")
	private We_Product product_id;
	/**
	 *  对应用户
	 */
	@ManyToOne
	@JoinColumn(name="user_id")
	private We_User user_id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getCreattime() {
		return creattime;
	}
	public void setCreattime(Date creattime) {
		this.creattime = creattime;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public We_Product getProduct_id() {
		return product_id;
	}
	public void setProduct_id(We_Product product_id) {
		this.product_id = product_id;
	}
	public We_User getUser_id() {
		return user_id;
	}
	public void setUser_id(We_User user_id) {
		this.user_id = user_id;
	}
	
}
