package pl.jiro.webapp.admin.category.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pl.jiro.webapp.admin.category.services.CategoryService;

/**
 * @author Łukasz Pawełczak
 */
@Controller
public class CategoryDeleteController {

	
	@Autowired
	private CategoryService categoryService;
	
	
	//------------------------ LOGIC --------------------------
	
	@RequestMapping(value="/admin/deleteCategory", method=RequestMethod.POST)
	public String deleteCategory(@RequestParam Integer id, Model model) {
		
		categoryService.delete(id);
		
		model.addAttribute("actionResponse", "deleteSuccess");
		
		return "redirect:/admin/categoryList";
	}
}
