package Ecommerce.OnlineShoppingAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EcommerceAutomation extends BrowserLaunchClose {
	
	//2. Navigate to url 'http://automationexercise.com'
	@Test (priority=1)
	public void VerifyHomePage() {
	driver.get("https://automationexercise.com/");
	String UrlHomePage=driver.getCurrentUrl();
	Assert.assertEquals(UrlHomePage, "https://automationexercise.com/");
	String HomePageTitle=driver.getTitle();
	Assert.assertEquals(HomePageTitle, "Automation Exercise");
	}
	
	@Test (priority=2)
	public void VerifyCartPage() throws InterruptedException {
	//4. Add products to cart
	EcommerceProducts_PageObjects clickto=new EcommerceProducts_PageObjects(driver);
	//driver.findElement(By.xpath("/html/body/section[2]/div/div/div[2]/div[1]/div[12]/div/div[1]/div[1]/a")).click();
	clickto.AddProductsToCart();
	Thread.sleep(3000);
	//5. Click 'View Cart' button
	driver.findElement(By.xpath("//p[@class='text-center']//a")).click();
	String UrlViewCartPage=driver.getCurrentUrl();
	Assert.assertEquals(UrlViewCartPage, "https://automationexercise.com/view_cart");
	}
	
	//Account Creation
	@Test (priority=3)
	public void VerifyAccountCreated() throws InterruptedException {
	//7. Click Proceed To Checkout
	driver.findElement(By.xpath("//*[@id=\"do_action\"]/div[1]/div/div/a")).click();
	
	//8. Click 'Register / Login' button
	driver.findElement(By.xpath("//*[@id=\"checkoutModal\"]/div/div/div[2]/p[2]/a/u")).click();
	
	//9. Fill all details in Sign up and create account
	
	driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]")).sendKeys("TestName12");
	driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]")).sendKeys("test1021@gmail.com");
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
	
	 //11. Verify ' Logged in as username' at top
	@Test (priority=4)
	public void VerifyLoggedInAsUsername() throws InterruptedException {
		 
		  Thread.sleep(3000);
		  //Click Continue Button
		  driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/a")).click();
		  Thread.sleep(3000);
		  String Text1=driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a")).getText();
		  Assert.assertEquals(Text1, "Logged in as TestName12");
	}
	
	
	@Test (priority=5)
	public void VerifyAddressAndOrder() throws InterruptedException {
	//12.Click 'Cart' button
	driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[3]/a")).click();
								
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
	String ProductQuantity=driver.findElement(By.xpath("//*[@id=\"product-13\"]/td[4]/button")).getText();
	Assert.assertEquals(ProductQuantity, "1");
	
	}
	
	@Test (priority=6)
	public void VerifyPlaceOrderSuccessMessage() throws InterruptedException {
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
	Thread.sleep(3000);
	//17. Click 'Pay and Confirm Order' button
	driver.findElement(By.id("submit")).click();
	Thread.sleep(3000);
	String OrderPlacedMessage=driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/p")).getText();
	Assert.assertEquals(OrderPlacedMessage, "Congratulations! Your order has been confirmed!");
	Thread.sleep(3000);
	}
	
}
