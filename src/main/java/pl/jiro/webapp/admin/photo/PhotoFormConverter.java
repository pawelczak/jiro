package pl.jiro.webapp.admin.photo;

import org.springframework.stereotype.Service;

import pl.jiro.persistence.model.Photo;

/**
 * 
 * @author Łukasz Pawełczak
 *
 */
@Service
public class PhotoFormConverter {

	
	//------------------------ LOGIC --------------------------
	
	public Photo convert(PhotoForm photoForm) {
		
		Photo photo = new Photo();
		
		photo.setId(photoForm.getId());
		photo.setCid(photoForm.getCid());
		photo.setTitle(photoForm.getTitle());
		photo.setSrc(photoForm.getSrc());
		photo.setFeatured(photoForm.getFeatured());
		photo.setVisible(photoForm.getVisible());
		photo.setPosition(photoForm.getPosition());
		photo.setDescription(photoForm.getDescription());
		
		return photo;
	}
	
	public PhotoForm convert(Photo photo) {
		
		PhotoForm photoForm = new PhotoForm();
		
		photoForm.setId(photo.getId());
		photoForm.setCid(photo.getCid());
		photoForm.setTitle(photo.getTitle());
		photoForm.setSrc(photo.getSrc());
		photoForm.setFeatured(photo.getFeatured());
		photoForm.setVisible(photo.getVisible());
		photoForm.setPosition(photo.getPosition());
		photoForm.setDescription(photo.getDescription());
		
		return photoForm;
	}
}
