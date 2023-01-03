package com.arunava.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ViewController {

	@RequestMapping("/register")

	public String registerPage(@RequestParam String name,ModelMap model) {
		model.put("user",name);
		System.out.println(name);

		return "register";
	}
}
