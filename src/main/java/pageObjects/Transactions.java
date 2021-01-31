package pageObjects;


import org.openqa.selenium.ElementNotVisibleException;

import enummerables.Enums.LocatorType;
import helperObjects.TestBase;
import utilities.SeleniumDriver;

public class Transactions extends TestBase {

	public Transactions(SeleniumDriver seleniumDriver) 
    {
    	super(seleniumDriver);
    }
	
	private static String dateTimeFilterLinkXpath()
    {
    	return "//a[@ng-click=\"sortType = 'date'; sortReverse = !sortReverse\"]";
    }
	
	private static String backButtonXpath()
    {
    	return "//button[@ng-click=\"back()\"]";
    }
	
	private static String row1DateTimeXpath()
    {
    	return "//tr[@id=\"anchor0\"]/td[1]";
    }
	private static String row1AmountXpath()
    {
    	return "//tr[@id=\"anchor0\"]/td[2]";
    }
	private static String row1TransactionTypeXpath()
    {
    	return "//tr[@id=\"anchor0\"]/td[3]";
    }
	
	public static Transactions sortByDate() throws ElementNotVisibleException, Exception
	{
		SeleniumDriver.clickElementByXpath(dateTimeFilterLinkXpath());
		SeleniumDriver.Pause(2000);
		
		return new Transactions(seleniumDriver);
	}
	
	public static String getDateTime() throws Exception
    {
    	String text = SeleniumDriver.getTextFromElement(LocatorType.XPATH, row1DateTimeXpath());
    	return text;
    }
	
	public static String getAmount() throws Exception
    {
    	String text = SeleniumDriver.getTextFromElement(LocatorType.XPATH, row1AmountXpath());
    	return text;
    }
	
	public static String getTransactionType() throws Exception
    {
    	String text = SeleniumDriver.getTextFromElement(LocatorType.XPATH, row1TransactionTypeXpath());
    	return text;
    }
	
	public static Transactions goBack() throws Exception
	{
		SeleniumDriver.clickElementByXpath(backButtonXpath());
		return new Transactions(seleniumDriver);
	}
}
