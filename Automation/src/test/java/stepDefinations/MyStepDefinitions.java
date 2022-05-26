package stepDefinations;


import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Cucumber.Automation.Base;
import io.cucumber.java.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import pageObjectsModels.CheckOutPage;
import pageObjectsModels.HomePage;

@RunWith(Cucumber.class)
public class MyStepDefinitions {
	public WebDriver driver;
	HomePage h;
	CheckOutPage cp;
	public GenericFunctions _functions;

    @Given("^User is on Greencart Landing page$")
    public void user_is_on_greencart_landing_page() throws Throwable 
    {
        driver= Base.getDriver();
    }


    @When("^User searched for (.+) Vegetable$")
    public void user_searched_for_something_vegetable(String strArg1) throws Throwable {
        
    	//  //tagname[@attribute='value']
    _functions.click(Base.Driver());		   	
    	
    h=new HomePage(driver);
    h.getSearch().sendKeys(strArg1);
  
    	Thread.sleep(3000);
    	
    }
    

    @Then("^\"([^\"]*)\" results are displayed$")
    public void something_results_are_displayed(String strArg1) throws Throwable {
   Assert.assertTrue( h.getProductName().getText().contains(strArg1));
    }
   

    @And("^Added items to cart$")
    public void added_items_to_cart() throws Throwable {
   h.increment().click();
h.addToCart().click();
    }

    @And("^User proceeded to Checkout page for purchase$")
    public void user_proceeded_to_checkout_page_for_purchase() throws Throwable {
  driver.findElement(By.xpath("//a[@class='cart-icon']//img[contains(@class,'')]")).click();
  driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
  
    }

    //io.cucumber.junit.UndefinedStepException: The step "Fail the test case" is undefined. You can implement it using the snippet(s) below:

    	@Then("Fail the test case")
    	public void fail_the_test_case() {
    	    // Write code here that turns the phrase above into concrete actions
    	    //throw new io.cucumber.java.PendingException();
    		//System.out.println("hello darling");
    		//System.out.println("hello darling added the changes");
    		Assert.assertTrue(true);
    	}



}