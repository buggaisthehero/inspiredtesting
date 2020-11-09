package pageObjects;

import java.util.concurrent.TimeoutException;

import helperObjects.TestBase;
import utilities.SeleniumDriver;

public class HomePage extends TestBase {
	
    public HomePage(SeleniumDriver seleniumDriver) 
    {
    	super(seleniumDriver);
    }
    
    public static String personalLoansVewButtonXpath()
    {
    	return "//a[text()='Personal Loans']";
    }
    
    public static String getLandingPageTitle()
    {
    	return SeleniumDriver.getPageTitle();
    }
    
	public HomePage navigateToHomePage(String url) throws Exception
	{
		seleniumDriver.navigateToPage(url);
		
		return new HomePage(seleniumDriver);
	}
    
    public boolean clickPersonalLoansViewButton() throws Exception
    {
    	return SeleniumDriver.clickElementByXpath(personalLoansVewButtonXpath());
    }

}
