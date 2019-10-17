package hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import hibernate.model.Event;

@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:context.xml")
public class Main3 {
	@Autowired SessionFactory sessionFactory;
	 
	@Test
	public void test(){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.persist(new Event("Our very first event!", new Date()));
		session.persist(new Event("A follow up event", new Date()));
		session.getTransaction().commit();
	}
}
