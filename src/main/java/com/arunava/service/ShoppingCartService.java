package com.arunava.service;

import java.util.HashMap;
import java.util.List;

import com.arunava.model.CartItem;

import jakarta.servlet.http.HttpSession;

public interface ShoppingCartService {

	CartItem addToCart(Long uid, Long vid);

	List<CartItem> listCartItem(Long uid);

	CartItem addItem(long vid, HttpSession request);

	HashMap<String, List<CartItem>> listCartItem(HttpSession request);


}
