package com.arunava.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arunava.model.CartItem;
import com.arunava.service.ShoppingCartService;



@RestController
@RequestMapping("user")
public class ShoppingCartController {

	@Autowired
	private ShoppingCartService shoppingCartService;

	@PostMapping("/addCart/{vid}")
	public CartItem addtItem(@PathVariable long vid ,HttpSession request) {
		return shoppingCartService .addItem(vid,request);
	}

	@GetMapping("/cart")
	public HashMap<String, List<CartItem>> listCartItems(HttpSession request){
		return shoppingCartService.listCartItem(request);

	}


}
