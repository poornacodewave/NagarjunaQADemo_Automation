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
import pageObjectsModels.QALogin;
import pageObjectsModels.nuiliHomePage;
import stepDefinations.GenericFunctions;

@RunWith(Cucumber.class)
public class demoQA {

	public WebDriver driver;
	
	nuiliHomePage nuilihomepage;
	HomePage h;
	CheckOutPage cp;
	
	public static QALogin qaloginObj;
	
	public GenericFunctions _functions;
	
	
	 @Given("^User login to demoQA with (.+) and password (.+)$")
	 public void user_login_to_demoqa_with_and_password(String username, String password) throws Throwable 
	 {
    	driver= Base.getDriver();
		System.out.println("User is on demoQA login Page");
		
		qaloginObj = new QALogin(driver);
		
		qaloginObj.enterloginInputFieldValue(username);
		qaloginObj.enterpasswordInputFieldValue(password);
		_functions.scroll(driver);
		qaloginObj.clickLoginButton();
		
    }
    
	 @Then("^User Navigate Back To Store$")
	    public void user_navigate_back_to_store() throws Throwable {

		 qaloginObj.clickgoToBookStoreButton();
	    }
	 
	 @When("^User add all the books to collection$")
	    public void user_add_all_the_books_to_collection() throws Throwable {
		 
		 qaloginObj.clickyouDontKnowJSLinkButton();
		 
		 qaloginObj.clickAddToYourCollectionAndNavigateBackToStore();
		 
		 qaloginObj.clickunderstandingEMACScriptLinkButton(); 
		 
		 qaloginObj.clickAddToYourCollectionAndNavigateBackToStore();
		 
		 qaloginObj.clickjavascriptDesignPatternsLinkButton();
		 
		 qaloginObj.clickAddToYourCollectionAndNavigateBackToStore();
		 
	    }


	 @Then("^User enter the (.+) in search input field$")
	    public void user_enter_the_in_search_input_field(String searchvalue) throws Throwable {

		 qaloginObj.entersearchBoxInputFieldValue(searchvalue);
	    }

	 @Then("^Verify only (.+) is displayed$")
	    public void verify_only_is_displayed(String bookname) throws Throwable {
		 
		 qaloginObj.verifyOnlyOneBookIsDisplayed(bookname);
	    }
    
	 @When("^User add gitPocketGuide to collection$")
	    public void user_add_gitpocketguide_to_collection() throws Throwable {
	    	 
		 qaloginObj.gitPocketGuideLinkButton();
		 		 
		 qaloginObj.clickAddToYourCollectionAndNavigateBackToStore();
		 
		 
	    }
	 
	 @When("^User navigate to profile page$")
	    public void user_navigate_to_profile_page() throws Throwable {
		 qaloginObj.clickProfileButton();
		 _functions.minimumWait();
	    }

	 @Then("^Verify only all four books are displayed$")
	    public void verify_only_all_four_books_are_displayed() throws Throwable {
		 qaloginObj.VerifyfourbooksDisplayed();
	    }


		
}
