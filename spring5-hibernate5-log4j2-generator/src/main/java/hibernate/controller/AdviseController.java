package hibernate.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class AdviseController {

	@ModelAttribute("request")
	public Object layout(Map<String, Object> model, HttpServletRequest request) {
		String path = request.getContextPath();
		model.put("path", path);
		return model;
	}
}
