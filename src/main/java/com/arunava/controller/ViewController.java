package com.arunava.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.arunava.model.User;

@Controller
public class ViewController {

	@RequestMapping("/register")

	public String registerPage(@RequestParam String name,ModelMap model) {
		model.put("user",name);
		System.out.println(name);
		
		return "register";
	}
}
