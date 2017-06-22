package west.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 后台管理员账户信息表
 * 
 * @author BianMingZhou
 */
@Entity
@Table(name="we_admin")
public class We_Admin implements Serializable {
	private static final long serialVersionUID = -6107387783673362236L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	/**
	 * 管理员账户
	 */
	@Column(unique=true,length=50)//字段唯一后最好也设置字段长度,不然有些情况会不能生成数据库表
	private String username;
	/**
	 * 管理员密码 （双32位大写md5加密）
	 */
	private String password;
	/**
	 * 帐号创建时间
	 */
	private Date creattime;
	/**
	 * 帐号最近修改时间
	 */
	private Date updatetime;
	/**
	 * 上次登陆时间
	 */
	private Date lastlogintime;
	/**
	 * 本次登陆时间
	 */
	private Date thislogintime;
	/**
	 * 角色类型0后台管理员超级账号
	 */
	private int role_type;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRole_type() {
		return role_type;
	}

	public void setRole_type(int role_type) {
		this.role_type = role_type;
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

	public Date getLastlogintime() {
		return lastlogintime;
	}

	public void setLastlogintime(Date lastlogintime) {
		this.lastlogintime = lastlogintime;
	}

	public Date getThislogintime() {
		return thislogintime;
	}

	public void setThislogintime(Date thislogintime) {
		this.thislogintime = thislogintime;
	}

	
}
