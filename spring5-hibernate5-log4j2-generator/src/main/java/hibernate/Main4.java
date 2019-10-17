package hibernate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import hibernate.service.EventService;
import lombok.extern.log4j.Log4j2;

@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:context.xml")
@Log4j2
public class Main4 {

	@Autowired
	private EventService service;

	@Test
	public void test() {
		service.insert();
		log.info(service.select());
		service.delete();
	}
}
