package omf.test;
import org.testng.annotations.*;

import enummerables.Enums.BrowserTypes;
import helperObjects.TestBase;
import helperObjects.TestData;
import pageObjects.HomePage;
import pageObjects.PersonalLoans;

public class VerifyCapitalAndTermValues extends TestBase {
	
	
	@BeforeTest                                          
	public void before_test()  
	{  
// 	  TestBase.setupTest("AddiLabUser");
	}
	  
    @Test
    public void testPayloanCalculation() throws Exception 
    {
    	HomePage homePage = new HomePage(seleniumDriver);
    	  
  		for(BrowserTypes browser: appConfig.getSelectedBrowsers())
  		{
  		  TestBase.prepareSuite("InputFile", browser);
	 	  homePage.navigateToHomePage(appConfig.getSelectedEnvironment().urlUnderTest);
	 	  homePage.clickPersonalLoansViewButton();

	 	  PersonalLoans.verifyCapitalAndTermValues();
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
