package com.sara.dao;

import java.util.List;

import com.sara.model.CartItem;

public interface CartDAO
{
	

	public boolean deleteCartItem(CartItem cartItem);
	public boolean updateCartItem(CartItem cartItem);
	public CartItem getCartItem(int cartItemId);
	
	public List<CartItem> listCartItem(String username);
	boolean addCartItem(CartItem cartItem);
	
	

}
