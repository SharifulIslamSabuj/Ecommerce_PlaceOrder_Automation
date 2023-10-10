package Ecommerce.OnlineShoppingAutomation;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ReviewAddressAndOrderDetails extends BrowserLaunchClose {
	
	@Test (priority=5)
	public void VerifyAddressAndOrder() throws InterruptedException {
		
	driver.get("https://automationexercise.com/");
			
	//Click "SignUp/LogIn" link in Navigation
	driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']")).click();
	Thread.sleep(1000); 
	driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("test10027@gmail.com");
	driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("MyTestPass@123");
	driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
	
	//Calling Product Page object
	EcommerceProducts_PageObjects clickto=new EcommerceProducts_PageObjects(driver);
	clickto.AddProductsToCart();
	Thread.sleep(3000);
	//5. Click 'View Cart' button
	driver.findElement(By.xpath("//u[normalize-space()='View Cart']")).click();
		  
	Thread.sleep(3000);
	//13. Click 'Proceed To Checkout' button
	driver.findElement(By.xpath("//*[@id=\"do_action\"]/div[1]/div/div/a")).click();
	
	//Verify Delivery Address
	String DeliveryAddress=driver.findElement(By.xpath("//*[@id=\"address_delivery\"]")).getText();
	Thread.sleep(3000);
	Assert.assertEquals(DeliveryAddress, "YOUR DELIVERY ADDRESS"+"\n"+"Mr. FirstName1 LastName1"+"\n"+"TESTING Corporation"+"\n"+"643/7, kalkata"+"\n"+"Madhobpur Kalkata 1234"+"\n"+"India"+"\n"+"123456789");
	Thread.sleep(3000);
	

	//Verify Billing Address 
	String BillingAddress=driver.findElement(By.id("address_invoice")).getText();
	Thread.sleep(3000);
	Assert.assertEquals(BillingAddress, "YOUR BILLING ADDRESS"+"\n"+"Mr. FirstName1 LastName1"+"\n"+"TESTING Corporation"+"\n"+"643/7, kalkata"+"\n"+"Madhobpur Kalkata 1234"+"\n"+"India"+"\n"+"123456789");
	Thread.sleep(3000);
	
	//Review Order Details
	String ProductDescription=driver.findElement(By.xpath("//*[@id=\"product-13\"]/td[2]/p")).getText();
	Assert.assertEquals(ProductDescription, "Kids > Tops & Shirts");
	String ProductPrice=driver.findElement(By.xpath("//*[@id=\"product-13\"]/td[3]/p")).getText();
	Assert.assertEquals(ProductPrice, "Rs. 278");
	//String ProductQuantity=driver.findElement(By.xpath("//*[@id=\"product-13\"]/td[4]/button")).getText();
	//Assert.assertEquals(ProductQuantity, "1");
	
	}

}
