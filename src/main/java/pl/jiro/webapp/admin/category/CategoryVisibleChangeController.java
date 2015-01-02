package pl.jiro.webapp.admin.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.jiro.persistence.model.Category;
import pl.jiro.persistence.repository.CategoryRepository;

/**
 * @author Łukasz Pawełczak
 */
@Controller
public class CategoryVisibleChangeController {

	@Autowired
	private CategoryRepository categoryRepository;

	
	//------------------------ LOGIC --------------------------
	
	@RequestMapping("/admin/category/visibleChange")
	public String visilePhoto(@RequestParam long id, @RequestParam boolean visibility, Model model) {

		Category category = categoryRepository.findCategoryById((int)id);
		
		category.setVisible(visibility);
		
		categoryRepository.editCategory(category);
		
		return "redirect:/admin/categoryList";
	}
}
