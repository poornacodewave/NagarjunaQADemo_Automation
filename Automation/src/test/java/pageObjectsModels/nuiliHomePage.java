package pageObjectsModels;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Cucumber.Automation.Base;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.Assert;
import stepDefinations.GenericFunctions;

public class nuiliHomePage extends Base{

	WebDriver driver;
	
	@FindBy(xpath="//a[@class='niuli-navbar-language-switch']")
    WebElement langswitch;
	
	@FindBy(xpath="//a[contains(text(),'Get Your Kitchen')]")
    WebElement getyourkitchen;

	@FindBy(className="niuli-login-btn")
    WebElement loginbtn;
	
	@FindBy(xpath="//div[@class='selected-flag']/div[@class='iti-flag sa']")
    WebElement flagIcon;
	
	@FindBy(xpath="//span[contains(text(),'India')]")
    WebElement indiacountryIcon;

	@FindBy(id="phone")
    WebElement entermobilenumber;
	
	@FindBy(xpath="//p[contains(text(),'GET OTP')]")
    WebElement getotpbtn;
	
	@FindBy(xpath="(//input[contains(@class,'otp_fld_niu')])[1]")
    WebElement enterotpfield;
	
	@FindBy(xpath="//p[@class='otp_nbtnappverify']")
    WebElement verifybtn;
	
	@FindBy(xpath="//a[contains(text(),'My Orders')]")
    WebElement myorders;
	
	@FindBy(xpath="//img[contains(@src,'Started')]")
    WebElement getstarted;

	@FindBy(xpath="//div[@class='lets-begin']")
    WebElement letsbegin;
	
	@FindBy(xpath="//div[@class='ant-slider-handle']")
    WebElement antsliderhandle;
	
	@FindBy(xpath="//div[contains(text(),'U-shaped Kitchen')]/parent::div/div[1]")
    WebElement ushapedkitchen;
	
	@FindBy(className="continue-button")
    WebElement continuebtn;
	
	@FindBy(xpath="//h3[contains(text(),'Neat')]/..")
    WebElement neat;
	
	@FindBy(xpath="//input[@value='New Site']/..")
    WebElement newsite;
	
	@FindBy(className="ant-select-selection-search-input")
    WebElement chooseyourdropdown;
	
	
	@FindBy(xpath="//div[contains(text(),'ROUGHLY, BY WHEN DO YOU NEED THE JOB DONE?')]/following-sibling::div//div[@class='ant-slider-handle']")
    WebElement roughlyjobdoneslider;
	
	
	@FindBy(xpath="//div[contains(@class,'react-datepicker__day--today')]/following-sibling::div[1]")
    WebElement tomorrowday;
	
	@FindBy(xpath="//div[text()='Thank you for your booking!']")
    WebElement Thankyouforyourbookingtext;
	
	@FindBy(xpath="//div[text()='OK, GOT IT!']")
    WebElement okgotitbtn;
	
	
    public nuiliHomePage(WebDriver driver){

        this.driver = driver;

        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);

    }
    
    
    public void clicklangswitch(){

    	langswitch.click();

    } 
    
    public void clickloginbtn(){

    	loginbtn.click();

    }
    
    public boolean VerifygetyourkitchenExists()
    {
       boolean temp = false;
    	if(getyourkitchen.isDisplayed())
    	{
    		temp = true;	
    	}

    	return temp;
    } 
    
    public boolean BookAnDemo()
    {
       boolean temp = false;
   	try 
   	{
   		getstarted.click();
		letsbegin.click();
		_functions.draganddrop(antsliderhandle,50);
		_functions.maximumWait();
		ushapedkitchen.click();
		continuebtn.click();
		
		neat.click();
		
		continuebtn.click();

		newsite.click();
		
		selectdropdownvalue("Economical");
		_functions.draganddrop(roughlyjobdoneslider, 50);
		
		continuebtn.click();
		
		SelectTomorrowDayandTime(1,10);

		continuebtn.click();
		
		continuebtn.click();
	
		Thankyouforyourbookingtext.isDisplayed();
		
		okgotitbtn.click();
		
   	 temp = true;
		Assert.fail();
	    
	} 
	catch (Exception e) {
		e.printStackTrace();
	}

	return temp;
 
 }
    
    public boolean SelectTomorrowDayandTime(int days,int time)
    {
       boolean temp = false;
   	try 
   	{
   		System.out.println("method SelectTomorrowDayandTime");
   		DateFormat dateFormat = new SimpleDateFormat("dd");
	    Calendar c = Calendar.getInstance();
	    //c.add(Calendar.DATE, 1);
	    c.add(Calendar.DATE, days);
	    System.out.println(dateFormat.format(c.getTime()));
	    
	    driver.findElement(By.xpath("//div[@aria-disabled='false' and text()='"+dateFormat.format(c.getTime())+"']")).click();
	    
	    //driver.findElement(By.xpath("//button[text()='"+time+":00 AM']")).click();
	    driver.findElement(By.xpath("//button[contains(text(),'"+time+":00 AM')]")).click();
	  
   	 	temp = true;
		//Assert.fail();
	    
	} 
	catch (Exception e) {
		e.printStackTrace();
	}

	return temp;
 
 }

    
    


    
    public boolean LoginToNuili()
    {
	    boolean temp = false;
    	try 
    	{
    		loginbtn.click();
    		
    		_functions.minimumWait();
    		
    		flagIcon.click();
    		
    		indiacountryIcon.click();
    		
    		
    		entermobilenumber.sendKeys(prop.getProperty("phoneno"));
    		
    		getotpbtn.click();
    		
    		enterotpfield.sendKeys(prop.getProperty("otp"));
    		
    		verifybtn.click();
    		_functions.maximumWait();

    		myorders.isDisplayed();
    		    		
    		temp = true;
    		//Assert.fail();
    	    
		} 
    	catch (Exception e) {
			e.printStackTrace();
		}

    	return temp;
    } 
    
    public boolean selectdropdownvalue(String dropdownvalue)
	{
    	boolean temp = false;
		try
		{
			chooseyourdropdown.click();	
			_functions.maximumWait();
		    //driver.findElement(By.xpath("//*[text()='Moderate']/ancestor::div[@class='ant-select-item-option-content']")).click();
			driver.findElement(By.xpath("//*[text()='"+dropdownvalue+"']/ancestor::div[@class='ant-select-item-option-content']")).click();
    		
			temp = true;	    
		} 
		
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return temp;	
	}
    
  
    
    
	

    /*@FindBy(name="uid")

    WebElement user99GuruName;

    @FindBy(name="password")

    WebElement password99Guru;    

    @FindBy(className="barone")

    WebElement titleText;

    @FindBy(name="btnLogin")

    WebElement login;

    public nuiliHomePage(WebDriver driver){

        this.driver = driver;

        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);

    }

    //Set user name in textbox

    public void setUserName(String strUserName){

        user99GuruName.sendKeys(strUserName);     
    }

    //Set password in password textbox

    public void setPassword(String strPassword){

    password99Guru.sendKeys(strPassword);

    }

    //Click on login button

    public void clickLogin(){

            login.click();

    }  

    //Get the title of Login Page

    public String getLoginTitle(){

     return    titleText.getText();

    }


    public void loginToGuru99(String strUserName,String strPasword){

        //Fill user name

        this.setUserName(strUserName);

        //Fill password

        this.setPassword(strPasword);

        //Click Login button

        this.clickLogin();           

    }*/
	
	
	
}
