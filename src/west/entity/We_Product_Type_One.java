package west.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 商品 类型1
 * @ClassName: We_Product_Type_One
 * @Description: TODO
 * @author BianMingZhou
 * @date 2016-3-22 下午3:41:46
 */
@Entity
@Table(name="we_product_type_one")
public class We_Product_Type_One implements Serializable {
	private static final long serialVersionUID = 5542950962680363770L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	/**
	 * 类型名  
	 */
	private String name;
	/**
	 * 类型标记 
	 *   1专利申请 2商标申请 3双创服务 
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
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
}
