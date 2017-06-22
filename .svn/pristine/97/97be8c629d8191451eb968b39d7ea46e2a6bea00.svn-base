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
 * 消息信息表
 * @ClassName: We_Message
 * @Description: TODO
 * @author BianMingZhou
 * @date 2016-3-22 上午11:31:14
 */
@Entity
@Table(name="we_message")
public class We_Message implements Serializable {
	private static final long serialVersionUID = -5713140433164681203L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	/**
	 * 信息名称
	 */
	@Column(length=100)
	private String name;
	/**
	 * 信息内容
	 */
	@Column(length=500)
	private String message;
	/**
	 * 消息类型 1订单消息
	 */
	private int type;
	/**
	 * 创建时间
	 */
	@Column(nullable=false,columnDefinition="TIMESTAMP default CURRENT_TIMESTAMP")
	private Date creattime;
	/**
	 * 信息对用用户
	 */
	@ManyToOne
	@JoinColumn(name="user_id")
	private We_User user_id;
	/**
	 * 是否已读 0否 1是
	 */
	private byte is_read;
	/**
	 *  对应外键id
	 */
	private int f_id;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
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
	public byte getIs_read() {
		return is_read;
	}
	public void setIs_read(byte is_read) {
		this.is_read = is_read;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getF_id() {
		return f_id;
	}
	public void setF_id(int f_id) {
		this.f_id = f_id;
	}
	
}
