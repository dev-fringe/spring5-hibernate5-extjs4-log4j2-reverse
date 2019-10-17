package hibernate.service;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import hibernate.model.User;

@Service
public class UserService {
	@Autowired private SessionFactory sessionFactory;
	
	public void save() {
		sessionFactory.getCurrentSession().save(new User("LEE", "HAKDO", "dev.fringe@gmail.com", "password"));
	}

	public User login(String email, String password) {
		return sessionFactory.getCurrentSession().createQuery("from User where id = :email and password = :password", User.class).setParameter("email", email).setParameter("password", password).uniqueResult();
	}
	
	public List<User> select(User user) {
		if( user == null) {
			user = new User();
		}
		CriteriaBuilder cb = sessionFactory.getCurrentSession().getCriteriaBuilder();
		CriteriaQuery<User> cq = cb.createQuery(User.class);
		Root<User> root = cq.from(User.class);
		if(StringUtils.isEmpty(user.getEmail()) == false) {
			Predicate predicate = cb.equal(root.get("email"), user.getEmail());
			cq.select(root).where(predicate);
		}
		Query<User> query = sessionFactory.getCurrentSession().createQuery(cq);
		query.setFirstResult(user.getFormRecord());
		query.setMaxResults(user.getSize());
		return query.list();
	}
	public Long selectCount() {
		CriteriaBuilder cb = sessionFactory.getCurrentSession().getCriteriaBuilder();
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		cq.select(cb.count(cq.from(User.class)));
		return sessionFactory.getCurrentSession().createQuery(cq).getSingleResult();
	}


}
