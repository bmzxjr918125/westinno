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
 *  用户信息表
 * @ClassName: We_User
 * @Description: TODO
 * @author BianMingZhou
 * @date 2016-3-22 上午11:01:35
 */
@Entity
@Table(name="we_user")
public class We_User implements Serializable {
	private static final long serialVersionUID = -6187890762858384260L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	/**
	 *  联系电话，登录用户名 可为空（第三方登录未绑定手机号时）
	 */
	@Column(unique=true,length=11)
	private String phonenum;
	/**
	 * 用户昵称(注册初始化时为手机号，第三方登录时为第三方用户名)
	 */
	@Column(length=20)
	private String nickname;
	/**
	 * 登录密码 32位大写双md5加密
	 */
	@Column(length=50)
	private String password;
	
	/**
	 *  性别
	 *  1男 2女 3其他
	 */
	private byte sex;
	/**
	 * 电子邮箱
	 */
	@Column(length=50)
	private String e_mail;
	/**
	 * QQ
	 */
	@Column(length=20)
	private String qq;
	/**
	 *  是否完善个人资料 0否 1是
	 */
	@Column(columnDefinition="INT default 0",nullable=false)
	private byte is_complete;
	/**
	 * 创建时间
	 */
	@Column(nullable=false,columnDefinition="TIMESTAMP default CURRENT_TIMESTAMP")
	private Date creattime;
	/**
	 *  信息修改时间
	 */
	@Column(columnDefinition="TIMESTAMP default CURRENT_TIMESTAMP")
	private Date updatetime;
	/**
	 * 本次登陆时间
	 */
	@Column(columnDefinition="TIMESTAMP default CURRENT_TIMESTAMP")
	private Date thislogintime;
	/**
	 * 上次登录时间
	 */
	@Column(columnDefinition="TIMESTAMP default CURRENT_TIMESTAMP")
	private Date lastlogintime;
	/**
	 * 是否为第三方帐号 0否 1是
	 */
	@Column(columnDefinition="INT default 0",nullable=false)
	private byte is_other;
	/**
	 * 第三方信息 json字符串
	 */
	private String openstr;
	/**
	 * 第三方类型 1qq
	 */
	private int opentype;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPhonenum() {
		return phonenum;
	}
	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public byte getSex() {
		return sex;
	}
	public void setSex(byte sex) {
		this.sex = sex;
	}
	public String getE_mail() {
		return e_mail;
	}
	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
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
	public Date getThislogintime() {
		return thislogintime;
	}
	public void setThislogintime(Date thislogintime) {
		this.thislogintime = thislogintime;
	}
	public Date getLastlogintime() {
		return lastlogintime;
	}
	public void setLastlogintime(Date lastlogintime) {
		this.lastlogintime = lastlogintime;
	}
	public byte getIs_other() {
		return is_other;
	}
	public void setIs_other(byte is_other) {
		this.is_other = is_other;
	}
	public String getOpenstr() {
		return openstr;
	}
	public void setOpenstr(String openstr) {
		this.openstr = openstr;
	}
	public int getOpentype() {
		return opentype;
	}
	public void setOpentype(int opentype) {
		this.opentype = opentype;
	}
	public byte getIs_complete() {
		return is_complete;
	}
	public void setIs_complete(byte is_complete) {
		this.is_complete = is_complete;
	}
	
}
