package pl.jiro.persistence.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Łukasz Pawełczak
 */
@Entity
@Table(name = "article")
public class Article {
	
	
	@Id 
	@GeneratedValue
	private Integer id;
	
	private String title;
	
	
	//------------------------ GETTERS --------------------------	
	
	public Integer getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}
	
	
	//------------------------ SETTERS --------------------------
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
}
