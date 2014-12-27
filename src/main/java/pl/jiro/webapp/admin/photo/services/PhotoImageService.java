package pl.jiro.webapp.admin.photo.services;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import pl.jiro.photo.ImageUploadException;

/**
 * @author Łukasz Pawełczak
 */
@Service
public class PhotoImageService {

	
	@Value("${jiro.photo.path}")
	private String webContext;
	
	
	//------------------------ LOGIC --------------------------
	
	public void delete(int id) {
		deleteImage(getImagePath(id));
	}
	
	public void delete(String filename) {
		deleteImage(filename);
	}
	
	public void save(String filename, MultipartFile image) throws ImageUploadException {
		try {
			File file = new File (filename);
			FileUtils.writeByteArrayToFile(file, image.getBytes());
		} catch(IOException e) {
			throw new ImageUploadException("photo.upload.fail");
		}
		
	}
	
	public void validateImage(MultipartFile image) {
		if (!image.getContentType().equals("image/jpeg")) {
			throw new ImageUploadException("Nieakceptowane pliki jpeg");
		}
	}
	
	//------------------------ PRIVATE --------------------------
	
	private String getImagePath(long id) {
		return webContext + id + ".jpg";
	}
	
	private void deleteImage(String filename) {
		try {
			 
    		File file = new File(filename);
 
    		if(file.delete()){
    			System.out.println(file.getName() + " is deleted!");
    		} else {
    			System.out.println("Delete operation is failed.");
    		}
    	} catch(Exception e){
    		e.printStackTrace();
    	}
	}
}
