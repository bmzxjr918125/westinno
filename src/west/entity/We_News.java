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
 * 新闻资讯信息表
 * @ClassName: We_News
 * @Description: TODO
 * @author BianMingZhou
 * @date 2016-3-22 上午10:49:35
 */
@Entity
@Table(name="we_news")
public class We_News implements Serializable {
	private static final long serialVersionUID = 4243313186377988226L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	/**
	 * 标题
	 */
	@Column(length=200)
	private String title;
	/**
	 * 简述
	 */
	@Column(length=500)
	private String scan;
    /**
     * 资讯类容
     */
	@Column(length=2^32-1)
	private String content;
	/**
	 * 创建时间
	 */
	@Column(nullable=false,columnDefinition="TIMESTAMP default CURRENT_TIMESTAMP")
	private Date creattime;
	/**
	 * 标签，最多四个，逗号分隔
	 */
	private String tag; 
	/**
	 * 缩略图片
	 */
	private String image;
	/**
	 * 来源
	 */
	private String source;
	/**
	 * 是否推荐 0否1是
	 */
	@Column(columnDefinition="INT default 0",nullable=false)
	private int is_recommend;
	
	/**
	 * 对应类型
	 */
	@ManyToOne
	@JoinColumn(name="news_type_id")
	private We_News_Type news_type_id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreattime() {
		return creattime;
	}

	public void setCreattime(Date creattime) {
		this.creattime = creattime;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public int getIs_recommend() {
		return is_recommend;
	}

	public void setIs_recommend(int is_recommend) {
		this.is_recommend = is_recommend;
	}

	public We_News_Type getNews_type_id() {
		return news_type_id;
	}

	public void setNews_type_id(We_News_Type news_type_id) {
		this.news_type_id = news_type_id;
	}

	public String getScan() {
		return scan;
	}

	public void setScan(String scan) {
		this.scan = scan;
	}
}
