package omf.test;
import org.testng.annotations.*;

import enummerables.Enums.BrowserTypes;
import helperObjects.Logging;
import helperObjects.TestBase;
import helperObjects.TestData;
import pageObjects.HomePage;
import pageObjects.PersonalLoans;
import utilities.Screenshot;
import utilities.SeleniumDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class VerifyCapitalAndTermValues extends TestBase {
	
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
	  
    @Test
    public void testPayloanCalculation() throws Exception 
    {
    	HomePage homePage = new HomePage(seleniumDriver);
    	Screenshot screenshot = new Screenshot();
    	
    	String homePageTitle = "Personal Loans | Online Loans | Money Account | Old Mutual";
    	  
  		for(BrowserTypes browser: appConfig.getSelectedBrowsers())
  		{
  		  TestBase.prepareSuite("InputFile", browser);
	 	  homePage.navigateToHomePage(appConfig.getSelectedEnvironment().urlUnderTest);
	 	  
	 	  String originalTitle = SeleniumDriver.getPageTitle();
          Assert.assertEquals(originalTitle, homePageTitle);
          screenshot.takeSnapShot(SeleniumDriver.GetWebDriver(), "screenshots//Home.png"); 
         
	 	  homePage.clickPersonalLoansViewButton();
	 	  PersonalLoans.verifyCapitalAndTermValues();
	 	  Assert.assertEquals(PersonalLoans.getMinLoanPayment(), "R1,521.05");
//	 	  Assert.assertEquals(PersonalLoans.getMaxLoanPayment(), "R1,600.42");
//	 	  screenshot.takeSnapShot(SeleniumDriver.GetWebDriver(), "screenshots//PersonalLoans.png"); 
	 	  
	 	  testResult.setStatus(true);
	 	 	
  		}
    }
    
    @AfterTest
	  public void after_test()  
	  { 
 		TestBase.endTest();
 		TestBase.closeBrowser();
	  }
    

}
