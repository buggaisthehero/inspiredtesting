package omf.test;
import org.testng.annotations.*;

import java.io.FileReader;
import java.sql.Timestamp;
import enummerables.Enums.BrowserTypes;
import helperObjects.Logging;
import helperObjects.TestBase;
import pageObjects.HomePage;
import pageObjects.Login;
import pageObjects.Transactions;
import pageObjects.Welcome;
import utilities.Screenshot;
import utilities.SeleniumDriver;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import org.testng.Assert;

public class CustomerActions extends TestBase {
	
	HomePage homePage = new HomePage(seleniumDriver);
	Login login = new Login(seleniumDriver);
	Welcome welcome = new Welcome(seleniumDriver);
	Transactions transactions = new Transactions(seleniumDriver);
	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	Screenshot screenshot = new Screenshot();
	    
	@BeforeClass
	public void before_class()  
	{  
		Logging logging = new Logging();
	}
	
	@BeforeTest                                          
	public void before_test()  
	{  
 	    TestBase.setupTest();
	}
	  
    @SuppressWarnings("static-access")
	@Test
    public void testDepositFirstAccount() throws Exception 
    {
    	
    	String homePageTitle = "Protractor practice website - Banking App";
    	  
  		for(BrowserTypes browser: appConfig.getSelectedBrowsers())
  		{
  		  TestBase.prepareSuite("InputFile", browser);
	 	  homePage.navigateToHomePage(appConfig.getSelectedEnvironment().urlUnderTest);
	 	  
	 	  String originalTitle = SeleniumDriver.getPageTitle();
          Assert.assertEquals(originalTitle, homePageTitle);
          screenshot.takeSnapShot(SeleniumDriver.GetWebDriver(), "screenshots//Home_"+timestamp.getTime()+"_.png"); 
         
	 	  homePage.clickCustomerLoginButton();
	 	  login.loginCustomer("Hermoine Granger");
	 	  welcome.deposit("1500", "1");
	 	  String message = welcome.getMessageStatus();
	 	  screenshot.takeSnapShot(SeleniumDriver.GetWebDriver(), "screenshots//deposit_"+timestamp.getTime()+"_.png");
	 	  Assert.assertEquals(message, "Deposit Successful");
	 	  
	 	  testResult.setStatus(true);
	 	 	
  		}
    }
    
    @SuppressWarnings("static-access")
	@Test(enabled=false)
    public void testDepositAllAcounts() throws Exception 
    {
    	String homePageTitle = "Protractor practice website - Banking App";
    	  
  		for(BrowserTypes browser: appConfig.getSelectedBrowsers())
  		{
  		  TestBase.prepareSuite("InputFile", browser);
	 	  homePage.navigateToHomePage(appConfig.getSelectedEnvironment().urlUnderTest);
	 	  
	 	  String originalTitle = SeleniumDriver.getPageTitle();
          Assert.assertEquals(originalTitle, homePageTitle);
          screenshot.takeSnapShot(SeleniumDriver.GetWebDriver(), "screenshots//Home_"+timestamp.getTime()+"_.png"); 
         
	 	  homePage.clickCustomerLoginButton();
	 	  login.loginCustomer("Hermoine Granger");
	 	  int listCount = welcome.getDropDownSize();
	 	  
	 	  for(int x=1; x <= listCount; x++)
	 	  {
		 	  welcome.deposit("1500", String.valueOf(x));
		 	  String message = welcome.getMessageStatus();
		 	  screenshot.takeSnapShot(SeleniumDriver.GetWebDriver(), "screenshots//deposit_"+timestamp.getTime()+"_.png"); 
		 	  Assert.assertEquals(message, "Deposit Successful");
	 	  }
	 	  testResult.setStatus(true);
	 	 	
  		}
    }
    
    @SuppressWarnings("static-access")
    @Test(enabled=false)
    public void testDepositAndWithdrawl() throws Exception 
    {
    	String homePageTitle = "Protractor practice website - Banking App";
    	  
  		for(BrowserTypes browser: appConfig.getSelectedBrowsers())
  		{
  		  TestBase.prepareSuite("InputFile", browser);
	 	  homePage.navigateToHomePage(appConfig.getSelectedEnvironment().urlUnderTest);
	 	  
	 	  String originalTitle = SeleniumDriver.getPageTitle();
          Assert.assertEquals(originalTitle, homePageTitle);
          screenshot.takeSnapShot(SeleniumDriver.GetWebDriver(), "screenshots//Home_"+timestamp.getTime()+"_.png"); 
         
	 	  homePage.clickCustomerLoginButton();
	 	  login.loginCustomer("Hermoine Granger");
	 	  String oldAccBalanceStr = welcome.getAccountBalance();
	 	  int accBalanceInt = Integer.parseInt(oldAccBalanceStr);
	 	  welcome.deposit("31459", "1");
	 	  String message = welcome.getMessageStatus();
	 	  screenshot.takeSnapShot(SeleniumDriver.GetWebDriver(), "screenshots//deposit_"+timestamp.getTime()+"_.png");
	 	  Assert.assertEquals(message, "Deposit Successful");
	 	  int newAccBalance = accBalanceInt + 31459;
	 	 
	 	  welcome.viewTransactions();
	 	  transactions.sortByDate();
	 	  String date = transactions.getDateTime();
	 	  String amount = transactions.getAmount();
	 	  String transactionType = transactions.getTransactionType();
	 	 
	 	  Assert.assertEquals(31459, Integer.parseInt(amount));
	 	  Assert.assertEquals(transactionType, "Credit");
	 	 
	 	  transactions.goBack();
	 	  oldAccBalanceStr = welcome.getAccountBalance();
	 	  accBalanceInt = Integer.parseInt(oldAccBalanceStr);
	 	  welcome.withdrawl("31459", "1");
	 	  message = welcome.getMessageStatus();
	 	  screenshot.takeSnapShot(SeleniumDriver.GetWebDriver(), "screenshots//deposit_"+timestamp.getTime()+"_.png");
	 	  Assert.assertEquals(message, "Transaction successful");
	 	  welcome.viewTransactions();
	 	  transactions.sortByDate();
	 	  date = transactions.getDateTime();
	 	  amount = transactions.getAmount();
	 	  transactionType = transactions.getTransactionType();
	 	  newAccBalance = newAccBalance - 31459;
	 	  Assert.assertEquals(31459, Integer.parseInt(amount));
	 	  Assert.assertEquals(transactionType, "Debit");
	 	  testResult.setStatus(true);
	 	 	
  		}
    }
    
    @SuppressWarnings("static-access")
    @Test(enabled=false)
    public void testDepositAndWithdrawlJSON() throws Exception 
    {
        try
        {
        	JSONParser jsonParser = new JSONParser();
        	Object obj = jsonParser.parse(new FileReader("./Inputfile/data.json"));
			JSONObject jsonObject = (JSONObject) obj;
 
			String customer = (String) jsonObject.get("customer");
			String account = (String) jsonObject.get("account");
			String amt = (String) jsonObject.get("amount");
 
			String homePageTitle = "Protractor practice website - Banking App";
	    	  
	  		for(BrowserTypes browser: appConfig.getSelectedBrowsers())
	  		{
		  		  TestBase.prepareSuite("InputFile", browser);
			 	  homePage.navigateToHomePage(appConfig.getSelectedEnvironment().urlUnderTest);
			 	  
			 	  String originalTitle = SeleniumDriver.getPageTitle();
		          Assert.assertEquals(originalTitle, homePageTitle);
		          screenshot.takeSnapShot(SeleniumDriver.GetWebDriver(), "screenshots//Home_"+timestamp.getTime()+"_.png"); 
		         
			 	  homePage.clickCustomerLoginButton();
			 	  login.loginCustomer(customer);
			 	  String oldAccBalanceStr = welcome.getAccountBalance();
			 	  int accBalanceInt = Integer.parseInt(oldAccBalanceStr);
			 	  welcome.deposit(amt, account);
			 	  String message = welcome.getMessageStatus();
			 	  screenshot.takeSnapShot(SeleniumDriver.GetWebDriver(), "screenshots//deposit_"+timestamp.getTime()+"_.png");
			 	  Assert.assertEquals(message, "Deposit Successful");
			 	  int newAccBalance = accBalanceInt + 31459;
			 	 
			 	  welcome.viewTransactions();
			 	  transactions.sortByDate();
			 	  String amount = transactions.getAmount();
			 	  String transactionType = transactions.getTransactionType();
			 	 
			 	  Assert.assertEquals(31459, Integer.parseInt(amount));
			 	  Assert.assertEquals(transactionType, "Credit");
			 	 
			 	  transactions.goBack();
			 	  oldAccBalanceStr = welcome.getAccountBalance();
			 	  accBalanceInt = Integer.parseInt(oldAccBalanceStr);
			 	  welcome.withdrawl(amt, account);
			 	  message = welcome.getMessageStatus();
			 	  screenshot.takeSnapShot(SeleniumDriver.GetWebDriver(), "screenshots//deposit_"+timestamp.getTime()+"_.png");
			 	  Assert.assertEquals(message, "Transaction successful");
			 	  welcome.viewTransactions();
			 	  transactions.sortByDate();
			 	  amount = transactions.getAmount();
			 	  transactionType = transactions.getTransactionType();
			 	  newAccBalance = newAccBalance - 31459;
			 	  Assert.assertEquals(31459, Integer.parseInt(amount));
			 	  Assert.assertEquals(transactionType, "Debit");
			 	  testResult.setStatus(true);
	  		}
		 	
 
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @AfterTest
	  public void after_test()  
	  { 
 		TestBase.endTest();
 		TestBase.closeBrowser();
	  }
    
    @AfterClass
    public void after_class()
    {
    	TestBase.closeBrowser();
    }
    

}
