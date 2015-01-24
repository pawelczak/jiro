package pl.jiro.persistence.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.apache.commons.dbcp.BasicDataSource;

/**
 * @author Łukasz Pawełczak
 */
@Entity
@Table(name = "photo")
public class Photo extends BasicDataSource {
	
	
	@Id
	@GeneratedValue
	private long id;
	
	private long cid;
	
	private String title;
	
	private String src;
	
	private int height;
	
	private int width;
	
	private boolean featured = false;
	
	private boolean visible = true;
	
	private int position;
	
	private String description;
	
	
	//------------------------ CONSTRUCTORS --------------------------
	
	public Photo() {}
	
	public Photo(String title) {
		this.title = title;
	}
	
	
	//------------------------ GETTERS --------------------------
	
	public long getId() {
		return id;
	}
	
	public long getCid() {
		return cid;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getSrc() {
		return src;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getWidth() {
		return width;
	}
	
	public boolean getVisible() {
		return visible;
	}
	
	public boolean getFeatured() {
		return featured;
	}
	
	public int getPosition() {
		return position;
	}
	
	public String getDescription() {
		return description;
	}
	
	
	
	
	//------------------------ PRIVATE --------------------------
	
	private void init() {
	    addConnectionProperty("useUnicode", "true");
	    addConnectionProperty("characterEncoding", "UTF-8");
	}
	
	//------------------------ SETTERS --------------------------
	
	public void setId(long id) {
		this.id = id;
	}
	
	public void setCid(long cid) {
		this.cid = cid;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setSrc(String src) {
		this.src = src;
	}	
	
	public void setHeight(int height) {
		this.height = height;
	} 
	
	public void setWidth(int width) {
		this.width = width;
	}
		
	public void setVisible(boolean vis) {
		this.visible = vis;
	}
	
	public void setFeatured(boolean feat) {
		featured = feat;
	}
	
	public void setPosition(int pos) {
		position = pos;
	}
	
	public void setDescription(String desc) {
		this.description = desc;
	}
	
	
	
}
