package pl.jiro.webapp.admin.photo;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
import pl.jiro.persistence.model.Photo;
import pl.jiro.persistence.repository.CategoryRepository;
import pl.jiro.persistence.repository.PhotoRepository;
import pl.jiro.photo.ImageUploadException;

/**
 * @author Łukasz Pawełczak
 */
@Controller
@SessionAttributes("sessionCid")
public class PhotoAddController {

	@Value("${jiro.photo.path}")
	private String webContext;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private PhotoRepository photoRepository;
	
	
	//------------------------ LOGIC --------------------------
	
	@RequestMapping(value="/admin/addPhoto", method=RequestMethod.GET)
	public String addPhoto(@RequestParam(value="actionResponse", required=false) String res,
						Model model) {
		
		List<Category> categories = categoryRepository.findAll();
		model.addAttribute("categories", categories);
		
		model.addAttribute("sessionCid", 0);
		model.addAttribute("photo", new Photo());
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
		model.addAttribute("photo", new Photo());
		model.addAttribute("formHeader", "add");
		model.addAttribute("message", res);
		
		return "photoAdd";
	}
	
	@RequestMapping(value="/admin/addPhoto", method=RequestMethod.POST)
	public String addPhotoPost(@ModelAttribute @Valid Photo photo, BindingResult bindingResult,
			@RequestParam(value="image", required=false) MultipartFile image, Model model) {
		
		if (bindingResult.hasErrors()) {
			model.addAttribute("formHeader", "add");
            return "photoAdd";
        }
		
		photo.setSrc(" ");
		photoRepository.addPhoto(photo);
		
		try {
			if (!image.isEmpty()) {
				validateImage(image);
				saveImage(webContext + photo.getId() + ".jpg", image);
				photo.setSrc(photo.getId() + ".jpg");
			}
		} catch (ImageUploadException e) {
			bindingResult.reject(e.getMessage());
			model.addAttribute("formHeader", "add");
			return "photoAdd";
		}
		
		photoRepository.editPhoto(photo);
		
		model.addAttribute("actionResponse", "addSuccess");
		
		return "redirect:/admin/addPhoto/" + photo.getCid();
	}
	
	@RequestMapping(value="/admin/addPhoto/{categoryId}", method=RequestMethod.POST)
	public String addPhotoWithCategoryPost(@ModelAttribute @Valid Photo photo, BindingResult bindingResult,
			@RequestParam(value="image", required=false) MultipartFile image,
			@PathVariable(value="categoryId") int categoryId, Model model) {
		
		if (bindingResult.hasErrors()) {
			model.addAttribute("formHeader", "add");
            return "photoAdd";
        }
		
		photo.setSrc(" ");
		photoRepository.addPhoto(photo);
		
		try {
			if (!image.isEmpty()) {
				validateImage(image);
				saveImage(webContext + photo.getId() + ".jpg", image);
				photo.setSrc(photo.getId() + ".jpg");
			}
		} catch (ImageUploadException e) {
			bindingResult.reject(e.getMessage());
			model.addAttribute("formHeader", "add");
			return "photoAdd";
		}
		
		photoRepository.editPhoto(photo);
		
		model.addAttribute("actionResponse", "addSuccess");
		
		return "redirect:/admin/addPhoto/" + categoryId;
	}
	
	
	//------------------------ PRIVATE --------------------------

	private void validateImage(MultipartFile image) {
		if (!image.getContentType().equals("image/jpeg")) {
			throw new ImageUploadException("Nieakceptowane pliki jpeg");
		}
	}
	
	private void saveImage(String filename, MultipartFile image) throws ImageUploadException {
		try {
			File file = new File (filename);
			FileUtils.writeByteArrayToFile(file, image.getBytes());
		} catch(IOException e) {
			throw new ImageUploadException("photo.upload.fail");
		}
		
	}
}
