package hibernate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hibernate.model.User;
import hibernate.service.UserService;
import hibernate.support.SuccessData;


@Controller
public class UserController  {

	@Autowired UserService service;
	
	
	@RequestMapping(value="/user", method =  RequestMethod.GET)
	public @ResponseBody Object view(User user){
		List<User> contacts = service.select(user);
		Long count = service.selectCount();
		return new SuccessData(contacts,count); 
	}
}
