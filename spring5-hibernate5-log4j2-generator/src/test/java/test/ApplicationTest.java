package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.client.RestTemplate;

import dev.fringe.intergration.ws.customer.login.LoginReq;
import dev.fringe.intergration.ws.customer.login.LoginRes;
import lombok.extern.log4j.Log4j2;
import support.ScsApplicationContextInitializer;
import support.ScsSpringJUnit4ClassRunner;

@RunWith(ScsSpringJUnit4ClassRunner.class)
@ContextConfiguration( locations = "classpath:context.xml", initializers = ScsApplicationContextInitializer.class)
@Log4j2
public class ApplicationTest {
	
	@Autowired RestTemplate template;
	
	@Test
	public void dummy(){
		log.info("ok");
		LoginReq req = new LoginReq();
		req.setUsername("111");
		req.setPassword("password");
		log.info(template.postForObject("http://localhost:8080/hibernate/contact", req, LoginRes.class));
	}
}
