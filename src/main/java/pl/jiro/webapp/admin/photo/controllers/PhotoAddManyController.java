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

import pl.jiro.persistence.model.Category;
import pl.jiro.persistence.repository.CategoryRepository;
import pl.jiro.persistence.repository.PhotoRepository;
import pl.jiro.photo.ImageUploadException;
import pl.jiro.webapp.admin.photo.PhotoManyFilesForm;
import pl.jiro.webapp.admin.photo.PhotoManyFilesFormConverter;
import pl.jiro.webapp.admin.photo.PhotoWithImage;
import pl.jiro.webapp.admin.photo.services.PhotoService;

/**
 * @author Łukasz Pawełczak
 */
@Controller
@SessionAttributes("sessionCid")
public class PhotoAddManyController {

	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private PhotoRepository photoRepository;
	
	@Autowired
	private PhotoService photoService;
	
	@Autowired
	private PhotoManyFilesFormConverter photoManyFilesFormConverter;

	
	//------------------------ LOGIC --------------------------
	
	@RequestMapping(value="/admin/addManyPhoto", method=RequestMethod.GET)
	public String addPhoto(@RequestParam(value="actionResponse", required=false) String res,
						Model model) {
		
		List<Category> categories = categoryRepository.findAll();
		model.addAttribute("categories", categories);
		
		model.addAttribute("sessionCid", 0);
		model.addAttribute("photoForm", new PhotoManyFilesForm());
		model.addAttribute("formHeader", "add");
		model.addAttribute("message", res);
		
		return "photoAddMany";
	}
	
	@RequestMapping(value="/admin/addManyPhoto/{categoryId}", method=RequestMethod.GET)
	public String addPhotoWithCategory(@RequestParam(value="actionResponse", required=false) String res,
			@PathVariable(value="categoryId") int categoryId,
			Model model) {
		
		List<Category> categories = categoryRepository.findAll();
		model.addAttribute("categories", categories);
		model.addAttribute("categoryId", categoryId);
		model.addAttribute("sessionCid", 0);
		model.addAttribute("photoForm", new PhotoManyFilesForm());
		model.addAttribute("formHeader", "add");
		model.addAttribute("message", res);
		
		return "photoAddMany";
	}
	
	@RequestMapping(value="/admin/addManyPhoto", method=RequestMethod.POST)
	public String addPhotoPost(@ModelAttribute @Valid PhotoManyFilesForm photoManyFilesForm, BindingResult bindingResult,
			Model model) throws IOException {
		
		if (bindingResult.hasErrors()) {
			model.addAttribute("formHeader", "add");
            return "photoAdd";
        }
		
		try {
			
			addPhotos(photoManyFilesForm);
			
		} catch (ImageUploadException e) {
			bindingResult.reject(e.getMessage());
			model.addAttribute("formHeader", "add");
			return "photoAdd";
		}
		
		model.addAttribute("actionResponse", "addSuccess");
		
		return "redirect:/admin/photoList/" + photoManyFilesForm.getCid();
	}
	
	@RequestMapping(value="/admin/addManyPhoto/{categoryId}", method=RequestMethod.POST)
	public String addPhotoWithCategoryPost(@ModelAttribute @Valid PhotoManyFilesForm photoManyFilesForm, BindingResult bindingResult,
			@PathVariable(value="categoryId") int categoryId, Model model) throws IOException {
		
		if (bindingResult.hasErrors()) {
			model.addAttribute("formHeader", "add");
            return "photoAdd";
        }
		
		try {
			
			addPhotos(photoManyFilesForm);
			
		} catch (ImageUploadException e) {
			bindingResult.reject(e.getMessage());
			model.addAttribute("formHeader", "add");
			return "photoAdd";
		}
		
		model.addAttribute("actionResponse", "addSuccess");
		
		
		return "redirect:/admin/photoList/" + categoryId;
	}
	
	
	//------------------------ PRIVATE --------------------------
	
	private void addPhotos(PhotoManyFilesForm photoForm) throws IOException {
		
		List<PhotoWithImage> photoWithImages = photoManyFilesFormConverter.convert(photoForm);
		
		for (PhotoWithImage photoWithImage : photoWithImages) {
			photoService.add(photoWithImage.getPhoto(), photoWithImage.getImage());
		}
	}
}
