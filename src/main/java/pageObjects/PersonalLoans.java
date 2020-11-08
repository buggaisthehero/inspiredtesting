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
	
    public static String FiftyThousanCalculatorButtonCss()
    {
    	return "div[class='btn btn-sq btn-primary actionbut repCalc repCalc50k']> img";
    }
    
    public static String EghtyFourMonthsCalculatorButtonCss()
    {
    	return "div[class='btn btn-sq btn-success calcbuts actionbut grp6 repCalcM repCalc84m']> img";
    }
    
    public static String ViewBreakdownStructureCalculatorLinkCss()
    {
    	return "a[class='font13 marg10 color-grey breakdown']";
    }
    
	public static PersonalLoans verifyCapitalAndTermValues() throws Exception
	{
		
		seleniumDriver.Pause(2000);
		SeleniumDriver.clickElementByCssSelector(FiftyThousanCalculatorButtonCss());
		SeleniumDriver.clickElementByCssSelector(EghtyFourMonthsCalculatorButtonCss());
		SeleniumDriver.clickElementByCssSelector(ViewBreakdownStructureCalculatorLinkCss());

		return new PersonalLoans(seleniumDriver);
	}
	

}
