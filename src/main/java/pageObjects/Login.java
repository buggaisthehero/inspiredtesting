package pageObjects;

import enummerables.Enums.LocatorType;
import helperObjects.TestBase;
import utilities.SeleniumDriver;

public class Login extends TestBase{
	
    public Login(SeleniumDriver seleniumDriver) 
    {
    	super(seleniumDriver);
    }
    
    public static String customerListXpath()
    {
    	return "//select[@name=\"userSelect\"]";
    }
    
    public static String loginButtonXpath()
    {
    	return "//button[@class=\"btn btn-default\"]";
    }
    
	public static Login loginCustomer() throws Exception
	{
		SeleniumDriver.selectOption(LocatorType.XPATH, customerListXpath(), "Harry Potter");
		SeleniumDriver.clickElementByXpath(loginButtonXpath());
		 
		return new Login(seleniumDriver);
	}
    
    
}
