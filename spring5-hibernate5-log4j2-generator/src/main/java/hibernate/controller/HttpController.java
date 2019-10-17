package hibernate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hibernate.model.HttpRestLog;
import hibernate.service.HttpService;
import hibernate.support.SuccessData;


@Controller
public class HttpController  {

	@Autowired HttpService service;
	
	@RequestMapping(value="/http", method =  RequestMethod.GET)
	public @ResponseBody Object view(HttpRestLog http){
		List<HttpRestLog> contacts = service.select(http);
		Long count = service.selectCount();
		return new SuccessData(contacts,count); 
	}
}
