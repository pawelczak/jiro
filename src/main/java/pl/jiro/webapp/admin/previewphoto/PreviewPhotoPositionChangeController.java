package pl.jiro.webapp.admin.previewphoto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.jiro.persistence.model.PreviewPhoto;
import pl.jiro.persistence.repository.PreviewPhotoRepository;
import pl.jiro.webapp.admin.previewphoto.services.PreviewPhotoService;

/**
 * @author Łukasz Pawełczak
 */
@Controller
public class PreviewPhotoPositionChangeController {

	
	@Autowired
	private PreviewPhotoRepository previewPhotoRepository;
	
	@Autowired
	private PreviewPhotoService previewPhotoService;
	
	//------------------------ LOGIC --------------------------
	
	@RequestMapping("/admin/previewPhoto/changePosition")
	public String featurePhoto(@RequestParam long firstId, @RequestParam long secondId, Model model) {
		PreviewPhoto firstPhoto = previewPhotoRepository.findPreviewPhotoById(firstId);
		PreviewPhoto secondPhoto = previewPhotoRepository.findPreviewPhotoById(secondId);
		
		previewPhotoService.switchPosition(firstPhoto, secondPhoto);
		
		return "redirect:/admin/previewPhoto/list";
	}
}
