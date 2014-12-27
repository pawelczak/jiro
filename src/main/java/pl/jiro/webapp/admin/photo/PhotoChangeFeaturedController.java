package pl.jiro.webapp.admin.photo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import pl.jiro.persistence.model.Photo;
import pl.jiro.persistence.repository.PhotoRepository;
import pl.jiro.webapp.admin.photo.services.PhotoService;

/**
 * @author Łukasz Pawełczak
 */
@Controller
@SessionAttributes("sessionCid")
public class PhotoChangeFeaturedController {

	
	@Autowired
	private PhotoRepository photoRepository;
	
	@Autowired
	private PhotoService photoService;
	
	//------------------------ LOGIC --------------------------
	
	@RequestMapping("/admin/featurePhoto")
	public String featurePhoto(@RequestParam long id, @RequestParam boolean status, Model model) {
		Photo photo = photoRepository.getPhotoById(id);
		
		photoService.setFeaturedStatus(photo, status);
		
		return "redirect:/admin/photoList/" + String.valueOf(photo.getCid());
	}
}
