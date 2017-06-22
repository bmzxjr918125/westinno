package west.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 商品 类型2
 * @ClassName: We_Product_Type_Two
 * @Description: TODO
 * @author BianMingZhou
 * @date 2016-3-22 下午3:41:46
 */
@Entity
@Table(name="we_product_type_two")
public class We_Product_Type_Two implements Serializable {
	private static final long serialVersionUID = -5189431506587390508L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	/**
	 * 类型名  
	 */
	private String name;
	@ManyToOne
	@JoinColumn(name="type_one_id")
	private We_Product_Type_One type_one_id;
	/**
	 * 1服务类型 2专利类型 3减缓类型
	 */
	private int flag;
	
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
	public We_Product_Type_One getType_one_id() {
		return type_one_id;
	}
	public void setType_one_id(We_Product_Type_One type_one_id) {
		this.type_one_id = type_one_id;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
}
