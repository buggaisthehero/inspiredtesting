package omf.test;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;


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
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com/users";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/1");

		ResponseBody<?> body = response.getBody();
		
		JSONParser parser = new JSONParser(); 
		JSONObject json = (JSONObject) parser.parse(body.asString()); 
		System.out.print("Here " + json.get("id"));    
		Assert.assertEquals(json.get("id").toString(), "1");
    }

	@SuppressWarnings("static-access")
	@Test
    public void testGetTenUser() throws Exception 
    {
		 RestAssured.baseURI = "https://jsonplaceholder.typicode.com/users";
		 RequestSpecification httpRequest = RestAssured.given();
		 Response response = httpRequest.get("");
		 ResponseBody<?> body = response.getBody();
		 
		 JSONParser parser = new JSONParser(); 
		 JSONArray json = (JSONArray) parser.parse(body.asString()); 
		    
		 Assert.assertTrue(json.size() == 10);
		 
    }
	
	@SuppressWarnings({ "static-access", "unchecked" })
	@Test
    public void testPostNewUser() throws Exception 
    {
		RestAssured.baseURI ="https://jsonplaceholder.typicode.com/users";
		RequestSpecification request = RestAssured.given();

		JSONObject requestParams = new JSONObject();
		requestParams.put("id", "asasasas"); // Cast
		requestParams.put("name", "asasasas");
		requestParams.put("username", "asas344334");
		requestParams.put("email", "password50");
		requestParams.put("address", "{\"street\": \"Kulas Light\",  \"suite\": \"Apt. 556\", \"city\": \"Gwenborough\", \"zipcode\": \"92998-3874\", \"geo\": {\"lat\": \"-37.3159\", \"lng\": \"81.1496\"}");	
		requestParams.put("phone", "34543535654");
		requestParams.put("website", "www.abc.co.za");
		requestParams.put("company", "{\"name\": \"Romaguera-Crona\", \"catchPhrase\": \"Multi-layered client-server neural-net\", \"bs\": \"harness real-time e-markets\"}");
		request.body(requestParams.toJSONString());
		Response response = request.post("");

		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 201);

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
