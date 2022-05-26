package stepDefinations;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import Cucumber.Automation.Base;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends Base{
	
	@AfterStep
	public void addScreenshot(Scenario scenario){

	      final byte[] screenshot = ((TakesScreenshot) Base.Driver()).getScreenshotAs(OutputType.BYTES);
	      scenario.attach(screenshot, "image/png", "image"); 	
	}
	
	@After("@NiuliTest1")
	public void AfterNuilivaldiation()
	{
		if (driver != null)
		{
			driver.close();
		}	
		
	}

	@After("@SmokeTest")
	public void AfterSmokevaldiation()
	{
		if (driver != null)
		{
			driver.close();
		}	
		
	}
	
	@Before("@MobileTest")
	public void beforevaldiation()
	{
		System.out.println("Before Mobile  hook");
	}
	
	@After("@MobileTest")
	public void Aftervaldiation()
	{
		System.out.println("  After Mobile before hook");
	}
		
		@Before("@WebTest")
		public void beforeWebvaldiation()
		{
			System.out.println("Before Web  hook");
		}
		
		@After("@WebTest")
		public void AfterWebvaldiation()
		{
			System.out.println("  After Web before hook");
		}
		
		

		
	}


