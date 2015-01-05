package pl.jiro.webapp.admin.category.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pl.jiro.persistence.repository.CategoryRepository;
import pl.jiro.webapp.admin.category.CategoryForm;
import pl.jiro.webapp.admin.category.CategoryFormConverter;

/**
 * @author Łukasz Pawełczak
 */
@Controller
public class CategoryEditController {
	
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private CategoryFormConverter categoryFormConverter;
	
	//------------------------ LOGIC --------------------------
	
	@RequestMapping(value="/admin/editCategory", method=RequestMethod.GET)
	public String editCategory(@RequestParam Integer id, Model model) {
		
		model.addAttribute("formHeader", "edit");
		model.addAttribute("categoryForm", categoryFormConverter.convert(categoryRepository.findCategoryById(id)));
		
		return "categoryAdd";
	}
	
	
	@RequestMapping(value="/admin/editCategory", method=RequestMethod.POST)
	public String editCategory(@ModelAttribute @Valid CategoryForm categoryForm, BindingResult bindingResult, Model model) {
		
		if (bindingResult.hasErrors()) {
			model.addAttribute("formHeader", "edit");
            return "categoryAdd";
        }
		
		categoryRepository.editCategory(categoryFormConverter.convert(categoryForm));

		model.addAttribute("actionResponse", "editSuccess");
		
		return "redirect:/admin/categoryList";
	}
}
