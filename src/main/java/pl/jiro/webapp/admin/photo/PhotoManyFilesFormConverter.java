package pl.jiro.webapp.admin.photo;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.google.common.collect.Lists;

import pl.jiro.persistence.model.Photo;

/**
 * 
 * @author Łukasz Pawełczak
 *
 */
@Service
public class PhotoManyFilesFormConverter {

	
	//------------------------ LOGIC --------------------------
	
	public List<PhotoWithImage> convert(PhotoManyFilesForm photoForm) {
		
		List<PhotoWithImage> photos = Lists.newArrayList();
		
		for(MultipartFile file: photoForm.getFiles()) {
			
			Photo photo = new Photo();
			
			photo.setId(photoForm.getId());
			photo.setCid(photoForm.getCid());
			photo.setTitle("");
			photo.setSrc(file.getOriginalFilename()); //file src
			photo.setFeatured(photoForm.getFeatured());
			photo.setVisible(photoForm.getVisible());
			photo.setPosition(photoForm.getPosition());
			photo.setDescription("");
			
			photos.add(new PhotoWithImage(photo, file));
		}
		
		return photos;
	}

}
