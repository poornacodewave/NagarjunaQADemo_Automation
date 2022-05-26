package pageObjectsModels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	public WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}

	By search=By.xpath("//input[@type='search']");
	
	By productName=By.cssSelector("h4.product-name");
	
	By increment=   By.cssSelector("a.increment");
	
	By addToCart=By.xpath("//button[contains(text(),'ADD TO CART')]");
	

 
	
	
	

	public WebElement getSearch()
	{
		return driver.findElement(search);
	}
	
	public WebElement getProductName()
	{
		return driver.findElement(productName);
	}
	public WebElement increment()
	{
		return driver.findElement(increment);
	}
	public WebElement addToCart()
	{
		return driver.findElement(addToCart);
	}
}
