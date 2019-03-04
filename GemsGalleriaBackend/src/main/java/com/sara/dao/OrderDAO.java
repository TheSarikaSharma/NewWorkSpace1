package com.sara.dao;

import com.sara.model.OrderDetail;

public interface OrderDAO

{
    public boolean saveOrder(OrderDetail orderDetail);
	public boolean updateCart(String username);
}
