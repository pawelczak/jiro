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
import org.springframework.web.multipart.MultipartFile;

import pl.jiro.persistence.model.PreviewPhoto;
import pl.jiro.persistence.repository.PreviewPhotoRepository;
import pl.jiro.webapp.admin.previewphoto.services.PreviewPhotoService;

/**
 * @author Łukasz Pawełczak
 */
@Controller
public class PreviewPhotoEditController {

	
	@Autowired
	private PreviewPhotoRepository previewPhotoRepository;
	
	@Autowired
	private PreviewPhotoService previewPhotoService;
	
	
	//------------------------ LOGIC --------------------------
	
	@RequestMapping(value="/admin/previewPhoto/edit", method=RequestMethod.GET)
	public String editPhoto(@RequestParam long id, Model model) {
		PreviewPhoto previewPhoto = previewPhotoRepository.findPreviewPhotoById(id);
		
		model.addAttribute("formHeader", "edit");
		model.addAttribute("previewPhoto", previewPhoto);
		model.addAttribute("previewPhotoSrc", previewPhoto.getSrc());
		
		return "previewPhotoAdd";
	}
	
	@RequestMapping(value="/admin/previewPhoto/edit", method=RequestMethod.POST)
	public String editPhotoPost(@ModelAttribute @Valid PreviewPhoto previewPhoto, 
			@RequestParam(value="image", required=false) MultipartFile image,
			@RequestParam(value="image_uploaded", required=false) String imageUploaded,
			BindingResult bindingResult, Model model) {
		
		
		if (bindingResult.hasErrors()) {
			model.addAttribute("formHeader", "edit");
            return "previewPhotoAdd";
        }		
		
		previewPhotoService.edit(previewPhoto, image, imageUploaded);
		
		model.addAttribute("actionResponse", "editSuccess");
		
		return "redirect:/admin/previewPhoto/list";
	}
}
