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
 * 商品收藏信息表
 * @ClassName: We_Product_Collect
 * @Description: TODO
 * @author BianMingZhou
 * @date 2016-3-22 上午11:34:52
 */
@Entity
@Table(name="we_product_collect")
public class We_Product_Collect implements Serializable {
	private static final long serialVersionUID = 8263498468472685511L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
    /**
     *  创建时间
     */
	@Column(nullable=false,columnDefinition="TIMESTAMP default CURRENT_TIMESTAMP")
	private Date creattime;
	/**
	 *  对应用户
	 */
	@ManyToOne
	@JoinColumn(name="user_id")
	private We_User user_id;
	/**
	 * 对应商品
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
	public Date getCreattime() {
		return creattime;
	}
	public void setCreattime(Date creattime) {
		this.creattime = creattime;
	}
	public We_User getUser_id() {
		return user_id;
	}
	public void setUser_id(We_User user_id) {
		this.user_id = user_id;
	}
	public We_Product getProduct_id() {
		return product_id;
	}
	public void setProduct_id(We_Product product_id) {
		this.product_id = product_id;
	}
}
