package pageObjects;

import helperObjects.TestBase;
import utilities.SeleniumDriver;

public class HomePage extends TestBase {
	
    public HomePage(SeleniumDriver seleniumDriver) 
    {
    	super(seleniumDriver);
    }
    
    public static String customerLoginButtonXpath()
    {
    	return "//button[text()=\"Customer Login\"]";
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
    
    public boolean clickCustomerLoginButton() throws Exception
    {
    	return SeleniumDriver.clickElementByXpath(customerLoginButtonXpath());
    }

}
