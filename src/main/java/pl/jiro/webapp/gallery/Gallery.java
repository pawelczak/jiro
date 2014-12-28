package pl.jiro.webapp.gallery;

import java.util.List;

import com.google.common.collect.Lists;

import pl.jiro.persistence.model.Category;
import pl.jiro.persistence.model.Photo;

/**
 * @author Łukasz Pawełczak
 */
public class Gallery {
	
	private Category category;
	private Photo photo;
	private List<Photo> photos = Lists.newArrayList();
	
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
	
	public List<Photo> getPhotos() {
		return this.photos;
	}
	
	//------------------------ SETTERS --------------------------
	
	public void setCategory(Category category) {
		this.category = category; 
	}
	
	public void setPhoto(Photo photo) {
		this.photo = photo;
	}
	
	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}
}