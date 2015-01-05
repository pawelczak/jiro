package pl.jiro.webapp.admin.category.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.jiro.persistence.model.Category;
import pl.jiro.persistence.repository.CategoryRepository;
import pl.jiro.webapp.admin.photo.services.PhotoService;

/**
 * @author Łukasz Pawełczak
 */
@Service
public class CategoryService {

	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private PhotoService photoDeleteService;
	

	//------------------------ LOGIC --------------------------
	
	public void delete(int id) {
		Category category = categoryRepository.findCategoryById(id);
		categoryRepository.deleteCategory(category);
		photoDeleteService.deleteAllByCategoryId(category.getId());
	}
	
	public void changeVisible(int id, boolean visible) {
		Category category = categoryRepository.findCategoryById((int)id);
		category.setVisible(visible);
		categoryRepository.editCategory(category);
	}
}
