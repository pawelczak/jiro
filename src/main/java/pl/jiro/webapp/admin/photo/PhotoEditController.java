package pl.jiro.webapp.admin.photo;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import pl.jiro.persistence.model.Category;
import pl.jiro.persistence.model.Photo;
import pl.jiro.persistence.repository.CategoryRepository;
import pl.jiro.persistence.repository.PhotoRepository;
import pl.jiro.photo.ImageUploadException;


/**
 * @author Łukasz Pawełczak
 */
@Controller
@SessionAttributes("sessionCid")
public class PhotoEditController {

	
	@Value("${jiro.photo.path}")
	private String webContext;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private PhotoRepository photoRepository;
	
	
	//------------------------ LOGIC --------------------------
	
	@RequestMapping(value="/admin/editPhoto", method=RequestMethod.GET)
	public String editPhoto(@RequestParam long id, Model model) {
		List<Category> categories = categoryRepository.findAll();
		model.addAttribute("categories", categories);
		
		model.addAttribute("formHeader", "edit");
		Photo photo = photoRepository.getPhotoById(id);
		model.addAttribute("photo", photo);
		model.addAttribute("photoSrc", photo.getSrc());
		
		return "photoAdd";
	}
	
	@RequestMapping(value="/admin/editPhoto", method=RequestMethod.POST)
	public String editPhotoPost(@ModelAttribute @Valid Photo photo, 
			@RequestParam(value="image", required=false) MultipartFile image,
			@RequestParam(value="image_uploaded", required=false) String imageUploaded,
			BindingResult bindingResult, Model model) {
		
		
		if (bindingResult.hasErrors()) {
			model.addAttribute("formHeader", "edit");
            return "photoAdd";
        }		
		
		photo.setSrc(imageUploaded);
		
		if (image != null) {
			if (!image.isEmpty()) {
				deleteImage(getImagePath(photo.getId()));
				
				validateImage(image);
				saveImage(webContext + photo.getId() + ".jpg", image);
				photo.setSrc(photo.getId() + ".jpg");
			}
		}
		
		photoRepository.editPhoto(photo);
		model.addAttribute("actionResponse", "editSuccess");
		
		return "redirect:/admin/photoList/" + photo.getCid();
	}
	
	//------------------------ PRIVATE --------------------------
	
	private String getImagePath(long id) {
		return webContext + id + ".jpg";
	}
	
	private void validateImage(MultipartFile image) {
		if (!image.getContentType().equals("image/jpeg")) {
			throw new ImageUploadException("Nieakceptowane pliki jpeg");
		}
		
	}
	
	private void saveImage(String filename, MultipartFile image) throws ImageUploadException {
		try {
			File file = new File (filename);
			FileUtils.writeByteArrayToFile(file, image.getBytes());
		} catch(IOException e) {
			throw new ImageUploadException("photo.upload.fail");
		}
		
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
