package pl.jiro.webapp.admin.photo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.jiro.persistence.model.Photo;
import pl.jiro.persistence.repository.PhotoRepository;

/**
 * 
 * @author Łukasz Pawełczak
 *
 */
@Service
public class PhotoFormConverter {

	
	@Autowired
	private PhotoRepository photoRepository;
	
	//------------------------ LOGIC --------------------------
	
	public Photo convert(PhotoForm photoForm) {
		
		Photo photo = new Photo();
		
		photo.setId(photoForm.getId());
		photo.setCid(photoForm.getCid());
		photo.setTitle(photoForm.getTitle());
		photo.setSrc(photoForm.getSrc());
		photo.setDescription(photoForm.getDescription());
		
		return photo;
	}
	
	public PhotoForm convert(Photo photo) {

		PhotoForm photoForm = new PhotoForm();
		
		photoForm.setId(photo.getId());
		photoForm.setCid(photo.getCid());
		photoForm.setTitle(photo.getTitle());
		photoForm.setSrc(photo.getSrc());
		photoForm.setDescription(photo.getDescription());
		
		return photoForm;
	}
}
