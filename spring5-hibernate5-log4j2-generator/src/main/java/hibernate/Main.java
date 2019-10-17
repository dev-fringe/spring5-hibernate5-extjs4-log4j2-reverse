package hibernate;

import java.util.Date;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import hibernate.model.Event;

public class Main {
	public static void main(String[] args) {
        Configuration config = config();
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction(); 
		session.save(new Event("Our very first event!", new Date()));
		session.save(new Event("A follow up event", new Date()));
		session.getTransaction().commit();
	}

	private static Configuration config() {
		Configuration config = new Configuration();
		Properties settings = new Properties();
		settings.put(Environment.DRIVER, "org.hsqldb.jdbc.JDBCDriver");
		settings.put(Environment.URL, "jdbc:hsqldb:hsql://localhost:9001/");
		settings.put(Environment.USER, "sa");
		settings.put(Environment.PASS, "");
		settings.put(Environment.DIALECT, "org.hibernate.dialect.HSQLDialect");
		settings.put(Environment.SHOW_SQL, "true");
		settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
		settings.put(Environment.HBM2DDL_AUTO, "create");
		config.setProperties(settings);
		config.addAnnotatedClass(Event.class);
		return config;
	}
}
