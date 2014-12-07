package pl.jiro.persistence.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.jiro.persistence.model.Article;

/**
 * @author Łukasz Pawełczak
 */
@Repository
@SuppressWarnings({"unchecked", "rawtypes"})
public class ArticleRepository {
	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	//------------------------ LOGIC --------------------------
	
	/**
	 * @Transactional annotation below will trigger Spring Hibernate transaction manager to automatically create
	 * a hibernate session. See src/main/webapp/WEB-INF/servlet-context.xml
	 */
	@Transactional
	public List<Article> findAll() {
		Session session = sessionFactory.getCurrentSession();
		List articles = session.createQuery("from Article").list();
		return articles;
	}
}
