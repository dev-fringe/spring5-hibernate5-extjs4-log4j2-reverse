package hibernate.service;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hibernate.model.Supplier;

@Service
public class SupplierService {
	@Autowired SessionFactory sessionFactory;
	public void save() {
		sessionFactory.getCurrentSession().save(new Supplier("supplier"));
	}
	
	public Supplier get(Long suppid) {
		return sessionFactory.getCurrentSession().createQuery("from Supplier where suppid = :id", Supplier.class).setParameter("id", suppid).uniqueResult(); 
	}
}
