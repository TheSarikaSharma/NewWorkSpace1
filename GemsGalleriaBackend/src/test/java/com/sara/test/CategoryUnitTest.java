package com.sara.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.sara.dao.CategoryDAO;
import com.sara.model.Category;

public class CategoryUnitTest 
{
static CategoryDAO categoryDAO;
	
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.sara");
		context.refresh();	
		categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
		
	}
	
	@Test
	public void addCategoryTest() 
	{
		Category category=new Category();
		category.setCategoryName("Rings");
		category.setCategoryDesc("Rings with stones");		
		assertTrue("Problem in adding Category",categoryDAO.addCategory(category));
	}
	
	@Test
	public void deleteCategoryTest()
	{
		Category category=categoryDAO.getCategory(10);
	//	assertTrue("Problem in Deleting Category:",categoryDAO.deleteCategory(category));
	}
	@Ignore
	@Test
	public void updateCategoryTest()
	{
		Category category=categoryDAO.getCategory(3);
		category.setCategoryDesc("Rings with EMERALD stone");
		//assertTrue("Problem in Updating the Category",categoryDAO.updateCategory(category));
	}
	
	@Test
	public void listCategoriesTest()
	{
		List<Category> listCategories=categoryDAO.listCategories();
		//assertTrue("Problem in Listing Categories:",listCategories.size()>0);
		
		for(Category category:listCategories)
		{
			System.out.println("Category ID:"+category.getCategoryID());
			System.out.println("Category Name:"+category.getCategoryName());
			System.out.println("Category Desc:"+category.getCategoryDesc());
		}
	}

}
