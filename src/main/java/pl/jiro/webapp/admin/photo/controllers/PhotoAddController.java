package pl.jiro.webapp.admin.photo.controllers;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import pl.jiro.persistence.model.Category;
import pl.jiro.persistence.repository.CategoryRepository;
import pl.jiro.persistence.repository.PhotoRepository;
import pl.jiro.photo.ImageUploadException;
import pl.jiro.webapp.admin.photo.PhotoForm;
import pl.jiro.webapp.admin.photo.PhotoFormConverter;
import pl.jiro.webapp.admin.photo.services.PhotoService;

/**
 * @author Łukasz Pawełczak
 */
@Controller
@SessionAttributes("sessionCid")
public class PhotoAddController {

	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private PhotoRepository photoRepository;
	
	@Autowired
	private PhotoService photoService;
	
	@Autowired
	private PhotoFormConverter photoFormConverter;
	
	
	//------------------------ LOGIC --------------------------
	
	@RequestMapping(value="/admin/addPhoto", method=RequestMethod.GET)
	public String addPhoto(@RequestParam(value="actionResponse", required=false) String res,
						Model model) {
		
		List<Category> categories = categoryRepository.findAll();
		model.addAttribute("categories", categories);
		
		model.addAttribute("sessionCid", 0);
		model.addAttribute("photoForm", new PhotoForm());
		model.addAttribute("formHeader", "add");
		model.addAttribute("message", res);
		
		return "photoAdd";
	}
	
	@RequestMapping(value="/admin/addPhoto/{categoryId}", method=RequestMethod.GET)
	public String addPhotoWithCategory(@RequestParam(value="actionResponse", required=false) String res,
			@PathVariable(value="categoryId") int categoryId,
			Model model) {
		
		List<Category> categories = categoryRepository.findAll();
		model.addAttribute("categories", categories);
		model.addAttribute("categoryId", categoryId);
		model.addAttribute("sessionCid", 0);
		model.addAttribute("photoForm", new PhotoForm());
		model.addAttribute("formHeader", "add");
		model.addAttribute("message", res);
		
		return "photoAdd";
	}
	
	@RequestMapping(value="/admin/addPhoto", method=RequestMethod.POST)
	public String addPhotoPost(@ModelAttribute @Valid PhotoForm photoForm, BindingResult bindingResult,
			@RequestParam(value="image", required=false) MultipartFile image, Model model) throws IOException {
		
		if (bindingResult.hasErrors()) {
			model.addAttribute("formHeader", "add");
            return "photoAdd";
        }
		
		try {
			photoService.add(photoFormConverter.convert(photoForm), image);
		} catch (ImageUploadException e) {
			bindingResult.reject(e.getMessage());
			model.addAttribute("formHeader", "add");
			return "photoAdd";
		}
		
		model.addAttribute("actionResponse", "addSuccess");
		
		return "redirect:/admin/addPhoto/" + photoForm.getCid();
	}
	
	@RequestMapping(value="/admin/addPhoto/{categoryId}", method=RequestMethod.POST)
	public String addPhotoWithCategoryPost(@ModelAttribute @Valid PhotoForm photoForm, BindingResult bindingResult,
			@RequestParam(value="image", required=false) MultipartFile image,
			@PathVariable(value="categoryId") int categoryId, Model model) throws IOException {
		
		if (bindingResult.hasErrors()) {
			model.addAttribute("formHeader", "add");
            return "photoAdd";
        }
		
		try {
			photoService.add(photoFormConverter.convert(photoForm), image);
		} catch (ImageUploadException e) {
			bindingResult.reject(e.getMessage());
			model.addAttribute("formHeader", "add");
			return "photoAdd";
		}
		
		model.addAttribute("actionResponse", "addSuccess");
		
		
		return "redirect:/admin/addPhoto/" + categoryId;
	}
}
