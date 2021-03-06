package com.sara.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sara.dao.UserDAO;
import com.sara.model.UserDetail;

public class UserUnitTest {

	static UserDAO userDAO;
	
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.sara");
		context.refresh();	
		userDAO=(UserDAO)context.getBean("userDAO");
	}
	
	@Test
	//@Ignore
	public void registerUserTest()
	{
		UserDetail user=new UserDetail();
		
		user.setUsername("kashubehal");
		user.setPassword("pass1234");
		user.setEnabled(true);
		user.setRole("ROLE_ADMIN");
		user.setCustomerName("Kashu Behl");
		user.setCustomerAddr("Ooty");
		
	//assertTrue("Problem in adding User:",userDAO.registerUser(user));
	}
}
