package pl.jiro.webapp.admin.photo;

import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import pl.jiro.persistence.model.Category;
import pl.jiro.persistence.model.Photo;
import pl.jiro.persistence.repository.CategoryRepository;
import pl.jiro.persistence.repository.PhotoRepository;

/**
 * @author Łukasz Pawełczak
 */
@Controller
@SessionAttributes("sessionCid")
public class PhotoListController {

	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private PhotoRepository photoRepository;
	
	
	//------------------------ LOGIC --------------------------
	
	@RequestMapping("/admin/photoList")
	public String photoList(@RequestParam(value="actionResponse", required=false) String res, Model model) {
		List<Category> categories = categoryRepository.findAll();
		List<Photo> photos = Collections.emptyList();
		
		if (categories.size() > 0) {
			photos = photoRepository.findByCategoryId(categories.get(0).getId());
		} 
		
		model.addAttribute("categories", categories);
		model.addAttribute("photos", photos);
		model.addAttribute("message", res);
		
		return "photoList";
	}
	
	@RequestMapping("/admin/photoList/{categoryId}")
	public String photoListByCategoryId(@RequestParam(value="actionResponse", required=false) String res,
			@PathVariable int categoryId, Model model) {
		List<Category> categories = categoryRepository.findAll();
		List<Photo> photos = photoRepository.findByCategoryId(categoryId);
		
		model.addAttribute("categories", categories);
		model.addAttribute("categoryId", (categoryId));
		model.addAttribute("sessionCid", (categoryId));
		model.addAttribute("photos", photos);
		model.addAttribute("message", res);
		
		return "photoList";
	}
}
