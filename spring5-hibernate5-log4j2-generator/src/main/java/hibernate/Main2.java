package hibernate;

import java.awt.Desktop;
import java.net.URI;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import hibernate.model.Event;

@Configuration
@ImportResource("classpath:context.xml")
@SuppressWarnings("resource")
public class Main2 implements InitializingBean {
	@Autowired SessionFactory sessionFactory;
	public static void main(String[] args) {
		new AnnotationConfigApplicationContext(Main2.class).getBean(Main2.class);
	}

	public void afterPropertiesSet() throws Exception {
		URI uri = new URI("http://localhost:8080/hibernate/");
		Desktop desktop =  Desktop.getDesktop();
		desktop.browse(uri);
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(new Event("Our very first event!", new Date()));
		session.save(new Event("A follow up event", new Date()));
		session.getTransaction().commit();
	}
}
