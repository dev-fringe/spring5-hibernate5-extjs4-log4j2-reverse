package support;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.env.AbstractEnvironment;

import hibernate.model.Application;

public class ScsApplicationContextInitializer implements ApplicationContextInitializer<GenericApplicationContext> {

	public void initialize(GenericApplicationContext context) {
		if(System.getProperty("spring.profiles.active") != null){
			context.getEnvironment().getSystemProperties().put(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, System.getProperty("spring.profiles.active"));
		}else{
			context.getEnvironment().getSystemProperties().put(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, Application.LOCALHOST);
		}
	}
}