package pl.jiro.webapp.admin.photo;

import static org.junit.Assert.*;

import org.junit.Test;

import pl.jiro.persistence.model.Photo;

public class PhotoFormConverterTest {

	
	private PhotoFormConverter photoFormConverter = new PhotoFormConverter();
	
	
	//------------------------ TESTS --------------------------
	
	@Test
	public void convertFromPhoto() {
		//given
		Photo expected = new Photo();
		
		expected.setId(2);
		expected.setCid(13);
		expected.setTitle("Tytul");
		expected.setSrc("/home/user/desktop/etc");
		expected.setFeatured(true);
		expected.setVisible(false);
		expected.setPosition(1);
		expected.setDescription("Opis");
		
		//when
		PhotoForm actual = photoFormConverter.convert(expected);
		
		//then
		assertEquals(expected.getId(), actual.getId());
		assertEquals(expected.getCid(), actual.getCid());
		assertEquals(expected.getTitle(), actual.getTitle());
		assertEquals(expected.getSrc(), actual.getSrc());
		assertEquals(expected.getFeatured(), actual.getFeatured());
		assertEquals(expected.getVisible(), actual.getVisible());
		assertEquals(expected.getPosition(), actual.getPosition());
		assertEquals(expected.getDescription(), actual.getDescription());
	}

	@Test
	public void convertFromPhotoForm() {
		//given
		PhotoForm expected = new PhotoForm();
		
		expected.setId(2);
		expected.setCid(13);
		expected.setTitle("Tytul");
		expected.setSrc("/home/user/desktop/etc");
		expected.setFeatured(true);
		expected.setVisible(false);
		expected.setPosition(1);
		expected.setDescription("Opis");
		
		//when
		Photo actual = photoFormConverter.convert(expected);
		
		//then
		assertEquals(expected.getId(), actual.getId());
		assertEquals(expected.getCid(), actual.getCid());
		assertEquals(expected.getTitle(), actual.getTitle());
		assertEquals(expected.getSrc(), actual.getSrc());
		assertEquals(expected.getFeatured(), actual.getFeatured());
		assertEquals(expected.getVisible(), actual.getVisible());
		assertEquals(expected.getPosition(), actual.getPosition());
		assertEquals(expected.getDescription(), actual.getDescription());
	}
}
