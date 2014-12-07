package pl.jiro.webapp.site.gallery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.jiro.persistence.repository.PhotoRepository;

/*
 * @author £ukasz Pawe³czak
 */
@Controller
public class GalleryFeaturedController {

	@Autowired
	private PhotoRepository photoRepository;
	
	@RequestMapping("/featured")
	public String featured(Model model) {
		
		model.addAttribute("photos", photoRepository.findAllFeatured());
		
		return "featured";
	}
}
