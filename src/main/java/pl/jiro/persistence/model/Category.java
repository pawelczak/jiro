package pl.jiro.persistence.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Łukasz Pawełczak
 */
@Entity
@Table(name = "category")
public class Category {
	
	
	@Id
	@GeneratedValue
	private Integer id;	
	
	private String name;
	
	private String description;
	
	private boolean visible = false;
	
	private long views;
	
	/*
	@DateTimeFormat(pattern=FormatConst.DATE_FORMAT_PATTERN)
	private Date addDate;
	
	@DateTimeFormat(pattern=FormatConst.DATE_FORMAT_PATTERN)
	private Date modDate;*/
	
	
	//------------------------ CONSTRUCTORS --------------------------
	
	public Category() {}
	
	public Category(String name) {
		this.name = name;
	}
	
	
	//------------------------ GETTERS --------------------------
	
	public Integer getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public boolean getVisible() {
		return visible;
	}
	
	public long getViews() {
		return views;
	}
	/*
	public Date getAddDate() {
		return addDate;
	}
	
	public Date getModDate() {
		return modDate;
	}*/
	
	
	//------------------------ SETTERS --------------------------
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDescription(String desc) {
		this.description = desc;
	}
	
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	
	public void setViews(long views) {
		this.views = views;
	}
	
	/*
	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}
	
	public void setModDate(Date modDate) {
		this.modDate = modDate;
	}
	*/

}

