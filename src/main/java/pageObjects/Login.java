package pageObjects;

import enummerables.Enums.LocatorType;
import helperObjects.TestBase;
import utilities.SeleniumDriver;

public class Login extends TestBase{
	
	public Login(SeleniumDriver seleniumDriver) 
    {
    	super(seleniumDriver);
    }
    
	private static String customerDropDownXpath()
    {
    	return "//select[@name=\"userSelect\"]";
    }
    
	private static String loginButtonXpath()
    {
    	return "//button[@class=\"btn btn-default\"]";
    }
    
	public static Login loginCustomer(String customerName) throws Exception
	{
		SeleniumDriver.selectOption(LocatorType.XPATH, customerDropDownXpath(), customerName);
		SeleniumDriver.clickElementByXpath(loginButtonXpath());
		 
		return new Login(seleniumDriver);
	}
    
    
}
