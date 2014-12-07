package pl.jiro.webapp.site.gallery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.jiro.persistence.repository.CategoryRepository;
import pl.jiro.persistence.repository.PhotoRepository;


/*
 * @author £ukasz Pawe³czak
 */
@Controller
public class GalleryDetailController {

	
	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private PhotoRepository photoRepository;
	
	
	//------------------------ LOGIC --------------------------	
	
	@RequestMapping("/gallery/{categoryId}")
	public String detailGallery(@PathVariable("categoryId") Integer categoryId, Model model) {
		
		model.addAttribute("category", categoryRepository.findCategoryById(categoryId));
		model.addAttribute("photos", photoRepository.findVisibleByCategoryId(categoryId));
		
		return "galleryDetail";
	}
}
