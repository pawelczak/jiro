package pl.jiro.persistence.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 * @author Łukasz Pawełczak
 */
@Entity
@Table(name = "category")
public class Category {
	
	
	@Id
	@GeneratedValue
	private Integer id;	
	
	@Size(min=3, max=128, message="Nazwa kategorii musi sk�ada� si� z 3 do 128 znak�w.")
	private String name;
	
	@Size(min=0, max=256, message="Opis kategorii mo�e sk�ada� si� maksymalnie z 256 znak�w.")
	private String description;
	
	private boolean visible = false;
	
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
	
	/*
	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}
	
	public void setModDate(Date modDate) {
		this.modDate = modDate;
	}
	*/

}

