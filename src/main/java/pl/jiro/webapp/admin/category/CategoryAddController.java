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
public class CategoryAddController {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	
	//------------------------ LOGIC --------------------------
	
	@RequestMapping(value="/admin/addCategory", method=RequestMethod.GET)
	public String categoryAddForm(@RequestParam(value="actionResponse", required=false) String res,Model model) {
		
		model.addAttribute("message", res);
		model.addAttribute("formHeader", "add");
		model.addAttribute("category", new Category());
		
		return "categoryAdd";
	}
	
	@RequestMapping(value="/admin/addCategory", method=RequestMethod.POST)
	public String categoryAddForm(@ModelAttribute @Valid Category category, BindingResult bindingResult, Model model) {
		
		if (bindingResult.hasErrors()) {
			model.addAttribute("formHeader", "add");
            return "categoryAdd";
        }
		
		categoryRepository.addCategory(category);
		model.addAttribute("actionResponse", "addSuccess");
		
		return "redirect:/admin/categoryList";
	}
}
