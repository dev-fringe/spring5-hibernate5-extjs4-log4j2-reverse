package support;

import org.junit.runners.model.InitializationError;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jndi.JndiTemplate;
import org.springframework.mock.jndi.SimpleNamingContextBuilder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * test jndi SpringJunit
 */
public class ScsSpringJUnit4ClassRunner extends SpringJUnit4ClassRunner {
	
	private static final String JNDI_NAME_DS = "java:/111DataSource";
	
	private static final String DRIVER_NAME = "org.hsqldb.jdbc.JDBCDriver";
	
	private static final String URL = "jdbc:hsqldb:hsql://localhost:9001/";

	private static final String USER = "sa";
	
	private static final String PASSWORD = "";

	
	public ScsSpringJUnit4ClassRunner(Class<?> clazz) throws InitializationError {
		super(clazz);
		try {
			SimpleNamingContextBuilder simpleNamingContextBuilder = new SimpleNamingContextBuilder();
			simpleNamingContextBuilder.activate();
			
			DriverManagerDataSource ds = new DriverManagerDataSource();
			ds.setDriverClassName(DRIVER_NAME);
			ds.setUrl(URL);
			ds.setUsername(USER);
			ds.setPassword(PASSWORD);
			
			new JndiTemplate().bind(JNDI_NAME_DS, ds);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}


