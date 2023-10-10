package Ecommerce.OnlineShoppingAutomation;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageVisibility extends BrowserLaunchClose {
	
	//2. Navigate to url 'http://automationexercise.com'
	@Test (priority=1)
	public void VerifyHomePageVisibility() {
	driver.get("https://automationexercise.com/");
	
	String UrlHomePage=driver.getCurrentUrl();
	Assert.assertEquals(UrlHomePage, "https://automationexercise.com/");
	
	String HomePageTitle=driver.getTitle();
	Assert.assertEquals(HomePageTitle, "Automation Exercise");
	}

}
