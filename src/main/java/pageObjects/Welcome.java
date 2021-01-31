package pageObjects;

import enummerables.Enums.LocatorType;
import helperObjects.TestBase;
import utilities.SeleniumDriver;

public class Welcome extends TestBase{

	private Welcome(SeleniumDriver seleniumDriver) 
    {
    	super(seleniumDriver);
    }
	
	private static String accountsDropDownXpath()
	{
		return "//select[@id=\"accountSelect\"]//option";
	}
	private static String transactionButtonXpath()
    {
    	return "//button[@ng-click=\"transactions()\"]";
    }
	private static String depositeButtonXpath()
    {
    	return "//button[@ng-click=\"deposit()\"]";
    }
	private static String withdrawlButtonXpath()
    {
    	return "//button[@ng-click=\"withdrawl()\"]";
    }
   
	private static String amountTextboxXpath()
    {
    	return "//input[@type=\"number\"]";
    }
    
	private static String submitButtonXpath()
    {
    	return "//button[@type=\"submit\"]";
    }
    
	private static String messageStatusXpath()
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
    
    public static String getMessageStatus() throws Exception
    {
    	String text = SeleniumDriver.getTextFromElement(LocatorType.XPATH, messageStatusXpath());
    	return text;
    }
}
