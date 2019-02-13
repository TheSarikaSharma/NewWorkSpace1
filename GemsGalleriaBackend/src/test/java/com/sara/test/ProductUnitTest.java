package com.sara.test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sara.dao.ProductDAO;
import com.sara.model.Product;

public class ProductUnitTest 
{
	static ProductDAO productDAO;
	
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.sara");
		context.refresh();	
		productDAO=(ProductDAO)context.getBean("productDAO");
	}
	
	@Test
	public void addProductTest()
	{
		Product product=new Product();
		product.setProductName("Rings");
		product.setProductDesc("Rings with green EMERALD stone");
		product.setPrice(25000);
		product.setStock(45);
		product.setCategoryId(3);
		product.setSupplierId(1);
		
		assertTrue("Problem in Adding Product:",productDAO.addProduct(product));
	}
}

