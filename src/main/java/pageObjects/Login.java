package pageObjects;

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
		SeleniumDriver.clickElementByXpath(customerListXpath());
		SeleniumDriver.clickElementByXpath(loginButtonXpath());
		 
		return new Login(seleniumDriver);
	}
    
    
}
