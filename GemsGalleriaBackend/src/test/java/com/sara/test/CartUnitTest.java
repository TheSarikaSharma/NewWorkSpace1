package com.sara.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sara.dao.CartDAO;
import com.sara.model.CartItem;




public class CartUnitTest 
{

static CartDAO cartDAO;
	
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.sara");
		context.refresh();	
		cartDAO=(CartDAO)context.getBean("cartDAO");
	}

	@Test
	public void addCartTest() 
	{
	CartItem cartItem=new CartItem();
	cartItem.setProductID(37);
	cartItem.setProductName("Rings");
	cartItem.setQuantity(50);
	cartItem.setPrice(25000);
	cartItem.setPaymentStatus("NP");
	cartItem.setUsername("sarika");
	assertTrue("problem in Adding into Cart",cartDAO.addCartItem(cartItem));
		
     }

@Ignore
@Test
public void updateCartItemTest()
{
CartItem cartItem=cartDAO.getCartItem(45);
cartItem.setQuantity(61);
assertTrue("problem in Upading the Cart",cartDAO.updateCartItem(cartItem));

} 
@Ignore
@Test
public void deleteCartItemTest()
{
	CartItem cartItem=cartDAO.getCartItem(45);
	assertTrue("problem in deleting the CartItem",cartDAO.deleteCartItem(cartItem));


}


	@Test
	public void displayCartItems()
	{
		List<CartItem> listCartItems=cartDAO.listCartItem("sarika");
		
		assertTrue("problem in Displaying the CartItems",listCartItems.size()>0);
		
		for(CartItem cartItem:listCartItems)
		{
			System.out.print(cartItem.getProductID()+"\t");
			System.out.print(cartItem.getProductName()+"\t");
			System.out.print(cartItem.getPrice()+"\t");
			System.out.println(cartItem.getPrice()*cartItem.getQuantity());
		}
		
	}
	
}
