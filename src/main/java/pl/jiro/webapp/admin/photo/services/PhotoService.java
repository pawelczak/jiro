package pl.jiro.webapp.admin.photo.services;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

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
	
	public boolean add(Photo photo, MultipartFile image) throws IOException {
		photo.setSrc(" ");
		photo.setPosition(0);
		photo.setFeatured(false);
		photo.setVisible(true);
		photo.setFront(false);
		photoRepository.addPhoto(photo);
		
		try {
			if (!image.isEmpty()) {
				photoImageService.validateImage(image);
				photoImageService.save(webContext + photo.getId() + ".jpg", image);
				photo.setSrc(photo.getId() + ".jpg");
				BufferedImage bufferedImage = ImageIO.read(new File(webContext + photo.getId() + ".jpg"));
				photo.setWidth( bufferedImage.getWidth());
				photo.setHeight(bufferedImage.getHeight());
			}
		} catch (ImageUploadException e) {
			return false;
		}
		
		photo.setPosition((int)photo.getId());
		photoRepository.editPhoto(photo);
		
		return true;
	}
	
	public void edit(Photo photo, MultipartFile image) throws IOException {
		Photo basePhoto = photoRepository.findPhotoById(photo.getId());
		
		photo.setPosition(basePhoto.getPosition());
		photo.setFeatured(basePhoto.getFeatured());
		photo.setVisible(basePhoto.getVisible());
		
		editPhoto(photo, image);
	}
	
	public void edit(Photo photo, MultipartFile image, String imageUploaded) throws IOException {
		Photo basePhoto = photoRepository.findPhotoById(photo.getId());
		
		photo.setPosition(basePhoto.getPosition());
		photo.setFeatured(basePhoto.getFeatured());
		photo.setVisible(basePhoto.getVisible());
		photo.setSrc(imageUploaded);
		
		editPhoto(photo, image);
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
	
	public void setFront(Photo photo, boolean front) {
		if (front) {
			clearFrontAllPhotoByCategory((int)photo.getCid());
		}
		
		photo.setFront(front);
		photoRepository.editPhoto(photo);
	}
	
	public void switchPosition(Photo firstPhoto, Photo secondPhoto) {
		int frstPhotoPosition = firstPhoto.getPosition();
		
		firstPhoto.setPosition(secondPhoto.getPosition());
		secondPhoto.setPosition(frstPhotoPosition);
		
		photoRepository.editPhoto(firstPhoto);
		photoRepository.editPhoto(secondPhoto);
	}
	
	
	//------------------------ PRIVATE --------------------------
	
	private void editPhoto(Photo photo, MultipartFile image) throws IOException {
		
		if (image != null) {
			if (!image.isEmpty()) {
				photoImageService.delete((int)photo.getId());
				
				photoImageService.validateImage(image);
				photoImageService.save(webContext + photo.getId() + ".jpg", image);
				photo.setSrc(photo.getId() + ".jpg");
				
				BufferedImage bufferedImage = ImageIO.read(new File(webContext + photo.getId() + ".jpg"));
				photo.setWidth( bufferedImage.getWidth());
				photo.setHeight(bufferedImage.getHeight());
			}
		}
		
		photoRepository.editPhoto(photo);
	}
	
	
	private void clearFrontAllPhotoByCategory(int categoryId) {
		List<Photo> photos = photoRepository.findByCategoryId(categoryId);
		
		for(Photo photo : photos) {
			photo.setFront(false);
			photoRepository.editPhoto(photo);
		}
	}
}
