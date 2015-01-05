package pl.jiro.webapp.admin.category.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.jiro.webapp.admin.category.services.CategoryService;

/**
 * @author Łukasz Pawełczak
 */
@Controller
public class CategoryVisibleChangeController {

	@Autowired
	private CategoryService categoryService;

	
	//------------------------ LOGIC --------------------------
	
	@RequestMapping("/admin/category/visibleChange")
	public String visilePhoto(@RequestParam long id, @RequestParam boolean visibility, Model model) {

		categoryService.changeVisible((int)id, visibility);
		
		return "redirect:/admin/categoryList";
	}
}
