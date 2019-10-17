package hibernate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hibernate.model.Event;
import hibernate.service.EventService;
import hibernate.support.SuccessData;


@Controller
public class ContactController  {

	@Autowired EventService service;
	
	
	@RequestMapping(value="/contact", method =  RequestMethod.GET)
	public @ResponseBody Object view(Event event){
		List<Event> contacts = service.select(event);
		Long count = service.selectCount();
		return new SuccessData(contacts,count); 
	}
	
	@RequestMapping(value="/contact", method =  RequestMethod.POST)
	public @ResponseBody Object view2(@RequestBody Event event){
		List<Event> contacts = service.select(event);
		Long count = service.selectCount();
		return new SuccessData(contacts,count); 
	}
	
	@RequestMapping(value="/contact/create")
	public @ResponseBody Object create(@RequestBody Event data){
		service.create(data);
		List<Event> contacts = service.select();
		Long count = service.selectCount();
		return new SuccessData(contacts,count); 
	}
	
	
	@RequestMapping(value="/contact/update")
	public @ResponseBody Object update(@RequestBody Event data){
		service.update(data);
		List<Event> contacts = service.select();
		return new SuccessData(contacts); 
	}
	
	@RequestMapping(value="/contact/delete")
	public @ResponseBody Object delete(@RequestBody Event data){
		service.delete(data); 
		List<Event> contacts = service.select();
		return new SuccessData(contacts); 
	}
}
