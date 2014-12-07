package pl.jiro.webapp.site.gallery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.jiro.persistence.repository.CategoryRepository;
import pl.jiro.webapp.gallery.GalleryListService;

/*
 * @author £ukasz Pawe³czak
 */
@Controller
public class GalleryListController {
	
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private GalleryListService galleryListService;
	
	
	//------------------------ LOGIC --------------------------	
	
	@RequestMapping("/gallery")
	public String galleryList(ModelMap model) {
		
		model.addAttribute("categories", categoryRepository.findAll());
		model.addAttribute("galleries", galleryListService.listAllGalleries());
		
		return "gallery";
	}
}
