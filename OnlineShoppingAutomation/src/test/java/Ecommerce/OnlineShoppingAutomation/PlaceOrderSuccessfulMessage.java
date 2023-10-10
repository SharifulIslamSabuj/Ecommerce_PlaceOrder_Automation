package Ecommerce.OnlineShoppingAutomation;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlaceOrderSuccessfulMessage extends BrowserLaunchClose {
	
	@Test (priority=6)
	public void VerifyPlaceOrderSuccessMessage() throws InterruptedException {
		
	driver.get("https://automationexercise.com/");
		
	//Click "SignUp/LogIn" link in Navigation
	driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']")).click();
	Thread.sleep(1000); 
	driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("test10027@gmail.com");
	driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("MyTestPass@123");
	driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
	//Calling Product Page Object
	EcommerceProducts_PageObjects clickto=new EcommerceProducts_PageObjects(driver);
	clickto.AddProductsToCart();
	Thread.sleep(2000);
	//5. Click 'View Cart' button
	driver.findElement(By.xpath("//u[normalize-space()='View Cart']")).click();						
	Thread.sleep(2000);
	//13. Click 'Proceed To Checkout' button
	driver.findElement(By.xpath("//*[@id=\"do_action\"]/div[1]/div/div/a")).click();	
		
	//15. Enter description in comment text area and click 'Place Order'
	driver.findElement(By.xpath("//*[@id=\"ordermsg\"]/textarea")).sendKeys("Delivery and billing address are right. Please deliver my order as soon as possible. Thank you.");
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@id=\"cart_items\"]/div/div[7]/a")).click();
	Thread.sleep(3000);
	//16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
	driver.findElement(By.xpath("//*[@id=\"payment-form\"]/div[1]/div/input")).sendKeys("TestName");
	driver.findElement(By.xpath("//*[@id=\"payment-form\"]/div[2]/div/input")).sendKeys("1234567890123");
	driver.findElement(By.xpath("//*[@id=\"payment-form\"]/div[3]/div[1]/input")).sendKeys("175");
	driver.findElement(By.xpath("//*[@id=\"payment-form\"]/div[3]/div[2]/input")).sendKeys("12");
	driver.findElement(By.xpath("//*[@id=\"payment-form\"]/div[3]/div[3]/input")).sendKeys("2025");
	Thread.sleep(2000);
	//17. Click 'Pay and Confirm Order' button
	driver.findElement(By.id("submit")).click();
	Thread.sleep(2000);
	String OrderPlacedMessage=driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/p")).getText();
	Assert.assertEquals(OrderPlacedMessage, "Congratulations! Your order has been confirmed!");
	Thread.sleep(3000);
	}

}
