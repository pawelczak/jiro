package pl.jiro.photo;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@SuppressWarnings({"unchecked", "rawtypes"})
public class PhotoDAO {
	@Autowired private SessionFactory sessionFactory;
	

	@Transactional
	public List<Photo> findAll() {
		Session session = sessionFactory.getCurrentSession();
		List photos = session.createQuery("from Photo").list();
		return photos;
	}
	
	@Transactional
	public List<Photo> findAllVisible() {
		Session session = sessionFactory.getCurrentSession();
		List photos = session.createQuery("from Photo where visible = 1").list();
		return photos;
	}
	
	@Transactional
	public List<Photo> findAllFeatured() {
		Session session = sessionFactory.getCurrentSession();
		List photos = session.createQuery("from Photo where featured = 1").list();
		return photos;
	}
	
	@Transactional
	public List<Photo> findByCategoryId(String id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Photo where cid = :categoryId");
		query.setParameter("categoryId", Long.parseLong(id));
		List photos = query.list();
		return photos;
	}
	
	@Transactional
	public List<Photo> findVisibleByCategoryId(String id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Photo where cid = :categoryId and visible = 1");
		query.setParameter("categoryId", Long.parseLong(id));
		List photos = query.list();
		return photos;
	}
	
	@Transactional
	public void addPhoto(Photo photo) {
		Session session = sessionFactory.getCurrentSession();
		session.save(photo);
	}
	
	@Transactional
	public void deletePhoto(Photo photo) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(photo);
	}
	
	@Transactional
	public void deletePhotosInCategory(String id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Photo where cid = :categoryId");
		query.setParameter("categoryId", Long.parseLong(id));
		List<Photo> photos = query.list();
		
		for(Photo photo: photos) {
			session.delete(photo);
		}
		
	}
	
	@Transactional
	public void editPhoto(Photo photo) {
		Session session = sessionFactory.getCurrentSession();
		session.update(photo);
	}
	
	@Transactional
	public Photo getPhotoById(long id) {
		Session session = sessionFactory.getCurrentSession();
		return (Photo) session.get(Photo.class, id);
	}
}