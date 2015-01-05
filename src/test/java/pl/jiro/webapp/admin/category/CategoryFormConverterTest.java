package pl.jiro.webapp.admin.category;

import static org.junit.Assert.*;

import org.junit.Test;

import pl.jiro.persistence.model.Category;

public class CategoryFormConverterTest {

	
	private CategoryFormConverter categoryFormConverter = new CategoryFormConverter();
	
	
	//------------------------ TESTS --------------------------
	
	@Test
	public void convertFromCategory() {
		//given
		Category expected = new Category();
		
		expected.setId(1);
		expected.setName("Tatry");
		expected.setDescription("Opis tatr.");
		expected.setVisible(false);
		
		
		//when
		CategoryForm actual = categoryFormConverter.convert(expected);
		
		
		//then
		assertEquals(expected.getId(), actual.getId());
		assertEquals(expected.getName(), actual.getName());
		assertEquals(expected.getDescription(), actual.getDescription());
		assertEquals(expected.getVisible(), actual.getVisible());
	}
	
	@Test
	public void convertFromCategoryForm() {
		//given
		CategoryForm expected = new CategoryForm();
		
		expected.setId(1);
		expected.setName("Tatry");
		expected.setDescription("Opis tatr.");
		expected.setVisible(false);
		
		
		//when
		Category actual = categoryFormConverter.convert(expected);
		
		
		//then
		assertEquals(expected.getId(), actual.getId());
		assertEquals(expected.getName(), actual.getName());
		assertEquals(expected.getDescription(), actual.getDescription());
		assertEquals(expected.getVisible(), actual.getVisible());
	}
}
