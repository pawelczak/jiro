package pl.jiro.webapp.admin.photo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import pl.jiro.persistence.model.Photo;
import pl.jiro.persistence.repository.PhotoRepository;

/**
 * @author Łukasz Pawełczak
 */
@Controller
@SessionAttributes("sessionCid")
public class PhotoChangeVisibilityController {

	@Autowired
	private PhotoRepository photoRepository;
	
	
	//------------------------ LOGIC --------------------------
	
	@RequestMapping("/admin/photoChangeVisibility")
	public String visilePhoto(@RequestParam long id, @RequestParam boolean visibility, Model model) {
		Photo photo = photoRepository.getPhotoById(id);
		
		photo.setVisible(visibility);
		photoRepository.editPhoto(photo);

		return "redirect:/admin/photoList/" + String.valueOf(photo.getCid());
	}
}

