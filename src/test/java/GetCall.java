import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetCall {

	
	@Test
	public void getRequest() {
		
		
		
		RestAssured.baseURI="http://thomas-bayer.com/sqlrest/CUSTOMER"; // base URL
		
		RequestSpecification httpreq = RestAssured.given();
		
		Response response = httpreq.request(Method.GET,"/5");// Filtering data- whatever data you want to look at
		
		String responseBody = response.getBody().asString(); // getting response
		
		System.out.println(responseBody);// printing response
		
		
		int statusCode=response.getStatusCode();
		Assert.assertEquals(statusCode, 200);// validation of status code
		
		String statusLine = response.getStatusLine();
		System.out.println(statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");// validation of status line	
		
	}
	
	
	
}
