package pageObjects;

import enummerables.Enums.LocatorType;
import helperObjects.TestBase;
import utilities.SeleniumDriver;

public class Welcome extends TestBase{

	public Welcome(SeleniumDriver seleniumDriver) 
    {
    	super(seleniumDriver);
    }
	
    public static String transactionButtonXpath()
    {
    	return "//button[@ng-click=\"transactions()\"]";
    }
    public static String depositeButtonXpath()
    {
    	return "//button[@ng-click=\"deposit()\"]";
    }
    public static String withdrawlButtonXpath()
    {
    	return "//button[@ng-click=\"withdrawl()\"]";
    }
    
    public static String amountTextboxXpath()
    {
    	return "//input[@type=\"number\"]";
    }
    
    public static String submitButtonXpath()
    {
    	return "//button[@type=\"submit\"]";
    }
    
    public static String messageStatusXpath()
    {
    	return "//span[@class=\"error ng-binding\"]";
    }
  
    
    public static Welcome deposit(String amount) throws Exception
	{
    	SeleniumDriver.clickElementByXpath(depositeButtonXpath());
		SeleniumDriver.enterText(LocatorType.XPATH, amountTextboxXpath(), amount);
		SeleniumDriver.clickElementByXpath(submitButtonXpath());
		 
		return new Welcome(seleniumDriver);
	}
    
    public static Welcome withdrawl(String amount) throws Exception
	{
    	SeleniumDriver.clickElementByXpath(withdrawlButtonXpath());
		SeleniumDriver.enterText(LocatorType.XPATH, amountTextboxXpath(), amount);
		SeleniumDriver.clickElementByXpath(submitButtonXpath());
		 
		return new Welcome(seleniumDriver);
	}
    
//    public static Welcome getStatus() throws Exception
//    {
//    	
//    }
}
