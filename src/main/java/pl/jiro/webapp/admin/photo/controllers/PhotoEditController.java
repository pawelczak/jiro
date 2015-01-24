package pl.jiro.webapp.admin.photo.controllers;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import pl.jiro.persistence.model.Category;
import pl.jiro.persistence.model.Photo;
import pl.jiro.persistence.repository.CategoryRepository;
import pl.jiro.persistence.repository.PhotoRepository;
import pl.jiro.webapp.admin.photo.PhotoForm;
import pl.jiro.webapp.admin.photo.PhotoFormConverter;
import pl.jiro.webapp.admin.photo.services.PhotoService;


/**
 * @author Łukasz Pawełczak
 */
@Controller
@SessionAttributes("sessionCid")
public class PhotoEditController {

	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private PhotoRepository photoRepository;
	
	@Autowired
	private PhotoService photoService;
	
	@Autowired
	private PhotoFormConverter photoFormConverter;
	
	
	//------------------------ LOGIC --------------------------
	
	@RequestMapping(value="/admin/editPhoto", method=RequestMethod.GET)
	public String editPhoto(@RequestParam long id, @RequestParam long categoryId, Model model) {
		List<Category> categories = categoryRepository.findAll();
		Photo photo = photoRepository.findPhotoById(id);
		
		model.addAttribute("categories", categories);
		model.addAttribute("categoryId", categoryId);
		model.addAttribute("formHeader", "edit");
		model.addAttribute("photoForm", photoFormConverter.convert(photo));
		model.addAttribute("photoSrc", photo.getSrc());
		
		return "photoAdd";
	}
	
	@RequestMapping(value="/admin/editPhoto", method=RequestMethod.POST)
	public String editPhotoPost(@ModelAttribute @Valid PhotoForm photoForm, 
			@RequestParam(value="image", required=false) MultipartFile image,
			@RequestParam(value="image_uploaded", required=false) String imageUploaded,
			BindingResult bindingResult, Model model) throws IOException {
		
		
		if (bindingResult.hasErrors()) {
			model.addAttribute("formHeader", "edit");
            return "photoAdd";
        }		
		
		photoService.edit(photoFormConverter.convert(photoForm), image, imageUploaded);
		
		model.addAttribute("actionResponse", "editSuccess");
		
		return "redirect:/admin/photoList/" + photoForm.getCid();
	}
}
