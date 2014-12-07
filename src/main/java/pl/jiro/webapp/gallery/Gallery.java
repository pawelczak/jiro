package pl.jiro.webapp.gallery;

import pl.jiro.persistence.model.Category;
import pl.jiro.persistence.model.Photo;

/*
 * @author £ukasz Pawe³czak
 */
public class Gallery {
	
	private Category category;
	private Photo photo;
	
	
	//------------------------ CONSTRUCTORS --------------------------
	
	public Gallery(Category cat, Photo photo) {
		this.category = cat;
		this.photo = photo;
	}
	
	
	//------------------------ GETTERS --------------------------
	
	public Category getCategory() {
		return this.category;
	}
	
	public Photo getPhoto() {
		return this.photo;
	}
	
	//------------------------ SETTERS --------------------------
	
	public void setCategory(Category category) {
		this.category = category; 
	}
	
	public void setPhoto(Photo photo) {
		this.photo = photo;
	}
}