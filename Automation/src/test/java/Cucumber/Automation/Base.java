package Cucumber.Automation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

import stepDefinations.GenericFunctions;

public class Base {
	public static WebDriver driver;
	public static Properties prop;
	public GenericFunctions _functions;

	public static WebDriver Driver()
	{
		if(driver == null)
		{
			throw new NullPointerException("The Webdriver browser instance was not initialized. you should first call the method InItBrowser");
		}	
		return driver;
	}

	public static WebDriver getDriver() throws IOException
	{
		//#url_nuili = https://qa.niulihome.com/
		prop=new Properties();
		//FileInputStream fis=new FileInputStream("C:\\Users\\Lenovo\\Documents\\Automation new\\Automation\\src\\test\\java\\Cucumber\\Automation\\global.properties");
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\Cucumber\\Automation\\global.properties");
		
	    prop.load(fis);

	    ChromeOptions options = new ChromeOptions();
	    options.addArguments("--disable-notifications");
	    
	    options.setCapability("unhandledPromptBehavior", "accept");
	    
	    options.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
	    
	    /*options.setCapability("UNEXPECTED_ALERT_BEHAVIOUR", "ACCEPT");
	    options.setCapability("unexpectedAlertBehaviour", "accept");
	    options.setCapability("CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR", "ACCEPT");
	    options.setCapability("UnexpectedAlertBehaviour", "ACCEPT");
	    *///webdriver.DesiredCapabilities.CHROME["unexpectedAlertBehaviour"] = "accept"
	    		
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\Documents\\Automation new\\Automation\\src\\test\\java\\driver\\chromedriver.exe");
	    System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\java\\driver\\chromedriver.exe");
	    
	    driver=new ChromeDriver(options);
   	 
  	//driver.get(prop.getProperty("url"));
   	driver.get("https://demoqa.com/login");    
  	driver.manage().window().maximize();
  	driver.manage().timeouts().implicitlyWait(Long.parseLong(prop.getProperty("implicitwait")), TimeUnit.SECONDS);
  	return driver;
		
	}
	
}





