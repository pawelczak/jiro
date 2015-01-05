package pl.jiro.webapp.admin.photo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import pl.jiro.persistence.model.Photo;
import pl.jiro.persistence.repository.PhotoRepository;
import pl.jiro.webapp.admin.photo.services.PhotoService;

/**
 * @author Łukasz Pawełczak
 */
@Controller
@SessionAttributes("sessionCid")
public class PhotoDeleteController {
	
	
	@Autowired
	private PhotoRepository photoRepository;
	
	@Autowired
	private PhotoService photoService;
	
	
	//------------------------ LOGIC --------------------------
	
	@RequestMapping(value="/admin/deletePhoto", method=RequestMethod.POST)
	public String deletePhoto(@RequestParam long id, Model model) {
		Photo photo = photoRepository.findPhotoById(id);
		
		photoService.delete(photo);

		model.addAttribute("actionResponse", "deleteSuccess");
		
		return "redirect:/admin/photoList/" + String.valueOf(photo.getCid());
	}
}
