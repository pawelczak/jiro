package pl.jiro.persistence.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.jiro.persistence.model.Category;

/**
 * @author Łukasz Pawełczak
 */
@Repository
@SuppressWarnings({"unchecked", "rawtypes"})
public class CategoryRepository {

	@Autowired 
	private SessionFactory sessionFactory;
	
	
	//------------------------ LOGIC --------------------------
	
	@Transactional
	public List<Category> findAll() {
		Session session = sessionFactory.getCurrentSession();
		List categories = session.createQuery("from Category order by name ASC").list();
		return categories;
	}
	
	@Transactional
	public List<Category> findAllOrderId() {
		Session session = sessionFactory.getCurrentSession();
		List categories = session.createQuery("from Category order by id DESC").list();
		return categories;
	}
	
	@Transactional
	public List<Category> findAllOrderPopular() {
		Session session = sessionFactory.getCurrentSession();
		List categories = session.createQuery("from Category order by views DESC, id DESC").list();
		return categories;
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
	public Category findCategoryById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		return (Category) session.get(Category.class, id);
	}
	
	
	//------------------------ PRIVATE --------------------------	
	
	@SuppressWarnings("unused")
	private Session currentSession() {
		return sessionFactory.getCurrentSession();
	}
}
