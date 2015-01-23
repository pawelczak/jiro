package pl.jiro.webapp.site.gallery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.jiro.persistence.repository.CategoryRepository;
import pl.jiro.persistence.repository.PhotoRepository;


/**
 * @author Łukasz Pawełczak
 */
@Controller
public class GalleryDetailController {

	
	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private PhotoRepository photoRepository;
	
	@Autowired
	private GalleryVoteService galleryVoteService;
	
	//------------------------ LOGIC --------------------------	
	
	@RequestMapping("/gallery/{categoryId}")
	public String detailGallery(@PathVariable("categoryId") Integer categoryId, Model model) {
		
		galleryVoteService.voteUp(categoryId);
		
		model.addAttribute("category", categoryRepository.findCategoryById(categoryId));
		model.addAttribute("photos", photoRepository.findVisibleByCategoryId(categoryId));
		
		return "galleryDetail";
	}
	
	@RequestMapping("/test")
	public String testGallery(Model model) {
		
	
		model.addAttribute("photos", photoRepository.findVisibleByCategoryId(35));
		
		return "test";
	}
	
	
}
