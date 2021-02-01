package omf.test;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import helperObjects.TestBase;

import static io.restassured.RestAssured.delete;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.hamcrest.Matchers;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class API {
	
	public API() {
		
	}
	
	@BeforeClass
	public void before_class()  
	{  
		
	}
	
	@SuppressWarnings("static-access")
	@Test
    public void testGetSingleUser() throws Exception 
    {
	    HttpUriRequest request = new HttpGet( "https://jsonplaceholder.typicode.com/users/1");
	    HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
	    Assert.assertEquals(httpResponse.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
	}

	@SuppressWarnings("static-access")
	@Test
    public void testGetTenUser() throws Exception 
    {
		 HttpUriRequest request = new HttpGet( "https://jsonplaceholder.typicode.com/users");
		 HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
		 Assert.assertEquals(httpResponse.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
    }
	
	@SuppressWarnings("static-access")
	@Test(enabled=false)
    public void testPostNewUser() throws Exception 
    {
		
    }
	public void post() 
	{
		
	}
	public void get(String numberOfUsers) 
	{
		
	}

	@AfterTest
	public void after_test()  
	{ 
	
	}
   
   @AfterClass
   public void after_class()
   {
   
   }
}
