package pl.jiro.webapp.gallery;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

import pl.jiro.persistence.model.Category;
import pl.jiro.persistence.model.Photo;
import pl.jiro.persistence.repository.CategoryRepository;
import pl.jiro.persistence.repository.PhotoRepository;

/**
 * @author Łukasz Pawełczak
 */
@Service
public class GalleryListService {

	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private PhotoRepository photoRepository;
	
	//------------------------ LOGIC --------------------------
	
	public List<Gallery> listAllGalleries() {
		return convertCategoriesToGalleries(categoryRepository.findAll());
	}
	
	public List<Gallery> findThreeLastAdded() {
		return convertCategoriesToGalleries(categoryRepository.findAllOrderId().subList(0, 3));
	}
	
	public List<Gallery> findMostPopular() {
		return convertCategoriesToGalleries(categoryRepository.findAllOrderPopular().subList(0, 3));
	}
	
	//------------------------ PRIVATE --------------------------
	
	private List<Gallery> convertCategoriesToGalleries(List<Category> categories) {
		List<Gallery> galleries = Lists.newArrayList();
		
		for (Category category : categories) {
			List<Photo> photos = photoRepository.findVisibleByCategoryId(category.getId());
			
			if (photos.size() > 0) {
				galleries.add(new Gallery(category, photos.get(0)));
			} else {
				galleries.add(new Gallery(category, new Photo()));
			}			
		}
		
		return galleries;
	}
}
