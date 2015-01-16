package pl.jiro.webapp.site.gallery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.jiro.persistence.model.Category;
import pl.jiro.persistence.repository.CategoryRepository;

/**
 * 
 * @author Łukasz Pawełczak
 *
 */
@Service
public class GalleryVoteService {

	
	@Autowired
	private CategoryRepository categoryRepository;
	
	//------------------------ LOGIC --------------------------
	
	public void voteUp(Integer id) {
		
		Category category = categoryRepository.findCategoryById(id);
		
		category.setViews(category.getViews() + 1);
		
		categoryRepository.editCategory(category);
	}
}
