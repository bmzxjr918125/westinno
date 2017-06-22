package west.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 订单客服名单表
 * @ClassName: We_Team
 * @Description: TODO
 * @author BianMingZhou
 * @date 2016-4-13 下午7:48:00
 */
@Entity
@Table(name="we_team")
public class We_Team implements Serializable {
	private static final long serialVersionUID = 8815850589285790924L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	/**
	 * 头像
	 */
	private String logo;
    /**
     * 名称
     */
	private String name;
	/**
	 * qq号
	 */
	private String qq;
	/**
	 * 电话号码
	 */
	private String phonenum;
	/**
	 * 邮箱
	 */
	private String e_mail;
	/**
	 * 创建时间
	 */
	private Date creattime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getPhonenum() {
		return phonenum;
	}

	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}

	public String getE_mail() {
		return e_mail;
	}

	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreattime() {
		return creattime;
	}

	public void setCreattime(Date creattime) {
		this.creattime = creattime;
	}
}
