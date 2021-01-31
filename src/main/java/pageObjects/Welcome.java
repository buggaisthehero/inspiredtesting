package pageObjects;

import org.openqa.selenium.ElementNotVisibleException;

import enummerables.Enums.LocatorType;
import helperObjects.TestBase;
import utilities.SeleniumDriver;

public class Welcome extends TestBase{

	public Welcome(SeleniumDriver seleniumDriver) 
    {
    	super(seleniumDriver);
    }
	
	private static String accountsDropDownXpath()
	{
		return "//select[@id=\"accountSelect\"]//option";
	}
	
	private static String accountBalanceXpath()
    {
    	return "//div[@ng-hide=\"noAccount\"][1]//strong[2]";
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
	

	public static int getDropDownSize() throws ElementNotVisibleException, Exception
	{
		int length = SeleniumDriver.getDropDownSize(LocatorType.XPATH, accountsDropDownXpath());
		
		return length;
	}
    
    public static Welcome deposit(String amount, String accountNum) throws Exception
	{
    	SeleniumDriver.clickElementByXpath(accountsDropDownXpath() + "//["+ accountNum +"]");
    	SeleniumDriver.clickElementByXpath(depositeButtonXpath());
		SeleniumDriver.enterText(LocatorType.XPATH, amountTextboxXpath(), amount);
		SeleniumDriver.clickElementByXpath(submitButtonXpath());
		 
		return new Welcome(seleniumDriver);
	}
    
    public static Welcome withdrawl(String amount, String accountNum) throws Exception
	{
    	SeleniumDriver.clickElementByXpath(accountsDropDownXpath() + "//["+ accountNum +"]");
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
    
    public static String getAccountBalance() throws Exception
    {
    	String text = SeleniumDriver.getTextFromElement(LocatorType.XPATH, accountBalanceXpath());
    	return text;
    }
    
    public static Welcome viewTransactions() throws Exception
	{
		SeleniumDriver.clickElementByXpath(transactionButtonXpath());
		return new Welcome(seleniumDriver);
	}
}
