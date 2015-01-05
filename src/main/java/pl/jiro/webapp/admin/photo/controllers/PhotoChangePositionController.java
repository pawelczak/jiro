package pl.jiro.webapp.admin.photo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.jiro.persistence.model.Photo;
import pl.jiro.persistence.repository.PhotoRepository;
import pl.jiro.webapp.admin.photo.services.PhotoService;

/**
 * @author Łukasz Pawełczak
 */
@Controller
public class PhotoChangePositionController {

	
	@Autowired
	private PhotoRepository photoRepository;
	
	@Autowired
	private PhotoService photoService;
	
	//------------------------ LOGIC --------------------------
	
	@RequestMapping("/admin/photo/changePosition")
	public String featurePhoto(@RequestParam long firstId, @RequestParam long secondId, Model model) {
		Photo firstPhoto = photoRepository.findPhotoById(firstId);
		Photo secondPhoto = photoRepository.findPhotoById(secondId);
		
		photoService.switchPosition(firstPhoto, secondPhoto);
		
		return "redirect:/admin/photoList/" + String.valueOf(firstPhoto.getCid());
	}
}
