package com.arunava.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arunava.model.CartItem;
import com.arunava.model.User;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
	//using Id
	public List<CartItem>findByUser(User user);

	//using email
	public List<CartItem> findByUser(String user);

}
