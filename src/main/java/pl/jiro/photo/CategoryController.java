package pl.jiro.photo;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.validation.BindingResult;


@Controller
public class CategoryController {
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private PhotoDAO photoDAO;
	
	/*@Autowired
	private CategoryService categoryService;
	*/
	
	@RequestMapping("/admin/category")
	public String categoryList(@RequestParam(value="actionResponse", required=false) String res, Model model) {
		
		List<Category> categories = categoryDAO.findAll();
		//List<Category> categories = categoryService.findAll();
		model.addAttribute("categories", categories);
		
		model.addAttribute("message", res);
		
		return "categoryList";
	}
	
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
		
		//categoryService.add(category);
		
		categoryDAO.addCategory(category);
		model.addAttribute("actionResponse", "addSuccess");
		
		return "redirect:/admin/category";
	}
	
	@RequestMapping(value="/admin/deleteCategory", method=RequestMethod.POST)
	public String deleteCategory(@RequestParam long id, Model model) {
		
		Category category = categoryDAO.getCategoryById(id);
		categoryDAO.deleteCategory(category);
		
		
		//Category category = categoryService.getCategoryById(id);
		
		//categoryService.delete(category);
		
		photoDAO.deletePhotosInCategory(String.valueOf(id));
		
		model.addAttribute("actionResponse", "deleteSuccess");
		
		return "redirect:/admin/category";
	}
	
	@RequestMapping(value="/admin/editCategory", method=RequestMethod.GET)
	public String editCategory(@RequestParam long id, Model model) {
		
		model.addAttribute("formHeader", "edit");
		Category category = categoryDAO.getCategoryById(id);
		
		//Category category = categoryService.getCategoryById(id);
		
		model.addAttribute("category", category);
		
		
		return "categoryAdd";
	}
	
	
	@RequestMapping(value="/admin/editCategory", method=RequestMethod.POST)
	public String editCategory(@ModelAttribute @Valid Category category, BindingResult bindingResult, Model model) {
		
		if (bindingResult.hasErrors()) {
			model.addAttribute("formHeader", "edit");
            return "categoryAdd";
        }
		
		categoryDAO.editCategory(category);
		
		//categoryService.update(category);
		
		model.addAttribute("actionResponse", "editSuccess");
		
		return "redirect:/admin/category";
	}
	
	
	
	
}