package stepDefinations;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Cucumber.Automation.Base;

public class GenericFunctions extends Base{

	public static void click(WebDriver driver)
	{
		try {
			String value = driver.findElement(By.xpath("//input[@type='search']")).getText();
			
			System.out.println(value);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		

	}
	
	public static void minimumWait() throws NumberFormatException, InterruptedException
	{
		Thread.sleep(Long.parseLong(prop.getProperty("minumumwait")));
		
	}
	
	public static void maximumWait() throws NumberFormatException, InterruptedException
	{
		Thread.sleep(Long.parseLong(prop.getProperty("maximumwait")));		
	}
	
	public static void draganddrop(WebElement antsliderhandle,int percentageOfMove) 
	{
		try
		{
		//int percentageOfMove = 50;
		Dimension sliderSize = antsliderhandle.getSize();
		int sliderWidth = sliderSize.getWidth();
		int sliderHeight =sliderSize.getHeight();
		
		int xCoord = antsliderhandle.getLocation().getX();
		
		System.out.println(xCoord);
		System.out.println(sliderWidth);
		
		double coordval = xCoord + sliderWidth+sliderHeight;
		
		//System.out.println(coordval);
		//xCoord = xCoord/2;
		coordval = coordval/2;
		//System.out.println(coordval);
		
		//int dragval = ((xCoord+sliderWidth/10)/100)*percentageOfMove;
		/*double val= (double) (coordval/100);
		System.out.println(val);
		double val1 = (double)val*90;
		System.out.println(val1);*/
		
		double doubledragval = (double) ((coordval/100)*percentageOfMove); //270;// 135*2;
		//System.out.println(doubledragval);
		int intdragval = (int) doubledragval;
		
		System.out.println(intdragval);

		Actions builder = new Actions(driver);   
		builder.moveToElement(antsliderhandle)
			   .click()
			   .dragAndDropBy
			   (antsliderhandle,intdragval, 0)
			     //(antsliderhandle,xCoord + sliderWidth, 0)
			   .build()
			   .perform();	
		
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
	}
	
	public static void acceptAlert(WebDriver driver)
	{
	driver.switchTo().alert().accept();
	}
	
	public static void dismissAlert(WebDriver driver)
	{
	driver.switchTo().alert().dismiss();
	}

	public static void scroll(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
	}
	
	
	public static void handleAlert(WebDriver driver){
	    if(isAlertPresent(driver)){
	        Alert alert = driver.switchTo().alert();
	        System.out.println(alert.getText());
	        alert.accept();
	    }
	}
	public static boolean isAlertPresent(WebDriver driver){
	      try{
	          driver.switchTo().alert();
	          return true;
	      }catch(NoAlertPresentException ex){
	          return false;
	      }
	}
	
	public static void scrollUp(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-500)", "");
	}
	
	public static void pressEnterKey(WebDriver driver)
	{
	Actions actions = new Actions(driver);
	actions.keyDown(Keys.ENTER);
	//actions.sendKeys(Keys.chord(Keys.ENTER));
	actions.build().perform();
	actions.release();
	 
	}
}
