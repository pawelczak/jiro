package pl.jiro.photo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@SuppressWarnings({"unchecked", "rawtypes"})
public class CategoryDAO {
	@Autowired private SessionFactory sessionFactory;
	

	@Transactional
	public List<Category> findAll() {
		Session session = sessionFactory.getCurrentSession();
		List categories = session.createQuery("from Category").list();
		return categories;
	}
	
	@SuppressWarnings("unused")
	private Session currentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Transactional
	public void addCategory(Category category) {
		Session session = sessionFactory.getCurrentSession();
		session.save(category);
	}
	
	@Transactional
	public void deleteCategory(Category category) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(category);
	}
	
	@Transactional
	public void editCategory(Category category) {
		Session session = sessionFactory.getCurrentSession();
		session.update(category);
	}
	
	@Transactional
	public Category getCategoryById(long id) {
		Session session = sessionFactory.getCurrentSession();
		return (Category) session.get(Category.class, id);
	}
}