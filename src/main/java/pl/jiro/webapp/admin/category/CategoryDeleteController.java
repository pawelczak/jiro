package pl.jiro.webapp.admin.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pl.jiro.persistence.model.Category;
import pl.jiro.persistence.repository.CategoryRepository;
import pl.jiro.webapp.admin.category.services.CategoryDeleteService;

/**
 * @author Łukasz Pawełczak
 */
@Controller
public class CategoryDeleteController {

	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private CategoryDeleteService categoryDeleteService;
	
	
	//------------------------ LOGIC --------------------------
	
	@RequestMapping(value="/admin/deleteCategory", method=RequestMethod.POST)
	public String deleteCategory(@RequestParam Integer id, Model model) {
		
		Category category = categoryRepository.findCategoryById(id);
		
		categoryDeleteService.delete(category);
		
		model.addAttribute("actionResponse", "deleteSuccess");
		
		return "redirect:/admin/categoryList";
	}
}
