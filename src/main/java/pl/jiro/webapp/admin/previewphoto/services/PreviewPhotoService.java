package pl.jiro.webapp.admin.previewphoto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import pl.jiro.persistence.model.PreviewPhoto;
import pl.jiro.persistence.repository.PreviewPhotoRepository;
import pl.jiro.photo.ImageUploadException;
import pl.jiro.webapp.admin.photo.services.PhotoImageService;

/**
 * 
 * @author Łukasz Pawełczak
 *
 */
@Service
public class PreviewPhotoService {

	
	@Value("${jiro.previewPhoto.path}")
	private String webContext;
	
	@Autowired
	private PhotoImageService photoImageService;

	@Autowired
	private PreviewPhotoRepository previewPhotoRepository;
	
	
	//------------------------ LOGIC --------------------------
	
	public boolean add(PreviewPhoto previewPhoto, MultipartFile image) {
		previewPhoto.setSrc(" ");
		previewPhotoRepository.add(previewPhoto);
		
		try {
			if (!image.isEmpty()) {
				photoImageService.validateImage(image);
				photoImageService.save(webContext + previewPhoto.getId() + ".jpg", image);
				previewPhoto.setSrc(previewPhoto.getId() + ".jpg");
			}
		} catch (ImageUploadException e) {
			return false;
		}
		
		previewPhoto.setPosition((int)previewPhoto.getId());
		previewPhotoRepository.edit(previewPhoto);
		
		return true;
	}
	
	public void edit(PreviewPhoto previewPhoto, MultipartFile image, String imageUploaded) {
		previewPhoto.setSrc(imageUploaded);
		
		if (image != null) {
			if (!image.isEmpty()) {
				photoImageService.delete((int)previewPhoto.getId());
				
				photoImageService.validateImage(image);
				photoImageService.save(webContext + previewPhoto.getId() + ".jpg", image);
				previewPhoto.setSrc(previewPhoto.getId() + ".jpg");
			}
		}
		
		previewPhotoRepository.edit(previewPhoto);
	}
	
	public void delete(PreviewPhoto previewPhoto) {
		previewPhotoRepository.delete(previewPhoto);
		photoImageService.delete((int)previewPhoto.getId());
	}
	
	public void setVisibility(PreviewPhoto previewPhoto, boolean visibility) {
		previewPhoto.setVisible(visibility);
		previewPhotoRepository.edit(previewPhoto);
	}
	
	public void switchPosition(PreviewPhoto firstPhoto, PreviewPhoto secondPhoto) {
		int frstPhotoPosition = firstPhoto.getPosition();
		
		firstPhoto.setPosition(secondPhoto.getPosition());
		secondPhoto.setPosition(frstPhotoPosition);
		
		previewPhotoRepository.edit(firstPhoto);
		previewPhotoRepository.edit(secondPhoto);
	}
}
