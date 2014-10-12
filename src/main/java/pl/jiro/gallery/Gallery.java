package pl.jiro.gallery;

import java.util.*;

import pl.jiro.photo.Category;
import pl.jiro.photo.Photo;

public class Gallery {
	
	private Category category;
	private Photo image;
	
	public Gallery(Category cat, Photo img) {
		this.category = cat;
		this.image = img;
	}
	
	public void setCategory(Category cat) {
		this.category = cat; 
	}
	
	public Category getCategory() {
		return this.category;
	}
	
	
	public void setImage(Photo image) {
		this.image = image;
	}
	
	public Photo getImage() {
		return this.image;
	}
}