package Ecommerce.OnlineShoppingAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpPage extends BrowserLaunchClose {
	
	@Test (priority=3)
	public void VerifyAccountCreated() throws InterruptedException {
		
	driver.get("https://automationexercise.com/");
	//4. Add products to cart
	EcommerceProducts_PageObjects clickto=new EcommerceProducts_PageObjects(driver);
	clickto.AddProductsToCart();
	Thread.sleep(3000);
	//5. Click 'View Cart' button
	driver.findElement(By.xpath("//p[@class='text-center']//a")).click();
			
	//7. Click Proceed To Checkout
	driver.findElement(By.xpath("//*[@id=\"do_action\"]/div[1]/div/div/a")).click();
	
	//8. Click 'Register / Login' button
	driver.findElement(By.xpath("//*[@id=\"checkoutModal\"]/div/div/div[2]/p[2]/a/u")).click();
		
	//9. Fill all details in Sign up and create account
		driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]")).sendKeys("TestName12");
	driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]")).sendKeys("test10031@gmail.com");
	driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button")).click();
	
	//Putting Sign up detail info	
	driver.findElement(By.id("id_gender1")).click();
	driver.findElement(By.id("password")).sendKeys("MyTestPass@123");
	Select dropDown1 = new Select(driver.findElement(By.id("days")));
	dropDown1.selectByVisibleText("1");
	Select dropDown2 = new Select(driver.findElement(By.id("months")));
	dropDown2.selectByVisibleText("January");
	Select dropDown3 = new Select(driver.findElement(By.id("years")));
	dropDown3.selectByVisibleText("1985");
	driver.findElement(By.id("newsletter")).click();
	driver.findElement(By.id("optin")).click();
	
	driver.findElement(By.id("first_name")).sendKeys("FirstName1");
	driver.findElement(By.id("last_name")).sendKeys("LastName1");
	driver.findElement(By.id("company")).sendKeys("TESTING Corporation");
	driver.findElement(By.id("address1")).sendKeys("643/7, kalkata");
	
	Select dropDown4 = new Select(driver.findElement(By.id("country")));
	dropDown4.selectByVisibleText("India");
	
	driver.findElement(By.id("state")).sendKeys("Kalkata");
	driver.findElement(By.id("city")).sendKeys("Madhobpur");
	driver.findElement(By.id("zipcode")).sendKeys("1234");
	driver.findElement(By.id("mobile_number")).sendKeys("123456789");
	
	driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/form/button")).click();
	
	Thread.sleep(5000);
	
	//10. Verify 'ACCOUNT CREATED!'
	String AccountCreationSuccessfullMessage=driver.findElement(By.xpath("/html[1]/body[1]/section[1]/div[1]/div[1]/div[1]/h2[1]/b[1]")).getText();
	  
	Assert.assertEquals(AccountCreationSuccessfullMessage, "ACCOUNT CREATED!");
	 
	Thread.sleep(2000);
	
	String AccountCreatedUrl=driver.getCurrentUrl();
	Assert.assertEquals(AccountCreatedUrl, "https://automationexercise.com/account_created");
	  
	}

}
