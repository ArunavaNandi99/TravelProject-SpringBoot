package com.arunava.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arunava.exception.UserNotFoundException;
import com.arunava.model.CartItem;
import com.arunava.model.User;
import com.arunava.model.Vacation;
import com.arunava.repository.CartItemRepository;
import com.arunava.repository.UserRepository;
import com.arunava.repository.VacationRepository;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
	
	@Autowired
	private CartItemRepository cartRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private VacationRepository vacationRepo;
	
	public List<CartItem> listCartItems(User user){
		return cartRepo.findByUser(user);
	}

	
	//static
	@Override
	public CartItem addToCart(Long uid, Long vid) {
		User user = userRepo.findById(uid).orElseThrow(()-> new UserNotFoundException("userNot found :" +uid));
		Vacation vacation = vacationRepo.findById(vid).orElseThrow(()->new UserNotFoundException("vacation not found :" +vid));
		
		CartItem cartItem = new CartItem();
		//cartItem.setUser(user);
		cartItem.setVacation(vacation);
		
		
		
		return cartRepo.save(cartItem);
	}

	//static
	@Override
	public List<CartItem> listCartItem(Long uid) {
		User user = userRepo.findById(uid).orElseThrow(()-> new UserNotFoundException("User not found By Id :"+uid));
		
		List<CartItem> cartList = cartRepo.findByUser(user);
		return cartList;
	}

	//dynamic using session
	@Override
	public CartItem addItem(long vid, HttpSession request) {
		String us = (String) request.getAttribute("userDetails");
		if(us!= null) {
			Vacation vacation = vacationRepo.findById(vid).orElseThrow(()->new UserNotFoundException("vacation not found :" +vid));
			
			CartItem item = new CartItem();
			item.setUser(us);
			item.setVacation(vacation);
			
			return cartRepo.save(item);
		}
		return null;
		
	}

	//dynamic using session
	@Override
	public HashMap<String, List<CartItem>> listCartItem(HttpSession request) {
		String user =(String) request.getAttribute("userDetails");
		if(user != null) {
			List<CartItem> cartItems = cartRepo.findByUser(user);
			HashMap<String , List<CartItem> > map = new HashMap<>();
			map.put(user, cartItems);
			return  map;
		}
		return null;	
	}

}
