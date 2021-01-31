package omf.test;
import org.testng.annotations.*;

import enummerables.Enums.BrowserTypes;
import helperObjects.Logging;
import helperObjects.TestBase;
import helperObjects.TestData;
import pageObjects.HomePage;
import pageObjects.Login;
import pageObjects.Welcome;
import utilities.Screenshot;
import utilities.SeleniumDriver;

import org.testng.Assert;

public class CustomerActions extends TestBase {
	
	@BeforeClass
	public void before_class()  
	{  
		Logging logging = new Logging();
	}
	
	@BeforeTest                                          
	public void before_test()  
	{  
 	  TestBase.setupTest();
	}
	  
    @SuppressWarnings("static-access")
	@Test
    public void testDeposit() throws Exception 
    {
    	HomePage homePage = new HomePage(seleniumDriver);
    	Login login = new Login(seleniumDriver);
    	Welcome welcome = new Welcome(seleniumDriver);
    	
    	Screenshot screenshot = new Screenshot();
    	
    	String homePageTitle = "Protractor practice website - Banking App";
    	  
  		for(BrowserTypes browser: appConfig.getSelectedBrowsers())
  		{
  		  TestBase.prepareSuite("InputFile", browser);
	 	  homePage.navigateToHomePage(appConfig.getSelectedEnvironment().urlUnderTest);
	 	  
	 	  String originalTitle = SeleniumDriver.getPageTitle();
          Assert.assertEquals(originalTitle, homePageTitle);
          screenshot.takeSnapShot(SeleniumDriver.GetWebDriver(), "screenshots//Home.png"); 
         
	 	  homePage.clickCustomerLoginButton();
	 	  login.loginCustomer();
	 	  welcome.deposit("1500");
	 	  String message = welcome.getMessageStatus();
	 	  screenshot.takeSnapShot(SeleniumDriver.GetWebDriver(), "screenshots//deposit.png");
	 	  Assert.assertEquals(message, "Deposit Successful");
	 	  
	 	  testResult.setStatus(true);
	 	 	
  		}
    }
    
    @SuppressWarnings("static-access")
	@Test
    public void testWithdrawal() throws Exception 
    {
    	HomePage homePage = new HomePage(seleniumDriver);
    	Login login = new Login(seleniumDriver);
    	Welcome welcome = new Welcome(seleniumDriver);
    	
    	Screenshot screenshot = new Screenshot();
    	
    	String homePageTitle = "Protractor practice website - Banking App";
    	  
  		for(BrowserTypes browser: appConfig.getSelectedBrowsers())
  		{
  		  TestBase.prepareSuite("InputFile", browser);
	 	  homePage.navigateToHomePage(appConfig.getSelectedEnvironment().urlUnderTest);
	 	  
	 	  String originalTitle = SeleniumDriver.getPageTitle();
          Assert.assertEquals(originalTitle, homePageTitle);
          screenshot.takeSnapShot(SeleniumDriver.GetWebDriver(), "screenshots//Home.png"); 
         
	 	  homePage.clickCustomerLoginButton();
	 	  login.loginCustomer();
	 	  welcome.withdrawl("1500");
	 	  String message = welcome.getMessageStatus();
	 	  screenshot.takeSnapShot(SeleniumDriver.GetWebDriver(), "screenshots//withdrawl.png"); 
	 	  Assert.assertEquals(message, "Withdrawl successful");
	 	  testResult.setStatus(true);
	 	 	
  		}
    }

    @AfterTest
	  public void after_test()  
	  { 
 		TestBase.endTest();
 		
	  }
    
    @AfterClass
    public void after_class()
    {
    	TestBase.closeBrowser();
    }
    

}
