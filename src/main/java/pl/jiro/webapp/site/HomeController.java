package pl.jiro.webapp.site;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.jiro.persistence.repository.PreviewPhotoRepository;
import pl.jiro.webapp.gallery.GalleryListService;

/**
 * 
 * @author Łukasz Pawełczak
 *
 */
@Controller
public class HomeController {
	
	
	@Autowired
	private GalleryListService galleryListService;
	
	@Autowired
	private PreviewPhotoRepository previewPhotoRepository;
	
	
	//------------------------ LOGIC --------------------------
    
    @RequestMapping("/")
    public String home(ModelMap model) {
        
    	model.addAttribute("mostPopularGalleries", galleryListService.findMostPopular());
    	model.addAttribute("lastAddedGalleries", galleryListService.findThreeLastAdded());
    	
    	model.addAttribute("carouselPhotos", previewPhotoRepository.findAllVisible());
        return "home";
    }
}