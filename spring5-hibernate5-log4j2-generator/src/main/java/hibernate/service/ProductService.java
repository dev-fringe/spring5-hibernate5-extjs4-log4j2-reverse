package hibernate.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hibernate.model.Category;
import hibernate.model.Product;

@Service
public class ProductService {
	@Autowired SessionFactory sessionFactory;
	@Autowired CategoryService Category;
	
	public void save() {
		Category category = Category.get(1); 
		sessionFactory.getCurrentSession().save(new Product("product","desc", category));
	}
	
	public Product get(Integer productId) {
		return sessionFactory.getCurrentSession().createQuery("from Product where productId = :id", Product.class).setParameter("id", productId).uniqueResult(); 
	}
	
	public List<Product> getByCategoryId(Category category) {
		return sessionFactory.getCurrentSession().createQuery("from Product where category = :category", Product.class).setParameter("category", category).list(); 
	}
}
