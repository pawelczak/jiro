package pl.jiro.webapp.admin.previewphoto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.jiro.persistence.model.PreviewPhoto;
import pl.jiro.persistence.repository.PreviewPhotoRepository;


/**
 * @author Łukasz Pawełczak 
 * 
 */
@Controller
public class PreviewPhotoListController {

	
	@Autowired
	private PreviewPhotoRepository previewPhotoRepository;
	
	
	//------------------------ LOGIC --------------------------
	
	@RequestMapping("/admin/previewPhoto/list")
	public String previewPhotoList(Model model) {
		
		List<PreviewPhoto> previewPhotos = previewPhotoRepository.findAll();
		
		model.addAttribute("previewPhotos", previewPhotos);
		
		return "previewPhotoList";
	}
}
