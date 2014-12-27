package pl.jiro.webapp.admin.category;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pl.jiro.persistence.model.Category;
import pl.jiro.persistence.model.Photo;
import pl.jiro.persistence.repository.CategoryRepository;
import pl.jiro.persistence.repository.PhotoRepository;

/**
 * @author Łukasz Pawełczak
 */
@Controller
public class CategoryDeleteController {
	
	@Value("${jiro.photo.path}")
	private String webContext;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private PhotoRepository photoRepository;
	
	
	//------------------------ LOGIC --------------------------
	
	@RequestMapping(value="/admin/deleteCategory", method=RequestMethod.POST)
	public String deleteCategory(@RequestParam Integer id, Model model) {
		
		Category category = categoryRepository.findCategoryById(id);
		List<Photo> photos = photoRepository.findByCategoryId(id);
		
		categoryRepository.deleteCategory(category);
		photoRepository.deletePhotosInCategory(String.valueOf(id));
		
		for(Photo photo : photos) {
			deleteImage(getImagePath(photo.getId()));
		}
		
		model.addAttribute("actionResponse", "deleteSuccess");
		
		return "redirect:/admin/categoryList";
	}

	//------------------------ PRIVATE --------------------------
	
	private String getImagePath(long id) {
		return webContext + id + ".jpg";
	}
	
	private void deleteImage(String filename) {
		try {
			 
    		File file = new File(filename);
 
    		if(file.delete()){
    			System.out.println(file.getName() + " is deleted!");
    		} else {
    			System.out.println("Delete operation is failed.");
    		}
    	} catch(Exception e){
    		e.printStackTrace();
    	}
	}
}
