package Ecommerce.OnlineShoppingAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EcommerceProducts_PageObjects {
	WebDriver driver1;
	
	//Create Product Element using Element Locators
	By FrozenTopsForKids=By.xpath("/html/body/section[2]/div/div/div[2]/div[1]/div[12]/div/div[1]/div[1]/a");
	By MenTShirt=By.xpath("/html/body/section[2]/div/div/div[2]/div[1]/div[3]/div/div[1]/div[1]/a");
	By WinterTop=By.xpath("/html/body/section[2]/div/div/div[2]/div[1]/div[6]/div/div[1]/div[1]/a");
	By StylishDress=By.xpath("/html/body/section[2]/div/div/div[2]/div[1]/div[5]/div/div[1]/div[1]/a");
	By SummerWhiteTop=By.xpath("/html/body/section[2]/div/div/div[2]/div[1]/div[7]/div/div[1]/div[1]/a");
	By BlueTop=By.xpath("/html/body/section[2]/div/div/div[2]/div[1]/div[2]/div/div[1]/div[1]/a");
	By FancyGreenTop=By.xpath("/html/body/section[2]/div/div/div[2]/div[1]/div[9]/div/div[1]/div[1]/a");
	By NeonGreenTShirt=By.xpath("/html/body/section[2]/div/div/div[2]/div[1]/div[26]/div/div[1]/div[1]/a");
	By PremiumPoloTShirt=By.xpath("/html/body/section[2]/div/div/div[2]/div[1]/div[25]/div/div[1]/div[1]/a");
	By SoftStretchJeans=By.xpath("/html/body/section[2]/div/div/div[2]/div[1]/div[27]/div/div[1]/div[1]/a");
	

	public EcommerceProducts_PageObjects(WebDriver driver2)
	{
		this.driver1=driver2;
	}
	
	public void AddProductsToCart() throws InterruptedException
	{
		driver1.findElement(FrozenTopsForKids).click();
		Thread.sleep(3000);
		driver1.findElement(By.xpath("//*[@id=\"cartModal\"]/div/div/div[3]/button")).click();
		Thread.sleep(3000);
		driver1.findElement(BlueTop).click();
	}
}
