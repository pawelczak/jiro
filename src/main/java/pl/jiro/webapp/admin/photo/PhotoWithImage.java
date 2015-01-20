package pl.jiro.webapp.admin.photo;

import org.springframework.web.multipart.MultipartFile;

import pl.jiro.persistence.model.Photo;

/**
 * 
 * @author Łukasz Pawełczak
 *
 */
public class PhotoWithImage {

	
	private Photo photo;
	
	private MultipartFile image;

	//------------------------ CONSTRUCTORS --------------------------
	
	public PhotoWithImage(Photo photo, MultipartFile image) {
		this.photo = photo;
		this.image = image;
	}
	
	//------------------------ GETTERS --------------------------
	
	public Photo getPhoto() {
		return photo;
	}
	
	public MultipartFile getImage() {
		return image;
	}

	//------------------------ SETTERS --------------------------
	
	public void setPhoto(Photo photo) {
		this.photo = photo;
	}
	
	public void setImage(MultipartFile image) {
		this.image = image;
	}
	
}

