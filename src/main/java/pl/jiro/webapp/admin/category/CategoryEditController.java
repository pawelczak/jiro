package pl.jiro.webapp.admin.category;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pl.jiro.persistence.model.Category;
import pl.jiro.persistence.repository.CategoryRepository;

/**
 * @author Łukasz Pawełczak
 */
@Controller
public class CategoryEditController {
	
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	
	//------------------------ LOGIC --------------------------
	
	@RequestMapping(value="/admin/editCategory", method=RequestMethod.GET)
	public String editCategory(@RequestParam Integer id, Model model) {
		
		Category category = categoryRepository.findCategoryById(id);
		
		model.addAttribute("formHeader", "edit");
		model.addAttribute("category", category);
		
		return "categoryAdd";
	}
	
	
	@RequestMapping(value="/admin/editCategory", method=RequestMethod.POST)
	public String editCategory(@ModelAttribute @Valid Category category, BindingResult bindingResult, Model model) {
		
		if (bindingResult.hasErrors()) {
			model.addAttribute("formHeader", "edit");
            return "categoryAdd";
        }
		
		categoryRepository.editCategory(category);

		model.addAttribute("actionResponse", "editSuccess");
		
		return "redirect:/admin/categoryList";
	}
}
