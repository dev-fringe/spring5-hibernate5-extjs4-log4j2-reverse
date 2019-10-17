package hibernate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MobileWebController {

	@RequestMapping(value = "/mobile")
	public String mobile() {
		return "mobile";
	}
	
}
