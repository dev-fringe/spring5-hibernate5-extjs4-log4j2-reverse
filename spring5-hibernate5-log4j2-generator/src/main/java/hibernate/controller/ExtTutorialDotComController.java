package hibernate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExtTutorialDotComController  {

	@RequestMapping(value = "/form")
	public String form() {
		return "ext/form";
	}
	
	@RequestMapping(value = "/mvm")
	public String mvvm() {
		return "mvm";
	}
	
	@RequestMapping(value = "/inheritance-in-extjs")
	public String inheritance() {
		return "ext/inheritance-in-extjs";
	}
	
	@RequestMapping(value = "/mixins")
	public String mixins() {
		return "ext/mixins";
	}
	
	@RequestMapping(value = "/config")
	public String config() {
		return "ext/config";
	}
	
	@RequestMapping(value = "/combo")
	public String combo() {
		return "ext/combo";
	}
	@RequestMapping(value = "/combo2")
	public String combo2() {
		return "ext/combo2";
	}	
	@RequestMapping(value = "/custom-events")
	public String custom() {
		return "ext/custom-events";
	}
	
	@RequestMapping(value = "/dom")
	public String dom() {
		return "ext/dom";
	}
	
	@RequestMapping(value = "/dom-helper")
	public String domHelper() {
		return "ext/dom-helper";
	}
	
	@RequestMapping(value = "/composite")
	public String composite() {
		return "ext/composite";
	}
	
	@RequestMapping(value = "/component")
	public String component() {
		return "ext/component";
	}
	
	@RequestMapping(value = "/container")
	public String container() {
		return "ext/container";
	}
	
	@RequestMapping(value = "/layouts")
	public String layouts() {
		return "ext/layouts";
	}
	@RequestMapping(value = "/component-query")
	public String componentQuery() {
		return "ext/component-query";
	}
	
	@RequestMapping(value = "/toolbar")
	public String toolbar() {
		return "ext/toolbar";
	}
	
	@RequestMapping(value = "/login")
	public String login() {
		return "ext/login";
	}
	
	@RequestMapping(value = "/tabpanel")
	public String tablpanel() {
		return "ext/tabpanel";
	}
	
	@RequestMapping(value = "/tree")
	public String tree() {
		return "ext/tree";
	}	
	
	@RequestMapping(value = "/upload")
	public String upload() {
		return "ext/upload";
	}	

	@RequestMapping(value = "/editor")
	public String editor() {
		return "ext/editor";
	}	
}
