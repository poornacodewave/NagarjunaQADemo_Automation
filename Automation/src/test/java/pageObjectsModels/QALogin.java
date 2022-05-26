package pageObjectsModels;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Cucumber.Automation.Base;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.junit.Assert;
import stepDefinations.GenericFunctions;

public class QALogin extends Base{

	WebDriver driver;
	
	@FindBy(id="userName")
    WebElement loginInputField;
	
	@FindBy(id="password")
    WebElement passwordInputField;
	
	@FindBy(id="login")
    WebElement loginButton;

	@FindBy(id="gotoStore")
    WebElement goToBookStoreButton;
	
	@FindBy(xpath="//button[text()='Delete All Books']")
    WebElement deleteAllBooksButton;
	
	@FindBy(id="see-book-You Don't Know JS")
    WebElement youDontKnowJSLinkButton;
	
	@FindBy(id="see-book-Understanding ECMAScript 6")
    WebElement understandingEMACScriptLinkButton;
	
	@FindBy(id="see-book-Learning JavaScript Design Patterns")
    WebElement javascriptDesignPatternsLinkButton;
	
	@FindBy(xpath="//button[text()='Add To Your Collection']")
    WebElement addToYourCollectionButton;
	
	@FindBy(xpath="//button[text()='Back To Book Store']")
    WebElement backToBookStoreButton;
	

	@FindBy(id="closeSmallModal-ok")
    WebElement okButton;
	
	@FindBy(id="searchBox")
    WebElement searchBoxInputField;
	
	@FindBy(xpath="//div[@class='action-buttons']")
	List<WebElement> listofBooks;
	
	@FindBy(xpath="//a[text()='Git Pocket Guide']")
    WebElement gitPocketGuideLinkButton;
	
	@FindBy(xpath="//span[text()='Profile']")
	WebElement ProfileButton;
	
	
	public GenericFunctions _functions;
	
    public QALogin(WebDriver driver){

        this.driver = driver;

        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);

    }
    
    public void entersearchBoxInputFieldValue(String val){

        _functions.scrollUp(driver);
    	searchBoxInputField.sendKeys(val);

    }
    
    public void clickProfileButton(){

        _functions.scroll(driver);
        ProfileButton.click();

    }
    
    public void enterloginInputFieldValue(String val){

    	loginInputField.sendKeys(val);

    } 

    public void enterpasswordInputFieldValue(String val){

    	passwordInputField.sendKeys(val);

    } 
    
    public void clickLoginButton(){

    	loginButton.click();

    } 
    
    public void clickgoToBookStoreButton() throws InterruptedException{

    	_functions.maximumWait();
    	_functions.scroll(driver);
    	deleteAllBooksButton.click();
      	okButton.click();
      	_functions.minimumWait();
      	_functions.handleAlert(driver);
      	_functions.handleAlert(driver);
     	
    	goToBookStoreButton.click();

    } 
    
    public void clickyouDontKnowJSLinkButton(){

    	_functions.scroll(driver);
    	youDontKnowJSLinkButton.click();

    } 
    
    public void clickunderstandingEMACScriptLinkButton() throws NumberFormatException, InterruptedException{

    	_functions.minimumWait();
    	_functions.scroll(driver);
    	_functions.scroll(driver);
    	understandingEMACScriptLinkButton.click();

    } 
    
    
    public void clickjavascriptDesignPatternsLinkButton(){

    	javascriptDesignPatternsLinkButton.click();

    } 
    
    public void clickAddToYourCollectionAndNavigateBackToStore() throws NumberFormatException, InterruptedException{

    	_functions.scroll(driver);
    	addToYourCollectionButton.click();
    	_functions.minimumWait();
    	//addToYourCollectionButton.sendKeys(Keys.RETURN);
    	//addToYourCollectionButton.sendKeys(Keys.ESCAPE);
    	
    	//driver.switchTo().alert().sendKeys(Keys.ENTER);
    	//driver.switchTo().alert().accept();
      	
    	try {
			
    		for(int i=0;i<10;i++)
        	{
          	Alert simpleAlert = driver.switchTo().alert();
            simpleAlert.accept();
            Thread.sleep(5000);
        	}
    		
		} catch (Exception e) {
			// TODO: handle exception
		}
    	
        
    	//_functions.handleAlert(driver);
    	_functions.handleAlert(driver);
    	//_functions.pressEnterKey(driver);
    	_functions.minimumWait();
    	_functions.scroll(driver);	
    	backToBookStoreButton.click();

    } 
    
    public void verifyOnlyOneBookIsDisplayed(String expVal)
    {
    	if(listofBooks.size()==1)
    	{
    		String actualVal = listofBooks.get(0).getText();
    		if(expVal.trim().equals(actualVal.trim()))
    		{
    			System.out.println("l"+expVal+"l");
    			System.out.println("l"+actualVal+"l");
    			System.out.println(expVal +" is equal to "+actualVal);
    			Assert.assertTrue(true);
    		}
    		else
    		{
    			System.out.println(expVal +" is not equal to "+actualVal);
    			Assert.assertTrue(false);
    		}	
    	}
    	else
    	{
    		System.out.println("more than 1 book is displayed actual no of books is "+listofBooks.size() );
			Assert.assertTrue(false);
    	}	
    	
    	
    }
      
    public void gitPocketGuideLinkButton(){

    	gitPocketGuideLinkButton.click();

    }
    
    public void VerifyfourbooksDisplayed(){
    	
    	
    	Assert.assertTrue(youDontKnowJSLinkButton.isDisplayed());
    	Assert.assertTrue(understandingEMACScriptLinkButton.isDisplayed());
    	Assert.assertTrue(javascriptDesignPatternsLinkButton.isDisplayed());
    	Assert.assertTrue(gitPocketGuideLinkButton.isDisplayed());

    }
    
    
   	
}
