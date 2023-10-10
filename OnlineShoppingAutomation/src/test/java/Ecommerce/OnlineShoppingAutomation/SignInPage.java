package Ecommerce.OnlineShoppingAutomation;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignInPage extends BrowserLaunchClose {
	
	@Test (priority=4)
	public void VerifyLoggedInAsUsername() throws InterruptedException {
		
		
	driver.get("https://automationexercise.com/");
		
	//Click "SignUp/LogIn" link in Navigation
	driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']")).click();
	Thread.sleep(2000);
 
	//Input User ID & Password
	driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("test10027@gmail.com");
	driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("MyTestPass@123");
	driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
	
	//Verify UserName as logged in
	String Text1=driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a")).getText();
	Assert.assertEquals(Text1, "Logged in as TestName12");
	}

}
