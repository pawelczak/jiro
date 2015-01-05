package pl.jiro.webapp.admin.category;

import org.springframework.stereotype.Service;

import pl.jiro.persistence.model.Category;


/**
 * 
 * @author Łukasz Pawełczak
 *
 */
@Service
public class CategoryFormConverter {

	
	//------------------------ LOGIC --------------------------
	
	public Category convert(CategoryForm categoryForm) {
		
		Category category = new Category();
		
		category.setId(categoryForm.getId());
		category.setName(categoryForm.getName());
		category.setDescription(categoryForm.getDescription());
		category.setVisible(categoryForm.getVisible());
		
		return category;
	}
	
	public CategoryForm convert(Category category) {
		
		CategoryForm categoryForm = new CategoryForm();
		
		categoryForm.setId(category.getId());
		categoryForm.setName(category.getName());
		categoryForm.setDescription(category.getDescription());
		categoryForm.setVisible(category.getVisible());
		
		return categoryForm;
	}
}
