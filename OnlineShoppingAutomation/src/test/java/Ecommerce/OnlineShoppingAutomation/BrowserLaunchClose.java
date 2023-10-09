package Ecommerce.OnlineShoppingAutomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BrowserLaunchClose {
static WebDriver driver;
	
	//1. Launch browser(Google Chrome/FireFox)
	@BeforeTest
	public void LaunchBrowser() {
	//System.setProperty("webdriver.chrome.driver", "..//OnlineShoppingAutomation//Drivers//chromedriver.exe");
	//driver =new ChromeDriver();
	System.setProperty("webdriver.gecko.driver", "..//OnlineShoppingAutomation//Drivers//geckodriver.exe");
	driver =new FirefoxDriver();
	driver.manage().window().maximize();
	}
	
	@AfterTest
	public void CloseBrowser() {
		
		driver.close();
	}

}
