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
		return convertCategoriesToGalleries(categoryRepository.findAllVisible());
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
			galleries.add(new Gallery(category, findFrontPhoto(category.getId())));
		}
		
		return galleries;
	}
	
	private Photo findFrontPhoto(int galleryId) {
		
		List<Photo> frontPhotos = photoRepository.findFrontByCategoryId(galleryId);
		
		if (frontPhotos.size() == 0) {
			List<Photo> photos = photoRepository.findVisibleByCategoryId(galleryId);
			
			if (photos.size() > 0) {
				return photos.get(0);
			} else {
				return new Photo();
			}
		} else {
			return frontPhotos.get(0);
		}
	}
}
