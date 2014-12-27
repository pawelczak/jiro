package pl.jiro.webapp.admin.category;

import java.util.List;

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
public class CategoryListController {

	
	@Autowired
	private CategoryRepository categoryRepository;
	
	
	//------------------------ LOGIC --------------------------
	
	@RequestMapping("/admin/categoryList")
	public String categoryList(@RequestParam(value="actionResponse", required=false) String res, Model model) {
		
		List<Category> categories = categoryRepository.findAll();
		
		model.addAttribute("categories", categories);
		model.addAttribute("message", res);
		
		return "categoryList";
	}
}
