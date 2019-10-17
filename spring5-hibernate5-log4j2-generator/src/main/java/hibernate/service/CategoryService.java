package hibernate.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hibernate.model.Category;

@Service
public class CategoryService {
	@Autowired SessionFactory sessionFactory;
	public void save() {
		sessionFactory.getCurrentSession().save(new Category("cate","desc"));
	}
	public Category get(Integer id) {
		return sessionFactory.getCurrentSession().createQuery("from Category where id = :id", Category.class).setParameter("id", id).uniqueResult(); 
	}
	public List<Category> list() {
		return sessionFactory.getCurrentSession().createQuery("from Category", Category.class).list();
	}
}
