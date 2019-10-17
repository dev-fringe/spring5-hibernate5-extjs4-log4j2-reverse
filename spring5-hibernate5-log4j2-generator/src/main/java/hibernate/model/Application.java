package hibernate.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Application {
	@Value("${application.profile}")
	private String profile;
	@Value("${application.title}")
	private String title;
	
	public static final String LOCALHOST = "loc";
	public static final String DEVELOPMENT = "dev";
	public static final String STAGE = "stg";
	public static final String PRODUCTION = "prod";
}
