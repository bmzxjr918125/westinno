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
 * 订单对应分配客服关系表
 * @ClassName: We_Order_Team
 * @Description: TODO
 * @author BianMingZhou
 * @date 2016-4-13 下午7:49:43
 */
@Entity
@Table(name="we_order_team")
public class We_Order_Team implements Serializable {
	private static final long serialVersionUID = -8978518125688585933L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	/**
	 * 对应订单
	 */
	@ManyToOne
	@JoinColumn(name="order_id",unique=true)
	private We_Order order_id;
	/**
	 * 对应客服id
	 */
	@ManyToOne
	@JoinColumn(name="team_id")
	private We_Team team_id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public We_Order getOrder_id() {
		return order_id;
	}
	public void setOrder_id(We_Order order_id) {
		this.order_id = order_id;
	}
	public We_Team getTeam_id() {
		return team_id;
	}
	public void setTeam_id(We_Team team_id) {
		this.team_id = team_id;
	}
}
