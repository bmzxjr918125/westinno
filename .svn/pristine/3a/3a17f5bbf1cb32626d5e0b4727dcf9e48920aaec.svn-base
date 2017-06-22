package west.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 商品信息表
 * @ClassName: We_Product
 * @Description: TODO
 * @author BianMingZhou
 * @date 2016-3-22 上午11:34:52
 */
@Entity
@Table(name="we_product")
public class We_Product implements Serializable {
	private static final long serialVersionUID = -3095659955235076565L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	/**
	 * 商品名称
	 */
	private String name;
	/**
	 * logo
	 */
	private String logo;
	/**
	 * 价格
	 */
	private double price;
	/**
	 * 一句话标签
	 */
	private String tag;
	/**
	 * 商品详情
	 */
	@Column(length=65533)
	private String description;
	/**
	 * 常见问题
	 */
	@Column(length=65533)
	private String problem;
	/**
	 * 对应类型1 发明专利,....
	 */
	@ManyToOne
	@JoinColumn(name="type_one_id")
	private We_Product_Type_One type_one_id;
	/**
	 * 对应类型2 服务类型
	 */
	@ManyToOne
	@JoinColumn(name="type_two_1")
	private We_Product_Type_Two type_two_1;
	/**
	 * 对应类型2 专利类型(仅发明申请包含)
	 */
	@ManyToOne
	@JoinColumn(name="type_two_2")
	private We_Product_Type_Two type_two_2;
	/**
	 * 对应类型2 减缓类型(仅发明申请包含)
	 */
	@ManyToOne
	@JoinColumn(name="type_two_3")
	private We_Product_Type_Two type_two_3;
	
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
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getProblem() {
		return problem;
	}
	public void setProblem(String problem) {
		this.problem = problem;
	}
	public We_Product_Type_One getType_one_id() {
		return type_one_id;
	}
	public void setType_one_id(We_Product_Type_One type_one_id) {
		this.type_one_id = type_one_id;
	}
	public We_Product_Type_Two getType_two_1() {
		return type_two_1;
	}
	public void setType_two_1(We_Product_Type_Two type_two_1) {
		this.type_two_1 = type_two_1;
	}
	public We_Product_Type_Two getType_two_2() {
		return type_two_2;
	}
	public void setType_two_2(We_Product_Type_Two type_two_2) {
		this.type_two_2 = type_two_2;
	}
	public We_Product_Type_Two getType_two_3() {
		return type_two_3;
	}
	public void setType_two_3(We_Product_Type_Two type_two_3) {
		this.type_two_3 = type_two_3;
	}
	
}
