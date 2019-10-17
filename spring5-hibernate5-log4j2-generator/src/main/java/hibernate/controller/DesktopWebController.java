package hibernate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DesktopWebController {

	@RequestMapping(value = "/")
	public String mainPage() {
		return "index";
	}
	
}
