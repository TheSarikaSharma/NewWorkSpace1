package com.sara.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sara.dao.CartDAO;
import com.sara.dao.OrderDAO;
import com.sara.model.OrderDetail;

public class OrderUnitTest
{

static OrderDAO orderDAO;
	
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.sara");
		context.refresh();	
		orderDAO=(OrderDAO)context.getBean("orderDAO");
	}
	
	@Test
	public void saveOrderTest()
	{
		OrderDetail orderDetail=new OrderDetail();
		
		orderDetail.setOrderDate(new java.util.Date());
		orderDetail.setCartId(101);
		orderDetail.setShippingAddr("Tilak Nagar");
		orderDetail.setTotalAmount(5000);
		orderDetail.setTranType("COD");
		orderDetail.setUsername("kashu");
		
		assertTrue("problem in Saving Order",orderDAO.saveOrder(orderDetail));
	}
	@Test
	public void updateCart()
	{
		assertTrue("problem in Updating Cart",orderDAO.updateCart("kashu"));
		
	}
	
}