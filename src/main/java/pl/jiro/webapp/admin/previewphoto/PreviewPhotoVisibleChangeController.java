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
public class PreviewPhotoVisibleChangeController {

	
	@Autowired
	private PreviewPhotoRepository previewPhotoRepository;
	
	@Autowired
	private PreviewPhotoService previewPhotoService;
	
	
	//------------------------ LOGIC --------------------------
	
	@RequestMapping("/admin/previewPhoto/visibleChange")
	public String visilePhoto(@RequestParam long id, @RequestParam boolean visibility, Model model) {
		PreviewPhoto previewPhoto = previewPhotoRepository.findPreviewPhotoById(id);
		
		previewPhotoService.setVisibility(previewPhoto, visibility);

		return "redirect:/admin/previewPhoto/list";
	}
}
