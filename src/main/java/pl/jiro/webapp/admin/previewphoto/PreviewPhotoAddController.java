package pl.jiro.webapp.admin.previewphoto;

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

import pl.jiro.persistence.model.PreviewPhoto;
import pl.jiro.photo.ImageUploadException;
import pl.jiro.webapp.admin.previewphoto.services.PreviewPhotoService;

/**
 * @author Łukasz Pawełczak
 */
@Controller
@SessionAttributes("sessionCid")
public class PreviewPhotoAddController {

	
	@Autowired
	private PreviewPhotoService previewPhotoService;
	
	
	//------------------------ LOGIC --------------------------
	
	@RequestMapping(value="/admin/previewPhoto/add", method=RequestMethod.GET)
	public String addPhoto(@RequestParam(value="actionResponse", required=false) String res,
						Model model) {
		
		model.addAttribute("previewPhoto", new PreviewPhoto());
		model.addAttribute("message", res);
		model.addAttribute("formHeader", "add");
		
		return "previewPhotoAdd";
	}
	
	@RequestMapping(value="/admin/previewPhoto/add", method=RequestMethod.POST)
	public String addPhotoPost(@ModelAttribute @Valid PreviewPhoto previewPhoto, BindingResult bindingResult,
			@RequestParam(value="image", required=false) MultipartFile image, Model model) {
		
		
		if (bindingResult.hasErrors()) {
            return "previewPhotoAdd";
        }
		
		try {
			previewPhotoService.add(previewPhoto, image);
		} catch (ImageUploadException e) {
			bindingResult.reject(e.getMessage());
			return "previewPhotoAdd";
		}
		
		model.addAttribute("actionResponse", "addSuccess");
		model.addAttribute("formHeader", "add");
		
		return "redirect:/admin/previewPhoto/add";
	}
	
}
