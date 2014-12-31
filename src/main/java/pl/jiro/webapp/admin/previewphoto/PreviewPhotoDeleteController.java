package pl.jiro.webapp.admin.previewphoto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pl.jiro.persistence.repository.PreviewPhotoRepository;
import pl.jiro.webapp.admin.previewphoto.services.PreviewPhotoService;

/**
 * 
 * @author Łukasz Pawełczak
 *
 */
@Controller
public class PreviewPhotoDeleteController {

	
	@Autowired
	private PreviewPhotoRepository previewPhotoRepository;
	
	@Autowired
	private PreviewPhotoService previewPhotoService;
	
	
	//------------------------ LOGIC --------------------------
	
	@RequestMapping(value="/admin/previewPhoto/delete", method=RequestMethod.POST)
	public String delete(@RequestParam long id, Model model) {
		
		previewPhotoService.delete(previewPhotoRepository.findPreviewPhotoById(id));

		model.addAttribute("actionResponse", "deleteSuccess");
		
		return "redirect:/admin/previewPhoto/list";
	}
}
