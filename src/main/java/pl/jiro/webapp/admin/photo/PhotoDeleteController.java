package pl.jiro.webapp.admin.photo;

import java.io.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import pl.jiro.persistence.model.Photo;
import pl.jiro.persistence.repository.PhotoRepository;

/**
 * @author Łukasz Pawełczak
 */
@Controller
@SessionAttributes("sessionCid")
public class PhotoDeleteController {
	
	@Value("${jiro.photo.path}")
	private String webContext;
	
	@Autowired
	private PhotoRepository photoRepository;
	
	
	//------------------------ LOGIC --------------------------
	
	@RequestMapping(value="/admin/deletePhoto", method=RequestMethod.POST)
	public String deletePhoto(@RequestParam long id, Model model) {
		
		Photo photo = photoRepository.getPhotoById(id);
		long categoryId = photo.getCid();
		photoRepository.deletePhoto(photo);
		
		deleteImage(getImagePath(photo.getId()));
		
		model.addAttribute("actionResponse", "deleteSuccess");
		
		return "redirect:/admin/photoList/" + String.valueOf(categoryId);
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
