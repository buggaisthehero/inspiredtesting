package pageObjects;

import org.openqa.selenium.ElementNotVisibleException;

import enummerables.Enums.LocatorType;
import helperObjects.TestBase;
import helperObjects.TestData;
import utilities.SeleniumDriver;

public class PersonalLoans extends TestBase {
	
    public PersonalLoans(SeleniumDriver seleniumDriver) 
    {
    	super(seleniumDriver);
    }
	
    public static String FiftyThousanCalculatorButtonXpath()
    {
    	return "//*[@id='calcAmountHold']/div/div[5]/img";
    }
    
    public static String EghtyFourMonthsCalculatorButtonXpath()
    {
    	return "//*[@id='calcTermHold']/div/div[9]/img[3]";
    }
    
    public static String ViewBreakdownStructureCalculatorLinkXpath()
    {
    	return "//*[@id='calcTotalsHold']/p[2]/a";
    }
    
    public static String payminXpath()
    {
    	return "//*[@id='paymin']";
    }
    
    public static String paymanXpath()
    {
    	return "//*[@id='paymax']";
    }
    
    public static String getMinLoanPayment() throws ElementNotVisibleException, Exception
    {
    	String text = seleniumDriver.returnTextFromElement(LocatorType.XPATH, payminXpath());
    	return text;
    }
    
    public static String getMaxLoanPayment() throws ElementNotVisibleException, Exception
    {
    	String text = seleniumDriver.returnTextFromElement(LocatorType.XPATH, paymanXpath());
    	return text;
    }
    
	public static PersonalLoans verifyCapitalAndTermValues() throws Exception
	{
		seleniumDriver.Pause(2000);
		SeleniumDriver.clickElementByXpath(FiftyThousanCalculatorButtonXpath());
		seleniumDriver.Pause(2000);
		SeleniumDriver.clickElementByXpath(EghtyFourMonthsCalculatorButtonXpath());
		seleniumDriver.Pause(2000);
		SeleniumDriver.clickElementByXpath(ViewBreakdownStructureCalculatorLinkXpath());
		seleniumDriver.Pause(2000);
		
		
		return new PersonalLoans(seleniumDriver);
	}
	

}
