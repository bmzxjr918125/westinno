package west.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 
 * @author  BianMingZhou
 *
 */
@Entity
@Table(name="we_adminmenu")
public class We_AdminMenu implements Serializable {
	private static final long serialVersionUID = -3634612317904647414L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	/**
	 *菜单名称
	 */
	private String  name;
	
	@ManyToOne
	@JoinColumn(name="parentId")
	private We_AdminMenu parent;
	
	///@OneToMany(cascade=CascadeType.PERSIST,mappedBy="parent")
    @Transient
	private List<We_AdminMenu> childrens = new ArrayList<We_AdminMenu>();
	
	private String url;

	private String descmark;
   
	private String logopath;
	
	private int role_type;
	

	
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
	public We_AdminMenu getParent() {
		return parent;
	}
	public void setParent(We_AdminMenu parent) {
		this.parent = parent;
	}
	public List<We_AdminMenu> getChildrens() {
		return childrens;
	}
	public void setChildrens(List<We_AdminMenu> childrens) {
		this.childrens = childrens;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDescmark() {
		return descmark;
	}
	public void setDescmark(String descmark) {
		this.descmark = descmark;
	}
	public int getRole_type() {
		return role_type;
	}
	public void setRole_type(int role_type) {
		this.role_type = role_type;
	}
	public String getLogopath() {
		return logopath;
	}
	public void setLogopath(String logopath) {
		this.logopath = logopath;
	}
}
