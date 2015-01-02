package pl.jiro.webapp.site.gallery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.jiro.persistence.repository.PhotoRepository;
import pl.jiro.webapp.site.photo.PhotoFeaturedService;

/*
 * @author �ukasz Pawe�czak
 */
@Controller
public class GalleryFeaturedController {

	
	
	@Autowired
	private PhotoRepository photoRepository;
	
	@Autowired
	private PhotoFeaturedService photoFeaturedService;
	
	
	//------------------------ LOGIC --------------------------	
	
	@RequestMapping("/featured")
	public String featured(Model model) {
		
		model.addAttribute("photos", photoFeaturedService.findAll());
		
		return "featured";
	}
}
