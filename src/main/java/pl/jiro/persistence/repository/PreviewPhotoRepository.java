package pl.jiro.persistence.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.jiro.persistence.model.PreviewPhoto;

/**
 * @author Łukasz Pawełczak
 */
@Repository
@SuppressWarnings({"unchecked", "rawtypes"})
public class PreviewPhotoRepository {

	@Autowired 
	private SessionFactory sessionFactory;
	
	
	//------------------------ LOGIC --------------------------
	
	@Transactional
	public List<PreviewPhoto> findAll() {
		Session session = sessionFactory.getCurrentSession();
		List photos = session.createQuery("from PreviewPhoto order by position").list();
		return photos;
	}
	
	@Transactional
	public List<PreviewPhoto> findAllVisible() {
		Session session = sessionFactory.getCurrentSession();
		List photos = session.createQuery("from PreviewPhoto where visible = 1 order by position").list();
		return photos;
	}
	
	@Transactional
	public PreviewPhoto findPreviewPhotoById(long id) {
		Session session = sessionFactory.getCurrentSession();
		return (PreviewPhoto) session.get(PreviewPhoto.class, id);
	}
	
	@Transactional
	public void add(PreviewPhoto previewPhoto) {
		Session session = sessionFactory.getCurrentSession();
		session.save(previewPhoto);
	}
	
	@Transactional
	public void edit(PreviewPhoto previewPhoto) {
		Session session = sessionFactory.getCurrentSession();
		session.update(previewPhoto);
	}
	
	@Transactional
	public void delete(PreviewPhoto previewPhoto) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(previewPhoto);
	}
}
