package hibernate.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hibernate.model.Item;
import hibernate.model.Product;
import hibernate.model.Supplier;

@Service
public class ItemService {

	@Autowired SessionFactory sessionFactory;
	@Autowired ProductService productService;
	@Autowired SupplierService supplierService;
	
	@SuppressWarnings("deprecation")
	public void save() {
		Product product = productService.get(1); 
		Supplier supplier = supplierService.get(new Long(1));
		sessionFactory.getCurrentSession().save(new Item("name","desc", product, supplier));
	}
	public Item get(Integer itemId) {
		return sessionFactory.getCurrentSession().createQuery("from Item where itemId = :itemId", Item.class).setParameter("itemId", itemId).uniqueResult(); 
	}
	public List<Item> getByProductId(Product product) {
		return sessionFactory.getCurrentSession().createQuery("from Item where product = :product", Item.class).setParameter("product", product).list(); 
	}
	public List<Item> getByItemname(String itemname) {
		return sessionFactory.getCurrentSession().createQuery("from Item where itemname like :itemname", Item.class).setParameter("itemname", "%" + itemname + "%").list();
	}
}
