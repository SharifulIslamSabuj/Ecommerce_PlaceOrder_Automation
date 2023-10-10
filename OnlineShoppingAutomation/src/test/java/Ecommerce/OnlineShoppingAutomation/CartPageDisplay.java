package Ecommerce.OnlineShoppingAutomation;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartPageDisplay extends BrowserLaunchClose {
	
	@Test (priority=2)
	public void VerifyCartPage() throws InterruptedException {
	driver.get("https://automationexercise.com/");
	
	//4. Add products to cart
	EcommerceProducts_PageObjects clickto=new EcommerceProducts_PageObjects(driver);
	clickto.AddProductsToCart();
	Thread.sleep(3000);
	
	//5. Click 'View Cart' button
	driver.findElement(By.xpath("//u[normalize-space()='View Cart']")).click();
	
	String UrlViewCartPage=driver.getCurrentUrl();
	Assert.assertEquals(UrlViewCartPage, "https://automationexercise.com/view_cart");
	
	//7. Click Proceed To Checkout
	driver.findElement(By.xpath("//*[@id=\"do_action\"]/div[1]/div/div/a")).click();
	}

}
