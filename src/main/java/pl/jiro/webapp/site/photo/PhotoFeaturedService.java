package pl.jiro.webapp.site.photo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

import pl.jiro.persistence.model.Photo;
import pl.jiro.persistence.repository.CategoryRepository;
import pl.jiro.persistence.repository.PhotoRepository;

/**
 * 
 * @author Łukasz Pawełczak
 *
 */
@Service
public class PhotoFeaturedService {

	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private PhotoRepository photoRepository;
	
	
	//------------------------ LOGIC --------------------------
	
	public List<Photo> findAll() {
		List<Photo> photos = photoRepository.findAllFeatured();
		List<Photo> featured = Lists.newArrayList();
		
		for(Photo photo: photos) {
			if (categoryRepository.findCategoryById((int)photo.getCid()).getVisible()) {
				featured.add(photo);
			}
		}
		
		return featured;
	}
}
