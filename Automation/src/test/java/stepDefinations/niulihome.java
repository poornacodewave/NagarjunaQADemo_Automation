package stepDefinations;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import Cucumber.Automation.Base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import pageObjectsModels.CheckOutPage;
import pageObjectsModels.HomePage;
import pageObjectsModels.nuiliHomePage;
import stepDefinations.GenericFunctions;

@RunWith(Cucumber.class)
public class niulihome {

	public WebDriver driver;
	
	nuiliHomePage nuilihomepage;
	HomePage h;
	CheckOutPage cp;
	
	public GenericFunctions _functions;
	
		@Given("User is on niuli home page")
		public void user_is_on_niuli_home_page() throws Throwable 
		{
			driver= Base.getDriver();
			System.out.println("User is on Niuli Home Page");
		}

		
		@When("User click on language switch")
		public void user_click_on_language_switch()
		{
			nuilihomepage = new nuiliHomePage(driver);
			nuilihomepage.clicklangswitch();
    		Assert.assertTrue("The get your kitchen not Exists",nuilihomepage.VerifygetyourkitchenExists());
			System.out.println("The get your kitchen Exists");

		}
		
		@When("User login to application")
		public void user_login_to_application() {
		    // Write code here that turns the phrase above into concrete actions
			Assert.assertTrue(" user not logged Successfully into home page",nuilihomepage.LoginToNuili());
			System.out.println("Successfully logged into home page");
		}
			
		@Then("User book an demo")
		public void user_book_an_demo() {
		
			Assert.assertTrue(" user not logged Successfully into home page",nuilihomepage.BookAnDemo());
			System.out.println("Successfully booked an demo");
		}










}
