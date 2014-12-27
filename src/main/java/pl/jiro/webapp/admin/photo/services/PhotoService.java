package pl.jiro.webapp.admin.photo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import pl.jiro.persistence.model.Photo;
import pl.jiro.persistence.repository.PhotoRepository;
import pl.jiro.photo.ImageUploadException;

/**
 * @author Łukasz Pawełczak
 */
@Service
public class PhotoService {

	
	@Value("${jiro.photo.path}")
	private String webContext;
	
	@Autowired
	private PhotoRepository photoRepository;
	
	@Autowired
	private PhotoImageService photoImageService;
	
	
	//------------------------ LOGIC --------------------------
	
	public boolean add(Photo photo, MultipartFile image) {
		photo.setSrc(" ");
		photoRepository.addPhoto(photo);
		
		try {
			if (!image.isEmpty()) {
				photoImageService.validateImage(image);
				photoImageService.save(webContext + photo.getId() + ".jpg", image);
				photo.setSrc(photo.getId() + ".jpg");
			}
		} catch (ImageUploadException e) {
			return false;
		}
		
		photoRepository.editPhoto(photo);
		
		return true;
	}
	
	public void edit(Photo photo, MultipartFile image, String imageUploaded) {
		photo.setSrc(imageUploaded);
		
		if (image != null) {
			if (!image.isEmpty()) {
				photoImageService.delete((int)photo.getId());
				
				photoImageService.validateImage(image);
				photoImageService.save(webContext + photo.getId() + ".jpg", image);
				photo.setSrc(photo.getId() + ".jpg");
			}
		}
		
		photoRepository.editPhoto(photo);
	}
	
	public void delete(Photo photo) {
		photoRepository.deletePhoto(photo);
		photoImageService.delete((int)photo.getId());
	}
	
	public void deleteAllByCategoryId(int categoryId) {
		List<Photo> photos = photoRepository.findByCategoryId(categoryId);
		
		photoRepository.deletePhotosInCategory(categoryId);
		
		for(Photo photo : photos) {
			photoImageService.delete((int)photo.getId());
		}
	}
	
	public void setFeaturedStatus(Photo photo, boolean status) {
		photo.setFeatured(status);
		
		if (status) {
			photo.setVisible(true);
		}
		
		photoRepository.editPhoto(photo);
	}
	
	public void setVisibility(Photo photo, boolean visibility) {
		photo.setVisible(visibility);
		photoRepository.editPhoto(photo);
	}
	
	
}
