package com.pkfinal.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	@RequestMapping("/Map")
	public String map() {
		return "map";
	}
}
