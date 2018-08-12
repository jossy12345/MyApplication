package com.app.tests;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.app.pages.HomePageObjects;

public class HomePageTest {

	HomePageObjects HomePage;
	int val = new Random().nextInt(5000);
	String email = "Jossy" + val + "@gmail.com";

	public HomePageTest() {
		HomePage = new HomePageObjects();
	}

	@Test
	public void verifyTab()
	{
		Assert.assertTrue(HomePage.elementFound(HomePage.getWomen()));
		Assert.assertTrue(HomePage.elementFound(HomePage.getDresses()));
		Assert.assertTrue(HomePage.elementFound(HomePage.getTshirts()));
	}

	@Test
	public void verifyAddToCardForProducts()
	{
		List<WebElement> products = HomePage.getProductList();

		for (WebElement prod : products) {
			Assert.assertTrue(HomePage.verifyAddToCard(prod), "Failed : Add to cart is not displayed for the product");
		}
	}

	
	  @Test public void verifyPageSelection() 
	  { 
		  HomePage.clickWomen();
		  Assert.assertTrue(HomePage.getTitle().contains("Women"),"Women page not selected"); 
		  HomePage.clickDresses();
		  Assert.assertTrue(HomePage.getTitle().contains("Dresses"),"Dresses page not selected"); 
		  HomePage.clickTshirts();
		  Assert.assertTrue(HomePage.getTitle().contains("T-shirts"),"T shirts page not selected");
	  }
	 
	 @Test public void verifySubscriptionMsg() {
	 
	 HomePage.SubmitEmail(email);
	 Assert.assertTrue(HomePage.elementFound(HomePage.getSubscriptionMessage()));
	  }
	 
}
