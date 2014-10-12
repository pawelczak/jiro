package pl.jiro.gallery;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.jiro.photo.Category;
import pl.jiro.photo.CategoryDAO;
import pl.jiro.photo.Photo;
import pl.jiro.photo.PhotoDAO;

@Controller
public class GalleryController {
	@Autowired private CategoryDAO categoryDAO;
	@Autowired private PhotoDAO photoDAO;
	
	@RequestMapping("/gallery")
	public String simpleGallery(ModelMap model) {
		List<Category> categories = categoryDAO.findAll();
		model.addAttribute("categories", categories);
		
		List<Gallery> galleries = new ArrayList<Gallery>();
		
		for(Category category: categories) {
			List<Photo> photos = photoDAO.findVisibleByCategoryId(Long.toString(category.getId()));
			Photo photo;
			
			if (photos.size() > 0) {
				photo = photos.get(0);
			} else {
				photo = new Photo();
			}
			
			galleries.add(new Gallery(category, photo));			
		}
		
		model.addAttribute("galleries", galleries);
		
		return "gallery";
	}
	
	@RequestMapping("/gallery/{categoryId}")
	public String singleGallery(@PathVariable String categoryId, Model model) {
		
		Category category = categoryDAO.getCategoryById(Long.valueOf(categoryId).longValue());
		List<Photo> photos = photoDAO.findVisibleByCategoryId(categoryId);
		
		model.addAttribute("category", category);
		model.addAttribute("photos", photos);
		
		return "singleGallery";
	}
	
	@RequestMapping("/featured")
	public String featured(Model model) {
		List<Photo> photos = photoDAO.findAllFeatured();
		
		model.addAttribute("photos", photos);
		return "featured";
	}
	
	
}