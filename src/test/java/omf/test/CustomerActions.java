package omf.test;
import org.testng.annotations.*;
import java.sql.Timestamp;
import enummerables.Enums.BrowserTypes;
import helperObjects.Logging;
import helperObjects.TestBase;
import pageObjects.HomePage;
import pageObjects.Login;
import pageObjects.Welcome;
import utilities.Screenshot;
import utilities.SeleniumDriver;

import org.testng.Assert;

public class CustomerActions extends TestBase {
	
	HomePage homePage = new HomePage(seleniumDriver);
	Login login = new Login(seleniumDriver);
	Welcome welcome = new Welcome(seleniumDriver);
	Timestamp timestamp = new Timestamp(System.currentTimeMillis());

	    
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
    public void testDepositFirstAccount() throws Exception 
    {

    	
    	Screenshot screenshot = new Screenshot();
    	
    	String homePageTitle = "Protractor practice website - Banking App";
    	  
  		for(BrowserTypes browser: appConfig.getSelectedBrowsers())
  		{
  		  TestBase.prepareSuite("InputFile", browser);
	 	  homePage.navigateToHomePage(appConfig.getSelectedEnvironment().urlUnderTest);
	 	  
	 	  String originalTitle = SeleniumDriver.getPageTitle();
          Assert.assertEquals(originalTitle, homePageTitle);
          screenshot.takeSnapShot(SeleniumDriver.GetWebDriver(), "screenshots//Home"+timestamp.getTime()+".png"); 
         
	 	  homePage.clickCustomerLoginButton();
	 	  login.loginCustomer();
	 	  welcome.deposit("1500", "1");
	 	  String message = welcome.getMessageStatus();
	 	  screenshot.takeSnapShot(SeleniumDriver.GetWebDriver(), "screenshots//deposit_"+timestamp.getTime()+"_.png");
	 	  Assert.assertEquals(message, "Deposit Successful");
	 	  
	 	  testResult.setStatus(true);
	 	 	
  		}
    }
    
    @SuppressWarnings("static-access")
	@Test
    public void testDepositAllAcounts() throws Exception 
    {
    	Screenshot screenshot = new Screenshot();
    	
    	String homePageTitle = "Protractor practice website - Banking App";
    	  
  		for(BrowserTypes browser: appConfig.getSelectedBrowsers())
  		{
  		  TestBase.prepareSuite("InputFile", browser);
	 	  homePage.navigateToHomePage(appConfig.getSelectedEnvironment().urlUnderTest);
	 	  
	 	  String originalTitle = SeleniumDriver.getPageTitle();
          Assert.assertEquals(originalTitle, homePageTitle);
          screenshot.takeSnapShot(SeleniumDriver.GetWebDriver(), "screenshots//Home_"+timestamp.getTime()+"_.png"); 
         
	 	  homePage.clickCustomerLoginButton();
	 	  login.loginCustomer();
	 	  int listCount = welcome.getDropDownSize();
	 	  
	 	  for(int x=1; x <= listCount; x++)
	 	  {
		 	  welcome.deposit("1500", String.valueOf(x));
		 	  String message = welcome.getMessageStatus();
		 	  screenshot.takeSnapShot(SeleniumDriver.GetWebDriver(), "screenshots//deposit_"+timestamp.getTime()+"_.png"); 
		 	  Assert.assertEquals(message, "Deposit Successful");
	 	  }
	 	  testResult.setStatus(true);
	 	 	
  		}
    }
    
    @SuppressWarnings("static-access")
	@Test
    public void testDepositAndWithdrawl() throws Exception 
    {
    	Screenshot screenshot = new Screenshot();
    	
    	String homePageTitle = "Protractor practice website - Banking App";
    	  
  		for(BrowserTypes browser: appConfig.getSelectedBrowsers())
  		{
  		  TestBase.prepareSuite("InputFile", browser);
	 	  homePage.navigateToHomePage(appConfig.getSelectedEnvironment().urlUnderTest);
	 	  
	 	  String originalTitle = SeleniumDriver.getPageTitle();
          Assert.assertEquals(originalTitle, homePageTitle);
          screenshot.takeSnapShot(SeleniumDriver.GetWebDriver(), "screenshots//Home_"+timestamp.getTime()+"_.png"); 
         
	 	  homePage.clickCustomerLoginButton();
	 	  login.loginCustomer();
	 	  String accBalanceStr = welcome.getAccountBalance();
	 	  int accBalanceInt = Integer.parseInt(accBalanceStr);
	 	  welcome.deposit("31459", "1");
	 	  String message = welcome.getMessageStatus();
	 	  screenshot.takeSnapShot(SeleniumDriver.GetWebDriver(), "screenshots//deposit_"+timestamp.getTime()+"_.png");
	 	  Assert.assertEquals(message, "Deposit Successful");
	 	  
	 	  int newAccBalance = accBalanceInt + 31459;
	 	  
	 	  
	 	  
	 	  
	 	  
	 	  
	 	  
	 	  testResult.setStatus(true);
	 	 	
  		}
    }
    
    @AfterTest
	  public void after_test()  
	  { 
 		TestBase.endTest();
 		TestBase.closeBrowser();
	  }
    
    @AfterClass
    public void after_class()
    {
    	TestBase.closeBrowser();
    }
    

}
